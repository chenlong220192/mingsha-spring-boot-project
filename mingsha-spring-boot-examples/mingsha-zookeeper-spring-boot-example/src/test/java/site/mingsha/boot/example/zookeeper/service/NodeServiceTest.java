package site.mingsha.boot.example.zookeeper.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 节点服务测试 - 单元测试
 * 注意：NodeService 使用内存数据存储，无需 mock 外部依赖
 */
@ExtendWith(MockitoExtension.class)
class NodeServiceTest {

    @InjectMocks
    private NodeService nodeService;

    @BeforeEach
    void setUp() {
        // NodeService 在构造器中初始化根节点，所以每个测试前都有根节点
    }

    @Test
    void testCreateNode() {
        // When
        nodeService.createNode("/test", "test data");

        // Then
        String data = nodeService.getNodeData("/test");
        assertEquals("test data", data);
    }

    @Test
    void testGetNodeData() {
        // Given
        nodeService.createNode("/test", "test data");

        // When
        String data = nodeService.getNodeData("/test");

        // Then
        assertEquals("test data", data);
    }

    @Test
    void testGetNodeData_NotExists() {
        // When
        String data = nodeService.getNodeData("/nonexistent");

        // Then
        assertEquals("节点不存在", data);
    }

    @Test
    void testUpdateNodeData() {
        // Given
        nodeService.createNode("/update", "original data");

        // When
        nodeService.updateNodeData("/update", "updated data");

        // Then
        String data = nodeService.getNodeData("/update");
        assertEquals("updated data", data);
    }

    @Test
    void testUpdateNodeData_NotExists() {
        // When & Then
        assertThrows(RuntimeException.class, () -> {
            nodeService.updateNodeData("/nonexistent", "new data");
        });
    }

    @Test
    void testDeleteNode() {
        // Given
        nodeService.createNode("/delete", "delete data");

        // When
        nodeService.deleteNode("/delete");

        // Then
        assertFalse(nodeService.nodeExists("/delete"));
    }

    @Test
    void testDeleteNode_NotExists() {
        // When & Then - 删除不存在的节点静默失败
        assertDoesNotThrow(() -> {
            nodeService.deleteNode("/nonexistent");
        });
    }

    @Test
    void testDeleteRootNode() {
        // When & Then - 不能删除根节点
        assertThrows(RuntimeException.class, () -> {
            nodeService.deleteNode("/");
        });
    }

    @Test
    void testDeleteNodeWithChildren() {
        // Given
        nodeService.createNode("/parent", "parent data");
        nodeService.createNode("/parent/child", "child data");

        // When & Then
        assertThrows(RuntimeException.class, () -> {
            nodeService.deleteNode("/parent");
        });
    }

    @Test
    void testGetChildren() {
        // Given
        nodeService.createNode("/parent", "parent data");
        nodeService.createNode("/parent/child1", "child1 data");
        nodeService.createNode("/parent/child2", "child2 data");
        nodeService.createNode("/parent/child3", "child3 data");

        // When
        List<String> children = nodeService.getChildren("/parent");

        // Then
        assertNotNull(children);
        assertEquals(3, children.size());
        assertTrue(children.contains("child1"));
        assertTrue(children.contains("child2"));
        assertTrue(children.contains("child3"));
    }

    @Test
    void testGetChildren_NoChildren() {
        // Given
        nodeService.createNode("/empty", "empty data");

        // When
        List<String> children = nodeService.getChildren("/empty");

        // Then
        assertNotNull(children);
        assertEquals(0, children.size());
    }

    @Test
    void testGetChildren_NotExists() {
        // When
        List<String> children = nodeService.getChildren("/nonexistent");

        // Then
        assertNotNull(children);
        assertEquals(0, children.size());
    }

    @Test
    void testNodeExists() {
        // Given
        nodeService.createNode("/exists", "exists data");

        // Then
        assertTrue(nodeService.nodeExists("/"));
        assertTrue(nodeService.nodeExists("/exists"));
        assertFalse(nodeService.nodeExists("/nonexistent"));
    }

    @Test
    void testGetConnectionInfo() {
        // When
        Map<String, Object> info = nodeService.getConnectionInfo();

        // Then
        assertNotNull(info);
        assertTrue((Boolean) info.get("connected"));
        assertNotNull(info.get("sessionId"));
        assertEquals("localhost:2181", info.get("serverAddress"));
        assertNotNull(info.get("nodeCount"));
    }

    @Test
    void testComplexHierarchy() {
        // Given - 创建复杂层级结构
        nodeService.createNode("/root", "root data");
        nodeService.createNode("/root/branch1", "branch1 data");
        nodeService.createNode("/root/branch2", "branch2 data");
        nodeService.createNode("/root/branch1/leaf1", "leaf1 data");
        nodeService.createNode("/root/branch1/leaf2", "leaf2 data");
        nodeService.createNode("/root/branch2/leaf3", "leaf3 data");

        // Then - 验证层级
        assertTrue(nodeService.nodeExists("/root"));
        assertTrue(nodeService.nodeExists("/root/branch1"));
        assertTrue(nodeService.nodeExists("/root/branch2"));
        assertTrue(nodeService.nodeExists("/root/branch1/leaf1"));
        assertTrue(nodeService.nodeExists("/root/branch1/leaf2"));
        assertTrue(nodeService.nodeExists("/root/branch2/leaf3"));

        // 验证子节点
        List<String> rootChildren = nodeService.getChildren("/root");
        assertEquals(2, rootChildren.size());

        List<String> branch1Children = nodeService.getChildren("/root/branch1");
        assertEquals(2, branch1Children.size());

        // 验证删除叶节点
        nodeService.deleteNode("/root/branch1/leaf1");
        assertFalse(nodeService.nodeExists("/root/branch1/leaf1"));
        assertTrue(nodeService.nodeExists("/root/branch1/leaf2"));
    }
}

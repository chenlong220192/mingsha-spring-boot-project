package site.mingsha.boot.example.zookeeper.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NodeServiceTest {
    @Autowired
    private NodeService nodeService;

    @Test
    void testCreateAndGetNode() {
        nodeService.createNode("/test", "test data");
        String data = nodeService.getNodeData("/test");
        assertEquals("test data", data);
    }

    @Test
    void testUpdateNodeData() {
        nodeService.createNode("/update", "original data");
        nodeService.updateNodeData("/update", "updated data");
        String data = nodeService.getNodeData("/update");
        assertEquals("updated data", data);
    }

    @Test
    void testDeleteNode() {
        nodeService.createNode("/delete", "delete data");
        assertTrue(nodeService.nodeExists("/delete"));
        
        nodeService.deleteNode("/delete");
        assertFalse(nodeService.nodeExists("/delete"));
    }

    @Test
    void testGetChildren() {
        nodeService.createNode("/parent", "parent data");
        nodeService.createNode("/parent/child1", "child1 data");
        nodeService.createNode("/parent/child2", "child2 data");
        
        List<String> children = nodeService.getChildren("/parent");
        assertEquals(2, children.size());
        assertTrue(children.contains("child1"));
        assertTrue(children.contains("child2"));
    }

    @Test
    void testNodeExists() {
        assertTrue(nodeService.nodeExists("/"));
        assertFalse(nodeService.nodeExists("/nonexistent"));
        
        nodeService.createNode("/exists", "exists data");
        assertTrue(nodeService.nodeExists("/exists"));
    }

    @Test
    void testGetConnectionInfo() {
        Map<String, Object> info = nodeService.getConnectionInfo();
        assertNotNull(info.get("connected"));
        assertNotNull(info.get("sessionId"));
        assertNotNull(info.get("serverAddress"));
        assertNotNull(info.get("nodeCount"));
    }

    @Test
    void testDeleteNodeWithChildren() {
        nodeService.createNode("/parent", "parent data");
        nodeService.createNode("/parent/child", "child data");
        
        assertThrows(RuntimeException.class, () -> {
            nodeService.deleteNode("/parent");
        });
    }
} 
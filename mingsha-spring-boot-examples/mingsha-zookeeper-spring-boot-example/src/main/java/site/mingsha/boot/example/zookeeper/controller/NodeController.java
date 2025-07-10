package site.mingsha.boot.example.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.zookeeper.service.NodeService;

import java.util.List;
import java.util.Map;

/**
 * 节点控制器 - 演示 Zookeeper 节点操作
 */
@RestController
@RequestMapping("/api/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    /**
     * 创建节点
     */
    @PostMapping
    public ResponseEntity<String> createNode(@RequestParam String path,
                                            @RequestParam String data) {
        nodeService.createNode(path, data);
        return ResponseEntity.ok("节点创建成功: " + path);
    }

    /**
     * 获取节点数据
     */
    @GetMapping("/{path:.*}")
    public ResponseEntity<String> getNodeData(@PathVariable String path) {
        String data = nodeService.getNodeData(path);
        return ResponseEntity.ok(data);
    }

    /**
     * 更新节点数据
     */
    @PutMapping("/{path:.*}")
    public ResponseEntity<String> updateNodeData(@PathVariable String path,
                                                @RequestParam String data) {
        nodeService.updateNodeData(path, data);
        return ResponseEntity.ok("节点数据更新成功: " + path);
    }

    /**
     * 删除节点
     */
    @DeleteMapping("/{path:.*}")
    public ResponseEntity<String> deleteNode(@PathVariable String path) {
        nodeService.deleteNode(path);
        return ResponseEntity.ok("节点删除成功: " + path);
    }

    /**
     * 获取子节点列表
     */
    @GetMapping("/{path:.*}/children")
    public ResponseEntity<List<String>> getChildren(@PathVariable String path) {
        List<String> children = nodeService.getChildren(path);
        return ResponseEntity.ok(children);
    }

    /**
     * 检查节点是否存在
     */
    @GetMapping("/{path:.*}/exists")
    public ResponseEntity<Boolean> nodeExists(@PathVariable String path) {
        boolean exists = nodeService.nodeExists(path);
        return ResponseEntity.ok(exists);
    }

    /**
     * 获取连接信息
     */
    @GetMapping("/connection/info")
    public ResponseEntity<Map<String, Object>> getConnectionInfo() {
        Map<String, Object> info = nodeService.getConnectionInfo();
        return ResponseEntity.ok(info);
    }
} 
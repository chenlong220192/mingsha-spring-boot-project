package site.mingsha.boot.example.zookeeper.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 节点服务 - 演示 Zookeeper 节点操作（内存模拟）
 */
@Service
public class NodeService {
    private final Map<String, String> nodeData = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> nodeChildren = new ConcurrentHashMap<>();

    public NodeService() {
        // 初始化根节点
        nodeData.put("/", "root");
        nodeChildren.put("/", new HashSet<>());
    }

    /**
     * 创建节点
     */
    public void createNode(String path, String data) {
        nodeData.put(path, data);
        
        // 创建父节点的子节点关系
        String parentPath = getParentPath(path);
        if (parentPath != null) {
            nodeChildren.computeIfAbsent(parentPath, k -> new HashSet<>()).add(getNodeName(path));
        }
        
        // 初始化当前节点的子节点集合
        nodeChildren.putIfAbsent(path, new HashSet<>());
    }

    /**
     * 获取节点数据
     */
    public String getNodeData(String path) {
        return nodeData.getOrDefault(path, "节点不存在");
    }

    /**
     * 更新节点数据
     */
    public void updateNodeData(String path, String data) {
        if (nodeData.containsKey(path)) {
            nodeData.put(path, data);
        } else {
            throw new RuntimeException("节点不存在: " + path);
        }
    }

    /**
     * 删除节点
     */
    public void deleteNode(String path) {
        if ("/".equals(path)) {
            throw new RuntimeException("不能删除根节点");
        }
        
        Set<String> children = nodeChildren.get(path);
        if (children != null && !children.isEmpty()) {
            throw new RuntimeException("节点有子节点，不能删除: " + path);
        }
        
        nodeData.remove(path);
        nodeChildren.remove(path);
        
        // 从父节点的子节点列表中移除
        String parentPath = getParentPath(path);
        if (parentPath != null) {
            Set<String> parentChildren = nodeChildren.get(parentPath);
            if (parentChildren != null) {
                parentChildren.remove(getNodeName(path));
            }
        }
    }

    /**
     * 获取子节点列表
     */
    public List<String> getChildren(String path) {
        Set<String> children = nodeChildren.get(path);
        return children != null ? new ArrayList<>(children) : new ArrayList<>();
    }

    /**
     * 检查节点是否存在
     */
    public boolean nodeExists(String path) {
        return nodeData.containsKey(path);
    }

    /**
     * 获取连接信息
     */
    public Map<String, Object> getConnectionInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("connected", true);
        info.put("sessionId", "session_" + System.currentTimeMillis());
        info.put("serverAddress", "localhost:2181");
        info.put("nodeCount", nodeData.size());
        return info;
    }

    /**
     * 获取父节点路径
     */
    private String getParentPath(String path) {
        int lastSlash = path.lastIndexOf('/');
        return lastSlash > 0 ? path.substring(0, lastSlash) : "/";
    }

    /**
     * 获取节点名称
     */
    private String getNodeName(String path) {
        int lastSlash = path.lastIndexOf('/');
        return lastSlash >= 0 ? path.substring(lastSlash + 1) : path;
    }
} 
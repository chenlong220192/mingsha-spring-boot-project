package site.mingsha.boot.example.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.elasticsearch.entity.Document;
import site.mingsha.boot.example.elasticsearch.service.DocumentService;

import java.util.List;

/**
 * 文档控制器 - 演示 Elasticsearch 操作
 */
@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * 创建文档
     */
    @PostMapping
    public ResponseEntity<Document> createDocument(@RequestBody Document document) {
        Document created = documentService.createDocument(document);
        return ResponseEntity.ok(created);
    }

    /**
     * 根据ID查询文档
     */
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable String id) {
        Document document = documentService.getDocument(id);
        if (document != null) {
            return ResponseEntity.ok(document);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 搜索文档
     */
    @GetMapping("/search")
    public ResponseEntity<List<Document>> searchDocuments(@RequestParam String keyword) {
        List<Document> documents = documentService.searchDocuments(keyword);
        return ResponseEntity.ok(documents);
    }

    /**
     * 更新文档
     */
    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable String id, 
                                                  @RequestBody Document document) {
        document.setId(id);
        Document updated = documentService.updateDocument(document);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * 删除文档
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable String id) {
        boolean deleted = documentService.deleteDocument(id);
        if (deleted) {
            return ResponseEntity.ok("文档删除成功");
        }
        return ResponseEntity.notFound().build();
    }
} 
package site.mingsha.boot.example.solr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.mingsha.boot.example.solr.entity.Document;
import site.mingsha.boot.example.solr.service.DocumentService;

import java.util.List;
import java.util.Optional;

/**
 * 文档控制器 - 演示 Solr 操作
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
     * 根据ID获取文档
     */
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable String id) {
        Optional<Document> document = documentService.getDocument(id);
        return document.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
    public ResponseEntity<Document> updateDocument(@PathVariable String id, @RequestBody Document document) {
        Document updatedDocument = documentService.updateDocument(id, document);
        return ResponseEntity.ok(updatedDocument);
    }

    /**
     * 删除文档
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable String id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok().build();
    }
    
    /**
     * 获取所有文档
     */
    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }
} 
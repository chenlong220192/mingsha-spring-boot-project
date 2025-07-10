package site.mingsha.boot.example.elasticsearch.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mingsha.boot.example.elasticsearch.entity.Document;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DocumentServiceTest {
    @Autowired
    private DocumentService documentService;

    @Test
    void testCreateAndGetDocument() {
        Document document = new Document("测试文档", "这是一个测试文档的内容", "测试作者");
        Document created = documentService.createDocument(document);
        
        assertNotNull(created);
        assertNotNull(created.getId());
        assertEquals("测试文档", created.getTitle());
        
        Document found = documentService.getDocument(created.getId());
        assertNotNull(found);
        assertEquals(created.getId(), found.getId());
    }

    @Test
    void testSearchDocuments() {
        // 创建测试文档
        Document doc1 = new Document("Java编程", "Java是一种编程语言", "张三");
        Document doc2 = new Document("Python教程", "Python是另一种编程语言", "李四");
        
        documentService.createDocument(doc1);
        documentService.createDocument(doc2);
        
        // 搜索包含"编程"的文档
        List<Document> results = documentService.searchDocuments("编程");
        assertNotNull(results);
        assertTrue(results.size() >= 1);
    }

    @Test
    void testUpdateDocument() {
        Document document = new Document("原始标题", "原始内容", "原始作者");
        Document created = documentService.createDocument(document);
        
        // 更新文档
        created.setTitle("更新后的标题");
        created.setContent("更新后的内容");
        Document updated = documentService.updateDocument(created);
        
        assertNotNull(updated);
        assertEquals("更新后的标题", updated.getTitle());
        assertEquals("更新后的内容", updated.getContent());
    }

    @Test
    void testDeleteDocument() {
        Document document = new Document("待删除文档", "这个文档将被删除", "删除作者");
        Document created = documentService.createDocument(document);
        
        // 删除文档
        boolean deleted = documentService.deleteDocument(created.getId());
        assertTrue(deleted);
        
        // 验证文档已被删除
        Document found = documentService.getDocument(created.getId());
        assertNull(found);
    }
} 
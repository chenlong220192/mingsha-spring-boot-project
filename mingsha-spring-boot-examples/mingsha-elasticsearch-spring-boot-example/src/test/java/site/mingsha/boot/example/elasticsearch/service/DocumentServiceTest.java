package site.mingsha.boot.example.elasticsearch.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import site.mingsha.boot.example.elasticsearch.entity.Document;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 文档服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class DocumentServiceTest {

    @Mock
    private ElasticsearchOperations elasticsearchOperations;

    @InjectMocks
    private DocumentService documentService;

    private Document testDocument;

    @BeforeEach
    void setUp() {
        testDocument = new Document("测试文档", "这是一个测试文档的内容", "测试作者");
        testDocument.setId("doc-1");
        testDocument.setCreateTime(LocalDateTime.now());
        testDocument.setUpdateTime(LocalDateTime.now());
    }

    @Test
    void testCreateDocument() {
        // Given
        when(elasticsearchOperations.save(any(Document.class))).thenReturn(testDocument);

        // When
        Document result = documentService.createDocument(testDocument);

        // Then
        assertNotNull(result);
        assertEquals("测试文档", result.getTitle());
        assertNotNull(result.getCreateTime());
        verify(elasticsearchOperations, times(1)).save(any(Document.class));
    }

    @Test
    void testGetDocument() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(testDocument);

        // When
        Document result = documentService.getDocument("doc-1");

        // Then
        assertNotNull(result);
        assertEquals("doc-1", result.getId());
        assertEquals("测试文档", result.getTitle());
    }

    @Test
    void testGetDocumentNotFound() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(null);

        // When
        Document result = documentService.getDocument("nonexistent");

        // Then
        assertNull(result);
    }

    @Test
    void testUpdateDocument() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(testDocument);
        when(elasticsearchOperations.save(any(Document.class))).thenReturn(testDocument);

        testDocument.setTitle("更新后的标题");
        testDocument.setContent("更新后的内容");

        // When
        Document result = documentService.updateDocument(testDocument);

        // Then
        assertNotNull(result);
        assertEquals("更新后的标题", result.getTitle());
    }

    @Test
    void testUpdateDocumentNotFound() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(null);

        // When
        Document result = documentService.updateDocument(testDocument);

        // Then
        assertNull(result);
    }

    @Test
    void testDeleteDocument() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(testDocument);

        // When
        boolean result = documentService.deleteDocument("doc-1");

        // Then
        assertTrue(result);
    }

    @Test
    void testDeleteDocumentNotFound() {
        // Given
        when(elasticsearchOperations.get(anyString(), eq(Document.class))).thenReturn(null);

        // When
        boolean result = documentService.deleteDocument("nonexistent");

        // Then
        assertFalse(result);
    }
}

package site.mingsha.boot.example.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import site.mingsha.boot.example.solr.entity.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * 文档服务测试
 *
 * @author mingsha
 * @since 2024-01-01
 */
@ExtendWith(MockitoExtension.class)
class DocumentServiceTest {
    
    @Mock
    private SolrClient solrClient;
    
    @InjectMocks
    private DocumentService documentService;
    
    private Document testDocument;
    
    @BeforeEach
    void setUp() {
        testDocument = new Document("test-1", "测试文档", "这是一个测试文档的内容", "测试作者");
        testDocument.setCreateTime(LocalDateTime.now());
        testDocument.setUpdateTime(LocalDateTime.now());
    }
    
    @Test
    void testCreateDocument() throws Exception {
        // Given
        when(solrClient.add(anyString(), any())).thenReturn(null);
        when(solrClient.commit(anyString())).thenReturn(null);
        
        // When
        Document result = documentService.createDocument(testDocument);
        
        // Then
        assertNotNull(result);
        assertEquals(testDocument.getId(), result.getId());
        assertEquals(testDocument.getTitle(), result.getTitle());
        verify(solrClient).add("documents", any());
        verify(solrClient).commit("documents");
    }
    
    @Test
    void testGetDocument() throws Exception {
        // Given
        SolrDocument solrDoc = new SolrDocument();
        solrDoc.addField("id", "test-1");
        solrDoc.addField("title", "测试文档");
        solrDoc.addField("content", "这是一个测试文档的内容");
        solrDoc.addField("author", "测试作者");
        solrDoc.addField("createTime", "2024-01-01T10:00:00Z");
        solrDoc.addField("updateTime", "2024-01-01T10:00:00Z");
        
        SolrDocumentList results = new SolrDocumentList();
        results.add(solrDoc);
        
        QueryResponse response = mock(QueryResponse.class);
        when(response.getResults()).thenReturn(results);
        when(solrClient.query(anyString(), any(SolrQuery.class))).thenReturn(response);
        
        // When
        Optional<Document> result = documentService.getDocument("test-1");
        
        // Then
        assertTrue(result.isPresent());
        assertEquals("test-1", result.get().getId());
        assertEquals("测试文档", result.get().getTitle());
    }
    
    @Test
    void testGetDocumentNotFound() throws Exception {
        // Given
        SolrDocumentList results = new SolrDocumentList();
        QueryResponse response = mock(QueryResponse.class);
        when(response.getResults()).thenReturn(results);
        when(solrClient.query(anyString(), any(SolrQuery.class))).thenReturn(response);
        
        // When
        Optional<Document> result = documentService.getDocument("not-exist");
        
        // Then
        assertFalse(result.isPresent());
    }
    
    @Test
    void testSearchDocuments() throws Exception {
        // Given
        SolrDocument solrDoc = new SolrDocument();
        solrDoc.addField("id", "test-1");
        solrDoc.addField("title", "测试文档");
        solrDoc.addField("content", "这是一个测试文档的内容");
        solrDoc.addField("author", "测试作者");
        
        SolrDocumentList results = new SolrDocumentList();
        results.add(solrDoc);
        
        QueryResponse response = mock(QueryResponse.class);
        when(response.getResults()).thenReturn(results);
        when(solrClient.query(anyString(), any(SolrQuery.class))).thenReturn(response);
        
        // When
        List<Document> documents = documentService.searchDocuments("测试");
        
        // Then
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals("test-1", documents.get(0).getId());
    }
    
    @Test
    void testUpdateDocument() throws Exception {
        // Given
        when(solrClient.add(anyString(), any())).thenReturn(null);
        when(solrClient.commit(anyString())).thenReturn(null);
        
        // When
        Document result = documentService.updateDocument("test-1", testDocument);
        
        // Then
        assertNotNull(result);
        assertEquals("test-1", result.getId());
        verify(solrClient).add("documents", any());
        verify(solrClient).commit("documents");
    }
    
    @Test
    void testDeleteDocument() throws Exception {
        // Given
        when(solrClient.deleteById(anyString(), anyString())).thenReturn(null);
        when(solrClient.commit(anyString())).thenReturn(null);
        
        // When
        documentService.deleteDocument("test-1");
        
        // Then
        verify(solrClient).deleteById("documents", "test-1");
        verify(solrClient).commit("documents");
    }
    
    @Test
    void testGetAllDocuments() throws Exception {
        // Given
        SolrDocument solrDoc = new SolrDocument();
        solrDoc.addField("id", "test-1");
        solrDoc.addField("title", "测试文档");
        solrDoc.addField("content", "这是一个测试文档的内容");
        solrDoc.addField("author", "测试作者");
        
        SolrDocumentList results = new SolrDocumentList();
        results.add(solrDoc);
        
        QueryResponse response = mock(QueryResponse.class);
        when(response.getResults()).thenReturn(results);
        when(solrClient.query(anyString(), any(SolrQuery.class))).thenReturn(response);
        
        // When
        List<Document> documents = documentService.getAllDocuments();
        
        // Then
        assertNotNull(documents);
        assertEquals(1, documents.size());
        assertEquals("test-1", documents.get(0).getId());
    }
    
    @Test
    void testCreateDocumentException() throws Exception {
        // Given
        when(solrClient.add(anyString(), any())).thenThrow(new SolrServerException("Solr error"));
        
        // When & Then
        assertThrows(RuntimeException.class, () -> {
            documentService.createDocument(testDocument);
        });
    }
} 
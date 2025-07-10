package site.mingsha.boot.example.solr.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.solr.entity.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文档服务
 *
 * @author mingsha
 * @since 2024-01-01
 */
@Service
public class DocumentService {
    
    @Autowired
    private SolrClient solrClient;
    
    private static final String COLLECTION = "documents";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    
    /**
     * 创建文档
     */
    public Document createDocument(Document document) {
        try {
            SolrInputDocument solrDoc = new SolrInputDocument();
            solrDoc.addField("id", document.getId());
            solrDoc.addField("title", document.getTitle());
            solrDoc.addField("content", document.getContent());
            solrDoc.addField("author", document.getAuthor());
            solrDoc.addField("createTime", document.getCreateTime().format(FORMATTER));
            solrDoc.addField("updateTime", document.getUpdateTime().format(FORMATTER));
            
            solrClient.add(COLLECTION, solrDoc);
            solrClient.commit(COLLECTION);
            
            return document;
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("创建文档失败", e);
        }
    }
    
    /**
     * 根据ID获取文档
     */
    public Optional<Document> getDocument(String id) {
        try {
            SolrQuery query = new SolrQuery();
            query.setQuery("id:" + id);
            query.setRows(1);
            
            QueryResponse response = solrClient.query(COLLECTION, query);
            SolrDocumentList results = response.getResults();
            
            if (results.isEmpty()) {
                return Optional.empty();
            }
            
            return Optional.of(convertToDocument(results.get(0)));
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("获取文档失败", e);
        }
    }
    
    /**
     * 搜索文档
     */
    public List<Document> searchDocuments(String keyword) {
        try {
            SolrQuery query = new SolrQuery();
            query.setQuery("title:" + keyword + " OR content:" + keyword);
            query.setRows(100);
            
            QueryResponse response = solrClient.query(COLLECTION, query);
            SolrDocumentList results = response.getResults();
            
            List<Document> documents = new ArrayList<>();
            for (SolrDocument solrDoc : results) {
                documents.add(convertToDocument(solrDoc));
            }
            
            return documents;
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("搜索文档失败", e);
        }
    }
    
    /**
     * 更新文档
     */
    public Document updateDocument(String id, Document document) {
        try {
            document.setId(id);
            document.setUpdateTime(LocalDateTime.now());
            
            SolrInputDocument solrDoc = new SolrInputDocument();
            solrDoc.addField("id", document.getId());
            solrDoc.addField("title", document.getTitle());
            solrDoc.addField("content", document.getContent());
            solrDoc.addField("author", document.getAuthor());
            solrDoc.addField("updateTime", document.getUpdateTime().format(FORMATTER));
            
            solrClient.add(COLLECTION, solrDoc);
            solrClient.commit(COLLECTION);
            
            return document;
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("更新文档失败", e);
        }
    }
    
    /**
     * 删除文档
     */
    public void deleteDocument(String id) {
        try {
            solrClient.deleteById(COLLECTION, id);
            solrClient.commit(COLLECTION);
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("删除文档失败", e);
        }
    }
    
    /**
     * 获取所有文档
     */
    public List<Document> getAllDocuments() {
        try {
            SolrQuery query = new SolrQuery();
            query.setQuery("*:*");
            query.setRows(1000);
            
            QueryResponse response = solrClient.query(COLLECTION, query);
            SolrDocumentList results = response.getResults();
            
            List<Document> documents = new ArrayList<>();
            for (SolrDocument solrDoc : results) {
                documents.add(convertToDocument(solrDoc));
            }
            
            return documents;
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("获取所有文档失败", e);
        }
    }
    
    /**
     * 转换 SolrDocument 为 Document
     */
    private Document convertToDocument(SolrDocument solrDoc) {
        Document document = new Document();
        document.setId((String) solrDoc.getFieldValue("id"));
        document.setTitle((String) solrDoc.getFieldValue("title"));
        document.setContent((String) solrDoc.getFieldValue("content"));
        document.setAuthor((String) solrDoc.getFieldValue("author"));
        
        String createTimeStr = (String) solrDoc.getFieldValue("createTime");
        if (createTimeStr != null) {
            document.setCreateTime(LocalDateTime.parse(createTimeStr, FORMATTER));
        }
        
        String updateTimeStr = (String) solrDoc.getFieldValue("updateTime");
        if (updateTimeStr != null) {
            document.setUpdateTime(LocalDateTime.parse(updateTimeStr, FORMATTER));
        }
        
        return document;
    }
} 
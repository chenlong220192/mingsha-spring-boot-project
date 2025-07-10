package site.mingsha.boot.example.elasticsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.elasticsearch.entity.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文档服务 - 演示 Elasticsearch 操作
 */
@Service
public class DocumentService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    private static final String INDEX_NAME = "documents";

    /**
     * 创建文档
     */
    public Document createDocument(Document document) {
        document.setCreateTime(LocalDateTime.now());
        document.setUpdateTime(LocalDateTime.now());
        return elasticsearchOperations.save(document);
    }

    /**
     * 根据ID查询文档
     */
    public Document getDocument(String id) {
        return elasticsearchOperations.get(id, Document.class);
    }

    /**
     * 搜索文档
     */
    public List<Document> searchDocuments(String keyword) {
        Criteria criteria = new Criteria("title").contains(keyword)
                .or("content").contains(keyword)
                .or("author").contains(keyword);
        Query query = new CriteriaQuery(criteria);
        SearchHits<Document> searchHits = elasticsearchOperations.search(query, Document.class);
        return searchHits.getSearchHits().stream()
                .map(hit -> hit.getContent())
                .collect(Collectors.toList());
    }

    /**
     * 更新文档
     */
    public Document updateDocument(Document document) {
        Document existing = getDocument(document.getId());
        if (existing != null) {
            document.setCreateTime(existing.getCreateTime());
            document.setUpdateTime(LocalDateTime.now());
            return elasticsearchOperations.save(document);
        }
        return null;
    }

    /**
     * 删除文档
     */
    public boolean deleteDocument(String id) {
        Document document = getDocument(id);
        if (document != null) {
            elasticsearchOperations.delete(document);
            return true;
        }
        return false;
    }
} 
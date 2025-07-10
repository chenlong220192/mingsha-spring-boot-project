package site.mingsha.boot.starter.mybatis.autoconfigure;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Mingsha MyBatis 自动配置类
 *
 * @author mingsha
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
@EnableConfigurationProperties(MingshaMybatisProperties.class)
@ConditionalOnProperty(prefix = "spring.datasource", name = "enabled", havingValue = "true", matchIfMissing = true)
public class MingshaMybatisAutoConfiguration {

    /**
     * 配置 SqlSessionFactory
     */
    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource, MingshaMybatisProperties properties) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        
        // 设置 MyBatis 配置
        if (properties.getMapperLocations() != null) {
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(properties.getMapperLocations()));
        }
        
        if (properties.getTypeAliasesPackage() != null) {
            sessionFactory.setTypeAliasesPackage(properties.getTypeAliasesPackage());
        }
        
        return sessionFactory.getObject();
    }
} 
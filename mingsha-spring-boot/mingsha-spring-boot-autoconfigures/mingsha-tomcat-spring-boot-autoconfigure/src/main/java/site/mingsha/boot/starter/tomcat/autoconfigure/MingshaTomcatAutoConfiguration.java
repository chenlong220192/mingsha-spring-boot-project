package site.mingsha.boot.starter.tomcat.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;

@Configuration
@ConditionalOnClass(name = "org.apache.catalina.startup.Tomcat")
@ConditionalOnProperty(prefix = "server.tomcat", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MingshaTomcatProperties.class)
public class MingshaTomcatAutoConfiguration {

    private final MingshaTomcatProperties tomcatProperties;

    public MingshaTomcatAutoConfiguration(MingshaTomcatProperties tomcatProperties) {
        this.tomcatProperties = tomcatProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        
        // 配置连接器
        factory.addConnectorCustomizers(this::customizeConnector);
        
        return factory;
    }

    private void customizeConnector(Connector connector) {
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        
        // 从配置文件读取参数
        protocol.setConnectionTimeout(tomcatProperties.getConnectionTimeout());
        protocol.setMaxConnections(tomcatProperties.getMaxConnections());
        protocol.setAcceptCount(tomcatProperties.getAcceptCount());
        protocol.setMaxThreads(tomcatProperties.getMaxThreads());
        protocol.setMinSpareThreads(tomcatProperties.getMinSpareThreads());
    }
} 
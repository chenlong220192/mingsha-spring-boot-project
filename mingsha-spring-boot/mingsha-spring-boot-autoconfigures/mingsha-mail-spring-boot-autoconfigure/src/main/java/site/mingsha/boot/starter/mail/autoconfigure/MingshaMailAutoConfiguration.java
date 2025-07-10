package site.mingsha.boot.starter.mail.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Mingsha Mail 自动配置
 */
@Configuration
@ConditionalOnClass(JavaMailSender.class)
@EnableConfigurationProperties(MingshaMailProperties.class)
public class MingshaMailAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JavaMailSender javaMailSender(MingshaMailProperties properties) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties.getHost());
        mailSender.setPort(properties.getPort());
        mailSender.setUsername(properties.getUsername());
        mailSender.setPassword(properties.getPassword());
        mailSender.setProtocol(properties.getProtocol());
        mailSender.setDefaultEncoding(properties.getDefaultEncoding());
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", properties.getProtocol());
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", properties.isTls());
        props.put("mail.smtp.ssl.enable", properties.isSsl());
        props.put("mail.smtp.connectiontimeout", properties.getConnectionTimeout());
        props.put("mail.smtp.timeout", properties.getReadTimeout());
        props.put("mail.smtp.writetimeout", properties.getWriteTimeout());
        
        return mailSender;
    }
} 
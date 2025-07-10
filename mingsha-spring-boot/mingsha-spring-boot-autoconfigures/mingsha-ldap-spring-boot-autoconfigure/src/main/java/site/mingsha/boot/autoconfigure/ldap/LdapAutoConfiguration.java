package site.mingsha.boot.autoconfigure.ldap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * LDAP自动配置
 *
 * @author mingsha
 * @date 2025-07-10
 */
@Configuration
@ConditionalOnClass(LdapTemplate.class)
@ConditionalOnProperty(prefix = "mingsha.ldap", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(LdapProperties.class)
public class LdapAutoConfiguration {

    /**
     * 配置LDAP上下文源
     */
    @Bean
    @ConditionalOnMissingBean
    public LdapContextSource ldapContextSource(LdapProperties properties) {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(properties.getUrl());
        contextSource.setBase(properties.getBase());
        
        if (properties.getManagerDn() != null && properties.getManagerPassword() != null) {
            contextSource.setUserDn(properties.getManagerDn());
            contextSource.setPassword(properties.getManagerPassword());
        }
        
        contextSource.setPooled(true);
        
        return contextSource;
    }

    /**
     * 配置LDAP模板
     */
    @Bean
    @ConditionalOnMissingBean
    public LdapTemplate ldapTemplate(LdapContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
} 
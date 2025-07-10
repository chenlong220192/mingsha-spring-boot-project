package site.mingsha.boot.example.ldap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.filter.Filter;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.query.LdapQuery;
import static org.springframework.ldap.query.LdapQueryBuilder.query;
import org.springframework.stereotype.Service;
import site.mingsha.boot.example.ldap.entity.User;

import javax.naming.Name;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户服务 - 演示 LDAP 操作
 */
@Service
public class UserService {

    @Autowired
    private LdapTemplate ldapTemplate;

    private static final String BASE_DN = "ou=users,dc=example,dc=com";

    /**
     * 创建用户
     */
    public User createUser(User user) {
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        
        Name dn = LdapNameBuilder
                .newInstance(BASE_DN)
                .add("uid", user.getUsername())
                .build();
        
        user.setId(dn);
        ldapTemplate.create(user);
        return user;
    }

    /**
     * 根据用户名查询用户
     */
    public User getUser(String username) {
        LdapQuery q = query().base(BASE_DN).where("uid").is(username);
        List<User> users = ldapTemplate.find(q, User.class);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 查询所有用户
     */
    public List<User> getAllUsers() {
        LdapQuery q = query().base(BASE_DN);
        return ldapTemplate.find(q, User.class);
    }

    /**
     * 根据邮箱查询用户
     */
    public User getUserByEmail(String email) {
        LdapQuery q = query().base(BASE_DN).where("mail").is(email);
        List<User> users = ldapTemplate.find(q, User.class);
        return users.isEmpty() ? null : users.get(0);
    }

    /**
     * 更新用户
     */
    public User updateUser(User user) {
        User existing = getUser(user.getUsername());
        if (existing != null) {
            user.setCreateTime(existing.getCreateTime());
            user.setUpdateTime(LocalDateTime.now());
            user.setId(existing.getId());
            ldapTemplate.update(user);
            return user;
        }
        return null;
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(String username) {
        User user = getUser(username);
        if (user != null) {
            ldapTemplate.delete(user);
            return true;
        }
        return false;
    }
} 
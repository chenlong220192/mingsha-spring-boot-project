package site.mingsha.boot.example.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import site.mingsha.boot.example.mybatis.entity.User;

import java.util.List;

/**
 * 用户数据访问层
 *
 * @author mingsha
 * @since 1.0.0
 */
@Mapper
public interface UserMapper {
    
    /**
     * 插入用户
     */
    @Insert("INSERT INTO users (username, email, phone, age, address, create_time, update_time) " +
            "VALUES (#{username}, #{email}, #{phone}, #{age}, #{address}, NOW(), NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
    
    /**
     * 根据ID查询用户
     */
    @Select("SELECT * FROM users WHERE id = #{id}")
    User selectById(Long id);
    
    /**
     * 根据用户名查询用户
     */
    @Select("SELECT * FROM users WHERE username = #{username}")
    User selectByUsername(String username);
    
    /**
     * 查询所有用户
     */
    @Select("SELECT * FROM users ORDER BY create_time DESC")
    List<User> selectAll();
    
    /**
     * 根据年龄范围查询用户
     */
    @Select("SELECT * FROM users WHERE age BETWEEN #{minAge} AND #{maxAge} ORDER BY age")
    List<User> selectByAgeRange(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);
    
    /**
     * 更新用户信息
     */
    @Update("UPDATE users SET username = #{username}, email = #{email}, phone = #{phone}, " +
            "age = #{age}, address = #{address}, update_time = NOW() WHERE id = #{id}")
    int update(User user);
    
    /**
     * 删除用户
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(Long id);
    
    /**
     * 统计用户总数
     */
    @Select("SELECT COUNT(*) FROM users")
    int count();
    
    /**
     * 根据地址模糊查询用户
     */
    @Select("SELECT * FROM users WHERE address LIKE CONCAT('%', #{address}, '%')")
    List<User> selectByAddressLike(String address);
} 
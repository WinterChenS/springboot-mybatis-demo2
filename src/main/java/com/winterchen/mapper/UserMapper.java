package com.winterchen.mapper;

import com.winterchen.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * User映射类
 * Created by Administrator on 2017/11/24.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
    User findUserByPhone(@Param("phone") String phone);

    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(" +
            "#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insertByUser(User user);

    @Update("UPDATE T_USER SET NAME = #{name}, PASSWORD = #{password} WHERE PHONE = #{phone}")
    void update(User user);

    @Delete("DELETE FROM T_USER WHERE ID = #{id}")
    void delete(Integer id);

    @Results({
            @Result(property = "name", column = "NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "phone", column = "PHONE")
    })
    @Select("SELECT NAME, PASSWORD, PHONE FROM T_USER")
    List<User> findAll();

}

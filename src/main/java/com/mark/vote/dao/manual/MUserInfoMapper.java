package com.mark.vote.dao.manual;

import com.mark.vote.model.UserInfo;
import com.mark.vote.model.UserInfoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MUserInfoMapper {

    @Delete({
        "delete from t_user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user_info (email, password, ",
        "phone, create_time, ",
        "update_time)",
        "values (#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, now(), ",
        "now())"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserInfo record);

    int insertSelective(UserInfo record);


    @Select({
        "select",
        "id, email, password, phone, create_time, update_time",
        "from t_user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.UserInfoMapper.BaseResultMap")
    UserInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(UserInfo record);

    @Update({
        "update t_user_info",
        "set email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserInfo record);

    @Select({
            "select",
            "count(1)",
            "from t_user_info",
            "where email = #{email, jdbcType=VARCHAR}"
    })
    int countByEmail(String email);

    @Select({
            "select",
            "count(1)",
            "from t_user_info",
            "where email = #{email, jdbcType=VARCHAR}",
            "and password = #{password, jdbcType=VARCHAR}"
    })
    int countByEmailAndPassword(String email, String password);


    UserInfo selectEmailAndPassword(String email, String passwod);
}
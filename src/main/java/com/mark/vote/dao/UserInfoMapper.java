package com.mark.vote.dao;

import com.mark.vote.model.UserInfo;
import com.mark.vote.model.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface UserInfoMapper {

    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

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
        "#{phone,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExampleWithRowbounds(UserInfoExample example, RowBounds rowBounds);

    List<UserInfo> selectByExample(UserInfoExample example);

    @Select({
        "select",
        "id, email, password, phone, create_time, update_time",
        "from t_user_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.UserInfoMapper.BaseResultMap")
    UserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

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
}
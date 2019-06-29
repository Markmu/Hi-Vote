package com.mark.vote.dao;

import com.mark.vote.model.VoteTheme;
import com.mark.vote.model.VoteThemeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface VoteThemeMapper {

    long countByExample(VoteThemeExample example);

    int deleteByExample(VoteThemeExample example);

    @Delete({
        "delete from t_vote_theme",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_vote_theme (user_id, title, ",
        "description, status, ",
        "start_time, close_time, ",
        "create_time, update_time)",
        "values (#{userId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{startTime,jdbcType=TIMESTAMP}, #{closeTime,jdbcType=TIMESTAMP}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VoteTheme record);

    int insertSelective(VoteTheme record);

    List<VoteTheme> selectByExampleWithRowbounds(VoteThemeExample example, RowBounds rowBounds);

    List<VoteTheme> selectByExample(VoteThemeExample example);

    @Select({
        "select",
        "id, user_id, title, description, status, start_time, close_time, create_time, ",
        "update_time",
        "from t_vote_theme",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.VoteThemeMapper.BaseResultMap")
    VoteTheme selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoteTheme record, @Param("example") VoteThemeExample example);

    int updateByExample(@Param("record") VoteTheme record, @Param("example") VoteThemeExample example);

    int updateByPrimaryKeySelective(VoteTheme record);

    @Update({
        "update t_vote_theme",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "start_time = #{startTime,jdbcType=TIMESTAMP},",
          "close_time = #{closeTime,jdbcType=TIMESTAMP},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteTheme record);
}
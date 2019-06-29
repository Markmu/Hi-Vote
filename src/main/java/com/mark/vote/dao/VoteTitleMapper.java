package com.mark.vote.dao;

import com.mark.vote.model.VoteTitle;
import com.mark.vote.model.VoteTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface VoteTitleMapper {

    long countByExample(VoteTitleExample example);

    int deleteByExample(VoteTitleExample example);

    @Delete({
        "delete from t_vote_title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_vote_title (theme_id, title, ",
        "type, img_name, vote_max, ",
        "vote_min, must_vote, ",
        "create_time, update_time)",
        "values (#{themeId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=INTEGER}, #{imgName,jdbcType=INTEGER}, #{voteMax,jdbcType=INTEGER}, ",
        "#{voteMin,jdbcType=INTEGER}, #{mustVote,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VoteTitle record);

    int insertSelective(VoteTitle record);

    List<VoteTitle> selectByExampleWithRowbounds(VoteTitleExample example, RowBounds rowBounds);

    List<VoteTitle> selectByExample(VoteTitleExample example);

    @Select({
        "select",
        "id, theme_id, title, type, img_name, vote_max, vote_min, must_vote, create_time, ",
        "update_time",
        "from t_vote_title",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.VoteTitleMapper.BaseResultMap")
    VoteTitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoteTitle record, @Param("example") VoteTitleExample example);

    int updateByExample(@Param("record") VoteTitle record, @Param("example") VoteTitleExample example);

    int updateByPrimaryKeySelective(VoteTitle record);

    @Update({
        "update t_vote_title",
        "set theme_id = #{themeId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "img_name = #{imgName,jdbcType=INTEGER},",
          "vote_max = #{voteMax,jdbcType=INTEGER},",
          "vote_min = #{voteMin,jdbcType=INTEGER},",
          "must_vote = #{mustVote,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteTitle record);
}
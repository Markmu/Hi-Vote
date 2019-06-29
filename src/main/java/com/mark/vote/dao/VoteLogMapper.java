package com.mark.vote.dao;

import com.mark.vote.model.VoteLog;
import com.mark.vote.model.VoteLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface VoteLogMapper {

    long countByExample(VoteLogExample example);

    int deleteByExample(VoteLogExample example);

    @Delete({
        "delete from t_vote_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_vote_log (user_id, vote_id, ",
        "device_id, vote_item_id, ",
        "anoymouse, create_time, ",
        "vote_time)",
        "values (#{userId,jdbcType=INTEGER}, #{voteId,jdbcType=INTEGER}, ",
        "#{deviceId,jdbcType=VARCHAR}, #{voteItemId,jdbcType=INTEGER}, ",
        "#{anoymouse,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{voteTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VoteLog record);

    int insertSelective(VoteLog record);

    List<VoteLog> selectByExampleWithRowbounds(VoteLogExample example, RowBounds rowBounds);

    List<VoteLog> selectByExample(VoteLogExample example);

    @Select({
        "select",
        "id, user_id, vote_id, device_id, vote_item_id, anoymouse, create_time, vote_time",
        "from t_vote_log",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.VoteLogMapper.BaseResultMap")
    VoteLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoteLog record, @Param("example") VoteLogExample example);

    int updateByExample(@Param("record") VoteLog record, @Param("example") VoteLogExample example);

    int updateByPrimaryKeySelective(VoteLog record);

    @Update({
        "update t_vote_log",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "vote_id = #{voteId,jdbcType=INTEGER},",
          "device_id = #{deviceId,jdbcType=VARCHAR},",
          "vote_item_id = #{voteItemId,jdbcType=INTEGER},",
          "anoymouse = #{anoymouse,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "vote_time = #{voteTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteLog record);
}
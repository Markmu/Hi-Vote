package com.mark.vote.dao;

import com.mark.vote.model.VoteItem;
import com.mark.vote.model.VoteItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface VoteItemMapper {

    long countByExample(VoteItemExample example);

    int deleteByExample(VoteItemExample example);

    @Delete({
        "delete from t_vote_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_vote_item (title_id, vote_no, ",
        "vote_desc, vote_num, ",
        "create_time, update_time)",
        "values (#{titleId,jdbcType=INTEGER}, #{voteNo,jdbcType=INTEGER}, ",
        "#{voteDesc,jdbcType=INTEGER}, #{voteNum,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(VoteItem record);

    int insertSelective(VoteItem record);

    List<VoteItem> selectByExampleWithRowbounds(VoteItemExample example, RowBounds rowBounds);

    List<VoteItem> selectByExample(VoteItemExample example);

    @Select({
        "select",
        "id, title_id, vote_no, vote_desc, vote_num, create_time, update_time",
        "from t_vote_item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.VoteItemMapper.BaseResultMap")
    VoteItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VoteItem record, @Param("example") VoteItemExample example);

    int updateByExample(@Param("record") VoteItem record, @Param("example") VoteItemExample example);

    int updateByPrimaryKeySelective(VoteItem record);

    @Update({
        "update t_vote_item",
        "set title_id = #{titleId,jdbcType=INTEGER},",
          "vote_no = #{voteNo,jdbcType=INTEGER},",
          "vote_desc = #{voteDesc,jdbcType=INTEGER},",
          "vote_num = #{voteNum,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteItem record);
}
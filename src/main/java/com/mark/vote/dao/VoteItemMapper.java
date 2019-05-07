package com.mark.vote.dao;

import com.mark.vote.model.VoteItem;
import com.mark.vote.model.VoteItemExample;
import com.mark.vote.model.VoteItemKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface VoteItemMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    long countByExample(VoteItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    int deleteByExample(VoteItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    @Delete({
        "delete from t_vote_item",
        "where vote_id = #{voteId,jdbcType=INTEGER}",
          "and vote_no = #{voteNo,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(VoteItemKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    @Insert({
        "insert into t_vote_item (vote_id, vote_no, ",
        "vote_desc, vote_num, ",
        "create_time, update_time)",
        "values (#{voteId,jdbcType=INTEGER}, #{voteNo,jdbcType=INTEGER}, ",
        "#{voteDesc,jdbcType=INTEGER}, #{voteNum,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(VoteItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    int insertSelective(VoteItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    List<VoteItem> selectByExampleWithRowbounds(VoteItemExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    List<VoteItem> selectByExample(VoteItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    @Select({
        "select",
        "vote_id, vote_no, vote_desc, vote_num, create_time, update_time",
        "from t_vote_item",
        "where vote_id = #{voteId,jdbcType=INTEGER}",
          "and vote_no = #{voteNo,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.VoteItemMapper.BaseResultMap")
    VoteItem selectByPrimaryKey(VoteItemKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    int updateByExampleSelective(@Param("record") VoteItem record, @Param("example") VoteItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    int updateByExample(@Param("record") VoteItem record, @Param("example") VoteItemExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    int updateByPrimaryKeySelective(VoteItem record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    @Update({
        "update t_vote_item",
        "set vote_desc = #{voteDesc,jdbcType=INTEGER},",
          "vote_num = #{voteNum,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where vote_id = #{voteId,jdbcType=INTEGER}",
          "and vote_no = #{voteNo,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(VoteItem record);
}
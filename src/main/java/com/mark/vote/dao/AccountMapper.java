package com.mark.vote.dao;

import com.mark.vote.model.Account;
import com.mark.vote.model.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface AccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    long countByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    int deleteByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    @Delete({
        "delete from t_account",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    @Insert({
        "insert into t_account (username, nickname, ",
        "email, password, ",
        "phone, create_time, ",
        "update_time)",
        "values (#{username,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{create_time,jdbcType=TIMESTAMP}, ",
        "#{update_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    int insertSelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    List<Account> selectByExampleWithRowbounds(AccountExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    List<Account> selectByExample(AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    @Select({
        "select",
        "id, username, nickname, email, password, phone, create_time, update_time",
        "from t_account",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.mark.vote.dao.AccountMapper.BaseResultMap")
    Account selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    int updateByPrimaryKeySelective(Account record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_account
     *
     * @mbg.generated Sun May 05 00:07:04 CST 2019
     */
    @Update({
        "update t_account",
        "set username = #{username,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "create_time = #{create_time,jdbcType=TIMESTAMP},",
          "update_time = #{update_time,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Account record);
}
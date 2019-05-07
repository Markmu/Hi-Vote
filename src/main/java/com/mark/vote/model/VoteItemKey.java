package com.mark.vote.model;

import java.io.Serializable;

public class VoteItemKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_vote_item.vote_id
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    private Integer voteId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_vote_item.vote_no
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    private Integer voteNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_vote_item.vote_id
     *
     * @return the value of t_vote_item.vote_id
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public Integer getVoteId() {
        return voteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public VoteItemKey withVoteId(Integer voteId) {
        this.setVoteId(voteId);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_vote_item.vote_id
     *
     * @param voteId the value for t_vote_item.vote_id
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public void setVoteId(Integer voteId) {
        this.voteId = voteId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_vote_item.vote_no
     *
     * @return the value of t_vote_item.vote_no
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public Integer getVoteNo() {
        return voteNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public VoteItemKey withVoteNo(Integer voteNo) {
        this.setVoteNo(voteNo);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_vote_item.vote_no
     *
     * @param voteNo the value for t_vote_item.vote_no
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    public void setVoteNo(Integer voteNo) {
        this.voteNo = voteNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_vote_item
     *
     * @mbg.generated Tue May 07 23:08:15 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", voteId=").append(voteId);
        sb.append(", voteNo=").append(voteNo);
        sb.append("]");
        return sb.toString();
    }
}
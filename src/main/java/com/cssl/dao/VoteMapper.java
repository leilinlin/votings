package com.cssl.dao;

import com.cssl.pojo.Vote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteMapper {
    //1.查询所有主题以及投票选项和投票的人数

   public List<Vote> findAllVote(@Param("title") String title);

   //2.查询主题表的选项
   public Vote findOptionById(Integer vid);

   //3.查询单个的主题以及投票选项和投票人数
   public Vote findVoteByVoteId(Integer vid);

   //4.新增投票主题
   public int addVote(Vote vote);

   //5.查询主题的名字查询主题的id
   public Vote findVoteByTitleName(@Param("title") String title);
}


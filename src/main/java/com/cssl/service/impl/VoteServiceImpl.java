package com.cssl.service.impl;

import com.cssl.dao.VoteMapper;
import com.cssl.pojo.Vote;
import com.cssl.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteMapper voteMapper;

    //查询所有的主题以及投票选项和投票人数
    @Override
    public List<Vote> findAllVote(String title) {
        List<Vote> voteList = voteMapper.findAllVote(title);
        return voteList;
    }
     //查询单个的主题以及投票选项和投票的人数
    @Override
    public Vote findVoteByVoteId(Integer vid){
        return voteMapper.findVoteByVoteId(vid);
    }

    //根据主题名字查询主题id
    @Override
    public Vote findVoteByTitleName(String title) {

        return voteMapper.findVoteByTitleName(title);
    }

    //新增主题
    @Override
    public int addVote(Vote vote) {

        return voteMapper.addVote(vote);
    }

}

package com.cssl.service;

import com.cssl.pojo.Vote;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Component 最普通的组件，可以被注入到spring容器进行管理
 * @Repository 作用于持久层
 * @Service 作用于业务逻辑层
 * @Controller 作用于表现层（spring-mvc的注解）
 */

@Repository
public interface VoteService {
         //1.查询所有的主题以及投票选项和投票人数
        public List<Vote> findAllVote(String title);


         //2.查询单个主题以及投票选项和投票人数
         public Vote findVoteByVoteId(Integer vid);

         //3.查询主题的名字查询主题的id
         public Vote findVoteByTitleName(String title);

         //4.新增主题
         public int addVote(Vote vote);

}

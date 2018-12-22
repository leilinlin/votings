package com.cssl.controller;

import com.cssl.pojo.Options;
import com.cssl.pojo.Users;
import com.cssl.pojo.Vote;
import com.cssl.service.OptionsService;
import com.cssl.service.VoteService;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class VoteController {
   //控制层调用服务层数据，自动装配VOtingService
    // @RequestParam(required = false)传值，传不传都不会报错

    @Autowired
    VoteService votingService; //主题

    @Autowired
    OptionsService optionsService; //选项
    //显示主页
    @RequestMapping("/voteList")
    public String toIndex(Model model, @RequestParam(required = false) Integer pageNum,@RequestParam(required = false) String title){
    if(pageNum==null||pageNum==0){
        pageNum=1;

    }
        System.out.println("进入voteList");
        Page<Vote> pg= PageHelper.startPage(pageNum,3);
        List<Vote> voteList = votingService.findAllVote(title);
        System.out.println(""+pg.getResult());
        //将分页pg对象
        model.addAttribute("pg",pg);
        return "votelist";
    }

    //根据主题id查询投票选项
    @RequestMapping("/showVote")
    public String showVote(Integer vid,Model model){
        String type = null;
        //查询单个主题以及投票选项和投票人数
        Vote vote = votingService.findVoteByVoteId(vid);
        //根据主题id查询主题选项
        List<Options> optionsList = optionsService.findOptionsById(vid);
        if(vote.getVtype()==0){
            type="ridio";
        }else {
            type="checkbox";
        }
        model.addAttribute("vote",vote);
        //将投票类型存放在model中给视图渲染
        model.addAttribute("vtype",type);
        model.addAttribute("optionsList",optionsList);
       //传到vote投票页面
        return  "vote";

    }


     //添加投票
     //@RequestParam 请求参数
     @RequestMapping("/addVote")
     public String addVote(Vote vote, @RequestParam String[] optionName, HttpSession session){
         //增加主题表
         Set set = new HashSet();
         //获取K值Users
         Users users =(Users)session.getAttribute("Users");
         System.out.println("Users.getIdAdmin():"+users.getIdAdmin());
         if(users.getIdAdmin()==0){
             //为主题添加选项
             int num = votingService.addVote(vote);//新增主题
             for(int i=0;i<optionName.length;i++){
                 System.out.println("获取的值"+optionName[i]);
                 //将OptionName[i]，添加到HashSet集合
                 set.add(optionName[i]);
             }
             //迭代器，Set类的iterator()返回了一个实例，这个实例是Iterator的实现类。这就是常说的向上转型
             Iterator<String> iteam=set.iterator();
             while(iteam.hasNext()){
                 optionsService.addOptions(iteam.next(),vote.getVid());
             }
             //转发到主页
             return "forward:/voteList";
         }else {
             //重定向到主页
             return "redirect:/voteList";
         }

     }

     //去投票表界面显示
    @RequestMapping("/toVoteView")
    public String toVoteView(Integer vid,Model model){
         //根据主题的id来查询投票选项id和每个选项所得的票数
        List<Options> options = optionsService.findOptions(vid);
        //主题名和投票的选项id和每个选项所得的票数
        Vote vote = votingService.findVoteByVoteId(vid);
        model.addAttribute("vote",vote);
        model.addAttribute("options",options);
        return "voteview";
    }
     //Ajax验证主题是否重复
    public String verify(String title){
        //查询title将值付给vote对象
     Vote vote = votingService.findVoteByTitleName(title);
      if(vote!=null){
          return "1";
      }else {
          return "2";
      }
    }
}


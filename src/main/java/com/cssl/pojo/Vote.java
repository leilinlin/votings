package com.cssl.pojo;

import lombok.Getter;

import java.util.List;




@Getter
public class Vote {
    private Integer vid;//主题表id
    private String title;//主题内容
    private Integer vtype;//主题类型
    private List<Options> options; //将投票表集合放入主题表中

    private Integer itemNum;//选项个数
    private Integer totalPoll;//票数
}
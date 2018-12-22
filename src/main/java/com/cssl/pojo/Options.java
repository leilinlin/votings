package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Options {


    private Integer oid;        //选项Id
    private String optionName;  //选项的名字
    private Integer vid;        //主题表的Id 关联option

    private Integer poll;      //某一选项票数


}

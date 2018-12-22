package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Record {
    private Integer  iid;  // 投票记录表id
    private Integer  uid;  // 用户表id
    private Integer si;    // 主题表id
    private Integer oid;   // 选项表id
}

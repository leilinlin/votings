package com.cssl.service;

import com.cssl.pojo.Options;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionsService {
    //根据主题id查询主题选项
    public List<Options> findOptionsById(Integer vid);

    //新增主题选项
    public List<Options> addOptions(String optionName, Integer vid);

    //2.根据主题的id来查询投票选项id和每个选项所得的票数(投票比例界面)
     public List<Options> findOptions(Integer vid);
}

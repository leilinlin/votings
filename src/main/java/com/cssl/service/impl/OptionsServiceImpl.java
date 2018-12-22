package com.cssl.service.impl;

import com.cssl.dao.OptionsMapper;
import com.cssl.pojo.Options;
import com.cssl.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {

    @Autowired
    private OptionsMapper optionsMapper;

    //1.根据主题的id来查询主题的Options投票选项
    //vid为主题表id
    @Override
    public List<Options> findOptionsById(Integer vid){
        return optionsMapper.findOptionsById(vid);
    }
    //3.添加主题投票****找到投票主题optionName，
    @Override
    public List<Options> addOptions(String optionName, Integer vid) {
            return optionsMapper.addOptions(optionName,vid);
    }

    //2.根据主题的id来查询投票选项id和每个选项所得的票数(投票比例界面)
    public List<Options> findOptions(Integer vid){
        return optionsMapper.findOptions(vid);
    }


}

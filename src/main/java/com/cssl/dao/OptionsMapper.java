package com.cssl.dao;

import com.cssl.pojo.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionsMapper {


    //1.根据主题的id来查询主题的Options投票选项
    //    //vid为主题表id
    public List<Options> findOptionsById(Integer vid);


    //2.根据主题的id来查询投票选项id和每个选项所得的票数(投票比例界面)
    public List<Options> findOptions(Integer vid);

    //3.添加主题投票****找到投票主题optionName，
    public List<Options> addOptions(@Param("optionName")String optionName,
                                    @Param("vid")Integer vid);


}

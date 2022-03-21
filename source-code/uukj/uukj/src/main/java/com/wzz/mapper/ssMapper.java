package com.wzz.mapper;

import com.wzz.model.ss;

import java.util.List;

/**
 * @ClassName ssMapper
 * @Description TODO 说说持久层接口
 * @Author wzj
 * Version 1.0
 **/
public interface ssMapper {

    List<ss> queryssList(int userid);

    void addss(ss Ss);

    void delssbyid(int id);

    int countss(int userid);
}

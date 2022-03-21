package com.wzz.service;

import com.wzz.model.ss;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ssService
 * @Description TODO 用户业务层接口
 * @Author AZhen
 * Version 1.0
 **/
public interface ssService {
    Map<String,Object> queryssList(int userid);

    void addss(ss Ss);

    void delssbyid(int id);

    int countss(int userid);
}

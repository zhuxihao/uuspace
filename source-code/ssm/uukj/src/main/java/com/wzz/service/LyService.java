package com.wzz.service;

import com.wzz.model.Ly;

import java.util.Map;

/**
 * @ClassName LyService
 * @Description TODO 留言业务层接口
 * @Author AZhen
 * Version 1.0
 **/

public interface LyService {

    void addLy(Ly ly);

    void delLy(int id);

    Map<String,Object> queryLyList(int userid);

    int countLy(int userid);
}

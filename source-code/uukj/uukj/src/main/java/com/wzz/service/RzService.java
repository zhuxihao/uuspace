package com.wzz.service;

import com.wzz.model.Rz;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RzService
 * @Description TODO 用户业务层接口
 * @Author AZhen
 * Version 1.0
 **/
public interface RzService {
    void addRz(Rz rz);

    void delRzbyid(int id);

    Map<String,Object> queryRznameList(int userid);

    int countRz(int userid);

    Rz queryRz(int id);
}

package com.wzz.mapper;

import com.wzz.model.Rz;
import com.wzz.model.ss;

import java.util.List;
/**
 * @ClassName RzMapper
 * @Description TODO 日志持久层接口
 * @Author wzj
 * Version 1.0
 **/
public interface RzMapper {
    void addRz(Rz rz);

    void delRzbyid(int id);

    List<Rz> queryRznameList(int userid);

    int countRz(int userid);

    Rz queryRz(int id);
}

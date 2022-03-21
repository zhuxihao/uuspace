package com.wzz.mapper;

import com.wzz.model.Ly;

import java.util.List;

/**
 * @ClassName LyMapper
 * @Description TODO 留言持久层接口
 * @Author AZhen
 * Version 1.0
 **/

public interface LyMapper {

    void addLy(Ly ly);

    void delLy(int id);

    List<Ly> queryLyList(int userid);

    int countLy(int userid);
}

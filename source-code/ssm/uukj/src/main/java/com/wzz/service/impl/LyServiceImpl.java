package com.wzz.service.impl;

import com.wzz.mapper.LyMapper;
import com.wzz.model.Ly;
import com.wzz.model.ss;
import com.wzz.service.LyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LyServiceImpl
 * @Description TODO  留言业务层实现类
 * @Author AZhen
 * Version 1.0
 **/

@Service
public class LyServiceImpl implements LyService {
    @Autowired
    private LyMapper LyMapper;

    @Override
    public void addLy(Ly ly){
        LyMapper.addLy(ly);
    }

    @Override
    public void delLy(int id){
        LyMapper.delLy(id);

    }

    @Override
    public Map<String,Object> queryLyList(int userid){
        List<Ly> Lylist= LyMapper.queryLyList(userid);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("LyList",Lylist);
        return resultMap;

    }

    @Override
    public int countLy(int userid){
       int count = LyMapper.countLy(userid);
       return count;
    }
}

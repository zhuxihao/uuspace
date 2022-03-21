package com.wzz.service.impl;

import com.wzz.mapper.ssMapper;
import com.wzz.model.ss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wzz.service.ssService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ssServiceImpl
 * @Description TODO  用户业务层实现类
 * @Author AZhen
 * Version 1.0
 **/

@Service
public class ssServiceImpl implements ssService {
    @Autowired
    private ssMapper ssMapper;
    @Override
    public Map<String,Object> queryssList(int userid){

        List<ss> sslist= ssMapper.queryssList(userid);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("ssList",sslist);
        return resultMap;
    }
    @Override
    public void addss(ss Ss){
        ssMapper.addss(Ss);
    }
    @Override
    public void delssbyid(int id) {
        ssMapper.delssbyid(id);

    }

    @Override
    public int countss(int userid) {
        int count=ssMapper.countss(userid);
        return count;
    }
}



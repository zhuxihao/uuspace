package com.wzz.service.impl;

import com.wzz.mapper.RzMapper;
import com.wzz.model.Rz;
import com.wzz.service.RzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RzServiceImpl
 * @Description TODO  用户业务层实现类
 * @Author AZhen
 * Version 1.0
 **/
@Service
public class RzServiceImpl implements RzService {

    @Autowired
    private RzMapper RzMapper;

    @Override
    public void addRz(Rz rz){
        RzMapper.addRz(rz);
    }
    @Override
    public void delRzbyid(int id){
        RzMapper.delRzbyid(id);
    }
    @Override
    public Map<String,Object> queryRznameList(int userid){
        List<Rz> listRzname = RzMapper.queryRznameList(userid);
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("Rzlist",listRzname);
        return resultMap;
    };
    @Override
    public int countRz(int userid){
        int count = RzMapper.countRz(userid);
        return count;
    };
    @Override
    public Rz queryRz(int id){
        Rz rz = RzMapper.queryRz(id);
        return rz;
    }
}

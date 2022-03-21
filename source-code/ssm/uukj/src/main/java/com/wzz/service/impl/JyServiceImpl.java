package com.wzz.service.impl;

import com.wzz.mapper.JyMapper;
import com.wzz.model.Jy;
import com.wzz.service.JyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

/**
 * @ClassName JyServiceImpl
 * @Description TODO  寄语业务层实现类
 * @Author AZhen
 * Version 1.0
 **/

@Service
public class JyServiceImpl implements JyService {

    @Autowired
    private JyMapper JyMapper;

    @Override
    public Jy queryJy(){
        Random df = new Random();
        int id = df.nextInt(11);
        Jy jy = JyMapper.queryJy(id);
        return jy;
    }

}

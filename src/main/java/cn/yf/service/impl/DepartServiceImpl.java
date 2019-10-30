package cn.yf.service.impl;

import cn.yf.mapper.DepartMapper;
import cn.yf.pojo.Depart;
import cn.yf.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService{

    @Autowired
    DepartMapper departMapper;

    @Override
    public List<Depart> getAllDepart() {
        return departMapper.getAllDepart();
    }
}

package cn.yf.service.impl;

import cn.yf.mapper.AdminMapper;
import cn.yf.pojo.Admin;
import cn.yf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public List<Admin> getAllAdmin() {
        List<Admin> adminList = adminMapper.getAllAdmin();
        return adminList;
    }

    @Override
    public Admin getAdminById(int id) {
        Admin admin = adminMapper.getAdminById(id);
        return admin;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        boolean result = adminMapper.addAdmin(admin);
        if(result){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        boolean result = adminMapper.updateAdmin(admin);
        if(result){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAdminById(int id) {
        boolean result = adminMapper.deleteAdminById(id);
        if(result){
            return true;
        }
        return false;
    }
}


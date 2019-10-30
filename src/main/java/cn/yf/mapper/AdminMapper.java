package cn.yf.mapper;

import cn.yf.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    public List<Admin> getAllAdmin();

    public Admin getAdminById(int id);

    public boolean addAdmin(Admin admin);

    public boolean updateAdmin(Admin admin);

    public boolean deleteAdminById(int id);

}


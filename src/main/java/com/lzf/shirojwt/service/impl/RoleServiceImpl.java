package com.lzf.shirojwt.service.impl;

import com.lzf.shirojwt.dao.RoleDao;
import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.model.Role;
import com.lzf.shirojwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Service("roleService")
@Cacheable(value = "role")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    @CacheEvict(value = "role")
    public int save(Role role) {
        try {
            roleDao.save(role);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Role findById(Integer id) {
        return roleDao.findById(id).get();
    }

    @Override
    public List<Permission> findPermissionById(Integer id) {
        return roleDao.findById(id).get().getPermissions();
    }
}

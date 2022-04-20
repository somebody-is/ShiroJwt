package com.lzf.shirojwt.service.impl;

import com.lzf.shirojwt.dao.PermissionDao;
import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Service("permissionService")
@Cacheable(value = "permission")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    @CacheEvict(value = "permission")
    public int save(Permission permission) {
        try {
            permissionDao.save(permission);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Permission findById(Integer id) {
        return permissionDao.findById(id).get();
    }
}

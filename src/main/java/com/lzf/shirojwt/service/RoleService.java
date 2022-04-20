package com.lzf.shirojwt.service;

import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.model.Role;

import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public interface RoleService {

    public int save(Role role);

    public Role findById(Integer id);

    public List<Permission>findPermissionById(Integer id);
}

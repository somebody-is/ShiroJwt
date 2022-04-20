package com.lzf.shirojwt.service;

import com.lzf.shirojwt.model.Permission;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public interface PermissionService {

    public int save(Permission permission);

    public Permission findById(Integer id);
}

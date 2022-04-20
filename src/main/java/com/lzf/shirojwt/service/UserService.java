package com.lzf.shirojwt.service;

import com.lzf.shirojwt.model.Role;
import com.lzf.shirojwt.model.User;

import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
public interface UserService {

    public User findByUserName(String username);

    public int save(User user);

    public List<Role> findRoleByUserName(String username);

    public List<Role> findRoleById(Integer id);

    public User findById(Integer id);

}

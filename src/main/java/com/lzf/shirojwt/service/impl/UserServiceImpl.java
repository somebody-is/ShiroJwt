package com.lzf.shirojwt.service.impl;

import com.lzf.shirojwt.dao.UserDao;
import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.model.Role;
import com.lzf.shirojwt.model.User;
import com.lzf.shirojwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Service("userService")
@Cacheable(value = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String username) {
        return userDao.findByUsernameEquals(username);
    }

    @Override
    @CacheEvict(value = "user")
    public int save(User user) {
        try{
            userDao.save(user);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Role> findRoleByUserName(String username) {
        return userDao.findByUsernameEquals(username).getRoles();
    }

    @Override
    public List<Role> findRoleById(Integer id) {
        return userDao.findById(id).get().getRoles();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}

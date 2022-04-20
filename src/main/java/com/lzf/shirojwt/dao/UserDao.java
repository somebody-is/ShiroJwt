package com.lzf.shirojwt.dao;

import com.lzf.shirojwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    public User findByUsernameEquals(String username);

}

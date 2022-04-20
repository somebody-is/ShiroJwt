package com.lzf.shirojwt.dao;

import com.lzf.shirojwt.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Repository
public interface PermissionDao extends JpaRepository<Permission,Integer> {

}

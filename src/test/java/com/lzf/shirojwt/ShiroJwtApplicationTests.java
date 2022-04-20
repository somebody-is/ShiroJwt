package com.lzf.shirojwt;

import com.lzf.shirojwt.dao.RoleDao;
import com.lzf.shirojwt.model.Permission;
import com.lzf.shirojwt.model.Role;
import com.lzf.shirojwt.service.PermissionService;
import com.lzf.shirojwt.service.RoleService;
import com.lzf.shirojwt.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ShiroJwtApplicationTests {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Test
    void testAddPermission() {
        Permission permission=new Permission();
        permission.setPermission("user:select:*");
        permission.setDescription("管理所有用户权限");
        permission.setCreateTime(new Date());
        permission.setUpdatedTime(new Date());
        permissionService.save(permission);
    }

    @Test
    void testAddRole(){
        String[]roles={"superAdmin","admin","user"};
        String[]description={"超级管理员","管理员","用户"};
        for(int i=0;i<roles.length;i++){
            Role role = new Role();
            role.setRole(roles[i]);
            role.setDescription(description[i]);
            roleService.save(role);
        }
    }

    @Test
    void testAddUser() throws Exception {
        String token = JwtUtils.sign(2);
        System.out.println("token:"+token);
        Integer id = JwtUtils.getId(token);
        System.out.println(id);
    }

}

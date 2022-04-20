package com.lzf.shirojwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "role_permission")
public class RolePermission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rp_role_id")
    private Integer roleId;

    @Column(name = "rp_permission_id")
    private Integer permissionId;

    @Column(name = "rp_createTime")
    private Date createTime;

    @Column(name = "rp_updatedTime")
    private Date updatedTime;
}

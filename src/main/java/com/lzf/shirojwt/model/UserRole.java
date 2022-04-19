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
@Table(name = "user_role")
public class UserRole  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ur_user_id")
    private Integer userId;

    @Column(name = "ur_role_id")
    private Integer roleId;

    @Column(name = "ur_createTime")
    private Date createTime;

    @Column(name = "ur_updatedTime")
    private Date updatedTime;
}

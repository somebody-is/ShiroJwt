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
public class Permission  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "p_permission")
    private String permission;

    @Column(name = "p_description")
    private String description;

    @Column(name = "p_createTime")
    private Date createTime;

    @Column(name = "p_updatedTime")
    private Date updatedTime;
}

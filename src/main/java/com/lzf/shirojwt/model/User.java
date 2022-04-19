package com.lzf.shirojwt.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_salt")
    private String salt;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "ur_user_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ur_role_id", referencedColumnName = "id")}
    )
    private List<Role>roles;
}

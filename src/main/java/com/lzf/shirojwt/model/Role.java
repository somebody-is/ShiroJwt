package com.lzf.shirojwt.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Role  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "r_role")
    private String role;

    @Column(name = "r_description")
    private String description;

    @Column(name = "r_createTime")
    private Date createTime;

    @Column(name = "r_updatedTime")
    private Date updatedTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "rp_role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rp_permission_id", referencedColumnName = "id")}
    )
    private List<Permission>permissions;

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {return false;}
        Role role = (Role) o;
        return id != null && Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

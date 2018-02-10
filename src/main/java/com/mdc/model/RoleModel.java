package com.mdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleModel implements Serializable {

    private static final long serialVersionUID = -678459308073021475L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "permission_id")
    )
    private Set<PermissionModel> permissions;

    public long getRoleId() {
        return roleId;
    }

    public RoleModel setRoleId(long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleModel setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PermissionModel> getPermissions() {
        return permissions;
    }

    public RoleModel setPermissions(Set<PermissionModel> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return roleId == roleModel.roleId &&
                Objects.equals(name, roleModel.name) &&
                Objects.equals(permissions, roleModel.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, name, permissions);
    }
}

package cc.ant.user.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: user_service
 * @description: 权限表
 * @Author: XINGUOZ
 * @date: 2019-05-02 13:26
 */
@Entity
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;//名称.
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType;//资源类型，[menu|button]
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private Long parentId; //父编号
    private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;

    private Date PERMISSCREATETIME;

    private Date PERMISSUPDATETIME;

    @ManyToMany
    @JoinTable(name="SysPermissionRole",joinColumns ={@JoinColumn(name="permissionId")},inverseJoinColumns = {@JoinColumn(name="rolesId")})
    private List<SysRole> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Date getPERMISSCREATETIME() {
        return PERMISSCREATETIME;
    }

    public void setPERMISSCREATETIME(Date PERMISSCREATETIME) {
        this.PERMISSCREATETIME = PERMISSCREATETIME;
    }

    public Date getPERMISSUPDATETIME() {
        return PERMISSUPDATETIME;
    }

    public void setPERMISSUPDATETIME(Date PERMISSUPDATETIME) {
        this.PERMISSUPDATETIME = PERMISSUPDATETIME;
    }
}

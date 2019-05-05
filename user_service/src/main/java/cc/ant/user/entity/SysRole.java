package cc.ant.user.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @program: user_service
 * @description: 角色表
 * @Author: XINGUOZ
 * @date: 2019-05-02 12:59
 */
@Entity
public class SysRole implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)  //与用户表形成多对多
    @JoinTable(name="SysUserRole" ,joinColumns = {@JoinColumn (name="roleId")},inverseJoinColumns = {@JoinColumn(name="uid")})
    private List<User> users;

    @ManyToMany
    @JoinTable(name="SysPermissionRole",joinColumns ={@JoinColumn(name="roleId")},inverseJoinColumns = {@JoinColumn(name="permissionId")})
    private List<SysPermission>  permissions;

    private Date ROLECREATETIME;

    private Date ROLEUPDATETIME;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public Date getROLECREATETIME() {
        return ROLECREATETIME;
    }

    public void setROLECREATETIME(Date ROLECREATETIME) {
        this.ROLECREATETIME = ROLECREATETIME;
    }

    public Date getROLEUPDATETIME() {
        return ROLEUPDATETIME;
    }

    public void setROLEUPDATETIME(Date ROLEUPDATETIME) {
        this.ROLEUPDATETIME = ROLEUPDATETIME;
    }
}

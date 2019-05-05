package cc.ant.user.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @program: user_service
 * @description:
 * @Author: XINGUOZ
 * @date: 2019-05-02 12:53
 */
@Entity
public class User implements Serializable {

    @GeneratedValue
    @Id
    private Integer uid; //主键dd
    @Column(unique = true)
    private String username;  //用户名
    private String password;  //密码
    private String name;      //名字昵称
    private String salt;       //加盐码
    private byte state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name="uid")},inverseJoinColumns = {@JoinColumn(name="roleId")})
    List<SysRole> roleList;

    @Column(name="updatetime")
    private Date USERCREATETIME;
    @Column(name="usercreatetime")
    private Date UPDATETIME;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
      return roleList;
    }

    public Date getUSERCREATETIME() {
        return USERCREATETIME;
    }

    public void setUSERCREATETIME(Date USERCREATETIME) {
        this.USERCREATETIME = USERCREATETIME;
    }

    public Date getUPDATETIME() {
        return UPDATETIME;
    }

    public void setUPDATETIME(Date UPDATETIME) {
        this.UPDATETIME = UPDATETIME;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}

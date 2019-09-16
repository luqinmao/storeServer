package com.lqm.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "store_user")
public class User {
    /**
     * 用户表id
     */
    @Id
    private Integer id;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码，MD5加密
     */
    private String password;

    private String email;

    private String phone;

    /**
     * 找回密码问题
     */
    private String question;

    /**
     * 找回密码答案
     */
    private String answer;

    /**
     * 角色0-管理员,1-普通用户
     */
    private Integer role;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public User(Integer id, String photo, String username, String password, String email, String phone, String question, String answer, Integer role, Date createTime, Date updateTime) {
        this.id = id;
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.question = question;
        this.answer = answer;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    /**
     * 获取用户表id
     *
     * @return id - 用户表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户表id
     *
     * @param id 用户表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户头像
     *
     * @return photo - 用户头像
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置用户头像
     *
     * @param photo 用户头像
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取用户密码，MD5加密
     *
     * @return password - 用户密码，MD5加密
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码，MD5加密
     *
     * @param password 用户密码，MD5加密
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取找回密码问题
     *
     * @return question - 找回密码问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置找回密码问题
     *
     * @param question 找回密码问题
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * 获取找回密码答案
     *
     * @return answer - 找回密码答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置找回密码答案
     *
     * @param answer 找回密码答案
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * 获取角色0-管理员,1-普通用户
     *
     * @return role - 角色0-管理员,1-普通用户
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置角色0-管理员,1-普通用户
     *
     * @param role 角色0-管理员,1-普通用户
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
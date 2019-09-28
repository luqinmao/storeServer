package com.lqm.pojo;

import org.apache.ibatis.annotations.Mapper;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "store_shipping")
public class Shipping {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 收货姓名
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收货固定电话
     */
    @Column(name = "receiver_phone")
    private String receiverPhone;

    /**
     * 收货移动电话
     */
    @Column(name = "receiver_mobile")
    private String receiverMobile;

    /**
     * 省份
     */
    @Column(name = "receiver_province")
    private String receiverProvince;

    /**
     * 城市
     */
    @Column(name = "receiver_city")
    private String receiverCity;

    /**
     * 区/县
     */
    @Column(name = "receiver_district")
    private String receiverDistrict;

    /**
     * 详细地址
     */
    @Column(name = "receiver_address")
    private String receiverAddress;

    /**
     * 邮编
     */
    @Column(name = "receiver_zip")
    private String receiverZip;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 默认地址
     */
    @Column(name = "is_default")
    private boolean isDefault;


    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取收货姓名
     *
     * @return receiver_name - 收货姓名
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收货姓名
     *
     * @param receiverName 收货姓名
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取收货固定电话
     *
     * @return receiver_phone - 收货固定电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 设置收货固定电话
     *
     * @param receiverPhone 收货固定电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * 获取收货移动电话
     *
     * @return receiver_mobile - 收货移动电话
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     * 设置收货移动电话
     *
     * @param receiverMobile 收货移动电话
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     * 获取省份
     *
     * @return receiver_province - 省份
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     * 设置省份
     *
     * @param receiverProvince 省份
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     * 获取城市
     *
     * @return receiver_city - 城市
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     * 设置城市
     *
     * @param receiverCity 城市
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     * 获取区/县
     *
     * @return receiver_district - 区/县
     */
    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    /**
     * 设置区/县
     *
     * @param receiverDistrict 区/县
     */
    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    /**
     * 获取详细地址
     *
     * @return receiver_address - 详细地址
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * 设置详细地址
     *
     * @param receiverAddress 详细地址
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * 获取邮编
     *
     * @return receiver_zip - 邮编
     */
    public String getReceiverZip() {
        return receiverZip;
    }

    /**
     * 设置邮编
     *
     * @param receiverZip 邮编
     */
    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip;
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


    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
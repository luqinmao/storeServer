package com.lqm.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "store_order")
public class Order {
    /**
     * 订单id
     */
    @Id
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "order_no")
    private Long orderNo;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "shipping_id")
    private Integer shippingId;

    /**
     * 实际付款金额,单位是元,保留两位小数
     */
    private BigDecimal payment;

    /**
     * 支付类型,1-在线支付
     */
    @Column(name = "payment_type")
    private Integer paymentType;

    /**
     * 运费,单位是元
     */
    private Integer postage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    private Integer status;

    /**
     * 支付时间
     */
    @Column(name = "payment_time")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "close_time")
    private Date closeTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return order_no - 订单号
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * 设置订单号
     *
     * @param orderNo 订单号
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
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
     * @return shipping_id
     */
    public Integer getShippingId() {
        return shippingId;
    }

    /**
     * @param shippingId
     */
    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    /**
     * 获取实际付款金额,单位是元,保留两位小数
     *
     * @return payment - 实际付款金额,单位是元,保留两位小数
     */
    public BigDecimal getPayment() {
        return payment;
    }

    /**
     * 设置实际付款金额,单位是元,保留两位小数
     *
     * @param payment 实际付款金额,单位是元,保留两位小数
     */
    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    /**
     * 获取支付类型,1-在线支付
     *
     * @return payment_type - 支付类型,1-在线支付
     */
    public Integer getPaymentType() {
        return paymentType;
    }

    /**
     * 设置支付类型,1-在线支付
     *
     * @param paymentType 支付类型,1-在线支付
     */
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取运费,单位是元
     *
     * @return postage - 运费,单位是元
     */
    public Integer getPostage() {
        return postage;
    }

    /**
     * 设置运费,单位是元
     *
     * @param postage 运费,单位是元
     */
    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    /**
     * 获取订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     *
     * @return status - 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     *
     * @param status 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取支付时间
     *
     * @return payment_time - 支付时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置支付时间
     *
     * @param paymentTime 支付时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取发货时间
     *
     * @return send_time - 发货时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 设置发货时间
     *
     * @param sendTime 发货时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取交易完成时间
     *
     * @return end_time - 交易完成时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置交易完成时间
     *
     * @param endTime 交易完成时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取交易关闭时间
     *
     * @return close_time - 交易关闭时间
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置交易关闭时间
     *
     * @param closeTime 交易关闭时间
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
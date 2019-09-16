package com.lqm.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "store_order_item")
public class OrderItem {
    /**
     * 订单子表id
     */
    @Id
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "order_no")
    private Long orderNo;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品图片地址
     */
    @Column(name = "product_image")
    private String productImage;

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数
     */
    @Column(name = "current_unit_price")
    private BigDecimal currentUnitPrice;

    /**
     * 商品数量
     */
    private Integer quantity;

    /**
     * 商品总价,单位是元,保留两位小数
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单子表id
     *
     * @return id - 订单子表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单子表id
     *
     * @param id 订单子表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return order_no
     */
    public Long getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     */
    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 获取商品id
     *
     * @return product_id - 商品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商品图片地址
     *
     * @return product_image - 商品图片地址
     */
    public String getProductImage() {
        return productImage;
    }

    /**
     * 设置商品图片地址
     *
     * @param productImage 商品图片地址
     */
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    /**
     * 获取生成订单时的商品单价，单位是元,保留两位小数
     *
     * @return current_unit_price - 生成订单时的商品单价，单位是元,保留两位小数
     */
    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    /**
     * 设置生成订单时的商品单价，单位是元,保留两位小数
     *
     * @param currentUnitPrice 生成订单时的商品单价，单位是元,保留两位小数
     */
    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    /**
     * 获取商品数量
     *
     * @return quantity - 商品数量
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置商品数量
     *
     * @param quantity 商品数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取商品总价,单位是元,保留两位小数
     *
     * @return total_price - 商品总价,单位是元,保留两位小数
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置商品总价,单位是元,保留两位小数
     *
     * @param totalPrice 商品总价,单位是元,保留两位小数
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
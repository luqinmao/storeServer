package com.lqm.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "store_product")
public class Product {
    /**
     * 商品id
     */
    @Id
    private Integer id;

    /**
     * 分类id,对应store_category表的主键
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品副标题
     */
    private String subtitle;

    /**
     * 产品主图,url相对地址
     */
    @Column(name = "main_image")
    private String mainImage;

    /**
     * 价格,单位-元保留两位小数
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 商品状态.1-在售 2-下架 3-删除
     */
    private Integer status;

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
     * 图片地址,json格式,扩展用
     */
    @Column(name = "sub_images")
    private String subImages;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 获取商品id
     *
     * @return id - 商品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品id
     *
     * @param id 商品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类id,对应store_category表的主键
     *
     * @return category_id - 分类id,对应store_category表的主键
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id,对应store_category表的主键
     *
     * @param categoryId 分类id,对应store_category表的主键
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取商品副标题
     *
     * @return subtitle - 商品副标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 设置商品副标题
     *
     * @param subtitle 商品副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 获取产品主图,url相对地址
     *
     * @return main_image - 产品主图,url相对地址
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * 设置产品主图,url相对地址
     *
     * @param mainImage 产品主图,url相对地址
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    /**
     * 获取价格,单位-元保留两位小数
     *
     * @return price - 价格,单位-元保留两位小数
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格,单位-元保留两位小数
     *
     * @param price 价格,单位-元保留两位小数
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取库存数量
     *
     * @return stock - 库存数量
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存数量
     *
     * @param stock 库存数量
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取商品状态.1-在售 2-下架 3-删除
     *
     * @return status - 商品状态.1-在售 2-下架 3-删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置商品状态.1-在售 2-下架 3-删除
     *
     * @param status 商品状态.1-在售 2-下架 3-删除
     */
    public void setStatus(Integer status) {
        this.status = status;
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

    /**
     * 获取图片地址,json格式,扩展用
     *
     * @return sub_images - 图片地址,json格式,扩展用
     */
    public String getSubImages() {
        return subImages;
    }

    /**
     * 设置图片地址,json格式,扩展用
     *
     * @param subImages 图片地址,json格式,扩展用
     */
    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    /**
     * 获取商品详情
     *
     * @return detail - 商品详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置商品详情
     *
     * @param detail 商品详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
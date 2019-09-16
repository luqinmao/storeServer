package com.lqm.dao;

import com.lqm.pojo.Product;
import com.lqm.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends MyMapper<Product> {


    List<Product> selectList();

    List<Product> selectByNameAndProductId(@Param("productName")String productName, @Param("productId") Integer productId);

    List<Product> selectByNameAndCategoryIds(@Param("productName")String productName,@Param("categoryIdList")List<Integer> categoryIdList);


    //这里一定要用Integer，因为int无法为NULL，考虑到很多商品已经删除的情况。
    Integer selectStockByProductId(Integer id);



}
package com.lqm.dao;

import com.lqm.pojo.OrderItem;
import com.lqm.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemMapper extends MyMapper<OrderItem> {
    //

    List<OrderItem> getByOrderNoUserId(@Param("orderNo") Long orderNo, @Param("userId") Integer userId);

    List<OrderItem> getByOrderNo(@Param("orderNo") Long orderNo);

    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);

}
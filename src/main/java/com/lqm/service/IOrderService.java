package com.lqm.service;

import com.github.pagehelper.PageInfo;
import com.lqm.common.ServerResponse;
import com.lqm.vo.OrderVo;

import java.util.Map;

/**
 * Created by geely
 */
public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId);
    ServerResponse aliCallback(Map<String, String> params);
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);
    ServerResponse createOrderByCard(Integer userId, Integer shippingId);
    ServerResponse createOrderDirect(int userId,long productId,int quantity,Integer shippingId);
    ServerResponse<String> cancel(Integer userId, Long orderNo);
    ServerResponse getOrderCartProduct(Integer userId);
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
    ServerResponse<PageInfo> getOrderList(Integer userId,Integer status, int pageNum, int pageSize);
    ServerResponse confirmReceivedGoods(Integer userId, Long orderNo);


    //backend
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);
    ServerResponse<String> manageSendGoods(Long orderNo);

    //hour个小时以内未付款的订单，进行关闭
    void closeOrder(int hour);


}

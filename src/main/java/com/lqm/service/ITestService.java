package com.lqm.service;

import com.github.pagehelper.PageInfo;
import com.lqm.common.ServerResponse;
import com.lqm.pojo.User;

import java.util.List;

/**
 * 测试例子专用
 */
public interface ITestService {

    /**
     * 测试pager分页功能
     * @param pageNum 第几页  从1开始
     * @param pageSize 一页返回多少条数据
     * @return
     */
    ServerResponse<PageInfo> testPageHelp(int pageNum, int pageSize);


    ServerResponse<List<User>> testRedisCache();
}

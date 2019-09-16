package com.lqm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqm.common.ServerResponse;
import com.lqm.dao.UserMapper;
import com.lqm.pojo.Order;
import com.lqm.pojo.User;
import com.lqm.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by HAL on 2019/1/11.
 */
@Service("iTestService")
public class TestServiceImpl implements ITestService {

    @Autowired
    UserMapper userMapper;


    @Override
    public ServerResponse<PageInfo> testPageHelp(int pageNum,int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectAll();
        PageInfo pageResult = new PageInfo(users);
//        pageResult.setList(users);

        return ServerResponse.createBySuccess(pageResult);
    }


    @Cacheable(cacheNames = "testRedisCache")
    @Override
    public ServerResponse<List<User>> testRedisCache() {
        List<User> users = userMapper.selectAll();
        return ServerResponse.createBySuccess(users);
    }
}

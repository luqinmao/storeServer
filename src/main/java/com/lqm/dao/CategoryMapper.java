package com.lqm.dao;

import com.lqm.pojo.Category;
import com.lqm.util.MyMapper;

import java.util.List;

public interface CategoryMapper extends MyMapper<Category> {

    List<Category> selectCategoryChildrenByParentId(Integer parentId);


}
package com.lqm.service;


import com.lqm.common.ServerResponse;
import com.lqm.pojo.Category;

import java.util.List;

/**
 * Created by geely
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

    ServerResponse<List<Category>> getCategoryList();


}

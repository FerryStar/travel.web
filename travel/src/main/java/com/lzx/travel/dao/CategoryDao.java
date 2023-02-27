package com.lzx.travel.dao;

import com.lzx.travel.domain.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> findAll();  //查询所有
}

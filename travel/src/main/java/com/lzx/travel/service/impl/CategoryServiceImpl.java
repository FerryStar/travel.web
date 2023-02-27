package com.lzx.travel.service.impl;

import com.lzx.travel.dao.CategoryDao;
import com.lzx.travel.dao.impl.CategoryDaoImpl;
import com.lzx.travel.domain.Category;
import com.lzx.travel.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao=new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}

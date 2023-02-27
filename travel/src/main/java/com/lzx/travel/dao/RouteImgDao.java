package com.lzx.travel.dao;

import com.lzx.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    public List<RouteImg> findByrid(int rid);  //根据route的id查询详情中的图片集合
}

package com.lzx.travel.service;

import com.lzx.travel.domain.PageBean;
import com.lzx.travel.domain.Route;

public interface RouteService {

    public PageBean<Route> pageQ(int cid,int currentPage,int pageSize,String rname);  //根据类型进行分页查询

    public Route findDetail(String rid);  //根据id查询旅游线路的详细信息
}

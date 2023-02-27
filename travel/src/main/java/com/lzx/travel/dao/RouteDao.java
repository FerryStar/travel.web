package com.lzx.travel.dao;

import com.lzx.travel.domain.Route;

import java.util.List;

public interface RouteDao {

    public int findTotalCount(int cid,String rname);  //根据cid查询总记录数

    public List<Route> findByPage(int cid, int start, int pageSize,String rname);  //根据cid start pageSize查询当前页的数据集合

    public Route findDetail(int rid);  //根据id查询 详细信息
}

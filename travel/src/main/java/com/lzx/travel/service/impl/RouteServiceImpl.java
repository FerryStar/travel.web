package com.lzx.travel.service.impl;

import com.lzx.travel.dao.RouteDao;
import com.lzx.travel.dao.RouteImgDao;
import com.lzx.travel.dao.SellerDao;
import com.lzx.travel.dao.impl.RouteDaoImpl;
import com.lzx.travel.dao.impl.RouteImgDaoImpl;
import com.lzx.travel.dao.impl.SellerDaoImpl;
import com.lzx.travel.domain.PageBean;
import com.lzx.travel.domain.Route;
import com.lzx.travel.domain.RouteImg;
import com.lzx.travel.domain.Seller;
import com.lzx.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();

    @Override
    public PageBean<Route> pageQ(int cid, int currentPage, int pageSize, String rname) {
        //封装PageBean
        PageBean<Route> pb = new PageBean<Route>();
        pb.setCurrentPage(currentPage);  //设置当前页码
        pb.setPageSize(pageSize);  //设置每页显示条数

        //设置总记录数
        int totalCount = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);
        //设置当前页显示的数据集合
        int start = (currentPage - 1) * pageSize;  //开始的记录数
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pb.setList(list);
        //设置总页数 =总记录数/每页显示条数
        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    @Override
    public Route findDetail(String rid) {
        //1、根据id去route表中查询route对象
        Route route = routeDao.findDetail(Integer.parseInt(rid));

        //2、根据route的id查询图片集合
        List<RouteImg> routeImgList = routeImgDao.findByrid(route.getRid());
        //将集合设置到route对象
        route.setRouteImgList(routeImgList);

        //3、根据sid查询商家信息
        Seller seller = sellerDao.findById(route.getSid());
        route.setSeller(seller);

        return route;
    }
}

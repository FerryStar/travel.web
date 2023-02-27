package com.lzx.travel.web.servlet;

import com.lzx.travel.domain.PageBean;
import com.lzx.travel.domain.Route;
import com.lzx.travel.service.RouteService;
import com.lzx.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService routeService = new RouteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");

        //接收rname，线路查询时输入的名称
        String rname = request.getParameter("rname");
        if ("null".equals(rname)) {
            rname = null;
        } else {
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }

        //2、处理参数
        int cid = 0;  //类别id
        if (cidStr != null && cidStr.length() > 0 && !"null".equals(cidStr)) {
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;  //当前页码,默认为1
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int pageSize = 0;  //每页显示条数，默认每页显示5条
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        //3、调用service查询PageBean对象
        PageBean<Route> pb = routeService.pageQ(cid, currentPage, pageSize, rname);

        //4、将PageBean对象序列化为json，返回
        writeValue(pb, response);

    }

    /**
     * 根据id查询一个旅游线路的 详细信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、接收id
        String rid = request.getParameter("rid");
        //2、调用service查询
        Route route = routeService.findDetail(rid);
        //3、转为json写回客户端
        writeValue(route, response);
    }


}

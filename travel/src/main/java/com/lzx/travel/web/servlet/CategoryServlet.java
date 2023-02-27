package com.lzx.travel.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzx.travel.domain.Category;
import com.lzx.travel.service.CategoryService;
import com.lzx.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();

    /**
     * 查询所有
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、调用service来查询所有
        List<Category> cs = service.findAll();
        //2、序列化json返回
        writeValue(cs, resp);  //父类baseServlet已经封装
    }
}

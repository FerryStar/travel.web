package com.lzx.travel.dao.impl;

import com.lzx.travel.dao.SellerDao;
import com.lzx.travel.domain.RouteImg;
import com.lzx.travel.domain.Seller;
import com.lzx.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SellerDaoImpl implements SellerDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public Seller findById(int id) {
        String sql = "select * from tab_seller where sid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), id);
    }
}

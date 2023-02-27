package com.lzx.travel.dao.impl;

import com.lzx.travel.dao.RouteDao;
import com.lzx.travel.domain.Route;
import com.lzx.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询总记录数
     *
     * @param cid
     * @return
     */
    public int findTotalCount(int cid, String rname) {
        //String sql = "select count(*) from tab_route where cid = ?";
        //1、定义sql模板
        String sql = "select count(*) from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        //2、判断哪个参数有值
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);  //添加？对应的值
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sql = sb.toString();

        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    /**
     * 分页查询
     *
     * @param cid
     * @param start
     * @param pageSize
     * @return
     */
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //String sql = "select * from tab_route where cid = ? limit ? , ?";
        //1、定义sql模板
        String sql = "select * from tab_route where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        //2、判断哪个参数有值
        if (cid != 0) {
            sb.append(" and cid = ? ");
            params.add(cid);  //添加？对应的值
        }
        if (rname != null && rname.length() > 0) {
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sb.append(" limit ? , ? ");  //分页条件
        sql = sb.toString();

        params.add(start);
        params.add(pageSize);

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    /**
     * 根据id查询旅游线路的详细信息
     *
     * @param rid
     * @return
     */
    public Route findDetail(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }
}

package com.lzx.travel.dao;

import com.lzx.travel.domain.Seller;

public interface SellerDao {

    public Seller findById(int id);  //根据商家sid查询
}

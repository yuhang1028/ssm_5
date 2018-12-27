package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersMapper {

   List<Orders>  findAll() throws Exception;

    void delete(Orders orders) throws Exception;

    void updateStatus(Orders orders)throws Exception;
}

package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

public interface OrdersMapper {

   List<Orders>  findAll(Orders orders) throws Exception;

    void delete(Orders orders) throws Exception;

    void updateStatus(Orders orders)throws Exception;

    Orders findById(String id) throws Exception;
}

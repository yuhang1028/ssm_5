package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrdersMapper;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
  private OrdersMapper ordersMapper ;
    @Override
    public List<Orders> findAll(Integer pageNum,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        List<Orders> orders = ordersMapper.findAll();
        return orders;
    }

    @Override
    public void delete(Orders orders) throws Exception {
        ordersMapper.delete(orders);
    }

    @Override
    public void updateStatus(Orders orders) throws Exception {
        ordersMapper.updateStatus(orders);
    }
}

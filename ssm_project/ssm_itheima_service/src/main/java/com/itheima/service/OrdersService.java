package com.itheima.service;

import com.itheima.domain.Orders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrdersService {
    /**
     * 分页查询
     * @param pageNum 当前页
     * @param pageSize 每页查询条数
     * @return
     * @throws Exception
     */
    List<Orders> findAll(Integer pageNum,Integer pageSize) throws Exception;

    /**
     * 删除
     * @param orders
     * @throws Exception
     */
    void delete(Orders orders)throws Exception;

    /**
     * 修改状态为已支付
     * @param orders
     */
    void updateStatus(Orders orders) throws Exception;
}

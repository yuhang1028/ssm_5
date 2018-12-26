package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {
    /**
     * 查询所有
     * @return
     * @throws Exception
     * @param product
     */
    List<Product> findAll(Product product) throws Exception;

    /**
     * 修改状态
     * @param product
     */
    void updateStatus(Product product) throws Exception;

    /**
     * 设置编号
     * @return
     * @throws Exception
     */
    String check() throws Exception;

    /**
     * 添加产品信息
     * @param p
     */
    void save(Product p) throws Exception;

    /**
     * 删除产品信息
     * @param productNum
     */
    void delete(String[] productNum) throws Exception;
}

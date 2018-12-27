package com.itheima.mapper;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findAll(Product productName) throws Exception;

    void updateStatus(Product product) throws Exception;

    String check() throws Exception;

    void save(Product p)throws Exception;

    void delete(String id) throws Exception;
}

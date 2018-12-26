package com.itheima.service.impl;

import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
   @Autowired
    private ProductMapper mapper;
    @Override
    public List<Product> findAll(Product product) throws Exception {
        List<Product> productList = mapper.findAll(product);
        System.out.println(productList);
        return productList;
    }

    @Override
    public void updateStatus(Product product) throws Exception {
        mapper.updateStatus(product);
    }

    @Override
    public String check() throws Exception {
        String checkNum = mapper.check();
        return checkNum;
    }

    @Override
    public void save(Product p)throws Exception {
       mapper.save(p);
    }

    @Override
    public void delete(String[] productNum) throws Exception {
        for (String s : productNum) {
            mapper.delete(s);
        }
    }
}

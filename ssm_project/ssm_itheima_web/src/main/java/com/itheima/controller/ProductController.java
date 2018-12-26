package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
   @Autowired
    private ProductService productService;

    /**
     * 查询所有
     * @param model
     * @return
     * @throws Exception
     */
   @RequestMapping("/findAll")
   public String findAll(Model model, Product product)throws Exception {

       List<Product> productList = productService.findAll(product);
       model.addAttribute("productList",productList);
       model.addAttribute("product",product);
       return "product-list";
   }

    /**
     *修改状态
     * @return
     */
   @RequestMapping("/updateStatus")
   public String updateStatus(Model model,Product product) throws Exception {
       productService.updateStatus(product);
       findAll(model,product);
       return "forward:/product/findAll";
   }
    /**
     * 设置产品编号
     */
    @RequestMapping("/productNum")
    public String check(Model model) throws Exception {
        String productNum = productService.check();//itcast-003
        String s = productNum.split("-")[1];
        int a = Integer.parseInt(s)+1;
        productNum = "itcast-"+a;
        model.addAttribute("productNum",productNum);
        return "product-add";
    }

    /**
     * 添加信息
     * @param p
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String save(Product p, HttpServletRequest request)throws Exception{
        productService.save(p);
       return "redirect:/product/findAll";
    }
    /**
     * 删除信息
     */
    @RequestMapping("/delete")
    public String delete( String[] productNum) throws Exception {
        productService.delete(productNum);
        return "redirect:/product/findAll";
    }


}

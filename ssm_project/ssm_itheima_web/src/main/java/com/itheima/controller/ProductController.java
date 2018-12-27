package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * @param product 模糊查询条件
     * @return
     * @throws Exception
     */
   @RequestMapping("/findAll")
   public String findAll(Model model, Product product,
               @RequestParam(required = false,defaultValue = "1") Integer pageNum,
               @RequestParam(required = false,defaultValue = "4") Integer pageSize)throws Exception {

       List<Product> productList = productService.findAll(product,pageNum,pageSize);
       //将数据封装到pageHelper
       PageInfo pageInfo = new PageInfo(productList);
       model.addAttribute("pageInfo",pageInfo);
       //吧productNum数据保存到request域中 product里封装了模糊查询条件,供前端改变状态的代码获取productName
       //把数据传输到controller中,用于updateStatus方法调用findAll方法的参数,保证查询的是修改了状态的数据.
       model.addAttribute("product",product);
       return "product-list";
   }

    /**
     *修改状态
     * @return
     */
   @RequestMapping("/updateStatus")
   public String updateStatus(Model model,Product product,Integer pageNum,Integer pageSize ) throws Exception {
       productService.updateStatus(product);
       this.findAll(model,product,pageNum,pageSize);
       return "product-list";
//       return "redirect:/product/findAll";
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
    public String delete( String[] id) throws Exception {
        productService.delete(id);
        return "redirect:/product/findAll";
    }


}

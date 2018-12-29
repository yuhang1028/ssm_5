package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 分页模糊查询
     * @param pageNum
     * @param pageSize
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(required = false,defaultValue = "1")Integer pageNum,@RequestParam(required = false,defaultValue = "4")Integer pageSize,Orders orders) throws Exception {
        ModelAndView mv = new ModelAndView();
        //调用方法获取结果集
        List<Orders> ordersList = ordersService.findAll(pageNum, pageSize,orders);
        //把结果集封装到pageInfo中
        PageInfo<Orders> page = PageInfo.of(ordersList);
        //把page保存到request域中
        mv.addObject("page",page);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 删除
     * @param orders
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(Orders orders) throws  Exception{
        ordersService.delete(orders);
        return "redirect:/orders/findAll";
    }

    /**
     * 修改状态
     * @param orders
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateStatus")
    public String updateStatus(Orders orders) throws Exception {
        ordersService.updateStatus(orders);
        return "redirect:/orders/findAll";
    }

    /**
     * 详情查询
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public String findOrdersByid(Model model , String id)throws Exception{
        System.out.println("------------------");
        System.out.println(id);
        System.out.println("------------------");
       Orders orders = ordersService.findById(id);
       model.addAttribute("orders",orders);
        return "orders-show";
    }

}

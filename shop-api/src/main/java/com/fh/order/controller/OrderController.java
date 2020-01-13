package com.fh.order.controller;

import com.fh.common.ServerResponse;
import com.fh.member.model.Member;
import com.fh.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //创建订单的API接口
    @RequestMapping("addOrder")
    public ServerResponse addOrder(Long uuid,HttpServletRequest request){
        try {
            Member loginMember = (Member) request.getAttribute("loginMember");
            ServerResponse serverResponse = orderService.addOrder(uuid,loginMember.getId());
            return serverResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }
    }

}

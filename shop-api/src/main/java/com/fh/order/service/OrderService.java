package com.fh.order.service;


import com.fh.common.ServerResponse;
import com.fh.order.model.Order;

public interface OrderService {
    ServerResponse addOrder(Long uuid,Integer id);

    void updateOrder(Order order);
}

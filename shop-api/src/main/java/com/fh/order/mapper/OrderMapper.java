package com.fh.order.mapper;


import com.fh.order.model.Order;
import com.fh.order.model.OrderItem;

import java.util.List;

public interface OrderMapper {
    void addOrder(Order order);

    void addOrderItemList(List<OrderItem> orderItemList);

    void addOrderId(String orderId);

    void updateOrder(Order order);
}

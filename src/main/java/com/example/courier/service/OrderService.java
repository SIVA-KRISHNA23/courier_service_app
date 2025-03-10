package com.example.courier.service;

import com.example.courier.dto.OrderDto;
import com.example.courier.dto.OrderStatusResponse;
import java.util.List;

public interface OrderService {
	
	
    List<OrderDto> getAllOrders();
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    OrderDto updateOrder(Long id, OrderDto orderDto);
    boolean deleteOrder(Long id); // Ensure this returns boolean
}

package com.example.courier.service.impl;

import com.example.courier.dao.OrderRepository;
import com.example.courier.dto.OrderDto;
import com.example.courier.model.Order;
import com.example.courier.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = convertToEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return convertToDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        return order != null ? convertToDto(order) : null;
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if (existingOrder != null) {
            existingOrder.setDescription(orderDto.getDescription());
            existingOrder.setStatus(orderDto.getStatus());
            orderRepository.save(existingOrder);
            return convertToDto(existingOrder);
        }
        return null;
    }

    @Override
    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Helper method to convert Order entity to OrderDto
    private OrderDto convertToDto(Order order) {
        return new OrderDto(order.getId(), order.getDescription(), order.getStatus());
    }

    // Helper method to convert OrderDto to Order entity
    private Order convertToEntity(OrderDto orderDto) {
        return new Order(orderDto.getId(), orderDto.getDescription(), orderDto.getStatus());
    }
}

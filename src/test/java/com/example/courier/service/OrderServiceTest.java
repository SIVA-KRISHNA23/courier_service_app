package com.example.courier.service;

import com.example.courier.dao.OrderRepository;
import com.example.courier.dto.OrderDto;
import com.example.courier.model.Order;
import com.example.courier.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOrders() {
        // Mock data
        Order order1 = new Order(1L, "Description 1", "Pending");
        Order order2 = new Order(2L, "Description 2", "Delivered");
        Mockito.when(orderRepository.findAll()).thenReturn(Arrays.asList(order1, order2));

        // Call service method
        List<OrderDto> result = orderService.getAllOrders();

        // Assertions
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(order1.getDescription(), result.get(0).getDescription());
        Assertions.assertEquals(order2.getDescription(), result.get(1).getDescription());
    }

    @Test
    public void testGetOrderById() {
        // Mock data
        Long orderId = 1L;
        Order order = new Order(orderId, "Description", "Pending");
        Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        // Call service method
        OrderDto result = orderService.getOrderById(orderId);

        // Assertions
        Assertions.assertNotNull(result);
        Assertions.assertEquals(order.getDescription(), result.getDescription());
    }

    @Test
    public void testCreateOrder() {
        // Mock data
        OrderDto orderDto = new OrderDto(null, "New Order", "Pending");
        Order order = new Order(null, "New Order", "Pending");
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);

        // Call service method
        OrderDto createdOrder = orderService.createOrder(orderDto);

        // Assertions
        Assertions.assertNotNull(createdOrder);
        Assertions.assertEquals(order.getDescription(), createdOrder.getDescription());
    }

    @Test
    public void testUpdateOrder() {
        // Mock data
        Long orderId = 1L;
        OrderDto orderDto = new OrderDto(orderId, "Updated Order", "Delivered");
        Order existingOrder = new Order(orderId, "Original Order", "Pending");
        Mockito.when(orderRepository.findById(orderId)).thenReturn(Optional.of(existingOrder));
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(existingOrder);

        // Call service method
        OrderDto updatedOrder = orderService.updateOrder(orderId, orderDto);

        // Assertions
        Assertions.assertNotNull(updatedOrder);
        Assertions.assertEquals(orderDto.getDescription(), updatedOrder.getDescription());
        Assertions.assertEquals(orderDto.getStatus(), updatedOrder.getStatus());
    }

    @Test
    public void testDeleteOrder() {
        // Mock data
        Long orderId = 1L;
        Mockito.when(orderRepository.existsById(orderId)).thenReturn(true);

        // Call service method
        boolean deleted = orderService.deleteOrder(orderId);

        // Assertions
        Assertions.assertTrue(deleted);
    }

    @Test
    public void testDeleteOrderNotFound() {
        // Mock data
        Long orderId = 1L;
        Mockito.when(orderRepository.existsById(orderId)).thenReturn(false);

        // Call service method
        boolean deleted = orderService.deleteOrder(orderId);

        // Assertions
        Assertions.assertFalse(deleted);
    }
}

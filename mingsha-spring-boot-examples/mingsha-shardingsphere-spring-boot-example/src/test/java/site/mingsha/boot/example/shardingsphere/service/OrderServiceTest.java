package site.mingsha.boot.example.shardingsphere.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.mingsha.boot.example.shardingsphere.entity.Order;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    void testCreateAndGetOrder() {
        Order order = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order created = orderService.createOrder(order);
        assertNotNull(created.getOrderId());
        Order found = orderService.getOrder(created.getOrderId());
        assertNotNull(found);
        assertEquals("商品A", found.getProductName());
    }

    @Test
    void testGetOrdersByUserId() {
        Order order1 = new Order(2L, "商品B", new BigDecimal("199.99"), "NEW");
        Order order2 = new Order(2L, "商品C", new BigDecimal("299.99"), "PAID");
        orderService.createOrder(order1);
        orderService.createOrder(order2);
        List<Order> orders = orderService.getOrdersByUserId(2L);
        assertTrue(orders.size() >= 2);
    }

    @Test
    void testUpdateOrder() {
        Order order = new Order(3L, "商品D", new BigDecimal("399.99"), "NEW");
        Order created = orderService.createOrder(order);
        created.setStatus("PAID");
        created.setAmount(new BigDecimal("499.99"));
        Order updated = orderService.updateOrder(created);
        assertEquals("PAID", updated.getStatus());
        assertEquals(new BigDecimal("499.99"), updated.getAmount());
    }

    @Test
    void testDeleteOrder() {
        Order order = new Order(4L, "商品E", new BigDecimal("599.99"), "NEW");
        Order created = orderService.createOrder(order);
        boolean deleted = orderService.deleteOrder(created.getOrderId());
        assertTrue(deleted);
        assertNull(orderService.getOrder(created.getOrderId()));
    }
} 
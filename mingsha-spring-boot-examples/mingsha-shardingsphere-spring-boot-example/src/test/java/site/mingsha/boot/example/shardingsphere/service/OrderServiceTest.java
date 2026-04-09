package site.mingsha.boot.example.shardingsphere.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import site.mingsha.boot.example.shardingsphere.entity.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 订单服务测试 - 单元测试
 */
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setUp() throws Exception {
        // 清理静态数据
        var ordersField = OrderService.class.getDeclaredField("orders");
        ordersField.setAccessible(true);
        ((List<?>) ordersField.get(null)).clear();

        var idGenField = OrderService.class.getDeclaredField("idGen");
        idGenField.setAccessible(true);
        ((AtomicLong) idGenField.get(null)).set(1);
    }

    @Test
    void testCreateOrder() {
        // Given
        Order order = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");

        // When
        Order result = orderService.createOrder(order);

        // Then
        assertNotNull(result);
        assertNotNull(result.getOrderId());
        assertEquals("商品A", result.getProductName());
        assertEquals(new BigDecimal("99.99"), result.getAmount());
        assertEquals("NEW", result.getStatus());
    }

    @Test
    void testGetOrder() {
        // Given
        Order order = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order created = orderService.createOrder(order);

        // When
        Order result = orderService.getOrder(created.getOrderId());

        // Then
        assertNotNull(result);
        assertEquals(created.getOrderId(), result.getOrderId());
        assertEquals("商品A", result.getProductName());
    }

    @Test
    void testGetOrderNotFound() {
        // When
        Order result = orderService.getOrder(999L);

        // Then
        assertNull(result);
    }

    @Test
    void testGetOrdersByUserId() {
        // Given
        Order order1 = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order order2 = new Order(1L, "商品B", new BigDecimal("199.99"), "PAID");
        Order order3 = new Order(2L, "商品C", new BigDecimal("299.99"), "NEW");

        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);

        // When
        List<Order> results = orderService.getOrdersByUserId(1L);

        // Then
        assertNotNull(results);
        assertEquals(2, results.size());
        assertTrue(results.stream().allMatch(o -> o.getUserId().equals(1L)));
    }

    @Test
    void testGetAllOrders() {
        // Given
        Order order1 = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order order2 = new Order(2L, "商品B", new BigDecimal("199.99"), "PAID");

        orderService.createOrder(order1);
        orderService.createOrder(order2);

        // When
        List<Order> results = orderService.getAllOrders();

        // Then
        assertNotNull(results);
        assertEquals(2, results.size());
    }

    @Test
    void testUpdateOrder() {
        // Given
        Order order = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order created = orderService.createOrder(order);

        // When
        Order updateOrder = new Order();
        updateOrder.setOrderId(created.getOrderId());
        updateOrder.setProductName("更新后商品");
        updateOrder.setAmount(new BigDecimal("199.99"));
        updateOrder.setStatus("PAID");

        Order result = orderService.updateOrder(updateOrder);

        // Then
        assertNotNull(result);
        assertEquals("更新后商品", result.getProductName());
        assertEquals(new BigDecimal("199.99"), result.getAmount());
        assertEquals("PAID", result.getStatus());
    }

    @Test
    void testUpdateOrderNotFound() {
        // Given
        Order order = new Order();
        order.setOrderId(999L);
        order.setProductName("不存在的商品");

        // When
        Order result = orderService.updateOrder(order);

        // Then
        assertNull(result);
    }

    @Test
    void testDeleteOrder() {
        // Given
        Order order = new Order(1L, "商品A", new BigDecimal("99.99"), "NEW");
        Order created = orderService.createOrder(order);

        // When
        boolean result = orderService.deleteOrder(created.getOrderId());

        // Then
        assertTrue(result);
        assertNull(orderService.getOrder(created.getOrderId()));
    }

    @Test
    void testDeleteOrderNotFound() {
        // When
        boolean result = orderService.deleteOrder(999L);

        // Then
        assertFalse(result);
    }
}

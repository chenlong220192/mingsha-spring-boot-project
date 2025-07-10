package site.mingsha.boot.example.shardingsphere.service;

import org.springframework.stereotype.Service;
import site.mingsha.boot.example.shardingsphere.entity.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * 订单服务 - 演示分库分表操作（内存模拟）
 */
@Service
public class OrderService {
    private static final List<Order> orders = new ArrayList<>();
    private static final AtomicLong idGen = new AtomicLong(1);

    public Order createOrder(Order order) {
        order.setOrderId(idGen.getAndIncrement());
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        orders.add(order);
        return order;
    }

    public Order getOrder(Long orderId) {
        return orders.stream().filter(o -> Objects.equals(o.getOrderId(), orderId)).findFirst().orElse(null);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orders.stream().filter(o -> Objects.equals(o.getUserId(), userId)).collect(Collectors.toList());
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    public Order updateOrder(Order order) {
        Order exist = getOrder(order.getOrderId());
        if (exist != null) {
            exist.setProductName(order.getProductName());
            exist.setAmount(order.getAmount());
            exist.setStatus(order.getStatus());
            exist.setUpdateTime(LocalDateTime.now());
            return exist;
        }
        return null;
    }

    public boolean deleteOrder(Long orderId) {
        return orders.removeIf(o -> Objects.equals(o.getOrderId(), orderId));
    }
} 
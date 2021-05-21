package passionx3.jkdk.dao;

import java.util.List;

import passionx3.jkdk.domain.Order;

public interface OrderDao {
	List<Order> getOrdersByUserId(String userId);  	// 사용자별 온라인 상품 주문 list 반환
	Order getOrder(int orderId);   	// orderId로 Order 반환
	int insertOrder(Order order); 	// Order 레코드 추가
}
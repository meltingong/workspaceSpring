package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.OrdersDto;
import com.itwill.ilhajob.common.dto.ProductDto;

public interface OrdersService {
	
	void saveOrder(OrdersDto ordersDto);
	void removeOrder();
	List<OrdersDto> findOrderByUser(long id);
	List<OrdersDto> findOrderByCorp(long id);
	void reorderingCheckUpdate(String role, long id);
}

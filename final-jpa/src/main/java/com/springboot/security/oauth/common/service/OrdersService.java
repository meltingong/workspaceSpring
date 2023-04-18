package com.springboot.security.oauth.common.service;

import java.util.List;
import java.util.Map;

import com.springboot.security.oauth.common.dto.OrdersDto;
import com.springboot.security.oauth.common.dto.PaymentDto;
import com.springboot.security.oauth.common.dto.ProductDto;



public interface OrdersService {
	//Orders savaOrder(String role, long id, ProductDto productDto);
	boolean checkAndSaveOrder(String role, long id, ProductDto productDto, String paymentMethod);
	void removeOrder();
	List<OrdersDto> findOrderByUser(long id);
	List<OrdersDto> findOrderByCorp(long id);
	void reorderingCheckUpdate(String role, long id);
	List<PaymentDto> findPayment(String role, long id);
	Map<String, Object> orderProductByUser(long user_id, long product_id) throws Exception;
	Map<String, Object> orderProductByCorp(long corp_id, long product_id) throws Exception;
}

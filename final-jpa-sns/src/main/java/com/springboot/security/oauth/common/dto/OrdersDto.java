package com.springboot.security.oauth.common.dto;

import java.time.LocalDateTime;
import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class OrdersDto {
	private Long id;
	private LocalDateTime orderStartDate;
	private LocalDateTime orderEndDate;
	//상품구매 목록 확인시 order_valid로 만료 표시
	private int orderValid;
	
	private Long productId;
	private Long corpId;
	private Long userId;
	
	
}

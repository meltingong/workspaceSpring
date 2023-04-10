package com.itwill.ilhajob.common.dto;

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
	private int orderNo;
	private Date orderEndDate;
	//상품구매 목록 확인시 order_valid로 만료 표시
	private char orderValid;
	
	private ProductDto product;
	private String corpId;
	private int userSeq;
	
	
}

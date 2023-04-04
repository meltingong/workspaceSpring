package com.itwill.ilhajob.order;

import java.util.Date;

import com.itwill.ilhajob.product.Product;

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
public class Orders {
	private int orderNo;
	private Date orderEndDate;
	//상품구매 목록 확인시 order_valid로 만료 표시
	private char orderValid;
	
	private Product product;
	private String corpId;
	private int userSeq;
	
	
}

package com.itwill.sns.naver;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Product {
	private int no;
	private String name;
	private BigInteger price; // BigDecimal은 21억 이상(모든 숫자를 포함)
}

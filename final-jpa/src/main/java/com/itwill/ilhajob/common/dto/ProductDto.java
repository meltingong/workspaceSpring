package com.itwill.ilhajob.common.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	private long id;
	private int pNo;
	private String pName;
	private int pPrice;
	private int pEndMonth;
	private String pImage;
	private String pDiv;
}

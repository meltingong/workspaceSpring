package com.itwill.ilhajob.product;

import java.util.List;

public interface ProductService {
	
	//상품 번호로 상품 1개 찾기
	Product selectByNo(int pNo) throws Exception;
	
	//p_div로 상품 리스트 불러오기
	List<Product> selectAllByDiv(String pDiv) throws Exception;
	
	//update Product
	int updateProduct(Product product) throws Exception;
	
	//delete Product
	int deleteProduct(int pNo) throws Exception;
	
}

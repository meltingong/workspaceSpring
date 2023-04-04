package com.itwill.ilhajob.product;

import java.util.List;

public interface ProductDao {
	
	Product findByNo(int pNo) throws Exception;
	
	List<Product> findAllByDiv(String pDiv) throws Exception;
	
	int update(Product product) throws Exception;
	
	int delete(int pNo) throws Exception;
}

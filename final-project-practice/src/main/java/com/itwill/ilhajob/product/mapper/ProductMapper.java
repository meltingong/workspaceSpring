package com.itwill.ilhajob.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.product.Product;

@Mapper
public interface ProductMapper {
	
	public Product selectByNo(int pNo);
	
	public List<Product> selectAllByDiv(String pDiv);
	
	public int updateProduct(Product product);
	
	public int deleteProduct(int pNo);
}

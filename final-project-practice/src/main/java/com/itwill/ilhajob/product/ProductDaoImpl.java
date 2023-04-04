package com.itwill.ilhajob.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.product.mapper.ProductMapper;

@Repository
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public Product findByNo(int pNo) throws Exception {
		return productMapper.selectByNo(pNo);
	}

	@Override
	public List<Product> findAllByDiv(String pDiv) throws Exception {
		return productMapper.selectAllByDiv(pDiv);
	}

	@Override
	public int update(Product product) throws Exception {
		return productMapper.updateProduct(product);
	}

	@Override
	public int delete(int pNo) throws Exception {
		return productMapper.deleteProduct(pNo);
	}
	
	
}

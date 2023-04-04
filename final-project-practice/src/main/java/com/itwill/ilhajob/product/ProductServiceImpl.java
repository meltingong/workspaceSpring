package com.itwill.ilhajob.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	//constructor
	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//getter
	public ProductDao getProductDao() {
		return productDao;
	}
	
	//setter
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	//상품 번호로 상품 검색
	@Override
	public Product selectByNo(int pNo) throws Exception {
		Product selectProductByNo=productDao.findByNo(pNo);
		return selectProductByNo;
	}
	
	//p_div로 상품 리스트 검색
	@Override
	public List<Product> selectAllByDiv(String pDiv) throws Exception {
		List<Product> productListByDiv=productDao.findAllByDiv(pDiv);
		return productListByDiv;
	}
	
	//상품 update
	@Override
	public int updateProduct(Product product) throws Exception {
		int updateCount=productDao.update(product);
		return updateCount;
	}
	
	//상품 delete
	@Override
	public int deleteProduct(int pNo) throws Exception {
		int deleteCount=productDao.delete(pNo);
		return deleteCount;
	}

	
}

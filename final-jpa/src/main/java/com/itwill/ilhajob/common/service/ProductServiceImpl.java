package com.itwill.ilhajob.common.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.common.dto.ProductDto;
import com.itwill.ilhajob.common.entity.Product;
import com.itwill.ilhajob.common.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private final ProductRepository productRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	//constructor
	public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
		this.productRepository = productRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public ProductDto selectByNo(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return null; 
	}
		
	@Override
	public List<ProductDto> selectAllByDiv(String pDiv) throws Exception {
		List<Product> productList = productRepository.findAll();
		return productList.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public int updateProduct(ProductDto productDto) throws Exception {
	    Product product = new Product();		
		productDto.setPNo(1);
		productDto.setPName("수정");
		productDto.setPPrice(1);
		productDto.setPEndMonth(4);
		productDto.setPImage("수정");
		productDto.setPDiv(null);
		
		return updateProduct(productDto);
		
	    
	}
	
	
	@Override
	public int deleteProduct(int pNo) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

package com.itwill.ilhajob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
}

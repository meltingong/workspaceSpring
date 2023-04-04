package com.itwill.ilhajob.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@EntityScan(basePackages = "com.itwill.ilhajob.product.mapper.ProductMapper")
@SpringBootApplication
//@MapperScan(basePackages = "com.itwill.ilhajob.product.mapper")
public class SpringBootProductDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootProductDaoMain.class, args);
		ProductDao productDao=(ProductDao)appicationContext.getBean(ProductDao.class);
		System.out.println("---------ProductTest 시작------------------");
		System.out.println("--selectByNo--");
		System.out.println(productDao.findByNo(2));
		System.out.println("--selectByDiv--");
		System.out.println(productDao.findAllByDiv("U"));
		System.out.println("--update--");
		System.out.println(productDao.update(new Product(4, "수정", 1, 3, "수정", "A")));
		System.out.println("--delete--");
		System.out.println(productDao.delete(32));

	}

}

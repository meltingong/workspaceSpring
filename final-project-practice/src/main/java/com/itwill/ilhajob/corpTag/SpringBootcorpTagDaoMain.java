package com.itwill.ilhajob.corpTag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.itwill.ilhajob.corpTag.mapper.CorpTagMapper;

@SpringBootApplication
@MapperScan(basePackages = "com.itwill.ilhajob.corpTag.mapper")
public class SpringBootcorpTagDaoMain{
	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootcorpTagDaoMain.class, args);
		
		CorpTagDao corpTagDao=(CorpTagDao)appicationContext.getBean(CorpTagDao.class);
		
		/*
		System.out.println("---------insert------------------");
		System.out.println(corpTagDao.insertCorpTag(CorpTag.builder().corpId("corp_04").tagId(1).build()));
		
		System.out.println("---------selectCorpByTag------------------");
		System.out.println(corpTagDao.selectCorpByTag(1));
		
		System.out.println("---------existedCorpTag------------------");
		System.out.println(corpTagDao.existedCorpTag("corp_04",1));

		System.out.println("---------deleteCorpTag------------------");
		System.out.println(corpTagDao.deleteCorpTag("corp_04",1));
		*/
	}

}

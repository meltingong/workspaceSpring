package com.itwill.ilhajob.tag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@MapperScan(basePackages = "com.itiwll.ilhajob.tag.mapper")
public class SpringBootTagDaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				SpringApplication.run(SpringBootTagDaoMain.class, args);
		TagDao tagDao =(TagDao)applicationContext.getBean(TagDao.class); 
		/*
		System.out.println("---------insert------------s-");
		System.out.println(tagDao.insertTag(new Tag(0, "tag3")));
		System.out.println("---------selectAll-------------");
		System.out.println(tagDao.selectAllTag());
		System.out.println();
		System.out.println("---------selectTagById-------------");
		System.out.println(tagDao.selectTagById(1));
		*/
		
		System.out.println("---------selectTagByName-------------");
		System.out.println(tagDao.selectTagByName("tag3"));
		System.out.println("---------updateTag-------------");
		Tag updateTag =  tagDao.selectTagByName("tag3");
		updateTag.setTagName("tag3333");
		
		System.out.println(tagDao.updateTag(updateTag));
		System.out.println("---------deleteTag-------------");
		System.out.println(tagDao.deleteTag(4));
		
	}

}

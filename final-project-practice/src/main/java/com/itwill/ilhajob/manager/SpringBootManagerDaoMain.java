package com.itwill.ilhajob.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@EntityScan(basePackages = "com.itwill.ilhajob.manager.mapper.managerMapper")
@SpringBootApplication
//@MapperScan(basePackages = "com.itwill.ilhajob.manager.mapper")
public class SpringBootManagerDaoMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootManagerDaoMain.class, args);
		ManagerDao managerDao=(ManagerDao)appicationContext.getBean(ManagerDao.class);
		System.out.println("---------ManagerTest 시작------------------");
		System.out.println("--insert--");
		System.out.println(managerDao.insert(new Manager("새이메일", "새매니저", "새직급", "새전화번호", "corp_01")));
		System.out.println("--update--");
		System.out.println(managerDao.update(new Manager("새이메일", "수정매니저", "수정직급", "수정번호", "corp_01")));
		System.out.println("--delete--");
		System.out.println(managerDao.delete("새이메일"));
		System.out.println("--findManagerByEmail--");
		System.out.println(managerDao.findManager("이메일@기업1-1.com"));
		System.out.println("--existedManager--");
		System.out.println(managerDao.existManager("이메일@기업1-1.com"));
		//System.out.println("--selectListByCorpId--"); corp mapper에서 실시
		//System.out.println(managerDao.listManagerByCorpId("corp_01"));

	}

}

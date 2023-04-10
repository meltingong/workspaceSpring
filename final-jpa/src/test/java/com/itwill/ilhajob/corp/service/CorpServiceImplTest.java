package com.itwill.ilhajob.corp.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.ilhajob.FinalProjectTeam1IlhajobApplicationTests;

class CorpServiceImplTest extends FinalProjectTeam1IlhajobApplicationTests{

	@Autowired
	CorpService corpService;
	
	@Disabled
	@Test
	void testLogin() throws Exception {
		//System.out.println(corpService.findCorp("corp_01"));
		System.out.println(corpService.findCorpAll());
	}
	//@Disabled
	@Test
	void testFindCorp() throws Exception {
		System.out.println(corpService.findCorp("corp_03"));
	}
	@Disabled
	@Test
	void testUpdate() {
		fail("Not yet implemented"); // TODO
	}
	@Disabled
	@Test
	void testRemove() {
		fail("Not yet implemented"); // TODO
	}
}

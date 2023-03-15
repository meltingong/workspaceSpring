package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

import io.swagger.annotations.ApiOperation;

/*
	1. GET    - /guest : 모든 데이터를 요청한다.
	2. POST   - /guest : 데이터를 추가한다.
	3. GET    - /guest/n : n번째 데이터를 요청한다.
	4. PUT    - /guest/n : n번째 데이터를 수정한다.
	5. DELETE - /guest/n : n번째 데이터를 제거한다.
	*/
@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@ApiOperation(value="방명록리스트")
	@GetMapping(value="/guest",produces = "application/json;charset=UTF-8")
	public Map<String,Object> guest_list() throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code = 1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		data = guestService.selectAll();
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	@GetMapping(value="/guest/{guest_no}", produces = "application/json;charset=UTF-8")
	public Map<String,Object> guest_detail(@PathVariable(value="guest_no") int guest_no) throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code = 1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		Guest guest = guestService.selectByNo(guest_no);
		if(guest!=null) {
			data.add(guest);
		}else {
			code=2;
			msg="게시물이 존재하지 않습니다.";
			
		}
		
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	@PostMapping(value="/guest",produces = "application/json;charset=UTF-8")
	public Map<String,Object> guest_write_action(@RequestBody Guest guest){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code = 1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		try {
			guestService.insertGuest(guest);
			code=1;
			msg="성공";
			data.add(guest);
		} catch (Exception e) {
			code=2;
			msg="방명록쓰기 실패";
			e.printStackTrace();
		}		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	public Map<String,Object> guest_modify_action() throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code = 1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	public Map<String,Object> guest_remove_action() throws Exception{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int code = 1;
		String msg="성공";
		List<Guest> data = new ArrayList<Guest>();
		
		
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		
		return resultMap;
	}
	
	
	
	
	
	
}

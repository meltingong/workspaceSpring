package com.itwill.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Order;

@Controller
public class SessionOrderController {
   @RequestMapping(value = "session_order_process1")
   public String session_order_process1(HttpSession session) {
      Order order = (Order)session.getAttribute("order"); //최초로 session꺼내면 null 
      if(order==null) {
         session.setAttribute("order", new Order()); //비어있으면, order 생성 -> 2번째는 뽑아서 집어넣음(첫페이지에서는 x, 다음페이지 요청할때 집어넣음)
      }
      return "session_order_process1";
   }
   @RequestMapping(value = "session_order_process2")
   public String session_order_process2(HttpSession session,@RequestParam String name) {
      Order order = (Order)session.getAttribute("order"); 
      order.setName(name);
      return "session_order_process2";
   }
   @RequestMapping(value = "session_order_process3")
   public String session_order_process3(HttpSession session,@RequestParam String cardNo) {
	   Order order = (Order)session.getAttribute("order"); 
	   order.setName(cardNo);
	   return "session_order_process3";
   }
}
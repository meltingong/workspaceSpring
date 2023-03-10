/*

*/
import * as View from "./view.js";
//import {render} from "./view.js";
//import {render as Render} from "./view.js";
import * as Service from "./service.js";
import * as URL from "./request-url.js";


/*
메뉴객체 이벤트등록
*/
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');

menuGuestHome.addEventListener('click',function(e){
	View.render("#guest-main-template",{},"#content");
	e.preventDefault();
});
menuGuestList.addEventListener('click',function(e){
	let jsonResult = Service.guestService('GET',URL.GUEST_LIST_URL,'');
	console.log(jsonResult);
	View.render("#guest-list-template",jsonResult,"#content");
	e.preventDefault();
	
});
menuGuestWriteForm.addEventListener('click',function(e){
	View.render("#guest-write-form-template",{},"#content");
	e.preventDefault();
	
});
/*
초기 로딩 시에 home anchor click event trigger
*/
//menuGuestHome.click();
document.addEventListener('click',function(e){
	
	console.log('Event객체:'+e);
	console.log('Event Target 객체:'+e.target);
	console.log('Event Target 객체 id:'+e.target.id);
	console.log('Event Target 객체 id:'+e.target.getAttribute("id"));
	console.log('Event Target 객체 className:'+e.target.className);
	console.log("Event Target 객체 classList.contains('guest_item_a'):"+e.target.classList.contains('guest_item_a'));
	/****************guest_detail****************/
	if(e.target.classList.contains('guest_item_a')){
		/*
		<<e.target>>
		<a href="#" class="user guest_item_a" class="guest_item_a" guest_no="{{guest_no}}">
		*/
		let params ='guest_no='+e.target.getAttribute("guest_no");
		
		let jsonResult = Service.guestService('GET',URL.GUEST_DETAIL_URL,params);
		View.render("#guest-detail-template",jsonResult,"#content");
	}
	/****************guest_delete_action****************/
	if(e.target.id=='btn_guest_remove_action'){
		let params ='guest_no='+e.target.getAttribute("guest_no");
		let jsonResult = Service.guestService('POST',URL.GUEST_REMOVE_ACTION_URL,params);
		if(jsonResult.code==1){
			menuGuestList.click();
		}else{
			alert(jsonResult.msg);
		}
	}
	
	
	e.preventDefault();
	
});



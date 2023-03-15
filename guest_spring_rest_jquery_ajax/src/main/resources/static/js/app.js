import * as View from "./view.js";
import * as Request from "./request.js";
/*
 메뉴객체 이벤트 등록 
	#menu_guest_home
	
	#menu_guest_list
	#btn_guest_list
	
	#menu_guest_write_form
	#btn_guest_write_form
	
	#btn_guest_write_action
	#btn_guest_modify_form
	#btn_guest_modify_action
	#btn_guest_remove_action
	
	.guest_item_a
 */
 /********guest_home*******/
$('#menu_guest_home').click(function(e){
	console.log(e.target);
	View.render("#guest-main-template");
	e.preventDefault();
});
 /********guest_list*******/
$(document).on('click','#menu_guest_list','#btn_guest_list',function(e){
	
	let url='guest';
	let method = 'GET';
	let contentType="application/json;charset=UTF-8";
	let sendData={};
	let async=true;
	Request.ajaxRequest(url,
						method,
						contentType,
						sendData,
						function(resultJson){
							View.render("#guest-list-template",resultJson);
						},
						async);	
	
	e.preventDefault();
});
 /********guest_detail*******/
$(document).on('click','.guest_item_a',function(e){
	console.log(e.target);
	View.render("#guest-detail-template",{});
	e.preventDefault();
});
 /********guest_write_form*******/
$(document).on('click','#menu_guest_write_form','#btn_guest_write_form',function(e){
	console.log(e.target);
	View.render("#guest-write-form-template");
	e.preventDefault();
});

 /********guest_write_action*******/
$(document).on('click','#btn_guest_write_action',function(e){
	
	let sendData={
		guest_name:document.f.guest_name.value,
		guest_email:document.f.guest_email.value,
		guest_homepage:document.f.guest_homepage.value,
		guest_title:document.f.guest_title.value,
		guest_content:document.f.guest_content.value
	};
	console.log(sendData);
	Request.ajaxRequest('guest',
						'POST',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						function(resultJson){
							if(resultJson.code==1){
								
								
								
							}else{
								alert(resultJson.msg);
							}
						},
						true);
	
	e.preventDefault();
});

 /********guest_modify_form*******/
$(document).on('click','#btn_guest_modify_form',function(e){
	console.log(e.target);
	View.render("#guest-modify-form-template");
	e.preventDefault();
});

 /********guest_modify_action*******/
$(document).on('click','#btn_guest_modify_action',function(e){
	console.log(e.target);
	e.preventDefault();
});

 /********guest_remove_action*******/
$(document).on('click','#btn_guest_remove_action',function(e){
	console.log(e.target);
	e.preventDefault();
});













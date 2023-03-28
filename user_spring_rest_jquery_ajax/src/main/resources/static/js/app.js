import *  as View from "./view.js";
import * as Request from "./request.js";
import * as ResponseStatusCode from "./response_status_code.js";
import * as ResponseMessage from "./response_message.js";

/************* validator기본설정************ */
/*################################################################################*/
/*##############################메뉴객체이벤트등록################################
   메뉴객체이벤트등록
	#menu_user_login_form
	#menu_user_write_form
	#menu_user_logout_action
	#menu_user_view
	
	#btn_user_write_form
	#btn_user_write_action
	#btn_user_login_action
	#btn_user_modify_form_action
	#btn_user_delete_action
	
	<<< template id >>>>>>>>
	#user-main-template
	#user-write-form-template
	#user-view-template
	#user-modify-form-template
	#user-login-form-template
*/ 
/****user home******/
$('#menu_user_main').click(function(e){
	console.log(e.target);
	View.render("#user-main-template");
	e.preventDefault();
});
$('#menu_user_write_form').click(function(e){
	console.log(e.target);
	View.render("#user-write-form-template");
	e.preventDefault();
});
$('#menu_user_login_form').click(function(e){
	console.log(e.target);
	View.render("#user-login-form-template");
	e.preventDefault();
});
$('#btn_user_write_action').click(function(e){
	let sendData={
			userId:document.f.userId.value,
			password:document.f.password.value,
			name:document.f.name.value,
			email:document.f.email.value,
		};
		Request.ajaxRequest('user',
							'POST',
							'application/json;charset=UTF-8',
							JSON.stringify(sendData),
							function(resultJson){
								if(resultJson.code==ResponseStatusCode.EXISTED_USER){
								  View.render('#user-write-form-template',resultJson);	
								}else{
									alert(resultJson.msg);
								}
							},
							true);
		e.preventDefault();
});
/****guest list******/

$('#menu_user_main').trigger('click');






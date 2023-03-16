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
 
 /*******validator 국제화**** */
 console.log(navigator.language);
$.getScript(`js/localization/messages_${navigator.language}.js`); 
/*************validator 기본설정************/
let validator = null;
$.validator.setDefaults({
	rules:{
			guest_name:{
				required:true,
				minlength:2
			},
			guest_email:{
				required:true,
				email:true
			},
			guest_homepage:{
				required:true,
				url:true
			},
			guest_title:{
				required:true,
				rangelength:[3,6]
			}
		},
			messages:{
				guest_name:{
					required:"이름을 입력하세요",
					minlength:"이름은 {0}글자 이상입니다"
				},
				guest_title:{
					required:"타이틀을 입력하세요",
					rangelength:"타이틀의 글자수는 {0} ~ {1} 사이입니다"
				}
			},
	errorClass:'error',
	validClass:'valid'
}); 
 
 /********guest_home*******/
$('#menu_guest_home').click(function(e){
	console.log(e.target);
	View.render("#guest-main-template");
	e.preventDefault();
});
 /********guest_list*******/
$(document).on('click','#menu_guest_list,#btn_guest_list',function(e){
	
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
	
	let guest_no = $(e.target).attr('guest_no');
	let sendData = {};
	Request.ajaxRequest(`guest/${guest_no}`,
						'GET',
						'application/json;charset=UTF-8',
						sendData,
						function(resultJson){
							View.render("#guest-detail-template",resultJson);
						},true)
	e.preventDefault();
});
 /********guest_write_form*******/
$(document).on('click','#menu_guest_write_form,#btn_guest_write_form',function(e){
	/*###############################[form validator plugin]##########################
	    form validator
		 - HOMEPAGE :   https://jqueryvalidation.org/
		 - API      :   https://jqueryvalidation.org/validate/
			1. $(form).validate() function은 form loading시에 미리 호출되어있어야한다.
			2. var validator=$(form).validate(); 실행후 반환되는 validator 객체를 사용한다.
	#################################################################################*/
	 View.render("#guest-write-form-template");
	 validator = $('#guest_write_form').validate(
			{
				rules:{
					guest_content:{
						required:true,
						equalTo:'#guest_title'
					}//equalTo는 아이디를 부여해야함
				},
				messages:{
					guest_content:{
						required:"내용을 입력하세요",
						equalTo:'타이틀과 일치하여야 합니다.'
					}
				}
			}
		);
	e.preventDefault();
});

 /********guest_write_action*******/
$(document).on('click','#btn_guest_write_action',function(e){
	
	if(validator.form()){
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
									let new_guest_no = resultJson.data[0].guest_no;
									Request.ajaxRequest('guest/'+new_guest_no,
														'GET',
														'application/json;charset=UTF-8',
														{},
														function(resultJson){
															View.render("#guest-detail-template",resultJson);
														},true);
								}else{
									alert(resultJson.msg);
								}
							},
							true);
	}else{
		alert('validation false');
	}
	e.preventDefault();
});

 /********guest_modify_form*******/
$(document).on('click','#btn_guest_modify_form',function(e){
	let guest_no = $(e.target).attr('guest_no');
	Request.ajaxRequest('guest/'+guest_no,
						'GET',
						'application/json;charset=UTF-8',
						{},
						function(resultJson){
							View.render("#guest-modify-form-template",resultJson);
						},true
	);
	e.preventDefault();
});

 /********guest_modify_action*******/
$(document).on('click','#btn_guest_modify_action',function(e){
	let guest_no = f.guest_no.value;
	let sendData = {
		guest_name:document.f.guest_name.value,
		guest_email:document.f.guest_email.value,
		guest_homepage:document.f.guest_homepage.value,
		guest_title:document.f.guest_title.value,
		guest_content:document.f.guest_content.value
	};
	Request.ajaxRequest('guest/'+guest_no,
						'PUT',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						function(resultJson){
							if(resultJson.code==1){
								Request.ajaxRequest('guest/'+guest_no,
													'GET',
													'application/json;charset=UTF-8',
													{},
													function(resultJson){
														View.render('#guest-detail-template',resultJson);
													},true);
							}
						}
			,true);
	e.preventDefault();
});


 /********guest_remove_action*******/
$(document).on('click','#btn_guest_remove_action',function(e){
	//let guest_no = $("#guest_view_form input[name='guest_no']").val(); id로 접근 시 
	let guest_no = $(e.target).attr('guest_no');
	Request.ajaxRequest('guest/'+guest_no,
						'DELETE',
						'application/json;charset=UTF-8',
						{},
						function(resultJson){
							if(resultJson.code==1){
								/*
								#menu_guest_list jQuery객체 이벤트 발생
								*/
								$('#menu_guest_list').trigger('click');
								/*Request.ajaxRequest('guest',
													'GET',
													'application/json;charset=UTF-8',
													{},
													function(resultJson){
														View.render("#guest-list-template",resultJson);													
													},true
								);*/
							}else{
								alert(resultJson.msg);
							}
						}
	);
	e.preventDefault();
});
/****************jQuery Ajax Global Event*************/
$(document).ajaxStart(function(){
	$("<div id = 'loading'>loading...</div>").insertBefore('#content').show();
	
});
$(document).ajaxComplete(function(){
	$('#loading').hide();
	$('#loading').remove();
});

/*
페이지 로딩 후 홈컨텐트 보여주기
*/
$('#menu_guest_home').trigger('click');










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
 
$('#menu_guest_home').click(function(e){
	console.log(e.target);
	e.preventDefault();
});
$(document).on('click','#menu_guest_list','#btn_guest_list',function(e){
	console.log(e.target);
	e.preventDefault();
});
$(document).on('click','#menu_guest_write_form','#btn_guest_write_form',function(e){
	console.log(e.target);
	e.preventDefault();
});

$(document).on('click','#btn_guest_write_action',function(){
	console.log(e.target);
	e.preventDefault();
});

$(document).on('click','#btn_guest_modify_form',function(){
	console.log(e.target);
	e.preventDefault();
});

$(document).on('click','#btn_guest_modify_action',function(){
	console.log(e.target);
	e.preventDefault();
});

$(document).on('click','#btn_guest_remove_action',function(){
	console.log(e.target);
	e.preventDefault();
});
$(document).on('click','.guest_item_a',function(){
	console.log(e.target);
	e.preventDefault();
});













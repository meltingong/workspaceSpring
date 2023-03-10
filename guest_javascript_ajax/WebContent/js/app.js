/*

*/

/*
메뉴객체 이벤트등록
*/
const menuGuestHome = document.querySelector('#menu_guest_home');
const menuGuestList = document.querySelector('#menu_guest_list');
const menuGuestWriteForm = document.querySelector('#menu_guest_write_form');

menuGuestHome.addEventListener('click',function(e){
	let templateHtml = document.querySelector('#guest-main-template');
	document.querySelector('#content').innerHTML = templateHtml.innerHTML;
	e.preventDefault();
});
menuGuestList.addEventListener('click',function(){
	
});
menuGuestWriteForm.addEventListener('click',function(){
	
});
/*
초기 로딩 시에 home anchor click event trigger
*/
menuGuestHome.click();
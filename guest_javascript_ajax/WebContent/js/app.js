/*

*/
import * as View from "./view.js";
//import {render} from "./view.js";
//import {render as Render} from "./view.js";
import * as Service from "./service.js"

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
	let jsonResult = Service.guestService('GET','guest/guest_list_json.jsp','');
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
menuGuestHome.click();
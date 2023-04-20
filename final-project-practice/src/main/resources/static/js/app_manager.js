import * as View from "./view.js";
import * as Request from "./request.js";

$(document).on('click','#create',function(e){
	console.log("펑션접근");
	/*
		url,method,contentType,sendData,function,async
	*/
	
		let sendData={
		managerName: document.form2.managerName.value,
		managerEmail: document.form2.managerEmail.value,
		managerPosition: document.form2.managerPosition.value,
		managerPhone: document.form2.managerPhone.value,
		corp: null,
		id: null,
	};
	console.log(sendData);
	Request.ajaxRequest('/manager',
					    'POST',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						console.log('여기까진왔따'),
						function(resultJson){
							if(resultJson.code==1){
								console.log('요청 URL manager/');
								//ajaxRequest();
								View.render("#manager-create-list",resultJson,"#manager-list");
							}else{
								alert(resultJson.msg);
							}
						},
						true); //비동기
	e.preventDefault();
});
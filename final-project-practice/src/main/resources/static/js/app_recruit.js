import * as View from "./view.js";
import * as Request from "./request.js";


$('.changeTag').click(function(e){
	console.log("펑션접근");
	/*
		url,method,contentType,sendData,function,async
	*/
	
		let sendData={
			tagId:$(this).val()
		};
	console.log(sendData);
	Request.ajaxRequest('getRecruitTag',
					    'POST',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						function(resultJson){
							console.log("제이슨 받아왔다");
								View.render("#recruit-tag-template",resultJson,"#recruit-main-list");
						},
						true); //비동기
	e.preventDefault();
});
function guestService(method,url,params){
	//ajax요청
	let returnJsonResult={};
	ajaxRequest(method,
				url,
				function(jsonResult){
					returnJsonResult=jsonResult;
				},
				params,
				false);
	return returnJsonResult;
}

/*
function guestServiceFunction(method,url,callbackFunction,params){
			ajaxRequest(method,
						url,
						callbackFunction,
						params,
						true);
}

*/
function ajaxRequest(method,url,callbackFunction,params,async){
	let xhr=new XMLHttpRequest();
	url=(method=='GET'&& params!=null)?url+'?'+params:url;
	async= async ?async:false;
	xhr.onload=function(){
		callbackFunction(JSON.parse(xhr.responseText));
	}
	xhr.open(method,url,async);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded')
	xhr.send(method=='POST'?params:null);
}

/*
function ajaxRequestPromise(method,url,params,async){
	return new Promise(function(success,fail){
			let xhr=new XMLHttpRequest();
			url=(method=='GET'&& params!=null)?url+'?'+params:url;
			async= async ?async:false;
			xhr.onload=function(){
				success(JSON.parse(xhr.responseText));
			}
			xhr.open(method,url,async);
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded')
			xhr.send(method=='POST'?params:null);
	});
	
}
function guestServicePromise(method,url,params){
		//ajax요청
		//let returnJsonResult={};
		let ajaxRequestPromiseObject= 
			ajaxRequestPromise(method,url,params,true);
		return ajaxRequestPromiseObject;
}
*/
export{ guestService} 
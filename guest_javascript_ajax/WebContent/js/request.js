/*
ajax 요청
*/

function ajaxRequest(method,url,callbackFunction,params,async){
	let xhr = new XmXMLHttpRequest();
	
	url=(method == 'GET' && params!=null)? url+'?'+params:url;
	async = async ?async:false;
	
	xhr.onload = function(){
		callbackFunction(JSON.parse(xhr.responseText));
	} 
	xhr.open(method,url,async);
	xhr.setRequestHeader('content-Type','application/x-www.form-urlencoded');
	xhr.send(method = 'POST'?params:null);
}
export {ajaxRequest}
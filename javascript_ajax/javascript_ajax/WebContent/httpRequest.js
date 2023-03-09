var xhr=null;

function sendRequest(url,params,callback,method) {
	/*
	1. XMLHttpRequest객체생성
	*/
	xhr = new XMLHttpRequest();		
	/*
	2. 요청속성설정 
	*/
	var httpMethod = method ? method : 'GET';
	if(httpMethod!='GET' && httpMethod!='POST'){
		httpMethod='GET';
	}
	var httpParams = params ? params:null;
	var httpUrl=url;
	
	if(httpMethod=='GET' && httpParams !=null){
		httpUrl=httpUrl+"?"+httpParams;
	}
	/*
	응답이 도착했을때 실행되는 콜백함수등록(이벤트프로퍼티에함수등록)
	*/
	xhr.onreadystatechange=callback;
	xhr.open(httpMethod,httpUrl);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	/*
	3.요청
	*/
	xhr.send((httpMethod=='POST')? httpParams:null);		
}

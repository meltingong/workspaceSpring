window.jQuery = function(arg){
	if(typeof arg == 'string'){
		/********selector*******/
		let elementNodeList = document.querySelectorAll(arg);
		if(!elementNodeList) elementNodeList=[];
		let jQueryWrapperObject = {
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(let i = 0; i < this.elementNodeList.length; i++){
					this.elementNodeList[i].style.cssText +=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				//set text
				if(textArg){
					for(let i = 0; i <this.elementNodeList.length; i++){
						//this.elementNodeList[i].innerHTML = textArg;
						this.elementNodeList[i].firstChild.nodeValue = textArg;
					}
					return this;
				}else if(textArg == undefined){
					//get text
					let returnText = "";
					for(let i = 0; i <this.elementNodeList.length; i++){
						//this.elementNodeList[i].innerHTML = textArg;
						returnText += this.elementNodeList[i].firstChild.nodeValue;
					}
					return returnText;
				}
			}	
		}
		return jQueryWrapperObject;
	}else if(typeof arg == 'function'){
		/*
		인자로 대입된 함수를 DOM트리 생성직후에 호출되도록
		window.onload이벤트 프로퍼티에 등록
		*/
		window.addEventListener('load',arg);
	}
}
/**********jQuery global function********/
window.jQuery.each = function(array,funArg){
	for(let i = 0; i < array.length; i++){
		funArg(i,array[i]);
	}
}

window.$ = window.jQuery;








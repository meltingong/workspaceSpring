window.jQuery = function(arg){
	if(typeof arg == 'string'){
		let elementNodeList = document.querySelectorAll(arg);
		let jQueryWrapperObject = {
			'elementNodeList':elementNodeList,
			'css':function(propertyName,propertyValue){
				for(let i = 0; i < this.elementNodeList.length; i++){
					this.elementNodeList[i].style.cssText +=`${propertyName}:${propertyValue};`;
				}
				return this;
			},
			'text':function(textArg){
				for(let i = 0; i <this.elementNodeList.length; i++){
					//this.elementNodeList[i].innerHTML = textArg;
					this.elementNodeList[i].firstChild.nodeValue = textArg;
				}
				return this;
			}	
		}
		return jQueryWrapperObject;
	}
}
window.$ = window.jQuery;








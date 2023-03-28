/**
 * view.js
 */
export function render(templateId='#user-main-template',jsonResult={},contentId="#content") {
	let templateHtml = $(templateId).html();
	let bindTemplate = Handlebars.compile(templateHtml);
	/*****************Handlebars함수등록*************** */
	Handlebars.registerHelper('substring',function(str,start,end){
		return str.substring(start,end);
	});
	
	let resultTemplate = bindTemplate(jsonResult);
	$(contentId).html(resultTemplate);
}

 
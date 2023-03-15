/**
 * 
 */
export function render(templateId='#guest-main-template',jsonResult={},contentId="#content") {
	let templateHtml = $(templateId).html();
	let bindTemplate = Handlebars.compile(templateHtml);
	let resultTemplate = bindTemplate(jsonResult);
	$(contentId).html(resultTemplate);
}

import *  as View from "./view.js";
//=================ajax rendering=====================
$('#init-page').click(function(e){
	console.log(e.target);
	View.render("#image-upload-form",{},"#image-content");
	e.preventDefault();
});

//$('#init-page').trigger('click');
//====================================================


/* 이미지 미리보기 */
/*function readURL(input) {
	if (input.files && input.files[0]) {
		let reader = new FileReader();
		reader.onload = function(e) {
			$('#preview')
				.attr('src', e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	}
}*/
/* 
//미리보기 여러개
function readURL(input) {
    if (input.files && input.files.length > 0) {
        $('#preview').empty();
        for (let i = 0; i < input.files.length; i++) {
            let reader = new FileReader();
            reader.onload = function(e) {
                $('#preview').append('<img class="preview-img" src="' + e.target.result + '"/>');
            };
            reader.readAsDataURL(input.files[i]);
        }
    }
}
*/
//이미지 여러개
/*	$('#upload-btn').click(function() {
		let formData = new FormData();
		let files = $('input[name="images"]').get(0).files;
		if (files.length > 0) {
			for (let i = 0; i < files.length; i++) {
				formData.append("images", files[i]);
			}
			console.log(formData.getAll("images"));
			$.ajax({
				url: "image-upload-action",
				type: "POST",
				data: formData,
				processData: false,
				contentType: false,
				success: function(data) {
					alert(data);
					View.render("#image-upload-form",{},"#image-content");
				},
				error: function() {
					alert("이미지 업로드 error");
				}
			});
		} else {
			alert("No images selected.");
		}
	});
	*/


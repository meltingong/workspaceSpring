  /**
 * review ajax -> test x
 */
/*
 $.ajax({
    type: "POST",
    url: "createReview",
    contentType: "application/json",
    data: JSON.stringify(reviewData),
    success: function(response) {
        // 서버로부터 성공 응답을 받은 경우
        var responseData = JSON.parse(response);
        if (responseData.success) {
            alert(responseData.message);
            // 페이지를 새로고침하거나 다른 작업을 수행
           // window.location.href = '/final-project-team1-ilhajob/corp-detail';
        } else {
            alert(responseData.message);
            // 오류 처리
        }
    },
    error: function(response) {
        // 서버로부터 오류 응답을 받은 경우
        alert("오류가 발생했습니다. 다시 시도해주세요.");
    }
});
*/


	$(document).on('click', '#reviewCreate-btn', function(e) {
		e.preventDefault();
		let formData = {};
		let corpId = $('.comment-form.default-form #corpId').val();
		let reviewData = {}; 
		$.each($('#review-form').serializeArray(), function() {
			reviewData[this.name] = this.value;
		});
		formData = {
			corpId: corpId,
			reviewData: reviewData
		}
		console.log(formData);
		let jsonData = JSON.stringify(formData);
		console.log(jsonData);
		let promise = $.ajax({
			type: 'POST',
			url: 'createReviewAjax',
			data: jsonData,
			contentType: 'application/json',
			dataType: 'json'
		}); 
		//promise 객체를 사용하여 Ajax 요청 처리 (resolve, reject)
		promise.then(function(response) {
			console.log(response);
			console.log(response.message);
			if (response.success) {
				window.location.href = '/final-project-team1-ilhajob';
			}
			else {
				alert(response.message);
				window.location.href = response.location;
			}
		}).fail(function(xhr, status, error) {
			// Ajax 요청 실패 시 처리
			console.log(xhr);
			console.log(status);
			console.log(error);
		});


	
		
	});


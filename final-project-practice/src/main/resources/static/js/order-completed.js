(function($) {
	
	$(document).ready(function() {
		// localStorage에서 데이터를 불러오기
		const data = JSON.parse(localStorage.getItem("data"));
		// 데이터를 사용하여 DOM을 변경
		const productPrice = parseInt(data.productData.productPrice);
		
		$(".order-info #order-id").text(data.orderData.id);
		$(".order-info #order-date").text(data.orderData.orderStartDate);
		$(".order-info #order-total").text(productPrice.toLocaleString()+"원");
		$(".order-info #order-method").text(data.paymentData.paymentMethod);
		$(".product-name").text(data.productData.productName);
		$(".product-total").text(productPrice.toLocaleString()+"원");
		$(".order-period").text(data.orderData.orderEndDate);
		$(".amount").text(data.productData.orderTotal);
		
	});

	$(window).on('beforeunload', function() {
		// 페이지 전환시 localStorage 데이터를 삭제
		localStorage.removeItem("data");localStorage.removeItem("data");
	});

})(window.jQuery);
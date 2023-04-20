/**
 * cv
 */
 
 // cv write
 function writeCv() {
	if (document.f.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.f.cvName.focus();
		return false;
	}
	if (document.f.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.f.cvDescription.focus();
		return false;
	}
	if (document.f.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.f.cvPortfolio.focus();
		return false;
	}
	document.f.action = "cv-write-action";
	document.f.method='POST';
	document.f.submit();
}

// cv update
function updateCv() {
	if (document.cvForm.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.cvForm.cvName.focus();
		return false;
	}
	if (document.cvForm.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.cvForm.cvDescription.focus();
		return false;
	}
	if (document.cvForm.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.cvForm.cvPortfolio.focus();
		return false;
	}
	document.cvForm.action = "cv-update-action";
	document.cvForm.method='POST';
	document.cvForm.submit();
}

// cv delete
function deleteCv() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
	  document.cvForm.action = "cv-delete-action";
	  document.cvForm.method='POST';
	  document.cvForm.submit();
	}
}

// cv change
function changeCv() {
  var cvId = document.querySelector('.chosen-select').value;
  window.confirm("cvId = " + cvId);
  document.querySelector('#cvId').value = cvId;
  document.cvForm.action = "cv-detail";
  document.cvForm.method='POST';
  document.cvForm.submit();
}

// cv apply(예정)
function apply() {
	window.confirm("지원하시겠습니까?");
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

/**************** edu ****************/
function addEdu() {
  // 새로운 요소를 생성하고 클래스 이름을 추가합니다.
  var newEduBlock = document.createElement("div");
  newEduBlock.classList.add("edu-block");
  // 새로운 요소의 내부 HTML을 설정합니다.
  newEduBlock.innerHTML = `
  <div class="resume-block" th:object="${eduList}" th:each="edu:${eduList}">
	  <div class="inner">
	  <span class="name">E</span>
		      <div class="edit-btns">
			      <button type="button" onclick="createEdu()"><span class="la la-check-circle-o"></span></button>
			      <button type="button" onclick="deleteEdu()" name="eduId"><span class="la la-trash"></span></button>
	      	  </div>
	      	  <div class="row">
			  
			  	<div class="form-group col-lg-6 col-md-12">
		        <label>학교명</label>
				  <input type=text th:field="*{eduDto.eduName}" name="eduName" placeholder="학교명">
			    </div>
			  	<div class="form-group col-lg-6 col-md-12">
		        <label>전공</label>
				  <input type=text name="eduMajor" placeholder="전공">
				</div>
			    <div class="form-group col-lg-6 col-md-12">
			    <label>학점</label>
			    <input type="text" name="eduScore" placeholder="학점을 입력하세요.">
			    </div>
			    <div class="form-group col-lg-6 col-md-12">
			    <label>추가 정보 입력</label>
			    <input type="text" name="eduContent" placeholder="학력 관련 추가 정보를 입력하세요.">
			    </div>
			    
			    <div class="edit-box">
			  	<div class="form-group col-lg-6 col-md-12">
			    <label>입학일</label><br>
			      <input type="date" name ="eduStartDate">
			    </div>
			  	<div class="form-group col-lg-6 col-md-12">
			    <labe>졸업일</label><br>
			      <input type="date" name ="eduEndDate">
			    </div>
		        </div>
		  </div>
	 	</div>
    </div>
  `;

  var eduList = document.getElementById("edu-block");
  console.log(">>>>>>>>>> " + eduList);
  var lastEduBlock = eduList.lastElementChild;
  eduList.insertBefore(newEduBlock, lastEduBlock.nextSibling);
}

function deleteEdu(eduId) {
	confirm(">>>>>>> eduId : " + eduId + "typeof : " + typeof eduId);
	$('#eduId'+eduId).val(eduId);
	console.log($('#eduId'+eduId).attr('value'));
	console.log($('.default-form').serialize());

	document.eduForm.action = "edu-delete";
	document.eduForm.method='POST';
	document.eduForm.submit();
	/*
	// eduId를 Long 타입으로 변환합니다.
	const longEduId = parseInt(eduId);
	confirm(">>>>>>> eduId : " + longEduId + "typeof : " + typeof longEduId);
    // hidden input 태그의 value 속성 값을 longEduId로 설정합니다.
	//$('#eduId'+eduId).val(longEduId);
	$('#eduId'+eduId).val(longEduId);
	//confirm(">>>>>> " + $('#eduId'+eduId));

	//console.log($('#eduId'+eduId).attr('value'));
	//console.log($('#eduForm').serialize());
	document.eduForm.action = "edu-delete";
	document.eduForm.method='POST';
	document.eduForm.submit();
	*/
}


function createEdu() {
	/*
	let eduStartDateStr = document.getElementById("eduStartDateInput").value;
	
	let eduStartDate = new Date(eduStartDateStr);
	document.getElementById("eduStartDate").value = eduStartDate;
    console.log(">>>>>>>>>>" + typeof eduStartDateStr);
    console.log(">>>>>>>>>>" + typeof eduStartDate);
    console.log(">>>>>>>>>>" + typeof document.getElementById("eduStartDate").value);
    
    var eduEndDate = new Date(document.getElementById("eduEndDate").value + "T00:00:00");
    console.log(">>>>>>>>>>" + eduEndDate);
    
    var eduDto = {
        eduName: document.getElementsByName("eduName")[0].value,
        eduMajor: document.getElementsByName("eduMajor")[0].value,
        eduStartDate: eduStartDate.toISOString(),
        eduEndDate: eduEndDate.toISOString(),
        eduScore: document.getElementsByName("eduScore")[0].value,
        eduContent: document.getElementsByName("eduContent")[0].value
    };
    */
    
	document.eduForm.action = "edu-create";
	document.eduForm.method='POST';
	document.eduForm.submit();

	/*
	const eduDto = {
    eduName: $("#eduName").val(),
    eduMajor: $("#eduMajor").val(),
    eduStartDate: $("#eduStartDate").val() + "T00:00:00.000",
    eduEndDate: $("#eduEndDate").val() + "T00:00:00.000",
    eduContent: $("#eduContent").val()
  };

  $.ajax({
    type: "POST",
    url: "/edu-create",
    contentType: "application/json",
    data: JSON.stringify(eduDto),
    success: function(response) {
      // success callback function
      alert("success");
    },
    error: function(xhr, status, error) {
      // error callback function
    }
  });
  */
}

function editEdu() {
	function replaceWithInputElements(elements) {
		console.log(">>>>>>> elements : " + elements)
	  for (let i = 0; i < elements.length; i++) {
	    const div = elements[i];
	    const text = div.textContent;
	    const input = document.createElement("input");
	    
	    // If the element has an ID of "eduStartDate" or "eduEndDate", set the input type to "date"
	    if (div.id === "eduStartDate" || div.id === "eduEndDate") {
	      input.type = "date";
	    }
	    
	    input.value = text;
	    input.name = div.id;
	    input.style.border = "1px solid red";
	    input.style.borderRadius = "5px";
	    div.replaceWith(input);
	  }
	}
  // 호출할 때 요소들을 배열로 전달합니다.
  replaceWithInputElements([document.getElementById("eduName"), document.getElementById("eduMajor"), document.getElementById("eduScore"), document.getElementById("eduContent"), document.getElementById("eduStartDate"), document.getElementById("eduEndDate")]);
  
  // change the button's onclick event to call sendUpdate() instead of editUpdate()
  // const button = document.getElementById("editBtn");
  // button.onclick = sendUpdate;
  
  /* for문 돌리기 이전
  // get the div element and its text content
  const scoreDiv = document.getElementById("eduScore");
  const scoreText = scoreDiv.textContent;
  
  const contentDiv = document.getElementById("eduContent");
  const contentText = contentDiv.textContent;

  // create a new input element and set its value to the div's text content
  const scoreInput = document.createElement("input");
  scoreInput.value = scoreText;
  scoreInput.style.border = "1px solid red";
  scoreInput.style.borderRadius = "5px";
  scoreDiv.replaceWith(scoreInput);
  
  const contentInput = document.createElement("input");
  contentInput.value = contentText;
  contentInput.style.border = "1px solid red";
  contentInput.style.borderRadius = "5px";
  contentDiv.replaceWith(contentInput);
  */
}

function updateEdu(eduId) {
	confirm(">>>>>>> eduId : " + eduId + " typeof : " + typeof eduId);
	$('#eduId'+eduId).val(eduId);
	console.log($('#eduId'+eduId).attr('value'));
	console.log($('.default-form').serialize());
  document.eduForm.action = "edu-update";
  document.eduForm.method = "POST";
  document.eduForm.submit();

	/*
  // get the input element and its value
  const input = document.querySelector("input");
  const text = input.value;

  // send the text to the server or do something else with it
  console.log("Sending text:", text);

  // create a new div element and set its text content to the input's value
  const div = document.createElement("div");
  div.textContent = text;

  // replace the input element with the new div element
  input.replaceWith(div);

  // change the button's onclick event to call editUpdate() again
  const button = document.getElementById("myButton");
  button.onclick = editUpdate;
  */
}
	  
/*
// exp
function deleteExp(expSeq) {
	$('#expSeq'+expSeq).val(expSeq);
	console.log($('#expSeq'+expSeq).attr('value'));
	console.log($('.default-form').serialize());
}

function deleteExp() {
	document.f.action = "exp-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/
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
	document.f.action = "cv-update-action";
	document.f.method='POST';
	document.f.submit();
}

// cv delete
function deleteCv() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
	  document.f.action = "cv-delete-action";
	  document.f.method='POST';
	  document.f.submit();
	}
}

// cv change
function changeCv() {
  var cvId = document.querySelector('.chosen-select').value;
  window.confirm("cvId = " + cvId);
  document.querySelector('#cvId').value = cvId;
  document.f.action = "cv-detail";
  document.f.method='POST';
  document.f.submit();
}

// cv apply(예정)
function apply() {
	window.confirm("지원하시겠습니까?");
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

// edu
/*
function deleteEdu(eduSeq) {
	$('#eduSeq'+eduSeq).val(eduSeq);
	console.log($('#eduSeq'+eduSeq).attr('value'));
	console.log($('.default-form').serialize());
	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/
/**
function deleteEdu(eduSeq) {
	document.f.value=eduSeq;
	$('#eduSeq'+eduSeq).value=eduSeq;
	console.log(document.f.value);
	console.log(">>>>"+$('#eduSeq'+eduSeq).value);

	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}

function deleteEdu(eduId) {
	document.f.value=eduId;
	$('#eduId'+eduId).value=eduId;
	console.log(document.f.value); // ok
	console.log(">>>>"+$('#eduId'+eduId).value); // undefined

	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/

function addEdu() {
  // 새로운 요소를 생성하고 클래스 이름을 추가합니다.
  var newEduBlock = document.createElement("div");
  newEduBlock.classList.add("edu-block");
  // 새로운 요소의 내부 HTML을 설정합니다.
  newEduBlock.innerHTML = `
  <div class="resume-block">
	  <div class="inner">
	  <span class="name">E</span>
      <div class="title-box">
		  <div class="info-box">
		  
			  <input type=text name="eduMajor" placeholder="전공">
			  <input type=text th:field="*{eduDto.eduName}" name="eduName" placeholder="학교명">
		  </div>
<div class="edit-box">
      <!--
      <input type="datetime-local" name ="eduStartDate" placeholder="시작날짜">
      <input type="datetime-local" name ="eduEndDate" placeholder="종료날짜">
      -->
      <div class="edit-btns">
      <button type="button" onclick="createEdu()"><span class="la la-pencil"></span></button>
      <button type="button" onclick="updateEdu()"><span class="la la-pencil"></span></button>
      <button type="button"><span class="la la-trash"></span></button>
      </div>
       <div class="text">
      <!-- Input eduScore -->
      <div class="form-group col-lg-12 col-md-12">
        <label>학점</label>
        <input type="text" name="eduScore" placeholder="학점을 입력하세요.">
      </div>
       <!-- Input eduContent -->
      <div class="form-group col-lg-12 col-md-12">
        <label>추가 정보 입력</label>
         <input type="text" name="eduContent" placeholder="학력 관련 추가 정보를 입력하세요.">
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

function createEdu() {
	document.f.action = "edu-create";
	document.f.method="POST";
	document.f.submit();
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
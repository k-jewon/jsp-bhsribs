 function loginCheck(){
	if(document.login_form.email.value==0){
		alert("이메일을 써주세요");
		login_form.email.focus();
		return false;
	}
	if(document.login_form.pw.value==""){
		alert("비밀번호를 입력해주세요");
		login_form.pw.focus();
		return false;
	}
	return true;
}


function joinCheck(){
	if(document.join_form.name.value.length==0){
		alert("이름을 입력해주십시요");
		join_form.name.focus();
		return false;
	}
	if(document.join_form.email.value.length==0){
		alert("이메일을 입력해주십시요");
		join_form.email.focus();
		return false;
	}
	if(document.join_form.phone.value.length==0){
		alert("전화번호를 입력해주십시요");
		join_form.phone.focus();
		return false;
	}
	if(document.join_form.pw.value == "") {
      alert("비밀번호를 반드시 입력해주시기 바랍니다.")
      join_form.pw.focus();
      return false;
	}
	if(document.join_form.pw.value.length < 8){
		alert("비밀번호를 8글자 이상으로 작성해주세요");
		join_form.email.focus();
		return false;
	}
	if(document.join_form.pw.value != document.join_form.pw_check.value) {
	  alert("비밀번호가 일치하지 않습니다.")
	  join_form.pw.focus();
	  return false;
	}
	return true;

}
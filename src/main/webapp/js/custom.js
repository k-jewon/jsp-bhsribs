$('.menu_bar').click(function() {
		$('.menu_bar').toggleClass('active');
		$('.menu_item').toggleClass('active');
});
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

function menuCheck(){
	if(document.Menu_form.name.value.length==""){
		alert("메뉴 이름을 입력해주십시요");
		Menu_form.name.focus();
		return false;
	}else if(document.Menu_form.addr.value.length==""){
		alert("원산지를 입력해주십시요");
		Menu_form.addr.focus();
		return false;
	}else if(document.Menu_form.price.value.length==""){
		alert("메뉴가격을 입력해주십시요");
		Menu_form.price.focus();
		return false;
	}else if(document.Menu_form.price_100g.value.length==""){
		alert("100g당 메뉴가격을 입력해주십시요");
		Menu_form.price_100g.focus();
		return false;
	}else if(document.getElementById("pic").files.length == 0) {
      alert("메뉴 사진을 넣어주십시요");
      Menu_form.file.focus();
      return false;
	}else{
		return true;	
	}
}

function menuUpdateCheck(){
	if(document.Menu_update_form.name.value.length==""){
		alert("메뉴 이름을 입력해주십시요");
		Menu_update_form.name.focus();
		return false;
	}else if(document.Menu_update_form.addr.value.length==""){
		alert("원산지를 입력해주십시요");
		Menu_update_form.addr.focus();
		return false;
	}else if(document.Menu_update_form.price.value.length==""){
		alert("메뉴가격을 입력해주십시요");
		Menu_update_form.price.focus();
		return false;
	}else if(document.Menu_update_form.price_100g.value.length==""){
		alert("100g당 메뉴가격을 입력해주십시요");
		Menu_update_form.price_100g.focus();
		return false;
	}else if(document.getElementById("pic").files.length == 0) {
      alert("메뉴 사진을 넣어주십시요");
      Menu_update_form.file.focus();
      return false;
	}else{
		return true;	
	}
}

var selectChange = function(value){
	if(value == 1){
		$('.100g').removeClass('none');
		$('#100g').attr('value','');
		$('#addr').attr('value','');
	} else if (value == 2 ){
		$('.100g').addClass('none');
		$('#100g').attr('value','0');
		$('#addr').attr('value','해당없음');
	}
	
}


function change(){

var random=Math.random();
document.getElementById("ipic").src="verifycode.jsp?r="+random;

}



function check(){
	
	
	var id=document.getElementById("uid").value;
	var pwd=document.getElementById("pwd").value;
	var verify=document.getElementById("verifycode").value;
	
	if(id==""){
		alert("用戶名不能為空");
		return false;
	}
	
	if(pwd==""){
		alert("密碼不能為空");
		return false;
	}
	
	if(verify==""){
		alert("驗證碼不能為空");
		return false;
	}
	
	return true;
}
document.querySelector(".admission_form_toggle").addEventListener("click",function(){
    document.querySelector("#admissionVerify").style.display="block";
});
document.querySelector(".close_box").addEventListener("click",function(){
    document.querySelector("#admissionVerify").style.display="none";
});
document.querySelector(".teacher_form_toggle").addEventListener("click",function(){
    document.querySelector("#insertTeacher").style.display="block";
});
document.querySelector(".close_box2").addEventListener("click",function(){
    document.querySelector("#insertTeacher").style.display="none";
});

document.querySelector(".deleteStudent").addEventListener("click",function(){
	console.log("Del St");
	$("#deletionBox").css("display","block");
	document.querySelector("#deletionBox input[name=user]").value = "student";
	var s = document.querySelector("#deletionBox input[name=user]").value;
	console.log(s);
});
document.querySelector(".deleteTeacher").addEventListener("click",function(){
	console.log("del teach");
	$("#deletionBox").css("display","block");
	document.querySelector("#deletionBox input[name=user]").value = "teacher";
	var s = document.querySelector("#deletionBox input[name=user]").value;
	console.log(s);
});
document.querySelector("#closeDelBox").addEventListener("click",function(){
    document.querySelector("#deletionBox").style.display="none";
});
document.querySelector("#deletionBox button[name=deleteUser]").addEventListener("click",function(){
	if(confirm("Are you sure you want to delete?"))
	{
		document.querySelector("#deletionBox").submit();
	}
	else
	{
		console.log("Cancelled");
		window.location = "dashboardAdmin.jsp";
	}
});
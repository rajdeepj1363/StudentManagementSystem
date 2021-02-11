if(document.querySelector("input[name=student_teacher").value==="student")
  {
      $("#student").css("background-color","green");
      $("#teacher").css("background-color","#f5f5f5");
      $("#student").css("color","#fff");
  }
  if(document.querySelector("input[name=student_teacher").value==="teacher"){
      $("#teacher").css("background-color","green");
      $("#student").css("background-color","#f5f5f5");
      $("#teacher").css("color","#fff");
     
  }
  document.querySelector("#student").addEventListener("click",function(){
      console.log("Student activated");
      document.querySelector("input[name=student_teacher").value="student";
      console.log(document.querySelector("input[name=student_teacher").value);
      $("#student").css("background-color","green");
      $("#student").css("color","#fff");
      $("#teacher").css("background-color","#f5f5f5");
      $("#teacher").css("color","#000");
  });
  document.querySelector("#teacher").addEventListener("click",function(){
      console.log("Teacher activated");
      document.querySelector("input[name=student_teacher").value="teacher";
      console.log(document.querySelector("input[name=student_teacher").value);
      $("#teacher").css("background-color","green");
      $("#teacher").css("color","#fff");
      $("#student").css("background-color","#f5f5f5");
      $("#student").css("color","#000");
     
  });
  document.querySelector(".adminLogin").addEventListener("click",function(){
  	console.log("Inside ADmin js");
  	$(".adminLoginModal").css("display","block");
  	$(".form-signin").css("display","none");
  });
  document.querySelector(".closeAdminModal").addEventListener("click",function(){
  	
  	$(".adminLoginModal").css("display","none");
  	$(".form-signin").css("display","block");
  });
  
  

document.querySelector(".next").addEventListener("click",function(){
    
    if(document.querySelector(".tab2").style.display == "none" || document.querySelector(".tab2").style.display == "" )
    {
        console.log("first");
        document.querySelector(".next").innerHTML = "BACK";
        document.querySelector("#admissionForm .tab2").style.display = "block";
        document.querySelector("#admissionForm .tab1").style.display = "none";
        if(document.querySelector(".submitBtn") != null)
        document.querySelector(".submitBtn").style.display="inline";
       
    }
    else
    {
        console.log("second");
        document.querySelector(".next").innerHTML = "NEXT";
        document.querySelector("#admissionForm .tab1").style.display = "block";
        document.querySelector("#admissionForm .tab2").style.display = "none";
        if(document.querySelector(".submitBtn") != null)
        document.querySelector(".submitBtn").style.display="none";
    }
    
});

//Dashboard Admin JS



//Index Page JS

if(document.querySelector("input[name=student_teacher").value==="student")
{
    $("#student").css("background-color","green");
    $("#teacher").css("background-color","#f5f5f5");
    $("#student").css("color","#fff");
}
if(document.querySelector("input[name=student_teacher").value==="teacher"){
    $("#teacher").css("background-color","green");
    $("#student").css("background-color","#f5f5f5");
    $("#teacher").css("color","#fff");
   
}
document.querySelector("#student").addEventListener("click",function(){
    console.log("Student activated");
    document.querySelector("input[name=student_teacher").value="student";
    console.log(document.querySelector("input[name=student_teacher").value);
    $("#student").css("background-color","green");
    $("#student").css("color","#fff");
    $("#teacher").css("background-color","#f5f5f5");
    $("#teacher").css("color","#000");
});
document.querySelector("#teacher").addEventListener("click",function(){
    console.log("Teacher activated");
    document.querySelector("input[name=student_teacher").value="teacher";
    console.log(document.querySelector("input[name=student_teacher").value);
    $("#teacher").css("background-color","green");
    $("#teacher").css("color","#fff");
    $("#student").css("background-color","#f5f5f5");
    $("#student").css("color","#000");
   
});
document.querySelector(".adminLogin").addEventListener("click",function(){
	console.log("Inside ADmin js");
	$(".adminLoginModal").css("display","block");
	$(".form-signin").css("display","none");
});
document.querySelector(".closeAdminModal").addEventListener("click",function(){
	
	$(".adminLoginModal").css("display","none");
	$(".form-signin").css("display","block");
});

//Information Page JS


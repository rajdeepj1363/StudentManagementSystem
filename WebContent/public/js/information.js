document.querySelector(".editInfoBtn").addEventListener("click",function(){
	document.querySelector("#editInfo").style.display = "block";
	document.querySelector("#wrapper").style.display = "none";
	document.querySelector("#closeBtn").disabled = false;
});
document.querySelector("#closeBtn").addEventListener("click",function(){
	document.querySelector("#editInfo").style.display = "none";
	document.querySelector("#wrapper").style.display = "block";
	
});


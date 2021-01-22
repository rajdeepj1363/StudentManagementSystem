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


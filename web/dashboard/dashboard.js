for(var i=0;i<document.querySelectorAll(".tomodules").length;i++)
{
  document.querySelectorAll(".tomodules")[i].addEventListener("click",function(){
    var save1 = this.innerHTML;
    location.href = "test.html";
  });
}

for(var i=0;i<document.querySelectorAll(".toprob").length;i++)
{
  document.querySelectorAll(".toprob")[i].addEventListener("click",function(){
    var save2 = this.innerHTML;
    location.href = "test.html";
  });
}


for(var i=0;i<document.querySelectorAll(".logout").length;i++)
{
  document.querySelectorAll(".logout")[i].addEventListener("click",function(){
    var save3 = this.innerHTML;
    location.href = "test.html";
  });
}

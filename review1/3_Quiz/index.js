function loadPage()
{
    nooq ="<option value=\"1\" selected>1</option>"
    for (var i = 2; i <= 10; i++) {
        nooq += "<option value=" + i + ">" + i + "</option>\n"
    }
    document.getElementById("nooq").innerHTML=nooq

    
    if (document.getElementById("enablepin").checked==true)
    {
        document.getElementById("pin").disabled=false;
    }
    else{
        document.getElementById("pin").disabled = true;
    }
    changeNOOQ()
}

function togglePin()
{
    if (document.getElementById("enablepin").checked==true)
    {
        document.getElementById("pin").disabled=false;
    }
    else{
        document.getElementById("pin").disabled = true;
    }
}

function changeNOOQ()
{

    let count=parseInt(document.getElementById("nooq").value)

    cardlistinnerhtml ="<h2>Questions</h2><br>"
    for(var i=1;i<=count;i++)
    {
        cardlistinnerhtml += `<div class=\"card\">\n
            <div class=\"cardData\">\n
                <label for=\"exampleInputPassword1\">Question `+i+`</label>\n
                <input type=\"text\\" class=\"form-control\" id=\"question`+ i +`\">\n
            <br >\n
            <div class=\"form-row\">\n
            <div class=\"input-group col-md-2\">\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i +`a\" placeholder=\"option a\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i +`b\" placeholder=\"option b\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i +`c\" placeholder=\"option c\">\n
                          </div >\n
            <div class=\"input-group col-md-2\">\n
            <input type =\"text\" class=\"form-control\" id=\"opt`+ i +`d\" placeholder=\"option d\">\n
                          </div >\n
            <div class=\"form-group col-md-4\">\n
            <select id =\"correct`+ i +`\" class=\"form-control\">\n
            <option selected > Correct Option</option >\n
            <option value =\"a\">a</option>\n
            <option value =\"b\">b</option>\n
            <option value =\"c\">c</option>\n
            <option value =\"d\">d</option>\n
                                                </select >\n
                                            </div >\n
                                        </div >\n
                                    </div></div><br>`
    }
    document.getElementById("cardlist").innerHTML=cardlistinnerhtml
    
}
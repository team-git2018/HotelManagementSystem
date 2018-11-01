var c = 0;
var c1 = 0;

function register() {
  c1 = 0;
  c++;
  document.getElementById("loginbtn").style.color = "white";
  if(c % 2 == 0) {
    document.getElementById("registerbtn").style.color = "white";
  }
  else {
    document.getElementById("registerbtn").style.color = "rgb(238, 152, 13)";
  }
}

function login() {
  c = 0
  c1++
  document.getElementById("registerbtn").style.color = "white";
  if(c1 % 2 == 0) {
    document.getElementById("loginbtn").style.color = "white";
  }
  else {
    document.getElementById("loginbtn").style.color = "rgb(238, 152, 13)";
  }
}

$(document).ready(function(){
      $("#registerbtn").click(function(){
          $(".form2").slideUp(200, function() {
            $(".form1").slideToggle(200);
          });
      });
});

$(document).ready(function(){
      $("#loginbtn").click(function(){
        $(".form1").slideUp(200, function() {
          $(".form2").slideToggle(200);
        });
    });
});

$(document).ready(function(){
    $("#email").focusout(function validateemail() {
    var x=document.form1.Email.value;
    var atposition=x.indexOf("@");
    var dotposition=x.lastIndexOf(".");
    if(x != "") {
      if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){
        alert("Please enter a valid e-mail address");
        $("#email").val('');
        return false;
      }
    }
  });
});

$(document).ready(function(){
    $("#emailLogin").focusout(function validateemail() {
    var x=document.form2.Email.value;
    var atposition=x.indexOf("@");
    var dotposition=x.lastIndexOf(".");
    if(x != "") {
      if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){
        alert("Please enter a valid e-mail address");
        $("#emailLogin").val('');
        return false;
      }
    }
  });
});

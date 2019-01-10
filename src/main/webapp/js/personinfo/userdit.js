var storage=window.localStorage;
var jwt = storage["jwt"];
var name = storage["name"];
console.log("输出:"+jwt);

$('#btn-usredit').click = function() {
  $.ajax({
    type: "POST",
    url: "rentHomeProj_war/user/edit",
    async: false,
    data: $('#form-usredit').serialize(),
  });
};

$(document).ready(function() {
  $.ajax({
    type:"GET",
    url:"http://localhost:8080/rentHomeProj_war/user/personedit",
    dataType:"json",
    global:"false",
    success:function(data) {
      $('#usereditform').append(
          '<li>' + data.userid + '</li>' +
          '<li>' + data.usernickname + '</li>' +
          '<li>' + data.usertype + '</li>'
      )
    },
    /* success:function(data){
       alert(JSON.stringify(data));
     },*/
    error:function(){
      alert("Please Log In First");
      $(location).attr('href', '/rentHomeProj_war/signin');
    }
  })
});


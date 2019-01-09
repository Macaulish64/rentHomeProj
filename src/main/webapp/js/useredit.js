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
      alert("!!!Error");
    }
  })
});
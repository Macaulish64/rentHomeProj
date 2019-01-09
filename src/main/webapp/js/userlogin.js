var btn = $('#btn-signin');

btn.click(function() {
  /* $.ajax({
       type: "POST",
       url: "http://localhost:8080/rentHomeProj_war/user/login",
       dataType: 'json',
       global: "false"/!*,
       data: frm.serialize(),
       success:function(data) {
           alert("!!!success!!!")
           console.log(data)
         //  var json = jQuery.parseJSON(data);n
         //  var jwt = json.jwt;
           // 登录成功,存储令牌到本地
        //   localStorage["jwt"] = jwt;
        //   localStorage["name"] = json.name;
        //   console.log(jwt);
       },
       error:function(data){
           alert("!!!error!!!")
           console.log(data)
       }*!/
   });
   alert("Done");
   ev.preventDefault();*/
  /* var idList = new Array();
   idList.push("1");
   idList.push("2");
   idList.push("3");
   $.ajax({
       type:"POST",
       url:"http://localhost:8080/rentHomeProj_war/user/test2",
       data:{"idList[]":idList}
   })*/
 /* var form = $('#form-signin');
  var usrdata = {
    usernickname : form["usernickname"].val,
    password : form["password"].val
  };

  $.ajax({
    type : "POST",
    url : "/rentHomeProj_war/user/login",
    async : false,
    data : JSON.stringify(usrdata),
    contentType: "application/json",
    success : function() {
      $(location).attr('href', '/rentHomeProj_war/');
      alert("Success");
    },
    error : function(){ alert("Error");}
  })*/
  $.ajax({
    type:"POST",
    url:"http://localhost:8080/rentHomeProj_war/user/login",
    async: false,
    data:$('#form-signin').serialize(),
    contentType: "application/x-www-form-urlencoded",
    success:function(){
      console.log(data);
      var json = jQuery.parseJSON(data);
      var jwt = json.jwt;
      // 登录成功,存储令牌到本地
      localStorage["jwt"] = jwt;
      localStorage["name"] = json.name;
      console.log(jwt);
      $(location).attr('href', '/rentHomeProj_war/');
      alert("Success");
    },
    error:function(){alert("Error");}
  })

});

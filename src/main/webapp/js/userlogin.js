var storage=window.localStorage;
$('#btnsignin').click(function() {
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
    success:function(data){
      console.log(data);
      //alert(data);
      var json = jQuery.parseJSON(data);
     // alert(data['resmsg']);
      if (json.rescode === 10002) {
        alert("Success");
        var jwt = json.JWT;
        // 登录成功,存储令牌到本地
        //alert(jwt);
        storage["jwt"] = jwt;
        storage["username"] = json.username;
        storage["userid"]=json.userid;
        console.log(jwt);
        $(location).attr('href', '/rentHomeProj_war/');
      }
      else {
          alert("密码错误");
          $(location).attr('href', '/rentHomeProj_war/signin');
      }
      //alert(json.resmsg);
    },
    error:function(){alert("Error");}
  })

});

var frm=$('#form');
frm.submit(function(){
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
    var idList = new Array();
    idList.push("1");
    idList.push("2");
    idList.push("3");
   /* $.post("../user/test",{idList:idList})
        .success(function(){alert("Success");})
        .error(function(){alert("ERROR");});*/
    $.ajax({
        type:"POST",
        url:"http://localhost:8080/rentHomeProj_war/user/login",
        async: false,
        dataType: "json",
        data:frm.serialize(),
        contentType: "application/x-www-form-urlencoded",
        success:function(){alert("Success");},
        error:function(){alert("Error");}
    })
});

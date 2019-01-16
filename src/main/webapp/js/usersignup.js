var storage = window.localStorage;

function signup() {
  var http = new XMLHttpRequest();
  http.open('POST', 'http://localhost:8080/rentHomeProj_war/user/regist', true);
  http.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

  http.onreadystatechange = function (data) {
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
      console.log(data);
      var json = jQuery.parseJSON(data);

      if (json.rescode === 10002) {
        alert("Success");
        var jwt = json.JWT;
        // 登录成功,存储令牌到本地
        //alert(jwt);
        storage["jwt"] = jwt;
        storage["username"] = json.username;
        storage["userid"] = json.userid;
        console.log(jwt);
        $(location).attr('href', '/rentHomeProj_war/');
      }
    }
  };

  http.send($('#register').serialize());
}

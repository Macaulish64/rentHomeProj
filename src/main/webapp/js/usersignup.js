var storage = window.localStorage;

function signup() {
  var pw = document.getElementById('password');
  var content = pw.value;
  var all_num = true;
  for (var i = 0; i < content.length; i++) {
    if (content[i] < '0' || content[i] > '9') {
      all_num = false;
      break;
    }
  }
  if (all_num) {
    alert('密码不能全部是数字！');
    return;
  }


  var http = new XMLHttpRequest();
  http.open('POST', 'http://localhost:8080/rentHomeProj_war/user/regist', true);
  http.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

  http.onreadystatechange = function(xhttp) {
    return function () {
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        var data = jQuery.parseJSON(xhttp.responseText);

        alert(data.rescode);
        alert(data);
        console.log(data);
        // var json = jQuery.parseJSON(data);

        if (data.rescode === 10003) {
          alert("Success");
          var jwt = data.JWT;
          // 登录成功,存储令牌到本地
          //alert(jwt);
          storage["jwt"] = jwt;
          storage["userid"] = data.userId;
          console.log(jwt);
          $(location).attr('href', '/rentHomeProj_war/');
        }
      }
    }
  } (http);

  http.send($('#register').serialize());
}

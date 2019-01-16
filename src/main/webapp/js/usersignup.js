var storage = window.localStorage;

function signup() {
  var http = XMLHttpRequest();
  http.open('POST', 'localhost:8080/rentHomeProj_war/user/regist', false);

  var form = document.getElementById('register');

  var fd = new FormData();
  fd.open('usernickname', $('#usernickname').text());
  /*
          $.ajax({
            type: "POST",
            url: "http://localhost:8080/rentHomeProj_war/user/regist",
            async: false,
            data: $('register').serialize(),
            contentType: "application/x-www-form-urlencoded",
            success: function(data) {
              console.log(data);
              alert(data);
              var json = jQuery.parseJSON(data);
              if (json.rescode === 10002) {
                alert('success');
                var jwt = json.JWT;
                alert(jwt);
                storage["username"] = json.username;
                storage["userid"]=json.userid;
                console.log(jwt);
                $(location).attr('href', '/rentHomeProj_war/');
              }
            }
          });*/
}


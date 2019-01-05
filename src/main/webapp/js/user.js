function signup_sumbit(url) {
  var obj = {
    phonenumber:"123",
    usernickname:"haha",
    password:"qwe12345",
    cardtype:0
  };

  var http = new XMLHttpRequest();
  http.open("POST", url, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.onload = function() {
    // window.alert('yes! sign up');
  };

  var data = JSON.stringify(obj);
  http.send(data);
}

function signin_sumbit(url) {
  var obj = {
    usernickname:"haha",
    password:"qwe12345"
  };

  window.alert('@' + url + '@');

  var http = new XMLHttpRequest();
  http.open("POST", url, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.onload = function() {
   // window.alert('yes! sign in');
    window.alert(http.responseText);
  };

  var data = JSON.stringify(obj);
  http.send(data);
}



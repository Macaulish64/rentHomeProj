function signup_sumbit(url) {
  var obj = {
    phonenumber:"123",
    usernickname:"haha",
    password:"qwe12345",
    cardtype:0
  };

  var xhr = new XMLHttpRequest();
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");

  var data = JSON.stringify(obj);
  xhr.send(data);
}

function signin_sumbit(url) {
  var obj = {
    usernickname:"haha",
    password:"qwe12345"
  };

  var xhr = new XMLHttpRequest();
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");

  var data = JSON.stringify(obj);
  xhr.send(data);
}

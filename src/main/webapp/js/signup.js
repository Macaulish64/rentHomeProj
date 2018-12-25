function signup_sumbit() {
  var obj = {
    phonenumber:"123",
    usernickname:"haha",
    password:"qwe12345",
    cardtype:0
  };

  var xhr = new XMLHttpRequest();
  var url = document.getElementById("register").action;
  xhr.open("POST", url, true);
  xhr.setRequestHeader("Content-Type", "application/json");

  var data = JSON.stringify(obj);
  xhr.send(data);
}
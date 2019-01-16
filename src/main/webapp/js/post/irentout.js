var storage = window.localStorage;
var userid = storage['userid'];

$(document).ready(function() {
  alert('ready');
  $('#publishuserid').attr({"value": userid});
});

function submithouse() {
  var http = new XMLHttpRequest();
  http.open("POST",
    "http://localhost:8080/rentHomeProj_war/house/addhouse",
    true);
  http.setRequestHeader('Content-Type','application/x-www-form-urlencoded');

  http.onreadystatechange = function(xhttp) {
    return function() {
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        var data = jQuery.parseJSON(xhttp.responseText);

        alert(data.rescode);
        console.log(data);
        // var json = jQuery.parseJSON(data);

        if (data.rescode === 10003) {
          alert("Success");
          var jwt = data.JWT;
          // var userid = data.userId;
          storage['jwt'] = jwt;
          // storage['userid'] = userid;
          $(location).attr('href', '/rentHomeProj_war/landlord');
        }
      }
    }
  } (http);

  http.send($('#irentout-form').serialize());
}
var jwt = window.localStorage["jwt"];
var username = window.localStorage["username"];
var userid=window.localStorage['userid'];
console.log("输出:"+jwt);


//Jquery 加参数或减参数
/*1、取值使用
$.Request("act") = 1
2、url加参数
$.UrlUpdateParams(window.location.href, "mid", 11111),*/
(function ($) {
  $.extend({
    Request: function (m) {
      var sValue = location.search.match(new RegExp("[\?\&]" + m + "=([^\&]*)(\&?)", "i"));
      return sValue ? sValue[1] : sValue;
    },
    UrlUpdateParams: function (url, name, value) {
      var r = url;
      if (r != null && r != 'undefined' && r != "") {
        value = encodeURIComponent(value);
        var reg = new RegExp("(^|)" + name + "=([^&]*)(|$)");
        var tmp = name + "=" + value;
        if (url.match(reg) != null) {
          r = url.replace(eval(reg), tmp);
        }
        else {
          if (url.match("[\?]")) {
            r = url + "&" + tmp;
          } else {
            r = url + "?" + tmp;
          }
        }
      }
      return r;
    }
  });
})(jQuery);

$(document).ready(function () {
  var houseid = $.Request("house");
  if (houseid===null) {
    alert("房屋编号错误");
    //   $(location).attr('href', '/rentHomeProj_war/houselist');
  }
  else {
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/rentHomeProj_war/house/details/" + houseid,
      dataType: "json",
      global: "false",
      success: function (data) {
        if (data.rescode!==10003) {
          alert("房屋编号错误");
          return;
        }
        if (data.rentstatus === 0)
        var house=data.house;
        houseinformation(house);
      },
      error: function () {
        alert("房屋编号错误");
        // $(location).attr('href', '/house/list');
      }
    })
  }
});

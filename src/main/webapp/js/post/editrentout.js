var storage=window.localStorage;
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

function stringHouseTyde(data)
{
  if (data===0) return '一居';
  if (data===1) return '二居';
  if (data===2) return '三居';
  if (data===3) return '三居以上';
  return "";
}

function stringPaymentMethod(data)
{
  if (data===0) return '月租';
  if (data===1) return '季租';
  if (data===2) return '年租';
  return "";
}

function stringhouseStatus(data)
{
  if (data===0) return '已租';
  if (data===1) return '待租';
  return "";
}

function fillinput(house) {
  $('#houseid').attr({"value": house.houseid});
  $('#city').attr({"value": house.cityname});
  $('#community').attr({"value": house.communityname});
  $('#buildingnumber').attr({"value": house.buildingnumber});
  $('#housetype').attr({"value": stringHouseTyde(house.housetype)});
  $('#housearea').attr({"value": house.housearea});
  $('#floornumber').attr({"value": house.floornumber});
  $('#elevatorornot').attr({"value": house.elevatorornot});
  $('#depositmoney').attr({"value": house.depositmoney});
  $('#rentmoney').attr({"value": house.rentmoney});
}

$(document).ready(function () {
  var houseid = $.Request("house");
  jwt = storage["jwt"];
  userid=storage['userid'];
  username = storage["username"];
  console.log("输出:"+jwt);
  if (userid != null) {
    $('#linksignin').prop('href', "/rentHomeProj_war/personview");
    $('#linksignin').html("个人中心");
    $('#linksignup').prop('href', "");
    $('#linksignup').html("注销");
    $('#linksignup').prop("id","longout");
    $('#longout').bind('click',function(){
      localStorage.clear();
      alert("注销成功");
      $(this).unbind('click');
      $(location).attr('href', "/rentHomeProj_war");
    })
  };
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
        var house=data.house;
        if (house.housestatus === 1) {
          alert('房屋已出租');
          return;
        }

        fillinput(house);
      },
      error: function () {
        alert("房屋编号错误");
        // $(location).attr('href', '/house/list');
      }
    })
  }
});

function submitchange() {
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/rentHomeProj_war/house/updatehouse", true);
  http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

  http.onreadystatechange = function(xhttp) {
    return function() {
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
        var data = jQuery.parseJSON(xhttp.responseText);

        alert(data.rescode);
        console.log(data);
        // var json = jQuery.parseJSON(data);

        if (data.rescode === 10003) {
          alert("Success");
          $(location).attr('href', '/rentHomeProj_war/landlordhouselist');
        }
      }
    }
  } (http);

  http.send($('#editrentout-form').serialize());
}

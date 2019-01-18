var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var myDate=new Date();
console.log("输出:"+jwt);

function stringUserType(data)
{
  if (data===0) return '普通用户';
  if (data===1) return '管理员';
}

function stringUserLevel(data)
{
  if (data===0) return '一般';
  if (data===1) return '重要';
  if (data===2) return '钻石级';
}

function stringcardType(data) {
  if (data === 0) return '身份证';
  if (data === 1) return '护照';
}

var phobut=$('#phonenumber');

function personinformation(data)
{
  if ($("input").attr("value") == "") {
    $(this).attr({"value": "请输入要查询的问题"});
  }

  $('#usernickname').attr({"value":data.usernickname});
  if (data.usernickname ===null) {
    $('#usernickname').attr({"value":"空"});
  }

  $('#userid').attr({"value":data.userid});
  if (data.userid ===null) {
    $('#userid').attr({"value":"空"});
  }

  $('#userlevel').attr({"value":stringUserLevel(data.userlevel)});
  if (data.userlevel ===null) {
    $('#userlevel').attr({"value":"空"});
  }

  phobut.attr({"value":data.phonenumber});
  if (data.phonenumber ===null) {
    phobut.attr({"value":"空"});
  }

  $('#username').attr({"value":data.username});
  if (data.username ===null) {
    $('#username').attr({"value":"空"});
  }

  $('#cardtype').attr({"value":stringcardType(data.cardtype)});
  if (data.cardtype ===null) {
    $('#cardtype').attr({"value":"空"});
  }


  $('#idnumber').attr({"value":data.idnumber});
  if (data.idnumber ===null) {
    $('#idnumber').attr({"value":"空"});
  }

  $('#registcity').attr({"value":data.registcity});
  if (data.registcity ===null) {
    $('#registcity').attr({"value":"空"});
  }

  $('#updatetime').attr({"value":data.updatetime});
  if (data.updatetime ===null) {
    $('#updatetime').attr({"value":"空"});
  }

}

$(document).ready(function() {
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
  }
  else {
    alert("请先登陆");
    $(location).attr('href', '/rentHomeProj_war/signin');
  };
  $.ajax({
    headers: {
      Authorization : jwt,
      'username' : username,
      'userid' : userid
    },
    type:"GET",
    url:"http://localhost:8080/rentHomeProj_war/user/personinfo/"+userid,
    dataType:"json",
    global:"false",
    success:function(data) {
      personinformation(data);

    },
    error:function(data){
      alert("Please Log In First");
      $(location).attr('href', '/rentHomeProj_war/signin');
    }
  })
});

$('#personedit-btn-yes').click(function() {
  var nstr=phobut.prop('value');
  alert(nstr);
  $.ajax({
    headers: {
      Authorization : jwt,
      'username' : username,
      'userid' : userid
    },
    type:"POST",
    url:"http://localhost:8080/rentHomeProj_war/user/personedit/"+userid,
    dataType:"json",
    global:"false",
    data:{"phonenumber":nstr},
    success:function(data) {
      if (data.rescode===10003) {
        alert("修改成功");
        window.location.reload();
      }
      else {
        alert("修改失败，请重试");
      }
    },
    error:function(data){
      alert("修改失败，请重试");
    }
  })
})


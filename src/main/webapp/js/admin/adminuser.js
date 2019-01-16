var jwt = window.localStorage["jwt"];
var username = window.localStorage["username"];
var userid=window.localStorage['userid'];
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

function stringcardType(data)
{
    if (data===0) return '身份证';
    if (data===1) return '护照';
}

function toshowuserlist(data)
{
    var i;
    if (data.length===0) return;
    for(i=0;i<data.length;i++) {
        $('#adminuserlist').append(
            '<tr>'+
            '<td>'+data[i].userid+'</td>'+
            '<td>'+data[i].usernickname+'</td>'+
            '<td>'+stringUserType(data[i].usertype) +'</td>'+
            '<td>'+data[i].username+'</td>'+
            '<td>'+stringcardType(data[i].cardtype)+'</td>'+
            '<td>'+data[i].idnumber+'</td>'+
            '<td>'+data[i].phonenumber +'</td>'+
            '<td>'+stringUserLevel(data[i].userlevel)+'</td>'+
            '<td>'+data[i].registcity+'</td>'+
            '<td>'+data[i].updatetime+'</td>'+
            '<tr>'+'</tr>'
        );
    }
}

$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/admin/adminuserlist",
        dataType:"json",
        global:"false",
        success:function(data) {
            //   alert(data);
            toshowuserlist(data.list);
        },
        /* success:function(data){
           alert(JSON.stringify(data));
         },*/
        error:function(){
            alert("Please Log In First");
            // $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});
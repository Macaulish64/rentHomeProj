var storage=window.localStorage;
var jwt = window.localStorage["jwt"];
var username = window.localStorage["username"];
var userid=window.localStorage['userid'];
console.log("输出:"+jwt);

function deletehouse(houseid)
{
    var http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8080/rentHomeProj_war/house/deletehouse", true);
    http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    http.onreadystatechange = function(xhttp) {
        return function() {
            if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
                var data = jQuery.parseJSON(xhttp.responseText);

                // alert(data.rescode);
                console.log(data);
                // var json = jQuery.parseJSON(data);

                if (data.rescode === 10003) {
                    alert("删除房屋成功");
                    $(location).attr('href', '/rentHomeProj_war/landlordhouselist');
                }
            }
        }
    } (http);

    http.send('houseid=' + houseid);
}

function stringHave(data)
{
    if (data===0) return '有';
    if (data===1) return '无';
}

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
    if (data===0) return '待租';
    if (data===1) return '已租';
    return "";
}
function toshowhouselist(data)
{
    var i;
    if (data.length===0) return;
    for(i=0;i<data.length;i++) {
        if (data[i].housestatus === 0) {
            $('#ownerhouselist').append(
              '<tr>' +
              '<td>' + data[i].houseid + '</td>' +
              '<td>' + data[i].cityname + '</td>' +
              '<td>' + data[i].communityname + '</td>' +
              '<td>' + data[i].buildingnumber + '</td>' +
              '<td>' + stringHouseTyde(data[i].housetype) + '</td>' +
              '<td>' + data[i].housearea + '平米' + '</td>' +
              '<td>' + data[i].floornumber + '</td>' +
              '<td>' + stringHave(data[i].elevatorornot) + '</td>' +
              '<td>' + '￥' + data[i].depositmoney + '</td>' +
              '<td>' + stringPaymentMethod(data[i].paymentmethod) + '</td>' +
              '<td>' + '￥' + data[i].rentmoney + '</td>' +
              '<td>' + data[i].registtime + '</td>' +
              '<td>' + data[i].updatetime + '</td>' +
              '<td>' + stringhouseStatus(data[i].housestatus) + '</td>' +
              '<td><a href="/rentHomeProj_war/editrentout?house=' + data[i].houseid + '">' +
              '<i class="fa fa-edit"></i></a></td>' +
              '<td><a href="#" onclick="deletehouse(' + data[i].houseid + ')">' +
              '<i class="fa fa-trash-o"></i></a></td>' +
              '</tr>'
            );
        }
        else {
            $('#ownerhouselist').append(
              '<tr>' +
              '<td>' + data[i].houseid + '</td>' +
              '<td>' + data[i].cityname + '</td>' +
              '<td>' + data[i].communityname + '</td>' +
              '<td>' + data[i].buildingnumber + '</td>' +
              '<td>' + stringHouseTyde(data[i].housetype) + '</td>' +
              '<td>' + data[i].housearea + '平米' + '</td>' +
              '<td>' + data[i].floornumber + '</td>' +
              '<td>' + stringHave(data[i].elevatorornot) + '</td>' +
              '<td>' + '￥' + data[i].depositmoney + '</td>' +
              '<td>' + stringPaymentMethod(data[i].paymentmethod) + '</td>' +
              '<td>' + '￥' + data[i].rentmoney + '</td>' +
              '<td>' + data[i].registtime + '</td>' +
              '<td>' + data[i].updatetime + '</td>' +
              '<td>' + stringhouseStatus(data[i].housestatus) + '</td>' +
              '</tr>'
            );
        }
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
    };
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/house/ownerhouselist/"+userid,
        dataType:"json",
        global:"false",
        data:{ op : 0 },
        success:function(data) {
         //   alert(data);
            toshowhouselist(data);
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
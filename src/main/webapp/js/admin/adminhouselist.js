var storage=window.localStorage;
var jwt = window.localStorage["jwt"];
var username = window.localStorage["username"];
var userid=window.localStorage['userid'];
console.log("输出:"+jwt);

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
        $('#ownerhouselist').append(
            '<tr>'+
            '<td>'+data[i].houseid+'</td>'+
            '<td>'+data[i].cityname+'</td>'+
            '<td>'+data[i].communityname +'</td>'+
            '<td>'+data[i].buildingnumber +'</td>'+
            '<td>'+stringHouseTyde(data[i].housetype)+'</td>'+
            '<td>'+data[i].housearea+'平米'+'</td>'+
            '<td>'+data[i].floornumber+'</td>'+
            '<td>'+data[i].elevatorornot +'</td>'+
            '<td>'+'￥'+data[i].depositmoney+'</td>'+
            '<td>'+stringPaymentMethod(data[i].paymentmethod)+'</td>'+
            '<td>'+'￥'+data[i].rentmoney  +'</td>'+
            '<td>'+data[i].registtime  +'</td>'+
            '<td>'+data[i].updatetime  +'</td>'+
            '<td>'+stringhouseStatus(data[i].housestatus)+'</td>'+
            '<tr>'+'</tr>'
        );
    }
}

$(document).ready(function() {
    if (username!="admin") {
        alert("权限不足");
        $(location).attr('href', '/rentHomeProj_war');
    }
    var list1=[];
    var map={};
    map["no"]=list1;
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/admin/adminhouselist",
        dataType:"json",
        global:"false",
        data:{"map":JSON.stringify(map)},
        success:function(data) {
         //   alert(data);
            toshowhouselist(data.list);
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
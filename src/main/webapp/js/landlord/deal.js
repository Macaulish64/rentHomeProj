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
    if (data===0) return '待确认';
    if (data===1) return '已确认';
    return "";
}

function toshowtransactionlist(data)
{
    var i;
    if (data.length===0) return;
    for(i=0;i<data.length;i++) {
        if (data[i].rentstatus === 0)
        {
            $('#pretranslist').append(
                '<tr>'+
                '<td>'+data[i].transactionid+
                '<a class="button" style="alignment:center" ' +
                'href="checktransaction?trans='+data[i].transactionid+'">'+
                '</td>'+
                '<td>'+data[i].houseid+'</td>'+
                '<td>'+data[i].landlordid +'</td>'+
                '<td>'+data[i].tenantid +'</td>'+
                '<td>'+data[i].transactiondate +'</td>'+
                '<td>'+data[i].startmonth +'</td>'+
                '<td>'+data[i].endmonth +'</td>'+
                '<td>'+'￥'+data[i].depositmoney +'</td>'+
                '<td>'+'￥'+data[i].totalrent+'</td>'+
                '<td>'+'￥'+data[i].landlordpaymentagencyfee +'</td>'+
                '<td>'+'￥'+data[i].tenantpaymentagencyfee+'</td>'+
                //'<td>'+stringhouseStatus(Number(data[i].rentstatus))+'</td>'+
                '<tr>'+'</tr>'
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
        url:"http://localhost:8080/rentHomeProj_war/trans/queryownerTransaction/"+userid,
        dataType:"json",
        global:"false",
        data:{ op :0 },
        success:function(data) {
            toshowtransactionlist(data);
        },
        error:function(){
           alert("Please Log In First");
           // $(location).attr('href', '/rentHomeProj_war/signin');
        }
     })
 });

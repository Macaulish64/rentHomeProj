var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var trans;
console.log("输出:"+jwt);

var startmonth,endmonth;

function calcudate(){
    var date1=$('#premonth').val();
    var y1=date1.split("-")[0];
    var m1=date1.split("-")[1];

    var date2=$('#edmonth').val();
    var y2=date2.split("-")[0];
    var m2=date2.split("-")[1];

    startmonth=data1;
    endmonth=data2;
}


function toshownumber(data)
{
    $('#total-transaction-number').text(data.transnum);
    $('#total-rent-money').text(data.rentnum);
    $('#total-deposit-money').text(data.deppsitnum);
    $('#total-agency-fee').text(data.feenum);
}

function getdata()
{
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/statisticsroomer/"+userid,
        dataType:"json",
        global:"false",
        data:{ "startmonth" :startmonth,
            "endmonth" : endmonth},
        success:function(data) {
            toshownumber(data);
        },
        error:function(){
            alert("Please Log In First");
            // $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
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
    $('#button-to-as').on('click',getdata());
    getdata();
});

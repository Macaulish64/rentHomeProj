var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var myDate=new Date();
console.log("输出:"+jwt);

var monthmoney;

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

function number_format(number) {
    /*
    * 参数说明：
    * number：要格式化的数字
    * decimals：保留几位小数
    * dec_point：小数点符号
    * thousands_sep：千分位符号
    * */
    var dec_point='.';
    var thousands_sep=',';
    var decimals=2;
    number = (number + '').replace(/[^0-9+-Ee.]/g, '');
    var n = !isFinite(+number) ? 0 : +number,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function (n, prec) {
            var k = Math.pow(10, prec);
            return '' + Math.ceil(n * k) / k;
        };

    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
    var re = /(-?\d+)(\d{3})/;
    while (re.test(s[0])) {
        s[0] = s[0].replace(re, "$1" + sep + "$2");
    }

    if ((s[1] || '').length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1).join('0');
    }
    return s.join(dec);
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

function calcudate(){
    var date1=$('#premonth').val();
    var y1=date1.split("-")[0];
    var m1=date1.split("-")[1];

    var date2=$('#edmonth').val();
    var y2=date2.split("-")[0];
    var m2=date2.split("-")[1];

    moneycount =Number(y2-y1)*Number(12)+Number(m2-m1)+1;
    return moneycount;
}

function updatamoney()
{
    longtime=calcudate();
    if ( longtime < 0 ) longtime=0;
    var allmoney=monthmoney*longtime;
    var middlemoney=Number(allmoney*0.03);
    $('#rentmoney').prop('value','￥'+number_format(allmoney));
    $('#landlordagenctfee').prop('value','￥'+number_format(middlemoney));
    $('#tenantagencyfee').prop('value','￥'+number_format(middlemoney));
}


var ahouseid;

function transactionformation(data)
{
    ahouseid=data.houseid;
    $('#houseid').prop('value',ahouseid)
    if (ahouseid ===null) {
        $('#houseid').prop('value',"空")
    }

    alandlordid=data.publishuserid;
    $('#landlordid').prop('value',data.publishuserid)
    if (data.publishuserid ===null) {
        $('#landlordid').prop('value',"空")
    }

    $('#tenantid').prop('value',userid);

    $('#depositmoney').prop('value',data.depositmoney);
    if (data.depositmoney ===null) {
        $('#depositmoney').prop('value',"空")
    }

    monthmoney=data.rentmoney;

    var year = myDate.getFullYear();
    var month = myDate.getMonth() + 1;
    if (month < 10) {
        month = "0" + (month);
    }
    var nowDate = (year) + "-" + (month);
    $('#premonth').val(nowDate);
    var strtime=$('#premonth').val();
    //alert(strtime);
    console.log("!"+strtime);
};


function houseinformation(data) {
    $('#housedescription').html(data.housedescription);
    $('#houseprice').append(Number(data.rentmoney)+"/月");
}

$(document).ready(function () {
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
    }
    $('#submit-btn2').on('click',function b(){
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/rentHomeProj_war/trans/submittransaction",
            dataType: "json",
            global: "false",
            data:{ userid : userid,
                houseid : ahouseid,
                startmonth : $('#premonth').val(),
                endmonth : $('#edmonth').val(),
                monthcount : longtime
            },
            success: function (data) {
                if (data.rescode !== 10003) {
                    alert("交易请求失败,请再试一次");
                    return;
                }
                alert("交易申请成功");
                trans=data.transId;
                $(location).attr('href', 'checktransaction?trans='+trans);
            },
            error: function () {
                alert("交易申请失败,请再试一次");
                // $(location).attr('href', '/house/list');
            }
        })
    });
    /*当开始时间改变时*/
    $('#premonth').bind("change input keyup", function(){
        updatamoney();
    });
    /*当结束时间改变时*/
    $('#edmonth').bind("change input keyup",function(){
        updatamoney();
    });
    if ($.Request("house")!==null) storage["house"]=$.Request("house");
    houseid=storage["house"];
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
                if (data.rescode !== 10003) {
                    alert("房屋编号错误");
                    return;
                }
                var house = data.house;
                houseinformation(house);
                if (house.rentstate === 1) {
                    alert("房子已出租，请选择其他房源");
                } else {
                    transactionformation(house);
                    updatamoney();
                }
            },
            error: function () {
                alert("房屋编号错误");
                // $(location).attr('href', '/house/list');
            }
        })
    }
  //  alert($('#submitbtn').prop("id"));
});

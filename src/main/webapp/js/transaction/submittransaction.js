var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var myDate=new Date();
console.log("输出:"+jwt);

var startdate=$('#startmonth');
var enddate=$('#endmonth');
var monthmoney;

alert("time"+$('#startmonth').val());
alert("time"+$('#startmonth').value);
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
    if (data===1) return '一居';
    if (data===2) return '二居';
    if (data===3) return '三居';
    if (data===4) return '三居以上';
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


function transactionformation(data)
{
    $('#houseid').prop('value',data.houseid)
    if (data.houseid ===null) {
        $('#houseid').prop('value',"空")
    }

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
    startdate.val(nowDate);
    alert(startdate.val());
};



$(document).ready(function() {
    var houseid=$.Request("house");
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
                if (house.rentstate===1) {
                    alert("房子已出租，请选择其他房源");
                }
                else {
                    transactionformation(house);
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

function calcudate(){
    var date1=startdata.val();
    var y1=date1.split("-")[0];
    var m1=date1.split("-")[1];

    var date2=enddata.val();
    var y2=date2.split("-")[0];
    var m2=date2.split("-")[1];

    var moneyCount =(y2-y1)*12+m2-m1;
    return moneyCount;
}


function updatamoney()
{
    $('#rentmoney').prop('value',monthmoney*longtime);
}

/*当开始时间改变时*/
startdate.change(function(){
    longtime=calcudate();
    if ( longtime < 0 ) longtime=0;
    updatamoney();
});
/*当结束时间改变时*/
enddate.bind('input propertychange',function(event){
    longtime=calcudate();
    if ( longtime < 0 ) longtime=0;
    updatamoney();
});








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


function houseinformation(data)
{
    $('#housedescription').html(data.housedescription);

    $('#houseid').append(
        data.houseid
    );
    if (data.houseid ===null) {
        $('#houseid').append(
            "空"
        );
    }

    $('#cityname').append(
        data.cityname
    );
    if (data.cityname ===null) {
        $('#cityname').append(
            "空"
        );
    }

    $('#communityname').append(
        data.communityname
    );
    if (data.communityname ===null) {
        $('#communityname').append(
            "空"
        );
    }

    $('#housetype').append(
        stringHouseTyde(data.housetype)
    );
    if (data.housetype ===null) {
        $('#housetype').append(
            "空"
        );
    }

    $('#housearea').append(
        data.housearea
    );
    if (data.housearea ===null) {
        $('#housearea').append(
            "空"
        );
    }

    $('#buildingnumber').append(
        data.buildingnumber
    );
    if (data.housearea ===null) {
        $('#housearea').append(
            "空"
        );
    }

    $('#floornumber').append(
        data.floornumber
    );
    if (data.floornumber ===null) {
        $('#floornumber').append(
            "空"
        );
    }

    $('#idnumber').append(
        data.idnumber
    );
    if (data.idnumber ===null) {
        $('#idnumber').append(
            "空"
        );
    }


    if (data.elevatorornot ===null) {
        $('#elevatorornot').append(
            "空"
        );
    }
    else {
        var str;
        if (data.elevatorornot===0) str='YES'
        else str='NO';
        $('#elevatorornot').append(
            str
        );
    }

    $('#depositmoney').append(
        "￥"+data.depositmoney
    );
    if (data.depositmoney ===null) {
        $('#depositmoney').append(
            "空"
        );
    }

    $('#rentmoney').append(
        '￥'+data.rentmoney
    );
    if (data.rentmoney ===null) {
        $('#rentmoney').append(
            "空"
        );
    }
    $('#houseprice').append(
        Number(data.rentmoney)+"/月"
    );


    $('#paymentmethod').append(
        stringPaymentMethod(data.paymentmethod)
    );
    if (data.paymentmethod ===null) {
        $('#paymentmethod').append(
            "空"
        );
    }

    $('#registtime').append(
        data.registtime
    );
    if (data.registtime ===null) {
        $('#registtime').append(
            "空"
        );
    }

    $('#updatetime').append(
        data.updatetime
    );
    if (data.updatetime ===null) {
        $('#updatetime').append(
            "空"
        );
    }


    if (data.housestatus===1) {
        $('#submit-btn').html("已出售");
        $('#submit-btn').prop('class',"btn btn-danger");
        $('#submit-btn').prop('id',"faile-btn");
    }
};



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
                houseinformation(house);
            },
            error: function () {
                alert("房屋编号错误");
                // $(location).attr('href', '/house/list');
            }
        })
    }
    $('#submit-btn').on('click',function(){
        var houseid=$.Request("house");
        if (houseid===null) {
            alert("房屋编号错误");
            $(location).attr('href', '/rentHomeProj_war/houselist');
        }
        var url='/rentHomeProj_war/transaction?house='+houseid;
        $(location).attr('href',url);
    });
});

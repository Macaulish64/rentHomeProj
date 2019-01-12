var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var trans;
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
    $('#transactionid').prop('value',trans)
  /*  if (data.transactionid ===null) {
        $('#transactionid').prop('value',"空")
    }*/

    $('#houseid').prop('value',data.houseid)
    if (data.houseid ===null) {
        $('#houseid').prop('value',"空")
    }

    $('#landlordid').prop('value',data.publishuserid)
    if (data.publishuserid ===null) {
        $('#landlordid').prop('value',"空")
    }

    $('#tenantid').prop('value',data.tenantid)
    if (data.tenantid ===null) {
        $('#tenantid').prop('value',"空")
    }

    $('#transactiondate').prop('value',data.transactiondate)
    if (data.transactiondate ===null) {
        $('#transactiondate').prop('value',"空")
    }



    $('#premonth').prop('value',data.premonth)
    if (data.premonth ===null) {
        $('#premonth').prop('value',"空")
    }

    $('#edmonth').prop('value',data.edmonth)
    if (data.edmonth ===null) {
        $('#edmonth').prop('value',"空")
    }


    $('#depositmoney').prop('value',data.depositmoney);
    if (data.depositmoney ===null) {
        $('#depositmoney').prop('value',"空")
    }

    $('#rentmoney').prop('value',data.rentmoney);
    if (data.rentmoney ===null) {
        $('#rentmoney').prop('value',"空")
    }

    $('#landlordagenctfee').prop('value',data.landlordagenctfee);
    if (data.landlordagenctfee ===null) {
        $('#landlordagenctfee').prop('value',"空")
    }

    $('#tenantagencyfee').prop('value',data.tenantagencyfee);
    if (data.tenantagencyfee ===null) {
        $('#tenantagencyfee').prop('value',"空")
    }

    $('#rentstatus').prop('value',stringhouseStatus(data.rentstatus));


    if (data.landlordid === userid && data.rentstate===0) {
        $('#morebutton').append(
            "<button id='confirmtransbtn' type='submit' class='btn btn-primary'>"+
            "确认交易"+
            "</button>"
        )
    }
    console.log("!"+strtime);
};



$(document).ready(function() {
    trans=$.Request("trans");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rentHomeProj_war/transaction/details/" + trans,
        dataType: "json",
        global: "false",
        success: function (data) {
            if (data.rescode !== 10003) {
                alert("交易号错误");
                return;
            }
            var transinform = data.RentTransaction;
            transactionformation(transinform);
        },
        error: function () {
            alert("交易号错误");
            // $(location).attr('href', '/house/list');
        }
    })
    //  alert($('#submitbtn').prop("id"));
});

$('#confirmtransbtn').click(function(){
     $.ajax({
        type: "POST",
        url: "http://localhost:8080/rentHomeProj_war/transaction/submittransaction/" + trans,
        dataType: "json",
        global: "false",
        success: function (data) {
            if (data.rescode !== 10003) {
                alert("交易请求失败,请再试一次");
                return;
            }
            else {
                alert("已成功确认");
                window.location.reload();
            }
        },
        error: function () {
            alert("交易请求失败,请再试一次");
            // $(location).attr('href', '/house/list');
        }
    })
});








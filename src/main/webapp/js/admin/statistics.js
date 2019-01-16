var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var trans;
console.log("输出:"+jwt);



var datamonth=[];
var monthMin,monthMax,area;


// 这个是折线方法
var fnLineChart = function (eles) {
    [].slice.call(eles).forEach(function (ele, index) {
        var eleNext = eles[index + 1];
        if (!eleNext) { return;  }
        var eleLine = ele.querySelector('i');
        if (!eleLine) {
            eleLine = document.createElement('i');
            eleLine.setAttribute('line', '');
            ele.appendChild(eleLine);
        }
        // 记录坐标
        var boundThis = ele.getBoundingClientRect();
        // 下一个点的坐标
        var boundNext = eleNext.getBoundingClientRect();
        // 计算长度和旋转角度
        var x1 = boundThis.left, y1 = boundThis.top;
        var x2 = boundNext.left, y2 = boundNext.top;
        // 长度
        var distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        // 弧度
        var radius = Math.atan((y2 - y1) / (x2 - x1));
        // 设置线条样式
        eleLine.style.width = distance + 'px';
        eleLine.style.msTransform = 'rotate('+ radius +'rad)';
        eleLine.style.transform = 'rotate('+ radius +'rad)';
    });
};


// 浏览器尺寸改变时候
window.addEventListener('resize', function () {
    fnLineChart(trans);
    fnLineChart(agency);
});

function calccity()
{
    area=$('#city option:selected').text();
}

function calcudate(){
    var date1=$('#premonth').val();
    var y1=date1.split("-")[0];
    var m1=date1.split("-")[1];

    var date2=$('#edmonth').val();
    var y2=date2.split("-")[0];
    var m2=date2.split("-")[1];

    monthMin=date1;
    monthMax=date2;
}

function getmonth(date)
{
    var y2=date.split("-")[0];
    var m2=date.split("-")[1];
    return Number(y2)*100+Number(m2);
}


function todrawview(name,list,big)
{
    if (list.length===0) return;
    $('#'+name).html("");
    $('#'+name).append('<div id="'+name+'m'+'" class="result-xy"></div>');
    for(var i=0;i<list.length;i++) {
    $('#'+name+'m').append(
        '<div class="result-bg" data-month='+getmonth(list[i]['x'])+'>'+
        '<span class="result-bar" style="height:'+list[i]['y']/big*100+'%"><s title="'+
        list[i]['y']+'"></s></span>'+
        '</div>'
    )}

    var trans = document.querySelectorAll('#'+name+'m s');
    fnLineChart(trans);
}


function toshowdata(data)
{
    var list=data.list;
    var alltransnum=data.transactionNum,alltransmoney=data.feeIncome;
    //alert(alltransnum+"--"+alltransmoney);
    var drawlist=[];
    var big=0;
    for(var i=0;i<list.length;i++) {
        var point={};
        point['x']=list[i].month;
        point['y']=Number(list[i].transactionnum);
        if (point['y']>big) big=point['y'];
        drawlist.push(point);
    }
    todrawview("viewtransnum",drawlist,big);
    drawlist=[];
    for(var i=0;i<list.length;i++) {
        var point={};
        point['x']=list[i].month;
        point['y']=list[i].feeincome;
        if (point['y']>big) big=point['y'];
        drawlist.push(point);
    }
    todrawview("viewtransmoney",drawlist,big);
}

function getdata()
{
    var map={};
    calcudate();
    calccity();
    var list1=[],list2=[],list3=[];

    if (monthMin==='') monthMin="2018-06-01 00:00:00";
    if (monthMax==='') monthMax="2019-12-01 99:99:99";
    list1[0]=monthMin;
    map["monthMin"]=list1;
    list2[0]=monthMax;
    map["monthMax"]=list2;
    list3[0]=area;
    map["area"]=list3;
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/admin/adminincomelist",
        dataType:"json",
        global:"false",
        data: {"map":JSON.stringify(map)},
        success:function(data) {
            toshowdata(data);
        },
        error:function(){
            alert("Please Log In First");
            // $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })



}


$(document).ready(function() {
    $('#button-to-get').on('click',getdata());
    getdata();
});

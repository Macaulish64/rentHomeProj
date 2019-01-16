var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var trans;
console.log("输出:"+jwt);



var datamonth=[];
var monthMin,monthMax,area;

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

    monthMin=data1;
    monthMax=data2;
}


function todrawview(name,list,big)
{
    for(var i=0;i<list.length;i++) {
        $('#'+name).append(
            '<div class="result-bg" data-month='+list[i]['x']+'>'+
                '<span class="result-bar" style="height:'+list[i]['y']/big*100+'%"><s title="'+
                list[i]['y']+'"></s></span>'+
            '</div>'

    )};
}


function toshowdata(data)
{
    var list=data.list;
    var alltransnum=data.transactionNum,alltransmoney=data.feeIncome;
    alert(alltransnum+"--"+alltransmoney);
    var point={};
    var drawlist=[];
    var big=0;
    for(var i=0;i<list.length;i++) {
        point['x']=list[i].month;
        point['y']=Number(list[i].transactionnum);
        if (point['y']>big) big=point['y'];
        drwalist.put(point);
    }
    todrawview("viewtransnum",drwalist,big);
    drawlist=[];
    for(var i=0;i<list.length;i++) {
        point['x']=list[i].month;
        point['y']=list[i].feeincome;
        if (point['y']>big) big=point['y'];
        drwalist.put(point);
    }
    todrawview("viewtransmoney",drwalist,big);
}

void getdata()
{
    var map={};
    calcudate();
    calccity();
    map.put("monthMin",monthMin);
    map.put("monthMax",monthMax);
    map.put("area",area);
    var str=JSON.stringify(map);
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
        data: str,
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

var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage['userid']
console.log("输出:"+jwt);

$(document).ready(function() {
    $('#search-btn').on('click',function() {
        var str=$('#search-text').val();
        var url='/rentHomeProj_war/houselist?searchbar='+str;
        $(location).attr('href',url);
    });
    $('#linkpresonview').on('click',function(){
        window.location.href="/rentHomeProj_war/personview/"+userid;
    });
})



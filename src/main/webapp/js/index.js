var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage['userid']
console.log("输出:"+jwt);


$('#linkpresonview').click(function(){
    window.location.href="/rentHomeProj_war/personview/"+userid;
});

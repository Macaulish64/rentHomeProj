var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
console.log("输出:"+jwt);
$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/personinfo",
        dataType:"json",
        global:"false",
        success:function() {
            alert("!!!");
        },
        error:function(data){
            alert("Please Log In First");
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});


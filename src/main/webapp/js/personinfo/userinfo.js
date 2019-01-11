var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
console.log("输出:"+jwt);
$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/personinfo/"+userid,
        dataType:"json",
        global:"false",
        success:function(data) {
            
        },
        error:function(data){
            alert("Please Log In First");
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});


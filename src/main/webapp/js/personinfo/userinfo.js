var storage=window.localStorage;
var jwt = storage["jwt"];
var name = storage["name"];
console.log("输出:"+jwt);
$(document).ready(function() {
    alert(jwt);
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : name
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/personinfo",
        dataType:"json",
        global:"false",
        success:function(data) {
            alert("!!!");
        },
        /* success:function(data){
           alert(JSON.stringify(data));
         },*/
        error:function(){
            alert("Please Log In First");
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});


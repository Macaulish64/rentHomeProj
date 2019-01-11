var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
console.log("输出:"+jwt);


$('#linkpresonview').click(function(){
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username
        },
        type:"POST",
        url:"http://localhost:8080/rentHomeProj_war/personview",
        dataType:"json",
        global:"false",
        success:function() {

        },
        // error:function(data) {
        //     alert("Please Log In First");
        //     $(location).attr('href', '/rentHomeProj_war/signin');
        // }
    })
});

var jwt = window.localStorage["jwt"];
var username = window.localStorage["username"];
var userid=window.localStorage['userid'];
console.log("输出:"+jwt);
alert("!!");
$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/transaction/queryownerTransaction",
        dataType:"json",
        global:"false",
        data:{ op :0 },
        success:function(data) {
           /* $('#usereditform').append(
                '<li>' + data[0].userid + '</li>' +
                '<li>' + data.usernickname + '</li>' +
                '<li>' + data.usertype + '</li>'
            )*/
       },
        /* success:function(data){
           alert(JSON.stringify(data));
         },*/
       error:function(){
           alert("Please Log In First");
           // $(location).attr('href', '/rentHomeProj_war/signin');
        }
     })
 });
//alert("d???dd?");
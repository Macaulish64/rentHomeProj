$(document).ready(function() {
    $.ajax({
        headers: {
            Authorization : jwt,
            'username' : username,
            'userid' : userid
        },
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/transaction/queryownerTransaction/"+0,
        dataType:"json",
        global:"false",
        success:function(data) {
            alert(data);
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
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});
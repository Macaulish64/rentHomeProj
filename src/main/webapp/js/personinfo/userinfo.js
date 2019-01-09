
$(document).ready(function() {
    $.ajax({
        type:"GET",
        url:"http://localhost:8080/rentHomeProj_war/user/personinfo",
        dataType:"json",
        global:"false",
        success:function(data) {
            $('#userinfoform').append(
                '<li>' + data.userid + '</li>' +
                '<li>' + data.usernickname + '</li>' +
                '<li>' + data.usertype + '</li>'
            )
        },
        /* success:function(data){
           alert(JSON.stringify(data));
         },*/
        error:function(){
            alert("!!!Error");
        }
    })
});


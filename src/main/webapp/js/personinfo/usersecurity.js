var storage=window.localStorage;
var jwt = storage["jwt"];
var name = storage["name"];
console.log("输出:"+jwt);
$(document).ready(function() {
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

$('#changepassword').click(function () {
    var oldpass=$('#oldpassword');
    var newpass1=$('#newpassword1');
    var newpass2=$('#newpassword2');
    if (oldpass.val() === newpass1.val()) {
        alert("与原密码一致");
    }
    else
        if (newpass1.val() !== newpass2.val()) {
            alert("两次输入不一致");
        }
        else {
        $.ajax({
            type: "POST",
            url: "rentHomeProj_war/user/changepassword",
            async: false,
            data: { oldpassword:oldpass,newpassword:newpass1},
            success:function() {
                alert("修改成功");
            },
            error:function() {
                alert("修改失败,请再试一次");
            }
        });
    }
})

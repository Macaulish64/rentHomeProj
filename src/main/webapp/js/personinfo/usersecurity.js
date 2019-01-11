var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"];
console.log("输出:"+jwt);

var oldpass=$('#oldpassword');
var newpass1=$('#newpassword1');
var newpass2=$('#newpassword2');


$('#changepassword').click(function () {
    if (oldpass.val() === newpass1.val()) {
        alert("与原密码一致");
    }
    else
        if (newpass1.val() !== newpass2.val()) {
            alert("两次输入不一致");
        }
        else {
            var obj = {
                oldpassword:oldpass.val(),
                newpassword : newpass1.val()
            };
            var json = JSON.stringify(obj);
        $.ajax({
            headers: {
                Authorization : jwt,
                'username' : username,
                'userid' : userid
            },
            type: "POST",
            url: "http://localhost:8080/rentHomeProj_war/user/changepassword/"+userid,
            async: false,
            data: json,
            success:function(data) {
                if (rescode===10003) {
                    alert("修改成功");
                    window.location.reload();
                }
                else {
                    alert("密码错误,请重新输入");
                }
            },
            error:function() {
                alert("修改失败,请再试一次");
            }
        });
    }
})

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
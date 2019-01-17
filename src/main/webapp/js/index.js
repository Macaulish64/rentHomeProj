var storage=window.localStorage;
var jwt,userid,username;

$(document).ready(function() {
    jwt = storage["jwt"];
    userid=storage['userid'];
    username = storage["username"];
    console.log("输出:"+jwt);
    $('#search-btn').on('click', function () {
        var str = $('#search-text').val();
        var url = '/rentHomeProj_war/houselist?searchbar=' + str;
        $(location).attr('href', url);
    });
    $('#linkpresonview').on('click', function () {
        window.location.href = "/rentHomeProj_war/personview/" + userid;
    });

    if (userid != null) {
        $('#linksignin').prop('href', "/rentHomeProj_war/personview");
        $('#linksignin').html("个人中心");
        $('#linksignup').prop('href', "");
        $('#linksignup').html("注销");
        $('#linksignup').prop("id", "longout");
        $('#longout').bind('click', function () {
            localStorage.clear();
            alert("注销成功");
            $(this).unbind('click');
            $(location).attr('href', "/rentHomeProj_war");
        })
        if (username !== "admin") {
            $('#toadmin').prop('href', "");
            $('#toadmin').html("");

        }
    }
});



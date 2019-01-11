var storage=window.localStorage;
var jwt = storage["jwt"];
var username = storage["username"];
var userid=storage["userid"]
var myDate=new Date();
console.log("输出:"+jwt);


function personinformation(data)
{
    $('#usernickname').append(
        data.usernickname
    );
    if (data.usernickname ===null) {
        $('#usernickname').append(
            "null"
        );
    }
    $('#userid').append(
        data.userid
    );
    if (data.userid ===null) {
        $('#userid').append(
            "null"
        );
    }
    $('#userlevel').append(
        data.userlevel
    );
    if (data.userlevel ===null) {
        $('#userlevel').append(
            "null"
        );
    }
    $('#phonenumber').append(
        data.phonenumber
    );
    if (data.phonenumber ===null) {
        $('#phonenumber').append(
            "null"
        );
    }
    $('#cardtype').append(
        data.cardtype
    );
    if (data.cardtype ===null) {
        $('#cardtype').append(
            "null"
        );
    }
    $('#idnumber').append(
        data.idnumber
    );
    if (data.idnumber ===null) {
        $('#idnumber').append(
            "null"
        );
    }
    $('#registcity').append(
        data.registcity
    );
    if (data.registcity ===null) {
        $('#registcity').append(
            "null"
        );
    }
    $('#updatetime').append(
        data.updatetime
    );
    if (data.updatetime ===null) {
        $('#updatetime').append(
            "null"
        );
    }
}

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
            personinformation(data);

        },
        error:function(data){
            alert("Please Log In First");
            $(location).attr('href', '/rentHomeProj_war/signin');
        }
    })
});


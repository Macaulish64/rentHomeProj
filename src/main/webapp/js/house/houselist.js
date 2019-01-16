


function getselect()
{
    var map={};
    var houseType =new Array();
    var i;
    var str,str2;
    str="housetype";
    for(i=0;i<=3;i++) {
        str2=str+Number(i+1);
        console.log($('#'+str2).prop('checked'));
        if (($('#'+str2).prop('checked'))==true)
            houseType.push(i);
     //   houseType.push(Number(1));
    }
    map['houseType']=houseType;

    var listhouseAreaMin=[];
    if ($('#houseareamin').val()!=="") {
        listhouseAreaMin[0]=Number($('#houseareamin').val());
    }
    else {
        listhouseAreaMin[0]=0;
    }
    map["houseAreaMin"]=listhouseAreaMin;


    var listhouseareamax=[];
    if ($('#houseareamax').val()!=="") {
        listhouseareamax[0]=Number($('#houseareamax').val());
    }
    else {
        listhouseareamax[0]=10000;
    }
    map["houseAreaMax"]=listhouseareamax;


    var listelevator=[];
    if ($('#elevator1').attr('checked')) listelevator.push(0);
    if ($('#elevator2').attr('checked')) listelevator.push(1);
    map["elevatorOrNot"]=listelevator;


    var listrentmoneymin=[];
    if ($('#rentmoneymin').val()!=="") {
        listrentmoneymin[0]=Number($('#rentmoneymin').val());
    }
    else {
        listrentmoneymin[0]=0;
    }
    map["rentMoneyMin"]= listrentmoneymin;



    var listrentmoneymax=[];
    if ($('#rentmoneymax').val()!=="") {
        listrentmoneymax[0]=Number($('#rentmoneymax').val());
    }
    else {
        listrentmoneymax[0]=10000;
    }
    map["rentMoneyMax"]=listrentmoneymax;

    var list2 =new Array();
    if ($('#paymentmethod1').prop('checked')==true) {
        list2.push(0);
    }
    if ($('#paymentmethod2').prop('checked')==true) {
        list2.push(1);
    }
    if ($('#paymentmethod2').prop('checked')==true) {
        list2.push(2);
    }
    map['paymentMethod']=list2;

    var str=JSON.stringify(map);
    console.log(str);
    return str;
}


function viewhouselist(list)
{
    /*问题：动态的话不能用th:需要绝对地址*/
    if (list.length===0) return;
    /*for(var i=0;i<2;i++) {
        $('#houseList').append(
            '<li class="round-panel">'+
                '<div class="row">'+
                    '<div class="img col-sm-5">'+
                        '<img class="w3-center"'+
                        'style="width: 15em; height: 15em;"'+
                        'src="'+'/rentHomeProj_war/img/a(1).JPG">'+
                    '</div>'+
                    '<div class="txt col-sm-5">'+
                        '<h3>'+'Haha'+'</h3>'+
                        '<h4>'+'北京市海淀区西土城路10号北京邮电大学学一楼307'+'</h4>'+
                    '</div>'+
                '<div class="btn col-sm-2">'+
                '<button id="house-btn" class="btn btn-default w3-center">'+'查看'+'</button>'+
                '</div>'+
            '</div>'+
            '</li>'
        );
    }*/

    for(var i=0;i<list.length;i++) {
        $('#houseList').append(
            '<li class="round-panel toumingdu">'+
            '<div class="row">'+
            '<div class="img col-sm-5">'+
            '<img class="w3-center"'+
            'style="width: 15em; height: 15em;"'+
            'src="'+'/rentHomeProj_war/img/a(1).JPG">'+
            '</div>'+
            '<div class="txt col-sm-5">'+
            '<h3>'+list[i].housedescription+'</h3>'+
            '<h4>'+list[i].cityname+'市'+list[i].communityname+'</h4>'+
            '</div>'+
            '<div class="btn col-sm-2">'+
            '<a href="/rentHomeProj_war/houseinfo?house='+list[i].houseid+'">'+
            '<button id="house-btn" class="btn btn-default w3-center">'+
            '查看'+'</button>'+
            '</a>'+
            '</div>'+
            '</div>'+
            '</li>'
        );
    }


}




$(document).ready(function () {
    $('#search-btn').on('click',function(){
        $.ajax({
            url:'http://localhost:8080/rentHomeProj_war/house/list',
            type:"GET",
            dataType:"json",
            data:{"map":getselect()},
            success:function(data){
                viewhouselist(data.list);
                // 	alert("Success");
            },
            error:function(){
                // 	alert("Error");
            }
        })
    });
    // $.ajax({
      // type: "GET",
      // dataType: 'json',
      // global: "false",
      // success: function (data) {
      /*for (var i = 0; i < 3; i++) {
          $('#tobehouselist').append(
            '<article class="media">'+
                '<a class="pull-left thumb p-thumb">' +
                    '<img src="/rentHomeProj_war/'+'/img/a(1).JPG">'+
                '</a>'+
                '<div class="media-body">'+
                    '<a class=" p-head" href="#">Item One Tittle</a>'+
                    '<p>Lorem ipsum dolor sit amet, consectetur adipiscing'+ 'elit.</p>'+
                '</div>'+
            '</article>'
          );
        }*/


      var list1=["1","2","3"];
      var list2=["444","555","666"];
      var list=[];
      //viewhouselist(list);
      var map={};
      map['aa']=list;
      $.ajax({
		  url:'http://localhost:8080/rentHomeProj_war/house/list',
		  type:"GET",
          dataType:"json",
          data:{"map":JSON.stringify(map)},
		  success:function(data){
		      viewhouselist(data.list);
		 // 	alert("Success");
		  },
		  error:function(){
		 // 	alert("Error");
		  }
	  })
		/*var idList = new Array();
		idList.push("1");
		idList.push("2");
		idList.push("3");
		$.ajax({
			type:"POST",
			url:"http://localhost:8080/rentHomeProj_war/user/test2",
			data:{"idList[]":idList}
		})
		var list1=["1","2","3"];
		$.ajax({
			url:'http://localhost:8080/rentHomeProj_war/user/test3',
			type:"POST",
			data:{"prideList[]":list1},
			success:function(){
			//	alert("Success");
			},
			error:function(){
			//	alert("Error");
			}
		})*/
     // }
    // })
  });
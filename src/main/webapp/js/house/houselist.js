



$('#search-btn').click(function(){
	var map={};
	var houseType =new Array();
	var i;
	var str,str2;
	str="houseType";
	for(i=0;i<=3;i++) {
		str2=str+i;
		if ($('#'+str2).attr('checked')) houseType.add(i);
	}
	str="depositMoneyMin",
	if ($('#'+houseAreaMin))
	publishUserId.add()







});





$(document).ready(function () {
    // $.ajax({
      // type: "GET",
      // dataType: 'json',
      // global: "false",
      // success: function (data) {
      for (var i = 0; i < 3; i++) {
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
        }
      /*问题：动态的话不能用th:需要绝对地址*/
      for(var i=0;i<3;i++) {
        $('#houseList').append(
          '<li class="row">'+
			  	'<div class="img col-sm-4">'+
					  '<img class="houseimg" src="/rentHomeProj_war/'+'img/a(1).JPG">'+
				  '</div>'+
				  '<div class="txt col-sm-4">'+
					  '<h3>Haha</h3>'+
					  '<h4>北京市海淀区西土城路10号北京邮电大学学一楼307</h4>'+
				  '</div>'+
				  '<div class="btn col-sm-4">'+
					  '<a class="button" style="alignment:center" href="houseinfo.html?house=2">'+
						  'Details'+
					  '</a>'+
				  '</div>'+
          '</li>'
        );
      }
      var list1=["1","2","3"];
      var list2=["444","555","666"];
      $.ajax({
		  url:'http://localhost:8080/rentHomeProj_war/house/list',
		  type:"POST",
		  data:{"prideList[]":list1,"cityList[]":list2},
		  success:function(){
		 // 	alert("Success");
		  },
		  error:function(){
		 // 	alert("Error");
		  }
	  })
		var idList = new Array();
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
		})
     // }
    // })
  });
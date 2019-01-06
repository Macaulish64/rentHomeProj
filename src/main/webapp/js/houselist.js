$(document).ready(function () {
    // $.ajax({
      // type: "GET",
      // url: "http://localhost:8081/book/list/",
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
					  '<a class="button" style="alignment:center" href="houseinfo.html">'+
						  'Details'+
					  '</a>'+
				  '</div>'+
          '</li>'
        );
      }
     // }
    // })
  });
<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>登录</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-login" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">登录</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom white-bg-color">
    <!-- <form action="campusAuthentication" method="post"> -->
  	<div class="campus-authentication-info">
  		<div class="item-input">
  			<div class="item-input-content " ><input type="text" class="not-null" id="userType" name="userType" placeholder="请选择用户类型" value="" readonly/></div>
  			<div class="item-input-logo " ><span class="icon icon-down" style=""></span></div>
  		</div>
  		<div class="item-input">
  			<div class="item-input-content " ><input type="number" class="not-null" id="userNumber" name="number" placeholder="请输入学号/工号" value=""/></div>
  		</div>
  		<div class="item-input">
  			<div class="item-input-content " ><input type="password" class="not-null" id="password" name="password" placeholder="请输入密码"  value="" /></div>
  		</div>
  	</div>
  	<button class="primary-btn long-btn" id="campusAuthentication">登录</button>
  	<!-- </form> -->
  </div>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
 <script src="${base}/resources/js/picker.js"></script>
<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-login", function(e, id, page) {
	  _$=$;
		/* $("#campusAuthentication").click(function(event){
			
		  }); */

		 $("#userType").picker({
		      toolbarTemplate: '<header class="bar bar-nav">\
		        <button class="button button-link pull-left close-picker">\
		      关闭\
		      </button>\
		      <button class="button button-link pull-right close-picker">\
		      确定\
		      </button>\
		      <h1 class="title">请选择用户类型</h1>\
		      </header>',
		      cols: [
		        {
		          textAlign: 'center',
		          values: ['学生', '教师'],
		          cssClass: 'picker-items-col-normal'
		        }
		      ]
		    });
	  });
}(Zepto);

document.getElementById("campusAuthentication").addEventListener("click", function(event){
	  event.preventDefault();
	  var userType=$("#userType").val();
		var userNumber=$("#userNumber").val();
		var password=$("#password").val();
		var flag=checkInputEmpty(_$);
		if (flag==false) {
			return;
		}
		_$.showPreloader();
		var timer=undefined;
		$.ajax({
			url:"${base}/my/login",
			type:"post",
			data:{"userType":userType,"userNumber":userNumber,"password":password},
			dataType:"json",
			beforeSend:function(){
				timer=setTimeout(function(){
					_$.hidePreloader();
					_$.alert("网络连接超时", function () {
				      });
					}, 10*1000);
				},
			success:function(data){
				clearTimeout(timer);
				 _$.hidePreloader();
				if (data.code=="0") {
					_$.router.load("${base}/"+data.url,true);
				}else{
					_$.alert(data.msg, function () {
				      });
				}
			},
		});
}, false);

</script>
</div>
  </body>
</html>
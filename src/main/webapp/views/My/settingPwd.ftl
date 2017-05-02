<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>设置密码</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-settingPwd" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">设置密码</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom white-bg-color">
  	<ul class="settingPwd-items">
  		<li class="settingPwd-item border-bottom">
  			<div class="settingPwd-item-left">请输入密码:</div>
  			<div class="settingPwd-item-right"><input class="not-null" type="password" id="password" placeholder="请输入密码" name="password"></div>
  		</li>
  		<li class="settingPwd-item border-bottom">
  			<div class="settingPwd-item-left">请确认密码:</div>
  			<div class="settingPwd-item-right"><input class="not-null" type="password" id="confirmPassword" placeholder="请输入确认密码" name="confirmPassword"></div>
  		</li>
  		<li class="settingPwd-item border-bottom">
  			<div class="settingPwd-item-left">请输入验证码:</div>
  			<div class="settingPwd-item-right"><input class="not-null" type="text" id="safeCode" placeholder="请输入验证码" name="safeCode"></div>
  		</li>
  		<li class="settingPwd-item border-bottom">
  			<div class="settingPwd-item-left">验证码图片:</div>
  			<div class="settingPwd-item-right"><img src="${base}/safeCodeServlet" id="safeCodeServlet" class="imgcode" id="" style="width: 4rem;height: 1.7rem;margin-top: 0.6rem;"><span id="changeSafeCodeServle" style="font-size: 0.7rem;" class="blue-font-color imgcode">&nbsp;&nbsp;看不清楚</span></div>
  		</li>
  	</ul>
  	<button class="primary-btn long-btn" id="submit">提交</button>
  </div>

</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script>
//picker
var _$=undefined;
+ function($) {
	$(document).on("pageInit", "#page-settingPwd", function(e, id, page) {
		_$=$;

		//点击验证码异步刷新验证码
		$(".imgcode").click(function(){
			//$("#safeCodeServlet").load("safeCodeServlet");
			  reflashSafeCode();
		});

		
	});

}(Zepto);

function reflashSafeCode(){
	$.ajax({
		url:"${base}/safeCodeServlet",
		dataType: "text",
		success:function(data){
			$("#safeCodeServlet").attr("src", "${base}/safeCodeServlet");
		}
	});  
}

$("#submit").click(function(event){
	var password=$("#password").val();
	var confirmPassword=$("#confirmPassword").val();
	var safeCode=$("#safeCode").val();
	var flag=checkInputEmpty(_$);
	if (flag==false) {
		return;
	}
	if (password!=confirmPassword) {
		_$.alert('对不起，您两次输入的密码不一致，请重新输入', function () {
	        	$("#password").val("");
	        	$("#confirmPassword").val("");
	        	$("#password")[0].focus();
	        });
	        return;
	}
	_$.showPreloader();
	var timer=undefined;
	$.ajax({
		url:"settingPwd",
		type:"post",
		data:{"password":password,"confirmPassword":confirmPassword,"safeCode":safeCode,"id":"${id}","userType":"${userType}"},
		dataType: "json",
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
				_$.alert(data.msg, function () {
					_$.router.load("${base}/my/toLogin?",true);
		        });
			}
			if (data.code=="5") {
				_$.alert(data.msg, function () {
					reflashSafeCode();
					$("#safeCode").val("");
					$("#safeCode")[0].focus();
		        });
			}
		}
	});  
		
  });
</script>
</div>
  </body>
</html>
<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>设置</title>
    <style>
    
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div class="page" id="page-setting">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.	7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">设置</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span> --> 
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom white-bg-color">
  <div class="grid-demo">
  <#if userInfo??>
  		<div class="welcome-img">
  			<img alt="" src="${base}/resources/images/my/integration-2.png">
  			<p>欢迎下次再来噢</p>
  		</div>
  		<button class="primary-btn long-btn" id="logout">退出账号</button>
  	<#else>
  		<div class="welcome-img">
  			<img alt="" src="${base}/resources/images/my/integration-2.png">
  			<p>您还没有登录哟</p>
  		</div>
  		<button class="primary-btn long-btn" id="login">登录</button>
  	</#if>
	</div>
  </div>
  
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>

<script type="text/javascript">
+ function($) {
	  'use strict';
	  $(document).on("pageInit", "#page-setting", function(e, id, page) {
		  $("#logout").click(function(){
			  $.router.load("logout",true);
		  });
		  $("#login").click(function(){
			  $.router.load("toLogin",true);
		  });
	  });
	}(Zepto);
</script>
</div>

  </body>
</html>
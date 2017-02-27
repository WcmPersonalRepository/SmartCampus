<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>教务网络管理系统</title>
    <style>
    	.owl-carousel img{width: 100%;float: left;}
    	.owl-carousel a{float: left;}
    	.owl-tip{float: left;margin-top: -40px;color: white;padding-left: 20px;background-color: rgba(0,0,0,0.5);width: 100%;height: 40px;line-height: 40px;}
    	.recommended{width: 100%;background-color: white;padding: 5% 5%;}
    	.recommended-title .col-90{line-height: 1.9em;}
    	.recommended-title img{width: 1.5em;}
    	.recommended-item img{width: 100%;float: left;}
    	.recommended-item{margin-top: 15px;}
    	.row{margin-left: -4%;}
    	.recommended-item .col-50 div{float: left;margin-top: -30px;color: white;padding-left: 20px;background-color: rgba(0,0,0,0.5);width: 100%;height: 30px;line-height: 30px;}
    </style>
 </head>
 
 <body>
  <div class="page">
  <header class="bar bar-nav apptitle">
    <!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
      <span class="icon icon-left"></span>
      返回
    </a> -->
    <h1 class="title title-color">校园管理</h1>
  </header>
  
  <div class="content">
     <div id="owl-demo" class="owl-carousel">
		<div>
			<a href="http://www.baidu.com">
				<img src="${base}/resources/images/index/banner1.jpg">
			</a>
			<div class="owl-tip">菜园生活让你乐滋滋</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/index/banner1.jpg">
			</a>
			<div class="owl-tip">菜园生活让你乐滋滋</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/index/banner1.jpg">
			</a>
			<div class="owl-tip">菜园生活让你乐滋滋</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/index/banner1.jpg">
			</a>
			<div class="owl-tip">菜园生活让你乐滋滋</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/index/banner1.jpg">
			</a>
			<div class="owl-tip">菜园生活让你乐滋滋</div>
		</div>
	</div>
	
	<div class="recommended">
		<div class="recommended-title row">
			<div class="col-10"><img alt="" src="${base}/resources/images/EducationalManager/recommended.png"></div>
			<div class="col-90">小编推荐</div>
		</div>
		
		<div class="recommended-items">
			<div class="recommended-item row">
				<div class="col-50">
					<img alt="" src="${base}/resources/images/EducationalManager/Online-ask-for-leave.png">
					<div class="recommended-item-tip">在线请假</div>
				</div>
				<div class="col-50">
					<img alt="" src="${base}/resources/images/EducationalManager/room-apply.png">
					<div>申请教室</div>
				</div>
			</div>
			<div class="recommended-item row">
				<div class="col-50">
					<img alt="" src="${base}/resources/images/EducationalManager/campus-car.png">
					<div>校车服务</div>
				</div>
				<div class="col-50">
					<img alt="" src="${base}/resources/images/EducationalManager/address-book.png">
					<div>更多服务</div>
				</div>
			</div>
		</div>
	</div>
	
  </div>
  
  <#include "/PUBLIC/nav-bar.ftl"/>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>

  </body>
  
  <script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({
				autoPlay:10000,
				stopOnHover: true,
				paginationSpeed: 1000,
				goToFirstSpeed: 2000,
				singleItem: true,
				autoHeight: true,
				transitionStyle: "fade"
			});
		});
	</script>
  </body>
</html>
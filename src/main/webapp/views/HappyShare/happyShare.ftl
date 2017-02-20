<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>校园乐享</title>
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
    <h1 class="title title-color">校园乐享</h1>
  </header>
  
  <div class="content">
     <div id="owl-demo" class="owl-carousel">
		<div>
			<a href="http://www.baidu.com">
				<img src="${base}/resources/images/happyShare/share-banner.png">
			</a>
			<div class="owl-tip">菜园生活乐享</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/happyShare/share-banner.png">
			</a>
			<div class="owl-tip">菜园生活乐享</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/happyShare/share-banner.png">
			</a>
			<div class="owl-tip">菜园生活乐享</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/happyShare/share-banner.png">
			</a>
			<div class="owl-tip">菜园生活乐享</div>
		</div>
		<div>
			<a href="#">
				<img src="${base}/resources/images/happyShare/share-banner.png">
			</a>
			<div class="owl-tip">菜园生活乐享</div>
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
					<img alt="" src="${base}/resources/images/happyShare/share_01.png">
					<div>查电表</div>
				</div>
				<div class="col-50">
					<img alt="" src="${base}/resources/images/happyShare/share_02.png">
					<div>缴电费</div>
				</div>
			</div>
			<div class="recommended-item row">
				<div class="col-50">
					<img alt="" src="${base}/resources/images/happyShare/share_03.png">
					<div>障碍保修</div>
				</div>
				<div class="col-50">
					<img alt="" src="${base}/resources/images/happyShare/share_04.png">
					<div>智慧校园快递</div>
				</div>
			</div>
			<div class="recommended-item row">
				<div class="col-50">
					<img alt="" src="${base}/resources/images/happyShare/share_05.png">
					<div>校园一卡通</div>
				</div>
				<div class="col-50">
					<img alt="" src="${base}/resources/images/happyShare/share_06.png">
					<div>校园生活</div>
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
<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>管理</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div class="page">
  <header class="bar bar-nav apptitle">
    <!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
      <span class="icon icon-left"></span>
      返回
    </a> -->
    <h1 class="title title-color">管理</h1>
  </header>
  
  <div class="content">
	<div class="manager-items">
		<ul class="manager-items-double">
			<li class="manager-item  online-application">
			<div>
				<div class="manager-item-logo">
					<img alt="" src="${base}/resources/images/EducationalManager/online-application.png">
				</div>
				<p>在线请假</p>
				</div>
			</li>
			<li class="manager-item apply-classroom">
				<div>
					<div class="manager-item-logo">
						<img alt="" src="${base}/resources/images/EducationalManager/apply-classroom.png">
					</div>
					<p>申请教室</p>
				</div>
			</li>
		</ul>
		<ul class="manager-items-double" >
			<li class="manager-item car-service" style="margin-top: 0;">
			<div>
				<div class="manager-item-logo">
					<img alt="" src="${base}/resources/images/EducationalManager/bus-Service.png">
				</div>
				<p>小车服务</p>
				</div>
			</li>
			<li class="manager-item other-service" style="margin-top: 0;">
				<div>
					<div class="manager-item-logo">
						<img alt="" src="${base}/resources/images/EducationalManager/integration.png">
					</div>
					<p>其他服务</p>
				</div>
			</li>
		</ul>
	</div>
  </div>
  <#include "/PUBLIC/nav-bar.ftl"/>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
</div>
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
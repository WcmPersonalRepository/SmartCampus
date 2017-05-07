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
  <div class="page" id="page-manager">
  <header class="bar bar-nav apptitle">
    <!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
      <span class="icon icon-left"></span>
      返回
    </a> -->
    <h1 class="title title-color">管理</h1>
  </header>
  
  <div class="content">
	<div class="manager-items">
		<ul class="manager-items-double" id="onlineLeave">
			<li class="manager-item  online-application">
			<!-- <a href="onlineLeave" style="width: 100%;height: 100%;" data-no-cache="true"> -->
			<div>
				<div class="manager-item-logo" >
					<img alt="" src="${base}/resources/images/EducationalManager/online-application.png">
				</div>
				<p>在线请假</p>
				</div>
				<!-- </a> -->
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

  </body>
  
<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-manager", function(e, id, page) {
	  _$=$;
		 $("#onlineLeave").click(function(event){
			$.router.load("onlineLeave",true);
		  }); 
	  });
}(Zepto);
		
</script>
</div>
  </body>
</html>
<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>我要批假</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-online-makeLeave" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">我要批假</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  	
  <div class="content no-bottom white-bg-color" style="padding: 0.5rem 5%;">
  	 <div class="wait-make-leave-amount">您有&nbsp;<span class="amount">1</span>&nbsp;条请假单未处理</div>
  	 <div class="leave-record-title" style="width: 5.3rem;font-size: 1rem;">请假单信息</div>
  	 <div class="wait-make-leave-record">
  	 	<ul class="wait-make-leave-items">
  	 		<li class="wait-make-leave-item border-bottom">
  	 			<div class="wait-make-leave-left"><img class="wait-make-leave-left-single-logo" src="${base }/resources/images/EducationalManager/single.png"></div>
  	 			<div class="wait-make-leave-main">
  	 				<div class="wait-make-leave-left-top">
  	 					<div class="">吴朝明</div>
  	 					<div class="">计应1331</div>
  	 				</div>
  	 				<div class="wait-make-leave-left-bottom">
	  	 				<div class="wait-make-leave-left-bottom-top"><img src="${base }/resources/images/EducationalManager/boy.png"></div>
	  	 				<div class="wait-make-leave-left-bottom-bottom">2017-05-30</div>
  	 				</div>
  	 			</div>
  	 			<div class="wait-make-leave-right"><button class="wait-make-btn">未处理</button></div>
  	 		</li>
  	 		<li class="wait-make-leave-item border-bottom">
  	 			<div class="wait-make-leave-left"><img class="wait-make-leave-left-more-logo" src="${base }/resources/images/EducationalManager/more.png"></div>
  	 			<div class="wait-make-leave-main">
  	 				<div class="wait-make-leave-left-top">
  	 					<div class="">蒙卓臻</div>
  	 					<div class="">计应1331</div>
  	 				</div>
  	 				<div class="wait-make-leave-left-bottom">
	  	 				<div class="wait-make-leave-left-bottom-top"><img src="${base }/resources/images/EducationalManager/girl.png"></div>
	  	 				<div class="wait-make-leave-left-bottom-bottom">2017-05-30</div>
  	 				</div>
  	 			</div>
  	 			<div class="wait-make-leave-right"><button class="maked-btn">已处理</button></div>
  	 		</li>
  	 	</ul>
  	 </div>
  </div>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
$(document).on("pageInit", "#page-online-makeLeave", function(e, id, page) {
  	_$=$;
	$("#leave").click(function(event){
		$.router.load("onlineLeave/toStudentLeave",true);
	});

});
}(Zepto);


</script>
</div>
  </body>
</html>
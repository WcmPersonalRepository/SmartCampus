<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>校园通讯录</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">校园通讯录</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom">
  <div class="grid-demo">
  <div class="personal-img"><img alt=""  src="${base}/resources/images/happyShare/personalPhoneBook.png"></div>
	<ul class="items">
		<li class="item border-bottom">
				<div class="item-content-left" >&nbsp;部门</div>
				<div class="item-content-right">${partName}&nbsp;</div>
		</li>
		<li class="item border-bottom">
				<div class="item-content-left" >&nbsp;科室</div>
				<div class="item-content-right">${phoneBookDetail.department }&nbsp;</div>
		</li>
		<li class="item border-bottom">
				<div class="item-content-left" >&nbsp;姓名</div>
				<div class="item-content-right">${phoneBookDetail.realName }&nbsp;</div>
		</li>
		<li class="item border-bottom">
				<div class="item-content-left" >&nbsp;电话</div>
				<div class="item-content-right">${phoneBookDetail.phone }&nbsp;</div>
		</li>
	</ul>
	<div class="">
		<button class="primary-btn long-btn">呼叫</button>
	</div>
	</div>
  </div>
  
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>
 <script>

		$(".primary-btn").click(function(){
			goHref("tel:${phoneBookDetail.phone }");
		});
	</script>
</div>

  </body>
</html>
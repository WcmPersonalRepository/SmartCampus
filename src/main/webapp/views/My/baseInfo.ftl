<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>个人信息</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.	7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">个人信息</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span> --> 
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom">
  <div class="grid-demo">
  <#if userType==2>
	<ul class="items">
		<li class="item border-bottom">
			<div class="item-left">用户类型</div>
			<div class="item-right">学生</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">姓名</div>
			<div class="item-right">${realName}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">班级</div>
			<div class="item-right">${className}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">学号</div>
			<div class="item-right">${studentNumber}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">专业</div>
			<div class="item-right">${professional}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">入学年份</div>
			<div class="item-right">${intoSchoolYear}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">系院</div>
			<div class="item-right">${collegeName}</div>
		</li>
	</ul>
	<#else>
		<ul class="items">
		<li class="item border-bottom">
			<div class="item-left">用户类型</div>
			<div class="item-right">教师</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">姓名</div>
			<div class="item-right">${realName}</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">所属部门</div>
			<div class="item-right">${partName }</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">工号</div>
			<div class="item-right">${workNumber }</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">组织机构</div>
			<div class="item-right">${organizationName }</div>
		</li>
		<li class="item border-bottom">
			<div class="item-left">职务</div>
			<div class="item-right">${positionName }</div>
		</li>
	</ul>
	</#if>
	</div>
  </div>
  
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>
</div>

  </body>
</html>
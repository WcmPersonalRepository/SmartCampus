<#include "/PUBLIC/head.ftl"/>
    <title>个人资料</title>
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
    <h1 class="title title-color">个人资料</h1>
  </header>
  
  <div class="content white-bg-color gray-font-color">
     <img alt="" src="${base}/resources/images/my/head_background.png" style="width: 100%;">
     <div class="head-img element-horizontal-center">
     	<a href="baseInfo" data-no-cache="true">
     		<#if realName??>
     		<div class="img" >
	     		<img src="${base }/resources/images/my/head-img-default.png"/>
	     	</div>
	     	<p>${realName}</p>
	     	<#else>
	     	<div class="img" >
	     		<img src="${base }/resources/images/my/head-img-default.png"/>
	     	</div>
	     	<p>未登录</p>
	     	</#if>
     	</a>
     </div>
     <div class="options">
		     <a href="toCampusAuthentication" data-no-cache="true">
	     <div class="row options-item line_bottom">
		     	<div class="col-10">
		     		<img alt="" src="${base }/resources/images/my/campus-certification.png">
		     	</div>
		     	<div class="col-80">校方认证</div>
		     	<div class="">
		     		<span class="icon icon-right"></span>
		     	</div>
	     </div>
		     </a>
		     
		     <a href="baseInfo" data-no-cache="true">
	     <div class="row options-item line_bottom">
	     	<div class="col-10">
	     		<img alt="" src="${base }/resources/images/my/base-info.png">
	     	</div>
	     	<div class="col-80 ">基本信息</div>
	     	<div class="">
	     		<span class="icon icon-right"></span>
	     	</div>
	     </div>
	     </a>
	     
	     <a href="${base }/toDeveloperPage?title=我的收藏" data-no-cache="true">
	     <div class="row options-item line_bottom">
	     	<div class="col-10">
	     		<img alt="" src="${base }/resources/images/my/my-collection.png">
	     	</div>
	     	<div class="col-80 ">我的收藏</div>
	     	<div class="">
	     		<span class="icon icon-right"></span>
	     	</div>
	     </div>
	     </a>
	     
	     <a href="${base }/toDeveloperPage?title=我的下载" data-no-cache="true">
	     <div class="row options-item line_bottom">
	     	<div class="col-10">
	     		<img alt="" src="${base }/resources/images/my/my-download.png">
	     	</div>
	     	<div class="col-80 ">我的下载</div>
	     	<div class="">
	     		<span class="icon icon-right"></span>
	     	</div>
	     </div>
	     </a>
	     
	     <a href="${base }/toDeveloperPage?title=播放记录" data-no-cache="true">
	     <div class="row options-item line_bottom">
	     	<div class="col-10">
	     		<img alt="" src="${base }/resources/images/my/play-record.png">
	     	</div>
	     	<div class="col-80 ">播放记录</div>
	     	<div class="">
	     		<span class="icon icon-right"></span>
	     	</div>
	     </div>
	     </a>
	     
	     <a href="toSetting" data-no-cache="true">
	     <div class="row options-item">
	     	<div class="col-10">
	     		<img alt="" src="${base }/resources/images/my/setting.png">
	     	</div>
	     	<div class="col-80 ">设置</div>
	     	<div class="">
	     		<span class="icon icon-right"></span>
	     	</div>
	     </div>
	     </a>
     </div>
  </div>
  
  <#include "/PUBLIC/nav-bar.ftl"/>
<#include "/PUBLIC/js-noBoot.ftl"/>
</div>
<script type="text/javascript">
//元素水平居住.element-horizontal-center
elementHorizontalCenter();
</script>
</div>
  </body>
</html>
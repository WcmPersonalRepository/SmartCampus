<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>请假信息</title>
    <style>
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-student-singleLeaveInfo" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">请假信息</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  	
  <div class="content no-bottom">
  	
  		 <div class="make-leave-options">
  		 	<#if statusCode==0>
  				<button class="make-leave-making" id="making">审核中</button>
  			</#if>
  		 	<#if statusCode==1>
  				<button class="make-leave-agree" id="agree">已同意</button>
  			</#if>
  			<#if statusCode==2>
  			<button class="make-leave-disagree" id="disagree">已拒绝</button>
  			</#if>
  		</div> 
  	<div class="single-leave" style="display: block;margin-top: 0;padding-top: 2rem;">
  	<!-- 基本信息 -->
  		<div class="baseInfo">
  			<div class="leave-record-title">基本信息</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学号</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${studentNumber}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">姓名</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${realName}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">性别</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${sex}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">班级</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${className}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">专业</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${professional}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学院</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${collegeName}</div>
  				</li>
  			</ul>
  		</div>
  		<!-- 请假必填 -->
  		<div class="leave-required">
  			<div class="leave-record-title">请假必填</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学生号码</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${studentMobile}&nbsp;&nbsp;<a href="tel:${studentMobile}" class="call">呼叫</a></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">家长号码</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${familyMobile}&nbsp;&nbsp;<a href="tel:${studentMobile}" class="call">呼叫</a></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">开始时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						${startTime}
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/startTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">结束时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						${endTime}
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/endTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">辅导员</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${classTeacher}</div>
  				</li>
  				<li class="baseInfo-item row border-bottom" style="height: 5rem;">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">请假原因</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea">${leaveReason}</textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						${isFamilyAgree}
  					</div>
  				</li>
  			</ul>
  		</div>
  		
  	</div>
  </div>
</div>

<style>
	.make-leave-msg{position: fixed;top:0;background-color: rgba(0,0,0,0.5);height: 100%;width: 100%;z-index: 9999;display: none;}
	.make-leave-dialog{background-color: white;height: 10rem;width: 80%;position: absolute;margin: auto;border-radius:5px;padding: 0.5rem;top:50%;left: 50%;margin-top: -5rem;margin-left: -40%;}
	.input-content textarea{height: 100%;width: 100%;font-size: 0.7rem;}
	.input-content{width: 100%;height: 6rem;padding-bottom: 0.5rem;}
	.make-leave-dialog-btn{text-align: right;}
	.animated{animation-duration:0.3s;}
</style>
<!-- 批假备注 -->
<div class="make-leave-msg" id="make-leave-model">
	<div class="make-leave-dialog">
		<div class="make-leave-dialog-tittle">批假意见</div>
		<div class="input-content"><textarea id="make-leave-advice" placeholder="30字以内"></textarea></div>
	</div>
</div>

<script type="text/javascript">
	
	 $("#make-leave-model").click(function(e){
		 $(".make-leave-dialog").removeClass("animated zoomIn");
		 $(".make-leave-dialog").addClass("animated zoomOut");
		 var _$this=$(this);
		 setTimeout(function(){_$this.hide();}, 300);
	}); 
	 $(".make-leave-dialog").click(function(e){
		e.stopPropagation();
	}); 
	
</script>
<#include "/PUBLIC/js-noBoot.ftl"/>

<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-student-singleLeaveInfo", function(e, id, page) {
	  _$=$;
	  $("#agree").click(function(e){
			 $("#make-leave-advice").text("${approverAdvice}");
			 $(".make-leave-dialog").removeClass("animated zoomOut");
			 $(".make-leave-dialog").addClass("animated zoomIn");
			 $("#make-leave-model").show();
		 }); 
		 $("#disagree").click(function(e){
			 $("#make-leave-advice").text("${approverAdvice}");
			 $(".make-leave-dialog").removeClass("animated zoomOut");
			 $(".make-leave-dialog").addClass("animated zoomIn");
			 $("#make-leave-model").show();
		}); 
		 $("#making").click(function(e){
			 $.alert("请假条在审核中", function () {
		     });
		}); 
 });

}(Zepto);


</script>

</div>
</div> 

  </body>
</html>
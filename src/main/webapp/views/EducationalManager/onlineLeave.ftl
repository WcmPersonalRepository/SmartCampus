<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>在线请假</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-online-leave" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">在线请假</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  	
  <div class="content no-bottom">
  <#if userType==1>
  	<div class="onlineLeave-options">
  		<div>
  			<button class="primary-btn" id="makeLeave" style="float: left;">我要批假</button>
  			<#if isNew==1>
  			<div class="drop">
  				<img alt="" src="${base}/resources/images/EducationalManager/drop.png">
  			</div>
  			<#else>
  			
  			</#if>
  		</div>
  		<!-- <div class="">
  			<button class="green-btn" id="leave">我要请假</button>
  		</div> -->
  		<img alt="" src="${base}/resources/images/EducationalManager/teacher.png">
  	</div>
  	
  	<div class="leave-record">
  		<div class="leave-record-title">批假记录</div>
  		<div class="leave-record-main">
  			<div class="leave-record-content">
  				<table class="leave-record-table">
  					<thead>
  						<tr class="border-bottom">
  							<td>批假人次</td>
  							<td>查看批假信息</td>
  							<td>批假时间</td>
  						</tr>
  					</thead>
  					<tbody>
  					<#list makeLeaveRecords as makeLeaveRecord>
  						<tr class="border-bottom">
  							<td>${makeLeaveRecord.count}</td>
  							<td><a href="onlineLeave/toMakeLeave?date=${makeLeaveRecord.date}" data-no-cache="true">查看</a></td>
  							<td>${makeLeaveRecord.date}</td>
  						</tr>
  					</#list>
  					</tbody>
  				</table>
  			</div>
  		</div>
  	</div>
  	<#else>
  		<div class="onlineLeave-options">
  		<div class="">
  			<button class="green-btn" id="leave">我要请假</button>
  		</div>
  		<img alt="" src="${base}/resources/images/EducationalManager/student.png">
  	</div>
  	
  	<div class="leave-record">
  		<div class="leave-record-title">请假记录</div>
  		<div class="leave-record-main">
  			<div class="leave-record-content">
  				<table class="leave-record-table">
  					<thead>
  						<tr class="border-bottom">
  							<td>申请状态</td>
  							<td>查看请假信息</td>
  							<td>请假时间</td>
  						</tr>
  					</thead>
  					<tbody>
  					<#list sysLeaveInfose as sysLeaveInfo>
  						<#if sysLeaveInfo.statusCode==0>
  						<tr class="border-bottom">
  							<td class="checking">审核中</td>
  							<td><a href="onlineLeave/lookLeaveInfo?stateCode=${sysLeaveInfo.stateCode}&id=${sysLeaveInfo.id}" data-no-cache="true">查看</a></td>
  							<td>${sysLeaveInfo.applyDate }</td>
  						</tr>
  						</#if>
  						<#if sysLeaveInfo.statusCode==2>
  						<tr class="border-bottom">
  							<td class="pass">已拒绝</td>
  							<td><a href="onlineLeave/lookLeaveInfo?stateCode=${sysLeaveInfo.stateCode}&id=${sysLeaveInfo.id}" data-no-cache="true">查看</a></td>
  							<td>${sysLeaveInfo.applyDate }</td>
  						</tr>
  						</#if>
  						<#if sysLeaveInfo.statusCode==1>
  						<tr class="border-bottom">
  							<td>已同意</td>
  							<td><a href="onlineLeave/lookLeaveInfo?stateCode=${sysLeaveInfo.stateCode}&id=${sysLeaveInfo.id}" data-no-cache="true">查看</a></td>
  							<td>${sysLeaveInfo.applyDate }</td>
  						</tr>
  						</#if>
  					</#list>
  					</tbody>
  				</table>
  			</div>
  		</div>
  	</div>
  	</#if>
  </div>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-online-leave", function(e, id, page) {
	  _$=$;
	    //我要请假
		$("#leave").click(function(event){
			//$.router.load("${base}/educationalManager/onlineLeave/toStudentLeave",false);
			window.location.href="${base}/educationalManager/onlineLeave/toStudentLeave";
		  });
		  //我要批假
		  $("#makeLeave").click(function(){
			  $.router.load("onlineLeave/toMakeLeave",true);
		  });

		 $("#userType").picker({
		      toolbarTemplate: '<header class="bar bar-nav">\
		        <button class="button button-link pull-left close-picker">\
		      关闭\
		      </button>\
		      <button class="button button-link pull-right close-picker">\
		      确定\
		      </button>\
		      <h1 class="title">请选择用户类型</h1>\
		      </header>',
		      cols: [
		        {
		          textAlign: 'center',
		          values: ['学生', '教师'],
		          cssClass: 'picker-items-col-normal'
		        }
		      ]
		    });
	  });
}(Zepto);


</script>
</div>
  </body>
</html>
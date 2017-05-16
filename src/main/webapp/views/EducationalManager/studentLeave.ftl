<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>学生请假</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div id="page-student-leave" class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">学生请假</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  	
  <div class="content no-bottom">
  	<div class="single-or-more">
  		<div class="single" id="single">
  			<div class="single-logo">
  				<img alt="" src="${base}/resources/images/EducationalManager/single.png">
  			</div>
  			<div class="single-content">
  				&nbsp;单人请假
  			</div>
  			<div class="single-choose">
  				<div class="kuang kuang-bg"></div>
  			</div>
  		</div>
  		<div class="more" id="more">
  			<div class="single-logo">
  				<img alt="" src="${base}/resources/images/EducationalManager/more.png">
  			</div>
  			<div class="single-content">
  				&nbsp;多人请假
  			</div>
  			<div class="single-choose">
  				<div class="kuang"></div>
  			</div>
  		</div>
  	</div>
  	
  	<div class="single-leave">
  	<!-- 基本信息 -->
  		<div class="baseInfo">
  			<div class="leave-record-title">基本信息</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学号</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${studentNumber }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">姓名</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${realName }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">性别</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${sex }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">班级</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${className }计应1331</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">专业</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${professional }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学院</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${collegeName }</div>
  				</li>
  			</ul>
  		</div>
  		<!-- 请假必填 -->
  		<div class="leave-required">
  			<div class="leave-record-title">请假必填</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50 " style="margin-left: 0;width: 30%;">学生号码</div>
  					<div class="baseInfo-item-right col-50 " style="margin-left: 0;width: 70%;"><input class="student-phone not-null" type="number" value="${mobile }" placeholder="请输入学生联系方式"/></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">家长号码</div>
  					<div class="baseInfo-item-right col-50 " style="margin-left: 0;width: 70%;"><input class="family-phone not-null" type="number" placeholder="请输入家长联系方式"/></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">开始时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						<input type="text" id="startTime" placeholder="请选择开始时间" class="col-70 startTime not-null" style="width: 85%;margin-left: 0;" />
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/startTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">结束时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						<input type="text" id="endTime" placeholder="请选择结束时间" class="col-70 endTime not-null" style="width: 85%;margin-left: 0;" />
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/endTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">辅导员</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${classTeacher }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom" style="height: 5rem;">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">请假原因</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea  leave-reason not-null"></textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						<input type="text" id="isAgree" class="col-85 isAgree  family-isAgree not-null" style="margin-top: 0.3rem;" placeholder="请选择"/>
  						<span class="icon icon-down col-15"></span>
  					</div>
  				</li>
  			</ul>
  			
  			<div class="submit">
  				<button class="primary-radius-btn" id="studentSingleLeave">提交</button>
  			</div>
  		</div>
  		
  	</div>
  	
  	<!-- 多人请假 -->
  	<div class="more-leave">
  	<!-- 本人基本信息 -->
  		<div class="baseInfo">
  			<div class="leave-record-title" style="width: 5.5rem;">本人基本信息</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学号</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${studentNumber }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">姓名</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${realName }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">性别</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${sex }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">班级</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${className }计应1331</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">专业</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${professional }</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学院</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">${collegeName }</div>
  				</li>
  			</ul>
  		</div>
  		
  		<div class="leave-required">
  		<!-- 本人请假必填 -->
  			<div class="self-leave-required">
	  			<div class="leave-record-title" style="width: 5.5rem;">本人请假必填</div>
	  			<ul class="baseInfo-items">
	  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50 " style="margin-left: 0;width: 30%;">学生号码</div>
  					<div class="baseInfo-item-right col-50 " style="margin-left: 0;width: 70%;"><input class="student-phone not-null" type="number" value="${mobile }" placeholder="请输入学生联系方式"/></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">家长号码</div>
  					<div class="baseInfo-item-right col-50 " style="margin-left: 0;width: 70%;"><input class="family-phone not-null" type="number" placeholder="请输入家长联系方式"/></div>
  				</li>
	  			</ul>
  			</div>
  			<!-- 多人请假必填-->
  			<div class="more-leave-required" >
  				<div class="row">
		  			<div class="col-30" style="width: 40%;"	><span class="leave-record-title" style="width: 5.5rem;">多人请假必填</span></div>
		  			<div class="col-70 open-popup" style="text-align: right;width: 60%;" id="add">添加+</div>
  				</div>
  				<ul class="more-leave-required-items">
  				</ul>
  			</div>
  			
  		</div>
  		<!-- 请假必填 -->
  		<div class="leave-required">
  			<div class="leave-record-title">请假必填</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">开始时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						<input type="text" id="startTime" placeholder="请选择开始时间" class="col-70 startTime" style="width: 85%;margin-left: 0;" />
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/startTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 25%;">结束时间</div>
	  				<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 75%;line-height: 2rem;">
	  					<div style="">
	  						<input type="text" id="endTime" placeholder="请选择结束时间" class="col-70 endTime" style="width: 85%;margin-left: 0;" />
							&nbsp;<img alt="" src="${base}/resources/images/EducationalManager/endTime.png" class="col-30" style="width: 0.9rem;position: relative;top:0.1rem;margin-left: 0;">
						</div>
					</div>
  				</li>
  				<li class="baseInfo-item row border-bottom" style="height: 5rem;">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">请假原因</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea  leave-reason not-null"></textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						<input type="text" id="isAgree" class="col-85 isAgree  family-isAgree not-null" style="margin-top: 0.3rem;" placeholder="请选择"/>
  						<span class="icon icon-down col-15"></span>
  					</div>
  				</li>
  			</ul>
  		</div>
  			<div class="submit">
  				<button class="primary-radius-btn" id="studentMoreLeave">提交</button>
  			</div>
  		
  	</div>
  	
  </div>
</div>

<!-- About Popup -->
<style>
	.content-block{margin-top: 2.2rem;}
	.item div{margin: 0;}
	.row>[class*=col-]{margin: 0;padding: 0;}
	.search{text-align: right;padding: 1rem 0;}
</style>
<div class="popup popup-about">
  <div class="content-block">
  	<header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left close-popup" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">添加请假人</h1>
    <!-- <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span>  -->
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
    <div class="add-leaver-content">
    	<ul class="items">
    		<li class="item border-bottom">
    			<div class="item-left" style="width: 20%;">学院</div>
    			<div class="item-right" style="width: 80%;">${collegeName }</div>
    		</li>
    		<!-- <li class="item border-bottom">
    			<div class="item-left" style="width: 90%">
    				<input type="text" id="chooseProfessional" value="${professional }" style="width: 100%;border: none;"/>
    			</div>
    			<div class="item-right" style="width: 10%"><span class="icon icon-down"></span></div>
    		</li> -->
    		<li class="item border-bottom">
    			<div class="item-left" style="width: 90%"><input type="text" id="chooseClass" value="${className }" style="width: 100%;border: none;"/></div>
    			<div class="item-right" style="width: 10%"><span class="icon icon-down"></span></div>
    		</li>
    	</ul>
    	<div class="search">
    		<button class="primary-btn" id="searchStudents" style="padding: 0.1rem 0.8rem;">检索</button>
    	</div>
    </div>
  </div>
</div>
<#include "/PUBLIC/choose-leaver-model.ftl"/>
<#include "/PUBLIC/js-noBoot.ftl"/>

 <script id="table-template-leave-students" type="text/x-handlebars-template">
  {{#each this}}
   		 <li class="more-leave-required-item border-bottom" param-data="{{userId}}">
  			 <div class="row">
  				 <div class="col-70">姓名：{{realName}}</div>
  				 <div class="col-30 remove" style="text-align: right;float: right;">×</div>
  			 </div>
			 <div class="">学号：{{studentNumber}}</div>
			 <div class="">班级：{{className}}</div>
			 <div class="">联系方式：{{mobile}}</div>
  		 </li>
  {{/each}}
</script>
 <script id="table-template-students" type="text/x-handlebars-template">
  {{#each this}}
   		 <li class="list-item border-bottom">
		    <div class="list-item-left"><div class="choose" data-param="{{userId}}"></div>&nbsp;{{realName}}</div>
			<div class="list-item-right">{{studentNumber}}</div>
		 </li>
  {{/each}}
</script>
<script>
var sysProfessionalsAndClass=undefined;
function getSysProfessionalsPickerParam(){
	  console.log(sysProfessionalsAndClass);
	  var sysProfessionals=sysProfessionalsAndClass.sysProfessionals;
	  var params=[];
	for ( var i = 0; i < sysProfessionals.length; i++) {
		params.push(sysProfessionals[i].professionalName);
	}
	return params;
}
//根据获取所有班级对象
function getSysClasssPickerParam(){
	  var sysProfessionals=sysProfessionalsAndClass.sysProfessionals;
	  var params=[];
	for ( var i = 0; i < sysProfessionals.length; i++) {
		//params.push(sysProfessionals[i].professionalName);
		var sysClasses=sysProfessionals[i].sysClasses;
		if (sysClasses.length>0) {
			for ( var j = 0; j < sysClasses.length; j++) {
				params.push(sysClasses[j]);
			}
		}
			
	}
	return params;
}
//校验专业与班级是否匹配
function validateData(professional,sysClass){
	var sysProfessionals=sysProfessionalsAndClass.sysProfessionals;
	for ( var i = 0; i < sysProfessionals.length; i++) {
		//params.push(sysProfessionals[i].professionalName);
		if (sysProfessionals[i].professionalName==professional) {
			var sysClasses=sysProfessionals[i].sysClasses;
			if (sysClasses.length>0) {
				for ( var j = 0; j < sysClasses.length; j++) {
					if (sysClasses[j].className==sysClass) {
						return true;
					}else{
						return false;
					}
				}
			}else{
				return false;
			}
		}
		
			
	}
}
var _$=undefined;
//picker
 + function($) {
  'use strict'; 
  $(document).on("pageInit", "#page-student-leave", function(e, id, page) {
	  _$=$;
	  console.log($);
	  //班级下已经认证的所有学生对象数组
	  var studentsArr=[];
	  $("#searchStudents").click(function(){
		  //校验选择的专业与班级是否对应的上
		  var professional=$("#chooseProfessional").val();
		  var sysClass=$("#chooseClass").val();
		  /* var flag=validateData(professional,sysClass);
		  if (!flag) {
			  $.alert("很遗憾没有任何记录", function () {
					
		        });
		        return;
		  } */
		  var timer=undefined;
		//查询该班级下的所有学生名称
			$.ajax({
				url:"getStudents",
				type:"post",
				dataType:"json",
				data:{"professional":professional,"sysClass":sysClass},
				beforeSend:function(){
					_$.showPreloader();
					timer=setTimeout(function(){
						_$.hidePreloader();
						_$.alert("网络连接超时", function () {
					      });
						}, 10*1000);
				},
				success:function(data){
					clearTimeout(timer);
					 _$.hidePreloader();
					 if (data.code==0) {
						 studentsArr=data.students;
						 var source=$("#table-template-students").html();
						 var template = Handlebars.compile(source);
						 var html = template(data.students);
						 $("#studentList").html(html);
						 //给刚更新的li进行点击事件绑定
						 $(".list-item").click(function(){
								var chooseDiv=$(this).find(".list-item-left").children();
								var className=chooseDiv.attr("class");
								if (className=="choosed") {
									chooseDiv.removeClass("choosed");
									chooseDiv.addClass("choose");
								}
								if (className=="choose") {
									chooseDiv.removeClass("choose");
									chooseDiv.addClass("choosed");
								}
							});
						 showModel();
					 }else{
						 $.alert(data.msg, function () {
					     });
				     }
				},
			});
	  });

	  //选择完添加的请假学生点击确定
	  $("#choose-student-btn").click(function(){
		//被选中的学生对象
		  var users=[];
		  //被选中的学生的userid
		  var userIds=[];
		  $(".choosed").each(function(){
			  userIds.push($(this).attr("data-param"));
		  });
		  //已选了请假人
		  if (userIds.length>0) {
			  //筛选出被选中的学生对象
             for ( var i = 0; i < studentsArr.length; i++) {
				for ( var j = 0; j < userIds.length; j++) {
					if (studentsArr[i].userId==userIds[j]) {
						users.push(studentsArr[i]);
						break;
					}
				}
			}
 			//关闭选择窗口以及检索页面
 			hideModel();
 			_$.closeModal();
 			//绑定数据
 			var source=$("#table-template-leave-students").html();
			 var template = Handlebars.compile(source);
			 var html=$(".more-leave-required-items").html();
			 html += template(users);
			 
			$(".more-leave-required-items").html(html);
			//移除请假人
			 $(".remove").each(function(){
			 	$(this).click(function(){
				 	var item=$(this).parent().parent();
			 		item.addClass("animated fadeOutLeft");
			 		setTimeout(function(){
			 			item.remove();
				 	}, 500);
			 	});
			 });
			//未选了请假人
		  }else{
			  $.alert("您未选请假人", function () {
			     });
			     return;
	     }
	  });
	  
	  //获取当前用户所在学院的专业以及班级信息
	initData();
	function initData(){
		$.ajax({
			url:"getSysProfessionalsAndClass?"+parseInt(Math.random()*100000),
			type:"get",
			cache:false,
			dataType:"json",
			async: false, 
			success:function(data){
				 if (data.code==0) {
					 sysProfessionalsAndClass=data;
					 initPicker();
				 }else{
					 $.alert(data.msg, function () {
				     });
			     }
			},
		});
	}
	 
		$("#leave").click(function(event){
			$.router.load("onlineLeave/toStudentLeave",true);
		  });

		var state=1;
		singleOrMoreSwich(state);
		$("#single").click(function(){
			state=1;
			$(this).find(".kuang").addClass("kuang-bg");
			$("#more").find(".kuang").removeClass("kuang-bg");
			singleOrMoreSwich(state);
		});
		$("#more").click(function(){
			state=2;
			$(this).find(".kuang").addClass("kuang-bg");
			$("#single").find(".kuang").removeClass("kuang-bg");
			singleOrMoreSwich(state);
		});

		/** 多人请假与单人请假切换
		state --1为单人请假 --2多人请假
		 */
		function singleOrMoreSwich(state){
			if (state==1) {
				$(".more-leave").hide();
				$(".single-leave").show();
			}
			if (state==2) {
				$(".single-leave").hide();
				$(".more-leave").show();
			}
		}

		//单人请假
		$("#studentSingleLeave").click(function(){
			//var flag=checkInputEmpty($);
			var studentPhone=$(".single-leave").find(".student-phone").val();
			var familyPhone=$(".single-leave").find(".family-phone").val();
			var startTime=$(".single-leave").find(".startTime").val();
			var endTime=$(".single-leave").find(".endTime").val();
			var leaveReason=$(".single-leave").find(".leave-reason").val();
			var familyIsAgree=$(".single-leave").find(".family-isAgree").val();
			//检查必填处是否为空
			var notNulls=$(".single-leave").find(".not-null");
			for ( var i = 0; i < notNulls.length; i++) {
				if (notNulls[i].value=="") {
					$.alert($(notNulls[i]).attr("placeholder"), function () {
						notNulls[i].focus();
			        });
					return;
				}
			}
			//校验手机号码是否有效
			var f1=checkMonile(studentPhone);
			if (f1==false) {
				var input=$(".single-leave").find(".student-phone")[0];
				$.alert("手机号码无效", function () {
					input.focus();
					input.select();
		        });
		        return;
			}
			var f2=checkMonile(familyPhone);
			if (f2==false) {
				var input=$(".single-leave").find(".family-phone")[0];
				$.alert("手机号码无效", function () {
					input.focus();
					input.select();
		        });
		        return;
			}

			//学生手机号码与家长手机号码不可以一致
			if (familyPhone==studentPhone) {
				var input=$(".single-leave").find(".family-phone")[0];
				$.alert("家长手机号码与学生手机号码不能一致", function () {
					input.focus();
					input.select();
		        });
		        return;
			}

			var timer=undefined;
			//提交
			$.ajax({
				url:"studentLeave",
				type:"post",
				dataType:"json",
				data:{"studentPhone":studentPhone,"familyPhone":familyPhone,"startTime":startTime,"endTime":endTime,"leaveReason":leaveReason,"familyIsAgree":familyIsAgree,"stateCode":"1"},
				beforeSend:function(){
					_$.showPreloader();
					timer=setTimeout(function(){
						_$.hidePreloader();
						_$.alert("网络连接超时", function () {
					      });
						}, 10*1000);
				},
				success:function(data){
					clearTimeout(timer);
					 _$.hidePreloader();
					 if (data.code==0) {
						 $.router.load("${base}/educationalManager/onlineLeave",true);
					 }else{
						 $.alert(data.msg, function () {
					     });
				     }
				},
			});
		});

		//多人请假
		$("#studentMoreLeave").click(function(){
			//var flag=checkInputEmpty($);
			var studentPhone=$(".more-leave").find(".student-phone").val();
			var familyPhone=$(".more-leave").find(".family-phone").val();
			var startTime=$(".more-leave").find(".startTime").val();
			var endTime=$(".more-leave").find(".endTime").val();
			var leaveReason=$(".more-leave").find(".leave-reason").val();
			var familyIsAgree=$(".more-leave").find(".family-isAgree").val();
			var ids=[];
			
			//获取所有请假人的userId
				var idRepeat=true;
			$(".more-leave-required-item").each(function(){
				var id=$(this).attr("param-data");
				for ( var i = 0; i < ids.length; i++) {
					if (ids[i]==id) {
						idRepeat=false;
						break;
					}
				}
				ids.push(id);
			});
			if (idRepeat==false) {
				$.alert("添加请假人中出现重复学生，请认真核对后再提交", function () {
		        });
		        return;
			}
				console.log(ids);
			//检查必填处是否为空
			var notNulls=$(".more-leave").find(".not-null");
			for ( var i = 0; i < notNulls.length; i++) {
				if (notNulls[i].value=="") {
					$.alert($(notNulls[i]).attr("placeholder"), function () {
						notNulls[i].focus();
			        });
					return;
				}
			}
			//校验手机号码是否有效
			var f1=checkMonile(studentPhone);
			if (f1==false) {
				var input=$(".more-leave").find(".student-phone")[0];
				$.alert("手机号码无效", function () {
					input.focus();
					input.select();
		        });
		        return;
			}
			var f2=checkMonile(familyPhone);
			if (f2==false) {
				var input=$(".more-leave").find(".family-phone")[0];
				$.alert("手机号码无效", function () {
					input.focus();
					input.select();
		        });
		        return;
			}

			//学生手机号码与家长手机号码不可以一致
			if (familyPhone==studentPhone) {
				var input=$(".more-leave").find(".family-phone")[0];
				$.alert("家长手机号码与学生手机号码不能一致", function () {
					input.focus();
					input.select();
		        });
		        return;
			}

			var timer=undefined;
			//提交
			$.ajax({
				url:"studentLeave",
				type:"post",
				dataType:"json",
				data:{"studentPhone":studentPhone,"familyPhone":familyPhone,"startTime":startTime,"endTime":endTime,"leaveReason":leaveReason,"familyIsAgree":familyIsAgree,"stateCode":"2","ids":ids.join(",")},
				beforeSend:function(){
					_$.showPreloader();
					timer=setTimeout(function(){
						_$.hidePreloader();
						_$.alert("网络连接超时", function () {
					      });
						}, 10*1000);
				},
				success:function(data){
					clearTimeout(timer);
					 _$.hidePreloader();
					 if (data.code==0) {
						 $.router.load("${base}/educationalManager/onlineLeave",true);
					 }else{
						 $.alert(data.msg, function () {
					     });
				     }
				},
			});
		});
		
		function getDefaults(){
			var today = new Date();

		    var getDays = function(max) {
		        var days = [];
		        for(var i=1; i<= (max||31);i++) {
		            days.push(i < 10 ? "0"+i : i);
		        }
		        return days;
		    };

		    var getDaysByMonthAndYear = function(month, year) {
		        var int_d = new Date(year, parseInt(month)+1-1, 1);
		        var d = new Date(int_d - 1);
		        return getDays(d.getDate());
		    };

		    var formatNumber = function (n) {
		        return n < 10 ? "0" + n : n;
		    };

		    var initMonthes = ('01 02 03 04 05 06 07 08 09 10 11 12').split(' ');

		    var initYears = (function () {
		        var arr = [];
		        /* for (var i = 1950; i <= 2030; i++) { arr.push(i); } */
		        arr.push(today.getFullYear());
		        arr.push(today.getFullYear()+1);
		        return arr;
		    })();
			var defaults = {

			        rotateEffect: false,  //为了性能

			        value: [today.getFullYear(), formatNumber(today.getMonth()+1), formatNumber(today.getDate()), today.getHours(), formatNumber(today.getMinutes())],

			        onChange: function (picker, values, displayValues) {
			            var days = getDaysByMonthAndYear(picker.cols[1].value, picker.cols[0].value);
			            var currentValue = picker.cols[2].value;
			            var currentDateTime=new Date(values[0]+"-"+values[1]+"-"+values[2]+" "+values[3]+":"+values[4]);
			            if(currentValue > days.length) 
				            currentValue = days.length;
			            picker.cols[2].setValue(currentValue);
			           /*  if (currentDateTime.getMonth()+1 <today.getMonth()+1) {
			            	picker.cols[0].setValue(today.getFullYear());
			            	picker.cols[1].setValue(today.getMonth()+1<10?"0"+(today.getMonth()+1):today.getMonth()+1);
			            	
						}
						if (currentDateTime.getDate() <today.getDate()) {
				            picker.cols[2].setValue(today.getDate()<10?"0"+today.getDate():today.getDate());
						}
						if (currentDateTime.getHours() <today.getHours()) {
							
			            	picker.cols[4].setValue(today.getHours()<10?"0"+today.getHours():today.getHours());
						}
						if (currentDateTime.getMinutes()<today.getMinutes()) {
							
			            	picker.cols[6].setValue(today.getMinutes()<10?"0"+today.getMinutes():today.getMinutes());
						} */
			        },
			        toolbarTemplate: '<header class="bar bar-nav">\
				        <button class="button button-link pull-left close-picker">\
				      关闭\
				      </button>\
				      <button class="button button-link pull-right close-picker">\
				      确定\
				      </button>\
				      <h1 class="title">请选择</h1>\
				      </header>',
			        formatValue: function (p, values, displayValues) {
			            return displayValues[0] + '-' + values[1] + '-' + values[2] + ' ' + values[3] + ':' + values[4]+' '+values[5];
			        },

			        cols: [
			            // Years
			        {
			            values: initYears
			        },
			        // Months
			        {
			            values: initMonthes
			        },
			        // Days
			        {
			            values: getDays()
			        },

			        // Space divider
			        {
			            divider: true,
			            content: '  '
			        },
			        // Hours
			        {
			            values: (function () {
			                var arr = [];
			                for (var i = 0; i <= 23; i++) { arr.push(i < 10 ? "0"+i : i); }
			                return arr;
			            })(),
			        },
			        // Divider
			        {
			            divider: true,
			            content: ':'
			        },
			        // Minutes
			        {
			            values: (function () {
			                var arr = [];
			                for (var i = 0; i <= 59; i++) { arr.push(i < 10 ? '0' + i : i); }
			                return arr;
			            })(),
			        },
			        {
			            divider: true,
			            content: '  '
			        },
			        {
			            values: ['第一节','第二节','第三节','第四节','第五节','第六节','第七节','第八节','第九节','第十节']
			        },
			        ]
			    };

		    return defaults;
		}
		
		$.fn.smartCampusDatetimePicker = function(params) {
	        return this.each(function() {
	            if(!this) return;
	            var p = $.extend(getDefaults(), params);
	            $(this).picker(p);
	            if (params.value) $(this).val(p.formatValue(p, p.value, p.value));
	        });
	    };

	    var date=new Date();
	    var year=date.getFullYear();
	    var month=date.getMonth()+1?"0"+(date.getMonth()+1):date.getMonth()+1;
	    var day=date.getDate()<10?"0"+date.getDate():date.getDate();
		$(".startTime").smartCampusDatetimePicker({
		    value: [year, month, day, '08', '00','第一节']
		 });
		$(".endTime").smartCampusDatetimePicker({
		    value: [year, month, day, '18', '00','第七节']
		 });
		
		 $(".isAgree").picker({
		      toolbarTemplate: '<header class="bar bar-nav">\
		        <button class="button button-link pull-left close-picker">\
		      关闭\
		      </button>\
		      <button class="button button-link pull-right close-picker">\
		      确定\
		      </button>\
		      <h1 class="title">请选择</h1>\
		      </header>',
		      value:['是'],
		      cols: [
		        {
		          
		          values: ['是', '否'],
		        },
		      ]
		    });

	  });
  var valusClass=['计应1331', '电商1332'];
  //选择专业
  function initPicker(){
	  $("#chooseProfessional").picker({
	      toolbarTemplate: '<header class="bar bar-nav">\
	        <button class="button button-link pull-left close-picker">\
	      关闭\
	      </button>\
	      <button class="button button-link pull-right close-picker">\
	      确定\
	      </button>\
	      <h1 class="title">请选择</h1>\
	      </header>',
	      value:['是'],
	      cols: [
	        {
	          textAlign: 'center',
	          values:getSysProfessionalsPickerParam(),
	        },
	      ]
	    });

	  var prams=getSysClasssPickerParam();
		var values=[];
		for ( var i = 0; i < prams.length; i++) {
			values.push(prams[i].className);
		}
		valusClass=values;
	//选择班级
	 $("#chooseClass").picker({
	      toolbarTemplate: '<header class="bar bar-nav">\
	        <button class="button button-link pull-left close-picker">\
	      关闭\
	      </button>\
	      <button class="button button-link pull-right close-picker">\
	      确定\
	      </button>\
	      <h1 class="title">请选择</h1>\
	      </header>',
	      cols: [
	        {
	          textAlign: 'center',
	          values: valusClass,
	        },
	      ]
	    }); 
	 
  }
  /* $("#chooseProfessional").change(function(){
		var prams=getSysClasssPickerParam();
		var values=[];
		for ( var i = 0; i < prams.length; i++) {
			values.push(prams[i].className);
		}
		valusClass=values;
		 $("#chooseClass").picker({
		      toolbarTemplate: '<header class="bar bar-nav">\
		        <button class="button button-link pull-left close-picker">\
		      关闭\
		      </button>\
		      <button class="button button-link pull-right close-picker">\
		      确定\
		      </button>\
		      <h1 class="title">请选择</h1>\
		      </header>',
		      cols: [
		        {
		          textAlign: 'center',
		          values: valusClass,
		        },
		      ]
		    });
  }); */
  
  //点击添加
/*   $("#add").click(function(){
	  initData();
  }); */

 
}(Zepto);
</script>

</div>
<!-- 添加页面 -->
</div> 

  </body>
</html>
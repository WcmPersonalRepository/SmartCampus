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
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">1232338928</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">姓名</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">吴朝明</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">性别</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">男</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">班级</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">计应1331</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">专业</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">计算机在应用技术</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学院</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">信息与统计学院</div>
  				</li>
  			</ul>
  		</div>
  		<!-- 请假必填 -->
  		<div class="leave-required">
  			<div class="leave-record-title">请假必填</div>
  			<ul class="baseInfo-items">
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">学生联系方式</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 60%;"><input type="text" placeholder="请输入学生联系方式"/></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长联系方式</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 60%;"><input type="text" placeholder="请输入学生联系方式"/></div>
  				</li>
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
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">辅导员</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">计算机在应用技术</div>
  				</li>
  				<li class="baseInfo-item row border-bottom" style="height: 5rem;">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">请假原因</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea"></textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						<input type="text" id="isAgree" class="col-85 isAgree" style="margin-top: 0.3rem;" placeholder="请选择"/>
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
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">1232338928</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">姓名</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">吴朝明</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">性别</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">男</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">班级</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">计应1331</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">专业</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">计算机在应用技术</div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学院</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">信息与统计学院</div>
  				</li>
  			</ul>
  		</div>
  		
  		<div class="leave-required">
  		<!-- 本人请假必填 -->
  			<div class="self-leave-required">
	  			<div class="leave-record-title" style="width: 5.5rem;">本人请假必填</div>
	  			<ul class="baseInfo-items">
	  				<li class="baseInfo-item row border-bottom">
	  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">本人联系方式</div>
	  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 60%;"><input type="text" placeholder="请输入本人联系方式"/></div>
	  				</li>
	  				<li class="baseInfo-item row border-bottom">
	  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长联系方式</div>
	  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 60%;"><input type="text" placeholder="请输入家长联系方式"/></div>
	  				</li>
	  			</ul>
  			</div>
  			<!-- 多人请假必填-->
  			<div class="more-leave-required" >
  				<div class="row">
		  			<div class="col-30" style="width: 40%;"	><span class="leave-record-title" style="width: 5.5rem;">多人请假必填</span></div>
		  			<div class="col-70 open-popup" style="text-align: right;width: 60%;">添加+</div>
  				</div>
  				<ul class="more-leave-required-items">
  					<li class="more-leave-required-item border-bottom">
  						<div class="row">
  							<div class="col-70">姓名：吴朝明</div>
  							<div class="col-30 remove" style="text-align: right;float: right;">×</div>
  						</div>
						
						<div class="">学号：120604303128</div>
						<div class="">班级：计算机应用技术</div>
						<div class="">联系方式：348573984</div>
  					</li>
  					<li class="more-leave-required-item border-bottom">
  						<div class="row">
  							<div class="col-70">姓名：吴朝明</div>
  							<div class="col-30 remove" style="text-align: right;float: right;">×</div>
  						</div>
						
						<div class="">学号：120604303128</div>
						<div class="">班级：计算机应用技术</div>
						<div class="">联系方式：348573984</div>
  					</li>
  					<li class="more-leave-required-item border-bottom">
  						<div class="row">
  							<div class="col-70">姓名：吴朝明</div>
  							<div class="col-30 remove" style="text-align: right;float: right;">×</div>
  						</div>
						
						<div class="">学号：120604303128</div>
						<div class="">班级：计算机应用技术</div>
						<div class="">联系方式：348573984</div>
  					</li>
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
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea"></textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						<input type="text" id="isAgree" class="col-85 isAgree" style="margin-top: 0.3rem;" placeholder="请选择"/>
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
    <p>About</p>
    <p><a href="#" class="close-popup">Close popup</a></p>
    <p>Lorem ipsum dolor ...</p>
  </div>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-student-leave", function(e, id, page) {
	  _$=$;
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

		//多人请假与单人请假切换
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
	  });

  		//提交请假单
	$("#studentMoreLeave").click(function(){
		$.router.load("${base}/educationalManager/onlineLeave",true);
	});
	$("#studentSingleLeave").click(function(){
		$.router.load("${base}/educationalManager/onlineLeave",true);
	});
}(Zepto);


</script>

</div>
<!-- 添加页面 -->
</div> 

  </body>
</html>
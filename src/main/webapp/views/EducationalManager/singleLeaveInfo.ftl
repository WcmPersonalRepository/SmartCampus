<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>请假信息</title>
    <style>
    	.make-leave-options{background-color: white;height: 3rem;text-align: right;padding: 0.7rem 5%;position: fixed;top:2.2rem;right:0;width: 100%;}
    	.make-leave-options button{margin-left: 0.5rem;}
    	.make-leave-agree{border: none;background-color: #3399ff;padding: 0.2rem 0.8rem;border-radius:3px;color:white;font-size: 0.8rem;}
    	.make-leave-agree:ACTIVE {background-color: #235d97;}
    	.make-leave-disagree{border: none;background-color:  #cc0000;padding: 0.2rem 0.8rem;border-radius:3px;color:white;font-size: 0.8rem;}
    	.make-leave-disagree:ACTIVE {background-color: #830e0e;}
    	.call{color:#235d97;}
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
  			<button class="make-leave-agree" id="agree">同意</button>
  			<button class="make-leave-disagree" id="disagree">拒绝</button>
  		</div>
  	<div class="single-leave" style="display: block;margin-top: 0;padding-top: 2rem;">
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
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">学生号码</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">18277719844&nbsp;&nbsp;<a href="tel:18277719844" class="call">呼叫</a></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">家长号码</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">13558471819&nbsp;&nbsp;<a href="tel:13558471819" class="call">呼叫</a></div>
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
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;">韦火旺</div>
  				</li>
  				<li class="baseInfo-item row border-bottom" style="height: 5rem;">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 30%;">请假原因</div>
  					<div class="baseInfo-item-right col-50" style="margin-left: 0;width: 70%;"><textarea placeholder="请填写请假原因100字以内" class="textarea"></textarea></div>
  				</li>
  				<li class="baseInfo-item row border-bottom">
  					<div class="baseInfo-item-left col-50" style="margin-left: 0;width: 40%;">家长是否同意</div>
  					<div class="baseInfo-item-right col-50 row" style="margin-left: 0;width: 60%;">
  						是
  					</div>
  				</li>
  			</ul>
  		</div>
  		
  	</div>
  </div>
</div>

<#include "/PUBLIC/make-leave-model.ftl"/>
<#include "/PUBLIC/js-noBoot.ftl"/>

<script>
var _$=undefined;
//picker
+ function($) {
  'use strict';
  $(document).on("pageInit", "#page-student-singleLeaveInfo", function(e, id, page) {
	  _$=$;
	  
	  	$("#makeLeave").click(function(e){
	  		$.showPreloader();
	  		setTimeout(function(){
	  			 $.hidePreloader();
				  $.router.load("toMakeLeave",true);
		  	}, 1000);
	  		  
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
</div> 

  </body>
</html>
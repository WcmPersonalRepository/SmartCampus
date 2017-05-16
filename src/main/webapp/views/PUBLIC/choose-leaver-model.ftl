<style>
	.make-leave-msg{position: fixed;top:0;background-color: rgba(0,0,0,0.5);height: 100%;width: 100%;z-index: 10999;display: none;}
	.make-leave-dialog{background-color: white;height: 20rem;width: 80%;position: absolute;margin: auto;border-radius:5px;padding: 0.5rem;top:50%;left: 50%;margin-top: -10rem;margin-left: -40%;}
	.list-content{height: 90%;overflow:auto;}
	.list-item{height: 2rem;line-height: 2rem;}
	.list-item div{float: left;}
	.list-item-left{width: 35%;}
	.list-item-right{width: 65%;text-align: right;}
	.choosed{width: 1rem;height: 1rem;background: url("/SmartCampus/resources/images/EducationalManager/more-choose-logo.png") no-repeat;background-position:50% 50%;background-size:0.8rem 0.8rem;margin-top: 0.5rem;}
	.choose{width: 1rem;height: 1rem;background-position:50% 50%;background-size:0.8rem 0.8rem;margin-top: 0.5rem;}
	.choose-sure{width: 100%;text-align: right;padding: 0.5rem 0;}
	.animated{animation-duration:0.3s;}
</style>
<!-- 批假备注 -->
<div class="make-leave-msg" id="make-leave-model">
	<div class="make-leave-dialog">
		<div class="list-content">
			<ul class="list" id="studentList">
			</ul>
		</div>
		<div class="choose-sure">
    		<button class="primary-btn" id="choose-student-btn" style="padding: 0.1rem 0.8rem;">确定</button>
    	</div>
	</div>
</div>

<script type="text/javascript">

	/* $(".list-item").click(function(){
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
	}); */

	 $("#agree").click(function(e){
		 showModel();
	 }); 
	 $("#disagree").click(function(e){
		 showModel();
	}); 
	 $("#make-leave-model").click(function(e){
		 hideModel();
	}); 
	 $(".make-leave-dialog").click(function(e){
		e.stopPropagation();
	}); 

	//显示选择请假人窗口
	function showModel(){
		$(".make-leave-dialog").removeClass("animated zoomOut");
		 $(".make-leave-dialog").addClass("animated zoomIn");
		 $("#make-leave-model").show();
	}

	//隐藏选择请假人窗口
	function hideModel(){
		 $(".make-leave-dialog").removeClass("animated zoomIn");
		 $(".make-leave-dialog").addClass("animated zoomOut");
		 setTimeout(function(){ $("#make-leave-model").hide();}, 300);
	}
	
</script>
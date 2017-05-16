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
		<div class="make-leave-dialog-tittle">填写批假意见</div>
		<div class="input-content"><textarea id="approverAdvice" placeholder="30字以内"></textarea></div>
		<div class="make-leave-dialog-btn"><button class="make-leave-agree" id="makeLeave">提交</button></div>
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
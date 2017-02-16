<nav class="bar bar-tab">
    <a class="tab-item active" href="${base}/?itemNum=0">
      <span class="icon icon-home"></span>
      <span class="tab-label">菜园</span>
    </a>
    <a class="tab-item" href="${base}/educationalManager?itemNum=1">
      <span class="icon icon-browser"></span>
      <span class="tab-label">管理</span>
    </a>
    <a class="tab-item" href="${base}/HappyShare?itemNum=2">
      <span class="icon icon-app"></span>
      <span class="tab-label">乐享</span>
    </a>
    <a class="tab-item" href="${base}/My?itemNum=3">
      <span class="icon icon-friends"></span>
      <span class="tab-label">我的</span>
    </a>
  </nav>
 <script>
	$(function(){
		initNavBar();
		function initNavBar(){
			var items=$(".bar-tab").children();
			console.log("${itemNum}");
			if ("${itemNum}"=="") {
				$(items[0]).addClass("active");
			}else{
				for ( var i = 0; i < items.length; i++) {
					var $tabItem=$(items[i]);
					$tabItem.removeClass("active");
				}
				for ( var i = 0; i < items.length; i++) {
					var $tabItem=$(items[i]);
					if ("${itemNum}"==i) {
						$tabItem.addClass("active");
					}
				}
			}
		}
		/* items.each(function(){
			$(this).click(function(){
				console.log($(this).attr("class"));
				for ( var i = 0; i < items.length; i++) {
					var $tabItem=$(items[i]);
					var clazz=$tabItem.attr("class");
					if (clazz.indexOf("active")) {
						$tabItem.removeClass("active");
					}
					//console.log($(items[i]));
				}
				$(this).addClass("active");
			});
		}); */
	});
</script> 
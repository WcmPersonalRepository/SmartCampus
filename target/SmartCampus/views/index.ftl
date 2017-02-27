<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
   <title>智慧校园</title>
   <style>
   	.owl-carousel img{width: 100%;}
   </style>
 </head>
 
 <body>
  <div class="page">
  <header class="bar bar-nav apptitle">
    <!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
      <span class="icon icon-left"></span>
      返回
    </a> -->
    <h1 class="title title-color">广西财经学院</h1>
  </header>
  
  <div class="content">
		<div id="owl-demo" class="owl-carousel">
			<div><a href="http://www.baidu.com"><img src="${base}/resources/images/index/banner1.jpg"></a></div>
			<div><a href="#"><img src="${base}/resources/images/index/banner1.jpg"></a></div>
			<div><a href="#"><img src="${base}/resources/images/index/banner1.jpg"></a></div>
			<div><a href="#"><img src="${base}/resources/images/index/banner1.jpg"></a></div>
			<div><a href="#"><img src="${base}/resources/images/index/banner1.jpg"></a></div>
		</div>
		
		<div class="special_subject">
			<ul class="item_list right_bottom">
				<li class="item right_line">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/advice.png"/>
						</a>
					</span>
					<p>通知广告</p>
				</li>
				<li class="item right_line">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/news.png"/>
						</a>
					</span>
					<p>广才新闻</p>
				</li>
				<li class="item">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/platform.png"/>
						</a>
					</span>
					<p>莲湖讲坛</p>
				</li>
			</ul>
			<ul class="item_list">
				<li class="item right_line">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/hot.png"/>
						</a>
					</span>
					<p>热点专题</p>
				</li>
				<li class="item right_line">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/fast_link.png"/>
						</a>
					</span>
					<p>快速链接</p>
				</li>
				<li class="item">
					<span>
						<a href="#">
							<img src="${base}/resources/images/index/fast_nav.png"/>
						</a>
					</span>
					<p>快速导航</p>
				</li>
			</ul>
		</div>
		
		<div class="campus_activities">
			<div class="activities_title row">
				<div class="col-5"><div class="vertical_line"></div></div>
				<div class="col-95">校园活动</div>
			</div>
			<div class="videose">
				<div class="video-item row click">
					<div class="col-50">
						<img width="100%" src="${base}/resources/images/index/video.png"/>
					</div>
					<div class="col-50">
						<p class="video-title">时光不老，我们不散</p>
						<div class="video-info">
							<label>来自计应1331班</label><br>
							<label>时间：2016-5-28 22:20:53</label>
						</div>
					</div>
				</div>
				<div class="video-item row click">
					<div class="col-50">
						<img width="100%" src="${base}/resources/images/index/video.png"/>
					</div>
					<div class="col-50">
						<p class="video-title">时光不老，我们不散</p>
						<div class="video-info">
							<label>来自计应1331班</label><br>
							<label>时间：2016-5-28 22:20:53</label>
						</div>
					</div>
				</div>
				<div class="video-item row click">
					<div class="col-50">
						<img width="100%" src="${base}/resources/images/index/video.png"/>
					</div>
					<div class="col-50">
						<p class="video-title">时光不老，我们不散</p>
						<div class="video-info">
							<label>来自计应1331班</label><br>
							<label>时间：2016-5-28 22:20:53</label>
						</div>
					</div>
				</div>
			</div>
		</div>
  </div>
  
  <#include "/PUBLIC/nav-bar.ftl"/>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>

  </body>
  
  <script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({
				autoPlay: 1000,
				stopOnHover: true,
				paginationSpeed: 1000,
				goToFirstSpeed: 2000,
				singleItem: true,
				autoHeight: true,
				transitionStyle: "fade"
			});
		});
	</script>
</html>
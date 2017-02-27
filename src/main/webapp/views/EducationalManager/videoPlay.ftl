<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>教务网络管理系统</title>
    <style>
		.video{position: fixed;top:2.1rem;}   
    </style>
 </head>
 
 <body>
  <div class="page">
  <header class="bar bar-nav apptitle">
    <!-- <a class="button button-link button-nav pull-left" href="/demos/card" data-transition='slide-out'>
      <span class="icon icon-left"></span>
      返回
    </a> -->
    <h1 class="title title-color">校园管理</h1>
  </header>
  
  <div class="content">
		<video class="video" src="${base}/uploads/video.mp4" controls="controls" width="100%" poster="${base}/resources/images/EducationalManager/video-test-img.png" ></video>
  </div>
  
  <#include "/PUBLIC/nav-bar.ftl"/>
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>
</body>
</html>
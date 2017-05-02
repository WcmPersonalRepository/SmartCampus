<#include "/PUBLIC/head.ftl"/>
<link rel="stylesheet" href="${base}/resources/css/owl.theme.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/owl.carousel.css" type="text/css"></link>
<link rel="stylesheet" href="${base}/resources/css/custom.css" type="text/css"></link>
    <title>校园通讯录</title>
    <style>
    	
    </style>
 </head>
 
 <body>
 <div class="page-group">
  <div class="page">
  <header class="bar bar-nav apptitle">
     <a class="button button-link button-nav pull-left back" style="color: white;" data-transition='slide-out'>
      <span class="icon icon-left" style="font-size:0.7rem;text-indent: 0.5rem;"></span>
    </a> 
     <h1 class="title title-color">校园通讯录</h1>
    <span class="icon icon-search" id="icon-search-out" onclick="search()" style="float: right;color: white;font-size: 1rem;line-height: 1.5rem"></span> 
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom">
  <div class="grid-demo">
  <div class="department-title" ><div class="department-title-text">${department}</div></div>
	<ul class="items">
	</ul>
	</div>
  </div>
  
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>
<script id="table-template" type="text/x-handlebars-template">
  {{#each this}}
   		<li class="item border-bottom">
			<a href="toPhoneBookDetail?id={{id}}" data-no-cache="true">
			<div class="phoneName">{{realName}}</div>
			<div class="phone" >{{phone}}</div>
			</a>
			<div class="call "><a class="blue-font-color" href="tel:{{phone}}">呼叫</a></div>
		</li>
  {{/each}}
</script>
 <script>

 var allPart='';
	var arr=[];
	$.ajax({
		url:'${base}/happyShare/phoneBookData',
		type:'POST',
		data:{'department':'${department}','partId':'${partId}'},
		dataType:'json',
		success:function(data){
			arr=data;
			for ( var i = 0; i < arr.length; i++) {
				arr[i].headText=arr[i].realName.substring(0,1);
			}
			
			if (arr.length>0) {
				initPage();
			}
		}
	});
	
	
	//var arr=[{id:'12',partName:'领导处'},{id:'13',partName:'组织部'},{id:'14',partName:'宣传部'},{id:'14',partName:'纪监察室'}];
	
	function initPage(){
		var html="";
		var template = Handlebars.compile($("#table-template").html());
		html+=template(arr);
		if (html.length>1) {
			$(".items").html(html);
		}
	}
		function updateItem(){
			var html="";
			var list=[];
			for ( var i = 0; i < arr.length; i++) {
				var val=$("#search").val();
				if (val!=""&&arr[i].realName.indexOf(val)>=0) {
					list.push(arr[i]);
				}
			}
			var template = Handlebars.compile($("#table-template").html());
			html+=template(list);
			if (html.length>1) {
				$(".items").html(html);
			}else{
				console.log("allPart:"+allPart);
				$(".items").html(allPart);
			}
		}

		function search(){
			$("#icon-search-out").hide();
			$('.title').hide();
			$(".search-input").css({'display':'block','opacity':'0'});
			$(".search-input").children()[1].focus()
			$(".search-text").css({'display':'block'});
			setTimeout(function(){
				$(".search-input").css({'width':'75%','opacity':'1'});
			}, 10);
			allPart=$(".items").html();
			updateItem();
		}

		function cancel(){
			$(".search-input").css({'width':'50%','opacity':'0'});
			$(".search-text").css({'display':'none'});
			setTimeout(function(){
				$('.icon-search').show();
				$('.title').show();
				$(".search-input").css({'display':'none'});
			}, 300);
			$(".items").html(allPart);
		}
	</script>
</div>

  </body>
</html>
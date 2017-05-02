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
    <div class="search-input"><span class="icon icon-search"></span><input id="search" onkeyup="updateItem()" placeholder="请输入科室或姓名" type="text"></div>
    <div class="search-text" onclick="cancel()">取消</div>
  </header>
  
  <div class="content no-bottom">
  <div class="grid-demo">
	<ul class="items" >
	</ul>
	<div id="phone-books"></div>
	</div>
  </div>
  
</div>
<#include "/PUBLIC/js-noBoot.ftl"/>
<script type="text/javascript" src="${base}/resources/js/owl.carousel.min.js"></script>
<script id="table-template" type="text/x-handlebars-template">
  {{#each this}}
   		<li class="item border-bottom">
			<a href="toDepartment?partId={{id}}" data-no-cache="true">
				<div class="item-content-big-font"><div class="blue-circle blue-background-color white-font-color">{{headText}}</div></div>
				<div class="item-content black-font-color" >&nbsp;{{partName}}</div>
				<div class="item-content-right-logo"><span class="icon icon-right"></span></div>
			</a>
		</li>
  {{/each}}
</script>
<script id="table-template-department" type="text/x-handlebars-template">
	<ul class="items-phone-book">
  {{#each this}}
   		<li class="item-phone-book border-bottom">
			<a href="toPhoneBook?department={{department}}&partId={{partId}}" data-no-cache="true">
			<div class="phone-book-department">
				<div class="phone-book-department-main">
					<div class="item-content-big-font " style="">&nbsp;<img src="${base}/resources/images/happyShare/department.png"></div>
					<div class="item-content black-font-color" style="width: 90%">&nbsp;{{department}}</div>
				</div>
				<div class="phone-book-path">{{partName}}</div>
			</div>
			<div class="item-content-right-logo" style="line-height: 3.4rem;"><span class="icon icon-right"></span></div>
			</a>
		</li>
  {{/each}}
</ul>
</script>
<script id="table-template-phone-book" type="text/x-handlebars-template">
<ul class="items-phone-book">
  {{#each this}}
   		<li class="item-phone-book border-bottom">
			<a href="toPhoneBookDetail?id={{id}}" data-no-cache="true">
			<div class="phone-book-department">
				<div class="phone-book-department-main">
					<div class="item-content-big-font " style="">&nbsp;&nbsp;</div>
					<div class="item-content black-font-color" style="width: 90%">&nbsp;{{realName}}</div>
				</div>
				<div class="phone-book-path">{{partName}}>{{department}}</div>
			</div>
			<div class="item-content-right-logo" style="line-height: 3.4rem;"><span class="icon icon-right"></span></div>
		</a>
		</li>
  {{/each}}
</ul>
</script>
 <script>

		var allPart='';
		var arr=[];
		 $.ajax({
			url:'${base}/happyShare/getParts',
			type:'POST',
			data:{},
			dataType:'json',
			success:function(data){
				arr=data;
				for ( var i = 0; i < arr.length; i++) {
					arr[i].headText=arr[i].partName.substring(0,1);
				}
				
				if (arr.length>0) {
					initPage();
				}
			}
		}); 

		var phoneBooksSortByDepartment=[];
		$.ajax({
			url:'${base}/happyShare/phoneBooksSortByDepartment',
			type:'POST',
			data:{},
			dataType:'json',
			success:function(data){
				
				phoneBooks=data;
				 var flag=true;
				 for ( var i = 0; i < data.length; i++) {
					for ( var j = 0; j < phoneBooksSortByDepartment.length; j++) {
						if (data[i].department==phoneBooksSortByDepartment[j].department&&data[i].partId==phoneBooksSortByDepartment[j].partId) {
							flag=false;
						 	break;
						}
					}
					if (flag) {
						phoneBooksSortByDepartment.push(data[i]);
					}
					flag=true;
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
			var list1=[];
			for ( var i = 0; i < phoneBooksSortByDepartment.length; i++) {
				var val=$("#search").val();
				if (val!=""&&phoneBooksSortByDepartment[i].department.indexOf(val)>=0) {
					list.push(phoneBooksSortByDepartment[i]);
				}
			}

			for ( var i = 0; i < phoneBooks.length; i++) {
				var val=$("#search").val();
				if (val!=""&&phoneBooks[i].realName.indexOf(val)>=0) {
					list1.push(phoneBooks[i]);
				}
			}
			var template = Handlebars.compile($("#table-template-department").html());
			var template1 = Handlebars.compile($("#table-template-phone-book").html());
			if (list.length>0) {
				html+='<div class="department-title" ><div class="department-title-text">科室</div></div>';
			}
			html+=template(list);
			if (list1.length>0) {
				html+='<div class="department-title" ><div class="department-title-text">教师</div></div>';
			}
			html+=template1(list1);
			if (list.length>=0) {
				$(".items").hide();
				$("#phone-books").show();
				$("#phone-books").html(html);
			}
			if (val.length==0) {
				//console.log("allPart:"+allPart);
				$(".items").show();
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
		}

		function cancel(){
			$(".search-input").css({'width':'50%','opacity':'0'});
			$(".search-text").css({'display':'none'});
			setTimeout(function(){
				$('.icon-search').show();
				$('.title').show();
				$(".search-input").css({'display':'none'});
			}, 300);
			$(".items").show();
			$("#phone-books").hide();
		}
	</script>
</div>

  </body>
</html>
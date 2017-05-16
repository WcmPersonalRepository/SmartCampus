
//获取屏幕宽度
var screenWidth=document.body.clientWidth;
//获取屏幕高度
var screenHeight=window.screen.availHeight;

var NET_TIMEOUT=10000;
function goHref(url){
	window.location.href=url;
}

function clickGoHref(id,url){
	$("#"+id).click(function(){
		goHref(url);
	});
}

//检查input是否为空
function checkInputEmpty($){
	var flag=true;
	var arr=$(".not-null");
	for ( var i = 0; i < arr.length; i++) {
		if (arr[i].value=="") {
			$.alert($(arr[i]).attr("placeholder"), function () {
				arr[i].focus();
	        });
			flag=false;
			break;
		}
	}
    return flag;
}

//校验手机号码
function checkMonile(mobile){
	var reg = /^1[0-9]{10}$/;
	if (!reg.test(mobile)) {
		return false;
	}else{
		return true;
	}
}

//元素水平居住.element-horizontal-center
elementHorizontalCenter();
function elementHorizontalCenter(){
	$('.element-horizontal-center').each(function(){
		var width=0;
		var $cssWdth=$(this).css('width')
		var eleStyleWdth=this.style.width;
		var eleWdth=$(this).attr('width');
		if ($cssWdth=='0px'&&eleStyleWdth==''&&eleWdth==undefined) {
			console.log(this);
			console.log('该元素没有宽度');
			return;
		}
		var arr=[$cssWdth,eleStyleWdth,eleWdth];
		for ( var i = 0; i < arr.length; i++) {
			width=percentAndPXToNumber(arr[i]);
			if (width!=0) {
				break;
			}
		}
		console.log(width);
		if (width==0) {
			console.log(this);
			console.log('该元素没有宽度');
			return;
		}
		
		this.style.left=(screenWidth-width)/2+'px';
	});
	
	//将百分比和像素转换为数字
	function percentAndPXToNumber(attr){
		var width=0;
		if (attr.indexOf('%')>0) {
			width=screenWidth*(Number(attr.substring(0,attr.length-1))/100);
			return width;
			
		}
		if(attr.indexOf('px')>0){
			width=Number(attr.substring(0,attr.length-2));
			return width;
		}
		if (Number(attr)!=NaN) {
			width=Number(attr);
			return width;
		}
		else{
			console.log('元素的宽度单位必须是百分比或像素');
		}
		return width;
	}
}

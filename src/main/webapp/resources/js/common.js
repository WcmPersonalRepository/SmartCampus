
//获取屏幕宽度
var screenWidth=document.body.clientWidth;
//获取屏幕高度
var screenHeight=window.screen.availHeight;
function goHref(url){
	window.location.href=url;
}

function clickGoHref(id,url){
	$("#"+id).click(function(){
		goHref(url);
	});
}

//元素水平居住
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
		/*if ($cssWdth!='') {
			width=percentAndPXToNumber($cssWdth);
		}
		if (eleStyleWdth!='') {
			width=percentAndPXToNumber(eleStyleWdth);
		}if (eleWdth!='') {
			width=eleWdth;
		}*/
		
		console.log($cssWdth);
		console.log(eleStyleWdth);
		console.log(eleWdth);
		//var ele=$(this).get(0);
		//var eleWidth=ele.style.withd.sustring(0,ele.style.withd.length-2);
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
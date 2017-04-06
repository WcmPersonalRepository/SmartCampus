function goHref(url){
	window.location.href=url;
}

function clickGoHref(id,url){
	$("#"+id).click(function(){
		goHref(url);
	});
}
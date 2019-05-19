function isEmpty(str) {
	return str == null || str == undefined || str == ""
			|| jsTrim(str).length == 0;
}

function jsTrim(x) {
	return x.replace(/^\s+|\s+$/gm, '');
}

<script>
//用于去除alert的url
window.alert = function(name){
    var iframe = document.createElement("IFRAME");
    iframe.style.display="none";
    iframe.setAttribute("src", 'data:text/plain,');
    document.documentElement.appendChild(iframe);
    window.frames[0].window.alert(name);
    iframe.parentNode.removeChild(iframe);
}
</script>
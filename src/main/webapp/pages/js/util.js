function isEmpty(str) {
	return str == null || str == undefined || str == ""
			|| jsTrim(str).length == 0;
}

function jsTrim(x) {
	return x.replace(/^\s+|\s+$/gm, '');
}

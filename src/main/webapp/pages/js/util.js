function isEmpty(str) {
	return str == null || str == undefined || str == ""
			|| str.length == 0;
}

String.prototype.format = function (args) {
    var result = this;
    if (arguments.length < 1) {
        return result;
    }

    var data = arguments;       //如果模板参数是数组
    if (arguments.length == 1 && typeof (args) == "object") {
        //如果模板参数是对象
        data = args;
    }
    for (var key in data) {
        var value = data[key];
        if (!isEmpty(value)) {
            result = result.replace(new RegExp("{" + key + "}", 'g'), value);
        }else{
        	
        	 result = result.replace(new RegExp("{" + key + "}", 'g'), "");
        }
    }
    return result;
}


function jsTrim(x) {
	return x.replace(new RegExp("/^\s+|\s+$/gm"),'');
}


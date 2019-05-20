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

function ValidatePhone(val){
    var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
    var isMob= /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
    if(isMob.test(val)||isPhone.test(val)){
        return true;
    }
    else{
        return false;
    }
}
function ValidateEmail(val){
	
	var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	 if(reg.test(val)){
	        return true;
	    }
	    else{
	        return false;
	    }
}

function jsTrim(x) {
	return x.replace(new RegExp("/^\s+|\s+$/gm"),'');
}


function isEmpty(str) {
	return str == null || str == undefined || str == ""
			|| str.length == 0;
}
function jsTrim(x) {
	return x.replace(new RegExp("/^\s+|\s+$/gm"),'');
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

//验证器
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

//验证
function DoValidate(){
	var result;
	var data={};
	$("[valisate]").each(function (i) {
		 var item=$(this);
		 var key=item.attr("id");
		 var placeholder=item.attr("placeholder");
		 var value=item.val();
		 //验证类型
		 var valisates= item.attr("valisate").split('-');
		 var itemResult=true;
		 for(var i=0;i<valisates.length;i++){
			 var valisate=valisates[i];
			 switch(valisate){
			 case"req":
				 if(value==""){
					 itemResult=false;
				 }
				 break;
			
			 case"phone":
				 itemResult=ValidatePhone(value);
				 placeholder="请输入正确的电话号码";
				 break;
				 
			 case"email":
				 itemResult=ValidateEmail(value);
				 placeholder="请输入正确的邮箱地址";
				 break;
			 }
			 
			 if(!itemResult)
				 break;
		 }
		 if(!itemResult)
		{
		 item.focus();
		 $.toast(placeholder);
		 console.log(placeholder);
		 data= itemResult;
		 return false;
		}
		data[key]=value;
    }
   );
	return data;
}


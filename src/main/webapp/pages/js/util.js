$.fn.validate = function(tips){

    if($(this).val() == "" || $.trim($(this).val()).length == 0){
        swal("提示",tips + "不能为空！","error");
        
        throw SyntaxError(); //如果验证不通过，则不执行后面
    }
}
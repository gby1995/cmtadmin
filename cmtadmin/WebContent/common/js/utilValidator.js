/**
 * 通用校验插件
 *
 * @author baitao 2016/8/4 必填项，数字检验，邮箱校验等
 */
var utilValidator = {
    isIDCard1Reg: /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/,//身份证正则表达式(15位)
    isIDCard2Reg: /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,//身份证正则表达式(18位)
    phoneReg: /^1[3|4|5|7|8]\d{9}$/,//手机号正则表达式
    simReg:  /^[1-9]\d{10}$/, 
    simReg13:  /^[1-9]\d{12}$/, 
    amountReg: /^(([1-9]\d{0,9}))(\.\d{1,2})?$/,//金额正在表达式
    floatNumReg: /^[0-9]+\.?[0-9]*$/,// 验证整数或者小时
    emailReg:/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,//邮箱正则表单式
    // 必填项校验
    requiredValidator: function () {
        var flag = true;
        $('form input[ gps="form"]').each(function () {
            if (typeof($(this).attr("required")) != "undefined") {
                var value = $.trim($(this).val());
                if (value == '') {
                    flag = false;
                }
            }
        });
        $('form textarea[ gps="form"]').each(function() {
        	 if (typeof($(this).attr("required")) != "undefined") {
                 var value = $.trim($(this).val());
                 if (value == '') {
                     flag = false;
                 }
             }
		});
        var checknum = 0;
        var checkcount = 0;
        $('form input:checkbox[ gps="form"]').each(function (index) {
            checknum = index;
        });
        $('form input:checkbox:checked[ gps="form"]').each(function (index1) {
            checkcount = index1;
        });
        if (checknum > 0 && checkcount == 0) {
            flag = false;
        }
        var radionum = 0;
        var radiocount = 0;
        $('form input[required]').each(function (j) {
            $('form input:radio:checked[ gps="form"]').each(function (index) {
                radionum = index;
                var value = $.trim($(this).attr('value'));
                if (value != '') {
                    radiocount++;
                }
            });
        });
        if (radionum > 0 && radiocount == 0) {
            flag = false;
        }
        if (!flag) {
            layer.msg("请填写完整信息！");
        }
        return flag;
    },  // 身份证校验
    cardValidator: function () {
        var cardValue = $.trim($('.cardValidator').val());
        if (!utilValidator.isIDCard1Reg.test(cardValue) && !utilValidator.isIDCard2Reg.test(cardValue)) {
            layer.msg("请填写正确的身份证号！");
            return false;
        } else {
            return true;
        }
    },// 手机号码
    phoneValidator: function () {
    	var flag = true;
    	$('.phoneValidator').each(function(){
    		 var phoneValue = $.trim($(this).val());
    	        if (!utilValidator.phoneReg.test(phoneValue)) {
    	            layer.msg("请填写正确的手机号码！");
    	            flag = false;
    	        } 
    	});
 	        return flag;
   
       
    },// 金额
    amountValidator: function () {
        var amountValue = $.trim($('.amountValidator').val());
        if (!utilValidator.amountReg.test(amountValue)) {
            layer.msg("请填写正确的金额！");
            return false;
        } else {
            return true;
        }
    },// 密码一致
    passwordValidator: function () {
        var passwordValue = $.trim($('.passwordValidator').val());
        var passwordValueSec = $.trim($('.passwordValidatorSec').val());
        if (passwordValue != passwordValueSec) {
            layer.msg("两次密码不一致！");
            return false;
        } else {
            return true;
        }
    },// SIM号码
    simValidator: function () {
        var phoneValue = $.trim($('.simValidator').val());
        if (utilValidator.simReg.test(phoneValue) || utilValidator.simReg13.test(phoneValue) ) {
        	return true;
        } else {
    	  layer.msg("请填写首位不能为0的11位或13位SIM卡号！");
          return false;
        }
    },// 精度校验
    lonValidator: function () {
        var patternLongitudeVal = $.trim($('.patternLongitude').val());
        if (Math.abs(patternLongitudeVal) > eval(180) || !utilValidator.floatNumReg.test(patternLongitudeVal)) {
            //if (!utilValidator.patternLongitude.test(patternLongitudeVal)) {
            layer.msg("请填写正确的经度！");
            return false;
        } else {
            return true;
        }
    },// 纬度校验
    latValidator: function () {
        var patternLatitudeVal = $.trim($('.patternLatitude').val());
        if (eval(patternLatitudeVal) > eval(90) || !utilValidator.floatNumReg.test(patternLatitudeVal)) {
            //if(!utilValidator.patternLatitude.test(patternLatitudeVal)){
            layer.msg("请填写正确的纬度！");
            return false;
        } else {
            return true;
        }
    },// 纬度校验
    numberValidator: function () {
        var patternLatitudeVal = $.trim($('.patternNumber').val());
        if (! /^\+?[1-9][0-9]*$/.test(patternLatitudeVal)) {
            //if(!utilValidator.patternLatitude.test(patternLatitudeVal)){
            layer.msg("配换轮胎个数必须是整数！");
            return false;
        } else {
            return true;
        }
    },// 邮箱校验
    eamilValidator: function () {
    	var flag = true;
    	$('.eamilValidator').each(function(){
    		 var eamilValidator = $.trim($(this).val());
    	        if (!utilValidator.emailReg.test(eamilValidator)) {
    	        	 layer.msg("请填写正确的邮箱格式！");
    	            flag = false;
    	        } 
    	});
 	        return flag;
    }
};

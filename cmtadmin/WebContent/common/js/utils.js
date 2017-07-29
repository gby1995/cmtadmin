/**
 * 前端工具类
 * @author baitao
 * 
 */
var utils = {
	uploadPath :'',
	basePath :'',
	path :'',
	// 图表集合
	chartsArray : new Array(),
	// 危险源R值和级别计算
	 Rvalue : function(){
			/**
			 * R的计算方法
		*R = α{β1*(q1/Q1)+......}式中：
		*q1,q2,…,qn —每种危险化学品实际存在（在线）量（单位：吨）；
		*Q1,Q2,…,Qn —与各危险化学品相对应的临界量（单位：吨）；
		*β1,β2…,βn— 与各危险化学品相对应的校正系数；
		*α— 该危险化学品重大危险源厂区外暴露人员的校正系数。
			 */
		 var qs = new Array();
		 var q = $('input[name=unitStock]').each(function(){
			 qs.push(Number($(this).val()));
		 });
		 var Qs = new Array();
		 var Q = $('input[name=crisis]').each(function(){
			 Qs.push(Number($(this).val()));
		 });
		 var bs = new Array();
		 var b = $('input[name=beta]').each(function(){
			 bs.push(Number($(this).val()));
		 });
		 /**
		  * 厂外可能暴露人员数量	α
		* 100人以上	2.0
		* 50人～99人	1.5
		* 30人～49人	1.2
		* 1～29人	1.0
		* 0人	0.5
		  */
		 var a = Number($('input[name=scopePersonCounts]').val());
		 if(a > 100){
			 a = 2;
		 }else if(50 <= a && a <=99 ){
			 a = 1.5;
		 }else if(30 <= a && a <=49 ){
			 a = 1.2;
		 }else if(1 <= a && a <=29 ){
			 a = 1;
		 }else if(0 == a){
			 a = 0.5;
		 }
		 /**
		  * 危险化学品重大危险源级别	R值
			* 一级	R≥100
			* 二级	100>R≥50
			* 三级	50>R≥10
			* 四级	R<10
		  */
		 var value = 0;
		 for(var i = 0; i < qs.length; i++){
			 value += bs[i] * (qs[i]/Qs[i]);
		 }
		 var R = a * value;
		 $('input[name="rpnValue"]').val(R);
		 if(R >= 100){
			 $('input[name="hsLevel"]').val("1");
			 $('input[name="hsLevelText"]').val("一级");
		 }else if(R >= 50 && 100 > R){
			 $('input[name="hsLevel"]').val("2");
			 $('input[name="hsLevelText"]').val("二级");
		 }else if(R >= 10 && 50 > R){
			 $('input[name="hsLevel"]').val("3");
			 $('input[name="hsLevelText"]').val("三级");
		 }else if(R <= 10){
			 $('input[name="hsLevel"]').val("4");
			 $('input[name="hsLevelText"]').val("四级");
		 }
		
	 },
	 /**js中文转换 ---解决浏览器JS get请求传递出现中文的情况
	 */
	// 转为unicode 编码   --传递前编码
	  encodeUnicode : function(str) {  
	     var res = [];  
	     for ( var i=0; i<str.length; i++ ) {  
	     res[i] = ( "00" + str.charCodeAt(i).toString(16) ).slice(-4);  
	     }  
	     return "\\u" + res.join("\\u");  
	 } ,
	   
	 // 解码   --传递前编码解码
	  decodeUnicode: function(str) {  
	     str = str.replace(/\\/g, "%");  
	     return unescape(str);  
	 }
	 ,init : function(){
		// 获取上传URL地址
		utils.uploadPath = $('#uploadPath').val();
		// 获取web工程地址
		utils.basePath = $('#basePath').val();
		// 获取工程名称
		utils.path = $('#path').val();
	 }
}

// 内容框点击缩放功能抽取 -- xiaohong
$(function(){
	 $(".siledbox i").click(function() {
				if ($(".siledbox i").attr("show") == 1) {
					$("#demo1").animate({
						opacity : "0",
						width : "0px",
						padding : "0px",
						borderWidth : "0px",
					},function(){
						$("#demo2").animate({
							width : "100%",
							paddingLeft : "0px"
						},500,function(){
							for(var i=0;i<utils.chartsArray.length;i++){
								var id = utils.chartsArray[i];
								$(id).highcharts().reflow();
							}
						});
					})
					
					$(".siledbox i").attr("show", "2");
				} else {
					$("#demo2").animate({
							width : "75%",
							paddingLeft : "15px"
					},10,function(){
						$("#demo1").animate({
							width : "25%",
							padding : "0px",
							borderWidth : "1px",
							opacity : "1"
						},function(){
							for(var i=0;i<utils.chartsArray.length;i++){
								var id = utils.chartsArray[i];
								$(id).highcharts().reflow();
							}
						});
					})
					$(".siledbox i").attr("show", "1");
				}
			})
			//
			utils.init();
})



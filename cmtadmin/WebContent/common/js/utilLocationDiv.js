/**
 * 打点获取百度地图经纬度
 * baitao 2017-3-6
 */
	var map = new BMap.Map("allmap");
	 var utilLocation = {
			 lng : null,
			 lat : null,
			 map : null,
			 init : function(){
				 map = new BMap.Map("allmap"),
				 map.centerAndZoom("姜堰",12);
				 map.enableScrollWheelZoom(true);	 // 支持缩放
				 var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
				 var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
				 map.addControl(top_left_control);        
				 map.addControl(top_left_navigation); 
			 },
			 setPoint : function(lng,lat,msg){
				 map.clearOverlays();  
				 var point = new BMap.Point(lng, lat);
				 var marker = new BMap.Marker(point);// 创建标注
				 map.addOverlay(marker);             // 将标注添加到地图中
				 map.centerAndZoom(point, 15);
				 var opts = {
						  width : 40,     // 信息窗口宽度
						  height: 30,     // 信息窗口高度
						  title : msg , // 信息窗口标题
						  enableMessage:false//设置允许信息窗发送短息
						}
				var infoWindow = new BMap.InfoWindow('', opts);  // 创建信息窗口对象 
				 map.openInfoWindow(infoWindow,point); //开启信息窗口
			 }
	 };
$(function() {
	 utilLocation.init();
});
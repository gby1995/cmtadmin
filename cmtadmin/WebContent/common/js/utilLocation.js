/**
 * 打点获取百度地图经纬度
 * baitao 2017-3-6
 */
	 var utilLocation = {
			 init : function(){
				 var map =  new BMap.Map("allmap");
				 map.centerAndZoom("姜堰",12);
				 map.enableScrollWheelZoom(true);	 // 支持缩放
				 var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
				 var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
				 map.addControl(top_left_control);        
				 map.addControl(top_left_navigation); 
				 // 逆地理解析
				 var geoc = new BMap.Geocoder();  
				//单击获取点击的经纬度
				 map.addEventListener("click",function(e){
					 map.clearOverlays();  
					 var point = new BMap.Point(e.point.lng, e.point.lat);
					 var marker = new BMap.Marker(point);// 创建标注
					 map.addOverlay(marker);             // 将标注添加到地图中 
					 geoc.getLocation(point, function(rs){
							var addComp = rs.addressComponents;
							var add = addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
							 layer.msg('您选择了经纬度为' + add + "的地址");
							 window.parent.$('#location').val(e.point.lng + "," + e.point.lat);
							 window.parent.$('#locationLng').val(e.point.lng);
							 window.parent.$('#locationLat').val(e.point.lat);
							 window.parent.$('#locationText').val(add);
						});     
					 
					});	 
				 
			 }
	 };
$(function() {
	 utilLocation.init();
});
	var gpsMap;
	 //$("body").toggleClass("mini-navbar");
	
	var map = new BMap.Map("container");          // 创建地图实例  
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.setCurrentCity("西安");          // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	//console.log(window.parent.window.gpsButtons);
	//gpsMap.init( window.parent.window.gpsButtons.gpsdata);
	//gpsMap.play(gpsMap.marker);
	 window.parent.NavToggle(); //缩放
	 
	var mapTool = {
	
	
	
	}

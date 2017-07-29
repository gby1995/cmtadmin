/*******************************************************************************
 * 说明：baiduAPI.js 是关于Baidu地图的api的封装。 * 作者：Huhaibo 2013-8-20 * /
 ******************************************************************************/
/*
 * 地图对象
 */
function baiduAPI() {
	try {
		this.maplet = null;
		this.mapName = "baidu";
		this.mapLevelDistance = [ 2000, 1000, 500, 200, 100, 50, 25, 20, 10, 5,
				2, 1, 0.5, 0.2, 0.1, 0.05, 0.02 ];
		this.disTool = null; // 测距工具
		this.mapLevel = new Array();
		this.mapLevel["全国"] = 5;
		this.mapLevel["省"] = 7;
		this.mapLevel["市"] = 12;
		this.mapLevel["区"] = 14;
		this.traffic = null;
		this.naviControl = null;
		this.overviewControl = null;
		this.LEVELD_ISTANCE = {
			5 : "500km",
			6 : "200km",
			7 : "100km",
			8 : "50km",
			9 : "25km",
			10 : "20km",
			11 : "10km",
			12 : "5km",
			13 : "2km",
			14 : "1km",
			15 : "500m",
			16 : "200m",
			17 : "100m",
			18 : "50m"
		};
		// 地址解析
		this.geocoder = null;
	} catch (ex) {
		// catchTheException("baiduAPI", ex);
	}
};
/*
 * 初始化baidu地图
 */
baiduAPI.prototype.InitBaidu = function(mDiv, dCity, level) {
	try {
		this.maplet = new BMap.Map(mDiv, {
			minZoom : 3,
			maxZoom : 18
		});
		if (typeof level == "undefined" || level == null || level == "") {
			level = 12;
		}
		if (typeof dCity != "undefined" && dCity != null && dCity != "") {
			var llArr = dCity.split(",");
			this.maplet
					.centerAndZoom(new BMap.Point(llArr[1], llArr[0]), level);
		} else {
			this.maplet.centerAndZoom("北京市", level);
		}
		llArr = null;
		this.maplet.enableScrollWheelZoom(); // 启用滚轮放大缩小，默认禁止。
		this.naviControl = new BMap.NavigationControl();
		this.maplet.addControl(this.naviControl); // 鱼骨控件
		this.maplet.addControl(new BMap.ScaleControl()); // 比例尺控件
		this.overviewControl = new BMap.OverviewMapControl();
		this.maplet.addControl(this.overviewControl); // 缩略图控件
		// this.maplet.addControl(new BMap.MapTypeControl({ mapTypes:
		// [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP] }));//地图or混合
	} catch (ex) {
		console.log(ex);
		// catchTheException("baiduAPI.prototype.InitBaidu", ex);
	}
};
/*
 * 显示路况
 */
baiduAPI.prototype.openTraffic = function() {
	try {
		this.traffic = new BMap.TrafficLayer();
		this.maplet.addTileLayer(this.traffic);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.openTraffic", ex);
	}
};
/*
 * 不显示路况
 */
baiduAPI.prototype.closeTraffic = function() {
	try {
		if (this.traffic != null) {
			this.maplet.removeTileLayer(this.traffic);
			this.traffic = null;
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.closeTraffic", ex);
	}
};
/*
 * 切换平面/卫星地图
 */
baiduAPI.prototype.changeMapType = function(type) {
	try {
		if (type == 0) { // 切换到平面
			this.maplet.setMapType(BMAP_NORMAL_MAP);
		} else { // 切换到卫星
			this.maplet.setMapType(BMAP_HYBRID_MAP);
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.changeMapType", ex);
	}
};
/*
 * 放大
 */
baiduAPI.prototype.ZoomIn = function() {
	try {
		this.maplet.zoomIn();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.ZoomIn", ex);
	}
};
/*
 * 缩小
 */
baiduAPI.prototype.ZoomOut = function() {
	try {
		this.maplet.zoomOut();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.ZoomOut", ex);
	}
};
/*
 * 地图平移
 */
baiduAPI.prototype.Move = function() {
	try {
		if (this.disTool != null) {
			this.disTool.close();
		}
		this.setDrawMode("pan", null);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.Move", ex);
	}
};
/*
 * 测距
 */
baiduAPI.prototype.Measure = function() {
	try {
		this.disTool = new BMapLib.DistanceTool(this.maplet, {
			"lineStroke" : 3,
			"opacity" : 0.7,
			"lineColor" : "#ff0000"
		});
		this.disTool.open();
	} catch (ex) {
		addScript("baiduDistanceTool.js");
		setTimeout(function() {
			this.disTool = new BMapLib.DistanceTool(this.maplet, {
				"lineStroke" : 3,
				"opacity" : 0.7,
				"lineColor" : "#ff0000"
			});
			this.disTool.open();
		}, 1000);
		// catchTheException("baiduAPI.prototype.Measure", ex);
	}
};
/*
 * 关闭测距
 */
baiduAPI.prototype.closeMeasure = function() {
	try {
		if (this.disTool) {
			this.disTool.close();
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.closeMeasure", ex);
	}
};
/*
 * 设置地图缩放等级
 */
baiduAPI.prototype.setZoom = function(level) {
	try {
		if (typeof (level) == 'undefined' || level == '' || level == null)
			return;
		this.maplet.setZoom(level);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setZoom", ex);
	}
};
/*
 * 获取地图缩放等级
 */
baiduAPI.prototype.getZoom = function() {
	try {
		return this.maplet.getZoom();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getZoom", ex);
	}
};
/*
 * 设置地图中心点 llObj:经纬度对象
 */
baiduAPI.prototype.setMapCenter = function(llObj) {
	try {
		if (typeof IsSetLockMap != "undefined") {
			IsSetLockMap = false;
		}
		this.maplet.setCenter(llObj);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setMapCenter", ex);
	}
};
/*
 * 获取地图中心点 返回值：[lon,lat]
 */
baiduAPI.prototype.getMapCenter = function() {
	try {
		var centerPoint = this.maplet.getCenter();
		var rObj = {
			lon : centerPoint.lng,
			lat : centerPoint.lat
		};
		return rObj;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getMapCenter", ex);
	}
};
/*
 * 创建经纬度对象
 */
baiduAPI.prototype.createMPoint = function(lon, lat) {
	try {
		return new BMap.Point(lon, lat);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createMPoint", ex);
	}
};
/*
 * 将对象添加到地图上
 */
baiduAPI.prototype.addOverlay = function(overLay) {
	try {
		if (typeof overLay == "undefined" || overLay == null) {
			return;
		}
		this.maplet.addOverlay(overLay);
		if (overLay.myLabel != null) {
			overLay.setLabel(overLay.myLabel);
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addOverlay", ex);
	}
};
/*
 * 将对象从地图上移除
 */
baiduAPI.prototype.removeOverlay = function(overLay) {
	try {
		this.maplet.removeOverlay(overLay);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.removeOverlay", ex);
	}
};

/*
 * 打开坐标点的气泡
 */
baiduAPI.prototype.openInfoWindow = function(overLay) {
	try {
		// var infoWin = new BMap.InfoWindow(overLay.winDetails, {
		// enableMessage: false, title: overLay.winTitle, width: 260, height:
		// 175 });
		var infoWin = new BMap.InfoWindow(overLay.winDetails, {
			enableMessage : false,
			title : overLay.winTitle
		});
		overLay.infoWin = infoWin;
		overLay.openInfoWindow(infoWin);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.openInfoWindow", ex);
	}
};
/*
 * 关闭信息窗口
 */
baiduAPI.prototype.closeInfoWindow = function() {
	try {
		this.maplet.closeInfoWindow();
		try {
			closeClusterWin(false);
		} catch (ex) {
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.closeInfoWindow", ex);
	}
};
/*
 * 清空地图
 */
baiduAPI.prototype.cleanMap = function() {
	try {
		this.maplet.clearOverlays();
		this.maplet.closeInfoWindow();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.cleanMap", ex);
	}
};
/*
 * 将相应的对象放在相应的数组中(Google地图方法) type:需要放进的数组的标识（P-点，A-区域，L-线，O-其他，Lo-定位车辆）
 */
baiduAPI.prototype.pushOverlayToArr = function(overlay, type) {
};
/*
 * 清空保存点的数组(Google地图方法)
 */
baiduAPI.prototype.clearMarkerArr = function() {
};
/*
 * 清空保存区域的数组(Google地图方法)
 */
baiduAPI.prototype.clearAreaArr = function() {
};
/*
 * 清空保存点的数组(Google地图方法)
 */
baiduAPI.prototype.clearAreaArr = function() {
};
/*
 * 自适应地图容器大小
 */
baiduAPI.prototype.mapResize = function(width, height) {
	try {
		this.maplet.checkResize();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.mapResize", ex);
	}
};

/*
 * 创建点对象 icon:图标路径（必填）；llObj:经纬度对象（必填）；name:名称；winDetails:信息窗口内容（默认为null）；
 * type:点类型（google地图用，通用参数，此处可传任意值）；color:名称背景颜色（默认白色）；fontColor:名称字体颜色（默认黑色）；
 * isDrag:是否可拖拽（默认不可拖拽）；width:图标宽度（默认25px）；height:默认高度（默认25px）；winTitle:信息框标题（默认“”）。
 * offsetType:图标的锚点偏移类型（0-以图表的中心点为锚点，1-已图标的底部中心为锚点；默认0。）
 */
baiduAPI.prototype.createMarker = function(llObj, options) {
	try {
		if (typeof llObj == "undefined" || llObj == "" || llObj == null) {
			return;
		}
		if (typeof options == "undefined" || options == null
				|| typeof options != "object") {
			options = {};
		}
		
		options.name = options.name || "";
		options.winDetails = options.winDetails || null;
		options.color = options.color || "#ffffff";
		options.fontColor = options.fontColor || "#000000";
		options.isDrag = options.isDrag || false;
		options.width = options.width || 25;
		options.height = options.height || 25;
		options.winTitle = options.winTitle || "";
		options.winTitle = options.winTitle.toString();
		options.offsetType = options.offsetType || 0;

		var iconOffset = {
			x : 0,
			y : 0
		};
		if (options.offsetType == 0) {
			iconOffset = {
				x : 0,
				y : 0
			};
		} else {
			iconOffset = {
				x : 0,
				y : (options.height / 2) * (-1)
			};
		}

		var myIcon = new BMap.Icon(options.icon, new BMap.Size(
				parseInt(options.width), parseInt(options.height)));
		myIcon.imageSize = new BMap.Size(parseInt(options.width),
				parseInt(options.height));
		var marker = new BMap.Marker(llObj, {
			offset : new BMap.Size(iconOffset.x, iconOffset.y),
			icon : myIcon,
			enableDragging : options.isDrag
		});
		if (options.winDetails != "" && options.winDetails != null) {
			marker.addEventListener("click", function() {
				this.infoWin = new BMap.InfoWindow(this.winDetails, {
					enableMessage : false,
					title : this.winTitle
				});
				this.openInfoWindow(this.infoWin);
			});
		}
		if (options.name != "" && options.name != " " && options.name != null) {
			if (options.icon.indexOf("blank") >= 0) {
				var myLabel = new BMap.Label(options.name, {
					offset : new BMap.Size(0, 0),
					position : llObj
				});
				myLabel.setStyle({
					color : options.fontColor,
					borderWidth : "1px",
					borderColor : "#cdcdcd",
					opacity : 0.7,
					backgroundColor : options.color
				});
				myLabel.addEventListener("click", function() {
					marker.infoWin = new BMap.InfoWindow(marker.winDetails, {
						enableMessage : false,
						title : marker.winTitle
					});
					marker.openInfoWindow(marker.infoWin);
				});
			} else {
				var myLabel = new BMap.Label(options.name, {
					offset : new BMap.Size((options.width + 2),
							(options.height / 2 - 10))
				});
				myLabel.setStyle({
					color : options.fontColor,
					borderWidth : "1px",
					borderColor : "#cdcdcd",
					backgroundColor : options.color
				});
			}
			marker.myLabel = myLabel;
		}

		else {
			marker.myLabel = null;
		}
		marker.winDetails = options.winDetails;
		marker.winTitle = options.winTitle;
		marker.lon = llObj.lng;
		marker.lat = llObj.lat;
		marker.name = options.name;
		marker.fontColor = options.fontColor;
		marker.color = options.color;
		marker.width = options.width;
		marker.height = options.height;
		marker.setTop(true);
		return marker;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createMarker", ex);
	}
};

// marker右上角显示序号
baiduAPI.prototype.createMarkerIndex = function(llObj, options) {
	try {
		if (typeof llObj == "undefined" || llObj == "" || llObj == null) {
			return;
		}
		if (typeof options == "undefined" || options == null
				|| typeof options != "object") {
			options = {};
		}
		options.icon = options.icon
				|| getRootPath()
				+ "/Areas/Monitor/Content/routeContent/webgis/Images/Map/15.png";
		options.name = options.name || "";
		options.winDetails = options.winDetails || null;
		options.color = options.color || "#ffffff";
		options.fontColor = options.fontColor || "#000000";
		options.isDrag = options.isDrag || false;
		options.width = options.width || 25;
		options.height = options.height || 25;
		options.winTitle = options.winTitle || "";
		options.winTitle = options.winTitle.toString();
		options.offsetType = options.offsetType || 0;

		var iconOffset = {
			x : 0,
			y : 0
		};
		if (options.offsetType == 0) {
			iconOffset = {
				x : 0,
				y : 0
			};
		} else {
			iconOffset = {
				x : 0,
				y : (options.height / 2) * (-1)
			};
		}

		var myIcon = new BMap.Icon(options.icon, new BMap.Size(
				parseInt(options.width), parseInt(options.height)));
		myIcon.imageSize = new BMap.Size(parseInt(options.width),
				parseInt(options.height));
		var marker = new BMap.Marker(llObj, {
			offset : new BMap.Size(iconOffset.x, iconOffset.y),
			icon : myIcon,
			enableDragging : options.isDrag
		});
		if (options.winDetails != "" && options.winDetails != null) {
			marker.addEventListener("click", function() {
				// this.openInfoWindow(new BMap.InfoWindow(this.winDetails, {
				// enableMessage: false, title: this.winTitle, width: 260,
				// height: 220 }));
				this.openInfoWindow(new BMap.InfoWindow(this.winDetails, {
					enableMessage : false,
					title : this.winTitle
				}));
			});
		}
		if (options.name != "" && options.name != " " && options.name != null) {
			if (options.icon.indexOf("blank") >= 0) {
				var myLabel = new BMap.Label(options.name, {
					offset : new BMap.Size(0, 0),
					position : llObj
				});
				myLabel.setStyle({
					color : options.fontColor,
					borderWidth : "1px",
					borderColor : "#cdcdcd",
					backgroundColor : options.color
				});
				myLabel.addEventListener("click", function() {
					// marker.openInfoWindow(new
					// BMap.InfoWindow(marker.winDetails, { enableMessage:
					// false, title: marker.winTitle, width: 260, height: 220
					// }));
					marker.openInfoWindow(new BMap.InfoWindow(
							marker.winDetails, {
								enableMessage : false,
								title : marker.winTitle
							}));
				});
			} else {
				var myLabel = new BMap.Label(options.name, {
					offset : new BMap.Size((options.width / 2 + 5),
							-(options.height / 2))
				});
				myLabel.setStyle({
					color : options.fontColor,
					width : "16px",
					height : "16px",
					borderWidth : "1px",
					textAlign : "center",
					lineHeight : "16px",
					borderRadius : "50%",
					display : "block",
					borderColor : "#cdcdcd",
					backgroundColor : options.color
				});
			}
			marker.myLabel = myLabel;
		} else {
			marker.myLabel = null;
		}
		marker.winDetails = options.winDetails;
		marker.winTitle = options.winTitle;
		marker.lon = llObj.lng;
		marker.lat = llObj.lat;
		marker.name = options.name;
		marker.fontColor = options.fontColor;
		marker.color = options.color;
		marker.width = options.width;
		marker.setTop(true);
		return marker;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createMarkerIndex", ex);
	}
};
/*
 * 创建线对象
 * LLObjs:经纬度对象数组（必填）；color:颜色（默认红色）；width:线宽度（默认3px）；IsArrow:是否需要箭头（Baidu中此参数无效）；clickable:是否可以click
 */
baiduAPI.prototype.createLine = function(LLObjs, options) {
	try {
		if (typeof LLObjs == "undefined" || LLObjs == "" || LLObjs == null) {
			return;
		}
		if (typeof options == "undefined" || options == null
				|| typeof options != "object") {
			options = {};
		}
		options.color = options.color || "#ff0000";
		options.width = options.width || 4;
		options.IsArrow = options.IsArrow || false;
		options.clickable = options.clickable || false;
		options.strokeOpacity = options.strokeOpacity || 1;

		return new BMap.Polyline(LLObjs, {
			strokeColor : options.color,
			strokeWeight : options.width,
			strokeStyle : "solid",
			enableClicking : options.clickable,
			strokeOpacity : options.strokeOpacity
		});
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createLine", ex);
	}
};
/*
 * 创建区域对象 LLObjs:经纬度对象数组；color:区域颜色；type:区域类型（Mapbar中此参数无效）；
 */
baiduAPI.prototype.createArea = function(LLObjs, options) {
	try {
		if (typeof LLObjs == "undefined" || LLObjs == "" || LLObjs == null) {
			return;
		}
		if (typeof options == "undefined" || options == null
				|| typeof options != "object") {
			options = {};
		}
		options.color = options.color || "#ff0000";

		var area = new BMap.Polygon(LLObjs, {
			strokeColor : options.color,
			strokeWeight : 1,
			fillOpacity : 0.35,
			fillColor : options.color,
			enableClicking : false,
			strokeStyle : "solid"
		});
		return area;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createArea", ex);
	}
};
/*
 * 修改点的经纬度信息 marker:点对象；newPoint:新的经纬度对象。
 */
baiduAPI.prototype.setMarkerPoint = function(marker, newPoint) {
	try {
		marker.lon = newPoint.lng;
		marker.lat = newPoint.lat;
		marker.setPosition(newPoint);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setMarkerPoint", ex);
	}
};
/*
 * 修改点的信息窗口
 */
baiduAPI.prototype.setMarkerWindow = function(marker, html) {
	try {
		marker.winDetails = html;
		var window = marker.infoWin;
		if (window && window.isOpen && window.isOpen() === true) {
			this.openInfoWindow(marker);
		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setMarkerWindow", ex);
	}
};
/*
 * 返回Marker的经纬度对象
 */
baiduAPI.prototype.getLLObjOfMarker = function(marker) {
	try {
		return marker.getPosition();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getLLObjOfMarker", ex);
	}
};
/*
 * 修改点的图标 marker:点对象；newIcon:新的图标路径
 */
baiduAPI.prototype.setMarkerIcon = function(marker, newIconUrl) {
	try {
		marker.setIcon(new BMap.Icon(newIconUrl, marker.getIcon().size));
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setMarkerIcon", ex);
	}
};
/*
 * 创建图表对象
 */
baiduAPI.prototype.createIcon = function(url, width, height) {
	try {
		return new BMap.Icon(url, new BMap.Size(width, height));
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createIcon", ex);
	}
};
/*
 * 如果 infoWindow 已打开，使其与 marker 坐标一致。但是因为百度地图会自己调整，所以该接口不会自己处理。 定义该接口为了和
 * googleAPI 结构一致。
 */
baiduAPI.prototype.moveInfoWindow = function() {
};

/*
 * 修改点的名称 marker:点对象；newLabelStr:新的名称字符串
 */
baiduAPI.prototype.setMarkerLabel = function(marker, newLabelStr) {
	try {
		if (marker.getLabel() == null) {
			var myLabel = new BMap.Label(newLabelStr, {
				offset : new BMap.Size(marker.width, 0)
			});
			myLabel.setStyle({
				color : marker.fontColor,
				borderWidth : "1px",
				borderColor : "#cdcdcd",
				backgroundColor : marker.color
			});
			marker.setLabel(myLabel);
			marker.setTop(true);
		} else {
			if (newLabelStr == "") {
				this.removeOverlay(marker);
				this.addOverlay(marker);
			} else {
				marker.getLabel().setContent(newLabelStr);
			}

		}
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setMarkerLabel", ex);
	}
};
/*
 * 设置区域颜色 area:区域对象；newColor:新的颜色
 */
baiduAPI.prototype.setAreaColor = function(area, newColor) {
	try {
		area.setFillColor(newColor);
		area.setStrokeColor(newColor);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setAreaColor", ex);
	}
};
/*
 * 设置线颜色 line:线对象；newColor:新的颜色
 */
baiduAPI.prototype.setLineColor = function(line, newColor) {
	try {
		line.setStrokeColor(newColor);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setLineColor", ex);
	}
};
/*
 * 创建圆形对象
 * cLLObj:中心点经纬度对象（必填）；radius:半径（单位-米，必填）；color:颜色；type:类型（Baidu地图中此参数无效）。
 */
baiduAPI.prototype.createCircle = function(cLLObj, radius, color, type) {
	try {
		if (typeof cLLObj == "undefined" || cLLObj == "" || cLLObj == null
				|| typeof radius == "undefined" || radius == ""
				|| radius == null) {
			return;
		}
		if (typeof color == "undefined" || color == "" || color == null) {
			color = "#ff0000";
		}
		var circle = new BMap.Circle(cLLObj, radius, {
			strokeColor : color,
			fillColor : color,
			strokeWeight : 1,
			fillOpacity : 0.35,
			strokeOpacity : 1,
			enableClicking : false
		});
		return circle;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.createCircle", ex);
	}
};
/*
 * 设置地图绘制模式
 * strMode:地图的绘制模式（pan-平移，marker-点，rect-矩形，polygon-多边形）；callbackFunction:回调函数
 * offsetType:图标的锚点偏移类型（0-以图表的中心点为锚点，1-已图标的底部中心为锚点；默认0。）
 */
var drawCallback_BD = null;
baiduAPI.prototype.setDrawMode = function(strMode, callbackFunction, mImgUrl,
		mWidth, mHeight, offsetType) {
	try {
		drawCallback_BD = null;
		if (typeof strMode == "undefined" || strMode == "" || strMode == null) {
			return;
		}
		if (strMode != "pan" && strMode != "marker" && strMode != "rect"
				&& strMode != "polygon") {
			return;
		}
		if (typeof callbackFunction == "undefined" || callbackFunction == ""
				|| callbackFunction == null) {
			callbackFunction = null;
		}
		if (typeof mImgUrl == "undefined" || mImgUrl == "" || mImgUrl == null) {
			mImgUrl = "";
		}
		if (typeof mWidth == "undefined" || mWidth == "" || mWidth == null) {
			mWidth = 25;
		}
		if (typeof mHeight == "undefined" || mHeight == "" || mHeight == null) {
			mHeight = 25;
		}
		if (typeof offsetType == "undefined" || offsetType == ""
				|| offsetType == null) {
			offsetType = 0;
		}
		drawCallback_BD = callbackFunction;
		// 初始化绘制对象
		InitDrawingManager_BD(mImgUrl, mWidth, mHeight, offsetType);
		switch (strMode) {
		case "pan":
			drawingManager_BD.close();
			// this.maplet.setMode("pan", callbackFunction);
			break;
		case "marker":
			drawingManager_BD.setDrawingMode(BMAP_DRAWING_MARKER);
			break;
		case "rect":
			drawingManager_BD.setDrawingMode(BMAP_DRAWING_RECTANGLE);
			break;
		case "polygon":
			drawingManager_BD.setDrawingMode(BMAP_DRAWING_POLYGON);
			break;
		default:
			break;
		}
		drawingManager_BD.open();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setDrawMode", ex);
	}
};
// DrawingManager
var drawingManager_BD = null;
function InitDrawingManager_BD(mImgUrl, mWidth, mHeight, offsetType) {
	try {
		if (typeof mImgUrl == "undefined" || mImgUrl == "" || mImgUrl == null) {
			mImgUrl = getRootPath()
					+ "/Areas/Monitor/Content/routeContent/webgis/Images/Map/15.png";
		}
		if (typeof mWidth == "undefined" || mWidth == "" || mWidth == null) {
			mWidth = 25;
		}
		if (typeof mHeight == "undefined" || mHeight == "" || mHeight == null) {
			mHeight = 25;
		}
		if (typeof offsetType == "undefined" || offsetType == ""
				|| offsetType == null) {
			offsetType = 0;
		}
		var iconOffset = {
			x : 0,
			y : 0
		};
		if (offsetType == 0) {
			iconOffset = {
				x : 0,
				y : 0
			};
		} else {
			iconOffset = {
				x : 0,
				y : (mHeight / 2) * (-1)
			};
		}
		var styleOptions = {
			strokeColor : "#ff0000", // 边线颜色。
			fillColor : "#ff0000", // 填充颜色。当参数为空时，圆形将没有填充效果。
			strokeWeight : 1, // 边线的宽度，以像素为单位。
			strokeOpacity : 1, // 边线透明度，取值范围0 - 1。
			fillOpacity : 0.35, // 填充的透明度，取值范围0 - 1。
			strokeStyle : 'solid' // 边线的样式，solid或dashed。
		};
		var mOption = {
			icon : new BMap.Icon(mImgUrl, new BMap.Size(mWidth, mHeight)),
			enableDragging : true,
			offset : new BMap.Size(iconOffset.x, iconOffset.y)
		};
		// 实例化鼠标绘制工具
		drawingManager_BD = new BMapLib.DrawingManager(map.maplet, {
			isOpen : false, // 是否开启绘制模式
			enableDrawingTool : false, // 是否显示工具栏
			enableCalculate : false, // 是否打开面积计算
			drawingToolOptions : {
				anchor : BMAP_ANCHOR_TOP_RIGHT, // 位置
				offset : new BMap.Size(5, 5), // 偏离值
				scale : 0.8, // 工具栏缩放比例
				drawingTypes : [ BMAP_DRAWING_MARKER, BMAP_DRAWING_CIRCLE,
						BMAP_DRAWING_POLYLINE, BMAP_DRAWING_POLYGON,
						BMAP_DRAWING_RECTANGLE ]
			},
			markerOptions : mOption,
			circleOptions : styleOptions, // 圆的样式
			polylineOptions : styleOptions, // 线的样式
			polygonOptions : styleOptions, // 多边形的样式
			rectangleOptions : styleOptions
		// 矩形的样式
		});

		// 添加鼠标绘制工具监听事件，用于获取绘制结果
		drawingManager_BD.addEventListener('overlaycomplete',
				DManagerComplete_BD);
	} catch (ex) {
		// catchTheException("InitDrawingManager_BD", ex);
	}
};
function DManagerComplete_BD(event) {
	try {
		drawingManager_BD.close();
		// event.overlay
		if (drawCallback_BD != null) {
			eval("drawCallback_BD(event.overlay)");
		}
	} catch (ex) {
		// catchTheException("DManagerComplete_BD", ex);
	}
};
/*
 * 创建右键菜单
 */
baiduAPI.prototype.setContextMenu = function(myMenu) {
	try {
		this.maplet.addContextMenu(myMenu.menu);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.setContextMenu", ex);
	}
};
// 地图右键菜单
var MapContextMenu = baiduAPI.prototype.MapContextMenu = function() {
	try {
		this.menu = new BMap.ContextMenu();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.MapContextMenu", ex);
	}
};
MapContextMenu.prototype.addMenuItem = function(title, callback) {
	try {
		this.menu.addItem(new BMap.MenuItem(title, callback));
	} catch (ex) {
		// catchTheException("baiduAPI.js的addMenuItem", ex);
	}
};
/*
 * 监听事件
 */
baiduAPI.prototype.addListener = function(obj, sEvent, callbackFun) {
	try {
		return eval("obj.addEventListener(sEvent, callbackFun)");
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addListener", ex);
	}
};
// 监听地图Zoom事件
baiduAPI.prototype.addZoomListener = function(callbackFun) {
	try {
		return this.maplet.addEventListener("zoomend", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addZoomListener", ex);
	}
};
// 监听地图Zoom事件
baiduAPI.prototype.addMapMoveListener = function(callbackFun) {
	try {
		return this.maplet.addEventListener("moveend", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMapMoveListener", ex);
	}
};
// 监听点Drag事件
baiduAPI.prototype.addMarkerDragListener = function(obj, callbackName) {
	try {
		this.markerDragBack.callbackName = callbackName;
		this.markerDragBack.type = obj.type;
		obj.addEventListener("dragend", this.markerDragBack);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMarkerDragListener", ex);
	}
};
// 点拖动回调
baiduAPI.prototype.markerDragBack = function(marker) {
	try {
		marker.lon = marker.point.lng;
		marker.lat = marker.point.lat;
		marker.type = this.type;
		var ll02Obj = LLBDTo02(marker.point.lng, marker.point.lat);
		var ll84Obj = LL02To84(ll02Obj.lon, ll02Obj.lat);
		var rObj = {
			ll84 : {
				lon : ll84Obj.lon,
				lat : ll84Obj.lat
			},
			ll02 : {
				lon : ll02Obj.lon,
				lat : ll02Obj.lat
			}
		};
		return eval(baiduAPI.prototype.markerDragBack.callbackName
				+ "(rObj,marker)");
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.markerDragBack", ex);
	}
};
// 线点击事件
baiduAPI.prototype.addLineClickListener = function(obj, callback) {
	try {
		this.lineClickBack.callback = callback;
		this.lineClickBack.lineObj = obj;
		obj.addEventListener("click", this.lineClickBack);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addLineClickListener", ex);
	}
};
baiduAPI.prototype.lineClickBack = function(event) {
	try {
		var rObj = {
			ll84 : {
				lon : 0,
				lat : 0
			},
			ll02 : {
				lon : 0,
				lat : 0
			}
		};
		var ll02Obj = LLBDTo02(event.point.lng, event.point.lat);
		var ll84Obj = LL02To84(ll02Obj.lon, ll02Obj.lat);
		var rObj = {
			ll84 : {
				lon : ll84Obj.lon,
				lat : ll84Obj.lat
			},
			ll02 : {
				lon : ll02Obj.lon,
				lat : ll02Obj.lat
			}
		};
		return eval("baiduAPI.prototype.lineClickBack.callback(rObj,baiduAPI.prototype.lineClickBack.lineObj)");
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.lineClickBack", ex);
	}
};
// marker点击事件
baiduAPI.prototype.addMarkerClick = function(obj, callback) {
	try {
		this.markerClickBack.callback = callback;
		this.markerClickBack.markerObj = obj;
		obj.addEventListener("click", this.markerClickBack);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMarkerClick", ex);
	}
};
baiduAPI.prototype.markerClickBack = function(event) {
	try {
		var rObj = {
			ll84 : {
				lon : 0,
				lat : 0
			},
			ll02 : {
				lon : 0,
				lat : 0
			}
		};
		var ll02Obj = LLBDTo02(event.point.lng, event.point.lat);
		var ll84Obj = LL02To84(ll02Obj.lon, ll02Obj.lat);
		var rObj = {
			ll84 : {
				lon : ll84Obj.lon,
				lat : ll84Obj.lat
			},
			ll02 : {
				lon : ll02Obj.lon,
				lat : ll02Obj.lat
			}
		};
		return eval("baiduAPI.prototype.markerClickBack.callback(rObj,baiduAPI.prototype.markerClickBack.markerObj)");
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.markerClickBack", ex);
	}
};
// 鼠标Over点事件
baiduAPI.prototype.addMouseoverListener = function(callbackFun) {
	try {
		this.maplet.addEventListener("mouseover", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMouseoverListener", ex);
	}
};
// 鼠标Out事件
baiduAPI.prototype.addMouseoutListener = function(callbackFun) {
	try {
		this.maplet.addEventListener("mouseout", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMouseoutListener", ex);
	}
};
// 鼠标Over点事件
baiduAPI.prototype.addMarkerMouseoverListener = function(obj, callbackFun) {
	try {
		obj.addEventListener("mouseover", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMarkerMouseoverListener",
		// ex);
	}
};
// 鼠标Out点事件
baiduAPI.prototype.addMarkerMouseoutListener = function(obj, callbackFun) {
	try {
		obj.addEventListener("mouseout", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMarkerMouseoutListener",
		// ex);
	}
};
// 鼠标移动结束事件
baiduAPI.prototype.addMousemoveListener = function(callbackFun) {
	try {
		this.maplet.addEventListener("mousemove", callbackFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.addMousemoveListener", ex);
	}
};
/*
 * 删除监听事件
 */
baiduAPI.prototype.removeListener = function(handle, obj, sEvent, removeFun) {
	try {
		return eval("obj.removeEventListener(sEvent, callbackFun)");
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.removeListener", ex);
	}
};
// 移除地图缩放事件
baiduAPI.prototype.removeZoomListener = function(handle, removeFun) {
	try {
		return this.maplet.removeEventListener("zoomend", removeFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.removeZoomListener", ex);
	}
};
// 监听点Drag事件
baiduAPI.prototype.removeMarkerDragListener = function(handle, obj, removeFun) {
	try {
		return obj.removeEventListener("dragend", removeFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.removeMarkerDragListener", ex);
	}
};
/*
 * 经纬度To像素值 llObj:{lon:lon,lat:lat}；@return:{x:x,y:y}
 */
baiduAPI.prototype.pointToPixel = function(llObj) {
	try {
		var point = new BMap.Point(llObj.lon, llObj.lat);
		var xy = this.maplet.pointToPixel(point);
		point = null;
		return xy;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.pointToPixel", ex);
	}
};
/*
 * 像素值To经纬度 @return:{lng:lng,lat:lat}
 */
baiduAPI.prototype.pixelToPoint = function(x, y) {
	try {
		var LLObj = this.maplet.pixelToPoint(new BMap.Pixel(x, y));
		var rObj = {
			lon : LLObj.lng,
			lat : LLObj.lat
		};
		return rObj;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.pixelToPoint", ex);
	}
};
/*
 * 获取地图的可视范围
 */
baiduAPI.prototype.getViewBounds = function() {
	try {
		var boundsObj = this.maplet.getBounds();
		var neObj = boundsObj.getNorthEast();
		var ne = {
			lon : neObj.lng,
			lat : neObj.lat
		};
		var swObj = boundsObj.getSouthWest();
		var sw = {
			lon : swObj.lng,
			lat : swObj.lat
		};
		var rObj = {
			ne : ne,
			sw : sw
		};
		return rObj;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getViewBounds", ex);
	}
};
/*
 * 根据bounds，将地图设置为相应的等级及中心点展示 bounds:{sw:{lon:lon,lat:lat},ne:{lon:lon,lat:lat}}
 */
baiduAPI.prototype.fitBounds = function(bounds) {
	try {
		var boundsArr = new Array();
		boundsArr.push(new BMap.Point(bounds.sw.lon, bounds.ne.lat));
		boundsArr.push(new BMap.Point(bounds.ne.lon, bounds.ne.lat));
		boundsArr.push(new BMap.Point(bounds.ne.lon, bounds.sw.lat));
		boundsArr.push(new BMap.Point(bounds.sw.lon, bounds.sw.lat));
		this.maplet.setViewport(boundsArr);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.fitBounds", ex);
	}
};
/*
 * 计算距离
 */
baiduAPI.prototype.getDistance = function(llObj01, llObj02) {
	try {
		var dis = this.maplet.getDistance(new BMap.Point(llObj01.lon,
				llObj01.lat), new BMap.Point(llObj02.lon, llObj02.lat));
		return dis;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getDistance", ex);
	}
};
/*
 * 获取marker对象的地图
 */
baiduAPI.prototype.getMapOfMarker = function(marker) {
	try {
		return marker.getMap();
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.getMapOfMarker", ex);
	}
};
/*
 * 放大边界，使其包含给定的点
 */
baiduAPI.prototype.extendBounds = function(llObj, bounds) {
	try {
		var bdBounds = new BMap.Bounds(new BMap.Point(bounds.sw.lon,
				bounds.sw.lat), new BMap.Point(bounds.ne.lon, bounds.ne.lat));
		var point = new BMap.Point(llObj.lon, llObj.lat);
		bdBounds.extend(point);
		var rObj = {
			sw : {
				lon : bdBounds.getSouthWest().lng,
				lat : bdBounds.getSouthWest().lat
			},
			ne : {
				lon : bdBounds.getNorthEast().lng,
				lat : bdBounds.getNorthEast().lat
			}
		};
		return rObj;
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.extendBounds", ex);
	}
};
/*
 * 点的点击事件（聚合使用）
 */
baiduAPI.prototype.AddMarkerClickListener = function(marker, clickFun) {
	try {
		marker.addEventListener("click", clickFun);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.AddMarkerClickListener", ex);
	}
};
/*
 * 经纬度是否在某个边界内
 */
baiduAPI.prototype.IsLLObjInBounds = function(llObj, bounds) {
	try {
		var bdBounds = new BMap.Bounds(new BMap.Point(bounds.sw.lon,
				bounds.sw.lat), new BMap.Point(bounds.ne.lon, bounds.ne.lat));
		var point = new BMap.Point(llObj.lon, llObj.lat);
		return bdBounds.containsPoint(point);
	} catch (ex) {
		// catchTheException("baiduAPI.prototype.IsLLObjInBounds", ex);
	}
};
/*
 * 创建叠加图层
 */
baiduAPI.prototype.createLayer = function(options) {
	return null;
};
/*
 * 添加叠加层到地图上
 */
baiduAPI.prototype.addLayer = function(layer) {
};
/*
 * 删除叠加层
 */
baiduAPI.prototype.removeLayer = function(layer) {
};

var MapUtils = {
	geocoder : new BMap.Geocoder(),

	// 根据经纬度获取地理位置
	// 参数：
	// q:经度，纬度 , 35.33442323,182.0034855
	// callback:function(address, addressObj){}
	// address:String 为解析到的地理位置，如果 address = null，说明没有解析到位置
	// addressObj:Object 详细的位置对象

	geocodeFromPoint : function(q, callback) {
		var latlng = q.split(",");
		var point = new BMap.Point(parseFloat(latlng[1]), parseFloat(latlng[0]));
		var geocoder = new BMap.Geocoder();

		geocoder.getLocation(point, function(rs) {
			if (rs != null) {
				if (callback && typeof callback == 'function') {
					callback(rs.address, rs);
				}
			} else {
				if (callback && typeof callback == 'function') {
					callback(null);
				}
			}
		});
	},
	/*
	 * 将火星坐标点转换到百度坐标点
	 */
	convertFrom02 : function(lon02, lat02) {
		var point = this.convertOrigialFrom02(lon02, lat02);
		return new BMap.Point(point.lon, point.lat);
	},
	/*
	 * 将火星坐标点转换到坐标对象
	 */
	convertOrigialFrom02 : function(lon02, lat02) {
		try {
			var x_pi = 3.14159265358979324 * 3000.0 / 180.0;
			var x = lon02, y = lat02;
			var z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
			var theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
			var lonBD = z * Math.cos(theta) + 0.0065;
			var latBD = z * Math.sin(theta) + 0.006;
			x_pi = null;
			x = null;
			y = null;
			z = null;
			theta = null;

			return {
				lon : lonBD,
				lat : latBD
			};
		} catch (ex) {
			// catchTheException("convertFrom02", ex);
		}
	}
}

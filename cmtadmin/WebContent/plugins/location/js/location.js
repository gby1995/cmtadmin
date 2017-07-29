var minimp;
/**
 * 0：发货地址 1：收货地址
 */
var targetFlag = 0;

var sendObj;
var receiveObj;
var sendInputObj;
var receiveInputObj;
$(function() {
	initMap();
	
});
function searchLocation() {
	$("#progress").show();
	$("#POI").show();
	if ($("#getDest").attr('isclick')) {
		$('#getDest').click();
		$('#layer_pop_tip').hide(0);
	}

	var key = $("#poiText").val();
	if (key == '') {
		$("#progress").hide();
		return;
	}
	searchObj = new BMap.LocalSearch(minimp, options);
	searchObj.search(key);
}
window.openInfoWinFuns = null;
var options = {
	onSearchComplete : function(results) {

		minimp.clearOverlays();
		openInfoWinFuns = null;
		$("#progress").hide();
		// 判断状态是否正确
		if (searchObj.getStatus() == BMAP_STATUS_SUCCESS) {
			var divElement = '<div style="font-family: arial,sans-serif;height:510px;overflow:scroll;font-size: 12px;">';
			divElement += '<div style="background: none repeat scroll 0% 0% rgb(255, 255, 255);">';
			divElement += '<ol style="list-style: none outside none; padding: 0pt; margin: 0pt;margin-top:5px;text-align:left;">';
			openInfoWinFuns = [];
			for ( var i = 0; i < results.getCurrentNumPois(); i++) {
				var marker = addMarker(results.getPoi(i).point, i);
				var openInfoWinFun = addInfoWindow(marker, results.getPoi(i), i);
				openInfoWinFuns.push(openInfoWinFun);
				// 默认打开第一标注的信息窗口
				var selected = "";
				if (i == 0) {
					selected = "background-color:#f0f0f0;";
					openInfoWinFun();
				}
				divElement += '<li id="list'
						+ i
						+ '" style="margin: 2px 0pt; cursor: pointer; overflow: hidden; line-height:30px;'
						+ selected + '" onclick="openInfoWinFuns[' + i
						+ ']()">';
				divElement += '<span style="color:#00c;text-decoration:underline;margin-left:10px;">'
						+ results.getPoi(i).title.replace(new RegExp(
								results.keyword, "g"), '<b>' + results.keyword
								+ '</b>') + '</span>';
				divElement += '<span style="color:#666;"> - '
						+ results.getPoi(i).address + '</span>';
				divElement += '</li>';

			}
			divElement += '</ol></div></div>';
			$("#poiList").empty();
			$("#poiList").append(divElement);
		}
	}
};
// 添加标注
function addMarker(point, index) {
	var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png",
			new BMap.Size(23, 25), {
				offset : new BMap.Size(10, 25),
				imageOffset : new BMap.Size(0, 0 - index * 25)
			});
	var marker = new BMap.Marker(point, {
		icon : myIcon
	});
	minimp.addOverlay(marker);
	return marker;
}
// 添加信息窗口
function addInfoWindow(marker, poi, index) {
	var maxLen = 10;
	var name = null;
	if (poi.type == BMAP_POI_TYPE_NORMAL) {
		name = "地址：  ";
	} else if (poi.type == BMAP_POI_TYPE_BUSSTOP) {
		name = "公交：  ";
	} else if (poi.type == BMAP_POI_TYPE_SUBSTOP) {
		name = "地铁：  ";
	} else {
		name = "地址：  ";
	}
	// infowindow的标题
	var infoWindowTitle = '<div style="font-weight:bold;color:#CE5521;font-size:14px">'
			+ poi.title + '</div>';
	// infowindow的显示信息
	var infoWindowHtml = [];
	infoWindowHtml
			.push('<table cellspacing="0" style="table-layout:fixed;width:100%;font:12px arial,simsun,sans-serif"><tbody>');
	infoWindowHtml.push('<tr>');
	infoWindowHtml
			.push('<td style="vertical-align:top;line-height:16px;width:38px;white-space:nowrap;word-break:keep-all">'
					+ name + '</td>');
	infoWindowHtml.push('<td style="vertical-align:top;line-height:16px">'
			+ poi.address + ' </td>');
	infoWindowHtml.push('</tr>');
	infoWindowHtml.push('</tbody></table>');
	var infoWindow = new BMap.InfoWindow(infoWindowHtml.join(""), {
		title : infoWindowTitle,
		width : 200
	});

	var openInfoWinFun = function() {
		marker.openInfoWindow(infoWindow);
		for ( var cnt = 0; cnt < maxLen; cnt++) {
			if (!document.getElementById("list" + cnt)) {
				continue;
			}
			if (cnt == index) {
				document.getElementById("list" + cnt).style.backgroundColor = "#f0f0f0";
			} else {
				document.getElementById("list" + cnt).style.backgroundColor = "#fff";
			}
		}
		var p = marker.getPosition();

		$("#destText").val(
				"经度:" + p.lng + ", " + "纬度:" + p.lat + ", " + " 地址:"
						+ poi.address + ", ");

	};
	marker.addEventListener("click", openInfoWinFun);
	return openInfoWinFun;
}

function SetFrameSize() {
	$('#progress').css("top",
			$(window).height() / 2 - $("#progress").height() / 2);
	$('#progress').css("left",
			$(window).width() / 2 - $("#progress").width() / 2);

};

$(window).resize(function() {
	SetFrameSize();
});
function loadMapScript() {
	var script = document.createElement("script");
	script.src = "http://api.map.baidu.com/api?v=1.3&callback=initialize";
	document.body.appendChild(script);
}
function initialize() {
	minimp = new BMap.Map('miniMap');
	minimp.centerAndZoom(new BMap.Point(116.4035, 39.915), 12);
	minimp.enableScrollWheelZoom(); // 启用滚轮放大缩小
	minimp.setDefaultCursor("default");
}

function openMapLayer() {
	var strAddress = '';
	if (targetFlag == 0) {
		strAddress = $(sendInputObj).val();
		// $("#destText").val("经度:" + sendLongitude + ", " + "纬度:" +
		// sendLatitude + ", ");
	} else {
		strAddress = $(receiveInputObj).val();
		// $("#destText").val("经度:" + receiveLongitude + ", " + "纬度:" +
		// receiveLatitude + ", ");
	}
	$("#destText").val("");
	$("#destName").val("");

	var _this = $(".all_box .layer_pop_box"), _thistop = -_this.height() / 2, _thisleft = -_this
			.width() / 2;
	_this.css({
		top : "50%",
		left : "50%",
		"margin-top" : (_thistop),
		"margin-left" : (_thisleft)
	}).show(300);
	$("#poiList").empty();
	minimp = new BMap.Map('miniMap');
	minimp.centerAndZoom(new BMap.Point(116.4035, 39.915), 12);
	minimp.enableScrollWheelZoom(); // 启用滚轮放大缩小
	minimp.setDefaultCursor("default");

	if (strAddress != '') {
		$("#poiText").val(strAddress);
		searchLocation();
	}
}
//
function setLocation() {
	var d = $("#destText").val();
	var arr = d.split(',');
	var addr = '';
	var geolat = 0;
	var geolong = 0;
	if (arr.length < 3)
		return;
	for ( var i = 0; i < arr.length; i++) {
		var temp = arr[i].split(':');
		switch (i) {
		case 0:
			geolong = temp[1];
			break;
		case 1:
			geolat = temp[1];
			break;
		case 2:
			if (arr.length > 3)
				addr = temp[1];
			break;
		}
	}

	if (targetFlag == 0) {
		$(sendObj).parent().find("input.latitudeHide").val(geolat);
		$(sendObj).parent().find("input.longitudeHide").val(geolong);
		if ($.trim(addr) != '') {
			$(sendInputObj).val(addr);
		}
		$(sendObj).attr("src", "plugins/location/images/dingweion.jpg");
	} else {
		$(receiveObj).parent().parent().parent().find("input[name='receiveLatitude']").val(geolat);
		$(receiveObj).parent().parent().parent().find("input[name='receiveLongitude']").val(geolong);
		if ($.trim(addr) != '') {
			$(receiveInputObj).val(addr);
		}
		$(receiveObj).attr("src", "plugins/location/images/dingweion.jpg");
	}
}
function showMouseTip(e) {
	_thisX = e.clientX, _thisY = e.clientY;
	$("#mouseover_tip").css({
		top : (_thisY),
		left : (_thisX),
		"margin-top" : (0),
		"margin-left" : (0)
	}).show(0);
}
function hideMouseTip(e) {
	$("#mouseover_tip").hide(0);
};
function initMap() {
	// 初始化地图
	loadMapScript();
	// 设置屏幕尺寸
	SetFrameSize();
	$("#poiText").keydown(function(e) {
		if (e.keyCode == 13) {
			$('#poiBtn').click();
		}
	});
	
	// 添加目的地事件
	$(".addressLocation").on(
			'click',
			function() {
				targetFlag = 0;
				sendObj = this;
//				sendInputObj = $(sendObj).parent().parent().parent().find(
				sendInputObj = $(sendObj).parent().find("input.addressLocation");
				openMapLayer();
			});

	// $("#getSendLocation").on('click', function () {
	// targetFlag = 0;
	// openMapLayer();
	// });
	// $("#getReceiveLocation").on('click', function () {
	// targetFlag = 1;
	// openMapLayer();
	// });

	$(".layer_pop_box .closer").on(
			'click',
			function() {
				// setLocation();
				layer.close(gpsButtons.indexTip); 
				$("#getDest").removeAttr('isclick');
				minimp.removeEventListener("click", showMark);
				$("#getDest").css("background",
						"url(plugins/location/images/getDest.png) no-repeat center");
				$("#getDest").html("拾取目的地");
				$("#progress").hide();
				$("#poiText").val("输入地址，立即查找");
			});
	// 搜索框单击事件
	$('#searchField,#poiText').on('click', function() {

		if ($('#searchField,#poiTex').attr('clicked')) {

		} else {
			$('#searchField,#poiTex').attr('clicked', "1");
			$(this).attr('value', "");
			$(this).css('color', "#000");
		}
	});
	// 获取目的地坐标完成事件
	$("#destOkBtn").on(
			'click',
			function() {
				setLocation();
				layer.close(gpsButtons.indexTip); 
				$("#getDest").removeAttr('isclick');
				minimp.removeEventListener("click", showMark);
				$("#getDest").css("background",
						"url(plugins/location/images/getDest.png) no-repeat center");
				$("#getDest").html("拾取目的地");
				$("#poiText").val("输入地址，立即查找");
			});

	// 单击关闭地图事件
	$(".title_box .closer").on('click', function() {
		layer.close(gpsButtons.indexTip); 
	});

	// 添加地名完成事件
	$("#destNameOk").on(
			'click',
			function() {
				layer.close(gpsButtons.indexTip); 
				$("#destText").val(
						$("#destText").val() + "地址:" + $("#destName").val()
								+ ", ");
			});
	// 添加鼠标拾取
	$('#getDest').on(
			'click',
			function() {

				if (!$(this).attr('isclick')) {
					$(this).attr('isclick', "1");
					// 将标注添加到地图中
					minimp.addEventListener("click", showMark);
					$(this).css("background",
							"url(plugins/location/images/getDestOn.png) no-repeat center");
					$(this).html("取消拾取");
					$("#poiList").empty();
					minimp.clearOverlays();
				} else {
					$(this).removeAttr('isclick');
					minimp.removeEventListener("click", showMark);
					$(this).css("background",
							"url(plugins/location/images/getDest.png) no-repeat center");
					$(this).html("拾取目的地");
				}
			});

	function showMark(e) {
		// 地名输入框
		/*var _this = $(".all_box .layer_pop_tip").eq($(this).prevAll().length), _thisX = e.clientX, _thisY = e.clientY;
		_this.css({
			top : (_thisY),
			left : (_thisX),
			"margin-top" : (0),
			"margin-left" : (0)
		}).show(300);
		$("#destName").val("");*/
		minimp.clearOverlays();
		// 地图标点
		var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建标注
		this.addOverlay(marker);
		// $("#destText").val(
		// "经度:" + e.point.lng + ", " + "纬度:" + e.point.lat + ", ");
		f_getLocationLocation(e.point.lng, e.point.lat);

	}
}
function f_getLocationLocation(lon, lat) {
	var point = new BMap.Point(lon, lat);
	var gc = new BMap.Geocoder();
	gc.getLocation(point, function(rs) {
		var addComp = rs.addressComponents;
		var str = addComp.province + " " + addComp.city + " "
				+ addComp.district+ " " + addComp.street;
		// var str = addComp.province + ", " + addComp.city + ", "
		// + addComp.district + ", " + addComp.street + ", "
		// + addComp.streetNumber;
		$("#destText").val(
				"经度:" + lon + ", " + "纬度:" + lat + ", " + " 地址:" + str + ", ");
	});
}
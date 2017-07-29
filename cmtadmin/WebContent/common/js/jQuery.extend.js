////////////////////////////扩展ajax方法/////////////////////////////////////////////////////////////////
$(function() {
	// 备份 $.get 方法
	var _get = $.get;

	/*
	 * 重写了 $.get 方法，用于向服务器发送get请求，输入参数与 $.get 一致
	 * 对于服务器返回的数据，该方法会判断是否有错误标识，并且会提示错误
	 */
	jQuery.get = function() {

		return _get.apply(this, arguments);
		
		var origalCallback = null;

		var callback = function(response, status, xhr) {
			switch (typeof response) {
			case 'string':
				break;

			case 'object':
				if (response.hasOwnProperty('success')
						&& response.success != true) {
					layer.msg(response.msg || '发生了错误');
				}

				break;
			}

			origalCallback(response, status, xhr);
		};

		if (arguments.length > 0) {
			if (typeof arguments[arguments.length - 1] === 'function') {
				origalCallback = arguments[arguments.length - 1];
				arguments[arguments.length - 1] = callback;
			}

			return _get.apply(this, arguments);
		}
	}
});

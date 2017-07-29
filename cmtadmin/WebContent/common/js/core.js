/*
 * 全局框架，后期维护
 */ 

/*
window.onerror = function (message, file, line, col, error) {
    console.log(message, "from", error.stack);
    // You can send data to your server
    // sendData(data);
};

// Only Chrome & Opera have an error attribute on the event.
window.addEventListener("error", function (e) {
    console.log(e.error.message, "from", e.error.stack);
    // You can send data to your server
    // sendData(data);
});
*/


/*
$.ajaxSetup({
	beforeSend: function(xhr, options) {
        options.url = baseHref + options.url；
    },
	complete: function(XMLHttpRequest, textStatus) { 
    	try {
            var json = $.parseJSON(XMLHttpRequest.responseText); 
            if (json.value === 'notlogin') 
                location.href='login.html'; 
        } catch(e) {
        	
        }; 
    }, 
    statusCode: { 
        404: function() { 
             
        }, 
        504: function() { 
             
        }, 
        500: function() { 
             
        } 
    } 
}); 
*/
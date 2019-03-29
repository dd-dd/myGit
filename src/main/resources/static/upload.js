/*$(function() {*/
	function upTo(){
		console.log("开始上传");
		var files = $('#files')[0].files;
		for(var i=0; i< files.length; i++){
			/*alert(files[i].name);*/
			}
		var file0 =  files[0];
		var formData = new FormData();
		formData.append('file', file0);
/*})*/
	$.ajax({  
		type: "POST",
	    　　url: "/ddd/upFile",
	    　　data: formData , //这里上传的数据使用了formData 对象
	    　　processData: false, 
	    　　contentType: false, //必须false才会自动加上正确的Content-Type
	    　　//这里我们先拿到jQuery产生的 XMLHttpRequest对象，为其增加 progress 事件绑定，然后再返回交给ajax使用
	    //获取ajaxSettings中的xhr对象，为它的upload属性绑定progress事件的处理函数
	    xhr: function(){ 
	        myXhr = $.ajaxSettings.xhr();          //获取ajaxSettings中的xhr对象，为它的upload属性绑定progress事件的处理函数
	        if(myXhr.upload){            //绑定progress事件的回调函数
	            myXhr.upload.addEventListener('progress',progressHandlingFunction, false);
	        }    //xhr对象返回给jQuery使用
	        return myXhr; 
	      },    
	      success:function(){}
	});
	
	function progressHandlingFunction(e) { 
		if (e.lengthComputable) { 
			//e.loaded 上传大小
            //e.total 文件大小
        var percent = e.loaded/e.total;
       
        var loaded = Math.floor(100 * percent);
        console.log("上传百分比====="+loaded);
    }
} 
	
	}
	
	
	
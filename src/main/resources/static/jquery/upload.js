$(function() {
	function upTo(){
		var files = $('#files')[0].files[0]
		for(var i=0; i< files.length; i++){
			alert(files[i].name);
			}	
	}
	
	
	
	
}
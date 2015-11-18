function initDialog(){
	$('.list-filter .btn').click(function(){
		$(this).siblings('.btn').removeClass('active');
		$(this).addClass('active');
		if($(this).find('input:radio').attr('id')=='filter-unavailable'){
			$('#available-courses').hide();
			$('#no-courses').show();
		}else{
			$('#available-courses').show();
			$('#no-courses').hide();
		}
	});
	$('.cCollapsible legend').click(function(){
		var parent = $(this).parents('.cCollapsible');
		var fieldset = $(this).siblings('.cFieldsetData');
		if(fieldset.is(':hidden')){
			parent.removeClass('cCollapsed');
			$(this).addClass('expand');
			fieldset.show();
		}else{
			fieldset.hide();
			$(this).removeClass('expand');
			parent.addClass('cCollapsed');
		}
	});
	$('.cRadioLabel').click(function(){
		$(this).siblings('.cRadioInput').find('input[type=radio]').click();
	})
	$('#accordion').accordion();
}

function openPageDialog(url, title, width, buttons){
	$('#dialogDiv').remove();
	$('body').append('<div id="dialogDiv"></div>');
	$.get(url, function(r){
		$('#dialogDiv').html(r);
	}, 'html');
	$('#dialogDiv').dialog({  
    	autoOpen:false,
        width:width,//宽度 
        buttons:buttons?buttons:{  
        	"取消":function(){  
            	$(this).dialog('close');
            	$('#main').css({'position':'absolute'});
            },
            "确认":function(){  
            	if($(this).find('form').validationEngine('validate')){
	            	$(this).find('form').submit();
	            	$(this).dialog('close');
	            	$('#main').css({'position':'absolute'});
            	}
            } 
        },
        bgiframe:false,
        closeOnEscape:false,//按esc退出默认的true  
        draggable:true, //拖拽默认是true  
        resizable:false,
        hide:"toggle",//关闭窗口的效果  
        modal:true, //遮罩效果默认是false不遮住  
        //position:['center','center'], //对话框弹出的位置，top,left,right,center,默认是center  
        //show:"slide",//打开窗口的效果  
        title:title//设置对话框的标题  
    });
	$('#main').css({'position':'fixed'});
	$('#dialogDiv').dialog('open');
}

layui.use(['table', 'form', 'jquery', 'layer','laytpl'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		form = layui.form ;

	//查询读者
	$("#search_reader").click(function(){
		var readerId=$("#readerId").val();
		if(readerId.length==0) return;
		$.getJSON("../static/api/reader_info.json",function(res){
			console.log(res);
			if(res.code!=0){
				return ;
			}
			//渲染读者信息模板
			laytpl($("#reader_info_tmpl").html()).render(res.data,function(html){
				$("#reader_info").html(html);
			});
			//请求获取该读者的借阅记录
			$.getJSON("../static/api/borrow.json",function(res){
				console.log(res);
				if(res.code!=0){
					return ;
				}
				layui.each(res.data,function(index,item){
					laytpl($("#borrow_info_tmpl").html()).render(item,function(html){
						$("#borrow_info").append(html);
					});
				});
			});
		});
	});
	
	//查询书籍
	$("#search_book").click(function(){
		var bookId=$("#bookId").val();
		if(bookId.length==0) return;
		$.getJSON("../static/api/book_info.json",function(res){
			console.log(res);
			if(res.code!=0){
				return ;
			}
			//渲染书籍信息模板
			laytpl($("#book_info_tmpl").html()).render(res.data,function(html){
				$("#book_info").html(html);
			});
		});
	});
	
	//确认借书
	$("#borrow_book").click(function(){
		var readerId=$("#readerId").val(),
			bookId=$("#bookId").val();
		if(readerId.length==0 || bookId.length==0){
			return layer.msg("读者证或者书籍编号不能为空！",{icon:2});
		}
		$.ajax({
			url:'../static/api/borrow_test.json',
			type:'get',
			// data: ,
			contentType:'application/json',
			dataType:'json',
			success:function(res){
				console.log(res);
				if(res.code!=0){
					return layer.msg(res.msg,{icon:2})
				}
				return layer.msg("借书成功!",{icon:1,time:1500},function(){
					laytpl($("#borrow_info_tmpl").html()).render(res.data,function(html){
						$("#borrow_info").append(html);
					});
				});
			},
			error:function(){
				return layer.msg("服务器出错!",{icon:2});
			}
		});
	});
	
	
	//还书
	$("#return_book").click(function(){
		var bookId=$("#bookId").val();
		if(bookId.length==0){
			return layer.msg("书籍编号不能为空！",{icon:2});
		}
		//ajax
	});
	
	//处理缴费
	$("#handle_fine").click(function(){
		var readerId=$("#readerId").val();
		if(readerId.length==0){
			return layer.msg("读者证号不能为空！",{icon:2});
		}
		//ajax
		layer.confirm("确认读者已缴费？",{title:'模拟缴费',icon:3},function(){
			//ajax
			return layer.msg("缴费成功！",{icon:1});
		});
	});
	
});

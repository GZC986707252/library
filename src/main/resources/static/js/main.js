layui.use(['table', 'form', 'jquery', 'layer','laytpl'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		laytpl = layui.laytpl,
		form = layui.form ;


	/**
	 * 根据读者ID,请求读者信息和读者借阅记录信息，并渲染到模板
	 * @param readerId
	 */
	function readerDetailRender(readerId) {
		$.getJSON("/reader/list/"+readerId,function(res){
			if(res.code!=0){
				return layer.msg(res.msg,{icon:2});
			}
			//渲染读者信息模板
			laytpl($("#reader_info_tmpl").html()).render(res.data,function(html){
				$("#reader_info").html(html);
			});
			//请求获取该读者的借阅记录
			$.getJSON("/main/borrow_record",{readerId:readerId},function(res){
				if(res.code!=0){
					return ;
				}
				$("#borrow_info").html("");
				$.each(res.data, function (index, item) {
					laytpl($("#borrow_info_tmpl").html()).render(item,function(html){
						$("#borrow_info").append(html);
					});
				});
			});
		});
	}

	/**
	 * 根据书籍ID,请求书籍信息并渲染模板
	 * @param bookId
	 */
	function bookRender(bookId) {
		$.getJSON("/book/list/"+bookId,function(res){
			if(res.code!=0){
				return layer.msg(res.msg,{icon:2});
			}
			//渲染书籍信息模板
			laytpl($("#book_info_tmpl").html()).render(res.data,function(html){
				$("#book_info").html(html);
			});
		});
	}

	//查询读者
	$("#search_reader").click(function(){
		let readerId=$("#readerId").val();
		if(readerId.length==0) return;
		if (!(/^\d+$/.test(readerId))) {
			return layer.msg("输入只能为数字", {icon: 2});
		}
		readerDetailRender(readerId);
	});
	
	//查询书籍
	$("#search_book").click(function(){
		let bookId=$("#bookId").val();
		if(bookId.length==0) return;
		if (!(/^\d+$/.test(bookId))) {
			return layer.msg("输入只能为数字", {icon: 2});
		}
		bookRender(bookId);
	});

	//确认借书
	$("#borrow_book").click(function(){
		let readerId=$("#readerId").val(),
			bookId=$("#bookId").val();
		if(readerId.length==0 || bookId.length==0){
			return layer.msg("读者证或者书籍编号不能为空！",{icon:2});
		}
		if (!(/^\d+$/.test(readerId)) || !(/^\d+$/.test(bookId))) {
			return layer.msg("输入只能为数字", {icon: 2});
		}
		$.post('/main/borrow',{readerId:readerId,bookId:bookId},function (res) {
			console.log(res);
			if(res.code!=0){
				return layer.msg(res.msg,{icon:2})
			}
			return layer.msg("借书成功",{icon:1,time:1500},function(){
				readerDetailRender(readerId);
				bookRender(bookId);
			});
		},'json');
	});
	
	
	//还书
	$("#return_book").click(function(){
		let bookId=$("#bookId").val();
		if(bookId.length==0){
			return layer.msg("书籍编号不能为空！",{icon:2});
		}
		if (!(/^\d+$/.test(bookId))) {
			return layer.msg("输入只能为数字", {icon: 2});
		}
		$.post("/main/return",{bookId:bookId},function (res) {
			console.log(res);
			if(res.code!=0){
				return layer.msg(res.msg,{icon:2})
			}
			let readerId=res.data.readerId;
			return layer.msg("还书成功",{icon:1,time:1500},function(){
				$("#readerId").val(readerId);
				readerDetailRender(readerId);
				bookRender(bookId);
			});
		},'json');
	});
	
});

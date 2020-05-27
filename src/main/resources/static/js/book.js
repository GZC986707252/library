layui.use(['table', 'form', 'jquery', 'layer'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form;

	table.render({
		elem: '#reader_tb',
		url: '../static/api/book.json',
		cols: [
			[{
				field: 'bookId',
				title: 'ID',
				width: 110,
				fixed: 'left',
				sort: true
			}, {
				field: 'bookName',
				title: '书名',
				width: 120
			}, {
				field: 'isbn',
				title: 'ISBN',
				width: 120,
				templet: function(res) {
					return '<em>' + res.isbn + '</em>'
				}
			}, {
				field: 'press',
				title: '出版社',
				width: 120
			}, {
				field: 'author',
				title: '作者',
				width: 100
			}, {
				field: 'publicationDate',
				title: '出版日期',
				width: 120
			}, {
				field: 'status',
				title: '在馆状态',
				width: 100,
				templet: function(res) {
					return res.status ? '借出' : '在馆';
				}
			}, {
				field: 'price',
				title: '价格',
				width: 80
			}, {
				field: 'createTime',
				title: '上架时间',
				width: 120
			}, {
				fixed: 'right',
				title: '操作',
				toolbar: '#barDemo',
				width: 150
			}]
		],
		page: true
	});


	//监听行工具事件
	table.on('tool(reader_tb)', function(obj) {
		var data = obj.data;
		//console.log(obj)
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', function(index) {
				obj.del();
				layer.close(index);
			});
		} else if (obj.event === 'edit') {
			add_update("/test_update","put",data,"编辑书籍");
			obj.update({
				email: value
			});
			layer.close(index);
		}
	});


	//搜索
	form.on('submit(search_btn)', function(data) {
		layer.msg(JSON.stringify(data.field));
		return false;
	});

	//点击添加按钮事件
	$("#add_btn").click(function(){
		add_update("/test_add","post",null,"添加书籍");
	});


	/**
	 * 添加或者更新弹窗
	 * @param {Object} url  请求地址
	 * @param {Object} method  请求方法
	 * @param {Object} data  发送数据
	 * @param {Object} title  弹窗标题
	 */
	function add_update(url,method,data,title){
		layer.open({
			type:1,
			title: title,
			content:$("#book_form_tmpl").html(),
			area: ['400px', '490px'],
			btn:['提交'],
			yes:function(index){
				var bookId=$("#bookId").val(),
					bookName=$("#bname").val(),
					isbn=$("#isbn").val(),
					press=$("#press").val(),
					author=$("#author").val(),
					publicationDate=$("#publicationDate").val(),
					price=$("#price").val();
				if(bookName.length==0 || isbn.length==0){
					return layer.msg("书名或ISBN不能为空!",{icon:2});
				}
				var data={
					'bookId':bookId,
					'bookName':bookName,
					'isbn':isbn,
					'press':press,
					'author':author,
					'publicationDate':publicationDate,
					'price':price
				}
				layer.alert(JSON.stringify(data)+"\n"+url+":"+method);
				layer.close(index);
			},
			success:function(){
				if(data!=null){
					//填充表单（编辑状态）
					form.val("book-form",data);
					form.render(null,"book-form");
					$("#bid").attr("disabled",true);
				}else{
					$("#bid").val("不需要填写").attr("disabled",true);
				}
			}
		});
	}

});

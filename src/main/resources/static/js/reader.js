layui.use(['table', 'form', 'jquery', 'layer'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form;

	table.render({
		elem: '#reader_tb',
		url: '../static/api/reader.json',
		cols: [
			[{
				field: 'readerId',
				title: '读者证号',
				width: 120,
				fixed: 'left',
				sort: true
			}, {
				field: 'readerName',
				title: '读者姓名',
				width: 120
			}, {
				field: 'phone',
				title: '手机号',
				width: 200,
				templet: function(res) {
					return '<em>' + res.phone + '</em>'
				}
			}, {
				field: 'status',
				title: '账户状态',
				width: 100,
				templet: function(res) {
					return res.status ? '停用' : '正常';
				}
			}, {
				field: 'fine',
				title: '欠费金额',
				width: 100
			}, {
				field: 'createTime',
				title: '注册时间',
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
			layer.prompt({
				formType: 2,
				value: data.email
			}, function(value, index) {
				obj.update({
					email: value
				});
				layer.close(index);
			});
		}
	});

	//搜索
	$("#search-btn").click(function() {
		var data = {
			'readerId': $("#readerId").val()
		}
		layer.msg(JSON.stringify(data));
	});

	//添加读者
	form.on('submit(add_btn)', function(data) {
		layer.msg(JSON.stringify(data.field));
		return false;
	});


});

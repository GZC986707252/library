layui.use(['table', 'form', 'jquery', 'layer'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		form = layui.form;

	var reader_tb=table.render({
		elem: '#reader_tb',
		url: '/reader/list',
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
		page: true,
		height: 500
	});

	//监听行工具事件
	table.on('tool(reader_tb)', function(obj) {
		var data = obj.data;
		//console.log(obj)
		if (obj.event === 'del') {
			layer.confirm('真的删除行么',{icon:3}, function(index) {
				$.ajax({
					url:'/reader/list/'+data.readerId,
					type:'delete',
					dataType:'json',
					success: function (res) {
						if(res.code!=0){
							return layer.msg("删除失败："+res.msg,{icon:2});
						}
						return layer.msg("删除成功",{icon:1,time:1300},function () {
							obj.del();
						});
					}
				})
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

	/**
	 * 	搜索
	 */
	var reader_tb_this;
	form.on('submit(search_btn)',function (data) {
		// console.log(data.field);
		//给表格添加搜索接口，添加额外参数
		if(reader_tb_this!=null){
			//必须置空，否则因为缓存导致上一次请求的参数遗留下来
			reader_tb_this.where={};
		}
		reader_tb.reload({
			url:"/reader/search",
			where:data.field,
			done:function () {
				reader_tb_this=this;   //拿到实例对象，从未清空where的参数缓存
			}
		});
	});

	/**
	 * 添加
	 */
	$("#add_btn").click(function () {
		let readerName= $("#readerName").val(),
			phone= $("#phone").val();
		if ( readerName.length==0 || phone.length==0) {
			return layer.msg("姓名或手机号不能为空！",{icon:2});
		}
		let data={
			readerName:readerName,
			phone:phone
		}
		$.ajax({
			url:'/reader/list',
			type:'post',
			data:JSON.stringify(data),
			contentType:'application/json',
			dataType: 'json',
			success:function (res) {
				if(res.code!=0){
					return layer.msg(res.msg,{icon: 2});
				}
				return layer.msg("添加成功", {icon: 1, time: 1300}, function () {
					$("#readerName").val("");
					$("#phone").val("");
					reader_tb.reload();
				});
			}
		});
	});

});

layui.use(['form','jquery','layer'], function(){
    var form = layui.form,
        $ = layui.jquery ,
        layer = layui.layer;

    //监听提交
    form.on('submit(login-btn)', function(data){
        $.post("/login.do",data.field,function (res) {
            if(res.code!=0){
                return layer.msg(res.msg,{icon:2});
            }
            return layer.msg("登录成功！",{icon:1,time:1300},function () {
                window.location.href=res.data;
            });
        },'json');
        return false;
    });
});
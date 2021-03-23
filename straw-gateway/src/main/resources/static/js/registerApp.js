let registerApp = new Vue({
    el:'#registerApp',
    methods:{
        register:function() {
            $.ajax({
                url:'/api-user/v1/users/reg',
                data:$("#form-reg").serialize(),
                type:'post',
                success:function (json) {
                    if (json.state==200){
                        alert("注册成功！");
                    }else{
                        alert(json.message);
                    }
                }
            })
        }
    }
});
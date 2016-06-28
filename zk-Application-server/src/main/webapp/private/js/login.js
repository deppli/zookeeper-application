$(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' // optional
    });

    $('form').validate({
        errorElement:'span',
        errorClass:'help-block red',
        rules:{
            email:{
                required : true,
                email:true,
                remote:{
                    url: '/ajax/loadUserByLoginName.do',
                    type:'post',
                    dataType:'json',
                    data:{
                        email:function(){
                            return $('input[type=email]').val().trim();
                        }
                    },
                    dataFilter:function(data){
                        data = JSON.parse(data);
                        if (data.flag == 'false'){
                            return false;
                        }else if (data.flag == 'true'){
                            return true;
                        }
                    }
                }
            },
            passwd:{
                required:true
            },
            repasswd:{
                required:true,
                equalTo:'#passwd'
            }

        },
        messages:{
            email:{
                required:'请输入邮件地址',
                email:'邮件格式错误',
                remote:'邮箱已注册,请重新输入'
            },
            passwd:{
                required:'请输入密码'
            },
            repasswd:{
                required:'请输入确认密码',
                equalTo:'两次输入的密码不一致'
            }
        },
        highlight:function(element, errorClass) {
        },
        unhighlight:function(element, errorClass) {
        }
    });


});
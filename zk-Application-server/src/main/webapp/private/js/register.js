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
                email:true
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
                email:'邮件格式错误'
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

    $('input[type=email]').blur(function(){
        var email = $('input[type=email]').val().trim();
        var postData ={'email':email};
        $.ajax({
            url: "/ajax/loadUserByLoginName.do",
            type:'post',
            data: postData,
            dataType:'json',
            success: function(data){
                var flag = data.flag;
                if (flag == "false") {

                }
            }
        });
    });

});
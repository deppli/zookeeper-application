<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin | Registration Page</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="/private/css/common.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <b>register</b>
    </div>

    <div class="register-box-body">

        <form action="/admin/register.do" method="post">
            <div class="form-group has-feedback">
                <input  id="email" type="email" name="email" class="form-control" placeholder="邮件" >
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="passwd" type="password" name="passwd" class="form-control" placeholder="密码" >
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input id="repasswd" type="password" name="repasswd" class="form-control" placeholder="确认密码" >
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="toLogin.do" class="text-center">已经注册</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.1.4 -->
<script src="/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/plugins/iCheck/icheck.min.js"></script>
<script src="/plugins/jquery-validation/jquery.validate.min.js"></script>
<script src="/private/js/register.js"></script>



</body>
</html>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Starter</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">

    <link rel="stylesheet" href="/plugins/datatables/dataTables.bootstrap.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect.
    -->
    <link rel="stylesheet" href="/dist/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <div  class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>A</b>LT</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>Admin</b>LTE</span>
        </div>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <ul class="dropdown-menu">
                        <li class="header">You have 10 notifications</li>
                        <li>
                            <!-- Inner Menu: contains the notifications -->
                            <ul class="menu">
                                <li><!-- start notification -->
                                    <a href="#">
                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                    </a>
                                </li>
                                <!-- end notification -->
                            </ul>
                        </li>
                        <li class="footer"><a href="#">View all</a></li>
                    </ul>
                    </li>
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">Alexander Pierce</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                <p>
                                    Alexander Pierce - Web Developer
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body -->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Followers</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Friends</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">HEADER</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="active"><a href="#"><i class="fa fa-link"></i> <span>Link</span></a></li>
                <li><a href="#"><i class="fa fa-link"></i> <span>Another Link</span></a></li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>Multilevel</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#">Link in level 2</a></li>
                        <li><a href="#">Link in level 2</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>
  <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <table id="example" class="table table-striped table-bordered">
                 <thead>
                    <tr>
                       <th>姓名</th>
                       <th>地点</th>
                       <th>薪水</th>
                       <th>入职时间</th>
                       <th>办公地点</th>
                        <th>编号</th>
                        <th>操作</th>
                     </tr>
                   </thead>
                   <tbody>
               		</tbody>
                        <!-- tbody是必须的 -->
            </table>           
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">新增</h4>
                            </div>
                            <div class="modal-body">
                			<form role="form">
                                <div class="form-group">
                					<input type="text" class="form-control" id="name" placeholder="姓名">
                				</div>
                				<div class="form-group">
                					<input type="text" class="form-control" id="position" placeholder="位置">
                				</div>
                				<div class="form-group">
                					<input type="text" class="form-control" id="salary" placeholder="薪资">
                				</div>
                				<div class="form-group">
                					<input type="text" class="form-control" id="start_date" placeholder="时间"
                                                                      data-date-format="yyyy/mm/dd">
                                </div>
                                <div class="form-group">
                                	<input type="text" class="form-control" id="office" placeholder="工作地点">
                                </div>
                                <div class="form-group">
                                	<input type="text" class="form-control" id="extn" placeholder="编号">
                                </div>
                			</form>
                            </div>
                            <div class="modal-footer">
                				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" id="save">保存</button>
                            </div>
                        </div>
                    </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2015 <a href="#">Company</a>.</strong> All rights reserved.
    </footer>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.1.4 -->
<script src="/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/dist/js/app.min.js"></script>
<script src="/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="/plugins/handlebars/handlebars-v4.0.5.js"></script>


    <!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
    {{/each}}
</script>

<script>
    var table;
    var editFlag = false;
    $(function () {


        var tpl = $("#tpl").html();
        //预编译模板
        var template = Handlebars.compile(tpl);

        table = $('#example').dataTable({
            ajax: {
                url: "/admin/test.do"
            },
            ordering: false,
            serverSide: true,
            columns: [
                {"data": "name"},
                {"data": "position"},
                {"data": "salary"},
                {"data": "start_date"},
                {"data": "office"},
                {"data": "extn"},
                {"data": null}
            ],
            columnDefs: [
                {
                    targets: 6,
                    render: function (a, b, c, d) {
                        var context =
                        {
                            func: [
                                {"name": "修改", "fn": "edit(\'" + c.name + "\',\'" + c.position + "\',\'" + c.salary + "\',\'" + c.start_date + "\',\'" + c.office + "\',\'" + c.extn + "\')", "type": "primary"},
                                {"name": "删除", "fn": "del(\'" + c.name + "\')", "type": "danger"}
                            ]
                        };
                        var html = template(context);
                        return html;
                    }
                }

            ],
           "oLanguage": {  //对表格国际化  
            "sLengthMenu": "每页显示 _MENU_条",    
            "sZeroRecords": "没有找到符合条件的数据",       
            "sInfo": "当前第 _START_ - _END_ 条　共计 _TOTAL_ 条",    
            "sInfoEmpty": "木有记录",    
            "sInfoFiltered": "(从 _MAX_ 条记录中过滤)",    
            "sSearch": "搜索：",    
            "oPaginate": {    
            "sFirst": "首页",    
            "sPrevious": "前一页",    
            "sNext": "后一页",    
            "sLast": "尾页"                     
            }    
      	  },  
            "dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>" +
            "t" +
            "<'row'<'col-xs-6'i><'col-xs-6'p>>",
            initComplete: function () {
                $("#mytool").append('<button type="button" class="btn btn-default btn-sm" onclick="addOne()">添加</button>');
            }

        });

        $("#save").click(add);


    });


	function addOne(){
		clear();
		$("#myModalLabel").text("新增");
		$("#myModal").modal("show");
	}
	

    /**
     * 清除
     */
    function clear() {
        $("#name").val("").attr("disabled",false);
        $("#position").val("");
        $("#salary").val("");
        $("#start_date").val("");
        $("#office").val("");
        $("#extn").val("");
    }

    /**
     * 添加数据
     **/
    function add() {
        var addJson = {
            "name": $("#name").val(),
            "position": $("#position").val(),
            "salary": $("#salary").val(),
            "start_date": $("#start_date").val(),
            "office": $("#office").val(),
            "extn": $("#extn").val()
        };

        ajax(addJson);
    }

    /**
     *编辑方法
     **/
    function edit(name,position,salary,start_date,office,extn) {
        console.log(name);
        editFlag = true;
        $("#myModalLabel").text("修改");
        $("#name").val(name).attr("disabled",true);
        $("#position").val(position);
        $("#salary").val(salary);
        $("#start_date").val(start_date);
        $("#office").val(office);
        $("#extn").val(extn);
        $("#myModal").modal("show");
    }

    function ajax(obj) {
        var url ="/add.jsp" ;
        if(editFlag){
            url = "/edit.jsp";
        }
        $.ajax({
            url:url ,
            data: {
                "name": obj.name,
                "position": obj.position,
                "salary": obj.salary,
                "start_date": obj.start_date,
                "office": obj.office,
                "extn": obj.extn
            }, success: function (data) {
                table.ajax.reload();
                $("#myModal").modal("hide");
                $("#myModalLabel").text("新增");
                clear();
                console.log("结果" + data);
            }
        });
    }
    /**
     * 删除数据
     * @param name
     */
    function del(name) {
        $.ajax({
            url: "/del.jsp",
            data: {
                "name": name
            }, success: function (data) {
                table.ajax.reload();
                console.log("删除成功" + data);
            }
        });
    }

</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/17
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>菜单</title>
    <jsp:include page="top.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="ch-container">
    <div class="row">

        <jsp:include page="navbar.jsp"/>

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">Tables</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-user"></i> 用户管理</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <div class="alert alert-info">For help with such table please check <a href="http://datatables.net/" target="_blank">http://datatables.net/</a></div>
                            <table id="userInfo" class="table table-striped table-bordered bootstrap-datatable datatable responsive" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>用户名</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>QQ</th>
                                        <th>邮箱</th>
                                        <th>类别</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>用户名</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>QQ</th>
                                        <th>邮箱</th>
                                        <th>类别</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                <!--/span-->

            </div><!--/row-->

            <!-- content ends -->
        </div><!--/#content.col-md-0-->
    </div><!--/fluid-row-->

    <hr>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static"
         aria-hidden="true">

        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3 id="form-title">添加用户</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="userForm">
                        <div class="form-group">
                            <label for="userName" class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="userName" id="userName" placeholder="用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="name" id="name" placeholder="姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">性别</label>
                            <div class="col-sm-10">
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="m-gender" value="1"> 男
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="gender" id="w-gender" value="0"> 女
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="qq" class="col-sm-2 control-label">QQ</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="qq" id="qq" placeholder="QQ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="type" class="col-sm-2 control-label">用户类别</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="type" name="type">
                                    <option value="0">系统用户</option>
                                    <option value="1">一般用户</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" id="save">保存</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div><!--/.fluid-container-->

<jsp:include page="down.jsp"/>

<script>
    var table ;
    $(document).ready(function () {

         table = $('#userInfo').DataTable({
            dom: "Bfrtip",
            "ajax":"selectUserInfo.do",//ajax请求后台JSON数据
             "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
             "sPaginationType": "bootstrap",
            "columns": [
                { "data": "userName" },
                { "data": "name" },
                { "data": "gender" ,
                    render:function (data, type, row) {
                        if(data){return "男"}else{return "女"}
                    }
                },
                { "data": "qq" },
                { "data": "email" },
                { "data": "type" ,
                    render:function (data, type, row) {
                        if(data.type){return "一般用户"}else{return "系统用户"}
                    }
                },
                { "data": "status" ,
                    render:function (data, type, row) {
                        if(data.status){
                            return '<span class="label-default label label-danger">失效</span>';
                        }else{
                            return '<span class="label-success label label-default">有效</span>';
                        }
                    }
                },
                {   "data":"",
                    render:function (data, type, row) {
                        return '<a class="btn btn-success" href="#">'+
                        '<i class="glyphicon glyphicon-zoom-in icon-white"></i>'+
                                '查询'+
                               ' </a>'+
                                '<a class="btn btn-info" onclick="dataEdit()">'+
                                '<i class="glyphicon glyphicon-edit icon-white"></i>'+
                                '修改'+
                               ' </a>'+
                                '<a class="btn btn-danger" href="#">'+
                                '<i class="glyphicon glyphicon-trash icon-white"></i>'+
                               ' 删除'+
                               ' </a>'
                    }
                },
            ],
            "oLanguage": {  //对表格国际化
                "sLengthMenu": "每页显示 _MENU_条",
                "sZeroRecords": "没有找到符合条件的数据",
                //  "sProcessing": "&lt;img src=’./loading.gif’ /&gt;",
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
        });
        $('#userForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName: {
                    message: '用户名不能为空',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: '长度为3-30位'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: '必须是字母数字下划线'
                        }
                    }
                },
                name: {
                    validators: {
                        notEmpty: {
                            message: '姓名不能为空'
                        }
                    }
                },
                gender: {
                    validators: {
                        notEmpty: {
                            message: '请选择性别'
                        }
                    }
                },
                qq: {
                    message: 'QQ不能为空',
                    validators: {
                        notEmpty: {
                            message: 'QQ不能为空'
                        },
                        stringLength: {
                            min: 4,
                            max: 12,
                            message: '长度为4-12位'
                        },
                        regexp: {
                            regexp: /^[0-9]+$/,
                            message: '必须是数字'
                        }
                    }
                },
                email: {
                    message: 'Email不能为空',
                    validators: {
                        notEmpty: {
                            message: 'Email不能为空'
                        },
                        emailAddress: {
                            message: '必须是Email'
                        }
                    }
                },
                type: {
                    validators: {
                        notEmpty: {
                            message: '请用户类别'
                        }
                    }
                },
            }
        });

    });
    function dataEdit() {
//        $(':input','#userForm')
//                .not(':button, :submit, :reset, :hidden')
//                .val('')
//                .removeAttr('checked')
//                .removeAttr('selected');
        $('#userForm')[0].reset();//清空表单
        $('#form-title').html("修改用户");//设置标题
        //表单赋值
        $('#userInfo tbody').on('click', 'tr', function () {
            console.log(this);
            var row = table.row( this ).data();
            $('#userName').val(row.userName);
            $('#name').val(row.name);
            $('input[name="gender"][value='+row.gender+']').attr("checked",true);
            $('#qq').val(row.qq);
            $('#email').val(row.email);
            $('#type').val(row.type);
        } );
        $('#myModal').on('hidden.bs.modal', function (e) {
            num=0;
        })

        $('#myModal').modal("show"); //模态框显示
        $('#save').click(function() {
//            $('#userForm').bootstrapValidator('validate');
            var bootstrapValidator = $("#userForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(!bootstrapValidator.isValid())return ;
            $.post('updatetUser.do', $('#userForm').serialize(), function(result) {
                alert(result);
            }, 'json');
        });
    }

</script>
</body>
</html>

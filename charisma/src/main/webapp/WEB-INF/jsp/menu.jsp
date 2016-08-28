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
    <style>
        #addMenu{
            position: absolute;
            left: 168px;
            top: 40px;
            z-index: 100;
        }
        #removeRoot{
            position: absolute;
            left: 280px;
            top: 40px;
            z-index: 100;
        }
        @media  screen and (max-width: 639px){
            #addMenu ,#removeRoot{
                position: static;
                display: block;
                margin: 5px auto;

            }
        }
    </style>
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
                <div class="box col-md-3">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-user"></i> 菜单管理</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <p>
                                <a  class="btn btn-info" id="addRoot">添加根目录</a>
                                <a  class="btn btn-primary" id="expandAll">展开全部</a>
                                <a  class="btn btn-danger" id="collapseAll">关闭全部</a>
                            </p>
                            <div id="tree"></div>
                        </div>
                    </div>
                </div>
                <div class="box col-md-9">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-user"></i> 菜单管理</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <a id="addMenu" class="btn btn-primary" disabled="disabled">添加菜单</a>
                            <a  class="btn btn-danger" id="removeRoot">删除根节点</a>
                            <table class="table table-striped table-bordered bootstrap-datatable datatable nowrap" cellspacing="0" width="100%" id="menuInfo">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>菜单名</th>
                                    <th>路径</th>
                                    <th>ICON</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>菜单名</th>
                                    <th>路径</th>
                                    <th>ICON</th>
                                    <th>排序</th>
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

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>添加根节点</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="rootMenuForm">
                        <div class="form-group">
                            <label for="text"  class="col-sm-2 control-label">菜单名</label>
                            <div class="col-sm-10">
                                <input type="text" id="text" class="form-control" name="text" placeholder="菜单名">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="href" class="col-sm-2 control-label">菜单路径</lable>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="href" placeholder="菜单路径">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="icon" class="col-sm-2 control-label">icon</lable>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="icon" placeholder="icon">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="sort" class="col-sm-2 control-label">排序</lable>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="sort" placeholder="排序">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal" id="save">保存</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="memuModal" tabindex="-1" role="dialog" aria-labelledby="memuModal" data-backdrop="static"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3 id="titleName">添加菜单</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="menuForm">
                        <input type="hidden" id="parentId" name="parentId">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">根目录</label>
                            <div class="col-sm-10">
                                <p class="form-control-static" id="rootMenuText"></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="menuText"  class="col-sm-2 control-label">菜单名</label>
                            <div class="col-sm-10">
                                <input type="text" id="menuText" class="form-control" name="text" placeholder="菜单名">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="menuHref" class="col-sm-2 control-label">菜单路径</lable>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="href" id="menuHref" placeholder="菜单路径">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="menuIcon" class="col-sm-2 control-label">icon</lable>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="icon" id="menuIcon" placeholder="icon">
                            </div>
                        </div>
                        <div class="form-group">
                            <lable for="menuSort" class="col-sm-2 control-label">排序</lable>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="sort" id="menuSort" placeholder="排序">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal" id="saveMenu">保存</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>

</div><!--/.fluid-container-->

<jsp:include page="down.jsp"/>

<script>
    var tree = [
        {
            text: "Node 1",
            icon: "glyphicon glyphicon-stop",
            selectedIcon: "glyphicon glyphicon-stop",
            color: "#000000",
            backColor: "#FFFFFF",
            href: "#node-1",
            selectable: true,
            state: {
                checked: true,
                disabled: true,
                expanded: true,
                selected: true
            },
            nodes: [
                {
                    text: "Child 1",
                    nodes: [
                        {
                            text: "Grandchild 1"
                        },
                        {
                            text: "Grandchild 2"
                        }
                    ]
                },
                {
                    text: "Child 2"
                }
            ]
        },
        {
            text: "Parent 2"
        },
        {
            text: "Parent 3"
        },
        {
            text: "Parent 4"
        },
        {
            text: "Parent 5"
        }
    ];
    var table;
    $(function () {
        $.post('selelctMenu.do',{},function (result) {

            var $tree = $('#tree').treeview({
                data: result.content.rows,
                onNodeSelected: function(event, node) {
                    table.ajax.url( 'selectSubMenu.do?parentId='+node.id ).load();
                    $('#addMenu').removeAttr('disabled');
                    $('#rootMenuText').html(node.text);
                    $('#parentId').val(node.id);
                },
            });
        },'JSON');

        $('#saveMenu').click(function () {
            var bootstrapValidator = $("#menuForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(!bootstrapValidator.isValid())return ;
            $.post('addMenu.do', $('#menuForm').serialize(), function(result) {
                if(result.state==0){
                    $('#memuModal').modal("hide");
                    noty({
                        text: '提示 - 操作成功!',
                    });
                }
            }, 'json');
        });
        
        table = $('#menuInfo').DataTable({
            dom: "Bfrtip",
//            "ajax":"selelctMenu.do",//ajax请求后台JSON数据
            "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
            "sPaginationType": "bootstrap",
            "scrollX": true,//水平滚动
            "columnDefs": [
                {
                    orderable: false,
                    visible:false,
                    targets: 0
                },
                {
                    orderable: false,
                    searchable: false,
                    targets: 1
                },
                {
                    orderable: false,
                    targets: 6
                }
            ],
            "columns": [
                { "data": "id" },
                { "data": null },
                { "data": "text" },
                { "data": "href" },
                { "data": "icon" },
                { "data": "sort" },
                {   "data":"",
                    render:function (data, type, row) {
                        return '<a class="btn btn-success" id="select">'+
                                '<i class="glyphicon glyphicon-zoom-in icon-white"></i>'+
                                ' 查询'+
                                ' </a>'+
                                '<a class="btn btn-info" id="edit">'+
                                '<i class="glyphicon glyphicon-edit icon-white"></i>'+
                                ' 修改'+
                                ' </a>'+
                                '<a class="btn btn-danger" id="del">'+
                                '<i class="glyphicon glyphicon-trash icon-white"></i>'+
                                ' 删除'+
                                ' </a>'
                    }
                },
            ],
            oLanguage: {  //对表格国际化
                sUrl:"language.json",
                decimal: ",",
            },
        });

        $('#addMenu').click(function () {
            $('#memuModal').modal('show');
        });

        rootFormValidator();
        formValidator();
        $('#expandAll').click(function () {
            $('#tree').treeview('expandAll', { levels: 2, silent: true });
        });
        $('#collapseAll').click(function () {
            $('#tree').treeview('collapseAll', { silent: true });
        });
        $('#addRoot').click(function () {
            $('#rootMenuForm')[0].reset();//清空表单
            $('#myModal').modal('show');
        });
        $('#save').click(function () {
            var bootstrapValidator = $("#rootMenuForm").data('bootstrapValidator');
            bootstrapValidator.validate();
            if(!bootstrapValidator.isValid())return ;
            $.post('addRootMenu.do', $('#rootMenuForm').serialize(), function(result) {
                if(result.state==0){
                    $('#myModal').modal("hide");
                    noty({
                        text: '提示 - 操作成功!',
                    });
                }
            }, 'json');
        });
        $('#myModal').on('hidden.bs.modal', function() {
            $("#rootMenuForm").data('bootstrapValidator').resetForm();
            rootFormValidator();
        });
        table.on( 'order.dt search.dt', function () {
            table.column(1, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                cell.innerHTML = i+1;
            } );
        } ).draw()

        function formValidator(){
            $('#menuForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    text: {
                        message: '菜单名不能为空',
                        validators: {
                            notEmpty: {
                                message: '菜单名不能为空'
                            },
                            stringLength: {
                                min: 4,
                                max: 30,
                                message: '长度为4-30位'
                            },
                        }
                    },
                    href: {
                        validators: {
                            notEmpty: {
                                message: '菜单路径不能为空'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z.#]+$/,
                                message: '请输入正确的路径'
                            },
                        }
                    },
                }
            });
        }
        function  rootFormValidator() {
            $('#rootMenuForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    text: {
                        message: '菜单名不能为空',
                        validators: {
                            notEmpty: {
                                message: '菜单名不能为空'
                            },
                            stringLength: {
                                min: 4,
                                max: 30,
                                message: '长度为4-30位'
                            },
                        }
                    },
                    href: {
                        validators: {
                            notEmpty: {
                                message: '菜单路径不能为空'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z.#]+$/,
                                message: '请输入正确的路径'
                            },
                        }
                    },
                }
            });
        }

    });
    
</script>
</body>
</html>

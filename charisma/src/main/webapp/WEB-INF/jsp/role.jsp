<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/9/1
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>角色管理</title>
    <jsp:include page="top.jsp"/>
    <style>
        #addRole{
            position: absolute;
            left: 168px;
            top: 38px;
            z-index: 100;
        }
        #assignedUser{
            position: absolute;
            left: 248px;
            top: 38px;
            z-index: 100;
        }
        #assignedPermission{
            position: absolute;
            left: 355px;
            top: 38px;
            z-index: 100;
        }
        @media  screen and (max-width: 639px){
            #addRole ,#assignedUser,#assignedPermission{
                position: static;
                display: block;
                margin: 5px auto;

            }
        }
    </style>
    <link rel="stylesheet" href="<%=basePath%>static/css/select.dataTables.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="ch-container">
    <div class="row">

        <jsp:include page="navbar.jsp"/>

        <div id="content" class="col-lg-10 col-sm-10">
            <!-- content starts -->
            <div>
                <ul class="breadcrumb">
                    <li>
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">角色管理</a>
                    </li>
                </ul>
            </div>

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-user"></i> 角色管理</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <a class="btn btn-primary btn-position-table" id="addRole" type="button"><i class="glyphicon glyphicon-plus icon-white"></i> 添加</a>
                            <a class="btn btn-info btn-position-table" id="assignedUser" type="button"><i class="glyphicon glyphicon-user icon-white"></i> 分配人员</a>
                            <a class="btn btn-success btn-position-table" id="assignedPermission" type="button"><i class="glyphicon glyphicon-stats icon-white"></i> 分配权限</a>
                            <table id="roleInfo" class="table table-striped table-bordered bootstrap-datatable datatable responsive" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>角色名</th>
                                    <th>角色编码</th>
                                    <th>角色描述</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>角色名</th>
                                    <th>角色编码</th>
                                    <th>角色描述</th>
                                    <th>操作</th>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
                <!--/span-->

            </div><!--/row-->

            <div class="row">
                <div class="box col-md-12">
                    <div class="box-inner">
                        <div class="box-header well" data-original-title="">
                            <h2><i class="glyphicon glyphicon-user"></i> 用户角色</h2>

                            <div class="box-icon">
                                <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
                                <a href="#" class="btn btn-minimize btn-round btn-default"><i
                                        class="glyphicon glyphicon-chevron-up"></i></a>
                                <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <table id="userTable" class="table table-striped table-bordered bootstrap-datatable datatable responsive" cellspacing="0" width="100%">
                                <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>用户名</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>QQ</th>
                                    <th>邮箱</th>
                                    <th>类别</th>
                                    <th>状态</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>用户名</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>QQ</th>
                                    <th>邮箱</th>
                                    <th>类别</th>
                                    <th>状态</th>
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

    <div class="modal fade" id="roleModal" tabindex="-1" role="dialog" aria-labelledby="roleModal" data-backdrop="static"
         aria-hidden="true">

        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3 id="role-title">添加角色</h3>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" id="roleForm">
                        <input type="hidden" id="roleId" name="id">
                        <div class="form-group">
                            <label for="roleName" class="col-sm-2 control-label">角色名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="roleName" id="roleName" placeholder="角色名" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="roleCode" class="col-sm-2 control-label">角色编码</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="roleCode" id="roleCode" placeholder="角色编码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label  for="roleDes" class="col-sm-2 control-label">角色描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="roleDes" id="roleDes" placeholder="角色描述">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" id="saveRole">保存</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="assignedUserModal" tabindex="-1" role="dialog" aria-labelledby="assignedUserModal" data-backdrop="static"
         aria-hidden="true">

        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3 id="assigned-user-title">人员分配</h3>
                </div>
                <div class="modal-body">
                    <table id="userInfo" class="table table-striped table-bordered bootstrap-datatable datatable responsive" cellspacing="0" width="100%">
                        <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>邮箱</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th></th>
                            <th></th>
                            <th>用户名</th>
                            <th>姓名</th>
                            <th>邮箱</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" id="saveassignedUser">保存</a>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="assignedPermissionModal" tabindex="-1" role="dialog" aria-labelledby="assignedPermissionModal" data-backdrop="static"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3 id="assigned-permission-title">权限分配</h3>
                </div>
                <div class="modal-body">
                    <div id="permissionTree"></div>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">关闭</a>
                    <a href="#" class="btn btn-primary" id="saveassignedPermission">保存</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>

</div><!--/.fluid-container-->

<jsp:include page="down.jsp"/>
<script src="<%=basePath%>static/js/dataTables.select.min.js"></script>
<script type="text/javascript">
    var roleTable;
    var userTable;
    var roleUrl;
    var roleData;
//    var userData;
    $(function () {

        roleFormValidator();
        roleTable=$('#roleInfo').DataTable({
            dom: "Bfrtip",
            "ajax":"selectRole.do",//ajax请求后台JSON数据
            "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
            "sPaginationType": "bootstrap",
            "sAjaxDataProp":"content.rows",
            "columnDefs": [
                {
                    orderable: false,
                    visible:true,
                    className: 'select-checkbox',
                    targets: 0
                },
                {
                    orderable: false,
                    visible:false,
                    searchable: false,
                    targets: 1
                },
                {
                    orderable: false,
                    targets: 5
                }
            ],
            select: {
                style:    'os',
                selector: 'td:first-child'
            },
            "columns": [
                { "data": "" ,render:function(){return ""} },
                { "data": "id" },
                { "data": "roleName" },
                { "data": "roleCode" },
                { "data": "roleDes" },
                {   "data":"",
                    render:function (data, type, row) {
                        return '<a class="btn btn-success" id="selectRole">'+
                                '<i class="glyphicon glyphicon-zoom-in icon-white"></i>'+
                                ' 查询 '+
                                ' </a>&nbsp;'+
                                '<a class="btn btn-info" id="editRole">'+
                                '<i class="glyphicon glyphicon-edit icon-white"></i>'+
                                ' 修改 '+
                                ' </a>&nbsp;'+
                                '<a class="btn btn-danger" id="delRole">'+
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
        table = $('#userTable').DataTable({
            dom: "Bfrtip",
            "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
            "sPaginationType": "bootstrap",
            "sAjaxDataProp":"content.rows",
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
                }
            ],
            "columns": [
                { "data": "id" },
                { "data": null },
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
                        if(data){return "一般用户"}else{return "系统用户"}
                    }
                },
                { "data": "status" ,
                    render:function (data, type, row) {
                        if(data=="DISABLE"){
                            return '<span class="label-default label label-danger">失效</span>';
                        }else{
                            return '<span class="label-success label label-default">有效</span>';
                        }
                    }
                }
            ],
            oLanguage: {  //对表格国际化
                sUrl:"language.json",
                decimal: ",",
            },
        });
        table.on( 'order.dt search.dt', function () {
            table.column(1, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
                cell.innerHTML = i+1;
            } );
        } ).draw();
        userTable=$('#userInfo').DataTable({
            dom: "Bfrtip",
            "ajax":"selectUserNoRole.do",//ajax请求后台JSON数据
            "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
            "sPaginationType": "bootstrap",
            "sAjaxDataProp":"content.rows",
            "columnDefs": [
                {
                    orderable: false,
                    visible:true,
                    className: 'select-checkbox',
                    targets: 0
                },
                {
                    orderable: false,
                    visible:false,
                    searchable: false,
                    targets: 1
                }
            ],
            select: {
                style:    'multi',
                selector: 'td:first-child',
                rows: {
                    _: "您选中了 %d 条",
                    0: "单击一行以选择它",
                    1: "只能选择一条"
                }
            },
            "columns": [
                { "data": "" ,render:function(){return ""} },
                { "data": "id" },
                { "data": "userName" },
                { "data": "name" },
                { "data": "email" },
            ],
            oLanguage: {  //对表格国际化
                sUrl:"language.json",
                decimal: ",",
            },
        });
        roleTable.on( 'select', function ( e, dt, type, indexes ) {
            roleData = roleTable.rows( indexes ).data().toArray()[0];
            table.ajax.url( 'selectUserByRoleId.do?roleCode='+roleData.roleCode ).load();
        } ) .on( 'deselect', function ( e, dt, type, indexes ) {
            roleData = null;
        } );
//        userTable.on( 'select', function ( e, dt, type, indexes ) {
//            userData = userTable.rows( indexes ).data().toArray();
//        } ).on( 'deselect', function ( e, dt, type, indexes ) {
//            userData = null;
//        } );
        $('#saveassignedUser').click(function () {
            var userIds="";
            var userData=userTable.rows('.selected').data();
            if (!userData){
                noty({
                    text: '提示 - 请先选择人员!',
                });
                return;
            }
            for(var x in userData){
                if(userData[x].id){
                    userIds +=userData[x].id+",";
                }
            }
            $.post('insertRoleCode.do',{userIds:userIds,roleCode:roleData.roleCode},function (result) {
                if(result.state==0){
                    $('#assignedUserModal').modal("hide");
                    userTable.ajax.reload();
                    noty({
                        text: '提示 - 操作成功!',
                    });

                }
            },'json');
        });
        /*分配人员*/
        $('#assignedUser').click(function () {
            if(!roleData){
                noty({
                    text: '提示 - 请先选择角色!',
                });
                return;
            }
            userTable.ajax.reload();
            $('#assignedUserModal').modal('show');
        });

        /*权限分配*/
        $('#assignedPermission').click(function () {
            if(!roleData){
                noty({
                    text: '提示 - 请先选择角色!',
                });
                return;
            }
            $.post('selelctPermissionByRoleId.do',{roleId:roleData.id},function (result) {

                 $('#permissionTree').treeview({
                    data: result.content.rows,
                    showCheckbox: true,
                     onNodeChecked:function(event, node) {
                         if(node.parentId==0) {
                             $('#permissionTree').treeview('checkNode', [$('#permissionTree').treeview('getParent', node), {silent: true}]);
                         }else if(node.parentId ==undefined){

                         }else{
                             $('#permissionTree').treeview('checkNode', [$('#permissionTree').treeview('getParent', node), {silent: true}]);
                             $('#permissionTree').treeview('checkNode', [$('#permissionTree').treeview('getParent', $('#permissionTree').treeview('getParent', node)), {silent: true}]);
                         }
//                         if(!node.parentId){
//                             var siblings = $('#permissionTree').treeview('getSiblings', node.id);
//                             console.log(siblings);
//                             for(var i =0;i < siblings.length;i++){
//                                 $('#permissionTree').treeview('checkNode', [ siblings[i], { silent: true } ]);
//                             }
//                         }
                     }

                 });
                $('#assignedPermissionModal').modal('show');
            },'JSON');
        });
        /*保存权限分配*/
        $('#saveassignedPermission').click(function () {
             var treeArray = $('#permissionTree').treeview('getChecked');
            var menuId = "";
            var permissionId="";
             for(var x in treeArray){
                 if(!treeArray[x].parentId ){
                     menuId+=treeArray[x].id+",";
                 }else{
                     permissionId +=treeArray[x].id+",";
                 }
             }
            if(!menuId){
                noty({
                    text: '提示 - 请先勾选菜单!',
                });
                return ;
            }
            $.post('addRoleAndPermission.do',{roleId:roleData.id,menuId:menuId,permissionId:permissionId},function (result) {
                if(result.state==0){
                    $('#assignedPermissionModal').modal("hide");
                    noty({
                        text: '提示 - 操作成功!',
                    });
                }
            },'JSON');
        });

        /* 查看角色*/
        $('#roleInfo tbody').on( 'click', 'a#selectRole', function () {
            var data = $('#roleInfo').DataTable().row($(this).parents('tr')).data();
            roleFormReading(data,"查询菜单");
            $("#roleForm  :input").attr("disabled",true);
            $('#saveRole').attr("disabled",true);
        });
        /*添加角色*/
        $('#addRole').on( 'click', function () {
            roleUrl='insertRole.do';
            $("#roleForm  :input").attr("disabled",false);
            $('#roleId').val('');
            roleFormReading(null,"添加角色");
        } );
        /*修改角色*/
        $('#roleInfo tbody').on( 'click', 'a#editRole', function () {
            !$("#roleForm  :input").attr("disabled",false);
            $('#saveRole').attr("disabled",false);
            roleUrl='updateRole.do';
            var data = $('#roleInfo').DataTable().row($(this).parents('tr')).data();
            roleFormReading(data,"修改角色");
        } );
        /*保存角色*/
        $('#saveRole').click(function() {
            var roleValidator = $("#roleForm").data('bootstrapValidator');
            roleValidator.validate();
            if(!roleValidator.isValid())return ;
            $.post(roleUrl, $('#roleForm').serialize(), function(result) {
                if(result.state==0){
                    $('#roleModal').modal("hide");
                    roleTable.ajax.reload();
                    noty({
                        text: '提示 - 操作成功!',
                    });
                }
            }, 'json');
        });
        $('#roleInfo tbody').on( 'click', 'a#delRole', function () {
            var data = $('#roleInfo').DataTable().row($(this).parents('tr')).data();
            Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
                if (!e) return;
                $.post('deleteRole.do', {id:data.id}, function(result) {
                    if(result.state==0){
                        noty({
                            text: '提示 - 删除成功!',
                        });
                        roleTable.ajax.reload();
                    }else {
                        noty({
                            text: '提示 - 删除失败!',
                        });
                    }
                }, 'json');
            });

        });
        /*重置角色表单*/
        function roleFormReading(data,title) {
            $('#roleForm')[0].reset();//清空表单
            $('#role-title').html(title);//设置标题
            if(data){
                $('#roleId').val(data.id);
                $('#roleName').val(data.roleName);
                $('#roleCode').val(data.roleCode);
                $('#roleDes').val(data.roleDes);
            }
            $('#roleModal').modal("show"); //模态框显示
        }
        /*角色对话框隐藏清空表单验证*/
        $('#roleModal').on('hidden.bs.modal', function() {
            $("#roleForm").data('bootstrapValidator').resetForm();
            roleFormValidator();
        });
//        /*分配人员对话框隐藏清空roleData*/
//        $('#assignedUserModal').on('hidden.bs.modal', function() {
//            roleData=null;
//        });
        /*表单验证*/
        function roleFormValidator(){
            $('#roleForm').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    roleName: {
                        message: '角色名不能为空',
                        validators: {
                            notEmpty: {
                                message: '角色名不能为空'
                            },
                            /*remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                                url: 'existUserName.do',//验证地址
                                message: '用户已存在',//提示消息
                                delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                                type: 'POST',//请求方式
                                /!* data: function(validator) {//自定义提交数据，默认值提交当前input value
                                 return {
                                 id: $('#id').val(),
                                 };
                                 }*!/
                            },*/
                        }
                    },
                    roleCode: {
                        validators: {
                            notEmpty: {
                                message: '角色编码不能为空'
                            }
                        }
                    },
                    roleDes: {
                        validators: {
                            notEmpty: {
                                message: '角色描述不能为空'
                            }
                        }
                    },
                }
            });
        }
    });
    
</script>

</body>
</html>

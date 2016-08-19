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

        <!-- left menu starts -->
        <div class="col-sm-2 col-lg-2">
            <div class="sidebar-nav">
                <div class="nav-canvas">
                    <div class="nav-sm nav nav-stacked">

                    </div>
                    <ul class="nav nav-pills nav-stacked main-menu">
                        <li class="nav-header">Main</li>
                        <li><a class="ajax-link" href="index.html"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                        </li>
                        <li><a class="ajax-link" href="ui.html"><i class="glyphicon glyphicon-eye-open"></i><span> UI Features</span></a>
                        </li>
                        <li><a class="ajax-link" href="form.html"><i
                                class="glyphicon glyphicon-edit"></i><span> Forms</span></a></li>
                        <li><a class="ajax-link" href="chart.html"><i class="glyphicon glyphicon-list-alt"></i><span> Charts</span></a>
                        </li>
                        <li><a class="ajax-link" href="typography.html"><i class="glyphicon glyphicon-font"></i><span> Typography</span></a>
                        </li>
                        <li><a class="ajax-link" href="gallery.html"><i class="glyphicon glyphicon-picture"></i><span> Gallery</span></a>
                        </li>
                        <li class="nav-header hidden-md">Sample Section</li>
                        <li><a class="ajax-link" href="table.html"><i
                                class="glyphicon glyphicon-align-justify"></i><span> Tables</span></a></li>
                        <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> Accordion Menu</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">Child Menu 1</a></li>
                                <li><a href="#">Child Menu 2</a></li>
                            </ul>
                        </li>
                        <li><a class="ajax-link" href="calendar.html"><i class="glyphicon glyphicon-calendar"></i><span> Calendar</span></a>
                        </li>
                        <li><a class="ajax-link" href="grid.html"><i
                                class="glyphicon glyphicon-th"></i><span> Grid</span></a></li>
                        <li><a href="tour.html"><i class="glyphicon glyphicon-globe"></i><span> Tour</span></a></li>
                        <li><a class="ajax-link" href="icon.html"><i
                                class="glyphicon glyphicon-star"></i><span> Icons</span></a></li>
                        <li><a href="error.html"><i class="glyphicon glyphicon-ban-circle"></i><span> Error Page</span></a>
                        </li>
                        <li><a href="login.html"><i class="glyphicon glyphicon-lock"></i><span> Login Page</span></a>
                        </li>
                    </ul>
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div>
        <!--/span-->
        <!-- left menu ends -->

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
                            <table id="userInfo" class="display" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
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

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">

        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary" data-dismiss="modal">Save changes</a>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"/>

</div><!--/.fluid-container-->

<jsp:include page="down.jsp"/>

<script>
    var editor;

    $(document).ready(function () {

        editor = new $.fn.dataTable.Editor( {
            "ajax":"selectUserInfo.do",
            "table": "#userInfo",
            "idSrc": "uid",
            "fields": [ {
                label: "用户名:",
                name: "userName",
            }, {
                label: "姓名:",
                name: "name",
            }, {
                label: "性别",
                name: "gender",
            }, {
                label: "QQ:",
                name: "qq",
            }, {
                label: "邮箱：",
                name: "email",
            }, {
                label: "类别：",
                name: "type",
                type: "datetime"
            }
            ],
            i18n: {
                create: {
                    button: "新增",
                    title:  "创建用户",
                    submit: "新增"
                },
                edit: {
                    button: "修改",
                    title:  "修改用户",
                    submit: "修改"
                },
                remove: {
                    button: "删除",
                    title:  "删除用户",
                    submit: "删除",
                    confirm: {
                        _: "你确定要删除这%d条数据吗?",
                        1: "您确定要删除这条数据吗?"
                    }
                },
                error: {
                    system: "操作失败，请与系统管理员"
                },
                multi: {
                    title: "Plusieurs valeurs",
                    info: "Les éléments sélectionnés contiennent des valeurs différentes pour cette entrée. Pour modifier et mettre tous les éléments pour cette entrée pour la même valeur, cliquez ou appuyez ici, sinon ils vont conserver leurs valeurs individuelles.",
                    restore: "取消更改"
                },
                datetime: {
                    previous: '<——',
                    next:     '——>',
                    months:   [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月' ],
                    weekdays: [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ]
                }
            }
        } );


        $('#userInfo').DataTable({
            dom: "Bfrtip",
//            "pagingType": "full_numbers",//首页 末页
            "ajax":"selectUserInfo.do",//ajax请求后台JSON数据
//             "sDom": "<'row'<'col-md-6'l><'col-md-6'f>r>t<'row'<'col-md-12'i><'col-md-12 center-block'p>>",
//             "sPaginationType": "bootstrap",
            "columns": [
                { "data": "userName" },
                { "data": "name" },
                { "data": "gender" ,
                    render:function (data, type, row) {
                        if(data.type){return "女"}else{return "男"}
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
                        if(data.status){return "无效"}else{return "有效"}
                    }
                },
            ],
            "select": true,
            "buttons": [
                { extend: "create", editor: editor },
                { extend: "edit",   editor: editor },
                { extend: "remove", editor: editor },
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


    });
</script>
</body>
</html>

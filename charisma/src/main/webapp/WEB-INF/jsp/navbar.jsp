<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- left menu starts -->
<div class="col-sm-2 col-lg-2" id="menuList">
    <div class="sidebar-nav">
        <div class="nav-canvas">
            <div class="nav-sm nav nav-stacked">

            </div>
            <ul class="nav nav-pills nav-stacked main-menu">
                <li class="nav-header">Main</li>
                <li><a class="ajax-link" href="index.jsp"><i class="glyphicon glyphicon-home"></i><span>首页</span></a>
                </li>
                <li class="accordion">
                    <a href="#"><i class="glyphicon glyphicon-list"></i><span> 系统管理</span></a>
                    <ul class="nav nav-pills nav-stacked">
                        <li><a href="user.htm">用户管理</a></li>
                        <li><a href="menu.htm">菜单管理</a></li>
                        <li><a href="role.htm">角色管理</a></li>
                    </ul>
                </li>
            </ul>
            <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
        </div>
    </div>
</div>
<script>
    $(function () {
        $.post('showMenu.do',{},function (result) {
            console.log(result);
        },'json');
    });
</script>
<!--/span-->
<!-- left menu ends -->
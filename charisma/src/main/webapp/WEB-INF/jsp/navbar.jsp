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
            </ul>
            <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
        </div>
    </div>
</div>
<script>
        $.ajax({
                url:'showMenu.do',
                type:'post',
                async:false,
                dataType:'json',
                success: function (result) {
                var obj = result.content.rows;
                $.each(obj,function (i,value) {
                    if(obj[i].parentId == 0){
                        $('ul.main-menu').append(

                                '<li class="accordion">'+
                                '<a href="#"><i class="'+obj[i].icon+'"></i><span> '+obj[i].text+'</span></a>'+
                                '  <ul class="nav nav-pills nav-stacked"  id="parent'+obj[i].id+'">'+
                                '  </ul>'+
                                '</li>'

                        );
                    }else{
                        $('#parent'+obj[i].parentId).append(
                                '<li><a href="'+obj[i].href+'">'+obj[i].text+'</a></li>'
                        );

                    }
                })
        }
        });


</script>
<!--/span-->
<!-- left menu ends -->
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
<meta name="author" content="Muhammad Usman">

<!-- The styles -->
<link id="bs-css" href="<%=basePath%>static/css/bootstrap-cerulean.min.css" rel="stylesheet">

<link href="<%=basePath%>static/css/charisma-app.css" rel="stylesheet">
<link href='<%=basePath%>static/bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
<link href='<%=basePath%>static/bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='<%=basePath%>static/bower_components/chosen/chosen.min.css' rel='stylesheet'>
<link href='<%=basePath%>static/bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
<link href='<%=basePath%>static/bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
<link href='<%=basePath%>static/bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/uploadify.css' rel='stylesheet'>
<link href='<%=basePath%>static/css/animate.min.css' rel='stylesheet'>


<!-- jQuery -->
<script src="<%=basePath%>static/bower_components/jquery/jquery.min.js"></script>
<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<!-- The fav icon -->
<link rel="shortcut icon" href="<%=basePath%>static/img/favicon.ico">

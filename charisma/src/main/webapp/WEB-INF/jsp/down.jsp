<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- external javascript -->

<script src="<%=basePath%>static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="<%=basePath%>static/js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='<%=basePath%>static/bower_components/moment/min/moment.min.js'></script>
<script src='<%=basePath%>static/bower_components/fullcalendar/dist/fullcalendar.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="<%=basePath%>static/bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="<%=basePath%>static/bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="<%=basePath%>static/js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="<%=basePath%>static/bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="<%=basePath%>static/bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="<%=basePath%>static/js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="<%=basePath%>static/js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="<%=basePath%>static/js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="<%=basePath%>static/js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="<%=basePath%>static/js/jquery.history.js"></script>
<!-- data table plugin -->
<script src='<%=basePath%>static/js/jquery.dataTables.min.js'></script>
<!-- application script for Charisma demo -->
<script src="<%=basePath%>static/js/charisma.js"></script>
<!-- BootstrapValidator plugin-->
<script src="<%=basePath%>static/js/bootstrapValidator.min.js"></script>
<!-- Bootstrap-Prompt-->
<script src="<%=basePath%>static/js/bootstrap-prompt.js"></script>


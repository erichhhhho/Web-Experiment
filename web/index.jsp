<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";pageContext.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html>
<head>
  <meta content="text/html; charset=UTF-8" http-equiv="content-type">
  <title>Eric's Page</title>
<link rel="stylesheet" type="text/css" href="/css/1.css">
  <meta name="keywords" content="Eric,CS,ComputerScience">
</head>
<body>
<div id="Layer1" style="position:absolute; width:100%; height:100%; z-index:-1">
  <img src="images/indexbg.jpg" height="100%" width="100%" style="position:fixed"/>
</div>

<script type="text/javascript">function rec() {
    alert("Hello welcome to My Page!!")
}</script>
<div class="">
  <img class="logo" src="/images/logoTransparent.png">
</div>

<p>This is Eric's Dorm!!!.</p>

<table align="center"><tr align="center">
  <caption><h1>实验内容如下</h1></caption>
  <tr>
  <td><a href=2.html>My profile</a></td>

<td><a href=upload.html>&nbsp;实验三、实验四&nbsp;</a></td>
<td><a href="upload.html">&nbsp;实验五&nbsp;</a></td>

<td><a href="Login.html">&nbsp;实验六&nbsp;</a></td>
<td><a href="Login2.html">&nbsp;实验七&nbsp;</a></td>
<td><a href="msgadd.jsp">&nbsp;实验八&nbsp;</a></td>
  <td><a href="msgshow.jsp">&nbsp;展示留言板&nbsp;</a></td>

</tr>
</table>
<center>
<table border="2" width="800" height="600" valign="center" align="middle"  >
  <caption>宿舍结构</caption>
  <tbody>
  <tr>
    <th>NAME</th>
    <th>Pics</th>
    <th>Number</th>
  </tr>
  <tr>
    <td>Eric ho</td>
    <td><img src=images/gongzhang.jpg usemap="#map">
    <map name="Map">
      <area shape="rect" coords="2,9,149,40" href="table.html"></map></td>
    <td>110&nbsp;</td>
  </tr>
  <tr>
    <td>Liam Liang</td>
    <td><img src="images/timg (1).jpg" width="325px" height="225px"></td>
    <td>13</td>
  </tr>
  <tr>
    <td>Zhenfu Cai</td>
    <td><img src="./images/timg.jpg" width="325px" height="225px"></td>

    <td>3</td>
  </tr>
  </tbody>
</table>


</center>
</body>
</html>

<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>æ æ é¢ææ¡£</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

	<div class="place">
    <span>ä½ç½®ï¼</span>
    <ul class="placeul">
    <li><a href="#">é¦é¡µ</a></li>
    <li><a href="#">æµç¨å¾</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
   
   <div class="formtitle1"><span>æµç¨å¾</span></div>
   
   
   <ul class="flow">
   <li><span><img src="images/lc01.png"  alt="1111" /></span><a href="#">ç«é¡¹ä¿¡æ¯ç»è®°</a><i>(21)</i><div class="flowjt"></div></li>   
   <li><span><img src="images/lc02.png"  alt="1111" /></span><a href="#">å­¦é¢å®¡æ ¸</a><i>(3)</i><div class="flowjt"></div></li>   
   <li><span><img src="images/lc03.png"  alt="1111" /></span><a href="#">ç§ç å¤å®¡æ ¸</a><i>(0)</i><div class="flowjt"></div></li>
   <li><span><img src="images/lc04.png"  alt="1111" /></span><a href="#">è¿ç¨ä¿¡æ¯å¡«æ¥</a><i>(3)</i><div class="flowjt"></div></li>
   <li><span><img src="images/lc05.png"  alt="1111" /></span><a href="#">éªæ¶ä¿¡æ¯å¡«æ¥</a><i>(2)</i><div class="flowjt"></div></li>
   <li><span><img src="images/lc06.png"  alt="1111" /></span><a href="#">é¡¹ç®ç»é¡¹</a><i>(1)</i></li>
   </ul>
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>

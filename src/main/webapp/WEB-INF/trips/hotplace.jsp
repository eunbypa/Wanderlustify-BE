<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
 <div>
   <h3 class = "mt-3" id = "tripSearchTitle">핫플레이스</h3>
   <hr>
 </div>

 <div id="hotplace">
  
 </div>

 <div class="map-container">
   <div id="map"></div>
 </div>
<%-- <script src="/js/mytrip.js"></script> --%>
<script src="/js/hotplace.js"></script>

 <%@ include file="../common/footer.jsp" %>
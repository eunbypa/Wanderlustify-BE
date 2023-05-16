<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<%@ include file="../common/confirm.jsp" %>
 <div>
   <h3 class = "mt-3" id = "tripSearchTitle">나의 여행 계획</h3>
   <hr>
 </div>

 <div class="map-container">
   <div id="map"></div>
 </div>
<script src="/js/mytrip.js"></script>

 <%@ include file="../common/footer.jsp" %>
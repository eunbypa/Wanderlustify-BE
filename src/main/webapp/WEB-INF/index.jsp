<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" id ="main">
<%@ include file="./common/header.jsp" %>
<%@ include file="./common/nav.jsp" %>
	<c:if test="${login eq true}"><script>alert('로그인 완료되었습니다.');</script></c:if>
	<c:if test="${login eq false}"><script>alert('로그인 실패했습니다.');</script></c:if>
<%@ include file="./common/footer.jsp" %>
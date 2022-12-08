<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Warm News</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>
</head>

<body>
<div id="page">
    <h1 id="header"><a href="#">Warm News</a></h1>
    <div id="right">
        <div class="article">

            <form:form action="saveArticle" modelAttribute="article">

                <form:hidden path="id"/>

                <c:url var="deleteButton" value="/deleteArticle">
                    <c:param name="artId" value="${article.id}"/>
                </c:url>

                <p><label for="Title">Title</label></p>
                <form:errors path="title" cssClass="error"/>
                <form:textarea path="title" rows="4" cols="50"/>
                <br/>

                <p><label for="Brief">Brief</label></p>
                <form:errors path="brief" cssClass="error"/>
                <form:textarea path="brief" rows="8" cols="50"/>
                <br/>

                <p><label for="Content">Content</label></p>
                <form:errors path="content" cssClass="error"/>
                <form:textarea path="content" rows="16" cols="50"/>
                <br/>

                <div class="text">

                    <p>
                        <input type="submit" value="Update">
                    <p/>
                    <p>
                        <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>
                    </p>

                </div>
            </form:form>
        </div>
    </div>
    <div id="left">
        <ul id="rss">
            <li><a href="/warmnews">News List</a></li>
            <li><a href="/warmnews/addArticle">Add News</a></li>
        </ul>
    </div>

    <p class="footer"> In faucibus elementum augue. Nam dapibus, nisi a vehicula </p>
</div>
</body>
</html>


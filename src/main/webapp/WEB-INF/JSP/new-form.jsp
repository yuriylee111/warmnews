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

                <p><label for="Title">Title</label></p>
                <textarea id="Title" name="Title" rows="4" cols="50"></textarea>
                <br/>

                <p><label for="Brief">Brief</label></p>
                <textarea id="Brief" name="Brief" rows="8" cols="50"></textarea>
                <br/>

                <p><label for="Content">Content</label></p>
                <textarea id="Content" name="Content" rows="16" cols="50"></textarea>
                <br/>

                <p><input type="submit" value="OK"></p>

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


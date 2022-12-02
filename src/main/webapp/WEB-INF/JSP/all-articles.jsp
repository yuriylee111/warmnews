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

            <c:forEach var="art" items="${allArticles}">

                <c:url var="viewButton" value="/getArticle">
                    <c:param name="artId" value="${art.id}"/>
                </c:url>

                <c:url var="updateButton" value="/getArticle">
                    <c:param name="artId" value="${art.id}"/>
                </c:url>

                <c:url var="deleteButton" value="/deleteArticle">
                    <c:param name="artId" value="${art.id}"/>
                </c:url>

                <div class="top">
                    <h2>${art.title}</h2>
                    <br/>

                    <td>created: <fmt:formatDate value="${art.created}" pattern="dd.MM.yyyy"/></td>

                    <td>/ updated: <fmt:formatDate value="${art.updated}" pattern="dd.MM.yyyy hh:mm"/></td>
                </div>

                <div class="text">
                    <p> ${art.brief} </p>
                    <p><a href='${viewButton}'>View Article...</a></p>
                    <br/><br/>
                </div>
            </c:forEach>
        </div>
    </div>
    <div id="left">
        <ul id="rss">
            <li><a href="/warmnews">News List</a></li>
            <li><a href="/warmnews/addArticle">Add Article</a></li>
            <br><br>
        </ul>
    </div>

    <p class="footer"> In faucibus elementum augue. Nam dapibus, nisi a vehicula </p>
</div>
</body>
</html>

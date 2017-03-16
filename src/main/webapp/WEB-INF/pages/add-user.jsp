<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<t:head title="Новый пользователь"/>
<body>
<div class="container">

    <h1>Новый пользователь</h1>

    <div class="row">
        <div class="col-sm-6">
            <div class="jumbotron">
                <form:form method="post" action="addUser" commandName="user" class="form-horizontal">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Имя</label>
                        <div class="col-sm-10">
                            <form:input path="name" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">Возраст</label>
                        <div class="col-sm-10">
                            <form:input path="age" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="isAdmin" class="col-sm-2 control-label">Админ?</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="isAdmin" value="yes"> Да
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isAdmin" value="no" checked> Нет
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="submit" value="Добавить" class="btn btn-primary btn-lg pull-right"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
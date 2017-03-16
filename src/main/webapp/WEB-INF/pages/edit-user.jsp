<%@ page language="java" contentType="text/html; charset=utf8"  pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<t:head title="Редактирование пользователя"/>
<body>


<div class="container">

    <h1>Редактирование пользователя</h1>

    <div class="row">
        <div class="col-sm-6">
            <div class="jumbotron">
                <form:form method="post" action="/editUser" commandName="userEdit" class="form-horizontal">
                    <input type="hidden" name="OldUserId" value="${userEdit.id}">

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
                                <input type="radio" name="isAdmin" value="yes" ${userEdit.admin ? 'checked' : ''}> Да
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isAdmin" value="no" ${userEdit.admin ? '' : 'checked'}> Нет
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="submit" value="Изменить" class="btn btn-primary btn-lg pull-right"/>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
</html>

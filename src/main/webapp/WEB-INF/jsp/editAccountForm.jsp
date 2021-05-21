<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form modelAttribute="accountForm" method="post" />
  <form:errors cssClass="error" /> <br><br>
  
  <table id="account">
    <tr>
      <td>
        <h3><font color="darkgreen">User Information</font></h3>
        <table class="n13">
          <tr>
            <td>User ID:</td>
            <td>
            <c:if test="${accountForm.newAccount}">
              <form:input path="account.username" htmlEscape="false"/>
              <B><form:errors path="account.username" cssClass="error" /></B>
            </c:if> 
            <c:if test="${!accountForm.newAccount}">
              <c:out value="${accountForm.account.username}" />
            </c:if>
            </td>
          </tr>
          <tr>
            <td>New password:</td>
            <td>
              <form:password path="account.password" /> 
              <B><form:errors path="account.password" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>Repeat password:</td>
            <td>
              <form:password path="repeatedPassword" /> 
              <B><form:errors path="repeatedPassword" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>alias:</td>
            <td>
              <form:password path="account.alias" /> 
              <B><form:errors path="account.alias" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>name:</td>
            <td>
              <form:password path="account.name" /> 
              <B><form:errors path="account.name" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>email:</td>
            <td>
              <form:password path="account.email" /> 
              <B><form:errors path="account.email" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>phone:</td>
            <td>
              <form:password path="account.phone" /> 
              <B><form:errors path="account.phone" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>zip:</td>
            <td>
              <form:password path="account.zip" /> 
              <B><form:errors path="account.zip" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>address1:</td>
            <td>
              <form:password path="account.address1" /> 
              <B><form:errors path="account.address1" cssClass="error" /></B></td>
          </tr>
          <tr>
            <td>address2:</td>
            <td>
              <form:password path="account.address2" /> 
              <B><form:errors path="account.address2" cssClass="error" /></B></td>
          </tr>
        </table> 
        
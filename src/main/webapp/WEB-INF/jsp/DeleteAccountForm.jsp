<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div align="center">
<form:form modelAttribute="accountForm" method="post" >
  <form:errors cssClass="error" /> <br><br>
  
  <table id="account">
    <tr>
      <td>
        <h3><font color="darkgreen">ȸ�� Ż��</font></h3>
        <table class="n13">
          <tr>
            <td>��й�ȣ�� �Է����ּ���</td>
            <td>
              <form:password path="account.password" /> 
              <B><form:errors path="account.password" cssClass="error" /></B></td>
          </tr>
          
         </table>
         
         <br />
         <button  type="submit" id="submit">ȸ��Ż��</button>
		 <button  type="button">���</button>
    </form:form>
        
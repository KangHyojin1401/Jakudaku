<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<HTML>
<HEAD>
<meta charset="UTF-8">
<TITLE>�Ǹų���</TITLE>
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
</style>
</HEAD>
<BODY>
${Account.name} ���� �Ǹų���<br><br>
<!-- ���ı�������
<table style="undefined;table-layout: fixed; width: 164px">
<colgroup>
<col style="width: 100px">
<col style="width: 100px">
<col style="width: 100px">
<col style="width: 100px">
<col style="width: 100px">
<col style="width: 100px">
</colgroup>
<thead>
  <tr>
    <th rowspan="2">��ȸ�Ⱓ</th>
    <th>����</th>
    <th>1����</th>
    <th>1����</th>
    <th>6����</th>
    <th>1��</th>
  </tr>
  <tr>
    <td colspan="5" align=center>��¥ ������ ��</td>
  </tr>
</thead>
</table> -->
<a name = "online" />
<h3>online ��ǰ �Ǹ� ���</h3>
<a href="#online">Funding ��ǰ �Ǹ� ��� ����</a>
<br><br>
<table>
	<tr>
		<td>��ȣ</td>
		<td>�����</td>
		<td>��ǰ��</td>
		<td>��ϳ�¥</td>
		<td>����</td>
	</tr>
	<c:forEach var="o" items="${onlineList}" varState="status" >
		<tr>
		<td>${status.index}</td>
		<td>${o.thumnail1}</td>
		<td onclick="location.href='/item/viewOnlineItem.do'"; style="cursor:pointer;" >${o.name}</td>
		<td>${o.uploadDate}</td>
		<td><button type="button"  onClick="location.href='/item/sellOnlineItem.do'">����</button></td>
		</tr>
	</c:forEach>
</table>
<br><br>
<a name = "funding" />
<h3>Funding ��ǰ �Ǹ� ���</h3>
<a href="#online">Online ��ǰ �Ǹ� ��� ����</a>
<br><br>
<table>
	<tr>
		<td>��ȣ</td>
		<td>�����</td>
		<td>��ǰ��</td>
		<td>��ϳ�¥</td>
		<td>����</td>
	</tr>
	<c:forEach var="f" items="${fundingList}" varState="status" >
		<tr>
		<td>${status.index}</td>
		<td>${f.thumnail1}</td>
		<td onclick="location.href='/item/viewOnlineItem.do'"; style="cursor:pointer;" >${f.name}</td>
		<td>${f.uploadDate}</td>
		<td><button type="button"  onClick="location.href='/item/sellOnlineItem.do'">����</button></td>
		</tr>
	</c:forEach>
</table>
</BODY>
</HTML>
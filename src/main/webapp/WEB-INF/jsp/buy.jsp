<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<HTML>
<HEAD>
<meta charset="UTF-8">
<TITLE>���ų���</TITLE>
<style>
  table {
    width: 100%;
    border: 1px solid #444444;
  }
</style>
</HEAD>
<BODY>
${Account.name} ���� ���ų���<br><br>
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
<br><br><br>

<h3>���� ���</h3>
<br><br>

<table>
	<c:forEach var="o" items="${lineItemMap}">
		<tr>
			<td>${o.key}</td>
			<td><button type="button"  onClick="location.href='/user/confirmOrder.do'">�󼼺���</button></td>
		</tr>
		<c:forEach var="i" items="${lineItemMap[order.key]}">
			<tr>
			<td>${i.value.item.thumnail1}</td>
			<td onclick="location.href='/item/viewOnlineItem.do'"; style="cursor:pointer;" >${i.value.itme.name}</td>
			<c:if test="${i.value.item.getClass().getSimpleName() eq Online}">
				<td>
				<c:if test="${not empty i.value.item.pcFile}">
					<a href="${orderList.lineItems.itemId.pcFile}" download><button>pc�� �ٿ�ε�</button></a>
				</c:if>
				<c:if test="${not empty i.value.item.tableFile}">
					<a href="${orderList.lineItems.itemId.tableFile}" download><button>�׺��� �ٿ�ε�</button></a>
				</c:if>	
				<c:if test="${not empty i.value.item.phoneFile}">
					<a href="${orderList.lineItems.itemId.phoneFile}" download><button>����Ͽ� �ٿ�ε�</button></a>
				</c:if>	
				</td>
			</c:if>
			</tr>
		</c:forEach>
	</c:forEach>
</table>

<!--

<table>
	<c:forEach var="o" items="${orderList}">
		<tr>
			<td>${o.orderDate}</td>
			<td><button type="button"  onClick="location.href='/user/confirmOrder.do'">�󼼺���</button></td>
		</tr>
		<c:forEach var="l" items="${orderList.lineItems}">
			<tr>
			<td>${l.itemId.thumnail1}</td>
			<td onclick="location.href='/item/viewOnlineItem.do'"; style="cursor:pointer;" >${l.itemId.name}</td>
			<td>
			<c:if test="${not empty orderList.lineItems.itemId.pcFile}">
				<a href="${orderList.lineItems.itemId.pcFile}" download><button>pc�� �ٿ�ε�</button></a>
			</c:if>
			<c:if test="${not empty orderList.lineItems.itemId.tableFile}">
				<a href="${orderList.lineItems.itemId.tableFile}" download><button>�׺��� �ٿ�ε�</button></a>
			</c:if>	
			<c:if test="${not empty orderList.lineItems.itemId.phoneFile}">
				<a href="${orderList.lineItems.itemId.phoneFile}" download><button>����Ͽ� �ٿ�ε�</button></a>
			</c:if>	
			</td>
			</tr>
		</c:forEach>
	</c:forEach>
</table>


<a name = "funding" />
<h3>Funding ��ǰ ���� ���</h3>
<a href="#online">Online ��ǰ ���� ��� ����</a>
<br><br>

<table>
	<c:forEach var="f" items="${fundorderList}">
		<tr>
		<td>${f.orderDate}</td>
		<td><button type="button"  onClick="location.href='/user/confirmOrder.do'">�󼼺���</button></td>
		</tr>
		<tr>
		<td>${f.lineItem.itemId.thumnail1}</td>
		<td onclick="location.href='/item/viewFundingItem.do'"; style="cursor:pointer;" >${f.name}</td>
		</tr>
	</c:forEach>
</table>

  -->
</BODY>
</HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>
<%@ include file="sidebar.jsp" %>
        <div class="col-7 base">
			<table style="width:1000px; align:center;">
			  <tr style="vertical-align:top">
			    <td style="text-align:center">
			      <h2>Shopping Cart</h2>
			      <form action='<c:url value="/order/newOrder.do?"/>' method="post">
			        <table style="width:100%;" id="cart">
			          <tr bgcolor="#cccccc">
			            <td style="text-align:center"><b>이미지</b></td>
						<td style="text-align:center"><b>상품</b></td>
			 			<td style="text-align:center"><b>판매가</b></td>
			 			<td style="text-align:center"><b>할인</b></td>
			 			<td style="text-align:center"><b>결제 금액</b></td>
			 			<td style="text-align:center">&nbsp;</td>
			          </tr>
			
			          <c:if test="${cart.numberOfItems == 0}">
			            <tr bgcolor="#EEEEEE">
			              <td style="text-align:center" colspan="6"><b>Your cart is empty.</b></td>
			            </tr>
			          </c:if>
			
			          <c:forEach var="cartItem" items="${cart.cartItemList.pageList}">
			            <tr bgcolor="#EEEEEE">
			              <td><a href='<c:url value="/item/viewOnlineItem.do">
			                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
			                  <img src="${cartItem.item.thumbnail1}}"/></a></td>
			              <td><b>
			                <a href='<c:url value="/item/viewOnlineItem.do">
			                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
			                  <c:out value="${cartItem.item.name}" /></a>
			                <br><br>옵션:
			                <c:if test="${cartitem.item.pcFile != ''}">PC </c:if>
			                <c:if test="${cartItem.item.tabletFile != ''}">TABLET </c:if>
			                <c:if test="${cartItem.item.phoneFile != ''}">PHONE </c:if>
			               </b></td>
			              <td style="text-align:center"><c:out value="${cartItem.item.price}" /></td>
			              <td style="text-align:center">
			              	<c:choose>
				              	<c:when test="cartItem.item.saleState == 0"> 	<!-- No Sale -->
				              		<c:set var="discountPrice" value="0" /></c:when>
				              	<c:when test="cartItem.item.saleState == 1">	<!-- Time Sale -->
				              		<c:set var="discountPrice" value="${cartItem.item.price} * 0.1" />
									Time Sale</c:when>
				              	<c:when test="cartItem.item.saleState == 2">	<!-- Battle Sale -->
				              		<c:set var="discountPrice" value="${cartItem.item.price} * 0.1" />
									Battle Sale</c:when></c:choose>
							<br>-<c:out value="${cartItem.item.discount}"/></td>
			              <td style="text-align:center"><c:out value="${cartItem.item.salePrice}" /></td>
			              <td style="text-align:center">
			                <button type="button" onclick="location.href='/order/newOrder.do?itemId=' + ${cartItem.item.itemId}">구매</button>
			                <br><button type="button" onclick="location.href='/user/removeItemFromCart.do?workingItemId=' + ${cartItem.item.itemId}">삭제</button></td>
			            </tr>
			          </c:forEach>
			          <tr bgcolor="#cccccc">
			          	<td colspan="3" align="left">
			          		<button type="button" onclick="location.href='/user/removeItemFromCart.do?">전체 삭제</button>
			          	</td>
			            <td colspan="3" align="right">
			            	<b>총 <c:out value="${cart.subTotal}" />원</b><br><br>
			            </td>
			          </tr>
			        </table>
			        
			        <div style="text-align:center">
			          <c:if test="${!cart.cartItemList.firstPage}">
			            <a href='<c:url value="viewCart.do?page=previousCart"/>'>
			              <font color="green"><B>&lt;&lt; Prev</B></font></a>
			          </c:if>
			          <c:if test="${!cart.cartItemList.lastPage}">
			            <a href='<c:url value="viewCart.do?page=nextCart"/>'>
			              <font color="green"><B>Next &gt;&gt;</B></font></a>
			          </c:if>
			        </div>
			        <c:if test="${cart.numberOfItems > 0}">
				      <br />
				      <div style="text-align:center">
			  			<input type="submit" value="구매하기" />
			        	<!-- <input type="image" src="" name="buy" /> -->
				      </div>
			        </c:if>
			      </form> 
			    </td>
			  </tr>
			</table>
		</div>
<%@ include file="bottom.jsp" %>
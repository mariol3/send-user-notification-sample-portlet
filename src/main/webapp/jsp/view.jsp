<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects/>

<portlet:actionURL name="sendUserNotification" var="sendUserNotificationURL">
</portlet:actionURL>

<aui:form name="sendUserNotificationFm" method="post" action="<%= sendUserNotificationURL %>">
	<aui:fieldset label="send-notification-to-user">
		<aui:input 	name="toUserId"
					type="text"
					label="to-user-id" />
		
		<aui:input 	name="notificationMessage"
					type="textarea"
					label="message" />
					
		<aui:input name="submit" type="submit" value="send" />
	</aui:fieldset>
</aui:form>



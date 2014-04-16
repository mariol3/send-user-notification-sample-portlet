package it.mario.sample.portlet.controller;

import it.mario.sample.portlet.notification.SampleUserNotificationHandler;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserNotificationEventLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class Controller extends MVCPortlet {

	public void sendUserNotification(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		Long toUserId = ParamUtil.getLong(actionRequest, "toUserId");
		String notificationMessage = ParamUtil.getString(actionRequest, "notificationMessage");
		
		if (Validator.isNotNull(toUserId) &&
			Validator.isNotNull(notificationMessage)) {
			
				ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
				
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject();
				payloadJSON.put("userId", serviceContext.getUserId());
				payloadJSON.put("notificationMessage", notificationMessage);
				
				UserNotificationEventLocalServiceUtil.addUserNotificationEvent(toUserId, 
						SampleUserNotificationHandler.PORTLET_ID, 
						(new Date()).getTime(),
						serviceContext.getUserId(),
						payloadJSON.toString(),
						false, serviceContext);
				
		}
		
	}
	
}

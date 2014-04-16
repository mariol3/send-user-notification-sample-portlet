package it.mario.sample.portlet.notification;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.model.UserNotificationEvent;
import com.liferay.portal.service.ServiceContext;


public class SampleUserNotificationHandler 
	extends BaseUserNotificationHandler {

	public static final String PORTLET_ID = "sendusernotificationsampleportlet_WAR_sendusernotificationsampleportlet";
	
	public SampleUserNotificationHandler() {
		setPortletId(PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		
		JSONObject payloadJSON = JSONFactoryUtil.createJSONObject(
				userNotificationEvent.getPayload());
		
		return payloadJSON.getString("notificationMessage", "");
	}
	
	@Override
	protected String getLink(UserNotificationEvent userNotificationEvent,
			ServiceContext serviceContext) throws Exception {
		
		return "#";
		
	}
	
}

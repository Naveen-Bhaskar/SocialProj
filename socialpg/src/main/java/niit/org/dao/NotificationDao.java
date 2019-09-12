package niit.org.dao;

import java.util.List;

import niit.org.model.Notification;



public interface NotificationDao {
	void addNotification(Notification notification);
	List<Notification>  getNotificationNotViewed(String email);
	Notification getNotificaiton(int id);
	void updateNotification(int id);

}

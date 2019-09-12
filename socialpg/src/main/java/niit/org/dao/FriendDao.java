package niit.org.dao;

import java.util.List;

import niit.org.model.Friend;
import niit.org.model.User;

public interface FriendDao {
	List<User> getSuggestedUsers(String email);
	void addFriendRequest(Friend friend);
	List<Friend> getPendingRequests(String email);
	void acceptFriendRequest(Friend friend);
	void deleteFriendRequest(Friend friend);
	List<User> listOfFriends(String email);

}

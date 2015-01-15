package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class Friends
{
	
	ArrayList<String> FriendList = new ArrayList<String>();
	
	public void addFriend(String name) {
		FriendList.add(name);	
	}
	
	public void NoFriends() {
		FriendList.clear();		
	}
	
	public void DeleteFriend(String Name) {
		FriendList.remove(Name);
	}
	
	

}

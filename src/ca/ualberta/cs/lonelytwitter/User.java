package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;


public abstract class User extends Object implements UserLike {
	public String username;

	public abstract void setUsername(String x) throws IOException;

	public User(String username){
		super();
		this.username = username;
	}
	
	public User() {
		super();
		this.username = "anonymous";
	}
	
}

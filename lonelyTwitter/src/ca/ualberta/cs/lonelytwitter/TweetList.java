package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class TweetList
{
	private ArrayList<LonelyTweetModel> tweetList;
	public int count;
	
	public TweetList() {
		tweetList = new ArrayList<LonelyTweetModel>();
		count = 0;
	}
	
	public LonelyTweetModel[] getTweets()
	{
		sort();
		LonelyTweetModel[] list = (LonelyTweetModel[]) tweetList.toArray();
		return list;
	}
	
	public void sort() {
		Collections.sort(tweetList, new Comparator<LonelyTweetModel>() {
			public int compare(LonelyTweetModel lhs, LonelyTweetModel rhs){
				return lhs.getTimestamp().compareTo(rhs.getTimestamp());
			}
		});
	}

	public int getCounts() {
		return count;
	}

	public void addTweet(NormalTweetModel tweet) {
		for (int i = 0; i < tweetList.size(); i++) {
			if (tweetList.get(i).equals(tweet)) {
				throw new IllegalArgumentException();
			}
		}
		tweetList.add(tweet);
		count++;
	}
	
	public boolean hasTweet(LonelyTweetModel tweet) {
		return true;
	}
	
	public void removeTweet(LonelyTweetModel tweet) {
		count --;
		
	}
}
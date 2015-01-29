package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetList;
import android.test.ActivityInstrumentationTestCase2;


public class TweetListTests extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListTests()
	{

		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception
	{

		super.setUp();
	}
	
	public void testTweetList() {
		TweetList tweetlist = new TweetList();
		LonelyTweetModel[] tweets = tweetlist.getTweets();
		assertNotNull("Tweet List Not Initialized", tweets);
	}
	
	public void testGet() {
		TweetList tweets = new TweetList();
		NormalTweetModel tweet1 = new NormalTweetModel("Hi");
		NormalTweetModel tweet2 = new NormalTweetModel("Hello");
		NormalTweetModel tweet3 = new NormalTweetModel("Bonjour");
		tweets.addTweet(tweet3);
		tweets.addTweet(tweet1);
		tweets.addTweet(tweet2);
		assertTrue("second element  = middle element?", tweets.getTweets()[1].equals(tweet3));
	}
	
	public void testAdd() {
		boolean thrown = false;
		TweetList tweets = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweets.addTweet(tweet);
		NormalTweetModel tweet1 = new NormalTweetModel("Hello");
		try {
			tweets.addTweet(tweet1);
		} catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue(thrown);		
	}
	
	public void testCounts() {
		TweetList tweetList = new TweetList();
		NormalTweetModel tweet = new NormalTweetModel("Hello");
		tweetList.addTweet(tweet);
		assertEquals("this should be zero", tweetList.getCounts(), 1);
	}

}

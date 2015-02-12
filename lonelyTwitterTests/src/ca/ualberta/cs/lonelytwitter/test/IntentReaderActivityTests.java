package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import android.content.Intent;
import ca.ualberta.cs.lonelytwitter.R;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;


public class IntentReaderActivityTests 
	extends ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSendText() {
		String text = "Hello World";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("got the text?", text, activity.getText());
	}
	
	public void testDoubleText() {
		String text = "Hello World";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		assertEquals("double text?", text+text, activity.getText());
	}
	
	public void testDisplayText() {
		String text = "Hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		TextView view = (TextView) activity.findViewById(R.id.intentText);
		assertEquals("correct text?", text, view.getText());	
	}
	
	public void testReverseText() {
		String text = "hi";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
		assertEquals("Reverse text?", "ih", activity.getText());
	}	
	
	public void noText() {
		String text = "";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		assertEquals("No Text?", "No Text", activity.getText());
	}
	
	public void visible() {
		String text = "hi";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(),
				activity.findViewById(R.id.intentText));
	}
	
	
	private IntentReaderActivity startWithText(String text, int mode) {
		Intent intent =  new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		setActivityIntent(intent);
		return (IntentReaderActivity) getActivity();
	}

}

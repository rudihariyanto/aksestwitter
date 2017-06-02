import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "tTcM0bn4g9Wo8yg9wZMqcuw35";
    private final static String CONSUMER_KEY_SECRET = "lFGzQhA5lcqlVKtDvi9IcVbZn1qj2iryfa0jHEAholRKGXH6fJ";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, i am updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "KiINUZ0qZ9U7kg0ISMzbAmXjsISRUkWBFhROWGmZEDL4c";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "861929502502404096-nsy00iJPBk9XE8foBkS7RMjfgLPeZjP";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
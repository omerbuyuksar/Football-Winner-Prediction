package com.football;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterProducer extends AbstractProducer<String, String> {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterProducer.class);

    /**
     * The actual Twitter stream. It's set up to collect raw JSON data
     */
    private Twitter twitterFactory;

    /**
     * The keywords to filter the twitter firehose.
     */
    private ArrayList<String> kullaniciIsimleri;

    /**
     * The name of the topic created for the producer.
     */
    private String topic;

    /**
     * Creates a TwitterProducer instance.
     *
     * @param topicName The topic associated with this TwitterProducer
     * @param keywords The keywords to filter from the Twitter API Firehose.
     */
    public TwitterProducer(String topicName, ArrayList<String> futbolcular) {
        this.topic = topicName;
        this.kullaniciIsimleri = futbolcular;
    }

    @Override
    public void configure(Properties props) {
        ProducerConfig config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);

        // The necessary authentication keys to connect to twitter API v1.1
        String consumerKey = props.getProperty(TwitterProducerConstants.CONSUMER_KEY_KEY);
        String consumerSecret = props.getProperty(TwitterProducerConstants.CONSUMER_SECRET_KEY);
        String accessToken = props.getProperty(TwitterProducerConstants.ACCESS_TOKEN_KEY);
        String accessTokenSecret = props.getProperty(TwitterProducerConstants.ACCESS_TOKEN_SECRET_KEY);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(consumerKey);
        cb.setOAuthConsumerSecret(consumerSecret);
        cb.setOAuthAccessToken(accessToken);
        cb.setOAuthAccessTokenSecret(accessTokenSecret);
//        cb.setJSONStoreEnabled(true);
//        cb.setIncludeEntitiesEnabled(true);
        cb.setDebugEnabled(true);




        twitterFactory = (new TwitterFactory(cb.build())).getInstance();
//        twitterFactory=new TwitterFactory().getInstance();
    }

    @Override
    public void start() {

        
        for (int i = 0; i < kullaniciIsimleri.size(); i++) {
            int pageno = 1;
            ArrayList<Status> statuses = new ArrayList();
            while (true) {
                try {
                    int size = statuses.size();
                    Paging page = new Paging(pageno++, 100);
                    statuses.addAll(twitterFactory.getUserTimeline(kullaniciIsimleri.get(i), page));
                    if (statuses.size() == size) {
                        break;
                    }
                } catch (TwitterException e) {

                    e.printStackTrace();
                }
            }
            for (int j = 0; j < statuses.size(); j++) {
                String key = statuses.get(i).getCreatedAt().toString();
                String msg = statuses.get(i).getText();

                KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, key, msg);

                producer.send(data);
            }

            System.out.println("Total: " + statuses.size());

        }
    }

    @Override
    public void shutdown() {
        LOG.info("Shutting down the TwitterProducer.");
        super.shutdown();
        twitterFactory.shutdown();
    }
}

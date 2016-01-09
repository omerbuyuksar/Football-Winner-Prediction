package com.football;

/**
 * The constants used for configuring a {@link TwitterProducer}. The
 * {@link Properties} file passed to {@link TwitterProducer#configure(java.util.Properties)}
 * should contain these authentication constants so that a TwitterProducer can
 * be created and authenticated to the Twitter API.
 */
public class TwitterProducerConstants {
	  public static final String CONSUMER_KEY_KEY = "riiJWP9Bu8iy7QYDTyxgAgn7r";
	  public static final String CONSUMER_SECRET_KEY = "XAFCwLcK0eXh7pWiVrIYtBXYHcTpd3MsX8yljTiDpjbAj60e9E";
	  public static final String ACCESS_TOKEN_KEY = "4702232546-CiSBYJWJnDGDlOu05RGTTAGvAlikyPrh9tTfsfl";
	  public static final String ACCESS_TOKEN_SECRET_KEY = "kH18K68P8vOFmuPW2OKOIi9LRQRq2tOPVMsV6RQMGnNOq";
	  
	  public static final String BATCH_SIZE_KEY = "batchSize";
	  public static final long DEFAULT_BATCH_SIZE = 1000L;
}

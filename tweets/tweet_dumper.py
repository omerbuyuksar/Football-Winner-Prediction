#!/usr/bin/env python
# encoding: utf-8

import tweepy #https://github.com/tweepy/tweepy
import csv

#Twitter API credentials
consumer_key = "riiJWP9Bu8iy7QYDTyxgAgn7r"
consumer_secret = "XAFCwLcK0eXh7pWiVrIYtBXYHcTpd3MsX8yljTiDpjbAj60e9E"
access_key = "4702232546-CiSBYJWJnDGDlOu05RGTTAGvAlikyPrh9tTfsfl"
access_secret = "kH18K68P8vOFmuPW2OKOIi9LRQRq2tOPVMsV6RQMGnNOq"


def get_all_tweets(screen_name):
	#Twitter only allows access to a users most recent 3240 tweets with this method
	
	#authorize twitter, initialize tweepy
	auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
	auth.set_access_token(access_key, access_secret)
	api = tweepy.API(auth)
	
	#initialize a list to hold all the tweepy Tweets
	alltweets = []	
	
	#make initial request for most recent tweets (200 is the maximum allowed count)
	new_tweets = api.user_timeline(screen_name = screen_name,count=200)
	
	#save most recent tweets
	alltweets.extend(new_tweets)
	
	#save the id of the oldest tweet less one
	oldest = alltweets[-1].id - 1
	
	#keep grabbing tweets until there are no tweets left to grab
	while len(new_tweets) > 0:
		print "getting tweets before %s" % (oldest)
		
		#all subsiquent requests use the max_id param to prevent duplicates
		new_tweets = api.user_timeline(screen_name = screen_name,count=200,max_id=oldest)
		
		#save most recent tweets
		alltweets.extend(new_tweets)
		
		#update the id of the oldest tweet less one
		oldest = alltweets[-1].id - 1
		
		print "...%s tweets downloaded so far" % (len(alltweets))
	
	#transform the tweepy tweets into a 2D array that will populate the csv	
	outtweets = [[tweet.id_str, tweet.created_at, tweet.text.encode("utf-8")] for tweet in alltweets]
	
	#write the csv	
	#with open('%s_tweets.csv' % screen_name, 'wb') as f:
	with open('tweets.csv', 'ab+') as f:
		writer = csv.writer(f)
		writer.writerow(["id","created_at","text"])
		writer.writerows(outtweets)
	
	pass


if __name__ == '__main__':
	#pass in the username of the account you want to download
	get_all_tweets("1VolkanDEMIREL")
	get_all_tweets("ErtugrulTSKRN")
	get_all_tweets("ertenersu94")
	get_all_tweets("simonkjaer1989")
	get_all_tweets("Balvesofficial")
	get_all_tweets("kadlec_michal")
	get_all_tweets("HasanAli_KALDRM")
	get_all_tweets("CanerErkin")
	get_all_tweets("senerzbayrakl")
	get_all_tweets("_gokhangonul")
	get_all_tweets("abdoubaofficial")
	get_all_tweets("yasirsubasi3")
	get_all_tweets("5Mehmetopalfb")
	get_all_tweets("luisnani")
	get_all_tweets("AlperPOTUK")
	get_all_tweets("ozantufan_7")
	get_all_tweets("_volkansen16")
	get_all_tweets("OficialMeireles")
	get_all_tweets("_mehmettopuz")
	get_all_tweets("Persie_Official")




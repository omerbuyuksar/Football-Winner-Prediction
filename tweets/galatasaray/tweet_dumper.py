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
	get_all_tweets("mustafa_denizli")
	get_all_tweets("ElNeneMuslera")
	get_all_tweets("HakanKadirBalta")
	get_all_tweets("Podolski10")
	get_all_tweets("sneijder101010")
	get_all_tweets("Yasinoztekin_11")
	get_all_tweets("8Selcukinan")
	get_all_tweets("Sarioglusabri")
	get_all_tweets("semihkaya_26")
	get_all_tweets("AurelienChedjou")
	get_all_tweets("UmutbulutCom")
	get_all_tweets("yilmazburak17")
	get_all_tweets("Olcanadin")
	get_all_tweets("Josseroodriguez")
	get_all_tweets("LionelCarole")
	get_all_tweets("Jasondenayer")
	get_all_tweets("sinanguemues18")
	get_all_tweets("emrecolak1010")
	get_all_tweets("TarikCamdal77")
	get_all_tweets("JemKaracan6")
	get_all_tweets("korayguenter28")




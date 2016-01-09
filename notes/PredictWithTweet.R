


tweetData<- fullData

tweetData$HomePositiveTweets      <- 0 
tweetData$AwayPositiveTweets      <- 0 

tweetData$HomeNegativeTweets      <- 0 
tweetData$AwayNegativeTweets      <- 0 



mongodb<-mongo
numberOfRow<-nrow(tweetData)

for(i in 1:numberOfRow){
  # print(i)
  #namespace<-paste("FOOTBALL_PREDICT",teamMapping(tweetData[i,"HomeTeam"]) , sep=".")
  namespace<-paste("FOOTBALL_PREDICT",teamMapping(tweetData[i,]["HomeTeam"]) , sep=".")
  tweetData[i,71]<-positiveTweetsCount(mongodb,namespace,tweetData[i,]["Date"])
  tweetData[i,73]<-negativeTweetsCount(mongodb,namespace,tweetData[i,]["Date"])
  
  namespace<-paste("FOOTBALL_PREDICT",teamMapping(tweetData[i,]["AwayTeam"]) , sep=".")
  tweetData[i,72]<-positiveTweetsCount(mongodb,namespace,tweetData[i,]["Date"])
  tweetData[i,74]<-negativeTweetsCount(mongodb,namespace,tweetData[i,]["Date"])
  
}

tweetData<-tweetData[!is.na(tweetData$BWH),]
tweetData<-tweetData[!is.na(tweetData$BWD),]
tweetData<-tweetData[!is.na(tweetData$BWA),]

set.seed(241)
rf.model <-randomForest(FTR ~ BWH+BWD+BWA+HomeTeam+AwayTeam+HomePositiveTweets+AwayPositiveTweets+HomeNegativeTweets+AwayNegativeTweets, data=tweetData,importance=TRUE,htree=500,proximity=TRUE)
rf.model

# rf.model <- randomForest(FTR ~ HC+AC+HF+AF+HO+AO+HBP+ABP+HY+AY+HR+AR+HS+AS+HST+AST+HHW+AHW+BWH+BWD+BWA, data=fullData, 
#                          importance=TRUE,htree=500,proximity=TRUE)
# fit






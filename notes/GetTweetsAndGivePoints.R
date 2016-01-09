



#### MONGODB CONNECT
#install.packages('rmongodb')

library(rmongodb)

# connection
host <- "127.0.0.1:27017"
username <- ""
password <- ""
db <- "FOOTBALL_PREDICT"

#connect to mongo
# mongo <- mongo.create(host=host , db=db, username=username, password=password)
# 
# 
# matches <- mongo.distinct(mongo,"FOOTBALL_PREDICT.matches","BWD")
# 
# tweets <- mongo.find.all(mongo, "FOOTBALL_PREDICT.galatasaray")
# 
# query = mongo.bson.buffer.create()
# # mongo.bson.buffer.append.list(query, "$text", " {$search: '"güzel"'}")
# buf <- mongo.bson.buffer.create()
# mongo.bson.buffer.start.object(buf, "$text")
# mongo.bson.buffer.append(buf, "$search", "beyaz varlık sağlık şifa barış mutluluk güzel açık temiz berrak rahat serbest zengin iyi süper tamam harika yes")
# mongo.bson.buffer.finish.object(buf)
# query <- mongo.bson.from.buffer(buf)

# positiveTweets <- mongo.find.all(mongo, "FOOTBALL_PREDICT.galatasaray", 
#       query=query)
# length(positiveTweets)
# 
# positiveTweetsCount(mongo,"FOOTBALL_PREDICT.galatasaray",dateOfMatch)
# negativeTweetsCount(mongo,"FOOTBALL_PREDICT.galatasaray",dateOfMatch)
# dateOfMatch<-"2012/12/12"
# strptime(dateOfMatch,"%Y/%m/%d")-1209600
# ??strptime
# mongodb<-mongo
# databaseNameSpace<-"FOOTBALL_PREDICT.galatasaray"
positiveTweetsCount <- function(mongodb, databaseNameSpace, dateOfMatch ){
  buf <- mongo.bson.buffer.create()
  mongo.bson.buffer.start.object(buf, "$text")
  mongo.bson.buffer.append(buf, "$search", "beyaz varlık sağlık şifa barış mutluluk güzel açık temiz berrak rahat serbest zengin iyi süper tamam harika yes")
  mongo.bson.buffer.finish.object(buf)
  #Son 2 haftalık tweetlerine göre veya ondan önceki tweetlere göre
  mongo.bson.buffer.start.object(buf, "created_at")
#   mongo.bson.buffer.append.time(buf, "$gt", strptime(dateOfMatch,"%Y/%m/%d")-1209600)
#   mongo.bson.buffer.finish.object(buf)
  mongo.bson.buffer.append.time(buf, "$lt", strptime(dateOfMatch,"%Y-%m-%d"))
  mongo.bson.buffer.finish.object(buf)
  query <- mongo.bson.from.buffer(buf)
  query
  positiveTweet <- mongo.find.all(mongodb, databaseNameSpace, 
                                   query=query)
  return(length(positiveTweet))
}

negativeTweetsCount <- function(mongodb, databaseNameSpace, dateOfMatch ){
  buf <- mongo.bson.buffer.create()
  mongo.bson.buffer.start.object(buf, "$text")
  mongo.bson.buffer.append(buf, "$search", "sakat sakatlık ceza cezalı kötü hasta hastalık hastalı kırık kırıklar kırıkları alçı alçılı hayır yorgun sıkkın bıkkın halsiz kırmızı sarı kart kırmızı kart sarı kart haksız fena fenalık eksik olumsuz kara ölüm yas katil kayıp savaş kaos berbat kapalı pis berbat bulanık yasak fakir kısıtlı kısıt")
  mongo.bson.buffer.finish.object(buf)
  #Son 2 haftalık tweetlerine göre veya ondan önceki tweetlere göre
  mongo.bson.buffer.start.object(buf, "created_at")
  #   mongo.bson.buffer.append.time(buf, "$gt", strptime(dateOfMatch,"%Y/%m/%d")-1209600)
  #   mongo.bson.buffer.finish.object(buf)
  mongo.bson.buffer.append.time(buf, "$lt", strptime(dateOfMatch,"%Y-%m-%d"))
  mongo.bson.buffer.finish.object(buf)
  query <- mongo.bson.from.buffer(buf)
  query
  negativeTweet <- mongo.find.all(mongodb, databaseNameSpace, 
                                 query=query)
  return(length(negativeTweet))
}

teamMapping<- function(teamName ){
  
  if(teamName=="Fenerbahce")
    return ("fenerbahce")
  if(teamName=="Buyuksehyr")
    return ("basaksehir")
  if(teamName=="Sivasspor")
    return ("sivasspor")
  if(teamName=="Akhisar Belediyespor")
    return ("akhisarspor")
  if(teamName=="Antalyaspor")
    return ("antalyaspor")-
    if(teamName=="Besiktas")
      return ("besiktas")
  if(teamName=="Bursaspor")
    return ("bursaspor")
  if(teamName=="Rizespor")
    return ("caykurizespor")
  if(teamName=="Eskisehirspor")
    return ("eskisehirspor")
  if(teamName=="Galatasaray")
    return ("galatasaray")
  if(teamName=="Gaziantepspor")
    return ("gaziantepspor")
  if(teamName=="Genclerbirligi")
    return ("genclerbirligi")
  if(teamName=="Kasimpasa")
    return ("kasimpasa")
  if(teamName=="Kayserispor")
    return ("kayserispor")
  if(teamName=="Konyaspor")
    return ("konyaspor")
  if(teamName=="Mersin Idman Yurdu")
    return ("mersinidman")
  if(teamName=="Osmanlispor")
    return ("osmanlispor")
  if(teamName=="Sivasspor")
    return ("sivasspor")
  else #dafault twitter adrei olmayan takım
    return ("osmanlispor")
}

 
 


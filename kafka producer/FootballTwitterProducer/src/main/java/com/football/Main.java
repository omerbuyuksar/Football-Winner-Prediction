/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author omer-pc
 */
public class Main {

    private static final long RUN_TIME_IN_SECONDS = 600;

    public static void main(String[] args) throws InterruptedException {

        String consumerKey, consumerSecret, access, accessSecret;

        Properties props = new Properties();
        props.put("metadata.broker.list", "localhost:9092,localhost:9093,localhost:9094");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "com.football.SimplePartitioner");
        props.put("request.required.acks", "1");

        ArrayList<String> oyuncular = new ArrayList<String>();
        oyuncular.add("hugol1120");
        TwitterProducer twitterProducer
                = new TwitterProducer("akhisarspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList<String>();
        oyuncular.add("setoo9");
        oyuncular.add("diegoangelo03");
        oyuncular.add("emrahbassan");
        oyuncular.add("MbolhiDz");

        twitterProducer
                = new TwitterProducer("antalyaspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("Ayhylc02");
        oyuncular.add("volkanbabacann");
        oyuncular.add("Ceko___");
        oyuncular.add("EmreBelozoglu80");
        oyuncular.add("CansevGencer");

        twitterProducer
                = new TwitterProducer("basaksehir", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("Senolgunesresmi");
        oyuncular.add("gnygvc");
        oyuncular.add("AndreasBeck87");
        oyuncular.add("GlmErsan");
        oyuncular.add("Musti5821");
        oyuncular.add("PedroCFranco");
        oyuncular.add("Oguzhan_ozyakup");
        oyuncular.add("Gokhan_Tore7");
        oyuncular.add("olcay_sahan10");
        oyuncular.add("07RQuaresma");
        oyuncular.add("KerimFrei21");
        oyuncular.add("josesosaok");
        oyuncular.add("velikavlak08");
        oyuncular.add("Mario_Gomez");
        oyuncular.add("CenkTosun_");
        oyuncular.add("mpektemek11");
        oyuncular.add("tolgayarslan18");

        twitterProducer
                = new TwitterProducer("besiktas", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("Hhamza_official");
        oyuncular.add("MertGunok");
        oyuncular.add("Necka7");
        oyuncular.add("emre_tsdmr3");
        oyuncular.add("luisadvincula17");
        oyuncular.add("NounkeuD");
        oyuncular.add("rickyfaty");
        twitterProducer
                = new TwitterProducer("bursaspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("karamanhikmet");
        oyuncular.add("leokweuke");
        oyuncular.add("AlbayrakEren");
        oyuncular.add("TuszynskiPatryk");
        oyuncular.add("SRCNKY7");
        twitterProducer
                = new TwitterProducer("caykurizespor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("BoffinOffical");
        oyuncular.add("sezgo75");
        oyuncular.add("Brlprlk");
        oyuncular.add("k_a_c92");
        oyuncular.add("jville15");
        twitterProducer
                = new TwitterProducer("eskisehirspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("1VolkanDEMIREL");
        oyuncular.add("ErtugrulTSKRN");
        oyuncular.add("ertenersu94");
        oyuncular.add("Balvesofficial");
        oyuncular.add("kadlec_michal");
        oyuncular.add("HasanAli_KALDRM");
        oyuncular.add("CanerErkin");
        oyuncular.add("senerzbayrakl");
        oyuncular.add("_gokhangonul");
        oyuncular.add("ertenersu94");
        oyuncular.add("abdoubaofficial");
        oyuncular.add("yasirsubasi3");
        oyuncular.add("5Mehmetopalfb");
        oyuncular.add("luisnani");
        oyuncular.add("AlperPOTUK");
        oyuncular.add("ozantufan_7");
        oyuncular.add("OficialMeireles");
        oyuncular.add("_mehmettopuz");
        oyuncular.add("Persie_Official");
        twitterProducer
                = new TwitterProducer("fenerbahce", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("mustafa_denizli");
        oyuncular.add("ElNeneMuslera");
        oyuncular.add("HakanKadirBalta");
        oyuncular.add("Podolski10");
        oyuncular.add("sneijder101010");
        oyuncular.add("Yasinoztekin_11");
        oyuncular.add("8Selcukinan");
        oyuncular.add("Sarioglusabri");
        oyuncular.add("semihkaya_26");
        oyuncular.add("AurelienChedjou");
        oyuncular.add("UmutbulutCom");
        oyuncular.add("yilmazburak17");
        oyuncular.add("Olcanadin");
        oyuncular.add("Josseroodriguez");
        oyuncular.add("LionelCarole");
        oyuncular.add("Jasondenayer");
        oyuncular.add("sinanguemues18");
        oyuncular.add("emrecolak1010");
        oyuncular.add("TarikCamdal77");
        oyuncular.add("JemKaracan6");
        oyuncular.add("korayguenter28");

        twitterProducer
                = new TwitterProducer("galatasaray", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("muhammetdmr10");
        oyuncular.add("a_kayali");

        twitterProducer
                = new TwitterProducer("gaziantepspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("Uzulmez19");
        oyuncular.add("Ahmetcalik5");
        oyuncular.add("Elkabir88");
        oyuncular.add("irfankahveci");
        oyuncular.add("Ante_Kulusic");

        twitterProducer
                = new TwitterProducer("genclerbirligi", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("rizacalimbay");
        oyuncular.add("AndreCastro88");
        oyuncular.add("Ryan_Donk18");
        oyuncular.add("AdemByK21");
        oyuncular.add("TunayTorun55");
        oyuncular.add("ErenDerdiyok1");
        oyuncular.add("veyselsari");
        oyuncular.add("YonathaDelValle");
        oyuncular.add("kartal117");

        twitterProducer
                = new TwitterProducer("kasimpasa", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

        oyuncular = new ArrayList();
        oyuncular.add("HTolunayKafkas");
        oyuncular.add("ZekiYavruCom");
        oyuncular.add("akbasmustafaa");
        oyuncular.add("sambsow");
        oyuncular.add("CglynOgulcan");

        twitterProducer
                = new TwitterProducer("kayserispor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        
        oyuncular = new ArrayList();
        oyuncular.add("S_Holmen84");
        oyuncular.add("uslumehmet54");
        oyuncular.add("alituran38");
        oyuncular.add("meha_alban");
        oyuncular.add("ay_selim");
        oyuncular.add("halilibosonmezz");

        twitterProducer
                = new TwitterProducer("konyaspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        
        
        oyuncular = new ArrayList();
        oyuncular.add("gokcekvederson6");
        oyuncular.add("servet_cetin76");
        oyuncular.add("oktaydelibalta");
        twitterProducer
                = new TwitterProducer("konyaspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        
        oyuncular = new ArrayList();
        oyuncular.add("gokcekvederson6");
        oyuncular.add("servet_cetin76");
        oyuncular.add("oktaydelibalta");
        twitterProducer
                = new TwitterProducer("mersinidman", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        
        
        oyuncular = new ArrayList();
        oyuncular.add("gokcek");
        twitterProducer
                = new TwitterProducer("osmanlispor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        
        oyuncular = new ArrayList();
        oyuncular.add("Chahechouhe92");
        oyuncular.add("KoneDjakari");
        oyuncular.add("michaeleneramo");
        oyuncular.add("yek_35");
        oyuncular.add("bthn65");
        oyuncular.add("KorcanCelikay");
        twitterProducer
                = new TwitterProducer("sivasspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();
        
        oyuncular = new ArrayList();
        oyuncular.add("10transfer");
        oyuncular.add("Yumlu22ESES");
        oyuncular.add("Ysf032");
        oyuncular.add("OnrKvrk1");
        oyuncular.add("ErkanZ10");
        oyuncular.add("LSP39");
        oyuncular.add("Okayokuslu");
        oyuncular.add("OZER_HURMACI");
        oyuncular.add("__oscarcardozo");
        oyuncular.add("mehmetekicim8");
        oyuncular.add("aytayt35");
        
        twitterProducer
                = new TwitterProducer("trabzonspor", oyuncular);

        twitterProducer.configure(props);
        twitterProducer.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(RUN_TIME_IN_SECONDS));
        twitterProducer.shutdown();

    }

}

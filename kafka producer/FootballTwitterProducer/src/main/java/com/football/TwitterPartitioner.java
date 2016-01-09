/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 *
 * @author omer-pc
 */
public class TwitterPartitioner implements Partitioner<String> {
    public TwitterPartitioner (VerifiableProperties props) {
    }
 
    /**
     * We partition by the time the tweet comes in over the number
     * of partitions. In this way, we can share the time load of 
     * tweets over partitions. 
     * 
     * Custom partitions can partition by some other metric (such
     * as entity mentioned, URL's, etc.).
     */
    public int partition(String key, int a_numPartitions) {
       return Integer.parseInt(key) % a_numPartitions;
  }
 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.ecos.ASE.services;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import edu.escuelaing.ecos.ASE.models.tweets;

import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author JUANC
 */
public class tweetsServices {
    
    
    //private final String dbURI = "mongodb+srv://juanleviathan:BZvAi5sp7xPTs0lq@cluster0.vrrimgz.mongodb.net/tweets?retryWrites=true&w=majority";
    private final String dbURI = "mongodb://juanleviathan:BZvAi5sp7xPTs0lq@ac-igr0fqm-shard-00-00.vrrimgz.mongodb.net:27017,ac-igr0fqm-shard-00-01.vrrimgz.mongodb.net:27017,ac-igr0fqm-shard-00-02.vrrimgz.mongodb.net:27017/tweets?ssl=true&replicaSet=atlas-wboc7v-shard-0&authSource=admin&retryWrites=true&w=majority";
    //private final String uris = "mongodb+srv://alizeci17:3lkEoZD4fXeZ4JdQ@cluster0.woyfef7.mongodb.net/tweets?retryWrites=true&w=majority";
    MongoClientURI uri = new MongoClientURI(dbURI);
    MongoClient client = new MongoClient(uri);
    Datastore store = new Morphia().createDatastore(client, "Twitter_version1");
    
    public String createTweet(tweets tweet){
        
        store.save(tweet);
        return "Tweet publicado";
        
    }
    
    public List<tweets> TweetsStream(){
        
        List<tweets> twe = store.find(tweets.class).asList();
        return twe;
    }
}

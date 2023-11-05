/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.ecos.ASE.controllers;

import com.google.gson.Gson;
import edu.escuelaing.ecos.ASE.models.tweets;
import edu.escuelaing.ecos.ASE.services.tweetsServices;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;


/**
 *
 * @author JUANC
 */

public class tweetController {
    
    Gson gson = new Gson();
    tweetsServices service = new tweetsServices();
    
    
    public List<tweets> tweetControllerServices(){
        
        
        // Habilita todas las solicitudes CORS desde cualquier origen
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Request-Method", "GET, POST, PUT, DELETE");
            response.header("Access-Control-Allow-Headers", "Content-Type, Authorization");
        });

      
         
        
        get("/tweets",(req,res)->{
            
            res.type("application/json");
            return service.TweetsStream();
            
        },gson::toJson);
          
        return service.TweetsStream();
        
    }
    
    
    public String valll (){
        
          post("/tweets",(req,res)->{
            
            res.type("application/json");
            tweets twe = gson.fromJson(req.body(), tweets.class);
            UUID id = UUID.randomUUID();
            String idValue = id.toString();
            twe.setId(idValue);
            twe.setDate(LocalDateTime.now());
            return service.createTweet(twe);
            
        },gson::toJson);
          
          return "Tweet publicado";
    }
}

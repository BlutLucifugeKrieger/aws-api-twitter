/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.escuelaing.ecos.ASE.handler;


import com.google.gson.Gson;
import edu.escuelaing.ecos.ASE.controllers.tweetController;
import edu.escuelaing.ecos.ASE.models.tweets;
import java.util.List;


/**
 *
 * @author JUANC
 */
public class handler {

    
    public List<tweets> handleRequest(tweets twe) {
     
        
            tweetController controller = new tweetController();
            List<tweets> response = controller.tweetControllerServices();
            Gson gson = new Gson();
            
            
            return response;
            
            
            
    }
    
    public String handleRequest2 (){
        
         tweetController controller = new tweetController();
         String result = controller.valll();
         
         return result;
    }
    
    
}

package fr.formation.inti.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class PageEventController {

	
	
	
	@GetMapping("/event/{id}")
	public String MyeventsGET(@PathVariable String id, Model model) {	  
		
		/*
        try {
            URL url = new URL("https://public.opendatasoft.com/api/v2/catalog/datasets/evenements-publics-openagenda/records/" + id);
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            
            model.addAttribute("response", response);
            
            
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response.toString());

            // Extract the "title_fr" field
            String title = rootNode.path("fields").path("title_fr").asText();

            // Store the title in the model
            model.addAttribute("title", title);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        return "eventinfo";
    }
}
	








// https://public.opendatasoft.com/api/v2/catalog/datasets/evenements-publics-openagenda/records/c2473cef9be86a8a398bb1bfbc47a2f365205ea4
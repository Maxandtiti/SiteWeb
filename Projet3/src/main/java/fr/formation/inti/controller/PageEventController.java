package fr.formation.inti.controller;


import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PageEventController {

	
	
	
	@GetMapping("/event/{id}")
	public String MyeventsGET(@PathVariable String id) {	  

		try {
			    URL url = new URL(String.format("https://public.opendatasoft.com/api/v2/catalog/datasets/evenements-publics-openagenda/records/%s", id));
			    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("GET");
			    connection.setDoInput(true);

			    int status = connection.getResponseCode();
			    if (status != 200) {
			      throw new Exception("Erreur de réponse du serveur");
			    }

			    return "eventinfo";
			  } catch (Exception ex) {
		
			    return "error";
			  }
			}
	
	
	@GetMapping("/privateevent/{id}")
	public String PrivateeventsGET(@PathVariable String id) {	  

		try {
			    URL url = new URL(String.format("http://localhost:8080/api/myevents/%s", id));
			    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			    connection.setRequestMethod("GET");
			    connection.setDoInput(true);

			    int status = connection.getResponseCode();
			    if (status != 200) {
			      throw new Exception("Erreur de réponse du serveur");
			    }

			    return "eventinfoprivate";
			  } catch (Exception ex) {
		
			    return "error";
			  }
			}
	
	
}
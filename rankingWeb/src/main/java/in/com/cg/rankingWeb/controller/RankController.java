package in.com.cg.rankingWeb.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import in.com.cg.rankingWeb.pojo.PlayerData;


@Controller
public class RankController {
	
	static final String Ranking= "http://localhost:8080/ranking/";
	static final RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("")
	public String viewHome(Model model) {
		return "home";
	}
	
	@RequestMapping("/ranking")
	public String viewAllCustomers(Model model) {
		ResponseEntity<?> responseEntity = restTemplate.exchange(Ranking, HttpMethod.GET, null, new ParameterizedTypeReference<List<PlayerData>>(){});
		
		if(responseEntity.getStatusCode().equals(HttpStatus.OK)) 
			model.addAttribute("ranking", responseEntity.getBody());
		else
			model.addAttribute("ranking", null);
		return "ranking";
	}
	
	


}

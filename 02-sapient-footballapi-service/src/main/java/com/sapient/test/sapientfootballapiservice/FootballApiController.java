package com.sapient.test.sapientfootballapiservice;

import java.util.Arrays;
import com.sapient.test.sapientfootballapiservice.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class FootballApiController {
	
	@Autowired
	Configuration footballApiConfig;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
	    return new RestTemplate();
	}
	
	@GetMapping("/countries")
	public String countries() {
		
		String url = "https://apiv2.apifootball.com/?action="+footballApiConfig.getCountriesaction()+"&APIkey="+footballApiConfig.getApikey();
		System.out.println("countries url: " + url);
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	      return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@GetMapping("/competitionsbycountry/{id}")
	public String competitionsByCountry(@PathVariable String id) {
		
		String url = "https://apiv2.apifootball.com/?action="+footballApiConfig.getCompetitionsbycountryaction()+"&country_id="+id+"&APIkey="+footballApiConfig.getApikey();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@GetMapping("/teamsbyleague/{id}")
	public String teamsByLeague(@PathVariable String id) {
		
		String url = "https://apiv2.apifootball.com/?action="+footballApiConfig.getTeamsbyleagueaction()+"&league_id="+id+"&APIkey="+footballApiConfig.getApikey();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
	
	@GetMapping("/standingbyleague/{id}")
	public String standingByLeague(@PathVariable String id) {
		
		String url = "https://apiv2.apifootball.com/?action="+footballApiConfig.getStandingbyleagueaction()+"&league_id="+id+"&APIkey="+footballApiConfig.getApikey();
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	      
	    return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	}
	
}


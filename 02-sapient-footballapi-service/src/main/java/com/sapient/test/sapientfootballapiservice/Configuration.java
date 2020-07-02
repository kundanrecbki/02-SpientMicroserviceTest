package com.sapient.test.sapientfootballapiservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("footballapi.action")
public class Configuration {
	
	private String countriesaction;
	private String apikey;
	private String competitionsbycountryaction;
	private String teamsbyleagueaction;
	private String standingbyleagueaction;
	public String getCountriesaction() {
		return countriesaction;
	}
	public void setCountriesaction(String countriesaction) {
		this.countriesaction = countriesaction;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getCompetitionsbycountryaction() {
		return competitionsbycountryaction;
	}
	public void setCompetitionsbycountryaction(String competitionsbycountryaction) {
		this.competitionsbycountryaction = competitionsbycountryaction;
	}
	public String getTeamsbyleagueaction() {
		return teamsbyleagueaction;
	}
	public void setTeamsbyleagueaction(String teamsbyleagueaction) {
		this.teamsbyleagueaction = teamsbyleagueaction;
	}
	public String getStandingbyleagueaction() {
		return standingbyleagueaction;
	}
	public void setStandingbyleagueaction(String standingbyleagueaction) {
		this.standingbyleagueaction = standingbyleagueaction;
	}
	
}


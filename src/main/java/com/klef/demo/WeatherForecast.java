package com.klef.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherForecast implements Serializable 
{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("entries")
	public List<WeatherIncomingModel> getEntries() {
		return entries;
	}
	@JsonSetter("list")
	public void setEntries(List<WeatherIncomingModel> entries) {
		this.entries = entries;
	}
	private List<WeatherIncomingModel> entries = new ArrayList<>();
	

}

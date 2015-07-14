package com.fsoft.bidding.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsoft.bidding.dto.Item;
import com.fsoft.bidding.dto.Response;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String showMessage(Model model) {
		model.addAttribute("message", "Hello World!");
		return "showMessage";
	}

	@RequestMapping(value = "/Hello")

	public @ResponseBody String sayHello() {
		return "Hello";
	}

	@RequestMapping(value = "/HelloJSON", produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody Response sayHelloJSON() {

		Response response = new Response();
		response.setMessage("Hello World JSON");

		return response;
	}

	@RequestMapping(value = "/HelloXML")
	@ResponseBody
	public Response sayHelloXML() {

		Response response = new Response();
		response.setMessage("Hello World XML");

		return response;
	}

	@RequestMapping(
			value = "/item",
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)

	public @ResponseBody Response createItem(@RequestBody Item item) {
		Response response = new Response();
		// response.setMessage("Item Created");
		response.setMessage("Item Name: " + item.getItem_name());

		return response;
	}

	@RequestMapping(
			value = "/items/all",
			method = RequestMethod.GET,
			//consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public @ResponseBody List<Item> allItems() {
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		Item i2 = new Item();
		Item i3 = new Item();
		
		i1.setItem_id(1);
		i2.setItem_id(2);
		i3.setItem_id(3);
		
		i1.setItem_name("One");
		i2.setItem_name("Two");
		i3.setItem_name("Three");
		items.add(i1);
		items.add(i2);
		items.add(i3);
		return items;
	}
	
	
	@RequestMapping(
			value = "/item/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public @ResponseBody Item itemId(@PathVariable Integer id){
		
		List<Item> items = new ArrayList<>();
		Item i1 = new Item();
		Item i2 = new Item();
		Item i3 = new Item();
		
		i1.setItem_id(1);
		i2.setItem_id(2);
		i3.setItem_id(3);
		
		i1.setItem_name("One");
		i2.setItem_name("Two");
		i3.setItem_name("Three");
		items.add(i1);
		items.add(i2);
		items.add(i3);
		
		switch(id){
		case 1: {
			return i1;
		}
		case 2: {
			return i2;
		}
		case 3: {
			return i3;
		}
		default: return null;
		}
	
	}
	
		
	

}

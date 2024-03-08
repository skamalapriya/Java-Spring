package com.code.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.code.mvc.entity.Category;
import com.code.mvc.entity.Item;
import com.code.mvc.services.IItemService;

@RestController
@RequestMapping(value = "/api")
public class ItemController {
	
	@Autowired
	IItemService itemServiceImpl;
	
	@GetMapping(value = "/")
	public void sendMsg() {
		System.out.println("Successful connection");
	}
	
	public String uploadImageToFile(MultipartFile photo) {
		String photoFileName = photo.getOriginalFilename();
		String path = "C:\\Users\\kamal\\eclipse-workspace\\SpringMVCProject\\src\\main\\webapp\\resources\\images";
		File directory = new File(path); 
		if(!(directory.exists()))
			directory.mkdir();
		File fileName = new File(directory.getPath(), photoFileName);
		try {
			photo.transferTo(fileName);
			System.out.println(fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IllegalStateException while trying to transfer photo file contents to a file inside images folder");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("IOException while trying to transfer photo file contents to a file inside images folder");
		}
		return fileName.getPath();
	}
	
/*	@PostMapping(value = "/item/add")
	public Item addItem(@RequestParam String itemName, @RequestParam int price, @RequestParam CommonsMultipartFile photo, @RequestParam Category category) {
		System.out.println("Item name: " + itemName);
		String fileNamePath = uploadImageToFile(photo);
		Item item = new Item();
		//item.setFileName(itemName);
		item.setPrice(price);
		item.setFileName(fileNamePath);
		item.setCategory(category);
		itemServiceImpl.createItem(item);
		return item;
		
	}*/
	
//	@RequestMapping(value = "/item/add", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@PostMapping(value = "/item/add")
	public Item addItem(@RequestPart Item item, @RequestPart("photo") MultipartFile photo) {
//	public Item addItem(@RequestBody Item item) {
		System.out.println("Item name: " + item.getFileName());
		String fileNamePath = uploadImageToFile(photo);
	//	String fileNamePath = uploadImageToFile(item.getPhoto());
		item.setFileName(fileNamePath);
		itemServiceImpl.createItem(item);
		return item;
	}
	
/*	@PostMapping(value = "/item/add")
	//@RequestMapping(value = "/item/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	//@ResponseBody
	public Item addItem(@RequestBody Item item) {
		itemServiceImpl.createItem(item);
		return item;
	}*/
} 

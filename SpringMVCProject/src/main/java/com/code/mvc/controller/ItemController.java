package com.code.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping(value = "/item/list")
	public List<Item> listItem() {
		List<Item> items = itemServiceImpl.getItems();
		return items;
	}
	
	/* @PathVariable is used if we give as "http://localhost:8080/item/1
	 * @PathVariable is used to fetch the id given in the url. If we give "/item/{id}", we can give just
	 * "@PathVariable int id", else if we have given "/item/{idd}" where idd is not the same as pathvariable
	 * name then give as given below in the code*/
	@GetMapping(value = "/item/{idd}")
	public Item getItemById(@PathVariable("idd") int id) {
		Item item = itemServiceImpl.getItemById(id);
		return item;		
	}
	
	/* @RequestPart is used to send a POST request i Postman using "form-data" option wherein we will 
	 * give key-value pairs along with the corresponding "Content-Type" i.e. in our usecase 2 key-value
	 * pairs which are key1 is item whose value is a JSON object with all fields and values corresponding
	 * to the attributes in our Item class except for item_id and the corresponding Content-Type is 
	 * "application-json" and key2 is photo whose value is selected from the local memory and the corresponding
	 * Content-Type is "multipart/form-data.
	 * Also, in "Post" we will not give id, so "Post" is not idempodent (i.e. if we hit the server n times
	 * with the same request, the response and the number of rows i.e. memory used by DB wont be the same.
	 * Each item new record/resource will be created with unique ids*/
	@PostMapping(value = "/item/add")
	public Item addItem(@RequestPart Item item, @RequestPart("photo") MultipartFile photo) {
		//System.out.println("Item name: " + item.getFileName());
		String fileNamePath = uploadImageToFile(photo);
		item.setFileName(fileNamePath);
		itemServiceImpl.createItem(item);
		System.out.println(item);
		return item;
	}
	
	
	/* @PutMapping is not compatible with multipart. So, when we try to update, previous fileName will not be 
	 * preserved, instead nothing will be saved in the fileName field for that record. So, if we want to update
	 * fileName preserving the other fields value without losing them, then PATCH has to be used.
	 * 
	 * For PUT, we have to value for all fields of a record/row of the table else null will be saved for the fields
	 * which have not been given any value. It doesn't preserve the previous value.
	 * 
	 * Also, if we try to edit the record for a non-existing id but explicitly mentioning a non-existing id(i.e.
	 * such a record is not created or doesn't exist), Postman shows error.
	 * (eg): {"itemId":7, //Here no record exists in DB with itemId=7 and trying to edit that record, Postman shows error
	 *        "itemName":"xyz",
	 *        ...}
	 *  
	 * But, if we try to edit by giving all the fields without mentioning the "itemId" explicitly, then a new 
	 * record will be created in DB with a new id. Suppose, before this PUT, there existed 5 records and the last
	 * itemId=5, then a new record will be created with itemId=6
	 * (eg): {"itemName":"xyz", //Here a new record is created.
	 *        ....}
	 *  */
	@PutMapping(value = "/item/edit")
	public Item updateItem(@RequestBody Item item) {
		System.out.println("Inside edit");
	//	String fileNamePath = uploadImageToFile(photo);
	//	item.setFileName(fileNamePath);
		itemServiceImpl.updateItem(item);
		return item;
	}
	
	@DeleteMapping(value = "/item/delete/{id}")
	public String deleteItemById(@PathVariable int id) {
		Item item = itemServiceImpl.getItemById(id);
		if(item == null)
			return "Item with itemId " + id + " not found";
		itemServiceImpl.deleteItemById(id);
		return "Item deleted successfully";
	}
	
	//@Patch is not working for any option like RequestPart, RequestParam or RequestBody. Try later	
/*	@PatchMapping(value = "/item/edit/{id}")
	public Item updateFile(@PathVariable int id, @RequestPart("photo") MultipartFile photo) throws Exception{
		System.out.println("Inside edit file");
	//	int id = Integer.parseInt(idd);
		if(photo.isEmpty()) {
			System.out.println("Inside photo empty");
			return null;
		}
		try {
		System.out.println("Inside try");
		System.out.println(photo.getOriginalFilename());
		String fileNamePath = uploadImageToFile(photo);
		return itemServiceImpl.updateFile(id, fileNamePath);
		}
		catch(Exception e){
			return null;
		}
	}*/   
	
/*	@PutMapping(value = "/item/edit")
	public Item updateItem(@RequestPart Item item, @RequestPart("photo") MultipartFile photo) {
		System.out.println("Inside edit");
		String fileNamePath = uploadImageToFile(photo);
		item.setFileName(fileNamePath);
		itemServiceImpl.updateItem(item);
		return item;
	}*/  
	
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
/*	@PostMapping(value = "/item/add")
	//@RequestMapping(value = "/item/add", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	//@ResponseBody
	public Item addItem(@RequestBody Item item) {
		itemServiceImpl.createItem(item);
		return item;
	}*/
} 

package com.bonc.demoweb.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bonc.demoweb.dao.UserDao;
import com.bonc.demoweb.model.UserEntity;


/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * @author zwd
 * @date 2018年9月25日
 */

@Controller
@RequestMapping("/con")
public class UserController {
	private final static Logger loger=LoggerFactory.getLogger(UserController.class);

	private static final String APPLICATION_JSON_VALUE = null;
	
	@Resource
	private UserDao userDao;

	@GetMapping(value="/say")
	//@ResponseBody
	public String say(Model model) {
	
		String name=userDao.getUserName();
		System.out.println(name);
		model.addAttribute("username", name);
		return "sta";
	}
	@PostMapping(value="/sayU")
	@ResponseBody
	public UserEntity sayU(@RequestBody Map<String,Object> map,Model model) {
		loger.info("打印"+map.get("uname"));
		List<UserEntity> userList=new ArrayList<UserEntity>();
		UserEntity user=new UserEntity();
		user.setUserName("张三");
		user.setPassword("123");
		userList.add(user);
		userList.add(user);
		
		return user;
	}
	
	@RequestMapping(value="/pdfIO",produces= "application/pdf")
	@ResponseBody
	public void  pdfIO(HttpServletResponse response){
	String path="src/main/resources/static/d.pdf";
	File file=new File(path);
	InputStream is = null;
	try {
	is=new FileInputStream(file);
	
	OutputStream outputStream=response.getOutputStream();
	IOUtils.write(IOUtils.toByteArray(is), outputStream);
		 IOUtils.toByteArray(is);
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally{
		if(is!= null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	}
	@RequestMapping(value="/pdf",produces= "application/pdf")
	@ResponseBody
	public byte[]  pdf(HttpServletResponse response){
		String path="src/main/resources/static/d.pdf";
		File file=new File(path);
		InputStream is = null;
		try {
			is=new FileInputStream(file);
			
		 return IOUtils.toByteArray(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!= null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
		
	}
	@RequestMapping(value="/word",produces= "application/msword")
	@ResponseBody
	public byte[] word(){
		String path="src/main/resources/static/w.docx";
		File file=new File(path);
		InputStream is = null;
		try {
			is=new FileInputStream(file);
			
			
			return IOUtils.toByteArray(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!= null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return null;
	}
	
	@RequestMapping("/upFile")
	public String upLoad(Model model,@RequestParam("file")MultipartFile file) {
		 String oldFileName = file.getOriginalFilename();
	        System.out.println(oldFileName+"===打印原文件名");
	        String suffix=FilenameUtils.getExtension(oldFileName);
		  String newFileName=System.currentTimeMillis()+RandomUtils.nextInt(100)+"."+suffix;
	        String path = "D:/test" ;
	        File myFile = new File(path + "/" + newFileName);
	        if(!myFile.getParentFile().exists()){ //判断文件父目录是否存在
	        	myFile.getParentFile().mkdir();
	        }
	        try {
				file.transferTo(myFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        model.addAttribute("img","D:/test/"+newFileName);
		    model.addAttribute("msg","上传成功");
		    return "index.html";
	}
	
}

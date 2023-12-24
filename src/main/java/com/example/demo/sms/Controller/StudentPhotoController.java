package com.example.demo.sms.Controller;




import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.sms.Model.StudentPhoto;

import com.example.demo.sms.Service.StudentPhotoService;



@Controller
public class StudentPhotoController {

	@Autowired
	private StudentPhotoService studentPhototService;
	
	 @GetMapping("/display")
	    public ResponseEntity<byte[]> displayImage(@RequestParam("id") long id) throws IOException, SQLException
	    {
	    	StudentPhoto image = studentPhototService.viewById(id);
	        byte [] imageBytes = null;
	        imageBytes = image.getImage().getBytes(1,(int) image.getImage().length());
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	    }
	    
	@GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        List<StudentPhoto> imageList = studentPhototService.viewAll();
        mv.addObject("imageList", imageList);
        return mv;
    }
	     
	    
	@GetMapping("/add")
    public String addImageForm(Model model) {
        return "adding";
    }

    @PostMapping("/add1")
    public String addImagePost(@RequestParam("name") String name, @RequestParam("studentphoto") MultipartFile file) throws IOException, SerialException, SQLException {
        byte[] bytes = file.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        StudentPhoto studentPhoto = new StudentPhoto();
        studentPhoto.setName(name);
        studentPhoto.setImage(blob);
        studentPhototService.create(studentPhoto);
        return "redirect:/add";
    }
    
    

}

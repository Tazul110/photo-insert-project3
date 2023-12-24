package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.StudentPhoto;

@Service
public interface StudentPhotoService {
 
   StudentPhoto create(StudentPhoto studentPhoto);
	
    List<StudentPhoto> viewAll(); 
    
    StudentPhoto viewById(long id);
}

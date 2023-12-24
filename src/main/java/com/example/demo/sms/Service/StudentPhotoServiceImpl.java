package com.example.demo.sms.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.sms.Model.StudentPhoto;
import com.example.demo.sms.Repository.StudentPhotoRepository;




@Service
public class StudentPhotoServiceImpl implements StudentPhotoService
{
   @Autowired
   private StudentPhotoRepository studentPhotoRepository;

public StudentPhoto create(StudentPhoto studentPhoto) {
	return studentPhotoRepository.save(studentPhoto);
}

public List<StudentPhoto> viewAll() {
	return (List<StudentPhoto>) studentPhotoRepository.findAll();
}

public StudentPhoto viewById(long id) {
	return studentPhotoRepository.findById(id).get();
}
   
   
}

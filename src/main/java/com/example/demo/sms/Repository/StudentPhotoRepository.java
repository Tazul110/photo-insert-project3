package com.example.demo.sms.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.sms.Model.StudentPhoto;

@Repository
public interface StudentPhotoRepository extends CrudRepository<StudentPhoto, Long>
{

}

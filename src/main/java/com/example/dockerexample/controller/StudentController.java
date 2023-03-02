package com.example.dockerexample.controller;

import com.example.dockerexample.models.Student;
import com.example.dockerexample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "student")
public class StudentController {

  @Autowired
  private StudentRepository studentRepository;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String hello(ModelMap modelMap){
    return "Hello World. How are you";
  }

  @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
  public String insertStudent(@RequestParam String name,
                              @RequestParam String birthYear){
    Student student = new Student(name,birthYear);
    studentRepository.save(student);
    return "insert student success: "+name;
  }
}

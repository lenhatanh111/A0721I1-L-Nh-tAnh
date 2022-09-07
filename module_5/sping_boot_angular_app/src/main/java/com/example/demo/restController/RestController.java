package com.example.demo.restController;
import com.example.demo.model.Student;
import com.example.demo.service.IGroupService;
import com.example.demo.service.IStudentService;
import com.example.demo.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/student")
public class RestController {
    @Autowired
    private  IStudentService studentService;
    private ITeacherService teacherService;
    private IGroupService groupService;
    @GetMapping("")
    public ResponseEntity<Page<Student>> getAllStudent(Pageable pageable){
Page<Student>students=studentService.getAll(pageable);
        System.out.println(students);
if (students.isEmpty()){
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> findAllStudent(){
        List<Student>students=studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }



}

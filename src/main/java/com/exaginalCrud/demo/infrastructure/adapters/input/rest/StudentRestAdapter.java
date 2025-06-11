package com.exaginalCrud.demo.infrastructure.adapters.input.rest;

import com.exaginalCrud.demo.application.ports.input.StudentServicePort;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request.StudentCourseAssignRequest;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/student")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class StudentRestAdapter {

    private final StudentServicePort servicePort;
    private final StudentRestMapper restMapper;

    @GetMapping("/getAll")
    public List<StudentResponse> findAll(){
        return restMapper.toStudentResponseList(servicePort.findAll());
    }

    @GetMapping("/getById/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return restMapper.toStudentResponse(servicePort.findById(id));
    }

    @PostMapping ("/create")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(
                        servicePort.save(restMapper.toStudent(request))));
    }

    @PutMapping("/update/{id}")
    public StudentResponse updateStudent(@Valid @RequestBody StudentCreateRequest request, @PathVariable Long id) {
        return restMapper.toStudentResponse(
                servicePort.update(id, restMapper.toStudent(request)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent (@PathVariable Long id){
        servicePort.deleteById(id);
    }

    @PostMapping("/assign-course")
    public ResponseEntity<String> assignCourseToStudent(
            @Valid @RequestBody StudentCourseAssignRequest request) {

        servicePort.addCourseToStudent(request.getStudentId(), request.getCourseId());
        return ResponseEntity.ok("Student assigned to course successfully.");
    }
}

package com.exaginalCrud.demo.infrastructure.adapters.input.rest;

import com.exaginalCrud.demo.application.ports.input.CourseServicePort;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.mapper.CourseRestMapper;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.request.CourseCreateRequest;
import com.exaginalCrud.demo.infrastructure.adapters.input.rest.model.response.CourseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/course")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class CourseRestAdapter {

    private final CourseServicePort servicePort;
    private final CourseRestMapper restMapper;

    @GetMapping("/getAll")
    public List<CourseResponse> findAll(){
        return restMapper.toCourseResponseList(servicePort.findAll());
    }

    @GetMapping("/getById/{id}")
    public CourseResponse findById(@PathVariable Long id){
        return restMapper.toCourseResponse(servicePort.findById(id));
    }

    @PostMapping ("/create")
    public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toCourseResponse(
                        servicePort.save(restMapper.toCourse(request))));
    }

    @PutMapping("/update/{id}")
    public CourseResponse updateCourse(@Valid @RequestBody CourseCreateRequest request, @PathVariable Long id) {
        return restMapper.toCourseResponse(
                servicePort.update(id, restMapper.toCourse(request)));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourse (@PathVariable Long id){
        servicePort.deleteById(id);
    }

}

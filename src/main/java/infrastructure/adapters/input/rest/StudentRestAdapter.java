package infrastructure.adapters.input.rest;

import application.ports.input.StudentServicePort;
import infrastructure.adapters.input.rest.mapper.StudentRestMapper;
import infrastructure.adapters.input.rest.model.request.StudentCreateRequest;
import infrastructure.adapters.input.rest.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentRestAdapter {

    private final StudentServicePort servicePort;
    private final StudentRestMapper restMapper;

    @GetMapping("/v|/api/getAllStudent")
    public List<StudentResponse> findAll(){
        return restMapper.toStudentResponseList(servicePort.findAll());
    }

    @GetMapping("/v|/api/getStudentById/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return restMapper.toStudentResponse(servicePort.findById(id));
    }

    @PostMapping ("/v1/api/createStudent")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(
                        servicePort.save(restMapper.toStudent(request))));
    }

    @PutMapping("v1/api/updateStudent/{id}")
    public StudentResponse updateStudent(@Valid @RequestBody StudentCreateRequest request, @PathVariable Long id) {
        return restMapper.toStudentResponse(
                servicePort.update(id, restMapper.toStudent(request)));
    }

    @DeleteMapping("/v1/api/deleteStudent/{id]")
    public void deleteStudent (@PathVariable Long id){
        servicePort.deleteById(id);
    }
}

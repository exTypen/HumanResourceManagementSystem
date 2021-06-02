package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.Abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAllByActive")
    public ResponseEntity<?> getAllByActive(@RequestParam boolean active){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByActive(active));
    }

    @GetMapping("/getAllByActiveOrderByCreateDateDesc")
    public ResponseEntity<?> getAllByActiveOrderByCreateDateDesc(@RequestParam boolean active){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByActiveOrderByCreateDateDesc(active));
    }

    @GetMapping("/getAllByEmployerId")
    public ResponseEntity<?> getAllByEmployerId(@RequestParam int employerId){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployerId(employerId));
    }

    @GetMapping("/getAllByEmployerIdAndAcitve")
    public ResponseEntity<?> getAllByEmployerIdAndAcitve(@RequestParam int employerId, boolean active){
        return ResponseEntity.ok(this.jobAdvertisementService.getAllByEmployerIdAndAcitve(employerId, active));
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(jobAdvertisement);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
        return errors;
    }
}

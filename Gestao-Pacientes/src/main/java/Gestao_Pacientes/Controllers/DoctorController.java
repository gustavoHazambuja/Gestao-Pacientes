package Gestao_Pacientes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestao_Pacientes.Entities.Doctor;
import Gestao_Pacientes.Services.DoctorService;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorController {
    
    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){

        Doctor result = doctorService.addDoctor(doctor);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Doctor>> getAllDoctors(Pageable pageable){

        Page<Doctor> result = doctorService.getAllDoctors(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){

        Doctor result = doctorService.findById(id);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    
}

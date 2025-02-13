package Gestao_Pacientes.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Gestao_Pacientes.Entities.Patient;
import Gestao_Pacientes.Entities.PatientStatus;
import Gestao_Pacientes.Services.PatientService;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {
    
    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPacient(@RequestBody Patient pacient){

        Patient result = patientService.addPacient(pacient);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Patient>> getAllPacients(Pageable pageable){

        Page<Patient> result = patientService.getAllPacients(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<Page<Patient>> findPacientbyStatus(@PathVariable PatientStatus status, Pageable pageable){

        Page<Patient> result = patientService.findPacientByStatus(status, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePacientById(@PathVariable Long id){

        patientService.deletePacientById(id);
    }

    @PatchMapping(value = "/{id}/status/{status}")
    public ResponseEntity<Patient> updateStatus(@PathVariable PatientStatus status, @PathVariable Long id){

        Patient result = patientService.updateStatus(status, id);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

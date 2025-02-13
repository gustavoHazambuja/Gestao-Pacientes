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

import Gestao_Pacientes.Entities.Pacient;
import Gestao_Pacientes.Entities.PacientStatus;
import Gestao_Pacientes.Services.PacienteService;

@RestController
@RequestMapping(value = "/pacients")
public class PacientController {
    
    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Pacient> addPacient(@RequestBody Pacient pacient){

        Pacient result = pacienteService.addPacient(pacient);

        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Pacient>> getAllPacients(Pageable pageable){

        Page<Pacient> result = pacienteService.getAllPacients(pageable);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping(value = "/status/{status}")
    public ResponseEntity<Page<Pacient>> findPacientbyStatus(@PathVariable PacientStatus pacientStatus, Pageable pageable){

        Page<Pacient> result = pacienteService.findPacientByStatus(pacientStatus, pageable);

        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deletePacientById(@PathVariable Long id){

        pacienteService.deletePacientById(id);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Pacient> updateStatus(@RequestBody PacientStatus pacientStatus, @PathVariable Long id){

        Pacient result = pacienteService.updateStatus(pacientStatus, id);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

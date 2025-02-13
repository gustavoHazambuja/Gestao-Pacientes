package Gestao_Pacientes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Gestao_Pacientes.Entities.Pacient;
import Gestao_Pacientes.Entities.PacientStatus;
import Gestao_Pacientes.Exceptions.PacientException;
import Gestao_Pacientes.Repositories.PacientRepository;

@Service
public class PacienteService {
    
    @Autowired
    PacientRepository pacientRepository;

    @Transactional
    public Pacient addPacient(Pacient pacient){

        return pacientRepository.save(pacient);
    }

    @Transactional(readOnly = true)
    public Page<Pacient> getAllPacients(Pageable pageable){
        
        Page<Pacient> result = pacientRepository.findAll(pageable);

        return result;
    }

    @Transactional(readOnly = true)
    public Page<Pacient> findPacientByStatus(PacientStatus pacientStatus, Pageable pageable){

        return pacientRepository.findPacientByStatus(pacientStatus, pageable);
    }

    @Transactional
    public void deletePacientById(Long id){

        if(!pacientRepository.existsById(id)){
            throw new PacientException("Paciente não encontrado com id" + id);
        }
        pacientRepository.deleteById(id);
    }

    @Transactional
    public Pacient updateStatus(PacientStatus pacientStatus, Long id){

        if(!pacientRepository.existsById(id)){
            throw new PacientException("Paciente não encontrado com id" + id);
        }

        Pacient result = pacientRepository.findById(id).get();

        result.setStatus(pacientStatus);

        return pacientRepository.save(result);
    }
}

package Gestao_Pacientes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Gestao_Pacientes.Entities.Doctor;
import Gestao_Pacientes.Exceptions.DoctorException;
import Gestao_Pacientes.Repositories.DoctorRepository;


@Service
public class DoctorService {
    
    @Autowired
    DoctorRepository doctorRepository;

    @Transactional
    public Doctor addDoctor(Doctor doctor){

        return doctorRepository.save(doctor);
    }

    @Transactional
    public Page<Doctor> getAllDoctors(Pageable pageable){

        return doctorRepository.findAll(pageable);
    }

    @Transactional
    public Doctor findById(Long id){

        if(!doctorRepository.existsById(id)){
            throw new DoctorException("Médico não encontrado com o id" + id);
        }

        return doctorRepository.findById(id).get();
    }
}

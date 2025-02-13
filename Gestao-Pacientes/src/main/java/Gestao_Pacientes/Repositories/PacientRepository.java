package Gestao_Pacientes.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import Gestao_Pacientes.Entities.Pacient;
import Gestao_Pacientes.Entities.PacientStatus;

public interface PacientRepository extends JpaRepository<Pacient,Long> {
    
    Page<Pacient> findPacientByStatus(PacientStatus pacientStatus, Pageable pageable);
}

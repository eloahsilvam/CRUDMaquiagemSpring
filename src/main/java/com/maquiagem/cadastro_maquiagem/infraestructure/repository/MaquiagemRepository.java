package com.maquiagem.cadastro_maquiagem.infraestructure.repository;

import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MaquiagemRepository extends JpaRepository<Maquiagem, Integer> {
   Optional<Maquiagem> findByMarca(String marca);

   void deleteByMarca(String marca);
}
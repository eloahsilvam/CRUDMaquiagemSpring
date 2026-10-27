package com.maquiagem.cadastro_maquiagem.infraestructure.repository;

import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MaquiagemRepository extends JpaRepository<Maquiagem, Integer> {
   List<Maquiagem> findByMarca(String marca);

   void deleteByMarca(String marca);
}
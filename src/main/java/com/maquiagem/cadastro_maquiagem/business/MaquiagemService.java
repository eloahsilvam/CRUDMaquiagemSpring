package com.maquiagem.cadastro_maquiagem.business;

import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import com.maquiagem.cadastro_maquiagem.infraestructure.repository.MaquiagemRepository;
import org.springframework.stereotype.Service;

@Service //seria o dao
public class MaquiagemService {

    private final MaquiagemRepository repository;

    public MaquiagemService(MaquiagemRepository repository) {
        this.repository = repository;
    }

    public void salvarMaquiagem(Maquiagem maquiagem) {
        repository.saveAndFlush(maquiagem);
    }

    public Maquiagem buscarMaquiagemPorMarca(String marca) {
        return repository.findByMarca(marca).orElseThrow(
                () -> new RuntimeException("Marca não encontrada")
        );
    }
}

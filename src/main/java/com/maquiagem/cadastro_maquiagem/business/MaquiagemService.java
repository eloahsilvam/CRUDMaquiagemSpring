package com.maquiagem.cadastro_maquiagem.business;

import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import com.maquiagem.cadastro_maquiagem.infraestructure.repository.MaquiagemRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

    @Transactional
    public void deletarMaquiagemPorMarca(String marca) {
        repository.deleteByMarca(marca);
    }

    public void atualizarMaquiagemPorId(Integer id, Maquiagem maquiagem) {
        Maquiagem maquiagemEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Maquiagem nao encontrada"));
        Maquiagem maquiagemAtualizada = Maquiagem.builder()
                .marca(maquiagem.getMarca() != null ? maquiagem.getMarca() :
                        maquiagemEntity.getMarca())
                .nome(maquiagem.getNome() != null ? maquiagem.getNome() :
                        maquiagemEntity.getNome())
                .id(maquiagemEntity.getId())
                .build();
        repository.saveAndFlush(maquiagemAtualizada);
    }
}
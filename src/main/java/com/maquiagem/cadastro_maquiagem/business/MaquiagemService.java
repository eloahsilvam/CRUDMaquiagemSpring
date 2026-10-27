package com.maquiagem.cadastro_maquiagem.business;

import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import com.maquiagem.cadastro_maquiagem.infraestructure.repository.MaquiagemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaquiagemService {

    private final MaquiagemRepository repository;

    public MaquiagemService(MaquiagemRepository repository) {
        this.repository = repository;
    }

    public void salvarMaquiagem(Maquiagem maquiagem) {
        repository.saveAndFlush(maquiagem);
    }

    public List<Maquiagem> buscarMaquiagemPorMarca(String marca) {
        return repository.findByMarca(marca);
    }

    @Transactional
    public void deletarMaquiagemPorMarca(String marca) {
        repository.deleteByMarca(marca);
    }

    public void atualizarMaquiagemPorId(Integer id, Maquiagem maquiagemAtualizada) {
        Maquiagem maquiagemExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Maquiagem não encontrada"));

        if (maquiagemAtualizada.getNome() != null) {
            maquiagemExistente.setNome(maquiagemAtualizada.getNome());
        }
        if (maquiagemAtualizada.getMarca() != null) {
            maquiagemExistente.setMarca(maquiagemAtualizada.getMarca());
        }
        if (maquiagemAtualizada.getCor() != null) {
            maquiagemExistente.setCor(maquiagemAtualizada.getCor());
        }
        if (maquiagemAtualizada.getPreco() != null) {
            maquiagemExistente.setPreco(maquiagemAtualizada.getPreco());
        }
        if (maquiagemAtualizada.getQuantidade() != null) {
            maquiagemExistente.setQuantidade(maquiagemAtualizada.getQuantidade());
        }

        repository.save(maquiagemExistente);
    }
}
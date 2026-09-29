package com.maquiagem.cadastro_maquiagem.controller;

import com.maquiagem.cadastro_maquiagem.business.MaquiagemService;
import com.maquiagem.cadastro_maquiagem.infraestructure.entitys.Maquiagem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/maquiagem")
public class MaquiagemController {

    private final MaquiagemService service;

    public MaquiagemController(MaquiagemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Maquiagem maquiagem) {
        service.salvarMaquiagem(maquiagem);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{marca}")
    public ResponseEntity<Maquiagem> buscarPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(service.buscarMaquiagemPorMarca(marca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPorId(@PathVariable Integer id, @RequestBody Maquiagem maquiagem) {
        service.atualizarMaquiagemPorId(id, maquiagem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{marca}")
    public ResponseEntity<Void> deletarPorMarca(@PathVariable String marca) {
        service.deletarMaquiagemPorMarca(marca);
        return ResponseEntity.noContent().build();
    }
}
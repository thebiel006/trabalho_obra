package com.exemplo.obra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exemplo.obra.dto.ConcretoDTO;
import com.exemplo.obra.dto.TijoloDTO;
import com.exemplo.obra.service.ConcretoService;
import com.exemplo.obra.service.TijoloService;

@RestController
@RequestMapping("/api/obra")
public class ObraController {

    @Autowired
    private ConcretoService concretoService;

    @Autowired
    private TijoloService tijoloService;

    // 👇 COLOCA AQUI
    @GetMapping("/teste")
    public String teste() {
        return "API funcionando!";
    }

    @PostMapping("/concreto")
    public double calcularConcreto(@RequestBody ConcretoDTO dto) {
        return concretoService.calcularVolume(dto.getArestas(), dto.getAltura());
    }

    @PostMapping("/tijolos")
    public int calcularTijolos(@RequestBody TijoloDTO dto) {
        return tijoloService.calcularQuantidade(
                dto.getArestas(),
                dto.getAlturaTijolo(),
                dto.getLarguraTijolo()
        );
    }
}
package com.Academia.project.Controller;

import com.Academia.project.DTO.ExercicioDTO;
import com.Academia.project.DTO.ExercicioListDTO;
import com.Academia.project.DTO.TreinosDTO;
import com.Academia.project.Model.ExerciciosEntity;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Repository.ExercicioRepository;
import com.Academia.project.Repository.TreinosRepository;
import com.Academia.project.Service.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Academia/Treinos")
@RequiredArgsConstructor
public class TreinosController {

    private final TreinoService treinoService;


    @GetMapping()
    public ResponseEntity<TreinosEntity> receberTreino(
            @RequestParam String nome
    ){
        TreinosEntity treino = treinoService.receberTreino(nome);
        return ResponseEntity.ok(treino);
    }

    @PostMapping("/Criar")
    public ResponseEntity<Void> criarTreino(
            @RequestBody TreinosDTO treinosDTO ) {

        treinoService.criarTreino(treinosDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/Criar/completo")
    public ResponseEntity<Void> cadastrarTreinoComExercicio(
            @RequestBody TreinosDTO treinosDTO,
            @RequestBody ExercicioListDTO exListDTO) {


        treinoService.criarTreinoComExercicio(treinosDTO, exListDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }



}

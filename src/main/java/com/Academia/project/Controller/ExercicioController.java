package com.Academia.project.Controller;

import com.Academia.project.DTO.Criar.CriarExercicioDTO;
import com.Academia.project.DTO.Retornar.RetornoExercicioDTO.ResponseExercicio;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Service.ExercicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Academia/Exercicio")
@RequiredArgsConstructor
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping("/receber")
    public ResponseEntity<List<ResponseExercicio>> receberExercicio(
            @RequestParam Treinos_Tipos tipo
            ){

        return ResponseEntity.ok(exercicioService.receberExercicio(tipo));

    }


    @PostMapping("/criar")
    public ResponseEntity<Void> criarEx(
            @RequestBody CriarExercicioDTO exDTO) {
        exercicioService.criarExercicio(exDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}

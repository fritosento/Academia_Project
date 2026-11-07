package com.Academia.project.Controller;

import com.Academia.project.DTO.Criar.CriarTreinoDTO;
import com.Academia.project.DTO.Retornar.ResponseTreino;
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
    public ResponseEntity<ResponseTreino> receberTreino(
            @RequestParam String nome
    ){

        return ResponseEntity.ok(treinoService.receberTreino(nome));
    }

    @PostMapping("/Criar")
    public ResponseEntity<Void> criarTreino(
            @RequestBody CriarTreinoDTO treinosDTO
    ) {

        treinoService.criarTreino(treinosDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/inserir")
    public ResponseEntity<Void> inserirEx(
            @RequestParam String nomeTreino,
            @RequestParam String nomeExercicio
    ){
        treinoService.adcionarExercicioEmTreino(nomeTreino, nomeExercicio);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

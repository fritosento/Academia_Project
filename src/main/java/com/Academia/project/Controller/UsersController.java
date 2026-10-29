package com.Academia.project.Controller;

import com.Academia.project.DTO.*;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Model.TreinosEntity;
import com.Academia.project.Model.UserEntity;
import com.Academia.project.Service.TreinoService;
import com.Academia.project.Service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Academia/Cliente")
@RequiredArgsConstructor
public class UsersController {

    public final UsersService usersService;
    public final TreinoService treinoService;


    @GetMapping("/perfil")
    public  ResponseEntity<ResponseClienteDTO> getUsuario(
            @RequestParam String email
            ) {
        UserEntity user = usersService.getCliente(email);
        return ResponseEntity.ok(new ResponseClienteDTO(user));
    }

    @GetMapping("/perfil/treino")
    public ResponseEntity<List<ResponseTreino_clienteDTO>> getTreinosCLientes(
            @RequestParam String email,
            @RequestParam Treinos_Tipos tipo
    ){
            return ResponseEntity.ok(treinoService.receberTreinoUser(tipo, email ));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<ResponseClienteDTO> cadastroUsuario(
            @RequestBody @Valid CriarClienteDTO clienteDTO
    ){
        usersService.save(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/Treinos/cadastrar")
    public ResponseEntity<ExercicioDTO> cadastrarTreino(
            @RequestParam String email,
            @RequestParam String nomeTreino
    ){
        usersService.cadastrarTreino_Usuario(email, nomeTreino);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

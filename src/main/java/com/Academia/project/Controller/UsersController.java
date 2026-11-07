package com.Academia.project.Controller;

import com.Academia.project.DTO.Criar.CriarClienteDTO;
import com.Academia.project.DTO.Retornar.ResponseTreino;
import com.Academia.project.DTO.Retornar.RetornoClienteDTO.ResponseCliente;
import com.Academia.project.DTO.Retornar.RetornoExercicioDTO.ResponseExercicio;
import com.Academia.project.ESTADOS.Treinos_Tipos;
import com.Academia.project.Service.TreinoService;
import com.Academia.project.Service.UsersService;
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
    public  ResponseEntity<ResponseCliente> getUsuario(
            @RequestParam String email
            ) {
        return ResponseEntity.ok(usersService.getCliente(email));
    }
    @GetMapping("/perfil/treino")
    public ResponseEntity<List<ResponseTreino>> getTreinosCLientes(
            @RequestParam String email,
            @RequestParam Treinos_Tipos tipo
    ){
            return ResponseEntity.ok(treinoService.receberTreinoUser(tipo, email ));
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastroUsuario(
            @RequestBody CriarClienteDTO clienteDTO
    ){
        usersService.criarUsuario(clienteDTO);
        usersService.ativarStatusCliente(clienteDTO.email());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/admSecreto/ativar")
    public ResponseEntity<Void> admSecretoAtivarUsuario(
            @RequestParam String email
    ){
        usersService.ativarStatusCliente(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/admSecreto/banir")
    public ResponseEntity<Void> admSecretoBanir(
            @RequestParam String email
    ){
        usersService.BanirStatusCliente(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



    @PostMapping("/Treinos/cadastrar")
    public ResponseEntity<Void> cadastrarTreino(
            @RequestParam String email,
            @RequestParam String nomeTreino
    ){
        usersService.cadastrarTreino_Usuario(email, nomeTreino);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

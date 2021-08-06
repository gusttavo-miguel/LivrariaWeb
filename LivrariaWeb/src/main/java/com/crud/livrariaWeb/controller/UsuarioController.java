package com.crud.livrariaWeb.controller;

import com.crud.livrariaWeb.model.Funcionarios;
import com.crud.livrariaWeb.repository.UsuarioRepository;
import com.crud.livrariaWeb.service.UsuarioRelatorio;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRelatorio usuarioRelatorio;

    @PostMapping
    public Funcionarios usuarioCadastro(@RequestBody Funcionarios funcionarios) {

        LocalDateTime data = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        funcionarios.setDataCadastro(data.format(formatter));
        usuarioRepository.save(funcionarios);
        return funcionarios;

    }
        /*if (usuariosModel.getPerfil() == "A" || usuariosModel.getPerfil() == "O") {

            if (usuariosModel.getStatus() == "A" || usuariosModel.getStatus() == "C") {
                LocalDateTime data = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                usuariosModel.setDataCadastro(data.format(formatter));
                usuarioRepository.save(usuariosModel);
                return usuariosModel;
            } else {
                return usuariosModel;
            }
        } else {
            return usuariosModel;
        }*/

    //---------------------------------------------------------------------------------------------

    @GetMapping(path = "/buscar/id/{id}")
    public ResponseEntity consultarId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    //---------------------------------------------------------------------------------------------

    @GetMapping(path = "/buscar/nome/{nome}")
    public Funcionarios consultarNome(@PathVariable("nome") String nome) {
        return usuarioRepository.findByNome(nome);
    }
    //---------------------------------------------------------------------------------------------

    @GetMapping(path = "/buscar/email/{email}")
    public Funcionarios pesquisaEmail(@PathVariable("email") String email) {
        return usuarioRepository.findByEmail(email);
    }
    //---------------------------------------------------------------------------------------------

    @GetMapping(path = "/buscar/todos")
    public List<Funcionarios> consultar() {
        return usuarioRepository.findAll();
    }
    //---------------------------------------------------------------------------------------------

    @DeleteMapping(path = "/delete")
    public void deletaUsuario(@RequestBody Funcionarios usuario) {
        usuarioRepository.delete(usuario);
    }
    //---------------------------------------------------------------------------------------------

    @PutMapping
    public Funcionarios updateUsuario(@RequestBody Funcionarios usuario) {
        return usuarioRepository.save(usuario);
    }
    //---------------------------------------------------------------------------------------------

    @GetMapping("/login")
    public String login(@RequestBody Funcionarios usuario) {
        Funcionarios login = usuarioRepository.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
        if (login != null) {
            if (login.getStatus().equals("A")) {
                return "logado com sucesso";
            } else {
                return "Usuario inativo";
            }
        } else {
            return "Usuario não encontrado";
        }
    }

    //---------------------------------------------------------------------------------------------

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return usuarioRelatorio.exportReport(format);
    }
}
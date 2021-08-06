//package com.crud.livrariaWeb.controller;
//
//import com.crud.livrariaWeb.model.Cliente;
//import com.crud.livrariaWeb.model.Venda;
//import com.crud.livrariaWeb.repository.VendaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "/Venda")
//public class VendaController {
//
//    @Autowired
//    private VendaRepository vendaRepository;
//
//    private String formatter;
//    private Optional<Cliente> idCliente;
//
//
//    @PostMapping (value = "/inserir")
//    public Venda LivroCaixa (@RequestBody Venda venda) {
//
//        if (venda.getTipo() == 'D' || venda.getTipo() == 'C') {
//            LocalDateTime data = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//            venda.setDataLancamento(data.format(formatter));
//            vendaRepository.save(venda);
//
//            return venda;
//
//        } else {
//
//            return null;
//        }
//    }
//    @GetMapping(path = "/buscar/todos")
//    public List<Venda> consultar() {
//        return vendaRepository.findAll();
//    }
//
//    @GetMapping(path = "/buscar/id/{id}")
//    public Venda consultarId(@PathVariable("id") int id) {
//        return  vendaRepository.findById(id);
//    }
//
//    @GetMapping(path = "/buscar/idCliente/{idCliente}")
//    public List <Venda> consultarIdCliente (@PathVariable("idCliente") int idCliente ) {
//        return vendaRepository.findByCliente(idCliente);
//    }
//
//    @DeleteMapping(path = "/delete")
//    public void deletaCliente (@RequestBody Venda venda) {
//        vendaRepository.delete(venda);
//    }
//
//    @PutMapping(path = "/update")
//    public Venda updateLivro (@RequestBody Venda venda) {
//        return (Venda) vendaRepository.save(venda);
//    }
//
//}
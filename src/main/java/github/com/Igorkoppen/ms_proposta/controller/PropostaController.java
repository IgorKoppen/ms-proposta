package github.com.Igorkoppen.ms_proposta.controller;


import github.com.Igorkoppen.ms_proposta.dto.PropostaInfoDTO;
import github.com.Igorkoppen.ms_proposta.dto.PropostaCadastroDTO;
import github.com.Igorkoppen.ms_proposta.service.PropostaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;


    @GetMapping
    public ResponseEntity<List<PropostaInfoDTO>> findAll() {
        List<PropostaInfoDTO> propostas = propostaService.findAll();
        return ResponseEntity.ok(propostas);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PropostaInfoDTO> findById(@PathVariable @NotNull Long id){
        PropostaInfoDTO propostaInfoDTO = propostaService.findById(id);
        return ResponseEntity.ok(propostaInfoDTO);
    }
    @PostMapping
    private ResponseEntity<PropostaCadastroDTO> insert(@RequestBody @Valid PropostaCadastroDTO propostaInsertDTO){
        propostaInsertDTO = propostaService.insert(propostaInsertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(propostaInsertDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(propostaInsertDTO);
    }
}

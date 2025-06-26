package br.com.ifpe.oxefood.api.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.comprador.SegmentoComprador;
import br.com.ifpe.oxefood.modelo.comprador.SegmentoCompradorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/segmentocomprador")
@CrossOrigin
public class SegmentoCompradorController {

    @Autowired
    private SegmentoCompradorService segmentoCompradorService;

    @PostMapping
    public ResponseEntity<SegmentoComprador> save(@RequestBody @Valid SegmentoCompradorRequest request) {

        SegmentoComprador segmentoCompradorNovo = request.build();
        SegmentoComprador segmentoComprador = segmentoCompradorService.save(segmentoCompradorNovo);
        return new ResponseEntity<SegmentoComprador>(segmentoComprador, HttpStatus.CREATED);
    }

    @GetMapping
    public List<SegmentoComprador> listarTodos() {
  
       return segmentoCompradorService.listarTodos();
    }

    @GetMapping("/{id}")
    public SegmentoComprador obterPorID(@PathVariable Long id) {

       return segmentoCompradorService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SegmentoComprador> update(@PathVariable("id") Long id, @RequestBody SegmentoCompradorRequest request) {

        segmentoCompradorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        segmentoCompradorService.delete(id);
        return ResponseEntity.ok().build();
    }
}

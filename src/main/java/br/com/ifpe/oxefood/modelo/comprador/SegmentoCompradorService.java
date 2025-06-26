package br.com.ifpe.oxefood.modelo.comprador;
import org.springframework.stereotype.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;

@Service
public class SegmentoCompradorService {
    @Autowired
    private SegmentoCompradorRepository repository;

    @Transactional
    public SegmentoComprador save(SegmentoComprador segmentoComprador) {
        segmentoComprador.setHabilitado(Boolean.TRUE);
        return repository.save(segmentoComprador);
    }

    public List<SegmentoComprador> listarTodos(){
        return repository.findAll();
    }
    public SegmentoComprador obterPorID(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("segmentoComprador não encontrada com o ID: " + id));
    }

    @Transactional
    public void update(Long id, SegmentoComprador segmentoCompradorAlterada) {
        SegmentoComprador segmentoComprador = repository.findById(id).get();
        segmentoComprador.setDescricao(segmentoCompradorAlterada.getDescricao());
        repository.save(segmentoComprador);
    }
    @Transactional
    public void delete(Long id) {
        SegmentoComprador segmentoComprador = repository.findById(id).get();
        segmentoComprador.setHabilitado(Boolean.FALSE);
        repository.save(segmentoComprador);

}
}

package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.exception.ProdutoException;
import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto)  {
        if (produto.getValorUnitario() < 20 || produto.getValorUnitario() > 100) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_E_MAXIMO);
        }

        produto.setHabilitado(Boolean.TRUE);
        return repository.save(produto);
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {

        Produto produto = repository.findById(id).get();
        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());

        repository.save(produto);
    }

    public Produto obterPorID(Long id) {
        return repository.findById(id).get();
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public void delete(Long id) {

        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
    }

}

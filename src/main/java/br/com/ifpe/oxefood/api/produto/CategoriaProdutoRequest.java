package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.CategoriaProduto;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

    @Max(value = 200, message = "A descrição deve ter no máximo {value} caracteres")
    private String descricao;

    public CategoriaProduto build() {

        return CategoriaProduto.builder()
            .descricao(descricao)
            .build();
    }
    
}
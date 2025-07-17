package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotNull(message = "A Categoria é de preenchimento obrigatório")
    private Long idCategoria;

    @NotNull(message = "O Código é de preenchimento obrigatório")
    private String codigo;

    @NotNull(message = "O Título é de preenchimento obrigatório")
    private String titulo;

    @Size(max = 500, message = "A Descrição deve ter no máximo {value} caracteres")
    private String descricao;

    @Min(value = 5, message = "O Valor Unitário não pode ser menor que {value}")
    private Double valorUnitario;

    @Min(value = 5, message = "O Tempo de Entrega Mínimo deve ser pelo menos {value} minuto(s)")
    private Integer tempoEntregaMinimo;

    @Min(value = 15, message = "O Tempo de Entrega Máximo deve ser pelo menos {value} minuto(s)")
    private Integer tempoEntregaMaximo;

    public Produto build() {
        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }
}

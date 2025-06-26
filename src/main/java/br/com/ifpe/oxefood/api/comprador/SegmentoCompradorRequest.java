package br.com.ifpe.oxefood.api.comprador;

import br.com.ifpe.oxefood.modelo.comprador.SegmentoComprador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SegmentoCompradorRequest {
    private String descricao;

    public SegmentoComprador build(){
        return SegmentoComprador.builder()
            .descricao(descricao)
            .build();
    }
}

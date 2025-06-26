package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   @NotEmpty(message = "O Nome é de preenchimento obrigatório")
   private String nome;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   @CPF
   private String cpf;

   @NotEmpty(message = "O RG é de preenchimento obrigatório")
   private String rg;
   @Min(value = 0, message = "A quantidade de entregas realizadas não pode ser negativa")
   private Integer qtdEntregasRealizadas;
   @Min(value = 1, message = "O valor do frete não pode ser menor que {value}")
   private Double valorFrete;
   @Length(max = 200, message = "O endereço deve ter no máximo {max} caracteres")
   private String enderecoRua;
   @Min(value = 1, message = "O número do endereço deve ser pelo menos {value}")
   private String enderecoNumero;
   @Length(max = 100, message = "O bairro deve ter no máximo {max} caracteres")
   private String enderecoBairro;
   @Length(max = 100, message = "A cidade deve ter no máximo {max} caracteres")
   private String enderecoCidade;
   @Length(max = 2, message = "A UF deve ter no máximo {max} caracteres")
   private String enderecoUf;
   @Length(max = 10, message = "O CEP deve ter no máximo {max} caracteres")
   private String enderecoCep;
   @Length(max = 100, message = "O complemento do endereço deve ter no máximo {max} caracteres")
   private String enderecoComplemento;
   @Length(min = 8, max = 20, message = "O celular deve ter entre {min} e {max} caracteres")
   private String foneCelular;
   private String foneFixo;
   private Boolean ativo;

   public Entregador build() {
      return Entregador.builder()
            .nome(nome)
            .dataNascimento(dataNascimento)
            .cpf(cpf)
            .rg(rg)
            .qtdEntregasRealizadas(qtdEntregasRealizadas)
            .valorFrete(valorFrete)
            .enderecoRua(enderecoRua)
            .enderecoNumero(enderecoNumero)
            .enderecoBairro(enderecoBairro)
            .enderecoCidade(enderecoCidade)
            .enderecoUf(enderecoUf)
            .enderecoCep(enderecoCep)
            .enderecoComplemento(enderecoComplemento)
            .foneCelular(foneCelular)
            .foneFixo(foneFixo)
            .ativo(ativo)
            .build();

   }
}

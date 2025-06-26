package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(unique=true, nullable = false, length = 10)
    private String rg;

    @Column(nullable = false)
    private Integer qtdEntregasRealizadas;

    @Column(nullable = false)
    private Double valorFrete;

    @Column(nullable = false, length = 200)
    private String enderecoRua;

    @Column(nullable = false, length = 10)
    private String enderecoNumero;

    @Column(nullable = false, length = 100)
    private String enderecoBairro;

    @Column(nullable = false, length = 100)
    private String enderecoCidade;

    @Column(nullable = false, length = 2)
    private String enderecoUf;

    @Column(nullable = false, length = 10)
    private String enderecoCep;

    @Column(nullable = false, length = 100)
    private String enderecoComplemento;

    @Column(nullable = false, length = 20)
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Boolean ativo;

}

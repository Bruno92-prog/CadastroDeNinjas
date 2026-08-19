package batismojavaNinja.cadastroDeNinjas.Ninjas;

import batismojavaNinja.cadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// Entity ele transforma uma classe em uma entidade do Banco de Dados
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    private int idade;

    // @ManyToOne muitos pra um, um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name ="missoes_id") // Foreing Key ou chave estrangeira
    private MissoesModel missoes;
}

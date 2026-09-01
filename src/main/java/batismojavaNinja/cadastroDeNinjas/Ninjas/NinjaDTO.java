package batismojavaNinja.cadastroDeNinjas.Ninjas;

import batismojavaNinja.cadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private int idade;

    private MissoesModel missoes;

    // Resolvendo o problema do rank pois a classe é um clone da classe de entidade

    private String rank_ninja;

}

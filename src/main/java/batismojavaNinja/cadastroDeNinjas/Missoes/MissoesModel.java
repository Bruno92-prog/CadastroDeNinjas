package batismojavaNinja.cadastroDeNinjas.Missoes;

import batismojavaNinja.cadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private String rank;
    private String localDaMissao;

    // @OneToMany - um pra muitos , uma missao pode ter varios ninjas
    @OneToMany(mappedBy = "missoes")
    List<NinjaModel> ninjasNaMissao = new ArrayList<>();

    // Construtores


    public MissoesModel() {
    }

    public MissoesModel(Long id, String nomeDaMissao, String rank, String localDaMissao, NinjaModel ninja) {
        this.id = id;
        this.nomeDaMissao = nomeDaMissao;
        this.rank = rank;
        this.localDaMissao = localDaMissao;
        ninjasNaMissao.add(ninja);
    }

    //Getters e Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getLocalDaMissao() {
        return localDaMissao;
    }

    public void setLocalDaMissao(String localDaMissao) {
        this.localDaMissao = localDaMissao;
    }

    public List<NinjaModel> getNinjasNaMissao() {
        return ninjasNaMissao;
    }

    public void setNinjasNaMissao(List<NinjaModel> ninjasNaMissao) {
        this.ninjasNaMissao = ninjasNaMissao;
    }
}

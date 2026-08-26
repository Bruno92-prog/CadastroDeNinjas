package batismojavaNinja.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("missoes")
public class MissoesController {

    // GET -- Mandar uma requisição para mostrar as missoes
    @GetMapping("/listar")
    public String ListarMissoes(){
        return "Missoes listadas com sucesso";
    }

    // Post -- Mandar uma requisição para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    // PUT -- Mandar uma requisição para alterar uma missao
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }

    // Delete -- Mandar uma requisição para deletar uma missoa
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}

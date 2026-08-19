package batismojavaNinja.cadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class MissoesController {
    @GetMapping("/olaMissoes")
    public String olaMissoes(){
        return "Essa é minha primeira menssagem nesta rota!";
    }
}

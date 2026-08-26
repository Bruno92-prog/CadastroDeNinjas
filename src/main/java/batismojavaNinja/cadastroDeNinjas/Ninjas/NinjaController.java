package batismojavaNinja.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/ninjas")

public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira menssagem nesta rota!";
    }

    // adicionar ninja (create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
    }

    // mostar todos os ninjas (read)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }

    // mostrar ninjas por id (read)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }


    // alterar dados dos ninjas (update)
    @PutMapping("/alterarID")
    public String alterarNinjasPorId(){
        return "Alterar Ninja por ID";
    }

    // deletar ninja (delete)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninja por ID";
    }
}

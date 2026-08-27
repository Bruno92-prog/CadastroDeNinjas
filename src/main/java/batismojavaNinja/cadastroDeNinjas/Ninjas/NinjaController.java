package batismojavaNinja.cadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninjas")

public class NinjaController {

    // injetando dependecia de NinjaService
    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


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
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // mostrar ninjas por id (read)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
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

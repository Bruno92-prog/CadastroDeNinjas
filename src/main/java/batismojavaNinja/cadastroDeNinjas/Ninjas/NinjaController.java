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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    // mostar todos os ninjas (read)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.listarNinjas();
    }

    // mostrar ninjas por id (read)
    @GetMapping("/listar/{id}")
    public NinjaDTO listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }


    // alterar dados dos ninjas (update)
    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        return ninjaService.atualizarNinja(id,ninjaAtualizado);
    }

    // deletar ninja (delete)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable  Long id)
    {
        ninjaService.deletarNinjaPorId(id);
    }


}

package batismojavaNinja.cadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/ninjas")

public class NinjaController {

    // injetando dependecia de NinjaService
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas",description = "Essa rota da uma menssagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa é minha primeira menssagem nesta rota!";
    }

    // adicionar ninja (create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja",description = "Essa rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: "+ novoNinja.getNome()+" (ID): "+novoNinja.getId());
    }

    // mostar todos os ninjas (read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // mostrar ninjas por id (read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID",description = "Essa rota lista um ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if( ninja != null) {
           return ResponseEntity.ok("Ninja encontrado: "+ ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: "+id+" Não encontrado em nossos registros!");
        }
    }


    // alterar dados dos ninjas (update)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por ID",description = "Essa rota altera os dados de um ninja por seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado, não foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjasPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja =  ninjaService.atualizarNinja(id,ninjaAtualizado);
        if(ninja != null){
            return ResponseEntity.ok(ninja);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("\"Ninja com id: \"+id+\" Não encontrado em nossos registros!");
        }
    }

    // deletar ninja (delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable  Long id)
    {
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com ID "+ id+" deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com id "+id+" não encontrado!");
        }
    }


}

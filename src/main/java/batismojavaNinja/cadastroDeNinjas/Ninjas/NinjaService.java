package batismojavaNinja.cadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    // TODO CODIGO ABAIXO É O ORIGINAL DO SERVICE ANTES DE SER FEITO O DTO E MAPPER

    /*
    @Autowired
    private NinjaRepository ninjaRepository;

    // Listar todos os meus ninjas

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar ninjas por id
    public NinjaModel listarNinjasPorId(Long id){
        Optional <NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }

    // CRIAR UM NOVO NINJA
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // Deletar o ninja
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar um  ninja
    public NinjaModel atualizarNinja(Long id,NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }


     */

    // depois com DTO e MAPPER

    @Autowired
    private NinjaRepository ninjaRepository;

    //Criando mapper e construtor
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas

    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    // Listar ninjas por id
    public NinjaDTO listarNinjasPorId(Long id){
        Optional <NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    // CRIAR UM NOVO NINJA
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja =  ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);

    }

    // Deletar o ninja
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar um  ninja
    public NinjaDTO atualizarNinja(Long id,NinjaDTO ninjaDTO){
       Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
       if (ninjaExistente.isPresent()){
           NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
           ninjaAtualizado.setId(id);
           NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
           return ninjaMapper.map(ninjaSalvo);
       }
       return null;

    }

}

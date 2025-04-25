package JonatasFreire.Services;

import JonatasFreire.Models.Time;
import JonatasFreire.Repositories.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    // Criar novo time
    public Time criar(Time time) {
        return timeRepository.save(time);
    }

    // Listar todos os times
    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    // Buscar um time por ID
    public Optional<Time> buscarPorId(Long id) {
        return timeRepository.findById(id);
    }

    // Atualizar time existente
    public Time atualizar(Long id, Time novoTime) {
        Optional<Time> timeOptional = timeRepository.findById(id);
        if (timeOptional.isPresent()) {
            Time existente = timeOptional.get();
            existente.setNome(novoTime.getNome());
            return timeRepository.save(existente);
        } else {
            return null;
        }
    }

    // Deletar time
    public void deletar(Long id) {
        timeRepository.deleteById(id);
    }
}

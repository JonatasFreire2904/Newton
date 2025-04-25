package JonatasFreire.Controllers;

import JonatasFreire.Models.Time;
import JonatasFreire.Services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    // Listar todos os times
    @GetMapping
    public List<Time> listarTimes() {
        return timeService.listarTodos();
    }

    // Criar novo time
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Time criarTime(@RequestBody Time time) {
        return timeService.criar(time);
    }

    // Buscar time por ID
    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        Optional<Time> time = timeService.buscarPorId(id);
        return time.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar time
    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizarTime(@PathVariable Long id, @RequestBody Time novoTime) {
        Time atualizado = timeService.atualizar(id, novoTime);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar time por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTime(@PathVariable Long id) {
        timeService.deletar(id);
    }
}

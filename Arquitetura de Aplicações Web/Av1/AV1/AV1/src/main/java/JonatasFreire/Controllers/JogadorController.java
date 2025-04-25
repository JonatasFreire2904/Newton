package JonatasFreire.Controllers;

import JonatasFreire.Models.Jogador;
import JonatasFreire.Services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    // Listar todos os jogadores
    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorService.listarTodos();
    }

    // Criar novo jogador
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.criar(jogador);
    }

    // Buscar jogador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(jogador -> ResponseEntity.ok(jogador))
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar jogador
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador novoJogador) {
        Jogador atualizado = jogadorService.atualizar(id, novoJogador);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar jogador por ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Long id) {
        jogadorService.deletarPorId(id);
    }

}

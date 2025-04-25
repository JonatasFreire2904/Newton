package JonatasFreire.Services;

import JonatasFreire.Models.Jogador;
import JonatasFreire.Repositories.JogadorReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorReposiroty jogadorRepository;

    // Listar todos os jogadores
    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    // Criar novo jogador
    public Jogador criar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    // Buscar jogador por ID
    public Optional<Jogador> buscarPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    // Atualizar jogador
    public Jogador atualizar(Long id, Jogador novoJogador) {
        Optional<Jogador> optionalJogador = jogadorRepository.findById(id);
        if (optionalJogador.isPresent()) {
            Jogador existente = optionalJogador.get();
            existente.setNome(novoJogador.getNome());
            existente.setPosicao(novoJogador.getPosicao());
            existente.setIdade(novoJogador.getIdade());
            existente.setTime(novoJogador.getTime());
            return jogadorRepository.save(existente);
        } else {
            return null;
        }
    }

    // Deletar jogador por objeto
    public void deletar(Jogador jogador) {
        jogadorRepository.delete(jogador);
    }

    // Deletar jogador por ID
    public void deletarPorId(Long id) {
        jogadorRepository.deleteById(id);
    }
}

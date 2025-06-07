package com.example.demo.controller;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.tarefas.controller.UsuarioController;
import com.example.tarefas.model.Usuario;
import com.example.tarefas.service.UsuarioService;

class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listar_RetornaListaDeUsuarios() {
        List<Usuario> usuarios = Arrays.asList(new Usuario(), new Usuario());
        when(usuarioService.listar()).thenReturn(usuarios);

        List<Usuario> resultado = usuarioController.listar();

        assertEquals(2, resultado.size());
        verify(usuarioService, times(1)).listar();
    }

    @Test
    void criar_RetornaUsuarioCriado() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setEmail("joao@example.com");
        when(usuarioService.criar(any(Usuario.class))).thenReturn(usuario);

        Usuario resultado = usuarioController.criar(usuario);

        assertEquals("João", resultado.getNome());
        verify(usuarioService, times(1)).criar(any(Usuario.class));
    }

    @Test
    void atualizar_RetornaUsuarioAtualizado() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setEmail("maria@example.com");
        when(usuarioService.atualizar(id, usuario)).thenReturn(usuario);

        Usuario resultado = usuarioController.atualizar(id, usuario);

        assertEquals("Maria", resultado.getNome());
        verify(usuarioService, times(1)).atualizar(id, usuario);
    }

    @Test
    void excluir_RetornaNoContent() {
        Long id = 1L;
        doNothing().when(usuarioService).excluir(id);

        ResponseEntity<Void> resposta = usuarioController.excluir(id);

        assertEquals(HttpStatus.NO_CONTENT, resposta.getStatusCode());
        verify(usuarioService, times(1)).excluir(id);
    }
}

package com.example.tarefas.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity // Para bancos relacionais
@Document(collection = "tarefas") // Para MongoDB
public class tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para bancos relacionais
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String titulo;

    @Size(max = 500)
    private String descricao;

    @NotNull
    private String status; // Ex.: "Em andamento", "Concluído"

    private LocalDateTime dataCriacao;
}

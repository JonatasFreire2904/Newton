CREATE TABLE time (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE jogador (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    posicao VARCHAR(255),
    idade INT,
    time_id BIGINT,
    CONSTRAINT fk_jogador_time FOREIGN KEY (time_id) REFERENCES time(id)
);

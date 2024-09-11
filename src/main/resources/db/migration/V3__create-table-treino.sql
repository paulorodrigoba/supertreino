CREATE TABLE treino (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_treino VARCHAR(255) NOT NULL,
    repeticoes INT NOT NULL,
    carga DOUBLE NOT NULL
);

CREATE TABLE treino_exercicio (
    treino_id BIGINT NOT NULL,
    exercicio_id BIGINT NOT NULL,
    PRIMARY KEY (treino_id, exercicio_id),
    FOREIGN KEY (treino_id) REFERENCES treino(id),
    FOREIGN KEY (exercicio_id) REFERENCES exercicio_musculacao(id)
);
CREATE TABLE ficha_treino (
    id BIGINT AUTO_INCREMENT PRIMARY KEY
);
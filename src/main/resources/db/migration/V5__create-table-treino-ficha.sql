
CREATE TABLE treino_exercicio (
    treino_id BIGINT NOT NULL,
    exercicio_id BIGINT NOT NULL,
    PRIMARY KEY (treino_id, exercicio_id),
    FOREIGN KEY (treino_id) REFERENCES treino(id),
    FOREIGN KEY (exercicio_id) REFERENCES exercicio_musculacao(id)
);

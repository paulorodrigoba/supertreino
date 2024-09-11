ALTER TABLE treino ADD COLUMN ficha_treino_id BIGINT;
ALTER TABLE treino ADD CONSTRAINT FK_ficha_treino
    FOREIGN KEY (ficha_treino_id)
    REFERENCES ficha_treino(id);
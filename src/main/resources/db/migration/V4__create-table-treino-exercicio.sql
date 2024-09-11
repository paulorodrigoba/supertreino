CREATE TABLE treino (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_treino VARCHAR(255) NOT NULL,
    repeticoes INT NOT NULL,
    carga DOUBLE NOT NULL
);

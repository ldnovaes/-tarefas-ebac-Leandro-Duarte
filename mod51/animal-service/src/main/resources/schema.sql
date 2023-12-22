CREATE TABLE animal (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_provisorio VARCHAR(255) NOT NULL,
    idade_estimada INT NOT NULL,
    data_entrada DATE NOT NULL,
    data_adocao DATE,
    condicoes_chegada VARCHAR(255) NOT NULL,
    nome_recebedor VARCHAR(255) NOT NULL,
    data_obito DATE,
    porte VARCHAR(50),
    tipo_animal VARCHAR(50) NOT NULL,
    raca VARCHAR(100),
    cor_pelagem VARCHAR(100)
);


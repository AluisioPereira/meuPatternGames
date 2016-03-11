CREATE TABLE CLIENTE(
	id serial,
	nome VARCHAR(50) NOT NULL UNIQUE,
	cpf VARCHAR(15) NOT NULL UNIQUE,
	email VARCHAR(60) NOT NULL UNIQUE,
	PRIMARY KEY(id)

);
CREATE TABLE JOGO(
	id serial,
	nome VARCHAR(40) NOT NULL UNIQUE, 
	estado VARCHAR(10) NOT NULL, 
	PRIMARY KEY(id)
);
CREATE TABLE LOCACAO(
	id serial,
	idcliente INTEGER NOT NULL,
	idjogo INTEGER NOT NULL,
	datalocacao DATE,
	datadevolucao DATE,
	tipo VARCHAR(9),
	PRIMARY KEY(id),
	FOREIGN KEY(idcliente) REFERENCES CLIENTE (id), 
	FOREIGN KEY(idjogo) REFERENCES JOGO(id)
);
CREATE TABLE MULTA(
	idcliente INTEGER NOT NULL,
        multa DOUBLE PRECISION NOT NULL,
       PRIMARY KEY(idcliente,multa)
);
CREATE TABLE RESERVARJOGO(
         id serial,
        emailCliente VARCHAR(60) NOT NULL,
	nomejogo VARCHAR(40) NOT NULL,
        PRIMARY KEY(id),
	FOREIGN KEY(emailCliente) REFERENCES CLIENTE (email), 
	FOREIGN KEY(nomejogo) REFERENCES JOGO(nome)

)

CREATE TABLE cartas(
	id serial PRIMARY KEY,
	nome varchar(60),
	descricao varchar(200),
	ataque smallint,
	defesa smallint,
	tipo varchar(15),
	classe varchar(15)
);
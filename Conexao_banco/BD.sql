CREATE TABLE Socio(
	pk_cpf_s INT PRIMARY KEY,
	nome_s TEXT,
	data_adm DATE
);

CREATE TABLE Dependente(
	pk_id INT,
	nome_d TEXT,
	idade INT,
	fk_cpf_s INT REFERENCES Socio(pk_cpf_s),
	PRIMARY KEY(pk_id, fk_cpf_s)
);
CREATE TABLE consulta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    medico_crm VARCHAR(255) NOT NULL,
    paciente_cpf VARCHAR(255) NOT NULL,
    data DATETIME NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_consultas_medico_crm FOREIGN KEY (medico_crm) REFERENCES medicos(crm),
    CONSTRAINT fk_consultas_paciente_cpf FOREIGN KEY (paciente_cpf) REFERENCES pacientes(cpf)
);
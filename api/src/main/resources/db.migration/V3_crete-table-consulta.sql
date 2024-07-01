create table consulta(

    id bigint not null auto_increment,
    medico_crm bigint not null,
    paciente_cpf bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_consultas_medico_crm foreign key(medico_crm) references medicos(crm),
    constraint fk_consultas_paciente_cpf foreign key(paciente_cpf) references pacientes(cpf)

);
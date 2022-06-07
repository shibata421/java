INSERT INTO USUARIO(nome, email, senha) 
VALUES 
	('Aluno', 'aluno@email.com', '$2a$10$HcoYtM/HONzCtph/H3t5Iu.sliut4ow882AdH8YszYO71uCO.Wahm'), 
	('Moderador', 'moderador@email.com', '$2a$10$HcoYtM/HONzCtph/H3t5Iu.sliut4ow882AdH8YszYO71uCO.Wahm');

INSERT INTO PERFIL(nome) 
VALUES 
	('ROLE_ALUNO'), 
	('ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id)
VALUES 
	(1, 1),
	(2, 2);
	
INSERT INTO CURSO(nome, categoria) 
VALUES
	('Spring Boot', 'Programação'), 
	('HTML 5', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id) 
VALUES
	('Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1),
	('Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1),
	('Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);
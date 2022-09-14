INSERT INTO usuario(nome, email, senha) VALUES ('Aluno', 'aluno@email.com', '$2a$10$VZD0YfOeyiGs9W/B62mrqeXUL.WonN.cIBVfNLdzHF.9nBEp9/vEe');
INSERT INTO usuario(nome, email, senha) VALUES ('Moderador', 'moderador@email.com', '$2a$10$VZD0YfOeyiGs9W/B62mrqeXUL.WonN.cIBVfNLdzHF.9nBEp9/vEe');

INSERT INTO perfil(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO perfil(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO usuario_perfis(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO usuario_perfis(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO CURSO(nome, categoria) VALUES('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES('HTML 5', 'Fron-end');

INSERT INTO topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida', 'Erro ao criar projeto', '2021-06-13 17:45','NAO_RESPONDIDO',1,1);
INSERT INTO topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 2', 'Projeto não compila', '2021-07-19 08:34','NAO_SOLUCIONADO',1,1);
INSERT INTO topico(titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES ('Dúvida 3', 'Tag HTML', '2021-05-05 20:00','NAO_SOLUCIONADO',1,2);
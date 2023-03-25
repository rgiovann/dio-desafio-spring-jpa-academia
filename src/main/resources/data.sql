INSERT INTO tb_aluno (nome, email, cpf, data_nascimento) VALUES ('Alex dos Santos', 'alexdosSantos@gmail.com', '652.601.989-72',TIMESTAMP WITH TIME ZONE '1967-07-13T20:50:07.12345Z');
INSERT INTO tb_aluno (nome, email, cpf, data_nascimento) VALUES ('Maria Alaide De Carvalho', 'MA_Carvalho@yahoo.com', '644.601.989-22',TIMESTAMP WITH TIME ZONE '1987-11-23T19:50:07.12234Z');
INSERT INTO tb_aluno (nome, email, cpf, data_nascimento) VALUES ('Vittorio Capuccino', 'vcapuccino1980@gmail.com', '123.342.989-52',TIMESTAMP WITH TIME ZONE '1980-08-13T18:50:07.12300Z');
INSERT INTO tb_aluno (nome, email, cpf, data_nascimento) VALUES ('Andreia da Silva Roxo', 'asilvar@gmail.com', '122.601.944-32',TIMESTAMP WITH TIME ZONE '1987-11-03T21:50:07.00345Z');


INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.78,TIMESTAMP WITH TIME ZONE '2022-11-03T17:20:07.00345Z',1,80.2,1);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.58,TIMESTAMP WITH TIME ZONE '2022-11-03T20:51:07.00345Z',2,60.2,2);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.80,TIMESTAMP WITH TIME ZONE '2023-02-13T18:12:07.00345Z',1,82.2,1);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.58,TIMESTAMP WITH TIME ZONE '2023-03-20T08:45:07.00345Z',2,58.7,1);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.90,TIMESTAMP WITH TIME ZONE '2022-03-24T07:33:07.00345Z',0,85.4,1);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.71,TIMESTAMP WITH TIME ZONE '2022-08-03T16:32:07.00345Z',0,70.2,4);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.67,TIMESTAMP WITH TIME ZONE '2022-11-03T18:11:07.00345Z',2,80.2,3);
INSERT INTO tb_avaliacao (altura_atual, data_avaliacao, objetivo_aluno, peso_atual,aluno_id ) VALUES ( 1.67,TIMESTAMP WITH TIME ZONE '2023-03-09T21:20:07.00345Z',2,85.2,3);


INSERT INTO tb_endereco (bairro, cep, cidade, endereco,estado,aluno_id) VALUES ( 'Ponta Aguda','89060-100','Blumenau','Rua República Argentina, 580 apto 29',24,1);
INSERT INTO tb_endereco (bairro, cep, cidade, endereco,estado,aluno_id) VALUES ( 'Velha','889200-100','Blumenau','Rua 2 de Setembro, 1234',24,2);
INSERT INTO tb_endereco (bairro, cep, cidade, endereco,estado,aluno_id) VALUES ( 'Alto Gaspar','88050-200','Gaspar','Rua Solimões, 320',24,3);
INSERT INTO tb_endereco (bairro, cep, cidade, endereco,estado,aluno_id) VALUES ( 'Beira Rio','90060-100','Porto Alegre','Rua Nonato dos Santos',21,4);


INSERT INTO tb_matricula (data_matricula, situacao_matricula,tipo_pagamento, aluno_id,created_at) VALUES ( TIMESTAMP WITH TIME ZONE '2022-08-04T21:50:07.00345Z',1,0,1,NOW());
INSERT INTO tb_matricula (data_matricula, situacao_matricula,tipo_pagamento, aluno_id,created_at) VALUES ( TIMESTAMP WITH TIME ZONE '2022-10-16T12:50:07.00345Z',2,2,2,NOW());
INSERT INTO tb_matricula (data_matricula, situacao_matricula,tipo_pagamento, aluno_id,created_at) VALUES ( TIMESTAMP WITH TIME ZONE '2022-04-16T12:18:07.00345Z',0,3,3,NOW());
INSERT INTO tb_matricula (data_matricula, situacao_matricula,tipo_pagamento, aluno_id,created_at) VALUES ( TIMESTAMP WITH TIME ZONE '2023-01-19T12:13:23.00345Z',2,1,4,NOW());



INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4798565432',1,1  );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4799595632',0,1  );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4789762238',1,2  );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4792348845',0,2 );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('473228532',3,2 );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4798565432',1,3  );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4798500432',1,4 );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4798568923',2,4 );
INSERT INTO tb_telefone (nr_telefone, tipo_telefone,aluno_id) VALUES ('4793565432',0,4 );



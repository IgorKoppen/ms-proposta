
INSERT INTO tb_user (nome, sobrenome, cpf, telefone, renda) VALUES ('João', 'Silva', '123.456.789-00', '11987654321', 3500.00);
INSERT INTO tb_user (nome, sobrenome, cpf, telefone, renda) VALUES ('Maria', 'Oliveira', '987.654.321-00', '21987654321', 4500.00);
INSERT INTO tb_user (nome, sobrenome, cpf, telefone, renda) VALUES ('Pedro', 'Souza', '111.222.333-44', '31987654321', 5500.00);


INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (10000.00, 24, true, 1);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (5000.00, 12, false, 1);


INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (15000.00, 36, false, 2);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (8000.00, 18, true, 2);


INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (20000.00, 48, true, 3);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES (12000.00, 24, false, 3);
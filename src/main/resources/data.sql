USE biblioteca;

-- Inserir  livros
INSERT INTO livro (livro_titulo, autor, ano_publicacao) VALUES ('Harry Potter e o Cálice de Fogo', 'JK Rowling', 2000);
INSERT INTO livro (livro_titulo, autor, ano_publicacao) VALUES ('Harry Potter e a Ordem da Fenix', 'JK Rowling', 2003);
INSERT INTO livro (livro_titulo, autor, ano_publicacao) VALUES ('Harry Potter e o Enigma do Príncipe', 'JK Rowling', 2005);

-- Inserir membros
INSERT INTO membro (membro_nome, endereco, telefone) VALUES ('Jonas', 'Rua XV de Novembro, 888', '(48) 9999-8888');
INSERT INTO membro (membro_nome, endereco, telefone) VALUES ('Ana', 'Rua Arcelino Ramos, 999', '(48) 1287-6542');

-- Inserir empréstimos
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (1, 1, '2023-12-01', '2023-12-22');
INSERT INTO emprestimo (livro_id, membro_id, data_emprestimo, data_devolucao) VALUES (2, 2, '2023-12-05', '2023-12-23');

-- Inserir visitantes
INSERT INTO visitante (visitante_nome, telefone) VALUES ('Lucas', '(48) 2563-8874');
INSERT INTO visitante (visitante_nome, telefone) VALUES ('Carlos', '(48) 2387-6348');

-- Inserir bibliotecários
INSERT INTO bibliotecario (bibliotecario_nome, email, senha) VALUES ('José', 'jose@gmail.com', '123456ABC');
INSERT INTO bibliotecario (bibliotecario_nome, email, senha) VALUES ('Antônio', 'antonio@gmail.com', '123456DEF');
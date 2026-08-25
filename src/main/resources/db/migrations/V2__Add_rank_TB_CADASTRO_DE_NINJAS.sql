--V2 Migrations para adicionar a coluna de RANK na tabela de cadastro de ninjas


ALTER TABLE tb_cadastro_de_ninjas
ADD COLUMN rank_ninja VARCHAR(255);
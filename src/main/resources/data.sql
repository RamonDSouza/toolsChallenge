
  
  
  INSERT INTO Descricao (valor,	dataHora,estabelecimento,nsu,codigoAutorizacao,	status)  VALUES
  ('4', '09/11/2022 18:30:00','PetShop Mundo cão','510010','2000','AUTORIZADO'),
  ('3', '15/11/2022 15:20:00','PetShop Mundo cão','510010','01441','NEGADO'),
  ('5', '06/05/2022 14:30:00','PetShop Mundo cão','510010','22626','AUTORIZADO');
  
  
  INSERT INTO FormaPagamento (tipo,parcelas) VALUES
  ('AVISTA', '1'),
  ('PARCELADO LOJA', '2'),
  ('PARCELADO EMISSOR', '4');

  INSERT INTO Transacao (id, cartao,DescricaoId,FormaPagamentoId) VALUES
  (510010,'3323******1234',1,1),
  (510010,'4224******4567',2,2),
  (510010,'3332******6789',3,3);
  

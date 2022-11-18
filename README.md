# ToolsChallenge

Teste Técnico ToolsChallenge

# Técnologias utilizadas

O projeto foi criado com Spring Boot na linguagem de programação Java, Spring Data JPA e realizado testes unitários com JUnit, uso do Banco de dados H2 e Swagger para toda documentação.

# Arquitetura

- Config
- Controller
- Convert
- DTO
- Exception
- Model
- Repository
- Service
- Utils
- Validation

# Como executar

1. Clonar o projeto
2. Executar o projeto em uma IDEA``
3. Acessar no navegador http://localhost:8080/swagger-ui.html#/
 
# Como testar

1) GET localhost:8080/transacao/consultarTodos
```
{
	"transacao": {
		"cartao": "777******1234",
		"descricao": {
			"valor": "50",
			"dataHora": "01/05/2021 18:30:00",
			"estabelecimento": "Supermercado"
			},
		"formaPagamento": {
			"tipo": "AVISTA",
			"parcelas": "1"
		}
	}
}
```
2) GET localhost:8080/transacao/consultarPorId?id=1
```
{
		"transacao": {
			"cartao": "333******1234",
			"descricao": {
				"valor": "50",
				"dataHora": "18/11/2022 15:30:00",
				"estabelecimento": "PetShop Mundo cão",
				"nsu": "52050",
				"codigoAutorizacao": "1320",
				"status": "AUTORIZADO"
			},
			"formaPagamento": {
				"tipo": "AVISTA",
				"parcelas": "1"
			}
		}
	}
```

3) POST localhost:8080/transacao/solicitarTransacao


**A mudança do extorno acontece no Status, por isso a utilização do metodo GET **

4) GET localhost:8080/estorno/estornarTransacao?id=1

5) GET localhost:8080/estorno/consultarPorId?id=1


# Contato

- LinkedIn: https://www.linkedin.com/in/ramon-duarte-91b77a15a/


- Email: ramon_duarte.10@hotmail.com
# toolsChallenge

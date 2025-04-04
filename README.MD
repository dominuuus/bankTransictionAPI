# bankTransactionAPI

[![GitHub](https://img.shields.io/badge/GitHub-Repository-blue?logo=github)](https://github.com/dominuuus/bankTransictionAPI)

## 📌 Descrição

Este projeto foi desenvolvido como desafio de código do bootcamp **Decola Tech 2025**, com o objetivo de publicar uma **API REST** na nuvem utilizando **Spring Boot 3**, **Java 17** e **Railway**. Trata-se de uma simulação de **transferência bancária** entre clientes de um banco.

---

## 📑 Sumário

- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Funcionalidades](#-funcionalidades)
- [Instalação](#-instalação)
- [Como Usar](#-como-usar)
- [Desafios e Aprendizados](#-desafios-e-aprendizados)
- [Contribuição](#-contribuição)
- [Licença](#-licença)



## 🚀 Tecnologias Utilizadas

O projeto foi desenvolvido com as seguintes tecnologias:

- **Java 17**
- **Spring Boot 3.4.4**
- **Maven** (Gerenciamento de dependências)
- **Swagger** (Documentação da API)
- **Railway** (Hospedagem do banco de dados online)
- **PostgreSQL** (Banco de dados relacional)
- **Mermaid** (Criação do diagrama de classe do banco de dados)

## Diagrama de Classes
![alt text](mermaid.png)


## ⚙️ Funcionalidades

- **Gerenciamento de Usuários:** Cada usuário (cliente) possui:
  - Primeiro e último nome, email, senha, dados da conta, cartão de crédito, documento de identificação.
  - Tipo de acesso (Usuário Comum ou Empresarial)


- **Transferências Bancárias:**
  - Permite a realização de transações entre contas.
  - Validação do saldo disponível antes da transação.
  - Mensagem de erro exibida caso o usuário tenha saldo insuficiente.

- **Validação Externa das Transações:**
  - Utiliza o serviço externo [`util.devi.tools`](https://util.devi.tools/api/v2/authorize) para validar transações.
  - Se a resposta for `"success"`, a transação é concluída e o saldo é movimentado.
  - Caso contrário, a transação é rejeitada e os saldos permanecem inalterados.


## 📌 Desafios e Aprendizados

- ✅ Primeiro projeto backend com Spring Boot
- ✅ Publicação de API REST em produção
- ✅ Estudo aprofundado de Java para compreender conceitos essenciais
- ✅ Solução de problemas com integração PostgreSQL no Railway

Durante o desenvolvimento, enfrentei desafios na configuração do banco de dados PostgreSQL no Railway. Diversos tutoriais apresentavam erros na conexão, exigindo múltiplas tentativas até alcançar uma integração bem-sucedida. Além disso, utilizei IA Generativa para esclarecer dúvidas e aprimorar a lógica do código.


## 🤝 Contribuição
Toda contribuição será bem vinda! Por se tratar do meu primeiro projeto, precisei recorrer a fontes diferentes para construir o projeto, então acredito que há muitos ajustes a serem realizados.


## 📜 Aplicação na prática

**Swagger: documentação com os métodos implantados.**
![alt text](registro-swagger.png)

**Registro de usuários no Railway**
![alt text](registro-usuarios-railway.png)

**Registro de transações executadas no banco**
![alt text](registro-transacoes-railway.png)

**Transferência realizada quando o usuário não possui saldo suficiente**
![alt text](saldo-insuficiente.png)

**Tratamento de erros**
- Usuário não encontrado
![alt text](user-not-found.png)

- Saldo insuficiente
![alt text](saldo-insuficiente.png)

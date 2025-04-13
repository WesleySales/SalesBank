# 🏦 Sistema Bancário em Spring Boot

**Um projeto de backend bancário com operações básicas, validações e API RESTful.**

🔗 **Repositório**: [SalesBank](https://github.com/WesleySales/SalesBank)

## 📌 Visão Geral
Este projeto simula operações bancárias básicas, incluindo:
✅ **Saque, depósito e transferência** (com validações de saldo e limite diário)  
✅ **Consulta de saldo e histórico de transações**  
✅ **CRUD de clientes e contas**

**Tecnologias Utilizadas**:
- **Backend**: Java 21, Spring Boot 3.4.4
- **Banco de Dados**: MySQL
- **ORM**: JPA/Hibernate
- **Testes de API**: Postman

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 21
- MySQL instalado (ou Docker para subir um container)

### Passo a Passo
1. **Clone o repositório**:
   ```sh
   git clone https://github.com/seu-usuario/sistema-bancario.git
2. **Configure o banco de dados**:
   ```sh
   spring.datasource.url=jdbc:mysql://localhost:3306/sistema_bancario
    spring.datasource.username=seu_user
    spring.datasource.password=sua_senha
3. **Execute a aplicação**:
   ```sh
    ./mvnw spring-boot:run

## 📡 Endpoints da API

### Contas Bancárias
| Método | Endpoint | Descrição | Parâmetros | Body (exemplo) |
|--------|----------|-----------|------------|----------------|
| `GET`  | `/contas` | Lista todas as contas cadastradas | - | - |
| `GET`  | `/contas/{id}` | Busca uma conta específica | `id` (Long) | - |
| `GET`  | `/contas/{id}/saldo` | Retorna o saldo atual da conta | `id` (Long) | - |

### Transações
| Método | Endpoint | Descrição | Parâmetros | Body (exemplo) |
|--------|----------|-----------|------------|----------------|
| `GET`  | `/contas/{id}/servicos` | Lista todas as transações de uma conta | `id` (Long) | - |
| `POST` | `/contas/{id}/servicos/{tipo}` | Executa uma transação bancária | `id` (Long), `tipo` (String: SAQUE, DEPOSITO ou TRANSFERENCIA) | ```json { "valor": 150.00, "contaDestinoId": 2 } ``` |

### Clientes
| Método | Endpoint | Descrição | Parâmetros | Body (exemplo) |
|--------|----------|-----------|------------|----------------|
| `POST` | `/clientes` | Cria um novo cliente | - | ```json { "nome": "Fulano", "cpf": "123.456.789-00" } ``` |
| `GET`  | `/clientes` | Lista todos os clientes cadastrados | - | - |
| `GET`  | `/clientes/{id}` | Retorna os dados de um cliente específico | `id` (Long) | - |

## 🔒 Validações Implementadas
- Verificação de saldo suficiente para saques/transferências
- Limite diário de transferência (ex: R$ 1.000 por dia)
- Validação de dados obrigatórios (valor positivo)

## 🛣️ Roadmap
- Refatorar endpoint servicos para transacoes
- Implementar autenticação com Spring Security
- Adicionar cache com Redis
- Desenvolver testes automatizados com JUnit

## 📚 Aprendizados
✔ Arquitetura de APIs RESTful com Spring Boot
✔ Implementação de regras de negócio bancárias
✔ Mapeamento objeto-relacional com JPA/Hibernate
✔ Validações e tratamento de erros

🤝 Como Contribuir
1. Faça um fork do projeto
2. Crie uma branch para sua feature (git checkout -b feature/awesome-feature)
3. Commit suas mudanças (git commit -m 'Add some awesome feature')
4. Push para a branch (git push origin feature/awesome-feature)
5. Abra um Pull Request

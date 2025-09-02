# CRM-Project
CRM Simplificado com Gson em Java

Este projeto é um sistema de CRM (Customer Relationship Management) simplificado desenvolvido em Java, utilizando Maven para gerenciamento de dependências e Gson para persistência de dados em formato JSON.
Partiu de um projeto inical utilizando Gson de forma básica

# Funcionalidades

    Gestão de Clientes: Criar, listar e buscar clientes

    Oportunidades de Venda: Registrar oportunidades comerciais com valores e status

    Atividades: Registrar atividades como ligações, reuniões e emails

    Persistência: Armazenamento automático em arquivos JSON

    Busca: Recuperação de clientes por ID

# Estrutura do Projeto

    CRM/
    ├── src/main/java/C14/CRM/
    │   ├── model/
    │   │   ├── Cliente.java
    │   │   ├── Oportunidade.java
    │   │   └── Atividade.java
    │   ├── repository/
    │   │   └── ClienteRepository.java
    │   ├── persistence/
    │   │   └── JsonUtils.java
    │   └── Main.java
    ├── data/clientes/ (gerado automaticamente)
    │   └── cliente_[id].json
    └── pom.xml

# Pré-requisitos

    Java 17 ou superior

    Maven 3.6 ou superior

    Git (opcional)

# Instalação e Configuração
1. Clone ou baixe o projeto
    
       git clone [url-do-repositorio]
       cd CRM


2. Instalação das Dependências

O Maven irá baixar automaticamente todas as dependências necessárias:
bash

    mvn clean install

3. Dependências Principais

O projeto utiliza as seguintes dependências (já configuradas no pom.xml):

    Gson 2.13.0: Para serialização/desserialização JSON

    JUnit Jupiter: Para testes unitários

    Maven Compiler Plugin: Para compilação Java

    Maven Surefire Plugin: Para execução de testes

4. Compilação do Projeto
    

        mvn compile


5. Execução da Aplicação
    
        mvn exec:java -Dexec.mainClass="C14.CRM.Main"
    
Ou compile e execute manualmente:
bash

    javac -cp "target/classes:$(mvn dependency:build-classpath -q -Dmdep.outputFile=/dev/stdout)" src/main/java/C14/CRM/Main.java
    java -cp "target/classes:$(mvn dependency:build-classpath -q -Dmdep.outputFile=/dev/stdout)" C14.CRM.Main

# Comandos Maven Úteis
    
    # Compilar o projeto
    mvn compile
    
    # Executar testes
    mvn test
    
    # Limpar e recompilar
    mvn clean compile
    
    # Executar a aplicação principal
    mvn exec:java -Dexec.mainClass="C14.CRM.Main"
    
    # Gerar jar executável
    mvn package

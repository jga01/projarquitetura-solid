# Projeto Turma - Aplicação do Princípio SRP (Single Responsibility Principle)

Este projeto implementa o exemplo da classe `Turma` apresentado na "Aula 01 - Solid", demonstrando a aplicação correta do **Princípio da Responsabilidade Única (SRP)**.

## 🎯 Objetivo

Demonstrar como refatorar uma classe que viola o SRP, separando suas responsabilidades em classes distintas, cada uma com uma única razão para mudar.

## 🏗️ Estrutura do Projeto

```
turma-solid/
└── src/main/java/com/turma/
    ├── Aluno.java          # Entidade básica do domínio
    ├── Turma.java          # Lógica de negócio
    ├── TurmaViewer.java    # Apresentação dos dados
    ├── Repositorio.java    # Persistência de dados
    └── Main.java           # Demonstração do sistema
```

## 📋 Classes Implementadas

### 1. **Aluno** (Entidade de Domínio)
- Representa um estudante com nome, idade e nota
- Contém métodos básicos: getters, setters, equals, hashCode, toString

### 2. **Turma** (Lógica de Negócio) 🎯 **SRP Aplicado**
**Responsabilidade única**: Gerenciar a lógica de negócio relacionada à turma
- `calculaMedia()` - Calcula a média das notas dos alunos
- `getAlunos()` - Retorna lista de alunos
- `getTotalAlunos()` - Retorna quantidade de alunos
- `add(Aluno)` - Adiciona um aluno à turma
- `delete(Aluno)` - Remove um aluno da turma

### 3. **TurmaViewer** (Camada de Apresentação) 🎯 **SRP Aplicado**
**Responsabilidade única**: Apresentar os dados da turma
- `imprimeDados()` - Exibe dados completos da turma
- `mostraDados()` - Exibe dados resumidos da turma

### 4. **Repositorio** (Camada de Persistência) 🎯 **SRP Aplicado**
**Responsabilidade única**: Gerenciar a persistência dos dados
- `load()` - Carrega turma do arquivo
- `save(Turma)` - Salva turma no arquivo
- `update(Turma)` - Atualiza dados da turma
- `delete()` - Remove arquivo da turma

## 🚫 Problema Original (Violação do SRP)

A implementação inicial apresentada nos slides concentrava todas as responsabilidades em uma única classe:

```java
class Turma {
    // ❌ Lógica de negócio
    float calculaMedia() {...}
    List getAlunos() {...}
    // ❌ Apresentação
    void imprimeDados() {...}
    void mostraDados() {...}
    // ❌ Persistência
    void load() {...}
    void save() {...}
    void update() {...}
    void delete() {...}
}
```

**Problemas:**
- **Múltiplas responsabilidades** em uma única classe
- **Difícil manutenção** - mudanças em uma área afetam outras
- **Baixa coesão** - métodos não relacionados na mesma classe
- **Alto acoplamento** - dependências desnecessárias

## ✅ Solução Aplicando SRP

A refatoração separa as responsabilidades:

1. **Turma** → Apenas lógica de negócio
2. **TurmaViewer** → Apenas apresentação
3. **Repositorio** → Apenas persistência

## 🚀 Como Executar

1. **Compilar:**
```bash
cd turma-solid/src/main/java
javac com/turma/*.java
```

2. **Executar:**
```bash
java com.turma.Main
```

## 📊 Benefícios da Aplicação do SRP

- ✅ **Maior coesão**: Cada classe tem uma responsabilidade específica
- ✅ **Menor acoplamento**: Classes independentes e especializadas
- ✅ **Facilidade de manutenção**: Mudanças localizadas
- ✅ **Facilidade de teste**: Classes menores e focadas
- ✅ **Reutilização**: Componentes podem ser reutilizados independentemente
- ✅ **Extensibilidade**: Fácil adicionar novas funcionalidades

## 📚 Conceitos SOLID Demonstrados

**S** - **Single Responsibility Principle (SRP)** ✅
- Cada classe tem uma única razão para mudar
- Separação clara de responsabilidades

Este projeto serve como base para aplicação dos demais princípios SOLID (OCP, LSP, ISP, DIP).

<img width="784" height="450" alt="turma" src="https://github.com/user-attachments/assets/ed4c89a0-9536-41df-8757-0e663401129e" />
<img width="486" height="608" alt="diagram" src="https://github.com/user-attachments/assets/10caf854-5a84-4200-9799-3e0fce911885" />

# Jogo da Velha com Inteligência Artificial

## 📋 Descrição do Projeto

Este projeto foi desenvolvido como **atividade de sala de aula** onde o professor solicitou a criação de um jogo da Velha em Java com implementação de **inteligência artificial** em três níveis de dificuldade diferentes.

O jogo foi desenvolvido utilizando apenas as bibliotecas `javax.swing` e `java.awt` para a interface gráfica, atendendo aos requisitos da atividade acadêmica.

## 🎮 Funcionalidades Implementadas

### Modos de Jogo
- **Jogador vs Jogador**: Dois jogadores humanos podem competir entre si
- **Jogador vs IA**: Desafie a inteligência artificial em três dificuldades

### Níveis de Dificuldade da IA
- **FÁCIL**: A IA realiza jogadas aleatórias
- **MÉDIO**: A IA tenta bloquear jogadas do oponente e buscar vitórias
- **DIFÍCIL**: A IA utiliza estratégia avançada com priorização de jogadas

### Recursos do Sistema
- ✅ **Placar dinâmico** com contagem de vitórias
- ✅ **Interface gráfica intuitiva** com navegação entre telas
- ✅ **Sistema de turnos** com indicação visual
- ✅ **Detecção automática** de vitórias e empates
- ✅ **Reinício de partida** sem perder o placar
- ✅ **Menu principal** para trocar modos de jogo

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java
- **Interface Gráfica**: Swing (javax.swing)
- **Gerenciamento de Layout**: AWT (java.awt)
- **Paradigma**: Programação Orientada a Objetos

## 🏗️ Estrutura do Projeto

```
JogoDaVelha/
├── src/
│   └── jogo/
│       └── JogoDaVelha.java
└── README.md
```

## 🧠 Lógica da Inteligência Artificial

### IA Fácil
- Realiza jogadas completamente aleatórias em posições vazias

### IA Média
1. Primeiro tenta completar uma sequência para vencer
2. Se não possível, tenta bloquear sequências do jogador
3. Caso contrário, joga aleatoriamente

### IA Difícil
1. Tenta vencer imediatamente
2. Tenta bloquear jogadas do oponente
3. Prioriza jogar no centro do tabuleiro
4. Prioriza jogar nos cantos
5. Joga aleatoriamente como última opção

## 🎯 Como Executar

### Pré-requisitos
- Java JDK 8 ou superior
- IDE Eclipse (recomendado)

### Passos para Execução
1. Abra o Eclipse e importe o projeto
2. Navegue até: `src/jogo/JogoDaVelha.java`
3. Clique com o botão direito e selecione: `Run As > Java Application`
4. O jogo será iniciado e você poderá navegar pelo menu

## 🕹️ Como Jogar

1. **Menu Inicial**: Escolha entre "JOGADOR vs JOGADOR" ou "JOGADOR vs IA"
2. **Seleção de Dificuldade**: Caso escolha vs IA, selecione a dificuldade desejada
3. **Jogando**:
   - Clique em qualquer quadrado vazio para fazer sua jogada
   - Os "X" são azuis e representam o Jogador 1
   - Os "O" são vermelhos e representam o Jogador 2 ou IA
4. **Controles**:
   - Use "Reiniciar Jogo" para uma nova partida
   - Use "Menu Principal" para voltar ao início e zerar o placar

## 📝 Regras do Jogo da Velha

- Tabuleiro 3x3
- Jogadores alternam entre "X" e "O"
- Vitória ao formar linha, coluna ou diagonal completa
- Empate quando todas as posições estão preenchidas sem vencedor

## 👨‍🎓 Contexto Acadêmico

Este projeto demonstra os conceitos aprendidos em sala de aula:

- **Programação Orientada a Objetos**
- **Interface Gráfica com Swing**
- **Implementação de Algoritmos**
- **Lógica de Jogos**
- **Inteligência Artificial Básica**
- **Manipulação de Eventos**
- **Gerenciamento de Layouts**

## 🔧 Possíveis Melhorias Futuras

- Adicionar sons para jogadas e vitórias
- Implementar modo torneio com múltiplas partidas
- Adicionar animações nas jogadas
- Criar ranking de pontuações
- Implementar rede para jogar online

## 📞 Suporte

Em caso de problemas na execução:
1. Verifique se a versão do Java é compatível
2. Confirme que todas as bibliotecas Swing e AWT estão disponíveis
3. Execute o comando `Project > Clean` no Eclipse se necessário

---

*Projeto educativo desenvolvido para fins acadêmicos - Disciplina de Programação Java*

**Desenvolvido por:** Gabriel Regel
**Instituição:** UNIDADE POLO 
**Ano:** 2025
```

Este README em Markdown está formatado com:
- **Cabeçalhos** organizados
- **Listas** de funcionalidades
- **Ênfase** em títulos importantes
- **Estrutura** de código para paths
- **Emojis** para melhor visualização
- **Seções** bem definidas

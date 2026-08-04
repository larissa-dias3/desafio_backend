# Detector de Golpes - Desafio Backend

Uma aplicação Java via linha de comando (CLI) desenvolvida para analisar e identificar potenciais mensagens de golpes, *phishing* e fraudes digitais por meio de análise heurística baseada em regras ponderadas.

---

## Sobre o Projeto

O **Detector de Golpes** avalia mensagens de texto coladas pelo usuário no terminal, buscando padrões frequentemente utilizados por golpistas (como senso de urgência, solicitações de transferências/PIX, links encurtados ou downloads suspeitos).

A aplicação calcula uma **pontuação de risco** (0% a 100%), exibe detalhadamente os alertas identificados, traz explicações sobre os motivos de atenção e alertas de possíveis falsos positivos, emitindo ao final um veredito sobre o nível de suspeita da mensagem.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java (Compatível com Java 8+)
- **Bibliotecas Padrão**: 
  - `java.util.Scanner` (Interação via terminal)
  - `java.text.Normalizer` (Normalização e tratamento de acentuação)

---

## 🚀 Funcionalidades

- **Normalização de Texto**: Remove automaticamente acentos e converte os caracteres para minúsculas, garantindo resiliência na busca por palavras-chave.
- **Sistema de Regras Ponderadas**:
  -  **Senso de Urgência** (20 pts): Expressões como *urgente*, *bloqueado*, *suspens*, *agora*.
  -  **Links Desconhecidos/Encurtados** (20 pts): Presença de URLs (*http://*, *bit.ly*, *tinyurl*).
  -  **Promessa de Prêmios/Dinheiro** (15 pts): Termos como *prêmio*, *sorteio*, *ganhou*, *resgate*.
  -  **Solicitação de Dados Pessoais** (25 pts): Pedidos de *CPF*, *cartão*, *senha*, *CVV*.
  -  **Pedido de PIX ou Transferência** (20 pts): Solicitações de *PIX*, *transferência*, *depósito*.
  -  **Arquivos ou Aplicativos para Baixar** (25 pts): Menções a *download*, *.apk*, *.exe*, *anexo*.
- **Relatório Detalhado**: Exibe o motivo da suspeita e orientações de segurança para cada regra violada.
- **Cálculo de Risco e Veredito**:
  - **BAIXO RISCO**: Nenhum padrão de golpe detectado.
  - **RISCO MÉDIO**: Pontuação abaixo de 50%.
  - **ALTO RISCO**: Pontuação igual ou superior a 50%.

---

## 📂 Estrutura do Código

```
desafio_backend/
└── src/
    ├── DetectorGolpe.java  # Classe principal (fluxo da aplicação e cálculo de risco)
    └── Regra.java          # Modelo para representação e estruturação das regras
```

- **`Regra.java`**: Define a estrutura de uma regra de detecção (nome, palavras-chave, pontuação, motivo do alerta e exceções/falsos positivos).
- **`DetectorGolpe.java`**: Contém a lista de regras, o loop interativo via `Scanner`, a função de normalização de texto e o motor de inferência de risco.

---

### Pré-requisitos
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) instalado (versão 8 ou superior).

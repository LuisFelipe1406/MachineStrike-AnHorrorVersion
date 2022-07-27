# MachineStrike-AnHorrorVersion


Releitura do jogo Ataque das Máquinas do Horizon Forbidden West.
Esse trabalho foi desenvolvido apra disciplina de Padrões de Projeto do quinto semestre do curso de Engenharia de Software da Universidade do Estado de Santa Catarina (UDESC).
A temática adotado para o jogo foi a de personagens de filmes de terror em formato 8bits.

A experiência desenvolvida foi idealizada para ser jogada no computador, ambos os jogadores devem usar o mouse ao longo do jogo. Primeiramente, seleciona-se o tabuleiro que será usado no jogo, também há a possibilidade de optar por um tabuleiro gerado randomicamente. Após isso, cada um dos jogadores escolhe suas peças respeitando o máximo de 7 personagens para cada.

Iniciando o jogo, os turnos irão decorrer indicando qual jogador deve jogar, os turnos também variam entre fases de movimento e de ataque. Em cada turno, o jogo indica os movimentos ou ataques possíveis para a peça selecionada, esse destaque visa auxiliar a jogabilidade. O jogador pode ainda pular sua vez, seja por não ter possibilidades de ataque ou por alguma estratégia elaborada para chegar a vitória. Para cada peça morta o jogador perde um ponto de vida, ao perder todas as suas peças e chegar a zero pontos de vida, o jogo termina e o jogador sobrevivente é anunciado como campeão.

O projeto foi desenvolvido utilizando JavaFX, para executá-lo, basta utilizar o Maven para baixar as dependências especificadas no arquivo POM.

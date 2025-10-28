package jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelha extends JFrame {
    private JButton[][] botoes;
    private boolean vezX;
    private JLabel statusLabel;
    private int placarJogador1 = 0;
    private int placarJogador2 = 0;
    private JLabel placarLabel;
    private boolean vsIA = false;
    private String dificuldadeIA = "FACIL";
    
    public JogoDaVelha() {
        super("Jogo da Velha");
        configurarJanela();
        mostrarTelaInicial();
    }
    
    private void configurarJanela() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void mostrarTelaInicial() {
        // Limpa a tela completamente
        getContentPane().removeAll();
        
        JPanel painelInicial = new JPanel(new BorderLayout());
        painelInicial.setBackground(new Color(240, 240, 240));
        
        // Título
        JLabel titulo = new JLabel("JOGO DA VELHA", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setForeground(Color.BLUE);
        titulo.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10));
        
        // Painel de opções
        JPanel painelOpcoes = new JPanel(new GridLayout(3, 1, 10, 10));
        painelOpcoes.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        
        JButton btnVsJogador = new JButton("JOGADOR vs JOGADOR");
        JButton btnVsIA = new JButton("JOGADOR vs IA");
        
        btnVsJogador.setFont(new Font("Arial", Font.BOLD, 18));
        btnVsIA.setFont(new Font("Arial", Font.BOLD, 18));
        
        btnVsJogador.setBackground(new Color(100, 200, 100));
        btnVsIA.setBackground(new Color(100, 150, 255));
        
        btnVsJogador.addActionListener(e -> {
            vsIA = false;
            iniciarJogo();
        });
        
        btnVsIA.addActionListener(e -> {
            vsIA = true;
            mostrarDificuldades();
        });
        
        painelOpcoes.add(btnVsJogador);
        painelOpcoes.add(btnVsIA);
        
        painelInicial.add(titulo, BorderLayout.NORTH);
        painelInicial.add(painelOpcoes, BorderLayout.CENTER);
        
        setContentPane(painelInicial);
        revalidate();
        repaint();
    }
    
    private void mostrarDificuldades() {
        // Limpa a tela completamente
        getContentPane().removeAll();
        
        JPanel painelDificuldades = new JPanel(new BorderLayout());
        painelDificuldades.setBackground(new Color(240, 240, 240));
        
        JLabel titulo = new JLabel("SELECIONE A DIFICULDADE", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(50, 10, 30, 10));
        
        JPanel painelBotoes = new JPanel(new GridLayout(4, 1, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        
        JButton btnFacil = new JButton("FÁCIL");
        JButton btnMedio = new JButton("MÉDIO");
        JButton btnDificil = new JButton("DIFÍCIL");
        JButton btnVoltar = new JButton("VOLTAR");
        
        btnFacil.setFont(new Font("Arial", Font.BOLD, 18));
        btnMedio.setFont(new Font("Arial", Font.BOLD, 18));
        btnDificil.setFont(new Font("Arial", Font.BOLD, 18));
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        
        btnFacil.setBackground(Color.GREEN);
        btnMedio.setBackground(Color.YELLOW);
        btnDificil.setBackground(Color.RED);
        btnVoltar.setBackground(Color.LIGHT_GRAY);
        
        btnFacil.addActionListener(e -> {
            dificuldadeIA = "FACIL";
            iniciarJogo();
        });
        
        btnMedio.addActionListener(e -> {
            dificuldadeIA = "MEDIO";
            iniciarJogo();
        });
        
        btnDificil.addActionListener(e -> {
            dificuldadeIA = "DIFICIL";
            iniciarJogo();
        });
        
        btnVoltar.addActionListener(e -> mostrarTelaInicial());
        
        painelBotoes.add(btnFacil);
        painelBotoes.add(btnMedio);
        painelBotoes.add(btnDificil);
        painelBotoes.add(btnVoltar);
        
        painelDificuldades.add(titulo, BorderLayout.NORTH);
        painelDificuldades.add(painelBotoes, BorderLayout.CENTER);
        
        setContentPane(painelDificuldades);
        revalidate();
        repaint();
    }
    
    private void iniciarJogo() {
        // Limpa a tela completamente antes de iniciar o jogo
        getContentPane().removeAll();
        inicializarComponentes();
        revalidate();
        repaint();
    }
    
    private void inicializarComponentes() {
        // Configura o layout principal
        setLayout(new BorderLayout());
        
        // Painel superior com placar
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(220, 220, 220));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        placarLabel = new JLabel("Jogador 1: " + placarJogador1 + "  |  Jogador 2: " + placarJogador2, SwingConstants.CENTER);
        placarLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JButton btnMenu = new JButton("Menu Principal");
        btnMenu.setFont(new Font("Arial", Font.PLAIN, 12));
        btnMenu.addActionListener(e -> {
            placarJogador1 = 0;
            placarJogador2 = 0;
            mostrarTelaInicial();
        });
        
        topPanel.add(placarLabel, BorderLayout.CENTER);
        topPanel.add(btnMenu, BorderLayout.EAST);
        
        // Painel dos botões (tabuleiro)
        JPanel tabuleiroPanel = new JPanel(new GridLayout(3, 3));
        botoes = new JButton[3][3];
        vezX = true;
        
        // Criar os botões do tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton("");
                botoes[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                botoes[i][j].setFocusPainted(false);
                botoes[i][j].addActionListener(new BotaoClickListener(i, j));
                tabuleiroPanel.add(botoes[i][j]);
            }
        }
        
        // Label de status
        statusLabel = new JLabel("Vez do: X", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 20));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Botão de reiniciar
        JButton reiniciarButton = new JButton("Reiniciar Jogo");
        reiniciarButton.setFont(new Font("Arial", Font.BOLD, 16));
        reiniciarButton.addActionListener(e -> reiniciarJogo());
        
        // Painel inferior
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statusLabel, BorderLayout.CENTER);
        bottomPanel.add(reiniciarButton, BorderLayout.SOUTH);
        
        // Adicionar componentes à janela
        add(topPanel, BorderLayout.NORTH);
        add(tabuleiroPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    private class BotaoClickListener implements ActionListener {
        private int linha, coluna;
        
        public BotaoClickListener(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton botaoClicado = botoes[linha][coluna];
            
            // Só permite jogar se o botão estiver vazio
            if (botaoClicado.getText().equals("")) {
                if (vezX) {
                    botaoClicado.setText("X");
                    botaoClicado.setForeground(Color.BLUE);
                    statusLabel.setText("Vez do: O");
                } else {
                    botaoClicado.setText("O");
                    botaoClicado.setForeground(Color.RED);
                    statusLabel.setText("Vez do: X");
                }
                
                // Verificar se há vencedor
                if (verificarVencedor()) {
                    String vencedor = vezX ? "X" : "O";
                    if (vezX) {
                        placarJogador1++;
                    } else {
                        placarJogador2++;
                    }
                    atualizarPlacar();
                    JOptionPane.showMessageDialog(null, "Jogador " + vencedor + " venceu!");
                    desabilitarBotoes();
                } else if (verificarEmpate()) {
                    JOptionPane.showMessageDialog(null, "Empate!");
                } else {
                    vezX = !vezX; // Alterna a vez
                    
                    // Se for contra IA e for a vez da IA
                    if (vsIA && !vezX) {
                        jogadaIA();
                    }
                }
            }
        }
    }
    
    private void jogadaIA() {
        // IA FÁCIL - joga aleatório
        if (dificuldadeIA.equals("FACIL")) {
            jogadaIAAleatoria();
        }
        // IA MÉDIA - tenta bloquear ou ganhar, senão aleatório
        else if (dificuldadeIA.equals("MEDIO")) {
            if (!tentarVencer() && !tentarBloquear()) {
                jogadaIAAleatoria();
            }
        }
        // IA DIFÍCIL - estratégia mais avançada
        else if (dificuldadeIA.equals("DIFICIL")) {
            if (!tentarVencer() && !tentarBloquear() && !jogarCentro() && !jogarCanto()) {
                jogadaIAAleatoria();
            }
        }
        
        // Verificar se a IA venceu após jogar
        if (verificarVencedor()) {
            placarJogador2++;
            atualizarPlacar();
            JOptionPane.showMessageDialog(null, "IA venceu!");
            desabilitarBotoes();
        } else if (verificarEmpate()) {
            JOptionPane.showMessageDialog(null, "Empate!");
        } else {
            vezX = !vezX;
            statusLabel.setText("Vez do: X");
        }
    }
    
    private void jogadaIAAleatoria() {
        java.util.List<Point> posicoesVazias = new java.util.ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botoes[i][j].getText().equals("")) {
                    posicoesVazias.add(new Point(i, j));
                }
            }
        }
        
        if (!posicoesVazias.isEmpty()) {
            Point jogada = posicoesVazias.get((int)(Math.random() * posicoesVazias.size()));
            botoes[jogada.x][jogada.y].setText("O");
            botoes[jogada.x][jogada.y].setForeground(Color.RED);
        }
    }
    
    private boolean tentarVencer() {
        return fazerJogadaEstrategica("O");
    }
    
    private boolean tentarBloquear() {
        return fazerJogadaEstrategica("X");
    }
    
    private boolean fazerJogadaEstrategica(String jogador) {
        // Verificar linhas, colunas e diagonais para completar sequência
        for (int i = 0; i < 3; i++) {
            // Linhas
            if (contarSimbolosLinha(i, jogador) == 2) {
                for (int j = 0; j < 3; j++) {
                    if (botoes[i][j].getText().equals("")) {
                        botoes[i][j].setText("O");
                        botoes[i][j].setForeground(Color.RED);
                        return true;
                    }
                }
            }
            
            // Colunas
            if (contarSimbolosColuna(i, jogador) == 2) {
                for (int j = 0; j < 3; j++) {
                    if (botoes[j][i].getText().equals("")) {
                        botoes[j][i].setText("O");
                        botoes[j][i].setForeground(Color.RED);
                        return true;
                    }
                }
            }
        }
        
        // Diagonais
        if (contarSimbolosDiagonal1(jogador) == 2) {
            for (int i = 0; i < 3; i++) {
                if (botoes[i][i].getText().equals("")) {
                    botoes[i][i].setText("O");
                    botoes[i][i].setForeground(Color.RED);
                    return true;
                }
            }
        }
        
        if (contarSimbolosDiagonal2(jogador) == 2) {
            for (int i = 0; i < 3; i++) {
                if (botoes[i][2-i].getText().equals("")) {
                    botoes[i][2-i].setText("O");
                    botoes[i][2-i].setForeground(Color.RED);
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean jogarCentro() {
        if (botoes[1][1].getText().equals("")) {
            botoes[1][1].setText("O");
            botoes[1][1].setForeground(Color.RED);
            return true;
        }
        return false;
    }
    
    private boolean jogarCanto() {
        int[][] cantos = {{0,0}, {0,2}, {2,0}, {2,2}};
        java.util.List<Point> cantosVazios = new java.util.ArrayList<>();
        
        for (int[] canto : cantos) {
            if (botoes[canto[0]][canto[1]].getText().equals("")) {
                cantosVazios.add(new Point(canto[0], canto[1]));
            }
        }
        
        if (!cantosVazios.isEmpty()) {
            Point canto = cantosVazios.get((int)(Math.random() * cantosVazios.size()));
            botoes[canto.x][canto.y].setText("O");
            botoes[canto.x][canto.y].setForeground(Color.RED);
            return true;
        }
        
        return false;
    }
    
    private int contarSimbolosLinha(int linha, String simbolo) {
        int count = 0;
        for (int j = 0; j < 3; j++) {
            if (botoes[linha][j].getText().equals(simbolo)) {
                count++;
            }
        }
        return count;
    }
    
    private int contarSimbolosColuna(int coluna, String simbolo) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (botoes[i][coluna].getText().equals(simbolo)) {
                count++;
            }
        }
        return count;
    }
    
    private int contarSimbolosDiagonal1(String simbolo) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (botoes[i][i].getText().equals(simbolo)) {
                count++;
            }
        }
        return count;
    }
    
    private int contarSimbolosDiagonal2(String simbolo) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (botoes[i][2-i].getText().equals(simbolo)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean verificarVencedor() {
        String simbolo = vezX ? "X" : "O";
        
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (botoes[i][0].getText().equals(simbolo) &&
                botoes[i][1].getText().equals(simbolo) &&
                botoes[i][2].getText().equals(simbolo)) {
                return true;
            }
        }
        
        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (botoes[0][j].getText().equals(simbolo) &&
                botoes[1][j].getText().equals(simbolo) &&
                botoes[2][j].getText().equals(simbolo)) {
                return true;
            }
        }
        
        // Verificar diagonais
        if (botoes[0][0].getText().equals(simbolo) &&
            botoes[1][1].getText().equals(simbolo) &&
            botoes[2][2].getText().equals(simbolo)) {
            return true;
        }
        
        if (botoes[0][2].getText().equals(simbolo) &&
            botoes[1][1].getText().equals(simbolo) &&
            botoes[2][0].getText().equals(simbolo)) {
            return true;
        }
        
        return false;
    }
    
    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (botoes[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void desabilitarBotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(false);
            }
        }
    }
    
    private void reiniciarJogo() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setText("");
                botoes[i][j].setEnabled(true);
            }
        }
        vezX = true;
        statusLabel.setText("Vez do: X");
    }
    
    private void atualizarPlacar() {
        placarLabel.setText("Jogador 1: " + placarJogador1 + "  |  Jogador 2: " + placarJogador2);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JogoDaVelha().setVisible(true);
        });
    }
}
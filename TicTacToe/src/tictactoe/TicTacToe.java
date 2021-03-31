/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author HP
 */
public class TicTacToe  extends JFrame{
    private  Container pane;
    private String player1;
    private JButton [][] board;
    private boolean kazanan;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newgame;
    public TicTacToe (){
        super();
        pane=getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("Tic Tac Toe");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        player1="X";
        board=new JButton[3][3];
        kazanan=false;
        startBoard();
        startMenuBar();
    }
    private void startMenuBar(){
        menuBar =new JMenuBar();
        menu =new JMenu("Game");
        newgame =new JMenuItem("New Game");
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                resetboard();
            }
        });
        quit=new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                System.exit(0);
            }
        });
        menu.add(newgame);
         menu.add(quit);
         menuBar.add(menu);
         setJMenuBar(menuBar);
        
    }private void resetboard(){
        player1="X";
        kazanan=false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j].setText("");
                }
            }
        
    } private void startBoard(){
        for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                   JButton button=new JButton();
                   button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
                  button.setForeground(Color.red);
                   board[i][j]=button;
                   button.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent arg0) {
                           if(((JButton)arg0.getSource()).getText().equals("")&&kazanan==false){
                               button.setText(player1);
                               winner();
                               changePlayer();
                           }
                       }
                   });
                   pane.add(button);
                }
            }
        
    } private void changePlayer(){
        if(player1.equals("X")){
            player1="O";
            
          
        }else{
            player1="X";
            
        }
    }private  void winner(){
       
        if(board[0][0].getText().equals(player1)&&board[1][0].getText().equals(player1)&&board[2][0].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[0][1].getText().equals(player1)&&board[1][1].getText().equals(player1)&&board[2][1].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[0][2].getText().equals(player1)&&board[1][2].getText().equals(player1)&&board[2][2].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[1][0].getText().equals(player1)&&board[1][1].getText().equals(player1)&&board[1][2].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[0][0].getText().equals(player1)&&board[0][1].getText().equals(player1)&&board[0][2].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[2][0].getText().equals(player1)&&board[2][1].getText().equals(player1)&&board[2][2].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[0][0].getText().equals(player1)&&board[1][1].getText().equals(player1)&&board[2][2].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }else if(board[0][2].getText().equals(player1)&&board[1][1].getText().equals(player1)&&board[2][0].getText().equals(player1)){
            JOptionPane.showMessageDialog(null,"Player "+player1+" won");
            kazanan=true;
        }
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TicTacToe();
            }
        });
        
    }
    
}

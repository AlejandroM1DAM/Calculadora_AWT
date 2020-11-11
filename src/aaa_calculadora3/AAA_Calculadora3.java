/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaa_calculadora3;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Alejandro
 */
public class AAA_Calculadora3 extends Frame{
        
    String signo = "";
    String operando1 = "";
    String operando2 = "";
    String ans = "";
    boolean comaUsada = false;
    
    AAA_Calculadora3() {
        Panel panel_uno = new Panel(new BorderLayout());
        Panel panel_dos = new Panel(new BorderLayout());        
        Panel panel_tres = new Panel(new BorderLayout());
        Panel panel_cuatro = new Panel(new BorderLayout());
        
        
        panel_uno.add(panel_dos, BorderLayout.CENTER);
        panel_dos.add(panel_tres, BorderLayout.CENTER);
        panel_dos.add(panel_cuatro, BorderLayout.EAST);
        
        TextField texto = new TextField("0");
        panel_uno.add(texto, BorderLayout.NORTH);
        
        Panel tecladoNumerico =new Panel(new GridLayout(4,3));
        panel_tres.add(tecladoNumerico);
        
        Panel tecladoSimbolos =new Panel(new GridLayout(4,2));
        panel_cuatro.add(tecladoSimbolos);
        
        Button botonIgual = new Button("=");
            botonIgual.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Float resultado = null;
                    if (!operando1.equals("") && operando2.equals("")) {
                         operando2 = texto.getText().substring(operando1.length() + 1, texto.getText().length());
                    } 
                    if (signo.equals("/")) {
                        resultado =  Float.valueOf(operando1) / Float.valueOf(operando2);
                    }
                    else if (signo.equals("*")) {
                        resultado =  Float.valueOf(operando1) * Float.valueOf(operando2);
                    }
                    else if (signo.equals("-")) {
                        resultado =  Float.valueOf(operando1) - Float.valueOf(operando2);
                    }
                    else if (signo.equals("+")) {
                        resultado =  Float.valueOf(operando1) + Float.valueOf(operando2);
                    }
                    texto.setText(Float.toString(resultado));
                     operando1 = "";
                     operando2 = "";
                     ans = Float.toString(resultado);
                     
                }
            });

            panel_uno.add(botonIgual, BorderLayout.SOUTH);   
            
        Button botonBorrado = new Button("<-");
        botonBorrado.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!texto.getText().equals("")) 
                if (texto.getText().substring((texto.getText().length()-1)).equals(".")) {
                    comaUsada = false;
                }                 
                texto.setText(texto.getText().substring( 0, (texto.getText().length()-1)));                
            }
        });
            

        tecladoSimbolos.add(botonBorrado); 
        
        Button botonBorradoTotal = new Button("C");
        botonBorradoTotal.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                if(!texto.getText().equals("")) {
                    signo = "";
                    operando1 = "";
                    operando2 = "";
                    ans = "0";
                    comaUsada = false;
                    texto.setText("");
                }
                                
            }
        });
            

        tecladoSimbolos.add(botonBorradoTotal); 
          
        
        for (int i = 1; i<=9;i++) {
            Button boton = new Button(Integer.toString(i));
            boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               texto.setText(texto.getText() + boton.getLabel());
                }
            });

            tecladoNumerico.add(boton);        
        }
        
        Button botonDividir = new Button("/");
        botonDividir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!texto.getText().equals("")) {
                if (operando1.equals("")) {
                    operando1 = texto.getText();
                    signo = "/";
                    comaUsada = false;
                }
                texto.setText(texto.getText() + botonDividir.getLabel());
            }
           
            }
        });
        
        tecladoSimbolos.add(botonDividir);
        
        
        
        Button botonMultiplicar = new Button("*");
        botonMultiplicar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!texto.getText().equals("")) {
                if (operando1.equals("")) {
                    operando1 = texto.getText();
                    signo = "*";
                    comaUsada = false;
                }
                texto.setText(texto.getText() + botonMultiplicar.getLabel());
            }
           
            }
        });
        
        tecladoSimbolos.add(botonMultiplicar);
        
        
        
        Button botonRestar = new Button("-");
        botonRestar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!texto.getText().equals("")) {
                if (operando1.equals("")) {
                    operando1 = texto.getText();
                    signo = "-";
                    comaUsada = false;
                }
                texto.setText(texto.getText() + botonRestar.getLabel());
            }
           
            }
        });
        
        tecladoSimbolos.add(botonRestar); 
        
         
    
        
        
        Button botonComa = new Button(".");
        botonComa.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!comaUsada) {
                comaUsada = true;
                texto.setText(texto.getText() + ".");
            }
            }
        });

        tecladoNumerico.add(botonComa);
        
        Button boton0 = new Button("0");
        boton0.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           texto.setText(texto.getText() + boton0.getLabel());
          }
        });

        tecladoNumerico.add(boton0);
        
        Button botonSuma = new Button("+");
        botonSuma.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {            
            if(!texto.getText().equals("")) {
                if (operando1.equals("")) {
                    operando1 = texto.getText();
                    signo = "+";
                    comaUsada = false;
                }
                texto.setText(texto.getText() + botonSuma.getLabel());
            }      
            }
        });

        tecladoSimbolos.add(botonSuma);
        
        Button botonAns = new Button("Ans");
        botonAns.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           texto.setText(texto.getText() + ans);
          }
        });

        tecladoNumerico.add(botonAns);
            
        
        
        this.setTitle("Calculadora3");
        this.setSize(350,250);
        this.setLocation(500, 300);
        this.add(panel_uno);
}
    public static void main(String[] args) {
        AAA_Calculadora3 app = new AAA_Calculadora3();
        app.setVisible(true);
        app.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });            
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.projetocaiostalberg.exercicio01;

import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;  

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author caio.gstalberg e Felipe Santos Magalhaes
 */
public class exercicio01
{       
        static String nome = "";
        static String dataNascimento = "";
        static String email = "";
        static int telefone = 0;
        
        private Connection connection;
        String driver = "apache_derby_net";    
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "";
        String password = "";
                    
    
    public static void main (String [] args)
    {
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Digite o seu nome: ");
        nome = sc.next();
        
        System.out.println("Digite a sua data de nascimento: ");
        dataNascimento = sc.next();
        
        System.out.println("Digite o seu email: ");
        email = sc.next();
        
        System.out.println("Digite o seu numero de telefone: ");
        telefone = sc.nextInt();
        
        System.out.println(nome);
        System.out.println(dataNascimento);
        System.out.println(email);
        System.out.println(telefone);  
        
    }// main
    
    public class conexaoInsert
        {
            //conexao insert
            private Connection connection;
            public Connection getConnection() throws ClassNotFoundException, SQLException
            {   
                if (connection == null)
                {  
                    try
                    {
                        Class.forName(driver); 
                        String sqlInsert = "INSERT INTO TB_PESSOA (ID_PESSOA, NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL)"+
                                "VALUES ('','"+nome+"','"+dataNascimento+"','"+email+"','"+telefone+"')";
                        connection = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = connection.prepareStatement(sqlInsert);
                        System.out.println("\nCadastro Salvo no Banco de dados. ");
                        
                        stmt.close();
                        connection.close();
   
                    }//try
                        catch (Exception e) 
                        {
                            System.err.println("Erro de banco de dados: " + e);
                            System.err.println(e.getMessage());
                        } //catch
                }  
            return connection;
            }
        }//fechando ConexaoInsert 
    
    public class conexaoSelect
        {
            //conexao insert
            private Connection connection;
            public Connection getConnection() throws ClassNotFoundException, SQLException
            {   
                if (connection == null)
                {  
                    try
                    {
                        Class.forName(driver); 
                    
                        //comandos com o banco de dados
                        String sqlSelect = "SELECT * FROM TB_PESSOA";
                        connection = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = connection.prepareStatement(sqlSelect);
                        ResultSet rs = stmt.executeQuery();
                        
                        // Percorre o ResultSet
                        while (rs.next())
                        {
                            String id = rs.getString("ID_PESSOA");
                            String nome = rs.getString("NM_PESSOA");
                            String datanascimento = rs.getString("DT_NASCIMENTO");
                            String telefone = rs.getString("VL_TELEFONE");
                            String email = rs.getString("VL_EMAIL");
                            System.out.println("ID: "+ id);
                            System.out.println("Nome: "+ nome);
                            System.out.println("Banda: "+ datanascimento);
                            System.out.println("Telefone: "+ telefone);
                            System.out.println("Email: "+ email);
                        }

                        System.out.println("\n\n Dados exibidos na tela através do banco de dados. ");
                        rs.close();
                        stmt.close();
                        connection.close();
   
                    }//try
                        catch (Exception e) 
                        {
                            System.err.println("Erro de banco de dados: " + e);
                            System.err.println(e.getMessage());
                        } //catch
                }  
            return connection;
            }
        }//fechando ConexaoSelect 
    
   public class conexaoAtualiza
        {
            //conexao insert
            private Connection connection;
            public Connection getConnection() throws ClassNotFoundException, SQLException
            {   
                if (connection == null)
                {  
                    try
                    {
                    
                    Class.forName(driver); 
                    
                        //comandos com o banco de dados
                        String sqlUpdate = "UPDATE TB_PESSOA SET NM_PESSOA='"+nome+"', DT_NASCIMENTO='"+dataNascimento+
                        "', VL_TELEFONE='"+telefone+"', VL_EMAIL='"+email+"'";
                        connection = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = connection.prepareStatement(sqlUpdate);
                        System.out.println("\nAtualização do registro concluída no Banco de dados. ");
                        
                        stmt.close();
                        connection.close();
   
                    }//try
                        catch (Exception e) 
                        {
                            System.err.println("Erro de banco de dados: " + e);
                            System.err.println(e.getMessage());
                        } //catch
                }  
            return connection;
            }
        }//fechando ConexaoInsert 
    
        public class conexaoDeleta
        {
            //conexao insert
            public Connection getConnection() throws ClassNotFoundException, SQLException
            {   
                if (connection == null)
                {  
                    try
                    {
                    
                    Class.forName(driver); 
                    
                        //comandos com o banco de dados
                        String sqlDelete = "DELETE * TB_PESSOA WHERE NM_PESSOA='"+nome+"'";
                        connection = DriverManager.getConnection(url, user, password);
                        PreparedStatement stmt = connection.prepareStatement(sqlDelete);
                        System.out.println("\nRegistro deletado do Banco de dados. ");
                        
                        stmt.close();
                        connection.close();
   
                    }//try
                        catch (Exception e) 
                        {
                            System.err.println("Erro de banco de dados: " + e);
                            System.err.println(e.getMessage());
                        } //catch
                }  
            return connection;
            }
        }//fechando ConexaoInsert 
            
}//Class exercicio01

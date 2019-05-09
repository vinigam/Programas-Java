


package atividade1;
    
import java.util.Scanner;  

public class Atividade1 {

    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        Notas notas_alunos = new Notas();
        
        int n =  notas_alunos.get_line();
        int m = notas_alunos.get_grade();
        
        
        
        String nome;
        int nota;
        
//-------------------------------------- Cadastro inicial dos alunos na matriz ---------------------------//
        for(int i = 0 ; i < n ; i++){
            System.out.println("Aluno " + (i+1) + " = ");
            nome = teclado.next();
            notas_alunos.set_name(nome, i, 0);
            
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 1 ; j < m ; j++){
                String vazio = " ";
                notas_alunos.set_void(vazio ,i,j);
            }
        }
//----------------------------------------------------------------------------------------------------------//
     
        boolean loop = true;
        
        while(loop == true){
            String opt;
            System.out.println("a)Atualiza nota \n b)Mostra notas \n c)Media geral(Grafico) \n d)Sair");
            
            opt = teclado.next();
            
            if(opt.charAt(0) == 'a'){
                boolean loop2 = true;
                
                while(loop2 == true){
                    notas_alunos.show_student();
                    
                    System.out.print("Nome = ");
                    nome = teclado.next();
                    
                    if(notas_alunos.set_grade(nome) == true){
                        System.out.println("Notas do aluno atualizadas, deseja atualizar outro ? \n s/ n");
                        
                        String opt3;
                        opt3 = teclado.next();
                        
                        if(opt3.charAt(0) == 'n'){
                            loop2 = false;
                        }
                    }else{
                        System.out.println("Alunos nao cadastrado , deseja sair ?  \n s / n ");
                        String opt4;
                        opt4 = teclado.next();
                        
                        if(opt4.charAt(0) == 's'){
                            loop2 = false;
                        }
                        
                    }
                }
            }
            if(opt.charAt(0) == 'b'){
                notas_alunos.show_System();
            }
            
            if(opt.charAt(0) == 'c'){
                notas_alunos.show_graph();
            }
            
            if(opt.charAt(0) == 'd'){
                loop = false;
            }
            
        }
        
        
    }
    
}



class Notas{
    private String [][] Alunos_Nota;
    private int alunos;
    private int notas = 7;
    private float []media;
    private float media_sala;
    
// ------------------------------------------------ Funções para manipular a Matriz -------------------//
    public int get_line(){ //---- pega qtdd de linhas(alunos)
        return alunos;
    }
    public int get_grade(){ // --- pega qtdd de colunas(notas)
        return notas;
    }
    
    public void set_name(String name, int n, int m){ //------ preenche primeira pos da linha com o nome
        Alunos_Nota[n][m] = name;
    }
    
    public void set_void(String vazio, int n , int m){ //---------matriz inicialmente vazia --------//
        Alunos_Nota[n][m] = vazio;
        media[n] = 0;
        media_sala = 0;
    }
    
    public void show_graph(){
        
        for(int i = 0 ; i < alunos ; i++){
            System.out.println(Alunos_Nota[i][0]);
            
            System.out.print("Media = ");
            for(int j = 0 ; j < media[i] ; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.print("Sala = ");
        for(int i = 0 ; i < media_sala ; i++){
            System.out.print("*");
            
        }
        System.out.println("");
    }
    
    public boolean set_grade(String nome){
       
        for(int i = 0 ; i < alunos; i++){
            if(nome.equals(Alunos_Nota[i][0]) == true){
                
                Scanner teclado = new Scanner(System.in);
                float []p = new float[3];
                
                float menor = 10;
                
                for(int j = 1 ; j <= 3 ; j++){
                    
                    System.out.println( "P"+ j + ") = ");
                    float temp = teclado.nextFloat();
                    if(temp <= menor){
                        menor = temp;
                    }
                    p[j-1]= temp;
                    
                    Alunos_Nota[i][j] = Float.toString(temp);
                    
         
                }
                media[i] = (p[0] + p[1] + p[2])/(float)3;
                
                
                if(media[i] >= 7){
                    Alunos_Nota[i][4] = " ";
                    Alunos_Nota[i][5] = " ";
                    Alunos_Nota[i][6] = "Aprovado";
                    
                    media_sala = media_sala + media[i];
                    
                }else{
                    int rep;
                    System.out.println("Informe a reposicao");
                    rep = teclado.nextInt();
                    
                    Alunos_Nota[i][4] = Integer.toString(rep);
                    
                    media[i] = (p[0] + p[1] + p[2] + rep - menor)/(float)3;
                    
                    if(media[i] >= 7){
                        Alunos_Nota[i][5] = " ";
                        Alunos_Nota[i] [6] = "Aprovado";
                        media_sala = media_sala + media[i];
                    }else{
                        System.out.println("Informe a nota final");
                        int FINAL = teclado.nextInt();
                        Alunos_Nota[i][5] = Integer.toString(FINAL);
                        
                        media[i] = (FINAL + media[i])/(float)2;
                        if(media[i] >= 6){
                            Alunos_Nota[i][6] = "Aprovado";
                            media_sala = media_sala + media[i];
                        }else{
                            Alunos_Nota[i][6] = "Reprovado";
                            media_sala = media_sala + media[i];
                        }
                    }
                    
                    
                }
                
                return true;
            }
        }
        
        return false;
    }
    
  
    public void show_student(){ //------- mostra apenas os nomes dos alunos
        for(int i = 0 ; i < alunos ; i++){
            System.out.println((i+1) + ") " + Alunos_Nota[i][0]);
        }
        System.out.println("");
    }
    public void show_System(){ //------- mostra todos os alunos 
        System.out.println("---------------------------------- Sibyla System -------------------------------------");
        System.out.println("    Nome          Notas                                          Status");
        for(int i = 0 ; i < alunos ; i++){
            
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.print("| " + (Alunos_Nota[i][0])+ " =         ");
            
            for(int j = 1 ; j < notas ; j++){
                if(j == 5 ){
                    System.out.print("(Final = " + Alunos_Nota[i][j] + ")  | ");
                }else if(j == notas - 1){
                    System.out.println("Status = " + Alunos_Nota[i][j]);
                 System.out.println("Media = " + media[i]);
                 
                }else{
                    
                    System.out.print("(P" + j + " = " + (Alunos_Nota[i][j]) + ")   ");
                    
                }
            }
            System.out.println("");
        }
        
        System.out.println("Media da sala = " + (media_sala/(float)alunos) + "\n---------------------------------------- \n");
    }
//---------------------------------------------------------------------------------------------------//
    Notas(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Classe Notas criada");
        
    //--------------- Declara e instancia uma matriz para a matriz da classe criada -------------------//
        System.out.println("Informe a quantidade de alunos");
       
        alunos = teclado.nextInt();
        
        media = new float[alunos];
        
   
       
        
        String [][]array = new String [alunos][];
        
        for(int i = 0 ; i < alunos ; i++){
           
            array[i] = new String[notas];
            
            for(int j = 0 ; j < notas ; j++){
                array[i][j] = new String();
            }
            
        }
       Alunos_Nota = array; 
     
       //--------------------------------------------------------------------------------------------//
    }
}

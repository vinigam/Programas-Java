
package atividade2;
import java.util.Scanner;

import java.util.ArrayList;
public class Atividade2 {

    
    public static void main(String[] args) {
    
    //-------------- Preenche casa --------------//
        Imovel casa = new Casa();
        
        ((Casa)casa).pinta("Bege");
        
        Porta p = new Porta();
        ((Casa)casa).adicionaPorta(p);
        Porta p2 = new Porta();
        ((Casa)casa).adicionaPorta(p2);
        ((Casa)casa).abre_fecha_porta();
        
    //------------------------------------------//    
       
        
    //---------------- Preenche edificio --------//    
        Imovel edificio = new Edificio();
        
        ((Edificio)edificio).pinta("Marron");
        Porta p3 = new Porta();
        ((Edificio)edificio).adicionaPorta(p3);
        Porta p4 = new Porta();
        ((Edificio)edificio).adicionaPorta(p4);
        
        ((Edificio)edificio).abre_fecha_porta();
        
        ((Edificio)edificio).adicionaAndar();
     //------------------------------------------//   
        
        
        
     //------------ Mostra ambos ---------------//   
        ((Casa)casa).show_info();
        ((Edificio)edificio).show_info();
        
     //-----------------------------------------//
    }
    
}

class Porta{
    
//----------------- Var ------------------------//
    
    private boolean porta_aberta;
    private String cor;
    private int dimensaoX;
    private int dimensaoY;

//------------------ Metd --------------------//
    public boolean estaAberta(){
        if(porta_aberta == true){
            return true;
        }
        return false;
    }
    public void abre(){
        this.porta_aberta = true;
    }
    public void fecha(){
        this.porta_aberta = false;
    }
    public void pinta(String cor){
        this.cor = cor;
        
    }
    public void show_DoorInfo(){
        System.out.println("Cor porta = " + cor);
        System.out.println("Aberta = " + estaAberta());
        System.out.println("Dimensao x = " + dimensaoX);
        System.out.println("Dimensao  y = " + dimensaoY);
    }

//--------------------- constr -------------------------------//
    Porta(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("cor da porta ");
        this.cor = teclado.next();
        System.out.println("informe a largura (x)");
        this.dimensaoX = teclado.nextInt();
        System.out.println("informe o comprimento (y)");
        this.dimensaoY = teclado.nextInt();
        this.porta_aberta = false;
        
    }
}

class Casa extends Imovel {
    
    public void show_info(){ //----------------------
        System.out.println("--------------------Casa -----------------");
        System.out.println("Cor = " + this.cor);
        System.out.println("Total de portas = " + totalDePortas());
        System.out.println("Portas abertas  = " + quantasPortasEstaoAbertas());
        for(int i = 0 ; i < porta.size() ; i++){
            porta.get(i).show_DoorInfo();
        }
    }
   
   
    
}

class Edificio extends Imovel{
    
;;
    private int  totalDeAndares;
    
    
//---------------- metd ----------------//
    public int totalDeAndares(){
        return this.totalDeAndares;
    }
    public void adicionaAndar(){
        totalDeAndares++;
    }
//-------------- constr ---------------//
    Edificio(){
        
        this.totalDeAndares = 0;
    }
    
    public void show_info(){ //----------------------
        System.out.println("--------------------Edificio -----------------");
        System.out.println("Cor = " + this.cor);
        System.out.println("Total de andares = " + totalDeAndares());
        System.out.println("Total de portas = " + totalDePortas());
        System.out.println("Portas abertas  = " + quantasPortasEstaoAbertas());
        for(int i = 0 ; i < porta.size() ; i++){
            porta.get(i).show_DoorInfo();
        }
    }
    
}

abstract class Imovel{
    
//------------ Var ---------------------//
    protected String cor;
    protected int totalDePortas;
    protected ArrayList <Porta> porta;
    
//------------ Metd --------------------//
    public void pinta(String cor){
        this.cor = cor;
    }
   
    public int totalDePortas(){//----------
        return this.totalDePortas;
    }
    public void adicionaPorta(Porta p){
        
        this.porta.add(p);
        
        this.totalDePortas++;
    }
    
    
    public void abre_fecha_porta(){
        Scanner teclado = new Scanner(System.in);
        String comp;
        System.out.println("a) abrir b)fechar");
        comp = teclado.next();
        
        if(comp.charAt(0) == 'a'){
            System.out.println("Escolha a porta = 1 a " + this.porta.size() );
            int aux;
            aux = teclado.nextInt();
            if(aux >= 0 && aux <= this.porta.size()){
                this.porta.get(aux-1).abre();
            }else{
                System.out.println("porta invalida");
            }
        }
        
        if(comp.charAt(0) == 'b'){
            System.out.println("Escolha a porta = 1 a " + this.porta.size() );
            int aux;
            aux = teclado.nextInt();
            if(aux >= 0 && aux <= this.porta.size()){
                this.porta.get(aux-1).fecha();
            }else{
                System.out.println("porta invalida");
            }
            
        }
        
        
            
        
        
    }
    public int quantasPortasEstaoAbertas(){//------------
        int cont = 0;
        for(int i = 0 ; i < this.porta.size() ; i++){
            if(this.porta.get(i).estaAberta() == true){
                cont++;
            }
        }
        return cont;
        
    }

//----------------- constr -------------------//
    Imovel(){
        this.porta = new ArrayList<>();
        this.totalDePortas = 0;
    }
    
}



package pilha;

import java.util.ArrayList;
import java.util.Scanner;

public class Pilha {
    // .get(indice) = mostra o elemento sem remover
    // .remove(indice) = remove o que esta armazenado no indice
    // .add(n) = adiciona um n qualquer
    // .size() = pega o tamanho do ArrayList
    private ArrayList pilha ;
    private int nelms;
    private int maxelms;
    
    public void Push(int n){ //------------------Push---------------------------
        if(nelms < maxelms){
            pilha.add(n);
            nelms++;
        }else{
            System.out.println("OverFlow");
        }
    }
    
    public void Pop(){ //----------------------Pop------------------------------
        
        if(nelms >=  0 ){
            pilha.remove(nelms);
            nelms--;
        }else{
            System.out.println("UnderFlow");
        }
    }
    
    public int Tamanho(){//----------------------Tamanho------------------------
        
        return pilha.size();
    }
    
    public void Topo(){//----------------------- Topo --------------------------
        if(nelms >= 0){
         System.out.println("Elemento do topo = " + pilha.get(nelms));
        }else{
            System.out.println("vazio");
        }
    }
    
    public void Vazio(){ //-------------------------- Vazio --------------------
        if(nelms < 0){
            System.out.println("vazio");
        }else{
            System.out.println("nao vazio");
        }
    }
    
    
    
    Pilha(){
        Scanner teclado = new Scanner(System.in);
        
        pilha = new ArrayList();
        nelms = -1;
        
        System.out.println("Informe o tamanho da pilha");
        maxelms = teclado.nextInt();
    }
    
    
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        Pilha pilha = new Pilha();
        
        int n;
        boolean loop = true;
        String opt;
        
        while(loop){
            System.out.println(" a)Push \n b)Pop \n c)Tamanho \n d)Topo \n e)Vazio \n f)Sair");
            opt = teclado.next();
            
            if(opt.charAt(0) == 'a'){
                System.out.println("informe o elemento ");
                n = teclado.nextInt();
                
                pilha.Push(n);
            }
            
            if(opt.charAt(0) == 'b'){
                pilha.Pop();
            }
            
            if(opt.charAt(0) == 'c'){
                System.out.println("Tamanho = " + pilha.Tamanho());
            }
            
            if(opt.charAt(0) == 'd'){
                pilha.Topo();
            }
            
            if(opt.charAt(0) == 'e'){
                pilha.Vazio();
            }
            
            if(opt.charAt(0) == 'f'){
                loop = false;
            }
        }
        
    }
    
}

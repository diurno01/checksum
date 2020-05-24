/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checksum;

import java.util.Scanner;

/**
 *
 * @author Diurno
 */
public class Checksum {

   
   
    public static void main(String[] args) {
        
        int a, b, c, suma; 
        String sumaBin;
        String cadenaIngresada1, cadenaIngresada2,cadenaIngresada3;
    
        //ingreso de datos   

        Scanner teclado = new Scanner(System.in);
        do{
            
            System.out.println("Ingese un num booleano de 16 bits");        
            cadenaIngresada1 = teclado.nextLine();
            
        }while(!comprueba(cadenaIngresada1));
        
        do{
            System.out.println("Ingese otro num booleano de 16 bits");
            cadenaIngresada2 = teclado.nextLine();
            
        }while(!comprueba(cadenaIngresada2));    
        
        do{
            System.out.println("Ingese otro num booleano de 16 bits una vez más");
            cadenaIngresada3 = teclado.nextLine();
            
        }while(!comprueba(cadenaIngresada3));
            
        //almacena en decimales los numeros binararios ingresados
        
        a = Integer.parseInt(cadenaIngresada1, 2);
        b = Integer.parseInt(cadenaIngresada2, 2);
        c = Integer.parseInt(cadenaIngresada3, 2);
        
        //los suma
        
        suma = a + b + c;
        
        //combierte la suma en binario y lo guarda en un string 
        
        sumaBin = aBin(suma);
        
       //complementa e imprime el numero en consola        
      
        
        System.out.println("Checksum : "+ String.valueOf(sumaBin).replace('1', '2').replace('0', '1').replace('2', '0') );    
       
       
                     
    }  

//comprueba que sea un numero booleano de 16 bits
    
    public static boolean comprueba(String ingresado){
            
     boolean check = true; 
     char[] aCaracteres = ingresado.toCharArray();
     
        if ( aCaracteres.length == 16){
            for (char x: aCaracteres){
            if(x != '0' && x != '1') { 
                check =  false;                                           
            }
        }       
        }else {
            check = false;
        }
        
    return check;
    }
    
   //convierte el int en binario dentro de un string
    
    public static String aBin(int i){
        int modulo, aux= 0;
        String aString= "";
        
            while(15 >= aux){
                modulo = (i%2);
                aString = (Integer.toString(modulo)) + aString;
                i = i/2;
                aux++;               
            }
   
        return aString;
    }
    
    
}

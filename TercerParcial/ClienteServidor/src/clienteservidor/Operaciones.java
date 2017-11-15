/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor;


import java.math.*;

public class Operaciones {
 
float num;
float num2;
float num3;


Operaciones(String valor1, String valor2){
    num2 = Float.parseFloat(valor1);
    num3= Float.parseFloat(valor2);
    
}
float suma(){
    num=num2+num3;
    return num;
}
float resta(){
    num=num2-num3;
    return num;
}
float multiplicacion(){
    num=num2*num3;
    return num;
}
float division(){
    num=num2/num3;
    return num;
}
    
}

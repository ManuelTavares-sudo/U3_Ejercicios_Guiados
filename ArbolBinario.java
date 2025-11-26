/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.utng.tics.arboles_binarios;

/**
 *Clase ArbolBinario que gestionara y dara estructura al arbol
 * @author 1224100719.math@gmail.com
 * @author Manuel Alejandro Tavares Hernandez
 */
public class ArbolBinario {
    private NodoArbol raiz;
    
    public ArbolBinario() {
    this.raiz = null;
    }
   
    //Metodos de insercion  y recorrido
        /**
         * Metodo publico  de insercion: Este es el punto de entrada del ususario
         * Inicia la recursion desde la raiz
         */

    public void insertar(int valor){
        this.raiz = insertarRecursivo(this.raiz, valor);
    }

    /**
     * Metodo privado y recursivo de insercion
     * @param actual El nodo que se esta examinando en la recursion
     * @param valor El valor a insertar
     * @return El nodo modificado o el nuevo nodo creado
     */

    private NodoArbol insertarRecursivo(NodoArbol actual, int valor){
        //Caso base: en caso de que el  odo actual sea nulo(null), encontramos su posicion, creamos el nuevo nodo y retornamos el valor del mismo
        if(actual == null){
            return new NodoArbol(valor);
        }

        if (valor < actual.getDato()){//Se usa getDato por el encapsulameinto estricto
            actual.hijoIzquierdo = insertarRecursivo(actual.hijoIzquierdo, valor);
        }else if(valor > actual.getDato()){
            actual.hijoDerecho = insertarRecursivo(actual.hijoDerecho, valor);
        }
        //Si valor == actual.get Dato, se ignora ya que no permite duplicados

        return actual; //Retorna el nodo actual sin cambios si no fue caso base
    }

    /**
    * Método Público de Recorrido Inorden.
    * Inicia la recursión desde la raíz y muestra el resultado.
    */
    
    public void recorrerInorden() {
    System.out.print("Recorrido Inorden: ");
    recorrerInordenRecursivo(this.raiz);
    System.out.println();
    }
    
    /**
    * Método Privado y Recursivo de Recorrido Inorden (Izquierda -> Raíz ->
    Derecha).
    */
    
    private void recorrerInordenRecursivo(NodoArbol nodo) {
        if (nodo != null) {
        recorrerInordenRecursivo(nodo.hijoIzquierdo); // 1. Izquierda
        System.out.print(nodo.getDato() + " "); // 2. Raíz (Imprimir)
        recorrerInordenRecursivo(nodo.hijoDerecho); // 3. Derecha
        }
    }
}

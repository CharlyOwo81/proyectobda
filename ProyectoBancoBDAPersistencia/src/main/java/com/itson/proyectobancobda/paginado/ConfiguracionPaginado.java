/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.proyectobancobda.paginado;

/**
 *
 * @author Usuario
 */
public class ConfiguracionPaginado {
    private int pagina;
    private int elementosPagina;

    public ConfiguracionPaginado() {
        this.pagina = 0;
        this.elementosPagina = 5;
    }

    public ConfiguracionPaginado(int pagina, int elementosPagina) {
        this.pagina = pagina;
        this.elementosPagina = elementosPagina;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getElementosPagina() {
        return elementosPagina;
    }

    public void setElementosPagina(int elementosPagina) {
        this.elementosPagina = elementosPagina;
    }
    
    public int getElementosASaltar(){
        return this.pagina * this.elementosPagina;
    }
    
    public void avanzarPagina(){
        this.pagina++;
    }
    
    public void retrocederPagina(){
        if(this.pagina==0){
        this.pagina--;
        }
    }
}

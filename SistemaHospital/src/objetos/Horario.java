/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.util.Date;

/**
 *
 * @author reneb
 */
public class Horario {

    private int id;
    private int id_Medico;
    private int id_Paciente;
    private String estado;
    private int year;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    public Horario( int id_Medico, int id_Paciente, String estado, int year, int mes, int dia, int hora, int minutos) {
        this.id_Medico = id_Medico;
        this.id_Paciente = id_Paciente;
        this.estado = estado;
        this.year = year;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }
    public Horario( int id_Medico, String estado, int year, int mes, int dia, int hora, int minutos) {
        this.id_Medico = id_Medico;
        this.id_Paciente = -1;
        this.id_Paciente = id_Paciente;
        this.estado = estado;
        this.year = year;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Medico() {
        return id_Medico;
    }

    public void setId_Medico(int id_Medico) {
        this.id_Medico = id_Medico;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    

    

}

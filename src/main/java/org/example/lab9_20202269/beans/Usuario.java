package org.example.lab9_20202269.beans;

public class Usuario {
    private int id;
    private String nombres;
    private String apellidos;
    private String telefono;
    private int  rol_idrol;
    private int licencia_idlicencia;
    private String tipoLicencia;
    private String estadoLicencia;

    public String getEstadoLicencia() {
        return estadoLicencia;
    }

    public void setEstadoLicencia(String estadoLicencia) {
        this.estadoLicencia = estadoLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public int getReservasCanceladas() {
        return reservasCanceladas;
    }

    public void setReservasCanceladas(int reservasCanceladas) {
        this.reservasCanceladas = reservasCanceladas;
    }

    private String paisProcedencia;
    private int reservasCanceladas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getRol_idrol() {
        return rol_idrol;
    }

    public void setRol_idrol(int rol_idrol) {
        this.rol_idrol = rol_idrol;
    }

    public int getLicencia_idlicencia() {
        return licencia_idlicencia;
    }

    public void setLicencia_idlicencia(int licencia_idlicencia) {
        this.licencia_idlicencia = licencia_idlicencia;
    }
}

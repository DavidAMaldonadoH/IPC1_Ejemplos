package Usuario;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String codigo;
    private String nombre;
    private String password;
    private String tipo;

    public Usuario(String codigo, String nombre, String password, String tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

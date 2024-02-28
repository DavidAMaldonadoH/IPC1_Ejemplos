package Util;

import Usuario.Usuario;

import java.util.ArrayList;

public class Estado {
    public final static Usuario admin = new Usuario("201908312", "pass1234", "admin", "admin");
    private final static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario) {
        Estado.usuarioActual = usuario;
    }

    public static ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static void guardarUsuario(Usuario usuario) {
        Estado.usuariosRegistrados.add(usuario);
    }
}

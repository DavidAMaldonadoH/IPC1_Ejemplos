package Util;

import Usuario.Usuario;

import java.util.ArrayList;

public class Estado {
    public static  Usuario usuarioAdmin = new Usuario("admin", "Administrador", "pass1234", "admin");
    private static Usuario usuarioActual = null;

    private static ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        Estado.usuarioActual = usuarioActual;
    }

    public static ArrayList<Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public static void setUsuariosRegistrados(ArrayList<Usuario> usuariosRegistrados) {
        Estado.usuariosRegistrados = usuariosRegistrados;
    }

    public static void registrarUsuario(Usuario usuario) {
        Estado.usuariosRegistrados.add(usuario);
    }

    public static Usuario getUsuarioRegistrado(int index) {
        return Estado.usuariosRegistrados.get(index);
    }
}

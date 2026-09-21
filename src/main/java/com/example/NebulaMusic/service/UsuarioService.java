package com.example.NebulaMusic.service;

import com.example.NebulaMusic.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UsuarioService {
    //Simulacion de base de datos usando un Mapa en memoria. (Clave: Correo, Valor: Datos del Usuario)
    private final Map<String, Usuario> usuarios =
            new ConcurrentHashMap<>();

    public UsuarioService(){}

    /**
     * Registra un nuevo usuario en la lista en memoria.
     * @param usuario datos del usuario que vienen del formulario.
     */
    public void registrar(Usuario usuario){
        //Almacenamos la contrasenia directamente en texto plano para simplificar la practica
        usuarios.put(usuario.getCorreo(), usuario);
    }

    /**
     * Verifica si un correo electronico ya esta registrado.
     * @param correo correo a verificar
     * @return true si esta registrado, false en caso contrario
     */
    public boolean existeCorreo(String correo){
        return usuarios.containsKey(correo);
    }

    /**
     * Realiza una autenticacion basica en memoria comparando contraseñas en texto plano.
     * @param correo Correo ingresado.
     * @param contrasenia Contraseña ingresada.
     * @return true si las credenciales coinciden, false de lo contrario.
     */
    public boolean autenticar(String correo, String contrasenia){
        Usuario usuario = usuarios.get(correo);
        return usuario != null && usuario.getContrasenia().equals(contrasenia);
    }
}

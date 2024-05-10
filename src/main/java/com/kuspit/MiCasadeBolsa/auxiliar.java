package com.kuspit.MiCasadeBolsa;

import org.mindrot.jbcrypt.BCrypt;

public class auxiliar {

    // Método para generar un hash de contraseña utilizando bcrypt
    public static String hashPassword(String password) {
        // Generar un "salt" aleatorio
        String salt = BCrypt.gensalt();
        // Hash de la contraseña con el "salt" generado
        String hashedPassword = BCrypt.hashpw(password, salt);
        return hashedPassword;
    }

    // Método para verificar si una contraseña coincide con su hash
    public static boolean verifyPassword(String password, String hashedPassword) {
        // Verificar la contraseña utilizando el hash almacenado
        return BCrypt.checkpw(password, hashedPassword);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String password = "contraseña123";

        // Generar el hash de la contraseña
        String hashedPassword = hashPassword(password);
        System.out.println("Contraseña original: " + password);
        System.out.println("Hash de la contraseña: " + hashedPassword);

        // Verificar si la contraseña coincide con el hash
        boolean isValidPassword = verifyPassword(password, hashedPassword);
        System.out.println("La contraseña es válida: " + isValidPassword);
    }
}


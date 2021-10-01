package com.sofka.biblioteca.usecase.prestamo.service;

public interface EnvioDeCorreoService {
    Boolean enviarCorreo(String emailDestino, String asunto, String mensaje);
}

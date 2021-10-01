package com.sofka.biblioteca.usecase.service;

public interface EnvioDeCorreoService {
    Boolean enviarCorreo(String emailDestino, String asunto, String mensaje);
}

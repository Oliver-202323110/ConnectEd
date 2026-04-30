package pe.edu.upc.connected.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.connected.entities.Usuario;

import java.time.LocalDate;

public class CalificacionMentoriaGeneralDTO {
    private int idMentoria;
    private int puntuacionCalificacionMentoria;
    private String comentarioCalificacionMentoria;
    private LocalDate dateCalificacionMentoria;
}

package pe.edu.alicorp.commondto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioDTO {

    private Long codUsuario;
    private String numeroDocumento;
    private String apeUsuario;
    private String nomUsuario;
    private LocalDate fecNac;
    private String sexUsuario;
    private String telUsuario;
    private String corUsuario;
    private String conUsuario;
    private LocalDateTime fecCre;
    private Boolean estUsuario;
    private Long codRol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long codUsuario, String numeroDocumento, String apeUsuario, String nomUsuario,
                      LocalDate fecNac, String sexUsuario, String telUsuario, String corUsuario,
                      String conUsuario, LocalDateTime fecCre, Boolean estUsuario, Long codRol) {
        this.codUsuario = codUsuario;
        this.numeroDocumento = numeroDocumento;
        this.apeUsuario = apeUsuario;
        this.nomUsuario = nomUsuario;
        this.fecNac = fecNac;
        this.sexUsuario = sexUsuario;
        this.telUsuario = telUsuario;
        this.corUsuario = corUsuario;
        this.conUsuario = conUsuario;
        this.fecCre = fecCre;
        this.estUsuario = estUsuario;
        this.codRol = codRol;
    }

    public Long getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Long codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApeUsuario() {
        return apeUsuario;
    }

    public void setApeUsuario(String apeUsuario) {
        this.apeUsuario = apeUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public String getSexUsuario() {
        return sexUsuario;
    }

    public void setSexUsuario(String sexUsuario) {
        this.sexUsuario = sexUsuario;
    }

    public String getTelUsuario() {
        return telUsuario;
    }

    public void setTelUsuario(String telUsuario) {
        this.telUsuario = telUsuario;
    }

    public String getCorUsuario() {
        return corUsuario;
    }

    public void setCorUsuario(String corUsuario) {
        this.corUsuario = corUsuario;
    }

    public String getConUsuario() {
        return conUsuario;
    }

    public void setConUsuario(String conUsuario) {
        this.conUsuario = conUsuario;
    }

    public LocalDateTime getFecCre() {
        return fecCre;
    }

    public void setFecCre(LocalDateTime fecCre) {
        this.fecCre = fecCre;
    }

    public Boolean getEstUsuario() {
        return estUsuario;
    }

    public void setEstUsuario(Boolean estUsuario) {
        this.estUsuario = estUsuario;
    }

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }
}

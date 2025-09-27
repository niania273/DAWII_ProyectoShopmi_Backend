package pe.edu.alicorp.commondto.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class RegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    // CLIENTE
    private String razonSocial;
    private String nroDoc;
    private String corCliente;

    // USUARIO
    private String apeUsuario;
    private String nomUsuario;
    private LocalDate fecNac;
    private String sexUsuario;   // expect "M" or "F"
    private String telUsuario;   // expect 9 digits
    private String corUsuario;
    private String password;

    public RegisterDTO() {}

    public RegisterDTO(String razonSocial, String nroDoc, String corCliente,
                       String apeUsuario, String nomUsuario, LocalDate fecNac,
                       String sexUsuario, String telUsuario, String corUsuario, String password) {
        this.razonSocial = razonSocial;
        this.nroDoc = nroDoc;
        this.corCliente = corCliente;
        this.apeUsuario = apeUsuario;
        this.nomUsuario = nomUsuario;
        this.fecNac = fecNac;
        this.sexUsuario = sexUsuario;
        this.telUsuario = telUsuario;
        this.corUsuario = corUsuario;
        this.password = password;
    }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getNroDoc() { return nroDoc; }
    public void setNroDoc(String nroDoc) { this.nroDoc = nroDoc; }

    public String getCorCliente() { return corCliente; }
    public void setCorCliente(String corCliente) { this.corCliente = corCliente; }

    public String getApeUsuario() { return apeUsuario; }
    public void setApeUsuario(String apeUsuario) { this.apeUsuario = apeUsuario; }

    public String getNomUsuario() { return nomUsuario; }
    public void setNomUsuario(String nomUsuario) { this.nomUsuario = nomUsuario; }

    public LocalDate getFecNac() { return fecNac; }
    public void setFecNac(LocalDate fecNac) { this.fecNac = fecNac; }

    public String getSexUsuario() { return sexUsuario; }
    public void setSexUsuario(String sexUsuario) { this.sexUsuario = sexUsuario; }

    public String getTelUsuario() { return telUsuario; }
    public void setTelUsuario(String telUsuario) { this.telUsuario = telUsuario; }

    public String getCorUsuario() { return corUsuario; }
    public void setCorUsuario(String corUsuario) { this.corUsuario = corUsuario; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override public String toString() {
        return "RegisterDTO{razonSocial='" + razonSocial + '\'' +
                ", nroDoc='" + nroDoc + '\'' +
                ", corCliente='" + corCliente + '\'' +
                ", apeUsuario='" + apeUsuario + '\'' +
                ", nomUsuario='" + nomUsuario + '\'' +
                ", fecNac=" + fecNac +
                ", sexUsuario='" + sexUsuario + '\'' +
                ", telUsuario='" + telUsuario + '\'' +
                ", corUsuario='" + corUsuario + '\'' +
                ", password='***'}";
    }
}

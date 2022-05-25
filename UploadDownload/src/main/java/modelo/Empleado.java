package modelo;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

public class Empleado {

    private int IDEMP;
    private String NOMEMP;
    private String APEEMP;
    private String DNIEMP;
    private double SUEEMP;
    private UploadedFile archivo;
    private StreamedContent archivoTraido;
    private String TIPEMP;

    public String getNOMEMP() {
        return NOMEMP;
    }

    public void setNOMEMP(String NOMEMP) {
        this.NOMEMP = NOMEMP;
    }

    public String getAPEEMP() {
        return APEEMP;
    }

    public void setAPEEMP(String APEEMP) {
        this.APEEMP = APEEMP;
    }

    public String getDNIEMP() {
        return DNIEMP;
    }

    public void setDNIEMP(String DNIEMP) {
        this.DNIEMP = DNIEMP;
    }



    public String getTIPEMP() {
        return TIPEMP;
    }

    public void setTIPEMP(String TIPEMP) {
        this.TIPEMP = TIPEMP;
    }

    public double getSUEEMP() {
        return SUEEMP;
    }

    public void setSUEEMP(double SUEEMP) {
        this.SUEEMP = SUEEMP;
    }

    public int getIDEMP() {
        return IDEMP;
    }

    public void setIDEMP(int IDEMP) {
        this.IDEMP = IDEMP;
    }

    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public StreamedContent getArchivoTraido() {
        return archivoTraido;
    }

    public void setArchivoTraido(StreamedContent archivoTraido) {
        this.archivoTraido = archivoTraido;
    }
}

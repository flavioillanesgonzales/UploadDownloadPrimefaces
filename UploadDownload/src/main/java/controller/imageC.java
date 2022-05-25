package controller;

import dao.imageD;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Empleado;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.CommonsUploadedFile;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;

@ManagedBean
@Named(value = "imageC")
public class imageC {

    private UploadedFile archivo;
    private UploadedFiles archivos;
    private StreamedContent archivoTraido;

    private imageD dao = new imageD();
    private Empleado emp = new Empleado();
    private List<Empleado> listadoEmp = new ArrayList<>();

    public void imageC() {
        archivo = new CommonsUploadedFile();
        archivoTraido = new DefaultStreamedContent();
        dao = new imageD();
        emp = new Empleado();
    }

    public void registrar() {
        try {
            dao.registrar(archivo, emp);
            archivo = null;
            emp = new Empleado();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrado", "Registrado con éxito"));
        } catch (Exception e) {
            System.out.println("Error en RegistrarC: " + e.getMessage());
        }
    }

    public void decargar() {
        try {
            System.out.println("El idemp es esto " + emp.getIDEMP());
            archivoTraido = dao.traerImagen(archivoTraido, emp.getIDEMP());
            System.out.println("Mi archivo traido : " + archivoTraido);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Descargado", "Descarga completada"));
        } catch (Exception e) {
            System.out.println("Error en Descargar: " + e.getMessage());
        }
    }

    public void listar() {
        try {
            listadoEmp = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en listar Empleados: " + e.getMessage());
        }
    }

    public void descargarPorId(Empleado emps) {
        try {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Descargado", "Descarga completada"));
        } catch (Exception e) {
            System.out.println("Error en DescargarCid: " + e.getMessage());
        }
    }

    public void limpiar() {
        emp = new Empleado();
    }

    // Ejemplo Primefaces
    public void subir() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Subido", "Subido Correctamente"));
    }

    public void upload() {
        if (archivos != null) {
            for (UploadedFile f : archivos.getFiles()) {
                FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    }


    public UploadedFile getArchivo() {
        return archivo;
    }

    public void setArchivo(UploadedFile archivo) {
        this.archivo = archivo;
    }

    public imageD getDao() {
        return dao;
    }

    public void setDao(imageD dao) {
        this.dao = dao;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public StreamedContent getArchivoTraido() {
        return archivoTraido;
    }

    public void setArchivoTraido(StreamedContent archivoTraido) {
        this.archivoTraido = archivoTraido;
    }

    public List<Empleado> getListadoEmp() {
        return listadoEmp;
    }

    public void setListadoEmp(List<Empleado> listadoEmp) {
        this.listadoEmp = listadoEmp;
    }

    public UploadedFiles getArchivos() {
        return archivos;
    }

    public void setArchivos(UploadedFiles archivos) {
        this.archivos = archivos;
    }

}

package dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import modelo.Empleado;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.util.SerializableSupplier;

public class imageD extends Conexion {

    public void registrar(UploadedFile archivo, Empleado emp) {
        try {
            String sql = "insert into EMPLEADO (NOMEMP,APEEMP,DNIEMP,SUEEMP,ESTEMP,IMAEMP,TIPEMP) values (?,?,?,?,'A',?,?)";
            if (archivo != null) {
                PreparedStatement ps = this.conectar().prepareStatement(sql);
                ps.setString(1, emp.getNOMEMP());
                ps.setString(2, emp.getAPEEMP());
                ps.setString(3, emp.getDNIEMP());
                ps.setDouble(4, emp.getSUEEMP());
                ps.setBinaryStream(5, archivo.getInputStream());
                ps.setString(6, emp.getTIPEMP());
                ps.executeUpdate();
                ps.close();
            } else {
                System.out.println("No ha entrado :((((");
            }

        } catch (Exception e) {
            System.out.println("Error en RegistrarDao: " + e.getMessage());
        }
    }
    
    
    public List<Empleado> listar(){
        List<Empleado> lista = new ArrayList<>();
        
        try {
            
        ResultSet rs;
        String sql = "SELECT * FROM EMPLEADO";
        PreparedStatement ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIDEMP(rs.getInt("IDEMP"));
                emp.setNOMEMP(rs.getString("NOMEMP"));
                emp.setAPEEMP(rs.getString("APEEMP"));
                emp.setDNIEMP(rs.getString("DNIEMP"));
                emp.setSUEEMP(rs.getDouble("SUEEMP"));
                emp.setTIPEMP(rs.getString("TIPEMP"));
                lista.add(emp);
            }
        } catch (Exception e) {
            System.out.println("Error en listarDao: " + e.getMessage());
        }
        return lista;
    }

    public StreamedContent traerImagen(StreamedContent archivo, int id) {

        String sql = "SELECT IMAEMP,NOMEMP,DNIEMP FROM EMPLEADO WHERE IDEMP =?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet st = ps.executeQuery();
            while (st.next()) {
                InputStream stream = st.getBinaryStream("IMAEMP");
                String nombre = st.getString("NOMEMP");
                String dni = st.getString("DNIEMP");
                archivo = DefaultStreamedContent.builder()
                        .name(nombre+" "+dni+".jpg")
                        .contentType("image/jpg")
                        .stream(() -> stream)
                        .build();
                
                System.out.println("Estoy en while dao traer imagen, " + archivo);
            }
        } catch (Exception e) {
            System.out.println("Error en traer imagen: " + e.getMessage());
        }
        return archivo;
    }

}

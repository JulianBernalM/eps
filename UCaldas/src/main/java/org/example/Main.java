package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@RestController
@CrossOrigin
public class Main {

    // ------------------- Obtener informacion plan de salud -------------------//
    @GetMapping("/infoPlanSalud")
    public static plan_salud getplan_salud(@RequestParam(value = "Nombre") String Nombre) {
        Conexion conn = new Conexion();
        // conn.getConnection();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM plan_salud WHERE Nombre = ?");
            // Scanner sc = new Scanner(System.in);
            // String Nombre = sc.next();
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            String respuesta = "";
            plan_salud f = new plan_salud();
            while (rs.next()) {
                f.setDescripcion(rs.getString("Descripcion"));
                f.setCosto(rs.getFloat("Costo"));
            }
            f.setNombre(Nombre);
            return f;

        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta");
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // ------------------- Crear plan de salud -------------------//
    @PostMapping("/crearPlanSalud")
    public void crearPlanSalud(@RequestBody plan_salud planSalud) {
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db
                    .prepareStatement("INSERT INTO plan_salud (Nombre, Descripcion, Costo) values (?,?,?)");
            ps.setString(1, planSalud.getNombre());
            ps.setString(2, planSalud.getDescripcion());
            ps.setFloat(3, planSalud.getCosto());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- Obtener informacion centro de salud -------------------//
    @GetMapping("/infoCentroSalud")
    public static centro_salud getcentro_salud(@RequestParam(value = "Nombre") String Nombre) {
        Conexion conn = new Conexion();
        // conn.getConnection();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM centro_salud WHERE Nombre = ?");
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            String respuesta = "";
            centro_salud f = new centro_salud();
            while (rs.next()) {
                f.setDireccion(rs.getString("Direccion"));
                f.setTelefono(rs.getString("Telefono"));
                f.setCiudad(rs.getString("Ciudad"));
                f.setTipo(rs.getString("Tipo"));
            }
            f.setNombre(Nombre);
            return f;

        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta");
        }
        return null;
    }

    // ------------------- Crear centro de salud -------------------//
    @PostMapping("/crearCentroSalud")
    public void crearCentroSalud(@RequestBody centro_salud centroSalud) {
        Conexion conn = new Conexion();

        try {
            System.out.println("Entro");
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO centro_salud (Nombre, Direccion, Telefono, Ciudad, Tipo) values (?,?,?,?,?)");
            ps.setString(1, centroSalud.getNombre());
            ps.setString(2, centroSalud.getDireccion());
            ps.setString(3, centroSalud.getTelefono());
            ps.setString(4, centroSalud.getCiudad());
            ps.setString(5, centroSalud.getTipo());

            System.out.println("Continuo");
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // --------------------Obtener informacion usuario -------------------//
    @GetMapping("/infoUsuario")
    public static usuario getUsuario(@RequestParam(value = "Nombre") String Nombre) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM usuario WHERE Nombre = ?");
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            String respuesta = "";
            usuario f = new usuario();
            while (rs.next()) {
                f.setContraseña(rs.getString("Contraseña"));
                f.setEmail(rs.getString("Email"));
                f.setRol(rs.getString("Rol"));
                f.setFk_Afiliado_ID(rs.getInt("fk_Afiliado_ID"));
                f.setFk_profesional_ID(rs.getInt("fk_profesional_ID"));
            }
            f.setNombre(Nombre);
            return f;

        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta");
        }
        return null;
    }

    // ------------------- Crear usuario -------------------//
    @PostMapping("/crearUsuario")
    public void crearUsuario(@RequestBody usuario user) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO usuario (Nombre, Contraseña, Email, Rol, fk_Afiliado_ID, fk_profesional_ID) VALUES (?,?,?,?,?,?)");
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getContraseña());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getRol());
            ps.setInt(5, user.getFk_Afiliado_ID());
            ps.setInt(6, user.getFk_profesional_ID());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- Obtener informacion profesional -------------------//
    @GetMapping("/infoProfesional")
    public static profesional getProfesional(@RequestParam(value = "Nombre") String Nombre) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM profesional WHERE Nombre = ?");
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            profesional p = new profesional();
            while (rs.next()) {
                p.setDocumento(rs.getString("Documento"));
                p.setEspecialidad(rs.getString("Especialidad"));
                p.setFk_centro_salud_ID(rs.getInt("fk_centro_salud_ID"));
                p.setEstado(rs.getString("Estado"));
            }
            p.setNombre(Nombre);
            return p;

        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta profesional");
        }
        return null;
    }

    // ------------------- Crear profesional -------------------//
    @PostMapping("/crearProfesional")
    public void crearProfesional(@RequestBody profesional prof) {
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO profesional (Nombre, Documento, Especialidad, fk_centro_salud_ID, Estado) values (?,?,?,?,?)");
            ps.setString(1, prof.getNombre());
            ps.setString(2, prof.getDocumento());
            ps.setString(3, prof.getEspecialidad());
            ps.setInt(4, prof.getFk_centro_salud_ID());
            ps.setString(5, prof.getEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- Obtener informacion afiliado -------------------//
    @GetMapping("/infoAfiliado")
    public static afiliado getAfiliado(@RequestParam(value = "Nombre_afiliado") String Nombre_afiliado) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM afiliado WHERE Nombre_afiliado = ?");
            st.setString(1, Nombre_afiliado);
            ResultSet rs = st.executeQuery();

            afiliado a = new afiliado();
            while (rs.next()) {
                a.setDocumento(rs.getString("Documento"));
                a.setTelefono(rs.getString("Telefono"));
                a.setFk_plan_salud_ID(rs.getInt("fk_plan_salud_ID"));
                a.setEstado(rs.getString("Estado"));
            }
            a.setNombre_afiliado(Nombre_afiliado);
            return a;

        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta afiliado");
        }
        return null;
    }

    // ------------------- Crear afiliado -------------------//
    @PostMapping("/crearAfiliado")
    public void crearAfiliado(@RequestBody afiliado aff) {
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO afiliado (Nombre_afiliado, Documento, Telefono, fk_plan_salud_ID, Estado) values (?,?,?,?,?)");
            ps.setString(1, aff.getNombre_afiliado());
            ps.setString(2, aff.getDocumento());
            ps.setString(3, aff.getTelefono());
            ps.setInt(4, aff.getFk_plan_salud_ID());
            ps.setString(5, aff.getEstado());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- Obtener información de factura -------------------//
    @GetMapping("/infoFactura")
    public static factura getFactura(@RequestParam(value = "Fecha_emision") String Fecha_emision) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM factura WHERE Fecha_emision = ?");
            st.setString(1, Fecha_emision);
            ResultSet rs = st.executeQuery();

            factura f = new factura();
            if (rs.next()) {
                f.setFecha_emision(java.sql.Date.valueOf(rs.getString("Fecha_emision")));
                f.setMonto(rs.getFloat("Monto"));
                f.setVencimiento(java.sql.Date.valueOf(rs.getString("Vencimiento")));
                f.setFk_afiliado_ID(rs.getInt("fk_afiliado_ID"));
                f.setFk_cita_ID(rs.getInt("fk_cita_ID"));
                f.setEstado_pago(rs.getString("Estado_pago"));
            }
            return f;
        } catch (Exception e) {
            System.out.println("Error ejecutando la consulta de factura: " + e.getMessage());
        }
        return null;
    }

    // ------------------- Crear factura -------------------//
    @PostMapping("/crearFactura")
    public void crearFactura(@RequestBody factura facturaNueva) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO factura (Fecha_emision, Monto, Vencimiento, fk_afiliado_ID, fk_cita_ID, Estado_pago) VALUES (?,?,?,?,?,?)");
            ps.setString(1, facturaNueva.getFecha_emision().toString());
            ps.setFloat(2, facturaNueva.getMonto());
            ps.setString(3, facturaNueva.getVencimiento().toString());
            ps.setInt(4, facturaNueva.getFk_afiliado_ID());
            ps.setInt(5, facturaNueva.getFk_cita_ID());
            ps.setString(6, facturaNueva.getEstado_pago());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    // ------------------- Obtener información de cita FALTA POR TERMINAR -------------------//
    @GetMapping("/infoCita")
    public static cita getCita(@RequestParam(value = "Fecha") String Fecha) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM cita WHERE Fecha = ?");
            st.setString(1, Fecha); // Fecha en formato ISO-8601 string
            ResultSet rs = st.executeQuery();

            cita c = new cita();
            if (rs.next()) {
                c.setFecha(java.time.LocalDateTime.parse(rs.getString("Fecha")));
                c.setEstado(rs.getString("Estado"));
                c.setFk_afiliado_ID(rs.getInt("fk_afiliado_ID"));
                c.setFk_profesional_ID(rs.getInt("fk_profesional_ID"));
                c.setFk_centro_salud_ID(rs.getInt("fk_centro_salud_ID"));
                c.setMotivo(rs.getString("Motivo"));
            }
            return c;
        } catch (Exception e) {
            System.out.println("Error ejecutando la consulta de cita: " + e.getMessage());
        }
        return null;
    }

    // ------------------- Crear cita FALTA POR TERMINAR-------------------//
    @PostMapping("/crearCita")
    public void crearCita(@RequestBody cita citaNueva) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO cita (Fecha, Estado, fk_afiliado_ID, fk_profesional_ID, fk_centro_salud_ID, Motivo) VALUES (?,?,?,?,?,?)");
            ps.setString(1, citaNueva.getFecha().toString());
            ps.setString(2, citaNueva.getEstado());
            ps.setInt(3, citaNueva.getFk_afiliado_ID());
            ps.setInt(4, citaNueva.getFk_profesional_ID());
            ps.setInt(5, citaNueva.getFk_centro_salud_ID());
            ps.setString(6, citaNueva.getMotivo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ------------------- Obtener información de historial clínico -------------------//
    @GetMapping("/infoHistorialClinico")
    public static historial_clinico getHistorialClinico(@RequestParam(value = "Fecha_consulta") String Fecha_consulta) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM historial_clinico WHERE Fecha_consulta = ?");
            st.setString(1, Fecha_consulta);
            ResultSet rs = st.executeQuery();

            historial_clinico h = new historial_clinico();
            if (rs.next()) {
                h.setFecha_consulta(new java.util.Date(rs.getDate("Fecha_consulta").getTime()));
                h.setDiagnostico(rs.getString("Diagnostico"));
                h.setTratamiento(rs.getString("Tratamiento"));
                h.setFk_afiliado_ID(rs.getInt("fk_afiliado_ID"));
                h.setFk_cita_ID(rs.getInt("fk_cita_ID"));
                h.setFk_Profesional_ID(rs.getInt("fk_Profesional_ID"));
            }
            return h;
        } catch (Exception e) {
            System.out.println("Error ejecutando la consulta de historial clínico: " + e.getMessage());
        }
        return null;
    }

    // ------------------- Crear historial clínico -------------------//
    @PostMapping("/crearHistorialClinico")
    public void crearHistorialClinico(@RequestBody historial_clinico historialNuevo) {
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement(
                    "INSERT INTO historial_clinico (Fecha_consulta, Diagnostico, Tratamiento, fk_afiliado_ID, fk_cita_ID, fk_Profesional_ID) VALUES (?,?,?,?,?,?)");
            ps.setDate(1, new java.sql.Date(historialNuevo.getFecha_consulta().getTime()));
            ps.setString(2, historialNuevo.getDiagnostico());
            ps.setString(3, historialNuevo.getTratamiento());
            ps.setInt(4, historialNuevo.getFk_afiliado_ID());
            ps.setInt(5, historialNuevo.getFk_cita_ID());
            ps.setInt(6, historialNuevo.getFk_Profesional_ID());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
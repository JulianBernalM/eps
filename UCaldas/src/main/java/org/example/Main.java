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
            PreparedStatement ps = db.prepareStatement("INSERT INTO usuario (Nombre, Contraseña, Email, Rol, fk_Afiliado_ID, fk_profesional_ID) VALUES (?,?,?,?,?,?)");
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

    //------------------- Obtener informacion profesional -------------------//
    @GetMapping("/infoProfesional")
    public static profesional getProfesional(@RequestParam(value="Nombre") String Nombre){
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM profesional WHERE Nombre = ?");
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            profesional p = new profesional();
            while(rs.next()){
                p.setDocumento(rs.getString("Documento"));
                p.setEspecialidad(rs.getString("Especialidad"));
                p.setFk_centro_salud_ID(rs.getInt("fk_centro_salud_ID"));
                p.setEstado(rs.getString("Estado"));
            }
            p.setNombre(Nombre);
            return p;

        }catch (SQLException e){
            System.out.println("Error ejecutando la consulta profesional");
        }
        return null;
    }

    //------------------- Crear profesional EN PROCESO -------------------//
    @PostMapping("/crearProfesional")
    public void crearProfesional(@RequestBody profesional prof){
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement("INSERT INTO profesional (Nombre, Documento, Especialidad, fk_centro_salud_ID, Estado) values (?,?,?,?,?)");
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

    //------------------- Obtener informacion afiliado -------------------//
    @GetMapping("/infoAfiliado")
    public static afiliado getAfiliado(@RequestParam(value="Nombre_afiliado") String Nombre_afiliado){
        Conexion conn = new Conexion();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM afiliado WHERE Nombre_afiliado = ?");
            st.setString(1, Nombre_afiliado);
            ResultSet rs = st.executeQuery();

            afiliado a = new afiliado();
            while(rs.next()){
                a.setDocumento(rs.getString("Documento"));
                a.setTelefono(rs.getString("Telefono"));
                a.setFk_plan_salud_ID(rs.getInt("fk_plan_salud_ID"));
                a.setEstado(rs.getString("Estado"));
            }
            a.setNombre_afiliado(Nombre_afiliado);
            return a;

        }catch (SQLException e){
            System.out.println("Error ejecutando la consulta afiliado");
        }
        return null;
    }

    //------------------- Crear afiliado -------------------//
    @PostMapping("/crearAfiliado")
    public void crearAfiliado(@RequestBody afiliado aff){
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement("INSERT INTO afiliado (Nombre_afiliado, Documento, Telefono, fk_plan_salud_ID, Estado) values (?,?,?,?,?)");
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
}
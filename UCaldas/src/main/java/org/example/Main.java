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


    //------------------- Obtener informacion plan de salud -------------------//
    @GetMapping("/infoPlanSalud")
    public static plan_salud getplan_salud(@RequestParam(value="Nombre") String Nombre){
        Conexion conn = new Conexion();
        //conn.getConnection();
        try {
            Connection db = conn.getConnection();
            PreparedStatement st = db.prepareStatement("SELECT * FROM plan_salud WHERE Nombre = ?");
//            Scanner sc = new Scanner(System.in);
//            String Nombre = sc.next();
            st.setString(1, Nombre);
            ResultSet rs = st.executeQuery();

            String respuesta = "";
            plan_salud f = new plan_salud();
            while(rs.next()){
                f.setDescripcion(rs.getString("Descripcion"));
                f.setCosto(rs.getFloat("Costo"));
            }
            f.setNombre(Nombre);
            return f;

        }catch (SQLException e){
            System.out.println("Error ejecutando la consulta");
        }
        return null;
    }

    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    //------------------- Crear plan de salud -------------------//
    @PostMapping("/crearPlanSalud")
    public void crearPlanSalud(@RequestBody plan_salud planSalud){
        Conexion conn = new Conexion();

        try {
            Connection db = conn.getConnection();
            PreparedStatement ps = db.prepareStatement("INSERT INTO plan_salud (Nombre, Descripcion, Costo) values (?,?,?)");
            ps.setString(1, planSalud.getNombre());
            ps.setString(2, planSalud.getDescripcion());
            ps.setFloat(3, planSalud.getCosto());

            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
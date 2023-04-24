/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Modelo;

import Seguridad.Controlador.clsTipoPersona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoTipoPersona {

    private static final String SQL_SELECT = "SELECT perTipoId, tipPerDescripcion, tipPerEstatus";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipopersona(tipPerDescripcion, tipPerEstatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipopersona SET tipPerDescripcion=?, tipPerEstatus=?  WHERE perTipoId = ?";
    private static final String SQL_DELETE = "DELETE FROM perTipoId WHERE perTipoId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT perTipoId, tipPerDescripcion, tipPerEstatus FROM tbl_tipopersona WHERE perTipoId = ?";
    private static final String SQL_SELECT_ID = "SELECT perTipoId, tipPerDescripcion, tipPerEstatus FROM tbl_tipopersona WHERE perTipoId = ?";     

    public List<clsTipoPersona> consultaTipPersona() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsTipoPersona> TipPersona = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perTipoId");
                String DescripcionTipoPersona = rs.getString("usunombre");
                String EstatusTipoPersona = rs.getString("usucontrasena");
		int tipoid= rs.getInt("perTipoId");
                clsTipoPersona TipPerona = new clsTipoPersona();
                TipPerona.setPerTipoId(id);
                TipPerona.setTipPerDescripcion(DescripcionTipoPersona);
                TipPerona.setTipPerEstatus(EstatusTipoPersona);

                TipPersona.add(TipPerona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return TipPersona;
    }

    public int ingresaTipPersona(clsTipoPersona TipPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, TipPersona.getTipPerDescripcion());
            stmt.setString(2, TipPersona.getTipPerEstatus());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaTipPersona(clsTipoPersona TipPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, TipPersona.getTipPerDescripcion());
            stmt.setString(2, TipPersona.getTipPerEstatus());
            stmt.setInt(3, TipPersona.getPerTipoId());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarTipPersona(clsTipoPersona TipPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, TipPersona.getPerTipoId());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsTipoPersona consultaTipPersonaPorId(clsTipoPersona TipPersona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + TipPersona);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, TipPersona.getPerTipoId());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("perTipoId");
                String DescripcionTipoPersona = rs.getString("tipPerDescripcion");
                String EstatusTipoPersona = rs.getString("tipPerEstatus");

                //usuario = new clsUsuario();
                TipPersona.setPerTipoId(id);
                TipPersona.setTipPerDescripcion(DescripcionTipoPersona);
                TipPersona.setTipPerEstatus(EstatusTipoPersona);

                System.out.println(" registro consultado: " + TipPersona);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return TipPersona;
    }    
}

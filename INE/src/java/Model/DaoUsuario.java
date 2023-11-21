package Model;

import java.sql.*;

public class DaoUsuario {

    ConnectionDB cn = new ConnectionDB();
    PreparedStatement ps;
    ResultSet rs;
    int attempts = 5;

    public int validAdmin(Admin admin) {
        String sqlQuery = "SELECT * FROM admin WHERE user_name = ? AND password_admin = ?";
        try {
            ps = cn.connectionMysql.prepareStatement(sqlQuery);
            ps.setString(1, admin.getUserName());
            ps.setString(2, admin.getPasswordAdmin());
            rs = ps.executeQuery();
            if (rs.next()) {
                admin.setIdAdmin(rs.getInt("id_admin"));
                rs.getString("user_name");
                rs.getString("password_admin");
                return 5;
            } else {
                return attempts -= 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public int validVotante(Votante votante) {
        String sqlQuery = "SELECT * FROM votante WHERE id_votante = ? AND nombre_votante = ? AND apellidos = ? AND fecha_nacimiento = ?;";
        try {
            ps = cn.connectionMysql.prepareStatement(sqlQuery);
            ps.setInt(1, votante.getIdVotante());
            ps.setString(2, votante.getvName());
            ps.setString(3, votante.getvLastName());
            ps.setString(4, votante.getvBirthday());
            rs = ps.executeQuery();
            if (rs.next()) {
                votante.setIdVotante(rs.getInt("id_votante"));
                rs.getString("nombre_votante");
                rs.getString("apellidos");
                return 5;
            } else {
                return attempts -= 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean insertNVotantes(Admin admin) {
        String query = "UPDATE admin SET n_votantes = ? WHERE id_admin = ? ;";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setInt(1, admin.getNVotantes());
            ps.setInt(2, admin.getIdAdmin());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createVotante(Votante votante) {
        String query = "INSERT INTO votante(nombre_votante, apellidos, edad, fecha_nacimiento, id_admin) values(?, ?, ?, ?, ?); ";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setString(1, votante.getvName());
            ps.setString(2, votante.getvLastName());
            ps.setInt(3, votante.getvAge());
            ps.setString(4, votante.getvBirthday());
            ps.setInt(5, votante.getIdAdmin());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean setVoto(Voto voto) {
        String query = "INSERT INTO votos(id_votante, id_partido) VALUES(?,?);";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setInt(1, voto.getIdVotante());
            ps.setString(2, voto.getIdPartido());
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para verificar si un votante ya ha votado
    public boolean hasVote(int idVotante) {
        try {
            String query = "SELECT * FROM votos WHERE id_votante = ?;";
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setInt(1, idVotante);
            rs = ps.executeQuery();
            return rs.next(); // Devuelve true si hay al menos una fila (el votante ya ha votado)
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getVotanteData(int idVotante, int idAdmin) {
        String query = " SELECT v.nombre_votante, v.apellidos, v.edad, v.fecha_nacimiento, v.id_admin FROM votante v JOIN admin a ON v.id_admin = a.id_admin WHERE v.id_votante = ? AND v.id_admin = ? ; ";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setInt(1, idVotante);
            ps.setInt(2, idAdmin);
            rs = ps.executeQuery();
            if (rs.next()) {
                html += "Datos del votante <br>";
                html += rs.getString("nombre_votante");
                html += "<br>";
                html += rs.getString("apellidos");
                html += "<br>";
                html += rs.getInt("edad") + " años";
                html += "<br>";
                html += rs.getString("fecha_nacimiento");
                html += "<br>";
                html += "Creado por el admin " + rs.getInt("id_admin");
            } else {
                html += "Datos no encontrados";
            }
            return html;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error " + e;
        }
    }
    
    public String getTotalVotantes(){
        String query = "SELECT SUM(n_votantes) as total_votantes FROM admin;";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                html += rs.getInt("total_votantes");
            }
            return html;
        } catch (Exception e) {
            return html += "Error : " + e;
        }
    
    }

    public String getPriVotos(){
        String query ="SELECT COUNT(*) as votos_pri FROM votos WHERE id_partido = 'PRI';";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                html += rs.getInt("votos_pri");
            }
            return html;
        } catch (Exception e) {
            return html += "Error : " + e;
        }
    }
    
    public String getPanVotos(){
        String query ="SELECT COUNT(*) as votos_pan FROM votos WHERE id_partido = 'PAN';";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                html += rs.getInt("votos_pan");
            }
            return html;
        } catch (Exception e) {
            return html += "Error : " + e;
        }
    }
    
    public String getMorenaVotos(){
        String query ="SELECT COUNT(*) as votos_morena FROM votos WHERE id_partido = 'MORENA';";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                html += rs.getInt("votos_morena");
            }
            return html;
        } catch (Exception e) {
            return html += "Error : " + e;
        }
    }
    
    public String hasNVotanes(int id_admin){
        String query = "SELECT n_votantes FROM admin WHERE id_admin = ?;";
        String html = "";
        try {
            ps = cn.connectionMysql.prepareStatement(query);
            ps.setInt(1, id_admin);
            rs = ps.executeQuery();
            while(rs.next()){
                html += rs.getInt("n_votantes");
            }
            return html;
        } catch (Exception e) {
            return html+=e;
        }
    }
}

package org.example.lab9_20202269.daos;
import org.example.lab9_20202269.beans.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends DaoBase{

    public boolean validarUsuarioPassword(String username, String password){
        boolean valido = false;
        String sql = "SELECT * FROM credenciales_usuario WHERE correo = ? AND contrasena = SHA2(?, 256)";
        try (Connection connection= getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    valido = true;
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valido;
    }
    public Usuario obtenerUsuario(String correo) {
        Usuario usuario1 = new Usuario();
        String sql = "SELECT * FROM base.credenciales_usuario c WHERE c.correo=?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,correo);

            try(ResultSet rs = pstmt.executeQuery()){

                if(rs.next()) {
                    usuario1 = new Usuario();
                    usuario1.setNombres(rs.getString(2));
                    usuario1.setApellidos(rs.getString(3));
                    usuario1.setTelefono(rs.getString(4));
                    usuario1.setRol_idrol(rs.getInt(5));
                    usuario1.setLicencia_idlicencia(rs.getInt(6));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario1;
    }

    public ArrayList<Usuario> listarUsuarios() {
        String sql = "SELECT " +
                "    u.idusuario AS 'ID Usuario', " +
                "    u.nombres AS 'Nombres', " +
                "    u.apellidos AS 'Apellidos', " +
                "    tl.categoria AS 'Tipo de licencia', " +
                "    tl.fecha_caducidad AS 'Estado de la licencia' " +
                "    pp.nombre_pais AS 'País de procedencia' " +
                "    rc.cancelada AS 'Reservas canceladas' " +
                "FROM " +
                "    usuario u " +
                "JOIN licencia tl ON u.licencia_idlicencia = tl.tipoLicencia " +
                "JOIN pais pp ON u.licencia_idlicencia = pp.paisProcedencia " +
                "JOIN licencia tl ON u.licencia_idlicencia = tl.reservasCanceladas ";


        ArrayList<Usuario> lista = new ArrayList<>();

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(setLocaleSql);
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("ID Usuario"));
                    usuario.setNombres(rs.getString("Nombres"));
                    usuario.setApellidos(rs.getString("Apellidos"));
                    usuario.setTipoLicencia(rs.getString("Tipo de licencia"));
                    usuario.setEstadoLicencia(rs.getString("Estado de la licencia"));
                    usuario.setPaisProcedencia(rs.getString("País de procedencia"));
                    usuario.setReservasCanceladas(rs.getInt("Reservas canceladas"));
                    lista.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}

package com.kdelectronics.dao;

import com.kdelectronics.conexion.ConexionBD;
import com.kdelectronics.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // INSERTAR
    public boolean insertar(Producto p) {

        String sql = "INSERT INTO productos " +
                "(codigo_producto, nombre, descripcion, precio_base, precio_venta, categoria, cantidad_disponible, estado) " +
                "VALUES (?,?,?,?,?,?,?,?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getCodigoProducto());
            ps.setString(2, p.getNombreProducto());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getPrecioBase());
            ps.setDouble(5, p.getPrecioVenta());
            ps.setString(6, p.getCategoria()); // ← STRING
            ps.setInt(7, p.getCantidadDisponible());
            ps.setInt(8, 1);

            ps.executeUpdate();
            System.out.println("✔ Producto insertado correctamente");
            return true;

        } catch (SQLException e) {
            System.out.println("✘ Error al insertar: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Producto> listar() {

        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE estado = 1";

        try (Connection conn = ConexionBD.conectar();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Producto p = new Producto(
                        rs.getString("codigo_producto"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio_base"),
                        rs.getDouble("precio_venta"),
                        rs.getString("categoria"), // ← STRING
                        rs.getInt("cantidad_disponible"),
                        rs.getInt("estado")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }

    // ELIMINAR LOGICO
    public boolean eliminar(String codigo) {

        String sql = "UPDATE productos SET estado = 0 WHERE codigo_producto = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codigo);
            ps.executeUpdate();
            System.out.println("✔ Producto eliminado lógicamente");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
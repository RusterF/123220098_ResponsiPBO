/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataDAO;
import java.sql.*;
import java.util.*;
import Koneksi.Connector;
import model.*;
import ImplementDAO.DataInterface;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class DAOData implements DataInterface {

    Connection connection;

    final String select = "SELECT * FROM buku";
    final String insert = "INSERT INTO buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?)";
    final String update = "UPDATE buku set penulis=?, rating=?, harga=? WHERE judul=?;";
    final String delete = "delete from buku WHERE judul=?";

    public DAOData() {
        connection = Connector.connection();
    }

    @Override
    public void insert(BukuData m) {
        PreparedStatement statement = null;
        try {
            if (m.getRating() < 0 || m.getRating() > 5 ) {
                throw new SQLException("Nilai rating harus berada di antara 0 dan 5");
            }
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setString(2, m.getPenulis());
            statement.setDouble(3, m.getRating());
            statement.setDouble(4, m.getHarga());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            throw new SQLException("Data Buku Berhasil Ditambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(BukuData m) {
        PreparedStatement statement = null;
        try {
             if (m.getRating() < 0 || m.getRating() > 5 ) {
                throw new SQLException("Nilai rating harus berada di antara 0 dan 5");
            }
            statement = connection.prepareStatement(update);
            statement.setString(1, m.getPenulis());
            statement.setDouble(2, m.getRating());
            statement.setDouble(3, m.getHarga());
            statement.setString(4, m.getJudul());
            statement.executeUpdate();
            throw new SQLException("Data Buku Berhasil Diupdate");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setString(1, judul);
            statement.executeUpdate();
            throw new SQLException("Data Buku Berhasil Dihapus");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<BukuData> getALL() {
        List<BukuData> dm = null;
        try {
            dm = new ArrayList<BukuData>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                BukuData buku = new BukuData();
                buku.setJudul(rs.getString("judul"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setRating(rs.getDouble("rating"));
                buku.setHarga(rs.getDouble("harga"));
                dm.add(buku);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dm;
    }
}

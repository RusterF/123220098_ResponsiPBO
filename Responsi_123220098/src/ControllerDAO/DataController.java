/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerDAO;
import java.util.List;
import DataDAO.DAOData;
import ImplementDAO.DataInterface;
import javax.swing.JOptionPane;
import model.*;
import Tampilan.MainView;
/**
 *
 * @author LENOVO
 */
public class DataController {
    
    MainView frame;
    DataInterface ImplDataMovie;
    List<BukuData> dm;

    public DataController(MainView frame) {
        this.frame = frame;
        ImplDataMovie = new DAOData();
        dm = ImplDataMovie.getALL();
    }

    public void isiTabel() {
        dm = ImplDataMovie.getALL();
        ModelTabel mm = new ModelTabel(dm);
        frame.getTabelDataBuku().setModel(mm);
    }

    public void insert() {
        BukuData dm = new BukuData();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setPenulis (frame.getJTxtpenulis().getText());
        dm.setRating(Double.parseDouble(frame.getJTxtrating().getText()));
        dm.setinputHarga(Double.parseDouble(frame.getJTxtinputHarga().getText()));
        dm.setHarga(dm.getHarga());
        ImplDataMovie.insert(dm);
    }

    public void update() {
        BukuData dm = new BukuData();
        dm.setJudul(frame.getJTxtjudul().getText());
        dm.setPenulis (frame.getJTxtpenulis().getText());
        dm.setRating(Double.parseDouble(frame.getJTxtrating().getText()));
        dm.setinputHarga(Double.parseDouble(frame.getJTxtinputHarga().getText()));
        dm.setHarga(dm.getHarga());
        ImplDataMovie.update(dm);
    }

    public void delete() {
        String judul = frame.getJTxtjudul().getText();
        ImplDataMovie.delete(judul);
    }

}

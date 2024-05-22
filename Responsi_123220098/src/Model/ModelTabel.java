/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class ModelTabel extends AbstractTableModel {

    List<BukuData> dm;

    public ModelTabel(List<BukuData> dm) {
        this.dm = dm;
    }

    @Override
    public int getRowCount() {
        return dm.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dm.get(row).getJudul();
            case 1:
                return dm.get(row).getPenulis();
            case 2:
                return dm.get(row).getRating();
            case 3:
                return dm.get(row).getHarga();
            default:
                return null;
        }
    }
}

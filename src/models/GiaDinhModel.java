/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Hien Phan
 */
public class GiaDinhModel {

    private int id;
    private int idHoKhau;
    private int idNhanKhau;
    private String qhChuHo;

    public GiaDinhModel() {
    }

    public GiaDinhModel(int idHoKhau, int idNhanKhau, String qhChuHo) {
        this.idHoKhau = idHoKhau;
        this.idNhanKhau = idNhanKhau;
        this.qhChuHo = qhChuHo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getQhChuHo() {
        return qhChuHo;
    }

    public void setQhChuHo(String qhChuHo) {
        this.qhChuHo = qhChuHo;
    }

}

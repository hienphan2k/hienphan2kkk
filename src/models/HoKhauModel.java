/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Hien Phan
 */
public class HoKhauModel {

    private int id;
    private String maHoKhau;
    private String hoTenChuHo;
    private String cmndChuHo;
    private String diaChi;
    private Date ngayLap;
    private Date ngayChuyenDi;
    private String tinhTrang;

    public HoKhauModel() {
    }

    public HoKhauModel(String maHoKhau, String cmndChuHo, String diaChi, Date ngayLap, String tinhTrang) {
        this.maHoKhau = maHoKhau;
        this.cmndChuHo = cmndChuHo;
        this.diaChi = diaChi;
        this.ngayLap = ngayLap;
        this.tinhTrang = tinhTrang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getHoTenChuHo() {
        return hoTenChuHo;
    }

    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }

    public String getCmndChuHo() {
        return cmndChuHo;
    }

    public void setCmndChuHo(String cmndChuHo) {
        this.cmndChuHo = cmndChuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayChuyenDi() {
        return ngayChuyenDi;
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}

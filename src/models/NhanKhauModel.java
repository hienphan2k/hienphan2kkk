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
public class NhanKhauModel {

    private int id;
    private String maHoKhau;
    private String hoTen;
    private String biDanh;
    private Date ngaySinh;
    private String gioiTinh;
    private String noiSinh;
    private String nguyenQuan;
    private String dcHienNay;
    private String danToc;
    private String tonGiao;
    private String quocTich;
    private String ngheNghiep;
    private String noiLamViec;
    private String cmnd;
    private Date ngayCap;
    private String noiCap;
    private Date ngayChuyenDen;
    private String noiTruocChuyenDen;
    private Date ngayChuyenDi;
    private String noiDen;
    private String tinhTrang;
    private Date tuNgay;
    private Date denNgay;
    private Date ngayLap;

    public NhanKhauModel() {
    }

    public NhanKhauModel(String hoTen, Date ngaySinh, String gioiTinh, String quocTich, String cmnd, 
            String noiTruocChuyenDen, String dcHienNay, String tinhTrang, Date tuNgay, Date denNgay, Date ngayLap) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.noiTruocChuyenDen = noiTruocChuyenDen;
        this.dcHienNay = dcHienNay;
        this.tinhTrang = tinhTrang;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.ngayLap = ngayLap;
    }

    
    public NhanKhauModel(String maHoKhau, String hoTen, String biDanh, Date ngaySinh, String gioiTinh,
            String noiSinh, String nguyenQuan, String dcHienNay, String danToc, String tonGiao, String quocTich,
            String ngheNghiep, String noiLamViec, String cmnd, Date ngayCap, String noiCap, Date ngayChuyenDen,
            String noiTruocChuyenDen, Date ngayChuyenDi, String tinhTrang, Date ngayLap) {
        this.maHoKhau = maHoKhau;
        this.hoTen = hoTen;
        this.biDanh = biDanh;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.dcHienNay = dcHienNay;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.quocTich = quocTich;
        this.ngheNghiep = ngheNghiep;
        this.noiLamViec = noiLamViec;
        this.cmnd = cmnd;
        this.ngayCap = ngayCap;
        this.noiCap = noiCap;
        this.ngayChuyenDen = ngayChuyenDen;
        this.noiTruocChuyenDen = noiTruocChuyenDen;
        this.ngayChuyenDi = ngayChuyenDi;
        this.tinhTrang = tinhTrang;
        this.ngayLap = ngayLap;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDcHienNay() {
        return dcHienNay;
    }

    public void setDcHienNay(String dcHienNay) {
        this.dcHienNay = dcHienNay;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(Date ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNoiCap() {
        return noiCap;
    }

    public void setNoiCap(String noiCap) {
        this.noiCap = noiCap;
    }

    public Date getNgayChuyenDen() {
        return ngayChuyenDen;
    }

    public void setNgayChuyenDen(Date ngayChuyenDen) {
        this.ngayChuyenDen = ngayChuyenDen;
    }

    public String getNoiTruocChuyenDen() {
        return noiTruocChuyenDen;
    }

    public void setNoiTruocChuyenDen(String noiTruocChuyenDen) {
        this.noiTruocChuyenDen = noiTruocChuyenDen;
    }

    public Date getNgayChuyenDi() {
        return ngayChuyenDi;
    }

    public void setNgayChuyenDi(Date ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

}

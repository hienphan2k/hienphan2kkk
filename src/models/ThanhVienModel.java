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
public class ThanhVienModel {
    public NhanKhauModel nhanKhau;
    public GiaDinhModel giaDinh;

    public ThanhVienModel(NhanKhauModel nhanKhau, GiaDinhModel giaDinh) {
        this.nhanKhau = nhanKhau;
        this.giaDinh = giaDinh;
    } 
}

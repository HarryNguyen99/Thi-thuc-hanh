import java.awt.peer.SystemTrayPeer;
import java.io.Serializable;

public class DanhBa implements Serializable {
    public static final String FORMAT = "%5d | %20s | %11s | %30s | %20s | %30s";
    private int id;
    private String hoTen;
    private String soDienThoai;
    private String emali;
    private String facebook;
    private String điaChi;

    public DanhBa() {
    }

    public DanhBa(String hoTen, String soDienThoai, String emali, String facebook, String điaChi) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.emali = emali;
        this.facebook = facebook;
        this.điaChi = điaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmali() {
        return emali;
    }

    public void setEmali(String emali) {
        this.emali = emali;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getĐiaChi() {
        return điaChi;
    }

    public void setĐiaChi(String điaChi) {
        this.điaChi = điaChi;
    }

    @Override
    public String toString() {
        return String.format(FORMAT,id, hoTen, soDienThoai, emali, facebook, getĐiaChi());
    }
}

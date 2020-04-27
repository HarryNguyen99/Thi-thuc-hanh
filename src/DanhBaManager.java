import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DanhBaManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<DanhBa> danhBaList;
    private DanhBaDao danhBaDao;

    public DanhBaManager() {
        danhBaDao = new DanhBaDao();
        danhBaList = danhBaDao.read();
    }

    public void add() {
        int id = danhBaList.size();
        System.out.println("id danh bạ = " + id);
        String hoten = inputHoTen();
        String sdt = inputSdt();
        String email = inputEmail();
        String facebook = inputFacebook();
        String diachi = inputDiaChi();
        DanhBa danhBa = new DanhBa(hoten, sdt, email, facebook, diachi);
        danhBa.setId(id);
        danhBaList.add(danhBa);
        danhBaDao.write(danhBaList);
    }

    public void edit(int id) {
        boolean isExisted = false;
        int size = danhBaList.size();
        for (int i = 0; i < size; i++) {
            if (danhBaList.get(i).getId() == id) {
                isExisted = true;
                danhBaList.get(i).setHoTen(inputHoTen());
                danhBaList.get(i).setSoDienThoai(inputSdt());
                danhBaList.get(i).setEmali(inputEmail());
                danhBaList.get(i).setFacebook(inputFacebook());
                danhBaList.get(i).setĐiaChi(inputDiaChi());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("id = %d không tồn tại.\n", id);
        } else {
            danhBaDao.write(danhBaList);
        }
    }

    public void delete(int id) {
        DanhBa danhBa = null;
        int size = danhBaList.size();
        for (int i = 0; i < size; i++) {
            if (danhBaList.get(i).getId() == id) {
                danhBa = danhBaList.get(i);
                break;
            }
        }
        if (danhBa != null) {
            danhBaList.remove(danhBa);
            danhBaDao.write(danhBaList);
        } else {
            System.out.printf("id = %d không tồn tại.\n", id);
        }
    }

    public void show() {
        for (DanhBa danhBa : danhBaList) {
            System.out.format("%5s | ", danhBa.getId());
            System.out.format("%20s | ", danhBa.getHoTen());
            System.out.format("%11s | ", danhBa.getSoDienThoai());
            System.out.format("%30s | ", danhBa.getEmali());
            System.out.format("%20s | ", danhBa.getFacebook());
            System.out.format("%30s", danhBa.getĐiaChi());
            System.out.println();
        }
    }

    public DanhBa timkiemTD(String ten){
        for (DanhBa danhBa : danhBaList){
            if (danhBa.getHoTen().equals(ten)){
                return danhBa;
            }
        }
        return null;
    }

    public int inputId() {
        System.out.print("Nhập id danh bạ: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("không hợp lệ! Nhập lại id danh bạ: ");
            }
        }
    }

    public String inputHoTen() {
        System.out.print("Nhập Tên: ");
        return scanner.nextLine();
    }

    private String inputSdt() {
        System.out.print("Nhập SĐT: ");
        return scanner.nextLine();
    }

    private String inputEmail() {
        System.out.print("Nhập Email: ");
        return scanner.nextLine();
    }

    private String inputFacebook() {
        System.out.print("Nhập Facebook: ");
        return scanner.nextLine();
    }

    private String inputDiaChi() {
        System.out.print("Nhập địa chỉ: ");
        return scanner.nextLine();
    }

}

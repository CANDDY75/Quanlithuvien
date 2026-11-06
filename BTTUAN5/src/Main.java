
import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    double gia;
    int soLuong;
}

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Sach[] dsSach = null;
        int n = 0;
        int luaChon;

        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Tinh tong so luong va tong gia tri sach");
            System.out.println("3. Tim sach theo ma");
            System.out.println("4. Thoat");
            System.out.println("======================================");
            // (Chưa có chức năng xóa sách, chưa có chức năng sửa thông tin sách.)
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {

                // BAI 1: NHAP N SACH BANG VONG LAP
                case 1:
                    System.out.print("Nhap so luong sach: ");
                    n = sc.nextInt();
                    sc.nextLine();
                    // (Muốn bổ sung sách mới thường phải nhập lại danh sách.)
                    if (n <= 0) {
                        System.out.println("So luong sach khong hop le!");
                        dsSach = null;
                        n = 0;
                        break;
                    }

                    dsSach = new Sach[n];

                    for (int i = 0; i < n; i++)
                    {
                        dsSach[i] = new Sach();

                        System.out.println("\nNhap thong tin sach thu " + (i + 1));

                        System.out.print("Ma sach: ");
                        dsSach[i].maSach = sc.nextLine();

                        System.out.print("Ten sach: ");
                        dsSach[i].tenSach = sc.nextLine();

                        System.out.print("Gia sach: ");
                        dsSach[i].gia = sc.nextDouble();

                        System.out.print("So luong: ");
                        dsSach[i].soLuong = sc.nextInt();
                        sc.nextLine();
                    }

                    System.out.println("\nNhap danh sach sach thanh cong!");
                    break;

                // BAI 2: TINH TONG SO LUONG VA TONG GIA TRI
                case 2:
                    if (dsSach == null)
                    {
                        System.out.println("Vui long nhap danh sach sach truoc!");
                        break;
                    }

                    int tongSoLuong = 0;
                    double tongGiaTri = 0;

                    for (int i = 0; i < n; i++)
                    {
                        tongSoLuong += dsSach[i].soLuong;

                        tongGiaTri += dsSach[i].gia * dsSach[i].soLuong;
                    }

                    System.out.println("\n===== KET QUA =====");
                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    System.out.println("Tong gia tri sach: " + tongGiaTri);
                    break;

                // BAI 3 VA BAI 4: MENU LAP VA TIM SACH THEO MA
                case 3:
                    if (dsSach == null)
                    {
                        System.out.println("Vui long nhap danh sach sach truoc!");
                        break;
                    }

                    String maTim;
                    boolean timThay = false;

                    System.out.print("Nhap ma sach can tim: ");
                    maTim = sc.nextLine();

                    for (int i = 0; i < n; i++) {
                        if (dsSach[i].maSach.equalsIgnoreCase(maTim))
                        {
                            System.out.println("\nTim thay sach!");
                            System.out.println("Ma sach: " + dsSach[i].maSach);
                            System.out.println("Ten sach: " + dsSach[i].tenSach);
                            System.out.println("Gia sach: " + dsSach[i].gia);
                            System.out.println("So luong: " + dsSach[i].soLuong);

                            timThay = true;
                            break;
                        }
                    }

                    if (timThay == false)
                    {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                // THOAT CHUONG TRINH
                case 4:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luaChon != 4);

        sc.close();
    }
}

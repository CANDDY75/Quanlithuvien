import java.util.ArrayList;
import java.util.Scanner;

class Sach {
    String maSach;
    String tenSach;
    double gia;
    int soLuong;
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    // BAI 1: MANG SO LUONG 5 CUON SACH
    public static void bai1() {
        int[] soLuong = new int[5];

        int tong = 0;
        int lonNhat;

        for (int i = 0; i < 5; i++)
        {
            System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.println("\nDanh sach so luong sach:");

        lonNhat = soLuong[0];

        for (int i = 0; i < 5; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);

            tong += soLuong[i];

            if (soLuong[i] > lonNhat)
            {
                lonNhat = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + lonNhat);
    }
    // BAI 2: ARRAYLIST LUU MA SACH
    public static void bai2() {
        ArrayList<String> maSach = new ArrayList<>();

        int chon;

        do {
            System.out.println("\n===== BAI 2: QUAN LY MA SACH =====");
            System.out.println("1. Them ma sach");
            System.out.println("2. Hien thi ma sach");
            System.out.println("3. Tim ma sach");
            System.out.println("4. Xoa ma sach");
            System.out.println("5. Quay lai");

            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma sach: ");
                    String ma = sc.nextLine();

                    maSach.add(ma);

                    System.out.println("Them thanh cong!");
                    break;

                case 2:
                    System.out.println("Danh sach ma sach:");

                    for (int i = 0; i < maSach.size(); i++)
                    {
                        System.out.println(maSach.get(i));
                    }
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    ma = sc.nextLine();

                    if (maSach.contains(ma)) {
                        System.out.println("Tim thay ma sach!");
                    }
                    else {
                        System.out.println("Khong tim thay ma sach!");
                    }
                    break;

                case 4:
                    System.out.print("Nhap ma sach can xoa: ");
                    ma = sc.nextLine();

                    if (maSach.remove(ma))
                    {
                        System.out.println("Xoa thanh cong!");
                    }
                    else
                    {
                        System.out.println("Khong tim thay ma sach!");
                    }
                    break;

                case 5:
                    System.out.println("Quay lai menu chinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 5);
    }

    // DANH SACH LUU THONG TIN SACH
    // Moi cuon sach duoc luu thanh:
    // Ma sach ; Ten sach ;Gia ;So luong

    static ArrayList<String> danhSachSach = new ArrayList<>();
    // HAM THEM SACH
    public static void themSach() {
        System.out.print("Nhap ma sach: ");
        String ma = sc.nextLine();

        System.out.print("Nhap ten sach: ");
        String ten = sc.nextLine();

        System.out.print("Nhap gia sach: ");
        double gia = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());

        String sach = ma + ";" + ten + ";" + gia + ";" + soLuong;

        danhSachSach.add(sach);

        System.out.println("Them sach thanh cong!");
    }

    // HAM HIEN THI SACH
    public static void hienThiSach() {
        if (danhSachSach.size() == 0)
        {
            System.out.println("Danh sach sach trong!");
        }
        else
        {
            for (int i = 0; i < danhSachSach.size(); i++)
            {
                String[] thongTin = danhSachSach.get(i).split(";");

                System.out.println("\nSach thu " + (i + 1));
                System.out.println("Ma sach: " + thongTin[0]);
                System.out.println("Ten sach: " + thongTin[1]);
                System.out.println("Gia sach: " + thongTin[2]);
                System.out.println("So luong: " + thongTin[3]);
            }
        }
    }

    // HAM TIM VI TRI SACH THEO MA
    public static int timSach(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] thongTin = danhSachSach.get(i).split(";");

            if (thongTin[0].equalsIgnoreCase(ma)) {
                return i;
            }
        }

        return -1;
    }

    // HAM XOA SACH
    public static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = sc.nextLine();

        int viTri = timSach(ma);

        if (viTri != -1) {
            danhSachSach.remove(viTri);
            System.out.println("Xoa sach thanh cong!");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }

    // HAM SUA SACH
    public static void suaSach() {
        System.out.print("Nhap ma sach can sua: ");
        String ma = sc.nextLine();

        int viTri = timSach(ma);

        if (viTri != -1) {
            String[] thongTin = danhSachSach.get(viTri).split(";");

            System.out.print("Nhap ten sach moi: ");
            String ten = sc.nextLine();

            System.out.print("Nhap gia sach moi: ");
            double gia = Double.parseDouble(sc.nextLine());

            System.out.print("Nhap so luong moi: ");
            int soLuong = Integer.parseInt(sc.nextLine());

            String sachMoi = thongTin[0] + ";" + ten + ";" + gia + ";" + soLuong;

            danhSachSach.set(viTri, sachMoi);

            System.out.println("Sua sach thanh cong!");
        } else {
            System.out.println("Khong tim thay sach!");
        }
    }
            // BAI 3: QUAN LY DANH SACH SACH
    public static void bai3() {
        int chon;

        do {
            System.out.println("\n===== BAI 3: DANH SACH SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Quay lai");

            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;

                case 2:
                    hienThiSach();
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String ma = sc.nextLine();

                    int viTri = timSach(ma);

                    if (viTri != -1)
                    {
                        System.out.println("Tim thay sach:");
                        System.out.println(danhSachSach.get(viTri));
                    }
                    else
                    {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 4:
                    xoaSach();
                    break;

                case 5:
                    suaSach();
                    break;

                case 6:
                    System.out.println("Quay lai menu chinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 6);
    }

    // BAI 4: MENU QUAN LY SACH HOAN CHINH
    public static void bai4() {
        int chon;

        do {
            System.out.println("\n========== MENU QUAN LY SACH ==========");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Quay lai");
            System.out.println("=======================================");

            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themSach();
                    break;

                case 2:
                    hienThiSach();
                    break;

                case 3:
                    System.out.print("Nhap ma sach can tim: ");
                    String ma = sc.nextLine();

                    int viTri = timSach(ma);

                    if (viTri != -1) {
                        System.out.println("Tim thay sach:");
                        System.out.println(danhSachSach.get(viTri));
                    } else {
                        System.out.println("Khong tim thay sach!");
                    }
                    break;

                case 4:
                    xoaSach();
                    break;

                case 5:
                    suaSach();
                    break;

                case 6:
                    int tongSoLuong = 0;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        String[] thongTin = danhSachSach.get(i).split(";");

                        tongSoLuong += Integer.parseInt(thongTin[3]);
                    }

                    System.out.println("Tong so luong sach: " + tongSoLuong);
                    break;

                case 7:
                    double tongGiaTri = 0;

                    for (int i = 0; i < danhSachSach.size(); i++) {
                        String[] thongTin = danhSachSach.get(i).split(";");

                        double gia = Double.parseDouble(thongTin[2]);
                        int soLuong = Integer.parseInt(thongTin[3]);

                        tongGiaTri += gia * soLuong;
                    }

                    System.out.println("Tong gia tri sach: " + tongGiaTri);
                    break;

                case 8:
                    System.out.println("Thoat menu quan ly sach!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 8);
    }




    // HAM MAIN
    public static void main(String[] args){

        int luaChon;

        do {
            System.out.println("\n========== QUAN LY THU VIEN ==========");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Luu ma sach");
            System.out.println("3. dach sách");
            System.out.println("4. Menu quản lý sách");
            System.out.println("5. Thoát chương trình");
            System.out.println("======================================");
            // Chưa có chức năng xóa sách, chưa có chức năng sửa thông tin sách.
            System.out.print("Nhap lua chon: ");
            luaChon = sc.nextInt();
            sc.nextLine();
            switch (luaChon) {
                case 1:
                    bai1();
                    break;

                case 2:
                    bai2();
                    break;

                case 3:
                    bai3();
                    break;

                case 4:
                    bai4();
                    break;

                case 5:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (luaChon != 5);

        sc.close();
    }
}

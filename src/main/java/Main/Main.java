package Main;

import data.Donor;
import data.PengelolaDonor;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        PengelolaDonor pengelola = new PengelolaDonor();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("+----------------------------------------+");
            System.out.println("|     Manajemen Pengelolaan Data Donor   |");
            System.out.println("+----------------------------------------+");
            System.out.println("| 1. Tambah Donor                        |");
            System.out.println("| 2. Hapus Donor                         |");
            System.out.println("| 3. Tampilkan Semua Donor               |");
            System.out.println("| 4. Cari Donor                          |");
            System.out.println("| 5. Update Donor                        |");
            System.out.println("| 6. Keluar                              |");
            System.out.println("+----------------------------------------+");
            System.out.print("Pilih menu: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama: ");
                    String nama = scanner.nextLine();

                    int usia;
                    do {
                        System.out.print("Masukkan usia (minimal 17 tahun): ");
                        usia = scanner.nextInt();
                        if (usia < 17) {
                            System.out.println("Usia tidak valid. Minimal 17 tahun.");
                        }
                    } while (usia < 17);
                    scanner.nextLine();

                    String golonganDarah;
                    do {
                        System.out.print("Masukkan golongan darah (A+, A-, B+, B-, AB+, AB-, O+, O-): ");
                        golonganDarah = scanner.nextLine().toUpperCase();
                        
                        if (!Pattern.matches("^(A|B|AB|O)[+-]$", golonganDarah)) {
                            System.out.println("Golongan darah tidak valid. Silakan masukkan lagi.");
                        }
                    } while (!Pattern.matches("^(A|B|AB|O)[+-]$", golonganDarah));

                    Donor donorBaru = new Donor(nama, usia, golonganDarah);
                    pengelola.tambahDonor(donorBaru);
                    break;

                case 2:
                    System.out.print("Masukkan ID donor yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    pengelola.hapusDonor(idHapus);
                    break;

                case 3:
                    pengelola.tampilkanSemuaDonor();
                    break;

                case 4:
                    System.out.print("Masukkan ID donor yang ingin dicari: ");
                    int idCari = scanner.nextInt();
                    pengelola.cariDonor(idCari);
                    break;

                case 5:
                    System.out.print("Masukkan ID donor yang ingin diupdate: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan usia baru: ");
                    int usiaBaru = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Masukkan golongan darah baru (A+, A-, B+, B-, AB+, AB-, O+, O-): ");
                    String golonganDarahBaru = scanner.nextLine();
                    pengelola.updateDonor(idUpdate, namaBaru, usiaBaru, golonganDarahBaru);
                    break;

                case 6:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}

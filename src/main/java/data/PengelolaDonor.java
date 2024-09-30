package data;

import java.util.ArrayList;

public class PengelolaDonor {
    private ArrayList<Donor> daftarDonor = new ArrayList<>();

    public void tambahDonor(Donor donor) {
        if (validasiGolonganDarah(donor.getGolonganDarah()) && validasiUsia(donor.getUsia())) {
            daftarDonor.add(donor);
            System.out.println("Donor berhasil ditambahkan.");
        } else {
            System.out.println("Data donor tidak valid.");
        }
    }

    private boolean validasiGolonganDarah(String golonganDarah) {
        return golonganDarah.equalsIgnoreCase("A") ||
               golonganDarah.equalsIgnoreCase("B") ||
               golonganDarah.equalsIgnoreCase("AB") ||
               golonganDarah.equalsIgnoreCase("O");
    }

    private boolean validasiUsia(int usia) {
        return usia >= 17;
    }

    public void tampilkanSemuaDonor() {
        if (daftarDonor.isEmpty()) {
            System.out.println("Tidak ada data donor.");
        } else {
            System.out.println("+-----+----------------------+------+-----+");
            System.out.println("| ID  | Nama                 | Usia | Gol |");
            System.out.println("+-----+----------------------+------+-----+");
            for (Donor donor : daftarDonor) {
                donor.tampilkanInfo();
            }
            System.out.println("+-----+----------------------+------+-----+");
        }
    }

    public void updateDonor(int id, String namaBaru, int usiaBaru, String golonganDarahBaru) {
        for (Donor donor : daftarDonor) {
            if (donor.getId() == id) {
                if (validasiGolonganDarah(golonganDarahBaru) && validasiUsia(usiaBaru)) {
                    donor.setNama(namaBaru);
                    donor.setUsia(usiaBaru);
                    donor.setGolonganDarah(golonganDarahBaru);
                    System.out.println("Data donor berhasil diperbarui.");
                } else {
                    System.out.println("Data donor tidak valid.");
                }
                return;
            }
        }
        System.out.println("Donor dengan ID " + id + " tidak ditemukan.");
    }

    public void cariDonor(int id) {
        for (Donor donor : daftarDonor) {
            if (donor.getId() == id) {
                System.out.println("+-----+----------------------+------+-----+");
                System.out.println("| ID  | Nama                 | Usia | Gol |");
                System.out.println("+-----+----------------------+------+-----+");
                donor.tampilkanInfo();
                System.out.println("+-----+----------------------+------+-----+");
                return;
            }
        }
        System.out.println("Donor dengan ID " + id + " tidak ditemukan.");
    }
    public void hapusDonor(int id) {
    for (Donor donor : daftarDonor) {
        if (donor.getId() == id) {
            daftarDonor.remove(donor);
            System.out.println("Donor dengan ID " + id + " berhasil dihapus.");
            return;
        }
    }
    System.out.println("Donor dengan ID " + id + " tidak ditemukan.");
}

}

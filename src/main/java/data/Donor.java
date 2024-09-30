package data;

public class Donor {
    private static int idCounter = 1; 
    private int id;
    private String nama;
    private int usia;
    private String golonganDarah;

    public static int jumlahDonor = 0;

    public Donor(String nama, int usia, String golonganDarah) {
        this.id = idCounter++; 
        this.nama = nama;
        this.usia = usia;
        this.golonganDarah = golonganDarah;
        jumlahDonor++;
    }

    public void tampilkanInfo() {
        System.out.printf("| %-3d | %-20s | %-4d | %-3s |\n", this.id, this.nama, this.usia, this.golonganDarah);
    }
    
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getGolonganDarah() {
        return golonganDarah;
    }

    public void setGolonganDarah(String golonganDarah) {
        this.golonganDarah = golonganDarah;
    }
}

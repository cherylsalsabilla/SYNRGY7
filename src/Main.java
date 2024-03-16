import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String PATH="Struk Pembelian.txt";
    public static String menu[] = {"Nasi Goreng", "Mie Goreng", "Nasi + Ayam", "Es teh Manis", "Es Jeruk"};
    public static long hargaSatuan[] = {15000, 13000, 18000, 3000, 5000};
    public static String bantuan[] = {"99. Pesan dan Bayar", "0. Keluar aplikasi"};

    //Untuk Menyimpan Input
    public static String order[] = new String[5];
    public static int jumlah[] = new int[5];
    public static long harga[] = new long[5];

    //Macam-macam Method
    public static void awalPesan() {
        String awalan[] = {"Selamat datang di Binarfud", "======================================", "Menu Makanan dan Minuman "};
        System.out.println(awalan[1]);
        System.out.println(awalan[0]);
        System.out.println(awalan[1]);
        System.out.println(awalan[2] + ":");
    }
    public static void tampilanMenu() {
        for (int i = 0; i < menu.length; i++) {
            if (i == 4) {
                System.out.println((i + 1) + ". " + menu[i] + "\t\t" +"|" + hargaSatuan[i]);
            } else {
                System.out.println((i + 1) + ". " + menu[i] + "\t" +"|" + hargaSatuan[i]);
            }
        }
        for (int i = 0; i < bantuan.length; i++) {
            System.out.println(bantuan[i]);
        }
    }
    public static void konfirmasiPesanan() {
        System.out.println("======================================");
        System.out.println("Konfirmasi dan Pembayaran");
        System.out.println("======================================");

    }
    public static void main(String[] args) {
        int index = 0;
        Scanner question = new Scanner(System.in);

        awalPesan();
        tampilanMenu();

        while(true) {
            System.out.print("Silahkan pilih menu: ");
            int pilihanMenu = question.nextInt();
            int jumlahPesanan = 0;
            if (pilihanMenu<=5 && pilihanMenu>=1) {
                System.out.println("======================================");
                System.out.println("Berapa pesanan anda");
                System.out.println("======================================");
                System.out.print("Qty-> ");
                jumlahPesanan = question.nextInt();
            }

            System.out.print("Menu yang Anda pilih: ");
            if (pilihanMenu == 1) {
                long l = jumlahPesanan * hargaSatuan[0];
                System.out.println(jumlahPesanan + " " + menu[0] + " = Rp" + l);
                order[index] = menu[0];
                jumlah[index] = jumlahPesanan;
                harga[index] = hargaSatuan[0];
                index++;
            } else if (pilihanMenu == 2) {
                long l = jumlahPesanan * hargaSatuan[1];
                System.out.println(jumlahPesanan + " " + menu[1] + " = Rp" + l);
                order[index] = menu[1];
                jumlah[index] = jumlahPesanan;
                harga[index] = hargaSatuan[1];
                index++;
            } else if (pilihanMenu == 3) {
                long l = jumlahPesanan * hargaSatuan[2];
                System.out.println(jumlahPesanan + " " + menu[2] + " = Rp" + l);
                order[index] = menu[2];
                jumlah[index] = jumlahPesanan;
                harga[index] = hargaSatuan[2];
                index++;
            } else if (pilihanMenu == 4) {
                long l = jumlahPesanan * hargaSatuan[3];
                System.out.println(jumlahPesanan + " " + menu[3] + " = Rp" + l);
                order[index] = menu[3];
                jumlah[index] = jumlahPesanan;
                harga[index] = hargaSatuan[3];
                index++;
            } else if (pilihanMenu == 5) {
                long l = jumlahPesanan * hargaSatuan[4];
                System.out.println(jumlahPesanan + " " + menu[4] + " = Rp" + l);
                order[index] = menu[4];
                jumlah[index] = jumlahPesanan;
                harga[index] = hargaSatuan[4];
                index++;
            } else if (pilihanMenu == 99) {
                int konfirmasi = 0;
                int totalQty = 0;

                System.out.println();
                konfirmasiPesanan();
                for (int i = 0; i < order.length; i++) {
                    if (order[i] != null) {
                        if (i == 3) {
                            System.out.println(order[i] +"\t\t" + jumlah[i] + "\t\t\t" + jumlah[i]*harga[i]);
                        } else {
                            System.out.println(order[i] +"\t\t\t" + jumlah[i] + "\t\t\t" + jumlah[i]*harga[i]);
                        }
                    }
                }
                long totalHarga = jumlah[0]*harga[0] + jumlah[1]*harga[1] + jumlah[2]*harga[2] + jumlah[3]*harga[3] + jumlah[4]*harga[4];
                for( int i = 0; i < 5; i++) {
                    totalQty = totalQty + jumlah[i];
                }
                System.out.println("-------------------------------------+");
                System.out.println("Total : " + "\t\t\t" + totalQty + "\t\t\t" + totalHarga +"\n");
                System.out.println("");
                System.out.println("1. Konfirmasi dan Bayar");
                System.out.println("2. Kembali ke menu utama");
                System.out.println("3. Keluar aplikasi");
                System.out.print("=>");
                konfirmasi = question.nextInt();

                if (konfirmasi == 1) {
                    writeFile();
                } else if (konfirmasi == 2) {
                    System.out.println("Mohon Tunggu. Anda akan dialihkan ke halaman utama.");
                    tampilanMenu();
                } else if (konfirmasi == 3) {
                    break;
                } else {
                    System.out.println("Menu tidak tersedia.");
                }
            } else if (pilihanMenu == 0) {
                System.out.println("Anda akan keluar aplikasi. Terima kasih!");
                break;
            } else {
                System.out.println("Menu tidak tersedia.");
            }
        }
    }
    public static void writeFile() {
        File file = new File(PATH);
        try {
            if (file.createNewFile()) {
                System.out.println("File Created");
            }else{
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }
        try {
            int totalQty = 0;
            String invoice = "";
            invoice += "======================================\n";
            invoice += "BinarFud\n";
            invoice += "======================================\n";
            invoice += "Terima kasih sudah memesan di BinarFud\n";
            invoice += "Dibawah ini adalah pesanan anda\n";
            invoice += "\n";

            for (int i = 0; i < order.length; i++) {
                if (order[i] != null) {
                    if (i == 3) {
                        invoice += order[i] +"\t\t" + jumlah[i] + "\t\t\t" + jumlah[i]*harga[i] +"\n";
                    } else {
                        invoice += order[i] +"\t\t\t" + jumlah[i] + "\t\t\t" + jumlah[i]*harga[i] +"\n";
                    }
                }
            }

            long totalHarga = jumlah[0]*harga[0] + jumlah[1]*harga[1] + jumlah[2]*harga[2] + jumlah[3]*harga[3] + jumlah[4]*harga[4];
            for( int i = 0; i < 5; i++) {
                totalQty = totalQty + jumlah[i];
            }

            invoice += "----------------------------------------+\n";
            invoice += "Total : " + "\t\t\t" + totalQty + "\t\t\t" + totalHarga + "\n";
            invoice += "Pembayaran : BinarCash\n";
            invoice += "\n";
            invoice += "=========================================\n";
            invoice += "Simpan struk ini sebagai bukti pembayaran\n";
            invoice += "=========================================\n";

            FileWriter fileWriter = new FileWriter(PATH);
            fileWriter.write(invoice);
            fileWriter.close();
            System.out.println("Berhasil ditulis");
        } catch (IOException e) {
            System.out.println("Terjadi error");
            throw new RuntimeException(e);
        }
    }
}
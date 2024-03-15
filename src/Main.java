import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static final String PATH="filename.txt";

    public static void introPesanan() {
        String intro[] = {"Selamat datang di Binarfood", "===========================", "Menu Makanan dan Minuman "};
        System.out.println(intro[1]);
        System.out.println(intro[0]);
        System.out.println(intro[1]);
        System.out.println(intro[2] + ":");
    }
    public static void main(String[] args) {
        String menu[] = {"Nasi Goreng", "Mie Goreng", "Nasi + Ayam", "Es teh Manis", "Es Jeruk"};
        long harga[] = {15000, 13000, 18000, 3000, 5000};
        String bantuan[] = {"99. Pesan dan Bayar", "0. Keluar aplikasi"};
//        String ulang;
        Scanner question = new Scanner(System.in);

        introPesanan();

        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + "|" + harga[i]);
        }
        for (int i = 0; i < bantuan.length; i++) {
            System.out.println(bantuan[i]);
        }
//       do {
        System.out.print("Silahkan pilih menu: ");
        int pilihanMenu = question.nextInt();

        System.out.println("===================");
        System.out.println("Berapa pesanan anda");
        System.out.println("===================");
        System.out.print("Qty-> ");
        int jumlahPesanan = question.nextInt();

        System.out.print("Menu yang Anda pilih: ");
        if (pilihanMenu == 1) {
            long l = jumlahPesanan * harga[0];
            System.out.println(jumlahPesanan + " " + menu[0] + " = Rp" + l);
        } else if (pilihanMenu == 2) {
            long l = jumlahPesanan * harga[1];
            System.out.println(jumlahPesanan + " " + menu[1] + " = Rp" + l);
        } else if (pilihanMenu == 3) {
            long l = jumlahPesanan * harga[2];
            System.out.println(jumlahPesanan + " " + menu[2] + " = Rp" + l);
        } else if (pilihanMenu == 4) {
            long l = jumlahPesanan * harga[3];
            System.out.println(jumlahPesanan + " " + menu[3] + " = Rp" + l);
        } else if (pilihanMenu == 5) {
            long l = jumlahPesanan * harga[4];
            System.out.println(jumlahPesanan + " " + menu[4] + " = Rp" + l);
        } else if (pilihanMenu == 99) {
            System.out.println("Pesanan Selesai.");
        } else if (pilihanMenu == 0) {
            System.out.println("Pesanan dibatalkan. Terima kasih!");
        } else {
            System.out.println("Menu tidak tersedia.");
        }

//        System.out.println();
//            System.out.print("Ingin memilih menu yang lain(y/n)?");
//            ulang = question.nextLine();
//            System.out.println();
            //       }
            //       while (ulang != "t");
            //      System.out.println("...");

//        ArrayList<Pesanan> objLst = new ArrayList<Pesanan>();
//        pesanan.add(".");
//        System.out.println(pesanan);




//        File file = new File(PATH);
//        try {
//            if (file.createNewFile()) {
//                System.out.println("File Created");
//            }else{
//                System.out.println("File already exists");
//            }
//        } catch (IOException e) {
//            System.out.println("Terjadi error");
//            throw new RuntimeException(e);
//        }
//
//        writeFile();
        }
//    public static void writeFile() {
//        try {
//            String invoice = ".";
//            FileWriter fileWriter = new FileWriter(PATH);
//            fileWriter.write(invoice);
//            fileWriter.close();
//            System.out.println("Berhasil ditulis");
//        } catch (IOException e) {
//            System.out.println("Terjadi error");
//            throw new RuntimeException(e);
//        }
//    }
}
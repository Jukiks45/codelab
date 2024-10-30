# Aplikasi Beli Baju

Aplikasi ini adalah simulasi sederhana dari sistem pembelian baju yang dibuat menggunakan bahasa pemrograman Java. Proyek ini memungkinkan pengguna untuk memilih jenis baju, memasukkan jumlah pembelian, dan mengelola stok yang tersedia.

## Fitur Proyek
- **Penambahan dan pengurangan stok baju** berdasarkan jumlah pembelian.
- **Menampilkan informasi baju** seperti nama, harga asli, harga diskon, dan jumlah stok.
- **Simulasi keranjang belanja** yang menampilkan lokasi pembelian serta detail baju yang dibeli.

## Struktur Kelas
Proyek ini terdiri dari beberapa kelas utama:
1. **AplikasiBeliBaju**: Kelas utama yang mengelola jalannya aplikasi.
2. **Baju**: Merepresentasikan baju dengan atribut seperti nama, harga, dan stok.
3. **Keranjang**: Merepresentasikan keranjang belanja yang menyimpan baju dan lokasi pembelian.

## Persyaratan
- **Java Development Kit (JDK)** versi 8 atau lebih baru harus diinstal di sistem Anda.

## Cara Menjalankan Proyek
1. **Kloning atau unduh** proyek ini ke komputer Anda.
2. Buka terminal atau command prompt di direktori proyek.
3. Jalankan perintah berikut untuk mengkompilasi semua kelas:
   ```bash
   javac AplikasiBeliBaju.java Baju.java Keranjang.java
4. Setelah kompilasi berhasil, jalankan aplikasi dengan perintah berikut
   ```bash
   java AplikasiBeliBaju
## Alur program
1. Aplikasi akan menampilkan informasi tentang baju yang tersedia di keranjang, termasuk harga asli dan harga setelah diskon.
2. Pengguna akan diminta untuk memasukkan jumlah baju yang ingin dibeli.
3. Stok akan diperbarui berdasarkan jumlah yang dimasukkan, dan informasi stok yang baru akan ditampilkan.

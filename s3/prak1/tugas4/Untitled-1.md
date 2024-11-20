Deskripsi Program:
Program ini akan menghitung total harga tiket untuk kunjungan ke objek wisata berdasarkan jenis tiket, kategori usia, dan hari kunjungan.

a. Spesifikasi Formal:
{|P|} C {|Q|}
{∣Nama, Hari, Tanggal, Jenis Tiket, Kategori Usia, Jumlah Tiket terisi} C {∣Total Harga yang harus dibayar atau pesan kesalahan}


b. Spesifikasi Informal:
Parameter:
- Nama (String): Nama pembeli tiket
- Hari (String): Hari dalam seminggu untuk kunjungan
- Tanggal (String): Tanggal kunjungan dalam format DD/MM/YYYY
- Jenis Tiket: Tiket reguler atau terusan
- Kategori Usia: Dewasa atau anak-anak
- Jumlah Tiket: Jumlah tiket yang akan dibeli

Returns: 
- Total harga yang harus dibayar berdasarkan perhitungan harga tiket, atau pesan kesalahan jika ada data yang tidak diisi.
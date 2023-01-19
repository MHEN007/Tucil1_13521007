# Tugas Kecil 1 - Strategi Algoritma
Matthew Mahendra (13521007)

## Deskripsi Singkat 
Permainan 24 adalah permainan dimana disediakan kartu Jack, Queen, As, King, 2 s.d. 10. Diambil 4 kartu secara acak. Dicari cara agar dapat mencapai angka 24 dari keempat kartu acak tersebut menggunakan operasi matematika seperti penjumlahan, pengurangan, perkalian, pembagian, dan sifat komutatif.

Untuk mencari seluruh solusi tersebut, dapat digunakan algoritma <i>Brute Force</i> untuk mencari hasil-hasil yang diinginkan. Program ini dibuat menggunakan bahasa Java.

## Setup Program
Program dijalankan pada `Main.java`. Langkah-langkahnya sebagai berikut
1. Change Directory ke `src`
2. Ketikkan `javac -d ../bin *.java`
3. Ketikkan `java -cp ../bin Main`
4. Program sudah dapat dijalankan

## Pengunaan Program
Ada dua opsi untuk mengambil kartu yaitu secara manual atau secara acak. Untuk secara manual masukkan input 1, secara otomatis masukkan input 2. Secara manual input yang valid adalah,
1. K untuk King
2. Q untuk Queen
3. J untuk Joker
4. A untuk As
5. Angka 2 - 10 untuk kartu 2 s.d. 10

Setelah dimasukkan program akan mencari semua kemungkinan. Hasil ditampilkan di layar dan dapat disimpan ke file text. Perlu dicatat bahwa hasil operasi yang serupa seperti (1 * 2) * 3 + 4 dan 1 * (2 * 3) + 4 keduanya akan ditulis.

package com.bank.app.main;
//Main(Ana) sınıfta gerekli olarak metot,degisken,nesneler icin  farklı paketlerde olan sınıflar icin import kullanılmıs
import com.bank.app.people.Musteri;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.service.BankaService;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- BANKA SİSTEMİ BAŞLATILIYOR ---\n");
        
        BankaService bankaServisi = new BankaService();

        System.out.println("--- 1. MÜŞTERİ OLUŞTURMA ---");
        //musteri1 nesnesi olusturulmus ve Musteri Constructoru istedigimiz degerleri girerek Musteri sınıfından cagırılmıs
        Musteri musteri1 = new Musteri("Sümeyra", "Muslu", "sumeyramuslu@mail.com", 550147548);
        //Once Musteri'nin toString()'i yazılmıs ardından Musteri'de super.toString() cagrıldıgı icin
        //Kisi sınıfının toString()'i yazılmıstır
        System.out.println(musteri1.toString() + "\n");

        System.out.println("--- 2. HESAP AÇMA İŞLEMLERİ ---");
        //Vadesiz hesapTuru icin hesapEkle metodu cagırılmıs, hesap acılmıs ve random bir iban degeri olusturulmustur
        musteri1.hesapEkle("Vadesiz");
      //Yatirim hesapTuru icin hesapEkle metodu cagırılmıs, hesap acılmıs ve random bir iban degeri olusturulmustur
        musteri1.hesapEkle("Yatirim");
        System.out.println();

        VadesizHesap vadesizHesap = (VadesizHesap) musteri1.getHesaplar().get(0);
        YatirimHesabi yatirimHesabi = (YatirimHesabi) musteri1.getHesaplar().get(1);

        System.out.println("--- 3. HESABA PARA YATIRMA ---");
        //Yatirim hesapTurune parakEkle metoduyla girilen miktar (1000.0TL) kadar para eklenmistir
        yatirimHesabi.paraEkle(1000.0);
        //VadesizHesaba setBakiye kullanılarak girilen miktar kadar para eklendi
        vadesizHesap.setBakiye(2000.0);
        System.out.println(2000.0+"TL bakiyeye eklendi. Mevcut Vadesiz Hesap Bakiyeniz: " + vadesizHesap.getBakiye() + "\n");

        System.out.println("--- 4. PARA TRANSFERİ ---");
        vadesizHesap.paraTransferi(yatirimHesabi, vadesizHesap, 400.0);
        //Paratransferi metodunun parametreleri: alıcı hesap, gonderen hesap sırasıyla oldugu icin 
        //400TL vadesiz hesaptan yatirim hesabına iletilmistir
        System.out.println("Vadesiz Hesap Mevcut Bakiyeniz: " + vadesizHesap.getBakiye() + " TL");
        System.out.println("Yatırım Hesabı Mevcut Bakiyeniz: " + yatirimHesabi.getBakiye() + " TL\n");

        System.out.println("--- 5. KREDİ KARTI TANIMLAMA ---");
        //krediKArtiEkle metoduna limit degiskeni verilmis, musterikartı ArrayList'e eklenmis
        //KrediKartıNo Random ile olusturulmustur. Buarada kartın limiti 3000.0 TL belirlenmis
        musteri1.krediKartiEkle(3000.0);
        KrediKarti musteriKarti = musteri1.getKrediKartlari().get(0);
        //Metotları test etmek icin Kredi Kartına 800.0TL borc verildi
        musteriKarti.setGuncelBorc(800.0); 
        System.out.println("Karta test etmek amaçlı 800 TL borç yansıtıldı.\n");

        System.out.println("--- 6. KREDİ KARTI BORCU ÖDEME ---");
        //Kredi Kartının borcu VadesizHesap sınıfının metodu cagırılarak 500.0 TL odeniyor
        vadesizHesap.krediKartiBorcOdeme(musteriKarti, 500.0);
        System.out.println("Kalan Kredi Kartı Borcunuz: " + musteriKarti.getGuncelBorc() + " TL\n");

        System.out.println("--- 7. HESAP SİLME İŞLEMLERİ ---");
        System.out.println("--- İçi para dolu yatirim hesabını silme denemesi:");
        //Basarısız oluyor cunku ıf else bloklarıyla bakiyesi dolu hesabı silemiyor
        musteri1.hesapSil(yatirimHesabi); 
        
        System.out.println("\n--- Bakiyesi sıfırlanmış hesabı silme denemesi:");
        //Bakiye sıfır oldugunda komut gecerlı olabılıyor
        vadesizHesap.setBakiye(0); 
        musteri1.hesapSil(vadesizHesap); 
        System.out.println();
        //En sonunda musterinin genel profilini gorebilmek icin BankaService classından musteriOzetiniGoster metodu cagırılıyor
        bankaServisi.musteriOzetiniGoster(musteri1);
    }
}
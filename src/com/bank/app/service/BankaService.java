
package com.bank.app.service;
//Farklı packagelardan olan classlara erısebılmek ıcın: ımport packageismi.classismi kullanılır
import com.bank.app.people.Musteri;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.cards.KrediKarti; 
//BankaService classında banka da sunulan hizmet, banka calısanının yapabilecegi hizmetler gosterılmektedır
	public class BankaService {
		//toplamBakiyeHesapla metoduyla musterinin bakiye hesabı icin diger classlarda olusturlan getter metotları kullanıldı
	    public double toplamBakiyeHesapla(Musteri musteri) {
	        double toplam = 0;
	        for (BankaHesabi hesap : musteri.getHesaplar()) {
	            toplam += hesap.getBakiye();
	        }
	        return toplam;
	        }
	    //toplamBorcHesapla metodunda musteri parametre olarak alınmıs ve diger classlardan 
	    //import edinilmesiye cagırılabılınen getter metotları kullanılmıs
	        public double toplamBorcHesapla(Musteri musteri) {
	            double toplamBorc = 0;
	            for (KrediKarti kart : musteri.getKrediKartlari()) {
	                toplamBorc += kart.getGuncelBorc();
	            }
	            return toplamBorc;
	        }
	    //Banka tarafından musterinin kisisel bilgilerini daha net bir sekilde gorebılmek ıcın metot:
	    //Musteri parametre olarak alnımıs ve yıne getter metodu kullanılmıs
	    public void musteriOzetiniGoster(Musteri musteri) {
	        System.out.println("-------------------------");
	        System.out.println("   BANKA MÜŞTERİ ÖZETİ   ");
	        System.out.println("-------------------------");
	        System.out.println("Müşteri: " +musteri.getAd()+ " " +musteri.getSoyad());
	        System.out.println("Müşteri No: "+musteri.getMusteriNumarasi());
	        System.out.println("\n--- HESAP BİLGİLERİ ---");
	        if (musteri.getHesaplar().isEmpty()) {
	            System.out.println("Henüz bir hesap açılmamış.");
	        } else {
	            for (BankaHesabi h : musteri.getHesaplar()) {
	                System.out.println(h.toString());
	            }
	        }
	        //Musterinin kredi kartı bilgilerini goruntulemek icin getter metotları kullanılmıs
	        System.out.println("\n--- KREDİ KARTI BİLGİLERİ ---");
	        if (musteri.getKrediKartlari().isEmpty()) {
	            System.out.println("Kayıtlı kredi kartı bulunmamaktadır.");
	        } else {
	            for (KrediKarti k : musteri.getKrediKartlari()) {
	                System.out.println(k.toString());
	            }
	        }
	        //Musterinin ekonomik durumunu gostermek ıcın aynı classta olusturdugumuz metotları kullanıyoruz:
	        System.out.println("\n--- EKONOMİK DURUM ---");
	        System.out.println("Toplam Bakiyeniz: " + toplamBakiyeHesapla(musteri) + " TL");
	        System.out.println("Toplam Borcunuz: "+toplamBorcHesapla(musteri)+" TL");
	        System.out.println("------------------------");
	    }
	}


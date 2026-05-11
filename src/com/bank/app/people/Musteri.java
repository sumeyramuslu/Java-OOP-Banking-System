package com.bank.app.people;
import java.util.Random;
import java.util.ArrayList;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
//farklı packagelardan classlara ulasabilmek icin import kullanıldı
// Musteri classi Kisi classının yavru-subclassı oldugu ıcın extends dedik
public class Musteri extends Kisi {
	private String musteriNumarasi;
	//ne kadar arguman girelecegi belli olmadıgı icn esnek bir liste,dizi turu olan ArrayList kullanıldı
	private ArrayList<BankaHesabi> hesaplar;
	private ArrayList<KrediKarti> krediKartlari;
//Musteri classının constructoru ile degerler superclasstan cagırıldı
public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
	super(ad, soyad, email, telefonNumarasi);
		this.hesaplar= new ArrayList<>();
		this.krediKartlari = new ArrayList<>();
		//Burada musteriNumarasina Random metodu kullanılarak rastgele degerler veriliyor
		Random rastgele = new Random();   
		this.musteriNumarasi=String.valueOf(rastgele.nextInt(900000)+10000);
	
}
//Musterinin sectigi hesapTurune gore hesap acılıyor 
public void hesapEkle(String hesapTuru) {
	if(hesapTuru.equalsIgnoreCase("Vadesiz")) {
		VadesizHesap yeniVadesiz = new VadesizHesap(0.0); 
		//yeni hesaptaki degeri 0 varsayıyoruz
		hesaplar.add(yeniVadesiz);
		System.out.println(getAd()+" "+getSoyad()+" için Vadesiz Hesap açıldı! IBAN: "+yeniVadesiz.getIban());
		//getIban() metodu kullanılarak hesap acıldıgında random degerler verılmıs olan Iban degeri de yazdırılıyor
	}
	
		else if(hesapTuru.equalsIgnoreCase("Yatirim")) {
			YatirimHesabi yeniYatirim = new YatirimHesabi(0.0);
			hesaplar.add(yeniYatirim);
			System.out.println(getAd()+" "+getSoyad()+" için Yatirim Hesabi açıldı! "+ " IBAN: "+yeniYatirim.getIban());
		}
		else {
			System.out.println("Hatalı hesap türü girdiniz! Vadesiz veya Yatirim Hesabı giriniz! ");
		}
	
		}
//Yeni bir kredikarti olusuturulmak istendiginde kullanılacak metot:

public void krediKartiEkle(double limit) {
	KrediKarti yeniKart = new KrediKarti(limit,0.0);
	//yeni kredikartinin bakiyesini 0 varsayıyoruz
	krediKartlari.add(yeniKart);
	//ArrayList'e yeniKart eklendi
	System.out.println("Kredi kartınız oluşturuldu! Kart No: "+yeniKart.getKartNumarasi());
	
}
//Hesap silmek icin kullanılacak metot:
public void hesapSil(BankaHesabi hesap) {
	if(hesap.getBakiye()>0) {
		System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız!");
	}
	//Ancak eger hesabınızın bakiyesi sıfırsa hesabı silebilirsiniz
	else if(hesap.getBakiye() ==0) {
		hesaplar.remove(hesap);
		//ArrayList'ten hesap silindi
		System.out.println("Hesabınız silindi!");
	}
	
}
//Kredi kartinizi silmek icin kullanılacak metot:
public void krediKartiSil(KrediKarti kart) {
	if(kart.getGuncelBorc()==0) {
		//eger borcunuz sıfır ise kredi kartınızı silebilirsiniz
		krediKartlari.remove(kart);
		System.out.println("Kredi kartınız silindi!");
	}
	else {
		System.out.println("Lütfen öncelikle borç ödemesi yapınız!");
	}
	
}
//Dısarıdan erisebilmek icin getter ve setter metotları
public String getMusteriNumarasi() {
	return musteriNumarasi;
}
public void setMusteriNumarasi(String musteriNumarasi) {
	this.musteriNumarasi=musteriNumarasi;
}
public ArrayList<BankaHesabi> getHesaplar(){
	return hesaplar;
}
public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
	this.hesaplar=hesaplar;
}
public ArrayList<KrediKarti> getKrediKartlari(){
	return krediKartlari;
}
public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
	this.krediKartlari=krediKartlari;
}
//Musteri sınıfında kullandıgımız bılgılerı tek satırda gorebılmemızı saglar, toString metodu ezilmistir
@Override
public String toString() {
	return "Müşteri No: " + this.musteriNumarasi + " | " + super.toString();
}
}

package com.bank.app.accounts;
//KrediKartı classındaki metotları,degiskenleri kullanabilmek icin import kullandık
import com.bank.app.cards.KrediKarti;
//VadesizHesap, BankaHesabi sınfının yavrusu oldugu icin extends kullanıldı
public class VadesizHesap extends BankaHesabi {
	private String hesapTuru;
	public VadesizHesap(double bakiye) {
		super(bakiye);  // super kullanılarak superclasstakı degısken cagırılıyor
		this.setHesapTuru("Vadesiz");
		
	}
	//paratransferi metoduyla girilen miktar gonderen hesabın bakiyesinden azalarak alıcı hesaptan arttırılmıstır
	//Bu ıslemler yapılırken superclasstakı verıler,getter,setter metotları kullanılmıstır
	public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
	double gonderenEskibakiye = gonderenHesap.getBakiye();
	gonderenHesap.setBakiye(gonderenEskibakiye-miktar);
	double aliciEskiBakiye = aliciHesap.getBakiye();
	aliciHesap.setBakiye(aliciEskiBakiye+miktar);
	System.out.println(miktar+"TL Para transferiniz gerçekleşti!");
	}
	//krediKartiBorcOdeme metoduyla girilen miktar GuncelBorctan cikar ve aynı miktarda mevcutBakiyeden de azalır.
	public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
		if(this.getBakiye()>=miktar) {
		double kartinMevcutBorc = kart.getGuncelBorc();
		kart.setGuncelBorc(kartinMevcutBorc-miktar);
		double mevcutBakiye=this.getBakiye();
		this.setBakiye(mevcutBakiye-miktar);
		System.out.println(miktar+" TL "+"Kredi kartı borcunuz ödendi!");
	}
		else {
			System.out.println(miktar+"TL Kredi kartı borcunuzu ödemek için bakiyeniz yeterli değil!");
		}
	}
//Getter Setter metotları
public String getHesapTuru() {
	return hesapTuru;
}
public void setHesapTuru(String hesapTuru) {
	this.hesapTuru = hesapTuru;
}
//VadesizHesap sınıfında elde ettıgımız verıleri tek satırda yazar, toString() metodu ezilmistir
@Override
public String toString() {
	return "Tür: " +hesapTuru+" "+super.toString();
}
}

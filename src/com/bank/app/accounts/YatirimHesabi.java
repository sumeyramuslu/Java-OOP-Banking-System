package com.bank.app.accounts;
//BankaHesabi sınıfı, YatirimHesabi sınıfının atası/super sınıfı oldugu icin extends yazılmıstır
public class YatirimHesabi extends BankaHesabi {
	private String hesapTürü;
	//YatirimHesabi sınfının constructoru ile degiskenlere ilk deger verilmis/baslatma metodu
	public YatirimHesabi(double bakiye) {
		super(bakiye);
		//super kullnarak ata sınıftan olan degisken cagırılmıstır
		this.hesapTürü="Yatirim";
	}
	//YatirimHesabi'na para eklemek icin gerekli metot:
	//Miktar degiskeni alınmıs, get ile bakiye cagırılmıs, set ile bakiye degistirilmis
	public void paraEkle(double miktar) {
		double mevcutBakiye = getBakiye();
		setBakiye(mevcutBakiye+miktar);
		System.out.println(miktar+" TL bakiyeye eklendi. Mevcut Yatirim Hesabi Bakiyeniz: "+getBakiye());
	}
	//YatirimHesabi'ndan para cekmek icin gerekli metot:
	//Miktar degiskeni parametre olarak alınmıs,get il bakiye ogrenılmıs,para azaldıgında set kullanılarak bakiye guncellenmıstır
	public void paraCek(double miktar) {
		if(getBakiye()>=miktar) {
			double mevcutBakiye=getBakiye();
			setBakiye(mevcutBakiye-miktar);
			System.out.println(miktar+" TL "+"Hesabınızdan çekildi! Mevcut bakiyeniz: " +getBakiye());
		}
		else {
			System.out.println("Bakiyeniz yetersiz! Mevcut bakiyeniz: "+getBakiye());
		}
	}
//Getter ve setter metotları
public String getHesapTürü() {
	return hesapTürü;
}
public void setHesapTürü(String hesapTürü) {
	this.hesapTürü = hesapTürü;
}
//tostring() metodu ezilmistir, sınıftan elde ettigimiz verileri tek satırda yazar
	@Override
public String toString() {
	return "Hesap Türü: "+ this.hesapTürü+" Mevcut Bakiyeniz: "+ getBakiye()+" TL";
}
}

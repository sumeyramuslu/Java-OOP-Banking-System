package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
	private String kartNumarasi;
	private double limit;
	private double guncelBorc;
	private double kullanilabilirLimit;
	//KrediKarti sınıfının constructoru ile verilere ilk degerleri tanımlanmıs
public KrediKarti(double limit,double guncelBorc){
		this.limit=limit;
		this.guncelBorc=guncelBorc;
		this.kullanilabilirLimit=limit-guncelBorc; //Kartta kullanılabilen limit belirlenmis
		Random rastgele=new Random();
		long rastgeleKartNo=rastgele.nextLong(90000000L)+1000000L;
		this.kartNumarasi=String.valueOf(rastgeleKartNo);  
		//KartNo'su hazır Random() metodu kullanılarak random degerler alabılmesı saglanmıs
	}
//Getter ve setter metodlarıyla disarıan degiskenlere erismeyi saglar
public double getGuncelBorc() {
	return guncelBorc;
}
public void setGuncelBorc(double guncelBorc) {
	this.guncelBorc = guncelBorc;
}
public String getKartNumarasi() {
	return kartNumarasi;
}
public void setKartNumarasi(String kartNumarasi) {
	this.kartNumarasi = kartNumarasi;
}
public double getLimit() {
	return limit;
}
public void setLimit(double limit) {
	this.limit = limit;
}
public double getKullanilabilirLimit() {
	return kullanilabilirLimit;
}
public void setKullanilabilirLimit(double kullanilabilirLimit) {
	this.kullanilabilirLimit = kullanilabilirLimit;
}
//krediKarti sınıfından elde ettigimi degiskenlerin degerlerini tek bir satırda gorebılmeyı saglar
//Override ata sınıftan alınan aynı ısımlı metodu degıstırerek kullanmak demektir, burada da kullanılmıstır
@Override
public String toString(){
	return "Kart no: "+kartNumarasi+" Borç: "+guncelBorc+" Limit: "+limit;
}
}

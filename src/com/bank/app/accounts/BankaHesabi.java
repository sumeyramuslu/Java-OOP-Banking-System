package com.bank.app.accounts;

import java.util.Random;

public class BankaHesabi {
	private String iban;
	private double bakiye;
	//BankHesabi sınıfının constructoru
	public BankaHesabi(double bakiye) {
		this.bakiye=bakiye;
		Random rastgele = new Random();
		long rastgeleSayi=rastgele.nextLong(900000L)+10000000L;
		this.iban="TR"+ rastgeleSayi;
		//Burada iban'a hazır Random metodu kullanılarak rastgele degerler alması saglanmıs ayrıca basına TR konulmustur
	}
	//BankaHesabinda elde ettigimiz bakiye ve iban degiskenlerinin degerleri tek satirda yazar
	//toString() metodu override/ezilmistir
@Override
public String toString() {
	return "IBAN: " + iban + "  Bakiye: " + bakiye + " TL";
}
//Bakiye ve iban degerlerini ulasmeayi ve degistirmeyi saglayan getter/setter metotları
public double getBakiye() {
	return bakiye;
}
public void setBakiye(double bakiye) {
	this.bakiye = bakiye;
}
public String getIban() {
	return iban;
}
public void setIban(String iban) {
	this.iban = iban;
}

}

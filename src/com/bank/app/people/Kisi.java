package com.bank.app.people;

public class Kisi {
	private String ad;
	private String soyad;
	private String email;
	private int telefonNumarasi;
	
	Kisi(){ // Banka personeli ve müşterilerin sahip olabileceği ortak özellikleri içeren super sınıf
	}
	//Construcotr ile degiskenlere ilk degerleri veriliyor
	public Kisi(String ad, String soyad, String email, int telefonNumarasi){
		this.ad=ad;
		this.soyad=soyad;
		this.email=email;
		this.telefonNumarasi=telefonNumarasi;
	}
	//Degiskenler icin getter,setter metotları
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefonNumarasi() {
		return telefonNumarasi;
	}
	public void setTelefonNumarasi(int telefonNumarasi) {
		this.telefonNumarasi = telefonNumarasi;
	}
	//Kisi bilgilerini tek satirda yazmak icin kullanılır, toString metodu ezilmistir
	@Override
	public String toString() {
		return "Ad: " + this.getAd() + ", Soyad: " + this.getSoyad() + 
		           ", Email: " + this.getEmail() + ", Telefon: " + this.getTelefonNumarasi();
				}
}

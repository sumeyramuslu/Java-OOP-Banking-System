package com.bank.app.people;
import java.util.ArrayList;
import java.util.Random;
//BankaPersoneli sınıfı Kisi sınıfının subclassı oldugu ıcın extends dedik
public class BankaPersoneli extends Kisi {
	private String personelID;
	private ArrayList<Musteri> musteriler;//ArrayList kullanılarak musteriler kayıt ediliyor
	//BankaPersoneli sınfının construtoru ile verilere ilk degerleri veriliyor,baslatma metodu
	public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
		super(ad, soyad, email, telefonNumarasi);
		this.musteriler=new ArrayList<>();
		Random rastgele = new Random();
		this.personelID=String.valueOf(rastgele.nextInt(9000)+1000);
		//personelID, Random hazır metodu kullanılarak rastgele degerler verilyor
		this.musteriler=new ArrayList<>();
	}
	//Verilere dısarıdan erismeyi saglayan getter/setter metotları
	public ArrayList<Musteri> getMusteriler(){
		return musteriler;
	}
	public void setMusteriler(ArrayList<Musteri> musteriler) {
		this.musteriler=musteriler;
	}
	public String getPersonelID() {
		return personelID;
	}
	public void setPersonelID(String personelID) {
		this.personelID=personelID;
	}
	// Bankapersoneli sınıfından elde edilen verileri tek satırda yazar, toString ezilmistir(override)
@Override
public String toString() {
	return "Personel ID: " + this.personelID + "  " + super.toString();
	}
}


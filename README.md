# Java OOP Banking System

Java ile nesne yönelimli programlama ilkeleri kullanılarak geliştirilmiş konsol tabanlı bir banka yönetim simülasyonudur. Proje; müşteri ve banka personeli oluşturma, hesap yönetimi, para transferi ve kredi kartı işlemleri gibi temel bankacılık senaryolarını sınıf tabanlı bir yapıyla modeller.

## Özellikler

- Müşteri ve banka personeli oluşturma
- Vadesiz ve yatırım hesabı açma
- Hesaba para yatırma ve hesaptan para çekme
- Hesaplar arasında para transferi
- Kredi kartı oluşturma ve borç ödeme
- Hesap silme kurallarının kontrolü
- Müşteri bakiye ve borç özetlerinin görüntülenmesi

## Uygulanan Nesne Yönelimli Programlama Kavramları

- Kalıtım
- Kapsülleme
- Çok biçimlilik
- Metot ezme (`override`)
- Constructor kullanımı
- Paket yapısı
- `ArrayList` ile nesne koleksiyonları

## Proje Yapısı

```text
src/
|-- com/bank/app/
|   |-- accounts/   # Banka hesabı, vadesiz hesap ve yatırım hesabı
|   |-- cards/      # Kredi kartı modeli
|   |-- main/       # Uygulamanın başlangıç noktası
|   |-- people/     # Kişi, müşteri ve banka personeli
|   `-- service/    # Bankacılık işlemleri ve müşteri özeti
`-- module-info.java
```

## Çalıştırma

### Eclipse veya IntelliJ IDEA

1. Repoyu Java projesi olarak içe aktarın.
2. `src/com/bank/app/main/Main.java` dosyasını açın.
3. `Main` sınıfını çalıştırın.

### PowerShell

```powershell
New-Item -ItemType Directory -Force out
javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java --module-path out --module PROJE/com.bank.app.main.Main
```

## Kullanılan Teknolojiler

- Java
- Java Collections (`ArrayList`)
- Eclipse IDE

## Proje Hakkında

Bu proje, Nesneye Yönelik Programlama dersi kapsamında Java'daki temel OOP kavramlarını gerçek bir problem senaryosu üzerinde uygulamak amacıyla bireysel olarak geliştirilmiştir.

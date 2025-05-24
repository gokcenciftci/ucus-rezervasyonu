Uçak Bilet Rezervasyon Sistemi

Bu proje, Java programlama dili kullanılarak geliştirilmiş, konsol tabanlı bir uçak bilet rezervasyon sistemidir. Kullanıcılar; mevcut uçuşlar arasından istedikleri uçuşu seçip rezervasyon oluşturabilir, aynı zamanda tüm yapılan rezervasyonları kolaylıkla görüntüleyebilirler. Sistem, koltuk kapasitesini aşan rezervasyon taleplerini engelleyerek gerçekçi bir biletleme deneyimi sağlar.

Özellikler

Uçuş Yönetimi:
Kalkış ve varış lokasyonları, tarih-saat bilgileri ve kullanılan uçak markası, modeli ve koltuk kapasitesi gibi detaylarla uçuşlar tam olarak tanımlanır ve yönetilir.

Esnek ve Güvenilir Rezervasyon Sistemi:
Kullanıcılar mevcut uçuşlar arasından seçim yaparak rezervasyon oluşturabilir. Sistem, uçaktaki koltuk kapasitesini kontrol ederek kapasite dolduğunda yeni rezervasyon yapılmasını engeller.

Rezervasyonları Listeleme:
Sistemde yapılmış olan tüm rezervasyonlar, yolcu adı, uçuş detayları ve uçak bilgileriyle birlikte kullanıcıya sunulur.

Kalıcı Veri Depolama:
Rezervasyon verileri JSON formatında bir dosyada (data/reservations.json) güvenli ve düzenli şekilde saklanır. Program başlatıldığında dosyadan yüklenerek önceki rezervasyonlar korunur.

Kullanıcı Dostu Konsol Arayüzü:
Menü tabanlı sade ve anlaşılır konsol ekranı, kullanıcı girişleri için geçerlilik kontrolleri içerir. Hatalı girişlerde anlamlı uyarılar verir.

Modüler ve Sürdürülebilir Kod Yapısı:
Nesne yönelimli programlama prensiplerine uygun olarak, veri modelleri, iş kuralları ve dosya işlemleri katmanlara ayrılmıştır. Bu sayede proje kolayca geliştirilebilir ve yeni özellikler eklenebilir.

Kullanım

Uçuşları Listeleme:
Menüden uçuşları görüntüleyerek kalkış ve varış noktaları, saatleri ve uçak bilgilerini görebilirsiniz.

Rezervasyon Yapma:
Listelenen uçuşlardan birini seçip ad, soyad ve yaş bilgilerinizi girerek rezervasyon oluşturabilirsiniz. Eğer uçuşta yer kalmamışsa sistem sizi uyaracaktır.

Rezervasyonları Görüntüleme:
Mevcut tüm rezervasyonları yolcu bilgileri ve uçuş detayları ile listeleyebilirsiniz.

Programdan Çıkış:
Çıkış işlemi sırasında tüm rezervasyonlar dosyaya kaydedilir, böylece veriler sonraki çalıştırmada korunmuş olur.

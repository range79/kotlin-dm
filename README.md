
# KotlinDm 🧪

Demo amaçlı geliştirilmiş Kotlin + Spring Boot tabanlı kullanıcı yönetimi uygulaması.

## ✨ Amaç

Bu proje, **Kotlin bilgimi güncellemek** ve Spring ekosisteminde Kotlin kullanımını deneyimlemek amacıyla geliştirilmiştir. Servis katmanında birim testler mevcuttur. Proje minimal ve sade tutulmuştur.

## 🔧 Kullanılan Teknolojiler

* **Kotlin (JVM 17)**
* **Spring Boot 3.4.5**
* **Spring Security (Basic Auth)**
* **JPA + Hibernate**
* **MySQL (Docker üzerinden)**
* **Swagger/OpenAPI (SpringDoc)**
* **JUnit 5 + Mockito ile Unit Testler**
* **Gradle (Kotlin DSL)**

## 📦 Özellikler

* Kullanıcı kayıt ve sorgulama işlemleri (kişisel bilgiler hariç)
* Temel `Basic Auth` güvenliği
* Swagger UI üzerinden test edilebilir REST API
* Docker Compose ile MySQL kurulumu
* Uygulama başladığında otomatik admin kullanıcısı oluşturma
* Service katmanında unit testler

## 🧪 Test

CLI üzerinden testleri çalıştırmak için:

```bash
./gradlew test
```

Testler şimdilik yalnızca `service layer` seviyesindedir. Daha ileri düzey testler (controller, integration vb.) bu demo projenin kapsamı dışında tutulmuştur.

## 📄 Swagger UI

Swagger arayüzüne erişim için:

📍 **Adres:**

```
http://localhost:8080/swagger-ui/index.html
```

🛡 **Giriş bilgileri (default):**

* Kullanıcı adı: `range`
* Şifre: `1234`

## 🧑‍💻 Admin Kullanıcısı

Uygulama ilk kez başlatıldığında `application.properties` dosyasındaki `user.name`, `user.password` ve `user.email` değerleri kullanılarak bir admin kullanıcı otomatik olarak veritabanına eklenir. Eğer kullanıcı daha önce oluşturulmuşsa işlem atlanır.

## 📂 Projeyi Çalıştırma

```bash
# MySQL servisini başlat
docker-compose up -d

# Spring Boot uygulamasını başlat
./gradlew bootRun
```

## 📌 Proje Yapısı

```
com.range.kotlinDm
├── controller
├── dto
├── model
├── repo
├── service
├── configuration
└── util
```

## 📎 Repository

🔗 [GitHub – range79/kotlin-dm](https://github.com/range79/kotlin-dm)


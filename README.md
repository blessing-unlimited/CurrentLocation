# 📍 CurrentLocation

CurrentLocation is an Android application developed in **Kotlin** that retrieves the user's current geographical location and displays it on an interactive **Mapbox map**.

The application demonstrates how to request location permissions, retrieve the device's last known location using Google Play Services, and use the retrieved coordinates to position a Mapbox map.

---

## 📱 Features

* 📍 Retrieves the user's current location
* 🗺️ Displays an interactive Mapbox map
* 🎯 Automatically centers the map on the user's location
* 🔐 Requests location permissions at runtime
* 📡 Uses Google Play Services Location API
* 🧭 Automatically zooms the map to the user's approximate location
* 📱 Supports Android devices running Android 7.1 (API 25) and above

---

## 🛠️ Technologies Used

| Technology                        | Purpose                                 |
| --------------------------------- | --------------------------------------- |
| **Kotlin**                        | Primary programming language            |
| **Android Studio**                | Development environment                 |
| **Mapbox Maps SDK**               | Interactive map display                 |
| **Google Play Services Location** | Retrieving device location              |
| **Gradle**                        | Project build and dependency management |
| **Android SDK**                   | Application development framework       |

---

## 🏗️ Project Structure

```text
CurrentLocation/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/currentlocation/
│   │   │   │       └── MainActivity.kt
│   │   │   │
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   ├── layout/
│   │   │   │   ├── mipmap/
│   │   │   │   ├── values/
│   │   │   │   └── xml/
│   │   │   │
│   │   │   └── AndroidManifest.xml
│   │   │
│   │   └── test/
│   │
│   ├── build.gradle.kts
│   └── proguard-rules.pro
│
├── gradle/
│   └── wrapper/
│
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
└── README.md
```

---

## ⚙️ How It Works

The application follows these main steps:

### 1. Request Location Permissions

The application requests:

* `ACCESS_FINE_LOCATION`
* `ACCESS_COARSE_LOCATION`

The permissions are requested at runtime using Android's `ActivityResultContracts.RequestMultiplePermissions()`.

### 2. Access the Device Location

Once permission has been granted, the application uses:

```kotlin
FusedLocationProviderClient
```

from Google Play Services to retrieve the device's last known location.

### 3. Retrieve Coordinates

The latitude and longitude are extracted from the location:

```kotlin
location.latitude
location.longitude
```

### 4. Display the Location on Mapbox

The coordinates are converted into a Mapbox geographical point and used to position the map camera:

```kotlin
val userLocation = Point.fromLngLat(
    location.longitude,
    location.latitude
)
```

The map then moves to the user's location and zooms in to provide a closer view.

---

## 🔐 Permissions

The application requires the following permissions:

```xml
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
```

Location permissions are requested only when required and are handled during runtime.

> **Privacy:** The application uses the device's location to position the map. Location data should be handled responsibly and should not be collected or shared without the user's knowledge and consent.

---

## 🚀 Getting Started

### Prerequisites

Before running the project, make sure you have:

* **Android Studio**
* **JDK 11 or compatible Java environment**
* Android SDK
* An Android device or emulator
* A **Mapbox access token**

---

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/CurrentLocation.git
```

Navigate into the project:

```bash
cd CurrentLocation
```

---

### 2. Open the Project

Open the project in **Android Studio**.

Allow Android Studio to:

* Sync Gradle
* Download required dependencies
* Configure the Android SDK

---

### 3. Configure Mapbox

The application uses Mapbox to render the map.

Your Mapbox access token should be configured in:

```text
app/src/main/res/values/mapbox_access_token.xml
```

For security, avoid committing private or sensitive access tokens directly to a public repository.

A safer approach is to keep credentials outside source control and inject them during the build process.

---

### 4. Connect an Android Device

You can either:

* Connect a physical Android device using USB debugging, or
* Create and use an Android Emulator through Android Studio.

Make sure location services are enabled on the device/emulator.

---

### 5. Run the Application

Click **Run ▶** in Android Studio.

When the application launches, Android will request permission to access the device's location.

Grant the required permission.

The application will then:

1. Load the Mapbox map.
2. Retrieve the device's last known location.
3. Convert the location into geographical coordinates.
4. Move the map camera to the user's location.

---

## 📋 Requirements

| Requirement         | Version              |
| ------------------- | -------------------- |
| Minimum Android SDK | API 25               |
| Target Android SDK  | API 36               |
| Compile SDK         | API 37               |
| Kotlin              | Kotlin/JVM           |
| Java                | Java 11              |
| Gradle              | 9.4.1                |
| Mapbox Maps         | Mapbox Maps SDK      |
| Location Services   | Google Play Services |

---

## 🧪 Testing

The project includes a basic unit test setup using **JUnit**.

Tests can be executed through Android Studio or using Gradle:

```bash
./gradlew test
```

On Windows:

```bash
gradlew.bat test
```

---

## 🐛 Known Limitations

The current implementation uses the device's **last known location**.

This means that:

* A location may not always be immediately available.
* The returned location may not represent the device's exact current position.
* Location accuracy depends on the device and available location providers.
* The application currently focuses on displaying the location rather than continuously tracking movement.

Future versions could implement continuous location updates using `requestLocationUpdates()`.

---

## 🔮 Future Improvements

Potential improvements include:

* [ ] Add a visible location marker
* [ ] Add continuous location tracking
* [ ] Display latitude and longitude
* [ ] Display the user's current address
* [ ] Add a "My Location" button
* [ ] Add location accuracy information
* [ ] Add search functionality
* [ ] Add route/navigation functionality
* [ ] Improve error handling when location services are disabled
* [ ] Improve the user interface
* [ ] Add automated UI tests
* [ ] Securely manage Mapbox API credentials

---

## 📚 Learning Objectives

This project was created to demonstrate practical Android development concepts including:

* Android application development with Kotlin
* Runtime permission handling
* Working with device location services
* Google Play Services APIs
* Mapbox Maps integration
* Working with latitude and longitude
* Android activity lifecycle
* Gradle project configuration
* Basic Android testing

---

## 👨‍💻 Author

**Blessing Makhukhula**

This project was developed as part of my Android development learning and coursework.

---

## 📄 License

This project is intended for educational and demonstration purposes.

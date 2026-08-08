📍 CurrentLocation
CurrentLocation is an Android application developed in Kotlin that retrieves the user's current geographical location and displays it on an interactive Mapbox map.

The application demonstrates how to request location permissions, retrieve the device's last known location using Google Play Services, and use the retrieved coordinates to position a Mapbox map.

📱 Features
📍 Retrieves the user's current location
🗺️ Displays an interactive Mapbox map
🎯 Automatically centers the map on the user's location
🔐 Requests location permissions at runtime
📡 Uses Google Play Services Location API
🧭 Automatically zooms the map to the user's approximate location
📱 Supports Android devices running Android 7.1 (API 25) and above
🛠️ Technologies Used
Technology	Purpose
Kotlin	Primary programming language
Android Studio	Development environment
Mapbox Maps SDK	Interactive map display
Google Play Services Location	Retrieving device location
Gradle	Project build and dependency management
Android SDK	Application development framework
🏗️ Project Structure
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
⚙️ How It Works
The application follows these main steps:

1. Request Location Permissions
The application requests:

ACCESS_FINE_LOCATION
ACCESS_COARSE_LOCATION
The permissions are requested at runtime using Android's ActivityResultContracts.RequestMultiplePermissions().

2. Access the Device Location
Once permission has been granted, the application uses:

FusedLocationProviderClient
from Google Play Services to retrieve the device's last known location.

3. Retrieve Coordinates
The latitude and longitude are extracted from the location:

location.latitude
location.longitude
4. Display the Location on Mapbox
The coordinates are converted into a Mapbox geographical point and used to position the map camera:

val userLocation = Point.fromLngLat(
    location.longitude,
    location.latitude
)
The map then moves to the user's location and zooms in to provide a closer view.

🔐 Permissions
The application requires the following permissions:

<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
Location permissions are requested only when required and are handled during runtime.

Privacy: The application uses the device's location to position the map. Location data should be handled responsibly and should not be collected or shared without the user's knowledge and consent.

🐛 Known Limitations
The current implementation uses the device's last known location.

This means that:

A location may not always be immediately available.
The returned location may not represent the device's exact current position.
Location accuracy depends on the device and available location providers.
The application currently focuses on displaying the location rather than continuously tracking movement.
Future versions could implement continuous location updates using requestLocationUpdates().

🔮 Future Improvements
Potential improvements include:

 Add a visible location marker
 Add continuous location tracking
 Display latitude and longitude
 Display the user's current address
 Add a "My Location" button
 Add location accuracy information
 Add search functionality
 Add route/navigation functionality
 Improve error handling when location services are disabled
 Improve the user interface
 Add automated UI tests
 Securely manage Mapbox API credentials
📚 Learning Objectives
This project was created to demonstrate practical Android development concepts including:

Android application development with Kotlin
Runtime permission handling
Working with device location services
Google Play Services APIs
Mapbox Maps integration
Working with latitude and longitude
Android activity lifecycle
Gradle project configuration
Basic Android testing
👨‍💻 Author
Blessing Makhukhula

This project was developed as part of my Android development learning and coursework.

📄 License
This project is intended for educational and demonstration purposes.

# Cordova-SDK
Cordova plugin for iOS and Android to use Ubudu UBeacon SDK in a Cordova application. 

The plugin is currently in development. As a consequence the plugin API may change without notice until it reaches a stable form.

## Installation procedure

Follow these instructions in order to get started with a fresh Cordova app that runs on iOS and Android and integrates the **Ubudu SDK**.

### 1. Install Cordova

If you don't already have Cordova installed then start by installing the Cordova toolchain which is available at *http://cordova.apache.org/#download*

### 2. Create a Cordova application

1. Create a new application if you don't have one

	`cordova create UbuduDemo com.example.ubudu UbuduDemo`
	
	The *cordova* tool should respond something like:
	
	```
Creating a new cordova project with name "UbuduDemo" and id "com.example.ubudu" at location...
```

2. Add **iOS** platform support if desired and not already present

	`cd UbuduDemo`
	
	`cordova platform add ios`

    ```
Adding ios project...
iOS project created with cordova-ios@3.8.0
```

3. Add **Android** platform support if desired and not already present
	
	`cordova platform add android`

    ```
Adding android project...
Creating Cordova project for the Android platform:
	Path: platforms/android
	Package: com.example.ubudu
	Name: UbuduDemo
	Android target: android-21
Copying template files...
Project successfully created.
```

### 3. Add the Ubudu SDK plugin

`cordova plugin add https://github.com/Ubudu/Cordova-SDK`

```
Fetching plugin "https://github.com/Ubudu/Cordova-SDK" via git clone
Installing "com.ubudu.cordova.sdk" for android
Installing "com.ubudu.cordova.sdk" for ios
```

#### Android dependencies

If you intent to support the Android platform you need to install the following Cordova plugin dependencies:

* `cordova plugin add com.google.playservices`
  
    ```
npm http GET http://registry.cordova.io/com.google.playservices
npm http 200 http://registry.cordova.io/com.google.playservices
Installing "com.google.playservices" for android
```

* `cordova plugin add android.support.v4`
  
    ```
npm http GET http://registry.cordova.io/android.support.v4
npm http 200 http://registry.cordova.io/android.support.v4
Installing "android.support.v4" for android
```

### 4. Configure the project

#### iOS project configuration

Open the generated XCode project `UbuduDemo.xcodeproj` located in `platforms/ios/`.

* Location Usage Description

    Since iOS 8.0 it is required to add an entry in the **UbuduDemo-Info.plist** file that explains why and when your application needs access to the user location. Please read [the detailed explainations in the native iOS SDK documentation](https://github.com/Ubudu/IOS-SDK#user-content-location-authorization)
	
	The safe thing to do to get started is to add the **NSLocationAlwaysUsageDescription** key to your plist file. The value for the key, if not empty, is a message that will be displayed in the alert asking the user for location authorizarion.
	
	If this key is not added then the prompt is not presented to the user and you are not granted access to the user position.

#### Android project configuration

In the `config.xml` file add these lines

```xml
<preference name="android-minSdkVersion" value="18" />
<preference name="android-targetSdkVersion" value="18" />
```
below this line

```xml
<access origin="*" />
```

### 5. Configure and start the SDK

1. In `www/js/index.js` add the following code to the *onDeviceReady* function. 

	Below `app.receivedEvent('deviceready');` add:
	
	```javascript
var pluginElement = document.getElementById('ubudusdk'); // DOM element used to get a visual confirmation that the SDK successfully started or not
UbuduSDK.setAppNamespace('634b207ee2f313c109c58675b44324ac2d41e61e', function(appNamespace){}); // Replace with your own app namespace key!
UbuduSDK.start(
    function() {
        pluginElement.setAttribute('style', 'color:green;');
        pluginElement.textContent = 'Ubudu SDK started';
    },
    function(err) {
        pluginElement.setAttribute('style', 'color:red;');
        pluginElement.textContent = 'Ubudu SDK start error: "' + err + '"';
});
```

	**You need to replace the app namespace by the one you created on the [Ubudu manager platform](https://manager.ubudu.com)**

    *Note: The HTML element manipulated with the DOM API in this example is only there to have a visual confirmation that the SDK is started. You are free to remove it.*

2. In your `www/index.html` file

    *Optional: Only if you want a visual confirmation that the SDK has started.*
    
    Add this line:
    
    ```html
  <p id="ubudusdk" style="color:orange;">Ubudu SDK waiting for start</p>
```
	
    Below this block
	
    ```html
  <div id="deviceready" class="blink">
      <p class="event listening">Connecting to Device</p>
      <p class="event received">Device is Ready</p>
  </div>
```

#### Specific to iOS platform

Add this import statement at the top of the `AppDelegate.m` file
	
```objective-c
#import <UbuduSDK/UbuduSDK.h>
```

And this line to the `application:didReceiveLocalNotification:` method

```objective-c
[[UbuduSDK sharedInstance] executeLocalNotificationActions:notification];
```

### 6. Build and Run

#### iOS

* To only build the app: `cordova build ios`

* To run on an iPhone simulator (won't be able to detect beacons but allows to check that everything runs as expected) `cordova emulate ios`

* To launch the app on a device, plug a device, then `cordova run ios`

#### Android

* To only build the app: `cordova build android`

* To run on an Android simulator (won't be able to detect beacons but allows to check that everything runs as expected): `cordova emulate android`

* To launch the app on a device, plug a device, then `cordova run android`

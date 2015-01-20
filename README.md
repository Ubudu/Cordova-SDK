# Cordova-SDK
Cordova plugin for IOS and Android to use Ubudu UBeacon SDK in a Cordova application. 

The plugin is currently in development. As a consequence the plugin API may change without any notice until it reaches a stable form.

## Installation procedure

Follow these instructions in order to get started with a fresh Cordova app that runs on iOS and integrate the **Ubudu SDK plugin**.

### 0. Install Cordova

If you don't already have Cordova installed then start by installing the Cordova toolchain which is available at http://cordova.apache.org/#download

### 1. Create a Cordova application

1. Create a new application if you don't have one

	`cordova create UbuduDemo com.example.ubudu UbuduDemo`
	
	The *cordova* tool should respond something like:
	
	```
	Creating a new cordova project with name "UbuduDemo" and id "com.example.ubudu" at location...
	```

2. Add iOS platform support if not already present

	`cd UbuduDemo`
	
	`cordova platform add ios`

	```
	Creating ios project...
	```

### 3. Add the Ubudu SDK plugin

`cordova plugin add https://github.com/Ubudu/Cordova-SDK`

```
Fetching plugin "https://github.com/Ubudu/Cordova-SDK" via git clone
Installing "com.ubudu.cordova.sdk" for ios

```

### 4. Configure the project (iOS only)

Open the generated XCode project `UbuduDemo.xcodeproj` located in `platforms/ios/`.

1. Background Location Capability

	In the `UbuduDemo-Info.plist` file add the **location** capability to the *Required background modes* section. The simplest way to achieve that is to go in the project settings and then in *"Capabilities" -> "Background Modes"*, check **Location updates**.

2. Location Usage Description

	Since iOS 8.0 it is required to add another entry in the `UbuduDemo-Info.plist` file that explains why your application access the user location and when it needs to do so ("always" or "when in use" - region monitoring requires always). Add an entry with **NSLocationAlwaysUsageDescription** as key and a message that will be prompted to the user when asked for location permission. If this key is not added then the prompt is not presented to the user and you are not granted access to the user position.

### 5. Configuring and starting the Ubudu SDK

1. In `index.js` (located at `js/www/`) add the following code to the *onDeviceReady* function. 

	Below `app.receivedEvent('deviceready');` add:
	
	```
	UbuduSDK.setAppNamespace('634b207ee2f313c109c58675b44324ac2d41e61e', 	function(appNamespace){});
	var pluginElement = document.getElementById('ubudusdk');
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

	**You need to replace the app namespace by the one you created in the [Ubudu manager](https://manager.ubudu.com)**

	*Of course the label manipulation via the DOM API if only there to have a visual confirmation that the SDK is started. You are free to remove it.*


2. **(Optional)** In your `index.html` file add thw following HTML:

	*Only if you want a visual confirmation that the SDK has started.*
	
	Add this line:

	```
	<p id="ubudusdk" style="color:orange;">Ubudu SDK waiting for start</p>
	```
	
	Below this block
	
	```
	<div id="deviceready" class="blink">
	    <p class="event listening">Connecting to Device</p>
	    <p class="event received">Device is Ready</p>
	</div>
	```

3. **(iOS only)** In you `AppDelegate` class

	Add this import statement at the top of the file
	
	```
	#import <UbuduSDK/UbuduSDK.h>
	```
	
	And this line to the `application:didReceiveLocalNotification:` method
	
	```
	[[UbuduSDK sharedInstance] executeLocalNotificationActions:notification];
	```

### 6. Build and Run

* To only build the app `cordova build ios`

* To run on an iPhone simulator (won't be able to detect beacons but allows to check that everything runs as expected) `cordova build ios`

* To launch the app on a device, plug a device, then `cordova run ios`

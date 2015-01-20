//
// Copyright (c) 2011-2015, UBUDU SAS
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer.
//
// * Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
// DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
// FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
// DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
//         SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
// CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
// OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//

var UbuduSDK = {

	SDKVersion: null,

	getSDKVersion: function(resultCallback) {
		if (UbuduSDK.SDKVersion) {
			resultCallback(UbuduSDK.SDKVersion);
		} else {
		    cordova.exec(function(version) {
		    	UbuduSDK.SDKVersion = version;
		    	resultCallback(version);
		    }, function(err) {
		        console.log('UbuduSDKCordova ERROR: getSDKVersion => ' + err);
		    }, 'UbuduSDKCordova', 'getSDKVersion', []);
		}
	},

	getAppNamespace: function(resultCallback) {
		cordova.exec(function(namespace) {
			resultCallback(namespace);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getAppNamespace => ' + err);
		}, 'UbuduSDKCordova', 'getAppNamespace', []);
	},

	setAppNamespace: function(namespace, doneCallback) {
		cordova.exec(function() {
			if (doneCallback) {
				doneCallback(namespace);
			}
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: setAppNamespace => ' + err);
		}, 'UbuduSDKCordova', 'setAppNamespace', [namespace]);
	},

	getBaseURL: function(resultCallback) {
		cordova.exec(function(baseURL) {
			resultCallback(baseURL);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getBaseURL => ' + err);
		}, 'UbuduSDKCordova', 'getBaseURL', []);
	},

	setBaseURL: function(baseURL, successCallback, errorCallback) {
		cordova.exec(function() {
			successCallback(baseURL);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: setBaseURL => ' + err);
		    if (errorCallback) {
		    	errorCallback(err);
			}
		}, 'UbuduSDKCordova', 'setBaseURL', [baseURL]);
	},

	setDelegate: function() {
		console.log('UbuduSDKCordova: setDelegate not implemented');
		alert('UbuduSDKCordova: setDelegate not implemented');
	},

	getBeaconsEnabled: function(resultCallback) {
		cordova.exec(function(isEnabled) {
			resultCallback(isEnabled);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getBeaconsEnabled => ' + err);
		}, 'UbuduSDKCordova', 'getBeaconsEnabled', []);
	},

	setBeaconsEnabled: function(enableBeacons, doneCallback) {
		cordova.exec(function() {
			if (doneCallback) {
				doneCallback(enableBeacons);
			}
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: setBeaconsEnabled => ' + err);
		}, 'UbuduSDKCordova', 'setBeaconsEnabled', [enableBeacons]);
	},

	getGeofencesEnabled: function(resultCallback) {
		cordova.exec(function(isEnabled) {
			resultCallback(isEnabled);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getGeofencesEnabled => ' + err);
		}, 'UbuduSDKCordova', 'getGeofencesEnabled', []);
	},

	setGeofencesEnabled: function(enableGeofences, doneCallback) {
		cordova.exec(function() {
			if (doneCallback) {
				doneCallback(enableGeofences);
			}
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: setGeofencesEnabled => ' + err);
		}, 'UbuduSDKCordova', 'setGeofencesEnabled', [enableGeofences]);
	},

	getFileLogEnabled: function(resultCallback) {
		cordova.exec(function(isEnabled) {
			resultCallback(isEnabled);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getFileLogEnabled => ' + err);
		}, 'UbuduSDKCordova', 'getFileLogEnabled', []);
	},

	setFileLogEnabled: function(enableFileLogs, doneCallback) {
		cordova.exec(function() {
			if (doneCallback) {
				doneCallback(enableFileLogs);
			}
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: setFileLogEnabled => ' + err);
		}, 'UbuduSDKCordova', 'setFileLogEnabled', [enableFileLogs]);
	},

	deviceSupportsGeofences: function(resultCallback) {
		cordova.exec(function(isSupported) {
			resultCallback(isSupported);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: deviceSupportsGeofences => ' + err);
		}, 'UbuduSDKCordova', 'deviceSupportsGeofences', []);
	},

	deviceSupportsBeacons: function(resultCallback) {
		cordova.exec(function(isSupported) {
			resultCallback(isSupported);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: deviceSupportsBeacons => ' + err);
		}, 'UbuduSDKCordova', 'deviceSupportsBeacons', []);
	},

	start: function(successCallback, errorCallback) {
	    cordova.exec(function() {
	    	successCallback();
	    }, function(err) {
	        console.log('UbuduSDKCordova ERROR: start => ' + err);
	        if (errorCallback) {
		        errorCallback(err);
		    }
	    }, 'UbuduSDKCordova', 'start', []);
	},

	stop: function(doneCallback) {
	    cordova.exec(function() {
	    	if (doneCallback) {
		    	doneCallback();
		    }
	    }, function(err) {
	        console.log('UbuduSDKCordova ERROR: stop => ' + err);
	    }, 'UbuduSDKCordova', 'stop', []);
	},

	isRunning: function(resultCallback) {
		cordova.exec(function(running) {
			resultCallback(running);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: isRunning => ' + err);
		}, 'UbuduSDKCordova', 'isRunning', []);
	},

	resetCounters: function(successCallback, errorCallback) {
		cordova.exec(function() {
			successCallback();
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: resetCounters => ' + err);
		    if (errorCallback) {
			    errorCallback(err);
			}
		}, 'UbuduSDKCordova', 'resetCounters', []);
	},

	removeAllData: function(successCallback, errorCallback) {
		cordova.exec(function() {
			successCallback();
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: removeAllData => ' + err);
		    if (errorCallback) {
			    errorCallback(err);
			}
		}, 'UbuduSDKCordova', 'removeAllData', []);
	},

	getDebugFileContent: function(resultCallback) {
		cordova.exec(function(fileContent) {
			resultCallback(fileContent);
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: getDebugFileContent => ' + err);
		}, 'UbuduSDKCordova', 'getDebugFileContent', []);
	},

	clearDebugFile: function(doneCallback) {
		cordova.exec(function() {
			if (doneCallback) {
				doneCallback();
			}
		}, function(err) {
		    console.log('UbuduSDKCordova ERROR: clearDebugFile => ' + err);
		}, 'UbuduSDKCordova', 'clearDebugFile', []);
	}

};

module.exports = UbuduSDK;

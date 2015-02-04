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

package com.ubudu.cordova.sdk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;
import android.content.Context;

import com.ubudu.sdk.UbuduSDK;
import com.ubudu.sdk.UbuduBeaconManager;
import com.ubudu.sdk.UbuduGeofenceManager;

import com.ubudu.cordova.sdk.UbuduUserCordova;

public class UbuduSDKCordova extends CordovaPlugin {

    private boolean beaconsEnabled;
    private boolean geofencesEnabled;
    private boolean isRunning;

    @Override
    public void pluginInitialize() {
        this.beaconsEnabled = true;
        this.geofencesEnabled = true;
        this.isRunning = false;
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d("UbuduSDKCordova", "execute: action = " + action + " # args = " + args.length());
        
        if (action.equals("getSDKVersion")) {
            this.getSDKVersion(callbackContext);
        }
        else if (action.equals("getAppNamespace")) {
            this.getAppNamespace(callbackContext);
        }
        else if (action.equals("setAppNamespace")) {
            String appNamespace = args.getString(0);
            this.setAppNamespace(appNamespace, callbackContext);
        }
        else if (action.equals("getBaseURL")) {
            this.getBaseURL(callbackContext);
        }
        else if (action.equals("setBaseURL")) {
            String baseURL = args.getString(0);
            this.setBaseURL(baseURL, callbackContext);
        }
        else if (action.equals("setDelegate")) {
            // TODO get delegate param
            this.setDelegate(callbackContext);
        }
        else if (action.equals("getBeaconsEnabled")) {
            this.getBeaconsEnabled(callbackContext);
        }
        else if (action.equals("setBeaconsEnabled")) {
            boolean isEnabled = args.getBoolean(0);
            this.setBeaconsEnabled(isEnabled, callbackContext);
        }
        else if (action.equals("getGeofencesEnabled")) {
            this.getGeofencesEnabled(callbackContext);
        }
        else if (action.equals("setGeofencesEnabled")) {
            boolean isEnabled = args.getBoolean(0);
            this.setGeofencesEnabled(isEnabled, callbackContext);
        }
        else if (action.equals("getFileLogEnabled")) {
            this.getFileLogEnabled(callbackContext);
        }
        else if (action.equals("setFileLogEnabled")) {
            boolean isEnabled = args.getBoolean(0);
            this.setFileLogEnabled(isEnabled, callbackContext);
        }
        else if (action.equals("deviceSupportsGeofences")) {
            this.deviceSupportsGeofences(callbackContext);
        }
        else if (action.equals("deviceSupportsBeacons")) {
            this.deviceSupportsBeacons(callbackContext);
        }
        else if (action.equals("setUserInfo")) {
            JSONObject userInfo = args.getJSONObject(0);
            this.setUserInfo(userInfo, callbackContext);
        }
        else if (action.equals("start")) {
            this.start(callbackContext);
        }
        else if (action.equals("stop")) {
            this.stop(callbackContext);
        }
        else if (action.equals("isRunning")) {
            this.isRunning(callbackContext);
        }
        else if (action.equals("resetCounters")) {
            this.resetCounters(callbackContext);
        }
        else if (action.equals("removeAllData")) {
            this.removeAllData(callbackContext);
        }
        else if (action.equals("getDebugFileContent")) {
            this.getDebugFileContent(callbackContext);
        }
        else if (action.equals("clearDebugFile")) {
            this.clearDebugFile(callbackContext);
        } else {
            Log.e("UbuduSDKCordova", "Unknown action received (action = " + action + ")");
            return false;
        }
        return true;
    }

    private void getSDKVersion(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getSDKVersion");

        UbuduSDK sdk = getUbuduSDK();
        String sdkVersion = sdk.getVersion();

        callbackContext.success(sdkVersion);
    }

    private void getAppNamespace(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getAppNamespace");

        UbuduSDK sdk = getUbuduSDK();
        String appNamespace = sdk.namespace();

        callbackContext.success(appNamespace);
    }

    private void setAppNamespace(String appNamespace, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setAppNamespace");

        UbuduSDK sdk = getUbuduSDK();
        sdk.setNamespace(appNamespace);

        callbackContext.success();
    }

    private void getBaseURL(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getBaseURL");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void setBaseURL(String baseURL, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setBaseURL");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void setDelegate(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setDelegate");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void getBeaconsEnabled(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getBeaconsEnabled");
        callbackContext.success(this.beaconsEnabled ? 1 : 0);
    }

    private void setBeaconsEnabled(boolean isEnabled, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setBeaconsEnabled");

        UbuduSDK sdk = getUbuduSDK();
        Context context = this.getContext();
        UbuduBeaconManager beaconManager = sdk.getBeaconManager();
        this.beaconsEnabled = isEnabled;

        if (beaconManager != null) {
            if (beaconManager.isMonitoring() && isEnabled == false) {
                beaconManager.stop(context);
            } else if (!beaconManager.isMonitoring() && this.isRunning && isEnabled == true) {
                Error error = beaconManager.start(context);
                if (error != null) {
                    // TODO handle error
                }
            }
        }

        callbackContext.success();
    }

    private void getGeofencesEnabled(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getGeofencesEnabled");

        UbuduSDK sdk = getUbuduSDK();
        callbackContext.success(this.geofencesEnabled ? 1 : 0);
    }

    private void setGeofencesEnabled(boolean isEnabled, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setGeofencesEnabled");

        UbuduSDK sdk = getUbuduSDK();
        Context context = this.getContext();
        UbuduGeofenceManager geofenceManager = sdk.getGeofenceManager();
        this.geofencesEnabled = isEnabled;

        if (geofenceManager != null) {
            if (geofenceManager.isMonitoring() && isEnabled == false) {
                geofenceManager.stop(context);
            } else if (!geofenceManager.isMonitoring() && this.isRunning && isEnabled == true) {
                Error error = geofenceManager.start(context);
                if (error != null) {
                    // TODO handle error
                }
            }
        }

        callbackContext.success();
    }

    private void getFileLogEnabled(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getFileLogEnabled");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void setFileLogEnabled(boolean isEnabled, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setFileLogEnabled");

        UbuduSDK sdk = getUbuduSDK();
        sdk.setFileLogEnabled(isEnabled);

        callbackContext.success();
    }

    private void deviceSupportsGeofences(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "deviceSupportsGeofences");

        UbuduSDK sdk = getUbuduSDK();
        UbuduGeofenceManager geofenceManager = sdk.getGeofenceManager();
        boolean geofencesSupported = (geofenceManager != null);
        
        callbackContext.success(geofencesSupported ? 1 : 0);
    }

    private void deviceSupportsBeacons(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "deviceSupportsBeacons");

        UbuduSDK sdk = getUbuduSDK();
        UbuduBeaconManager beaconManager = sdk.getBeaconManager();
        boolean beaconsSupported = (beaconManager != null);

        callbackContext.success(beaconsSupported ? 1 : 0);
    }

    private void setUserInfo(JSONObject userInfo, CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "setUserInfo");

        UbuduSDK sdk = getUbuduSDK();
        UbuduUserCordova user = new UbuduUserCordova(userInfo);
        sdk.setUserInformation(user);

        callbackContext.success();
    }

    private void start(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "start");

        Context context = this.getContext();
        UbuduSDK sdk = getUbuduSDK();
        UbuduGeofenceManager geofenceManager = sdk.getGeofenceManager();
        UbuduBeaconManager beaconManager = sdk.getBeaconManager();

        if (geofenceManager != null && this.geofencesEnabled && !geofenceManager.isMonitoring()) {
            Error error = geofenceManager.start(context);
            if (error != null) {
                Log.e("UbuduSDKCordova", "start: Error with geofenceManager.start");
                callbackContext.error(error.getLocalizedMessage());
                return;
            }
        }
        if (beaconManager != null && this.beaconsEnabled && !beaconManager.isMonitoring()) {
            Error error = beaconManager.start(context);
            if (error != null) {
                if (geofenceManager != null && geofenceManager.isMonitoring()) {
                    geofenceManager.stop(context);
                }

                Log.e("UbuduSDKCordova", "start: Error with beaconManager.start");
                callbackContext.error(error.getLocalizedMessage());
                return;
            }
        }
        this.isRunning = true;

        callbackContext.success();
    }

    private void stop(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "stop");

        Context context = this.getContext();
        UbuduSDK sdk = getUbuduSDK();
        UbuduGeofenceManager geofenceManager = sdk.getGeofenceManager();
        UbuduBeaconManager beaconManager = sdk.getBeaconManager();

        if (geofenceManager != null && geofenceManager.isMonitoring()) {
            geofenceManager.stop(context);
        }
        if (beaconManager != null && beaconManager.isMonitoring()) {
            beaconManager.stop(context);
        }
        this.isRunning = false;

        callbackContext.success();
    }

    private void isRunning(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "isRunning");
        callbackContext.success(this.isRunning ? 1 : 0);
    }

    private void resetCounters(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "resetCounters");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void removeAllData(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "removeAllData");

        UbuduSDK sdk = getUbuduSDK();
        // TODO
        callbackContext.error("Not implemented");
    }

    private void getDebugFileContent(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "getDebugFileContent");

        UbuduSDK sdk = getUbuduSDK();
        String debugFileContent = sdk.debugFileContent();

        callbackContext.success(debugFileContent);
    }

    private void clearDebugFile(CallbackContext callbackContext) {
        Log.d("UbuduSDKCordova", "clearDebugFile");

        UbuduSDK sdk = getUbuduSDK();
        Context context = this.getContext();
        sdk.clearDebugFile(context);

        callbackContext.success();
    }

    private Context getContext() {
        return this.cordova.getActivity().getApplicationContext();
    }

    private UbuduSDK getUbuduSDK() {
        Context context = this.getContext();
        UbuduSDK sdk = UbuduSDK.getSharedInstance(context);
        return sdk;
    }
}
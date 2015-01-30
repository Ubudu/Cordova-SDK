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

#import <UbuduSDK/UbuduSDK.h>

#import "UbuduSDKCordova.h"

@implementation UbuduSDKCordova

- (void)getSDKVersion:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getSDKVersion");
    NSString *sdkVersion = [UbuduSDK sharedInstance].SDKVersion;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:sdkVersion];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getAppNamespace:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getAppNamespace");
    NSString *appNamespace = [UbuduSDK sharedInstance].appNamespace;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:appNamespace];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setAppNamespace:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    if ([command.arguments count] == 0) {
        NSLog(@"UbuduSDKCordova: setAppNamespace => error, no parameter");
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"App namespace parameter not provided"];
    }
    else {
        NSString *appNamespace = [command.arguments objectAtIndex:0];
        [UbuduSDK sharedInstance].appNamespace = appNamespace;
        NSLog(@"UbuduSDKCordova: setAppNamespace '%@'", appNamespace);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getBaseURL:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getBaseURL");
    NSString *baseURL = [UbuduSDK sharedInstance].baseURL;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:baseURL];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setBaseURL:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    if ([command.arguments count] == 0) {
        NSLog(@"UbuduSDKCordova: setBaseURL => error, no parameter");
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Base URL parameter not provided"];
    }
    else {
        NSString *baseURL = [command.arguments objectAtIndex:0];
        [UbuduSDK sharedInstance].baseURL = baseURL;
        NSLog(@"UbuduSDKCordova: setBaseURL '%@'", baseURL);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setDelegate:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: setDelegate");
    // TODO Implement
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Not implemented"];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getBeaconsEnabled:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getBeaconsEnabled");
    BOOL beaconsEnabled = [UbuduSDK sharedInstance].beaconsEnabled;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:beaconsEnabled];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setBeaconsEnabled:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    if ([command.arguments count] == 0) {
        NSLog(@"UbuduSDKCordova: setBeaconsEnabled => error, no parameter");
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"'Beacons enabled' boolean parameter not provided"];
    }
    else {
        NSNumber *beaconsEnabled = [command.arguments objectAtIndex:0];
        [UbuduSDK sharedInstance].beaconsEnabled = [beaconsEnabled boolValue];
        NSLog(@"UbuduSDKCordova: setBeaconsEnabled '%@'", beaconsEnabled);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getGeofencesEnabled:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getGeofencesEnabled");
    BOOL geofencesEnabled = [UbuduSDK sharedInstance].geofencesEnabled;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:geofencesEnabled];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setGeofencesEnabled:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    if ([command.arguments count] == 0) {
        NSLog(@"UbuduSDKCordova: setGeofencesEnabled => error, no parameter");
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"'Geofences enabled' boolean parameter not provided"];
    }
    else {
        NSNumber *geofencesEnabled = [command.arguments objectAtIndex:0];
        [UbuduSDK sharedInstance].geofencesEnabled = [geofencesEnabled boolValue];
        NSLog(@"UbuduSDKCordova: setGeofencesEnabled '%@'", geofencesEnabled);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getFileLogEnabled:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getFileLogEnabled");
    BOOL fileLogEnabled = [UbuduSDK sharedInstance].fileLogEnabled;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:fileLogEnabled];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setFileLogEnabled:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    if ([command.arguments count] == 0) {
        NSLog(@"UbuduSDKCordova: setFileLogEnabled => error, no parameter");
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"'File log enabled' boolean parameter not provided"];
    }
    else {
        NSNumber *fileLogEnabled = [command.arguments objectAtIndex:0];
        [UbuduSDK sharedInstance].fileLogEnabled = [fileLogEnabled boolValue];
        NSLog(@"UbuduSDKCordova: setFileLogEnabled '%@'", fileLogEnabled);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)deviceSupportsGeofences:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: deviceSupportsGeofences");
    CDVPluginResult* pluginResult = nil;

    NSError *error = nil;
    BOOL geofencesSupported = [UbuduSDK deviceSupportsGeofences:[UIDevice currentDevice] error:&error];

    if (error != nil) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.localizedDescription];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:geofencesSupported];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)deviceSupportsBeacons:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: deviceSupportsBeacons");
    CDVPluginResult* pluginResult = nil;

    NSError *error = nil;
    BOOL beaconsSupported = [UbuduSDK deviceSupportsBeacons:[UIDevice currentDevice] error:&error];

    if (error != nil) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.localizedDescription];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:beaconsSupported];
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)start:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: start");
    CDVPluginResult* pluginResult = nil;
    
    NSError *error = nil;
    BOOL result = [[UbuduSDK sharedInstance] start:&error];
    if (result) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        if (error != nil) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.localizedDescription];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)stop:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: stop");
    [[UbuduSDK sharedInstance] stop];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)isRunning:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: isRunning");
    BOOL isRunning = [UbuduSDK sharedInstance].isRunning;

    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:isRunning];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)resetCounters:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: resetCounters");
    CDVPluginResult* pluginResult = nil;
    
    NSError *error = nil;
    BOOL result = [[UbuduSDK sharedInstance] resetCounters:&error];
    if (result) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        if (error != nil) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.localizedDescription];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)removeAllData:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: removeAllData");
    CDVPluginResult* pluginResult = nil;
    
    NSError *error = nil;
    BOOL result = [[UbuduSDK sharedInstance] removeAllData:&error];
    if (result) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        if (error != nil) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:error.localizedDescription];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
    }
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getDebugFileContent:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: getDebugFileContent");

    NSData *debugFileContent = [[UbuduSDK sharedInstance] getDebugFileContent];
    
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsArrayBuffer:debugFileContent];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)clearDebugFile:(CDVInvokedUrlCommand*)command
{
    NSLog(@"UbuduSDKCordova: clearDebugFile");

    [[UbuduSDK sharedInstance] clearDebugFile];
    [self.commandDelegate sendPluginResult:[CDVPluginResult resultWithStatus:CDVCommandStatus_OK] callbackId:command.callbackId];
}

@end
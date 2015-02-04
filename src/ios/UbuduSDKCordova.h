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

#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>

@interface UbuduSDKCordova : CDVPlugin

- (void)getSDKVersion:(CDVInvokedUrlCommand*)command;

- (void)getAppNamespace:(CDVInvokedUrlCommand*)command;
- (void)setAppNamespace:(CDVInvokedUrlCommand*)command;

- (void)getBaseURL:(CDVInvokedUrlCommand*)command;
- (void)setBaseURL:(CDVInvokedUrlCommand*)command;

- (void)setDelegate:(CDVInvokedUrlCommand*)command;

- (void)getBeaconsEnabled:(CDVInvokedUrlCommand*)command;
- (void)setBeaconsEnabled:(CDVInvokedUrlCommand*)command;

- (void)getGeofencesEnabled:(CDVInvokedUrlCommand*)command;
- (void)setGeofencesEnabled:(CDVInvokedUrlCommand*)command;

// TODO presentationViewController property ?
// TODO user property

- (void)getFileLogEnabled:(CDVInvokedUrlCommand*)command;
- (void)setFileLogEnabled:(CDVInvokedUrlCommand*)command;

- (void)deviceSupportsGeofences:(CDVInvokedUrlCommand*)command;
- (void)deviceSupportsBeacons:(CDVInvokedUrlCommand*)command;

- (void)setUserInfo:(CDVInvokedUrlCommand*)command;

- (void)start:(CDVInvokedUrlCommand*)command;
- (void)stop:(CDVInvokedUrlCommand*)command;
- (void)isRunning:(CDVInvokedUrlCommand*)command;

- (void)resetCounters:(CDVInvokedUrlCommand*)command;

- (void)removeAllData:(CDVInvokedUrlCommand*)command;

- (void)getDebugFileContent:(CDVInvokedUrlCommand*)command;
- (void)clearDebugFile:(CDVInvokedUrlCommand*)command;

@end

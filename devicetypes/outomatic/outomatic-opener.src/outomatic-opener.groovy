/**
 *  Copyright 2016 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
import physicalgraph.zigbee.clusters.iaszone.ZoneStatus
import physicalgraph.zigbee.zcl.DataType

metadata {

	definition (name: "Outomatic Opener", namespace: "outomatic", author: "Outomatic, LLC", genericHandler: "Zigbee") {
		capability "Refresh"
		command	"getInfo"
        
		fingerprint endpointId: "10", profileId: "0104", inClusters: "0000,0003,0004,0005,0006", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"
		fingerprint endpointId: "11", profileId: "0104", inClusters: "0000,0003,0004,0005,0006", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"        
		fingerprint endpointId: '12', profileId: "0104", inClusters: "0000,0003,0402", outClusters: "0003", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener" 
		fingerprint endpointId: '13', profileId: "0104", inClusters: "0000,0003,000F", outClusters: "0003", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"
		fingerprint endpointId: '14', profileId: "0104", inClusters: "0000,0003,000F", outClusters: "0003", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"
		fingerprint endpointId: '15', profileId: "0104", inClusters: "0000,0003,000F", outClusters: "0003", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"
		fingerprint endpointId: '16', profileId: "0104", inClusters: "0000,0003,000F", outClusters: "0003", application: "02", manufacturer: "Outomatic", model: "Opener_v1.0", deviceJoinName: "Outomatic Opener"
	}

	tiles(scale: 1) {
        standardTile("refresh", "device.refresh", inactiveLabel: false, decoration: "flat", width: 1, height: 1) {
            state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
        }
        details(["refresh"])
    }
}

// Parse incoming device messages to generate events
def parse(String description) {
    log.debug "Parsing description: $description"
    def event = zigbee.getEvent(description)
    log.debug(event)
}

def getInfo() {
	log.debug "getInfo called."
}

def refresh() {
	log.debug "Starting Refresh (2)"
	["zdo active 0x${device.deviceNetworkId}", "delay 2000"]
}

def installed() {
	log.debug "Installed."
}

def configure() {
    log.debug "Configuring Reporting and Bindings."
	// Device-Watch allows 2 check-in misses from device + ping (plus 2 min lag time)
	// sendEvent(name: "checkInterval", value: 2 * 10 * 60 + 2 * 60, displayed: false, data: [protocol: "zigbee", hubHardwareId: device.hub.hardwareID])
}

def ping() {
	log.debug "Ping"
}
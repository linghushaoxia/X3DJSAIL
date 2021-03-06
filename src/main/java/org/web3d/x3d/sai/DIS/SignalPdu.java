/*
Copyright (c) 1995-2017 held by the author(s).  All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer
      in the documentation and/or other materials provided with the
      distribution.
    * Neither the name of the Web3D Consortium (http://www.web3D.org)
      nor the names of its contributors may be used to endorse or
      promote products derived from this software without specific
      prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/

package org.web3d.x3d.sai.DIS;


import org.web3d.x3d.sai.Networking.X3DNetworkSensorNode;
import org.web3d.x3d.sai.Grouping.X3DBoundedObject;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  SignalPdu is a networked Protocol Data Unit (PDU) information node that communicates the transmission of voice, audio or other data modeled in a simulation. 
 * <ul>
 *  <li> <i>Hint:</i>  SignalPdu packets use the IEEE Distributed Interactive Simulation (DIS) protocol.  </li> 
 *  <li> <i>Hint:</i>  Savage Developers Guide on DIS https://savage.nps.edu/Savage/developers.html#DIS  </li> 
 *  <li> <i>Hint:</i>   include &lt;component name='DIS' level='1'/&gt;  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#SignalPdu" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/dis.html#SignalPdu" target="blank">X3D Abstract Specification: SignalPdu</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#SignalPdu" target="_blank">X3D Tooltips: SignalPdu</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface SignalPdu extends X3DNetworkSensorNode, X3DBoundedObject
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide String value from inputOutput SFString field named <i>address</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Multicast network address, or else "localhost" example: 224.2.181.145.
	 * @return value of address field
	 */
	public String getAddress();

	/**
	 * Assign String value to inputOutput SFString field named <i>address</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Multicast network address, or else "localhost" example: 224.2.181.145.
	 * @param newValue is new value for the address field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setAddress(String newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>applicationID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Each simulation application that can respond to simulation management PDUs needs to have a unique applicationID.
	 * @return value of applicationID field
	 */
	public int getApplicationID();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>applicationID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Each simulation application that can respond to simulation management PDUs needs to have a unique applicationID.
	 * @param newValue is new value for the applicationID field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setApplicationID(int newValue);

	/**
	 * Provide array of 3-tuple float results from initializeOnly SFVec3f field named <i>bboxCenter</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Bounding box center: optional hint for position offset from origin of local coordinate system.
	 * @return value of bboxCenter field
	 */
	@Override
	public float[] getBboxCenter();

	/**
	 * Assign 3-tuple float array to initializeOnly SFVec3f field named <i>bboxCenter</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Bounding box center: optional hint for position offset from origin of local coordinate system.
	 * @param newValue is new value for the bboxCenter field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setBboxCenter(float[] newValue);

	/**
	 * Provide array of 3-tuple float results within allowed range of [0,infinity), or default value [-1 -1 -1], from initializeOnly SFVec3f field named <i>bboxSize</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Bounding box size is usually omitted, and can easily be calculated automatically by an X3D player at scene-loading time with minimal computational cost. Bounding box size can also be defined as an optional authoring hint that suggests an optimization or constraint. Hint: can be useful for collision computations or inverse-kinematics (IK) engines.
	 * @return value of bboxSize field
	 */
	@Override
	public float[] getBboxSize();

	/**
	 * Assign 3-tuple float array within allowed range of [0,infinity), or default value [-1 -1 -1], to initializeOnly SFVec3f field named <i>bboxSize</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Bounding box size is usually omitted, and can easily be calculated automatically by an X3D player at scene-loading time with minimal computational cost. Bounding box size can also be defined as an optional authoring hint that suggests an optimization or constraint. Hint: can be useful for collision computations or inverse-kinematics (IK) engines.
	 * @param newValue is new value for the bboxSize field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setBboxSize(float[] newValue);

	/**
	 * Provide array of int results from inputOutput MFInt32 field named <i>data</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Holds audio or digital data conveyed by the radio transmission. Interpretation of the field depends on values of encodingScheme and tdlType fields.
	 * @return value of data field
	 */
	public int[] getData();

	/**
	 * Assign int array to inputOutput MFInt32 field named <i>data</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Holds audio or digital data conveyed by the radio transmission. Interpretation of the field depends on values of encodingScheme and tdlType fields.
	 * @param newValue is new value for the data field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setData(int[] newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>dataLength</i>.
	 * <br><br>
	 * <i>Tooltip:</i> number of bits of digital voice audio or digital data being sent in the Signal PDU. If the Encoding Class is database index, then dataLength field is set to 96.
	 * @return value of dataLength field
	 */
	public int getDataLength();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>dataLength</i>.
	 * <br><br>
	 * <i>Tooltip:</i> number of bits of digital voice audio or digital data being sent in the Signal PDU. If the Encoding Class is database index, then dataLength field is set to 96.
	 * @param newValue is new value for the dataLength field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setDataLength(int newValue);

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables the sensor node.
	 * @return value of enabled field
	 */
	@Override
	public boolean getEnabled();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables the sensor node.
	 * @param newValue is new value for the enabled field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setEnabled(boolean newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>encodingScheme</i>.
	 * <br><br>
	 * <i>Tooltip:</i> designates both Encoding Class and Encoding Type. Encoding Class enumerated value (2 most significant bits): 0 = Encoded Voice; 1 = Raw Binary Data; 2 = Application-Specific Data; 3 = Database Index. Encoding Type enumerated value (14 least significant bits): 1 = 8-bit mu-law; 2 = CVSD per MIL-STD-188-113; 3 = ADPCM per CCITT G.721; 4 = 16-bit linear PCM; 5 = 8-bit linear PCM; 6 = Vector Quantization.
	 * @return value of encodingScheme field
	 */
	public int getEncodingScheme();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>encodingScheme</i>.
	 * <br><br>
	 * <i>Tooltip:</i> designates both Encoding Class and Encoding Type. Encoding Class enumerated value (2 most significant bits): 0 = Encoded Voice; 1 = Raw Binary Data; 2 = Application-Specific Data; 3 = Database Index. Encoding Type enumerated value (14 least significant bits): 1 = 8-bit mu-law; 2 = CVSD per MIL-STD-188-113; 3 = ADPCM per CCITT G.721; 4 = 16-bit linear PCM; 5 = 8-bit linear PCM; 6 = Vector Quantization.
	 * @param newValue is new value for the encodingScheme field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setEncodingScheme(int newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>entityID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> EntityID unique ID for entity within that application.
	 * @return value of entityID field
	 */
	public int getEntityID();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>entityID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> EntityID unique ID for entity within that application.
	 * @param newValue is new value for the entityID field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setEntityID(int newValue);

	/**
	 * Provide array of 3-tuple double results from inputOutput SFVec3d field named <i>geoCoords</i>.
	 * @return value of geoCoords field
	 */
	public double[] getGeoCoords();

	/**
	 * Assign 3-tuple double array to inputOutput SFVec3d field named <i>geoCoords</i>.
	 * @param newValue is new value for the geoCoords field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setGeoCoords(double[] newValue);

	/**
	 * Provide array of String results from initializeOnly MFString field named <i>geoSystem</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (X3D version 3.3 or later) Identifies spatial reference frame: Geodetic (GD), Geocentric (GC), Universal Transverse Mercator (UTM). Supported values: "GD" "UTM" or "GC" followed by additional quoted string parameters as appropriate for the type. Hint: see X3D Specification 25.2.2 Spatial reference frames http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geodata.html#Spatialreferenceframes Hint: see X3D Specification 25.2.4 Specifying geospatial coordinates http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geodata.html#Specifyinggeospatialcoords Hint: UTM is Universal Transverse Mercator coordinate system https://en.wikipedia.org/wiki/Universal_Transverse_Mercator_coordinate_system Warning: deprecated values are GDC (use GD) and GCC (use GC).
	 * @return value of geoSystem field
	 */
	public String[] getGeoSystem();

	/**
	 * Assign String array to initializeOnly MFString field named <i>geoSystem</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (X3D version 3.3 or later) Identifies spatial reference frame: Geodetic (GD), Geocentric (GC), Universal Transverse Mercator (UTM). Supported values: "GD" "UTM" or "GC" followed by additional quoted string parameters as appropriate for the type. Hint: see X3D Specification 25.2.2 Spatial reference frames http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geodata.html#Spatialreferenceframes Hint: see X3D Specification 25.2.4 Specifying geospatial coordinates http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geodata.html#Specifyinggeospatialcoords Hint: UTM is Universal Transverse Mercator coordinate system https://en.wikipedia.org/wiki/Universal_Transverse_Mercator_coordinate_system Warning: deprecated values are GDC (use GD) and GCC (use GC).
	 * @param newValue is new value for the geoSystem field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setGeoSystem(String[] newValue);

	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isActive</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Have we had a network update recently?.
	 * @return value of isActive field
	 */
	@Override
	public boolean getIsActive();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isNetworkReader</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether networkMode="remote" (listen to network as copy of remote entity).
	 * @return value of isNetworkReader field
	 */
	public boolean getIsNetworkReader();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isNetworkWriter</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether networkMode="master" (output to network as master entity at writeInterval).
	 * @return value of isNetworkWriter field
	 */
	public boolean getIsNetworkWriter();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isRtpHeaderHeard</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether incoming DIS packets have an RTP header prepended.
	 * @return value of isRtpHeaderHeard field
	 */
	public boolean getIsRtpHeaderHeard();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isStandAlone</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether networkMode="local" (ignore network but still respond to local events).
	 * @return value of isStandAlone field
	 */
	public boolean getIsStandAlone();
	/**
	 * Provide X3DMetadataObject instance (using a properly typed node) from inputOutput SFNode field <i>metadata</i>.
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @return value of metadata field
	 */
	@Override
	public X3DMetadataObject getMetadata(); // acceptable node types: X3DMetadataObject

	/**
	 * Assign X3DMetadataObject instance (using a properly typed node) to inputOutput SFNode field <i>metadata</i>.
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @param newValue is new value for the metadata field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide String value from inputOutput SFString field named <i>multicastRelayHost</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Fallback server address if multicast not available locally. For example: track.nps.edu.
	 * @return value of multicastRelayHost field
	 */
	public String getMulticastRelayHost();

	/**
	 * Assign String value to inputOutput SFString field named <i>multicastRelayHost</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Fallback server address if multicast not available locally. For example: track.nps.edu.
	 * @param newValue is new value for the multicastRelayHost field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setMulticastRelayHost(String newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>multicastRelayPort</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Fallback server port if multicast not available locally. For example: 8010.
	 * @return value of multicastRelayPort field
	 */
	public int getMulticastRelayPort();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>multicastRelayPort</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Fallback server port if multicast not available locally. For example: 8010.
	 * @param newValue is new value for the multicastRelayPort field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setMulticastRelayPort(int newValue);

	/**
	 * Provide String enumeration value ['standAlone'|'networkReader'|'networkWriter'] from inputOutput SFString field named <i>networkMode</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether this entity is ignoring the network, sending DIS packets to the network, or receiving DIS packets from the network. (1) standAlone: ignore network but still respond to events in local scene. (2) networkReader: listen to network and read PDU packets at readInterval, act as remotely linked copy of entity. (3) networkWriter: send PDU packets to network at writeInterval, act as master entity. Default value "standAlone" ensures that DIS network activation within a scene as networkReader or networkWriter is intentional. Warning: do not wrap extra quotation marks around these SFString enumeration values, since "quotation" "marks" are only used for MFString values. Warning: network activity may have associated security issues.
	 * @return value of networkMode field
	 */
	public String getNetworkMode();

	/**
	 * Assign String enumeration value ("standAlone"|"networkReader"|"networkWriter") ['standAlone'|'networkReader'|'networkWriter'] to inputOutput SFString field named <i>networkMode</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether this entity is ignoring the network, sending DIS packets to the network, or receiving DIS packets from the network. (1) standAlone: ignore network but still respond to events in local scene. (2) networkReader: listen to network and read PDU packets at readInterval, act as remotely linked copy of entity. (3) networkWriter: send PDU packets to network at writeInterval, act as master entity. Default value "standAlone" ensures that DIS network activation within a scene as networkReader or networkWriter is intentional. Warning: do not wrap extra quotation marks around these SFString enumeration values, since "quotation" "marks" are only used for MFString values. Warning: network activity may have associated security issues.
	 * @param newValue is new value for the networkMode field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setNetworkMode(String newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>port</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Multicast network port, for example: 62040.
	 * @return value of port field
	 */
	public int getPort();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>port</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Multicast network port, for example: 62040.
	 * @param newValue is new value for the port field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setPort(int newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>radioID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Identifies a particular radio within a given entity.
	 * @return value of radioID field
	 */
	public int getRadioID();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>radioID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Identifies a particular radio within a given entity.
	 * @param newValue is new value for the radioID field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setRadioID(int newValue);

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>readInterval</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Seconds between read updates, 0 means no reading.
	 * @return value of readInterval field
	 */
	public double getReadInterval();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>readInterval</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Seconds between read updates, 0 means no reading.
	 * @param newValue is new value for the readInterval field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setReadInterval(double newValue);

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>rtpHeaderExpected</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether RTP headers are prepended to DIS PDUs.
	 * @return value of rtpHeaderExpected field
	 */
	public boolean getRtpHeaderExpected();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>rtpHeaderExpected</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether RTP headers are prepended to DIS PDUs.
	 * @param newValue is new value for the rtpHeaderExpected field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setRtpHeaderExpected(boolean newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>sampleRate</i>.
	 * <br><br>
	 * <i>Tooltip:</i> sampleRate gives either (1) sample rate in samples per second if Encoding Class is encoded audio, or (2) data rate in bits per second for data transmissions. If Encoding Class is database index, sampleRate is set to zero.
	 * @return value of sampleRate field
	 */
	public int getSampleRate();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>sampleRate</i>.
	 * <br><br>
	 * <i>Tooltip:</i> sampleRate gives either (1) sample rate in samples per second if Encoding Class is encoded audio, or (2) data rate in bits per second for data transmissions. If Encoding Class is database index, sampleRate is set to zero.
	 * @param newValue is new value for the sampleRate field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setSampleRate(int newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>samples</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Number of samples in the PDU if the Encoding Class is encoded voice, otherwise the field is set to zero.
	 * @return value of samples field
	 */
	public int getSamples();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>samples</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Number of samples in the PDU if the Encoding Class is encoded voice, otherwise the field is set to zero.
	 * @param newValue is new value for the samples field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setSamples(int newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>siteID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Simulation/exercise siteID of the participating LAN or organization.
	 * @return value of siteID field
	 */
	public int getSiteID();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>siteID</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Simulation/exercise siteID of the participating LAN or organization.
	 * @param newValue is new value for the siteID field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setSiteID(int newValue);

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>tdlType</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Tactical Data Link (TDL) type as an enumerated value when the Encoding Class is voice, raw binary, application-specific, or database index representation of a TDL message.
	 * @return value of tdlType field
	 */
	public int getTdlType();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>tdlType</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Tactical Data Link (TDL) type as an enumerated value when the Encoding Class is voice, raw binary, application-specific, or database index representation of a TDL message.
	 * @param newValue is new value for the tdlType field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setTdlType(int newValue);

	/**
	 * Provide double value in seconds from outputOnly SFTime field named <i>timestamp</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DIS timestamp in X3D units (seconds since 1 January 1970).
	 * @return value of timestamp field
	 */
	public double getTimestamp();
	/**
	 * Provide int value from inputOutput SFInt32 field named <i>whichGeometry</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Select geometry to render: -1 for no geometry, 0 for text trace, 1 for default geometry, (optional) higher values to render different states.
	 * @return value of whichGeometry field
	 */
	public int getWhichGeometry();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>whichGeometry</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Select geometry to render: -1 for no geometry, 0 for text trace, 1 for default geometry, (optional) higher values to render different states.
	 * @param newValue is new value for the whichGeometry field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setWhichGeometry(int newValue);

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>writeInterval</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Seconds between write updates, 0 means no writing (sending).
	 * @return value of writeInterval field
	 */
	public double getWriteInterval();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>writeInterval</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Seconds between write updates, 0 means no writing (sending).
	 * @param newValue is new value for the writeInterval field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SignalPdu setWriteInterval(double newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setDEF(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>USE</i>.
	 * <br><br>
	 * <i>Tooltip:</i> USE means reuse an already DEF-ed node ID, excluding all child nodes and all other attributes (except for containerField, which can have a different value). Hint: USE references to previously defined DEF geometry (instead of duplicating nodes) can improve performance. Warning: do NOT include any child nodes, a DEF attribute, or any other attribute values (except for containerField) when defining a USE attribute. Warning: each USE value must match a corresponding DEF value that is defined earlier in the scene.
	 * <br><br>
	 * <i>Note:</i> each <code>USE</code> node is still an independent object, with the <code>USE</code> value matching the <code>DEF</code> value in the preceding object. 
	 * <br><br>
	 * <i>WARNING:</i> invoking the <code>setUSE()</code> method resets all other fields to their default values and also releases all child nodes.<br><br>
	 * <i>WARNING:</i> no other operations can be performed to modify a USE node other than setting an alternate containerField value.
	 * @param newValue is new value for the USE field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link SignalPdu} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SignalPdu setCssClass(String newValue);

}

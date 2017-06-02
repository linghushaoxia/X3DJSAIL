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

package org.web3d.x3d.sai.HAnim;


import org.web3d.x3d.sai.Core.X3DChildNode;
import org.web3d.x3d.sai.Grouping.X3DBoundedObject;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.HAnim.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.HAnim.*;
import org.web3d.x3d.sai.HAnim.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.Rendering.*;
import org.web3d.x3d.sai.Rendering.*;
import org.web3d.x3d.sai.HAnim.*;
import java.util.Arrays;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  The HAnimHumanoid node is used to: (a) store references to the joints, segments, sites, skin and viewpoints, (b) serve as a container for the entire humanoid, (c) provide a convenient way of moving the humanoid through its environment, and (d) store human-readable data such as author and copyright information. HAnimHumanoid contains HAnimJoint, HAnimSegment and HAnimSite nodes, plus a single optional Coordinate/CoordinateDouble mesh with a single corresponding Normal node. 
 * <ul>
 *  <li> <i>Hint:</i>  MFNode arrays for joints, segments, sites, skin and viewpoints usually follow the human body definition and contain USE node references.  </li> 
 *  <li> <i>Hint:</i>  H-Anim Specification http://www.web3d.org/documents/specifications/19774-1/V2.0/HAnim/HAnimArchitecture.html  </li> 
 *  <li> <i>Hint:</i>  H-Anim Specification, Humanoid http://www.web3d.org/documents/specifications/19774-1/V2.0/HAnim/ObjectInterfaces.html#Humanoid  </li> 
 *  <li> <i>Hint:</i>  the viewpoints field connects internal Site nodes that in turn hold relative Viewpoint nodes, such as HAnimSite USE='ObserveFace_viewSite' containerField='viewpoints'/&gt; which has a corresponding &lt;HAnimSite DEF='ObserveFace_viewSite' name='ObserveFace_view' containerField='children' description='look at me!'/&gt; node.  </li> 
 *  <li> <i>Hint:</i>   include &lt;component name='H-Anim' level='1'/&gt;  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#HAnimHumanoid" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/hanim.html#HAnimHumanoid" target="blank">X3D Abstract Specification: HAnimHumanoid</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#HAnimHumanoid" target="_blank">X3D Tooltips: HAnimHumanoid</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface HAnimHumanoid extends X3DChildNode, X3DBoundedObject
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

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
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setBboxCenter(float[] newValue);

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
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setBboxSize(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>center</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Translation offset from origin of local coordinate system.
	 * @return value of center field
	 */
	public float[] getCenter();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>center</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Translation offset from origin of local coordinate system.
	 * @param newValue is new value for the center field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setCenter(float[] newValue);

	/**
	 * Provide array of String results from inputOutput MFString field named <i>info</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Contains metadata keyword=value pairs, where approved keyword terms are humanoidVersion authorName authorEmail copyright creationDate usageRestrictions age gender height and weight.
	 * @return value of info field
	 */
	public String[] getInfo();

	/**
	 * Assign String array to inputOutput MFString field named <i>info</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Contains metadata keyword=value pairs, where approved keyword terms are humanoidVersion authorName authorEmail copyright creationDate usageRestrictions age gender height and weight.
	 * @param newValue is new value for the info field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setInfo(String[] newValue);

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>joints</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint.
	 * @return value of joints field
	 */
	public X3DNode[] getJoints(); // acceptable node types: HAnimJoint

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>joints</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint.
	 * @param newValue is new value for the joints field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setJoints(X3DNode[] newValue); // acceptable node types: HAnimJoint

	/**
	 * Add array of child joints nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint.
	 * @param newValue is new value array to be appended the joints field.
	 */
	public void addJoints(X3DNode[] newValue); // acceptable node types: HAnimJoint
	/**
	 * Set single child joints node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the joints field.
	 */
	public void setJoints(X3DNode newValue); // acceptable node types: HAnimJoint
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
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide String value from inputOutput SFString field named <i>name</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Unique name attribute must be defined so that HAnimHumanoid node can be identified at run time for animation purposes. Warning: name is not included if this instance is a USE node.
	 * @return value of name field
	 */
	public String getName();

	/**
	 * Assign String value to inputOutput SFString field named <i>name</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Unique name attribute must be defined so that HAnimHumanoid node can be identified at run time for animation purposes. Warning: name is not included if this instance is a USE node.
	 * <br><br>@see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions">X3D Scene Authoring Hints: Naming Conventions</a>
	 * @param newValue is new value for the name field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setName(String newValue);

	/**
	 * Provide array of 4-tuple float results unit axis, angle (in radians) from inputOutput SFRotation field named <i>rotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation of children relative to local coordinate system.
	 * @return value of rotation field
	 */
	public float[] getRotation();

	/**
	 * Assign 4-tuple float array unit axis, angle (in radians) to inputOutput SFRotation field named <i>rotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation of children relative to local coordinate system.
	 * @param newValue is new value for the rotation field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setRotation(float[] newValue);

	/**
	 * Provide array of 3-tuple float results within allowed range of (0,infinity) from inputOutput SFVec3f field named <i>scale</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Non-uniform x-y-z scale of child coordinate system, adjusted by center and scaleOrientation.
	 * @return value of scale field
	 */
	public float[] getScale();

	/**
	 * Assign 3-tuple float array within allowed range of (0,infinity) to inputOutput SFVec3f field named <i>scale</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Non-uniform x-y-z scale of child coordinate system, adjusted by center and scaleOrientation.
	 * @param newValue is new value for the scale field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setScale(float[] newValue);

	/**
	 * Provide array of 4-tuple float results unit axis, angle (in radians) from inputOutput SFRotation field named <i>scaleOrientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Preliminary rotation of coordinate system before scaling (to allow scaling around arbitrary orientations).
	 * @return value of scaleOrientation field
	 */
	public float[] getScaleOrientation();

	/**
	 * Assign 4-tuple float array unit axis, angle (in radians) to inputOutput SFRotation field named <i>scaleOrientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Preliminary rotation of coordinate system before scaling (to allow scaling around arbitrary orientations).
	 * @param newValue is new value for the scaleOrientation field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setScaleOrientation(float[] newValue);

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>segments</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSegment.
	 * @return value of segments field
	 */
	public X3DNode[] getSegments(); // acceptable node types: HAnimSegment

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>segments</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSegment.
	 * @param newValue is new value for the segments field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSegments(X3DNode[] newValue); // acceptable node types: HAnimSegment

	/**
	 * Add array of child segments nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSegment.
	 * @param newValue is new value array to be appended the segments field.
	 */
	public void addSegments(X3DNode[] newValue); // acceptable node types: HAnimSegment
	/**
	 * Set single child segments node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the segments field.
	 */
	public void setSegments(X3DNode newValue); // acceptable node types: HAnimSegment
	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>sites</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @return value of sites field
	 */
	public X3DNode[] getSites(); // acceptable node types: HAnimSite

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>sites</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @param newValue is new value for the sites field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSites(X3DNode[] newValue); // acceptable node types: HAnimSite

	/**
	 * Add array of child sites nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @param newValue is new value array to be appended the sites field.
	 */
	public void addSites(X3DNode[] newValue); // acceptable node types: HAnimSite
	/**
	 * Set single child sites node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the sites field.
	 */
	public void setSites(X3DNode newValue); // acceptable node types: HAnimSite
	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) with acceptable node types HAnimJoint|HAnimSite, from inputOutput MFNode field <i>skeleton</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint|HAnimSite.
	 * @return value of skeleton field
	 */
	public X3DNode[] getSkeleton(); // acceptable node types: HAnimJoint|HAnimSite

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) with acceptable node types HAnimJoint|HAnimSite, to inputOutput MFNode field <i>skeleton</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint|HAnimSite.
	 * @param newValue is new value for the skeleton field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSkeleton(X3DNode[] newValue); // acceptable node types: HAnimJoint|HAnimSite

	/**
	 * Add array of child skeleton nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimJoint|HAnimSite.
	 * @param newValue is new value array to be appended the skeleton field.
	 */
	public void addSkeleton(X3DNode[] newValue); // acceptable node types: HAnimJoint|HAnimSite
	/**
	 * Set single child skeleton node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the skeleton field.
	 */
	public void setSkeleton(X3DNode newValue); // acceptable node types: HAnimJoint|HAnimSite
	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>skin</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode.
	 * @return value of skin field
	 */
	public X3DNode[] getSkin(); // acceptable node types: X3DChildNode

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>skin</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode.
	 * @param newValue is new value for the skin field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSkin(X3DNode[] newValue); // acceptable node types: X3DChildNode

	/**
	 * Add array of child skin nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode.
	 * @param newValue is new value array to be appended the skin field.
	 */
	public void addSkin(X3DNode[] newValue); // acceptable node types: X3DChildNode
	/**
	 * Set single child skin node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the skin field.
	 */
	public void setSkin(X3DNode newValue); // acceptable node types: X3DChildNode
	/**
	 * Provide X3DCoordinateNode instance (using a properly typed node) from inputOutput SFNode field <i>skinCoord</i>.
	 * @return value of skinCoord field
	 */
	public X3DCoordinateNode getSkinCoord(); // acceptable node types: X3DCoordinateNode

	/**
	 * Assign X3DCoordinateNode instance (using a properly typed node) to inputOutput SFNode field <i>skinCoord</i>.
	 * @param newValue is new value for the skinCoord field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSkinCoord(X3DCoordinateNode newValue); // acceptable node types: X3DCoordinateNode

	/**
	 * Provide X3DNormalNode instance (using a properly typed node) from inputOutput SFNode field <i>skinNormal</i>.
	 * @return value of skinNormal field
	 */
	public X3DNormalNode getSkinNormal(); // acceptable node types: X3DNormalNode

	/**
	 * Assign X3DNormalNode instance (using a properly typed node) to inputOutput SFNode field <i>skinNormal</i>.
	 * @param newValue is new value for the skinNormal field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setSkinNormal(X3DNormalNode newValue); // acceptable node types: X3DNormalNode

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>translation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position of children relative to local coordinate system.
	 * @return value of translation field
	 */
	public float[] getTranslation();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>translation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position of children relative to local coordinate system.
	 * @param newValue is new value for the translation field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setTranslation(float[] newValue);

	/**
	 * Provide String enumeration value ['2.0'|'2.2'|'etc.'] from inputOutput SFString field named <i>version</i>.
	 * <br><br>
	 * <i>Tooltip:</i> HAnimHumanoid version, where standardized ISO 19774 value is 2.0. Warning: prior versions of HAnim nodes might not validate correctly.
	 * @return value of version field
	 */
	public String getVersion();

	/**
	 * Assign String enumeration value ("2.0"|"2.2") ['2.0'|'2.2'|'etc.'] to inputOutput SFString field named <i>version</i>.
	 * <br><br>
	 * <i>Tooltip:</i> HAnimHumanoid version, where standardized ISO 19774 value is 2.0. Warning: prior versions of HAnim nodes might not validate correctly.
	 * @param newValue is new value for the version field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setVersion(String newValue);

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>viewpoints</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @return value of viewpoints field
	 */
	public X3DNode[] getViewpoints(); // acceptable node types: HAnimSite

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>viewpoints</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @param newValue is new value for the viewpoints field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public HAnimHumanoid setViewpoints(X3DNode[] newValue); // acceptable node types: HAnimSite

	/**
	 * Add array of child viewpoints nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to HAnimSite.
	 * @param newValue is new value array to be appended the viewpoints field.
	 */
	public void addViewpoints(X3DNode[] newValue); // acceptable node types: HAnimSite
	/**
	 * Set single child viewpoints node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the viewpoints field.
	 */
	public void setViewpoints(X3DNode newValue); // acceptable node types: HAnimSite

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setDEF(String newValue);


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
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link HAnimHumanoid} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public HAnimHumanoid setCssClass(String newValue);

}

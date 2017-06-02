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

package org.web3d.x3d.sai.Navigation;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  Viewpoint provides a specific location and direction where the user may view the scene. 
 * <ul>
 *  <li> <i>Hint:</i>  NavigationInfo, Background, TextureBackground, Fog, OrthoViewpoint and Viewpoint are bindable nodes, meaning that no more than one of each node type can be active at a given time.  </li> 
 *  <li> <i>Warning:</i>  do not include Viewpoint or OrthoViewpoint as a child of LOD or Switch, instead use ViewpointGroup as parent to constrain location proximity where the viewpoint is available to user.  </li> 
 *  <li> <i>Hint:</i>   X3D Scene Authoring Hints, Viewpoints http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Viewpoints  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#Viewpoint" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/navigation.html#Viewpoint" target="blank">X3D Abstract Specification: Viewpoint</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Viewpoint" target="_blank">X3D Tooltips: Viewpoint</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Viewpoints" target="_blank">X3D Scene Authoring Hints: Viewpoints</a>
 */
public interface Viewpoint extends X3DViewpointNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide double value in seconds from outputOnly SFTime field named <i>bindTime</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Event sent when node becomes active/inactive.
	 * @return value of bindTime field
	 */
	@Override
	public double getBindTime();
	/**
	 * Provide array of 3-tuple float results unit axis, angle (in radians) from inputOutput SFVec3f field named <i>centerOfRotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> centerOfRotation specifies center point about which to rotate user's eyepoint when in EXAMINE or LOOKAT mode.
	 * @return value of centerOfRotation field
	 */
	public float[] getCenterOfRotation();

	/**
	 * Assign 3-tuple float array unit axis, angle (in radians) to inputOutput SFVec3f field named <i>centerOfRotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> centerOfRotation specifies center point about which to rotate user's eyepoint when in EXAMINE or LOOKAT mode.
	 * @param newValue is new value for the centerOfRotation field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Viewpoint setCenterOfRotation(float[] newValue);

	/**
	 * Provide String value from inputOutput SFString field named <i>description</i>.
	 * <br><br>
	 * <i>Tooltip:</i> &#38;
	 * @return value of description field
	 */
	@Override
	public String getDescription();

	/**
	 * Assign String value to inputOutput SFString field named <i>description</i>.
	 * <br><br>
	 * <i>Tooltip:</i> &#38;
	 * @param newValue is new value for the description field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setDescription(String newValue);

	/**
	 * Provide float value within allowed range of (0,3.1416) from inputOutput SFFloat field named <i>fieldOfView</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Preferred minimum viewing angle from this viewpoint in radians. Small field of view roughly corresponds to a telephoto lens, large field of view roughly corresponds to a wide-angle lens. Hint: modifying Viewpoint distance to object may be better for zooming. Warning: fieldOfView may not be correct for different window sizes and aspect ratios. Interchange profile hint: this field may be ignored, applying the default value regardless.
	 * @return value of fieldOfView field
	 */
	public float getFieldOfView();

	/**
	 * Assign float value within allowed range of (0,3.1416) to inputOutput SFFloat field named <i>fieldOfView</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Preferred minimum viewing angle from this viewpoint in radians. Small field of view roughly corresponds to a telephoto lens, large field of view roughly corresponds to a wide-angle lens. Hint: modifying Viewpoint distance to object may be better for zooming. Warning: fieldOfView may not be correct for different window sizes and aspect ratios. Interchange profile hint: this field may be ignored, applying the default value regardless.
	 * @param newValue is new value for the fieldOfView field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Viewpoint setFieldOfView(float newValue);

	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isBound</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Event true sent when node becomes active, event false sent when unbound by another node.
	 * @return value of isBound field
	 */
	@Override
	public boolean getIsBound();
	/**
	 * Provide boolean value from inputOutput SFBool field named <i>jump</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Transition instantly by jumping, or smoothly adjust offsets in place when changing to this Viewpoint. Hint: set jump=true for smooth camera motion when going to this viewpoint.
	 * @return value of jump field
	 */
	@Override
	public boolean getJump();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>jump</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Transition instantly by jumping, or smoothly adjust offsets in place when changing to this Viewpoint. Hint: set jump=true for smooth camera motion when going to this viewpoint.
	 * @param newValue is new value for the jump field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setJump(boolean newValue);

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
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of 4-tuple float results unit axis, angle (in radians) from inputOutput SFRotation field named <i>orientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Rotation (axis, angle in radians) of Viewpoint, relative to default -Z axis direction in local coordinate system. Hint: this is orientation _change_ from default direction (0 0 -1). Hint: complex rotations can be accomplished axis-by-axis using parent Transforms.
	 * @return value of orientation field
	 */
	@Override
	public float[] getOrientation();

	/**
	 * Assign 4-tuple float array unit axis, angle (in radians) to inputOutput SFRotation field named <i>orientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Rotation (axis, angle in radians) of Viewpoint, relative to default -Z axis direction in local coordinate system. Hint: this is orientation _change_ from default direction (0 0 -1). Hint: complex rotations can be accomplished axis-by-axis using parent Transforms.
	 * @param newValue is new value for the orientation field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setOrientation(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>position</i>.
	 * <br><br>
	 * <i>Tooltip:</i> position (x, y, z in meters) relative to local coordinate system.
	 * @return value of position field
	 */
	public float[] getPosition();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>position</i>.
	 * <br><br>
	 * <i>Tooltip:</i> position (x, y, z in meters) relative to local coordinate system.
	 * @param newValue is new value for the position field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Viewpoint setPosition(float[] newValue);

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>retainUserOffsets</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Retain (true) or reset to zero (false) any prior user navigation offsets from defined viewpoint position, orientation.
	 * @return value of retainUserOffsets field
	 */
	@Override
	public boolean getRetainUserOffsets();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>retainUserOffsets</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Retain (true) or reset to zero (false) any prior user navigation offsets from defined viewpoint position, orientation.
	 * @param newValue is new value for the retainUserOffsets field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setRetainUserOffsets(boolean newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setDEF(String newValue);


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
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link Viewpoint} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Viewpoint setCssClass(String newValue);

}

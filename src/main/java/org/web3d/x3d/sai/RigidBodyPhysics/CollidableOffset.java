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

package org.web3d.x3d.sai.RigidBodyPhysics;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>: (X3D version 3.2 or later) CollidableOffset repositions geometry relative to center of owning body.
Contains a single CollidableShape or CollidableOffset node (containerField='collidable'). * <br>

 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#CollidableOffset" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/rigid_physics.html#CollidableOffset" target="blank">X3D Abstract Specification: CollidableOffset</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#CollidableOffset" target="_blank">X3D Tooltips: CollidableOffset</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface CollidableOffset extends X3DNBodyCollidableNode
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
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setBboxCenter(float[] newValue);

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
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setBboxSize(float[] newValue);

	/**
	 * Provide X3DNBodyCollidableNode instance (using a properly typed node) from initializeOnly SFNode field <i>collidable</i>.
	 * @return value of collidable field
	 */
	public X3DNBodyCollidableNode getCollidable(); // acceptable node types: X3DNBodyCollidableNode

	/**
	 * Assign X3DNBodyCollidableNode instance (using a properly typed node) to initializeOnly SFNode field <i>collidable</i>.
	 * @param newValue is new value for the collidable field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public CollidableOffset setCollidable(X3DNBodyCollidableNode newValue); // acceptable node types: X3DNBodyCollidableNode

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @return value of enabled field
	 */
	@Override
	public boolean getEnabled();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @param newValue is new value for the enabled field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setEnabled(boolean newValue);

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
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of 4-tuple float results unit axis, angle (in radians) from inputOutput SFRotation field named <i>rotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation (axis, angle in radians) of children relative to local coordinate system. Hint: The order of operation is first apply the center offset, then scaleOrientation and scale, then rotation, then restore the center offset, then translation.
	 * @return value of rotation field
	 */
	@Override
	public float[] getRotation();

	/**
	 * Assign 4-tuple float array unit axis, angle (in radians) to inputOutput SFRotation field named <i>rotation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation (axis, angle in radians) of children relative to local coordinate system. Hint: The order of operation is first apply the center offset, then scaleOrientation and scale, then rotation, then restore the center offset, then translation.
	 * @param newValue is new value for the rotation field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setRotation(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>translation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position (x, y, z in meters) of children relative to local coordinate system. Hint: The order of operation is first apply the center offset, then scaleOrientation and scale, then rotation, then restore the center offset, then translation.
	 * @return value of translation field
	 */
	@Override
	public float[] getTranslation();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>translation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position (x, y, z in meters) of children relative to local coordinate system. Hint: The order of operation is first apply the center offset, then scaleOrientation and scale, then rotation, then restore the center offset, then translation.
	 * @param newValue is new value for the translation field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setTranslation(float[] newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setDEF(String newValue);


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
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link CollidableOffset} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public CollidableOffset setCssClass(String newValue);

}

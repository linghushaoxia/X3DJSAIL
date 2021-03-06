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


import org.web3d.x3d.sai.Core.X3DNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  (X3D version 3.2 or later) Contact nodes are produced as output events when two collidable objects or spaces make contact. 
 * <ul>
 *  <li> <i>Hint:</i>  each Contact node contains two RigidBody (containerField='body1,body2') and two CollidableShape or CollidableOffset nodes (containerField='geometry1,geometry2').  </li> 
 *  <li> <i>Warning:</i>   Contact nodes are transient and can only occur at run time, not in saved X3D files.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#Contact" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/rigid_physics.html#Contact" target="blank">X3D Abstract Specification: Contact</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Contact" target="_blank">X3D Tooltips: Contact</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface Contact extends X3DNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide array of String enumeration results ['"BOUNCE"'|'"USER_FRICTION"'|'"FRICTION_COEFFICIENT-2"'|'"ERROR_REDUCTION"'|'"CONSTANT_FORCE"'|'"SPEED-1"'|'"SPEED-2"'|'"SLIP-1"'|'"SLIP-2"'|'"etc."'] from inputOutput MFString field named <i>appliedParameters</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Default global parameters for collision outputs of rigid body physics system. Contact node can override parent CollisionCollection node. Selectable values for array: "BOUNCE" "USER_FRICTION" "FRICTION_COEFFICIENT-2" "ERROR_REDUCTION" "CONSTANT_FORCE" "SPEED-1" "SPEED-2" "SLIP-1" "SLIP-2". Hint: BOUNCE: bounce value is used; USER_FRICTION: apply user-supplied value; FRICTION_COEFFICIENT-2: apply frictionCoefficients values; ERROR_REDUCTION: apply softnessErrorCorrection value; CONSTANT_FORCE: apply softnessConstantForceMix value; SPEED-1: apply first component of surfaceSpeed array; SPEED-2: apply second component of surfaceSpeed array; SLIP-1: apply first component of slipFactors array; SLIP-2: apply second component of slipFactors array.
	 * @return value of appliedParameters field
	 */
	public String[] getAppliedParameters();

	/**
	 * Assign String enumeration array (""BOUNCE""|""USER_FRICTION""|""FRICTION_COEFFICIENT-2""|""ERROR_REDUCTION""|""CONSTANT_FORCE""|""SPEED-1""|""SPEED-2""|""SLIP-1""|""SLIP-2"") ['"BOUNCE"'|'"USER_FRICTION"'|'"FRICTION_COEFFICIENT-2"'|'"ERROR_REDUCTION"'|'"CONSTANT_FORCE"'|'"SPEED-1"'|'"SPEED-2"'|'"SLIP-1"'|'"SLIP-2"'|'"etc."'] to inputOutput MFString field named <i>appliedParameters</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Default global parameters for collision outputs of rigid body physics system. Contact node can override parent CollisionCollection node. Selectable values for array: "BOUNCE" "USER_FRICTION" "FRICTION_COEFFICIENT-2" "ERROR_REDUCTION" "CONSTANT_FORCE" "SPEED-1" "SPEED-2" "SLIP-1" "SLIP-2". Hint: BOUNCE: bounce value is used; USER_FRICTION: apply user-supplied value; FRICTION_COEFFICIENT-2: apply frictionCoefficients values; ERROR_REDUCTION: apply softnessErrorCorrection value; CONSTANT_FORCE: apply softnessConstantForceMix value; SPEED-1: apply first component of surfaceSpeed array; SPEED-2: apply second component of surfaceSpeed array; SLIP-1: apply first component of slipFactors array; SLIP-2: apply second component of slipFactors array.
	 * @param newValue is new value for the appliedParameters field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setAppliedParameters(String[] newValue);

	/**
	 * Provide RigidBody instance (using a properly typed node) from inputOutput SFNode field <i>body1</i>.
	 * @return value of body1 field
	 */
	public RigidBody getBody1(); // acceptable node types: RigidBody

	/**
	 * Assign RigidBody instance (using a properly typed node) to inputOutput SFNode field <i>body1</i>.
	 * @param newValue is new value for the body1 field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setBody1(RigidBody newValue); // acceptable node types: RigidBody

	/**
	 * Provide RigidBody instance (using a properly typed node) from inputOutput SFNode field <i>body2</i>.
	 * @return value of body2 field
	 */
	public RigidBody getBody2(); // acceptable node types: RigidBody

	/**
	 * Assign RigidBody instance (using a properly typed node) to inputOutput SFNode field <i>body2</i>.
	 * @param newValue is new value for the body2 field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setBody2(RigidBody newValue); // acceptable node types: RigidBody

	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>bounce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] bounce indicates bounciness (0 = no bounce at all, 1 = maximum bounce).
	 * @return value of bounce field
	 */
	public float getBounce();

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>bounce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] bounce indicates bounciness (0 = no bounce at all, 1 = maximum bounce).
	 * @param newValue is new value for the bounce field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setBounce(float newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>contactNormal</i>.
	 * <br><br>
	 * <i>Tooltip:</i> contactNormal is unit vector describing normal between two colliding bodies.
	 * @return value of contactNormal field
	 */
	public float[] getContactNormal();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>contactNormal</i>.
	 * <br><br>
	 * <i>Tooltip:</i> contactNormal is unit vector describing normal between two colliding bodies.
	 * @param newValue is new value for the contactNormal field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setContactNormal(float[] newValue);

	/**
	 * Provide float value from inputOutput SFFloat field named <i>depth</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] depth indicates how deep the current intersection is along normal vector.
	 * @return value of depth field
	 */
	public float getDepth();

	/**
	 * Assign float value to inputOutput SFFloat field named <i>depth</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] depth indicates how deep the current intersection is along normal vector.
	 * @param newValue is new value for the depth field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setDepth(float newValue);

	/**
	 * Provide array of 2-tuple float results within allowed range of [0,infinity) from inputOutput SFVec2f field named <i>frictionCoefficients</i>.
	 * <br><br>
	 * <i>Tooltip:</i> frictionCoefficients used for computing surface drag.
	 * @return value of frictionCoefficients field
	 */
	public float[] getFrictionCoefficients();

	/**
	 * Assign 2-tuple float array within allowed range of [0,infinity) to inputOutput SFVec2f field named <i>frictionCoefficients</i>.
	 * <br><br>
	 * <i>Tooltip:</i> frictionCoefficients used for computing surface drag.
	 * @param newValue is new value for the frictionCoefficients field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setFrictionCoefficients(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>frictionDirection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> frictionDirection controls friction vector. Hint: value of (0 0 0) indicates no friction.
	 * @return value of frictionDirection field
	 */
	public float[] getFrictionDirection();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>frictionDirection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> frictionDirection controls friction vector. Hint: value of (0 0 0) indicates no friction.
	 * @param newValue is new value for the frictionDirection field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setFrictionDirection(float[] newValue);

	/**
	 * Provide X3DNBodyCollidableNode instance (using a properly typed node) from inputOutput SFNode field <i>geometry1</i>.
	 * @return value of geometry1 field
	 */
	public X3DNBodyCollidableNode getGeometry1(); // acceptable node types: X3DNBodyCollidableNode

	/**
	 * Assign X3DNBodyCollidableNode instance (using a properly typed node) to inputOutput SFNode field <i>geometry1</i>.
	 * @param newValue is new value for the geometry1 field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setGeometry1(X3DNBodyCollidableNode newValue); // acceptable node types: X3DNBodyCollidableNode

	/**
	 * Provide X3DNBodyCollidableNode instance (using a properly typed node) from inputOutput SFNode field <i>geometry2</i>.
	 * @return value of geometry2 field
	 */
	public X3DNBodyCollidableNode getGeometry2(); // acceptable node types: X3DNBodyCollidableNode

	/**
	 * Assign X3DNBodyCollidableNode instance (using a properly typed node) to inputOutput SFNode field <i>geometry2</i>.
	 * @param newValue is new value for the geometry2 field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setGeometry2(X3DNBodyCollidableNode newValue); // acceptable node types: X3DNBodyCollidableNode

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
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Contact setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide float value within allowed range of [0,infinity) from inputOutput SFFloat field named <i>minBounceSpeed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) minBounceSpeed m/s needed to bounce.
	 * @return value of minBounceSpeed field
	 */
	public float getMinBounceSpeed();

	/**
	 * Assign float value within allowed range of [0,infinity) to inputOutput SFFloat field named <i>minBounceSpeed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) minBounceSpeed m/s needed to bounce.
	 * @param newValue is new value for the minBounceSpeed field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setMinBounceSpeed(float newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>position</i>.
	 * <br><br>
	 * <i>Tooltip:</i> position (x, y, z in meters) of exact location of collision.
	 * @return value of position field
	 */
	public float[] getPosition();

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>position</i>.
	 * <br><br>
	 * <i>Tooltip:</i> position (x, y, z in meters) of exact location of collision.
	 * @param newValue is new value for the position field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setPosition(float[] newValue);

	/**
	 * Provide array of 2-tuple float results from inputOutput SFVec2f field named <i>slipCoefficients</i>.
	 * <br><br>
	 * <i>Tooltip:</i> slipCoefficients used for computing surface drag.
	 * @return value of slipCoefficients field
	 */
	public float[] getSlipCoefficients();

	/**
	 * Assign 2-tuple float array to inputOutput SFVec2f field named <i>slipCoefficients</i>.
	 * <br><br>
	 * <i>Tooltip:</i> slipCoefficients used for computing surface drag.
	 * @param newValue is new value for the slipCoefficients field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setSlipCoefficients(float[] newValue);

	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>softnessConstantForceMix</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] softnessConstantForceMix value applies a constant force value to make colliding surfaces appear to be somewhat soft.
	 * @return value of softnessConstantForceMix field
	 */
	public float getSoftnessConstantForceMix();

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>softnessConstantForceMix</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] softnessConstantForceMix value applies a constant force value to make colliding surfaces appear to be somewhat soft.
	 * @param newValue is new value for the softnessConstantForceMix field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setSoftnessConstantForceMix(float newValue);

	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>softnessErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] softnessErrorCorrection indicates fraction of collision error fixed in a set of evaluations (0 = no error correction, 1 = all errors corrected in single step).
	 * @return value of softnessErrorCorrection field
	 */
	public float getSoftnessErrorCorrection();

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>softnessErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] softnessErrorCorrection indicates fraction of collision error fixed in a set of evaluations (0 = no error correction, 1 = all errors corrected in single step).
	 * @param newValue is new value for the softnessErrorCorrection field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setSoftnessErrorCorrection(float newValue);

	/**
	 * Provide array of 2-tuple float results from inputOutput SFVec2f field named <i>surfaceSpeed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> surfaceSpeed defines speed vectors for computing surface drag, if contact surfaces move independently of bodies.
	 * @return value of surfaceSpeed field
	 */
	public float[] getSurfaceSpeed();

	/**
	 * Assign 2-tuple float array to inputOutput SFVec2f field named <i>surfaceSpeed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> surfaceSpeed defines speed vectors for computing surface drag, if contact surfaces move independently of bodies.
	 * @param newValue is new value for the surfaceSpeed field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Contact setSurfaceSpeed(float[] newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Contact setDEF(String newValue);


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
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Contact setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link Contact} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Contact setCssClass(String newValue);

}

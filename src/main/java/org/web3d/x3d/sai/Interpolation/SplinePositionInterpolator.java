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

package org.web3d.x3d.sai.Interpolation;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  (X3D version 3.2 or later) SplinePositionInterpolator performs non-linear interpolation among paired lists of 3-tuple values and velocities to produce an SFVec3f value_changed output event. 
 * <ul>
 *  <li> <i>Hint:</i>  typical input connection is ROUTE someTimeSensorDEF.fraction_changed TO thisInterpolatorDEF.set_fraction  </li> 
 *  <li> <i>Hint:</i>  typical output connection is ROUTE thisInterpolatorDEF.value_changed TO someDestinationNodeDEF.set_someAttribute.  </li> 
 *  <li> <i>Hint:</i>   include &lt;component name='Interpolation' level='4'/&gt;  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#SplinePositionInterpolator" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/interp.html#SplinePositionInterpolator" target="blank">X3D Abstract Specification: SplinePositionInterpolator</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#SplinePositionInterpolator" target="_blank">X3D Tooltips: SplinePositionInterpolator</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface SplinePositionInterpolator extends X3DInterpolatorNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>closed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether or not the curve is closed (i.e. matching end values), with continuous velocity vectors as the interpolator transitions from the last key to the first key. Warning: if velocity vectors at first and last keys are specified, the closed field is ignored. Warning: if keyValues at first and last key are not identical, the closed field is ignored.
	 * @return value of closed field
	 */
	public boolean getClosed();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>closed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether or not the curve is closed (i.e. matching end values), with continuous velocity vectors as the interpolator transitions from the last key to the first key. Warning: if velocity vectors at first and last keys are specified, the closed field is ignored. Warning: if keyValues at first and last key are not identical, the closed field is ignored.
	 * @param newValue is new value for the closed field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SplinePositionInterpolator setClosed(boolean newValue);

	/**
	 * Provide array of float results from inputOutput MFFloat field named <i>key</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Definition parameters for nonlinear-interpolation function time intervals, in increasing order and corresponding to keyValue, keyVelocity array values. Warning: number of keys must match number of keyValues!.
	 * @return value of key field
	 */
	@Override
	public float[] getKey();

	/**
	 * Assign float array to inputOutput MFFloat field named <i>key</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Definition parameters for nonlinear-interpolation function time intervals, in increasing order and corresponding to keyValue, keyVelocity array values. Warning: number of keys must match number of keyValues!.
	 * @param newValue is new value for the key field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SplinePositionInterpolator setKey(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput MFVec3f field named <i>keyValue</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for nonlinear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyValues!.
	 * @return value of keyValue field
	 */
	public float[] getKeyValue();

	/**
	 * Assign 3-tuple float array to inputOutput MFVec3f field named <i>keyValue</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for nonlinear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyValues!.
	 * @param newValue is new value for the keyValue field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SplinePositionInterpolator setKeyValue(float[] newValue);

	/**
	 * Provide array of 3-tuple float results from inputOutput MFVec3f field named <i>keyVelocity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for nonlinear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyVelocity values!.
	 * @return value of keyVelocity field
	 */
	public float[] getKeyVelocity();

	/**
	 * Assign 3-tuple float array to inputOutput MFVec3f field named <i>keyVelocity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for nonlinear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyVelocity values!.
	 * @param newValue is new value for the keyVelocity field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SplinePositionInterpolator setKeyVelocity(float[] newValue);

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
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SplinePositionInterpolator setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>normalizeVelocity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> normalizeVelocity field specifies whether the velocity vectors are normalized to produce smooth speed transitions, or transformed into tangency vectors. Hint: X3D 19.2.3 Non-linear interpolation http://www.web3d.org/files/specifications/19775-1/V3.3/Part01/components/interp.html#NonlinearInterpolation.
	 * @return value of normalizeVelocity field
	 */
	public boolean getNormalizeVelocity();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>normalizeVelocity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> normalizeVelocity field specifies whether the velocity vectors are normalized to produce smooth speed transitions, or transformed into tangency vectors. Hint: X3D 19.2.3 Non-linear interpolation http://www.web3d.org/files/specifications/19775-1/V3.3/Part01/components/interp.html#NonlinearInterpolation.
	 * @param newValue is new value for the normalizeVelocity field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SplinePositionInterpolator setNormalizeVelocity(boolean newValue);

	/**
	 * Provide array of 3-tuple float results from outputOnly SFVec3f field named <i>value_changed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Nonlinearly interpolated output value computed by using current time fraction along with corresponding key, keyValue and keyVelocity values.
	 * @return value of value_changed field
	 */
	public float[] getValue();

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SplinePositionInterpolator setDEF(String newValue);


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
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SplinePositionInterpolator setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link SplinePositionInterpolator} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SplinePositionInterpolator setCssClass(String newValue);

}
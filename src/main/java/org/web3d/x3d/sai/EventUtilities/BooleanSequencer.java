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

package org.web3d.x3d.sai.EventUtilities;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  BooleanSequencer generates periodic discrete Boolean values that can be ROUTEd to other Boolean attributes. 
 * <ul>
 *  <li> <i>Hint:</i>  typical input connection is ROUTE someTimeSensorDEF.fraction_changed TO thisInterpolatorDEF.set_fraction  </li> 
 *  <li> <i>Hint:</i>  typical output connection is ROUTE thisInterpolatorDEF.value_changed TO someDestinationNodeDEF.set_someAttribute.  </li> 
 *  <li> <i>Hint:</i>  example scenes and authoring assets at http://x3dgraphics.com/examples/X3dForWebAuthors/Chapter09-EventUtilitiesScripting  </li> 
 *  <li> <i>Hint:</i>   X3D Event-Utility Nodes, Field Event Diagrams http://x3dgraphics.com/examples/X3dForWebAuthors/Chapter09-EventUtilitiesScripting/X3dEventUtilityNodeEventDiagrams.pdf  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#BooleanSequencer" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/utils.html#BooleanSequencer" target="blank">X3D Abstract Specification: BooleanSequencer</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#BooleanSequencer" target="_blank">X3D Tooltips: BooleanSequencer</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface BooleanSequencer extends X3DSequencerNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide array of float results from inputOutput MFFloat field named <i>key</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Definition parameters for linear-interpolation function time intervals, in increasing order and corresponding to keyValues. Warning: number of keys must match number of keyValues!.
	 * @return value of key field
	 */
	@Override
	public float[] getKey();

	/**
	 * Assign float array to inputOutput MFFloat field named <i>key</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Definition parameters for linear-interpolation function time intervals, in increasing order and corresponding to keyValues. Warning: number of keys must match number of keyValues!.
	 * @param newValue is new value for the key field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setKey(float[] newValue);

	/**
	 * Provide array of boolean results from inputOutput MFBool field named <i>keyValue</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for linear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyValues!.
	 * @return value of keyValue field
	 */
	public boolean[] getKeyValue();

	/**
	 * Assign boolean array to inputOutput MFBool field named <i>keyValue</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Output values for linear interpolation, each corresponding to time-fraction keys. Warning: number of keys must match number of keyValues!.
	 * @param newValue is new value for the keyValue field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public BooleanSequencer setKeyValue(boolean[] newValue);

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
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject


	/**
	 * Assign boolean value to inputOnly SFBool field named <i>next</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Send next output value in keyValue array, and reset internal fraction field to match corresponding value in key array. Hint: "wrap around" boundary of keyValue array, i.e. continue from last to first if necessary.
	 * @param newValue is new value for the next field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setNext(boolean newValue);


	/**
	 * Assign boolean value to inputOnly SFBool field named <i>previous</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Send previous output value in keyValue array, and reset internal fraction field to match corresponding value in key array. Hint: "wrap around" boundary of keyValue array, i.e. continue from first to last if necessary.
	 * @param newValue is new value for the previous field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setPrevious(boolean newValue);

	/**
	 * Provide boolean value from outputOnly SFBool field named <i>value_changed</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Single intermittent output value determined by current key time and corresponding keyValue pair.
	 * @return value of value_changed field
	 */
	public boolean getValue();

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setDEF(String newValue);


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
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link BooleanSequencer} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public BooleanSequencer setCssClass(String newValue);

}

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

package org.web3d.x3d.sai.Layering;


import org.web3d.x3d.sai.Core.X3DNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Layering.*;
import org.web3d.x3d.sai.Core.*;
import java.util.Arrays;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  (X3D version 3.2 or later) LayerSet defines a list of layers and a rendering order. The rendering order is specified by the order field. 
 * <ul>
 *  <li> <i>Hint:</i>  the layer first specified in the order field is the first layer rendered and appears below any other layers. The layer last specified in the order field is the last layer rendered and correspondingly appears on top of all other layers.  </li> 
 *  <li> <i>Warning:</i>  only one LayerSet node is allowed in a scene, and it shall be a root node at the top of the scene graph.  </li> 
 *  <li> <i>Hint:</i>   X3D Abstract Specification 35.2.1 Overview of layering http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/layering.html#OverviewOfLayering  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#LayerSet" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/layering.html#LayerSet" target="blank">X3D Abstract Specification: LayerSet</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#LayerSet" target="_blank">X3D Tooltips: LayerSet</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface LayerSet extends X3DNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide int value from inputOutput SFInt32 field named <i>activeLayer</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] activeLayer field specifies the layer in which navigation takes place. Hint: nodes that are not part of a layer are considered to be in layer 0.
	 * @return value of activeLayer field
	 */
	public int getActiveLayer();

	/**
	 * Assign int value to inputOutput SFInt32 field named <i>activeLayer</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] activeLayer field specifies the layer in which navigation takes place. Hint: nodes that are not part of a layer are considered to be in layer 0.
	 * @param newValue is new value for the activeLayer field.
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public LayerSet setActiveLayer(int newValue);

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>layers</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DLayerNode] The layers list defines a list of Layer nodes that contain the constituent parts of the scene. Each layer is assigned an ordinal number depending on its position in this contained list of nodes. Hint: Ordinal values start with the numeral 1 representing the first item in the list. Hint: nodes that are not part of a layer are considered to be in layer 0.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DLayerNode.
	 * @return value of layers field
	 */
	public X3DNode[] getLayers(); // acceptable node types: X3DLayerNode

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>layers</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DLayerNode] The layers list defines a list of Layer nodes that contain the constituent parts of the scene. Each layer is assigned an ordinal number depending on its position in this contained list of nodes. Hint: Ordinal values start with the numeral 1 representing the first item in the list. Hint: nodes that are not part of a layer are considered to be in layer 0.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DLayerNode.
	 * @param newValue is new value for the layers field.
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public LayerSet setLayers(X3DNode[] newValue); // acceptable node types: X3DLayerNode

	/**
	 * Add array of child layers nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DLayerNode.
	 * @param newValue is new value array to be appended the layers field.
	 */
	public void addLayers(X3DNode[] newValue); // acceptable node types: X3DLayerNode
	/**
	 * Set single child layers node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the layers field.
	 */
	public void setLayers(X3DNode newValue); // acceptable node types: X3DLayerNode
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
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public LayerSet setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of int results from initializeOnly MFInt32 field named <i>order</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] The order list defines the order in which layers are rendered. Each value corresponds to the ordinals of the layers. Hint: the order list may contain repetitions of ordinal values, in which case the layer is rendered again. Warning: if order contains number values that are not ordinals assigned to layers, such numbers are ignored. Warning: layers that are not included in the order list are not rendered.
	 * @return value of order field
	 */
	public int[] getOrder();

	/**
	 * Assign int array to initializeOnly MFInt32 field named <i>order</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] The order list defines the order in which layers are rendered. Each value corresponds to the ordinals of the layers. Hint: the order list may contain repetitions of ordinal values, in which case the layer is rendered again. Warning: if order contains number values that are not ordinals assigned to layers, such numbers are ignored. Warning: layers that are not included in the order list are not rendered.
	 * @param newValue is new value for the order field.
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public LayerSet setOrder(int[] newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public LayerSet setDEF(String newValue);


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
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public LayerSet setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link LayerSet} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public LayerSet setCssClass(String newValue);

}

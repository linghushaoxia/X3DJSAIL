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

package org.web3d.x3d.sai.Shape;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.Shaders.*;
import org.web3d.x3d.sai.Texturing.*;
import org.web3d.x3d.sai.Texturing.*;
import java.util.Arrays;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  Appearance specifies the visual properties of geometry by containing the Material, ImageTexture/MovieTexture/PixelTexture, FillProperties, LineProperties, and TextureTransform nodes. 
 * <ul>
 *  <li> <i>Hint:</i>  insert a Shape node before adding geometry or Appearance. Interchange profile hint: only Material and ImageTexture children are allowed.  </li> 
 *  <li> <i>Hint:</i>  DEF/USE copies of a single node can provide a similar "look + feel" style for related shapes in a scene.  </li> 
 *  <li> <i>Hint:</i>   Advanced uses can contain MultiTexture, MultiTextureTransform/TextureTransformMatrix3D/TextureTransform3D, ComposedShader/PackagedShader/ProgramShader, ComposedTexture3D/ImageTexture3D/PixelTexture3D, or ComposedCubeMapTexture/GeneratedCubeMapTexture/ImageCubeMapTexture.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#Appearance" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/shape.html#Appearance" target="blank">X3D Abstract Specification: Appearance</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Appearance" target="_blank">X3D Tooltips: Appearance</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface Appearance extends X3DAppearanceNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide FillProperties instance (using a properly typed node) from inputOutput SFNode field <i>fillProperties</i>.
	 * @return value of fillProperties field
	 */
	public FillProperties getFillProperties(); // acceptable node types: FillProperties

	/**
	 * Assign FillProperties instance (using a properly typed node) to inputOutput SFNode field <i>fillProperties</i>.
	 * @param newValue is new value for the fillProperties field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setFillProperties(FillProperties newValue); // acceptable node types: FillProperties

	/**
	 * Provide LineProperties instance (using a properly typed node) from inputOutput SFNode field <i>lineProperties</i>.
	 * @return value of lineProperties field
	 */
	public LineProperties getLineProperties(); // acceptable node types: LineProperties

	/**
	 * Assign LineProperties instance (using a properly typed node) to inputOutput SFNode field <i>lineProperties</i>.
	 * @param newValue is new value for the lineProperties field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setLineProperties(LineProperties newValue); // acceptable node types: LineProperties

	/**
	 * Provide X3DMaterialNode instance (using a properly typed node) from inputOutput SFNode field <i>material</i>.
	 * @return value of material field
	 */
	public X3DMaterialNode getMaterial(); // acceptable node types: X3DMaterialNode

	/**
	 * Assign X3DMaterialNode instance (using a properly typed node) to inputOutput SFNode field <i>material</i>.
	 * @param newValue is new value for the material field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setMaterial(X3DMaterialNode newValue); // acceptable node types: X3DMaterialNode

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
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Appearance setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>shaders</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DShaderNode.
	 * @return value of shaders field
	 */
	public X3DNode[] getShaders(); // acceptable node types: X3DShaderNode

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>shaders</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DShaderNode.
	 * @param newValue is new value for the shaders field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setShaders(X3DNode[] newValue); // acceptable node types: X3DShaderNode

	/**
	 * Add array of child shaders nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DShaderNode.
	 * @param newValue is new value array to be appended the shaders field.
	 */
	public void addShaders(X3DNode[] newValue); // acceptable node types: X3DShaderNode
	/**
	 * Set single child shaders node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the shaders field.
	 */
	public void setShaders(X3DNode newValue); // acceptable node types: X3DShaderNode
	/**
	 * Provide X3DTextureNode instance (using a properly typed node) from inputOutput SFNode field <i>texture</i>.
	 * @return value of texture field
	 */
	public X3DTextureNode getTexture(); // acceptable node types: X3DTextureNode

	/**
	 * Assign X3DTextureNode instance (using a properly typed node) to inputOutput SFNode field <i>texture</i>.
	 * @param newValue is new value for the texture field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setTexture(X3DTextureNode newValue); // acceptable node types: X3DTextureNode

	/**
	 * Provide X3DTextureTransformNode instance (using a properly typed node) from inputOutput SFNode field <i>textureTransform</i>.
	 * @return value of textureTransform field
	 */
	public X3DTextureTransformNode getTextureTransform(); // acceptable node types: X3DTextureTransformNode

	/**
	 * Assign X3DTextureTransformNode instance (using a properly typed node) to inputOutput SFNode field <i>textureTransform</i>.
	 * @param newValue is new value for the textureTransform field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Appearance setTextureTransform(X3DTextureTransformNode newValue); // acceptable node types: X3DTextureTransformNode


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Appearance setDEF(String newValue);


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
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Appearance setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link Appearance} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Appearance setCssClass(String newValue);

}

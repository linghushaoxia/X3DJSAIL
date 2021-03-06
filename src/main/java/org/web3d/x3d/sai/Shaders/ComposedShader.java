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

package org.web3d.x3d.sai.Shaders;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.Shaders.*;
import java.util.Arrays;

/**
 * ComposedShader can contain field declarations, but no CDATA section of plain-text source code, since programs are composed from child ShaderPart nodes.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  ComposedShader defines a shader where the individual source files are assembled from contained ShaderPart program sections. All access to shading capabilities is defined through a single interface that applies to all parts. 
 * <ul>
 *  <li> <i>Hint:</i>  ComposedShader contains field definitions, IS/connect, and &lt;ShaderPart containerField='parts'/&gt; nodes.  </li> 
 *  <li> <i>Warning:</i>   ComposedShader can contain field declarations, but no CDATA section of plain-text source code. All source programs are contained in child ShaderPart nodes.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#ComposedShader" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/shaders.html#ComposedShader" target="blank">X3D Abstract Specification: ComposedShader</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#ComposedShader" target="_blank">X3D Tooltips: ComposedShader</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface ComposedShader extends X3DShaderNode, X3DProgrammableShaderObject
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness


	/**
	 * Assign boolean value to inputOnly SFBool field named <i>activate</i>.
	 * <br><br>
	 * <i>Tooltip:</i> activate forces the shader to activate the contained objects.
	 * @param newValue is new value for the activate field.
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setActivate(boolean newValue);

	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isSelected</i>.
	 * <br><br>
	 * <i>Tooltip:</i> isSelected indicates this shader instance is selected for use by browser.
	 * @return value of isSelected field
	 */
	@Override
	public boolean getIsSelected();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isValid</i>.
	 * <br><br>
	 * <i>Tooltip:</i> isValid indicates whether current shader objects can be run as a shader program.
	 * @return value of isValid field
	 */
	@Override
	public boolean getIsValid();
	/**
	 * Provide String enumeration value ['Cg'|'GLSL'|'HLSL'|'etc.'] from initializeOnly SFString field named <i>language</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The language field indicates to the X3D player which shading language is used. The language field may be used to optionally determine the language type if no MIME-type information is available. Hint: recognized values include "CG" "GLSL" "HLSL" "FX" Hint: relates to Internationalization (i18n) http://www.w3.org/standards/webdesign/i18n.
	 * @return value of language field
	 */
	@Override
	public String getLanguage();

	/**
	 * Assign String enumeration value ("Cg"|"GLSL"|"HLSL") ['Cg'|'GLSL'|'HLSL'|'etc.'] to initializeOnly SFString field named <i>language</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The language field indicates to the X3D player which shading language is used. The language field may be used to optionally determine the language type if no MIME-type information is available. Hint: recognized values include "CG" "GLSL" "HLSL" "FX" Hint: relates to Internationalization (i18n) http://www.w3.org/standards/webdesign/i18n.
	 * @param newValue is new value for the language field.
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setLanguage(String newValue);

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
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from inputOutput MFNode field <i>parts</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to ShaderPart.
	 * @return value of parts field
	 */
	public X3DNode[] getParts(); // acceptable node types: ShaderPart

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to inputOutput MFNode field <i>parts</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to ShaderPart.
	 * @param newValue is new value for the parts field.
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ComposedShader setParts(X3DNode[] newValue); // acceptable node types: ShaderPart

	/**
	 * Add array of child parts nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to ShaderPart.
	 * @param newValue is new value array to be appended the parts field.
	 */
	public void addParts(X3DNode[] newValue); // acceptable node types: ShaderPart
	/**
	 * Set single child parts node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the parts field.
	 */
	public void setParts(X3DNode newValue); // acceptable node types: ShaderPart

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setDEF(String newValue);


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
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link ComposedShader} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ComposedShader setCssClass(String newValue);

}

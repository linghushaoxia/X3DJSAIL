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

package org.web3d.x3d.sai.Geometry2D;


import org.web3d.x3d.sai.Rendering.X3DGeometryNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  TriangleSet2D is a geometry node that defines a set of filled 2D triangles in X-Y plane. 
 * <ul>
 *  <li> <i> Hint:</i>   insert a Shape node before adding geometry or Appearance.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#TriangleSet2D" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geometry2D.html#TriangleSet2D" target="blank">X3D Abstract Specification: TriangleSet2D</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#TriangleSet2D" target="_blank">X3D Tooltips: TriangleSet2D</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Meshes" target="_blank">X3D Scene Authoring Hints: Meshes</a>
 */
public interface TriangleSet2D extends X3DGeometryNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

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
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public TriangleSet2D setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>solid</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Setting solid true means draw only one side of polygons (backface culling on), setting solid false means draw both sides of polygons (backface culling off). Warning: default value true can completely hide geometry if viewed from wrong side! Hint: if in doubt, use solid='false' for maximum visibility. Warning: solid false not supported in VRML97.
	 * @return value of solid field
	 */
	public boolean getSolid();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>solid</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Setting solid true means draw only one side of polygons (backface culling on), setting solid false means draw both sides of polygons (backface culling off). Warning: default value true can completely hide geometry if viewed from wrong side! Hint: if in doubt, use solid='false' for maximum visibility. Warning: solid false not supported in VRML97.
	 * @param newValue is new value for the solid field.
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public TriangleSet2D setSolid(boolean newValue);

	/**
	 * Provide array of 2-tuple float results from inputOutput MFVec2f field named <i>vertices</i>.
	 * <br><br>
	 * <i>Tooltip:</i> 2D coordinates of TriangleSet2D vertices. Warning: simple-geometry dimensions are initializeOnly and cannot be changed after initial creation, for animation use Transform scale instead.
	 * @return value of vertices field
	 */
	public float[] getVertices();

	/**
	 * Assign 2-tuple float array to inputOutput MFVec2f field named <i>vertices</i>.
	 * <br><br>
	 * <i>Tooltip:</i> 2D coordinates of TriangleSet2D vertices. Warning: simple-geometry dimensions are initializeOnly and cannot be changed after initial creation, for animation use Transform scale instead.
	 * @param newValue is new value for the vertices field.
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public TriangleSet2D setVertices(float[] newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public TriangleSet2D setDEF(String newValue);


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
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public TriangleSet2D setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link TriangleSet2D} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public TriangleSet2D setCssClass(String newValue);

}

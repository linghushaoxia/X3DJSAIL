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

package org.web3d.x3d.sai.Geometry3D;


import org.web3d.x3d.sai.Rendering.X3DGeometryNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  Extrusion is a geometry node stretching a 2D cross section along a 3D-spine path in the local coordinate system. Scaling/rotating cross-sections can produce a variety of shapes. 
 * <ul>
 *  <li> <i> Hint:</i>   insert a Shape node before adding geometry or Appearance.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#Extrusion" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/geometry3D.html#Extrusion" target="blank">X3D Abstract Specification: Extrusion</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Extrusion" target="_blank">X3D Tooltips: Extrusion</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface Extrusion extends X3DGeometryNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>beginCap</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether beginning cap is drawn (similar to Cylinder top cap). Warning: cannot be changed after initial creation.
	 * @return value of beginCap field
	 */
	public boolean getBeginCap();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>beginCap</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether beginning cap is drawn (similar to Cylinder top cap). Warning: cannot be changed after initial creation.
	 * @param newValue is new value for the beginCap field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setBeginCap(boolean newValue);

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>ccw</i>.
	 * <br><br>
	 * <i>Tooltip:</i> ccw = counterclockwise: ordering of vertex-coordinates orientation. Hint: ccw false can reverse solid (backface culling) and normal-vector orientation.
	 * @return value of ccw field
	 */
	public boolean getCcw();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>ccw</i>.
	 * <br><br>
	 * <i>Tooltip:</i> ccw = counterclockwise: ordering of vertex-coordinates orientation. Hint: ccw false can reverse solid (backface culling) and normal-vector orientation.
	 * @param newValue is new value for the ccw field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setCcw(boolean newValue);

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>convex</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether all polygons in a shape are convex (true), or possibly concave (false). A convex polygon is planar, does not intersect itself, and has all interior angles &lt; 180 degrees. Warning: concave geometry may be invisible default convex=true.
	 * @return value of convex field
	 */
	public boolean getConvex();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>convex</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether all polygons in a shape are convex (true), or possibly concave (false). A convex polygon is planar, does not intersect itself, and has all interior angles &lt; 180 degrees. Warning: concave geometry may be invisible default convex=true.
	 * @param newValue is new value for the convex field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setConvex(boolean newValue);

	/**
	 * Provide float value unit axis, angle (in radians) within allowed range of [0,infinity) from initializeOnly SFFloat field named <i>creaseAngle</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) creaseAngle defines angle (in radians) where adjacent polygons are drawn with sharp edges or smooth shading. If angle between normals of two adjacent polygons is less than creaseAngle, smooth shading is rendered across the shared line segment. Hint: creaseAngle=0 means render all edges sharply, creaseAngle=3.14159 means render all edges smoothly.
	 * @return value of creaseAngle field
	 */
	public float getCreaseAngle();

	/**
	 * Assign float value unit axis, angle (in radians) within allowed range of [0,infinity) to initializeOnly SFFloat field named <i>creaseAngle</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) creaseAngle defines angle (in radians) where adjacent polygons are drawn with sharp edges or smooth shading. If angle between normals of two adjacent polygons is less than creaseAngle, smooth shading is rendered across the shared line segment. Hint: creaseAngle=0 means render all edges sharply, creaseAngle=3.14159 means render all edges smoothly.
	 * @param newValue is new value for the creaseAngle field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setCreaseAngle(float newValue);

	/**
	 * Provide array of 2-tuple float results from initializeOnly MFVec2f field named <i>crossSection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> An ordered set of 2D points drawing a piecewise-linear curve and forming a planar series of connected vertices. This provides a silhouette of the outer surface. Warning: match clockwise/counterclockwise or impossible/inverted geometry can result!.
	 * @return value of crossSection field
	 */
	public float[] getCrossSection();

	/**
	 * Assign 2-tuple float array to initializeOnly MFVec2f field named <i>crossSection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> An ordered set of 2D points drawing a piecewise-linear curve and forming a planar series of connected vertices. This provides a silhouette of the outer surface. Warning: match clockwise/counterclockwise or impossible/inverted geometry can result!.
	 * @param newValue is new value for the crossSection field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setCrossSection(float[] newValue);

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>endCap</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether end cap is drawn (similar to Cylinder end cap). Warning: cannot be changed after initial creation.
	 * @return value of endCap field
	 */
	public boolean getEndCap();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>endCap</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether end cap is drawn (similar to Cylinder end cap). Warning: cannot be changed after initial creation.
	 * @param newValue is new value for the endCap field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setEndCap(boolean newValue);

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
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Extrusion setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide array of 4-tuple float results unit axis, angle (in radians) from inputOutput MFRotation field named <i>orientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> orientation is a list of axis-angle orientation 4-tuples applied at each spine-aligned cross-section plane. Hint: number of spine points, scale values and orientation values must be the same.
	 * @return value of orientation field
	 */
	public float[] getOrientation();

	/**
	 * Assign 4-tuple float array unit axis, angle (in radians) to inputOutput MFRotation field named <i>orientation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> orientation is a list of axis-angle orientation 4-tuples applied at each spine-aligned cross-section plane. Hint: number of spine points, scale values and orientation values must be the same.
	 * @param newValue is new value for the orientation field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setOrientation(float[] newValue);

	/**
	 * Provide array of 2-tuple float results from inputOutput MFVec2f field named <i>scale</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (0,+infinity) scale is a list of 2D-scale parameters applied at each spine-aligned cross-section plane. Hint: number of spine points, scale values and orientation values must be the same. Warning: zero or negative scale values not allowed.
	 * @return value of scale field
	 */
	public float[] getScale();

	/**
	 * Assign 2-tuple float array to inputOutput MFVec2f field named <i>scale</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (0,+infinity) scale is a list of 2D-scale parameters applied at each spine-aligned cross-section plane. Hint: number of spine points, scale values and orientation values must be the same. Warning: zero or negative scale values not allowed.
	 * @param newValue is new value for the scale field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setScale(float[] newValue);

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>solid</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Setting solid true means draw only one side of polygons (backface culling on), setting solid false means draw both sides of polygons (backface culling off). Warning: default value true can completely hide geometry if viewed from wrong side! Hint: if in doubt, use solid='false' for maximum visibility.
	 * @return value of solid field
	 */
	public boolean getSolid();

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>solid</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Setting solid true means draw only one side of polygons (backface culling on), setting solid false means draw both sides of polygons (backface culling off). Warning: default value true can completely hide geometry if viewed from wrong side! Hint: if in doubt, use solid='false' for maximum visibility.
	 * @param newValue is new value for the solid field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setSolid(boolean newValue);

	/**
	 * Provide array of 3-tuple float results from initializeOnly MFVec3f field named <i>spine</i>.
	 * <br><br>
	 * <i>Tooltip:</i> spine is a list of 3D points for a piecewise-linear curve forming a series of connected vertices, open or closed. This is the path along which the crossSection is extruded. Hint: number of spine points, scale values and orientation values must be the same.
	 * @return value of spine field
	 */
	public float[] getSpine();

	/**
	 * Assign 3-tuple float array to initializeOnly MFVec3f field named <i>spine</i>.
	 * <br><br>
	 * <i>Tooltip:</i> spine is a list of 3D points for a piecewise-linear curve forming a series of connected vertices, open or closed. This is the path along which the crossSection is extruded. Hint: number of spine points, scale values and orientation values must be the same.
	 * @param newValue is new value for the spine field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public Extrusion setSpine(float[] newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Extrusion setDEF(String newValue);


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
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Extrusion setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link Extrusion} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public Extrusion setCssClass(String newValue);

}

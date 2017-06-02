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

package org.web3d.x3d.sai.ParticleSystems;


import org.web3d.x3d.sai.Shape.X3DShapeNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Rendering.*;
import org.web3d.x3d.sai.ParticleSystems.*;
import org.web3d.x3d.sai.Rendering.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.sai.ParticleSystems.*;
import org.web3d.x3d.sai.Texturing.*;
import java.util.Arrays;

/**
 * Abstract node interface, defined by X3D specification to support X3D Java interoperability.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  (X3D version 3.2 or later) ParticleSystem specifies a complete particle system. It can contain Appearance for particle appearance, a geometry node if gemoetryType='GEOMETRY', a colorRamp Color/ColorRGBA node for changing base color over each particle's lifetime, a texcoordRamp TextureCoordinate node to control texture coordinates of provided texture(s) in the Appearance node over time, a single emitter X3DParticleEmitterNode, and an array of physics X3DParticlePhysicsModelNode nodes. 
 * <ul>
 *  <li> <i>Hint:</i>  event timing details are explained in 4.4.8.3 Execution model http://www.web3d.org/files/specifications/19775-1/V3.3/Part01/concepts.html#ExecutionModel  </li> 
 *  <li> <i>Hint:</i>   Wikipedia, particle system https://en.wikipedia.org/wiki/Particle_system  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/concretes.html#ParticleSystem" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/particle_systems.html#ParticleSystem" target="blank">X3D Abstract Specification: ParticleSystem</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#ParticleSystem" target="_blank">X3D Tooltips: ParticleSystem</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface ParticleSystem extends X3DShapeNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide X3DAppearanceNode instance (using a properly typed node) from inputOutput SFNode field <i>appearance</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DAppearanceNode] The appearance field holds an Appearance node that is used for the geometry. All effects, such as material colours and/or multi-textures, are applied to each particle. Hint: if a texture coordinate ramp and key is supplied with this geometry, it shall be used in preference to any automatic texture coordinate generation. Hint: if automatic texture coordinate generation is used, results shall be based on the entire volume that the particles consume, not locally applied to each particle.
	 * @return value of appearance field
	 */
	@Override
	public X3DAppearanceNode getAppearance(); // acceptable node types: X3DAppearanceNode

	/**
	 * Assign X3DAppearanceNode instance (using a properly typed node) to inputOutput SFNode field <i>appearance</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DAppearanceNode] The appearance field holds an Appearance node that is used for the geometry. All effects, such as material colours and/or multi-textures, are applied to each particle. Hint: if a texture coordinate ramp and key is supplied with this geometry, it shall be used in preference to any automatic texture coordinate generation. Hint: if automatic texture coordinate generation is used, results shall be based on the entire volume that the particles consume, not locally applied to each particle.
	 * @param newValue is new value for the appearance field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setAppearance(X3DAppearanceNode newValue); // acceptable node types: X3DAppearanceNode

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
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setBboxCenter(float[] newValue);

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
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setBboxSize(float[] newValue);

	/**
	 * Provide array of float results using RGB values [0..1] from initializeOnly MFFloat field named <i>colorKey</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) Array of time intervals in seconds, corresponding to particle lifetime, that are used to interpolate colorRamp array values. Hint: color values are interpolated in linear Hue Saturation Value (HSV) space, similar to ColorInterpolator node. Hint: color values are defined as per-vertex colour values. Warning: if an Appearance and Material nodes are provided, those material properties override colorRamp interpolation. Hint: number of colorKey values must match length of the per-vertex colorRamp arrays! Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @return value of colorKey field
	 */
	public float[] getColorKey();

	/**
	 * Assign float array using RGB values [0..1] to initializeOnly MFFloat field named <i>colorKey</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) Array of time intervals in seconds, corresponding to particle lifetime, that are used to interpolate colorRamp array values. Hint: color values are interpolated in linear Hue Saturation Value (HSV) space, similar to ColorInterpolator node. Hint: color values are defined as per-vertex colour values. Warning: if an Appearance and Material nodes are provided, those material properties override colorRamp interpolation. Hint: number of colorKey values must match length of the per-vertex colorRamp arrays! Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @param newValue is new value for the colorKey field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setColorKey(float[] newValue);

	/**
	 * Provide X3DColorNode instance (using a properly typed node) using RGB values [0..1] from initializeOnly SFNode field <i>colorRamp</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DColorNode] The colorRamp Color/ColorRGBA node holds a series of colour values to be used at the given colorKey points in time. Hint: color values are defined as per-vertex colour values. Warning: if an Appearance and Material nodes are provided, those material properties override colorRamp interpolation. Hint: number of colorKey values must match length of the per-vertex colorRamp arrays! Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @return value of colorRamp field
	 */
	public X3DColorNode getColorRamp(); // acceptable node types: X3DColorNode

	/**
	 * Assign X3DColorNode instance (using a properly typed node) using RGB values [0..1] to initializeOnly SFNode field <i>colorRamp</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DColorNode] The colorRamp Color/ColorRGBA node holds a series of colour values to be used at the given colorKey points in time. Hint: color values are defined as per-vertex colour values. Warning: if an Appearance and Material nodes are provided, those material properties override colorRamp interpolation. Hint: number of colorKey values must match length of the per-vertex colorRamp arrays! Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @param newValue is new value for the colorRamp field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setColorRamp(X3DColorNode newValue); // acceptable node types: X3DColorNode

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>createParticles</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables creation of new particles, while any existing particles remain in existence and continue to animate until the end of their lifetimes. Hint: if no particles are left in scene, system is considered both active and enabled.
	 * @return value of createParticles field
	 */
	public boolean getCreateParticles();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>createParticles</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables creation of new particles, while any existing particles remain in existence and continue to animate until the end of their lifetimes. Hint: if no particles are left in scene, system is considered both active and enabled.
	 * @param newValue is new value for the createParticles field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setCreateParticles(boolean newValue);

	/**
	 * Provide X3DParticleEmitterNode instance (using a properly typed node) from initializeOnly SFNode field <i>emitter</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DParticleEmitterNode] The emitter field specifies the type of emitter geometry and properties that the particles are given for their initial positions.
	 * @return value of emitter field
	 */
	public X3DParticleEmitterNode getEmitter(); // acceptable node types: X3DParticleEmitterNode

	/**
	 * Assign X3DParticleEmitterNode instance (using a properly typed node) to initializeOnly SFNode field <i>emitter</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DParticleEmitterNode] The emitter field specifies the type of emitter geometry and properties that the particles are given for their initial positions.
	 * @param newValue is new value for the emitter field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setEmitter(X3DParticleEmitterNode newValue); // acceptable node types: X3DParticleEmitterNode

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @return value of enabled field
	 */
	public boolean getEnabled();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @param newValue is new value for the enabled field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setEnabled(boolean newValue);

	/**
	 * Provide X3DGeometryNode instance (using a properly typed node) from inputOutput SFNode field <i>geometry</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DGeometryNode] The geometry node provides geometry used for each particle when geometryType=GEOMETRY. Hint: include &lt;component name='Geospatial' level='1'/&gt;.
	 * @return value of geometry field
	 */
	@Override
	public X3DGeometryNode getGeometry(); // acceptable node types: X3DGeometryNode

	/**
	 * Assign X3DGeometryNode instance (using a properly typed node) to inputOutput SFNode field <i>geometry</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DGeometryNode] The geometry node provides geometry used for each particle when geometryType=GEOMETRY. Hint: include &lt;component name='Geospatial' level='1'/&gt;.
	 * @param newValue is new value for the geometry field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setGeometry(X3DGeometryNode newValue); // acceptable node types: X3DGeometryNode

	/**
	 * Provide String enumeration value ['LINE'|'POINT'|'QUAD'|'SPRITE'|'TRIANGLE'|'GEOMETRY'] from initializeOnly SFString field named <i>geometryType</i>.
	 * @return value of geometryType field
	 */
	public String getGeometryType();

	/**
	 * Assign String enumeration value ("LINE"|"POINT"|"QUAD"|"SPRITE"|"TRIANGLE"|"GEOMETRY") ['LINE'|'POINT'|'QUAD'|'SPRITE'|'TRIANGLE'|'GEOMETRY'] to initializeOnly SFString field named <i>geometryType</i>.
	 * @param newValue is new value for the geometryType field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setGeometryType(String newValue);

	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isActive</i>.
	 * <br><br>
	 * <i>Tooltip:</i> isActive true/false events are sent when playback starts/stops.
	 * @return value of isActive field
	 */
	public boolean getIsActive();
	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>lifetimeVariation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1) TODO not properly defined in X3D spedification. Multiplier for the randomness used to control the range of possible output values. The bigger the value, the more random the output and the bigger the range of initial values possible. Hint: variation of zero does not allow any randomness.
	 * @return value of lifetimeVariation field
	 */
	public float getLifetimeVariation();

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>lifetimeVariation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1) TODO not properly defined in X3D spedification. Multiplier for the randomness used to control the range of possible output values. The bigger the value, the more random the output and the bigger the range of initial values possible. Hint: variation of zero does not allow any randomness.
	 * @param newValue is new value for the lifetimeVariation field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setLifetimeVariation(float newValue);

	/**
	 * Provide int value within allowed range of [0,infinity) from inputOutput SFInt32 field named <i>maxParticles</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] Maximum number of particles to be generated at one time (subject to player limitations).
	 * @return value of maxParticles field
	 */
	public int getMaxParticles();

	/**
	 * Assign int value within allowed range of [0,infinity) to inputOutput SFInt32 field named <i>maxParticles</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,infinity] Maximum number of particles to be generated at one time (subject to player limitations).
	 * @param newValue is new value for the maxParticles field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setMaxParticles(int newValue);

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
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide float value within allowed range of [0,infinity) from inputOutput SFFloat field named <i>particleLifetime</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) TODO not properly defined in X3D spedification. Particle animation lifetime in base time units (default is seconds).
	 * @return value of particleLifetime field
	 */
	public float getParticleLifetime();

	/**
	 * Assign float value within allowed range of [0,infinity) to inputOutput SFFloat field named <i>particleLifetime</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) TODO not properly defined in X3D spedification. Particle animation lifetime in base time units (default is seconds).
	 * @param newValue is new value for the particleLifetime field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setParticleLifetime(float newValue);

	/**
	 * Provide array of 2-tuple float results within allowed range of [0,infinity) from inputOutput SFVec2f field named <i>particleSize</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) particleSize describes width and height dimensions for each particle in length base units (default is meters). Changing this value dynamically will only change new particles created after the change. Hint: particles created before this timestamp will remain at the old size. Hint: his field only effects particles using LINE, QUAD, SPRITE, and TRIANGLE geometry types.
	 * @return value of particleSize field
	 */
	public float[] getParticleSize();

	/**
	 * Assign 2-tuple float array within allowed range of [0,infinity) to inputOutput SFVec2f field named <i>particleSize</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) particleSize describes width and height dimensions for each particle in length base units (default is meters). Changing this value dynamically will only change new particles created after the change. Hint: particles created before this timestamp will remain at the old size. Hint: his field only effects particles using LINE, QUAD, SPRITE, and TRIANGLE geometry types.
	 * @param newValue is new value for the particleSize field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setParticleSize(float[] newValue);

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) from initializeOnly MFNode field <i>physics</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DParticlePhysicsModelNode] After being created, the individual particles are then manipulated according to the physics model(s) specified in the physics field.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DParticlePhysicsModelNode.
	 * @return value of physics field
	 */
	public X3DNode[] getPhysics(); // acceptable node types: X3DParticlePhysicsModelNode

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) to initializeOnly MFNode field <i>physics</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [X3DParticlePhysicsModelNode] After being created, the individual particles are then manipulated according to the physics model(s) specified in the physics field.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DParticlePhysicsModelNode.
	 * @param newValue is new value for the physics field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setPhysics(X3DNode[] newValue); // acceptable node types: X3DParticlePhysicsModelNode

	/**
	 * Add array of child physics nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DParticlePhysicsModelNode.
	 * @param newValue is new value array to be appended the physics field.
	 */
	public void addPhysics(X3DNode[] newValue); // acceptable node types: X3DParticlePhysicsModelNode
	/**
	 * Set single child physics node, replacing prior array of existing nodes (if any).
	 * @param newValue is new node for the physics field.
	 */
	public void setPhysics(X3DNode newValue); // acceptable node types: X3DParticlePhysicsModelNode
	/**
	 * Provide array of float results within allowed range of [0,infinity) from initializeOnly MFFloat field named <i>texCoordKey</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) Array of time intervals in seconds, corresponding to particle lifetime, that are used to sequence texCoordRamp array values. Hint: no interpolation is performed, texture coordinates are simply sequenced in order. Hint: texture-coordinate values map textures to vertices in the geometry. Hint: number of texCoordKey values must match length of the per-vertex texCoordRamp arrays!.
	 * @return value of texCoordKey field
	 */
	public float[] getTexCoordKey();

	/**
	 * Assign float array within allowed range of [0,infinity) to initializeOnly MFFloat field named <i>texCoordKey</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,+infinity) Array of time intervals in seconds, corresponding to particle lifetime, that are used to sequence texCoordRamp array values. Hint: no interpolation is performed, texture coordinates are simply sequenced in order. Hint: texture-coordinate values map textures to vertices in the geometry. Hint: number of texCoordKey values must match length of the per-vertex texCoordRamp arrays!.
	 * @param newValue is new value for the texCoordKey field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setTexCoordKey(float[] newValue);

	/**
	 * Provide TextureCoordinate instance (using a properly typed node) from initializeOnly SFNode field <i>texCoordRamp</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [TextureCoordinate] texture coordinates of the provided texture(s) in the Appearance node, over time. Particle systems frequently like to change the texture on a particle as it ages, yet there is no good way of accomplishing this through standard interpolators because interpolators have no concept of particle time. This pair of fields hold time-dependent values for the texture coordinates to be applied to the particle. When a particle reaches the next time stamp it moves to the next set of texture coordinates. Hint: texture-coordinate values map textures to vertices in the geometry. Hint: number of texCoordKey values must match length of the per-vertex texCoordRamp arrays!.
	 * @return value of texCoordRamp field
	 */
	public TextureCoordinate getTexCoordRamp(); // acceptable node types: TextureCoordinate

	/**
	 * Assign TextureCoordinate instance (using a properly typed node) to initializeOnly SFNode field <i>texCoordRamp</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [TextureCoordinate] texture coordinates of the provided texture(s) in the Appearance node, over time. Particle systems frequently like to change the texture on a particle as it ages, yet there is no good way of accomplishing this through standard interpolators because interpolators have no concept of particle time. This pair of fields hold time-dependent values for the texture coordinates to be applied to the particle. When a particle reaches the next time stamp it moves to the next set of texture coordinates. Hint: texture-coordinate values map textures to vertices in the geometry. Hint: number of texCoordKey values must match length of the per-vertex texCoordRamp arrays!.
	 * @param newValue is new value for the texCoordRamp field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ParticleSystem setTexCoordRamp(TextureCoordinate newValue); // acceptable node types: TextureCoordinate


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setDEF(String newValue);


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
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link ParticleSystem} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ParticleSystem setCssClass(String newValue);

}

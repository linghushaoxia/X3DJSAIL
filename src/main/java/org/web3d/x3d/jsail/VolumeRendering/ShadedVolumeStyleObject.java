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

package org.web3d.x3d.jsail.VolumeRendering;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.fields.*; // making sure #4
import org.web3d.x3d.sai.VolumeRendering.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Shape.*;
import org.web3d.x3d.sai.VolumeRendering.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;
import org.web3d.x3d.sai.VolumeRendering.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Texturing3D.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Texturing3D.*;

/**
 * All fields fully supported except shadows supported with at least Phong shading at level 3. All fields fully supported with at least Phong shading and Henyey-Greenstein phase function, shadows fully supported at level 4.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  (X3D version 3.3 or later) ShadedVolumeStyle applies Blinn-Phong illumination model to volume rendering. 
 * <ul>
 *  <li> <i> Hint:</i>   ShadedVolumeStyle can contain a single Texture3D node with containerField='surfaceNormals' and a single Material node.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This org.web3d.x3d.jsail concrete class is used for implementing a standalone X3D object as a Plain Old Java Object (POJO).
 * If you are writing Java code for use inside an X3D Script node, compile using the <i>org.web3d.x3d.sai</i> package instead.
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/volume.html#ShadedVolumeStyle" target="blank">X3D Abstract Specification: ShadedVolumeStyle</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#ShadedVolumeStyle" target="_blank">X3D Tooltips: ShadedVolumeStyle</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Volume" target="_blank">X3D Scene Authoring Hints: Volume</a>
 */
public class ShadedVolumeStyleObject extends org.web3d.x3d.jsail.X3DConcreteNode implements org.web3d.x3d.sai.VolumeRendering.ShadedVolumeStyle
{
	private ArrayList<String> commentsList; // provided since no children array present

	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private boolean enabled;

	private boolean lighting;

	private X3DMaterialNode material; // acceptable node types: X3DMaterialNode
	private ProtoInstanceObject materialProtoInstance; // allowed alternative for material field

	private X3DMetadataObject metadata; // acceptable node types: X3DMetadataObject
	private ProtoInstanceObject metadataProtoInstance; // allowed alternative for metadata field

	private String phaseFunction;

	private boolean shadows;

	private X3DTexture3DNode surfaceNormals; // acceptable node types: X3DTexture3DNode
	private ProtoInstanceObject surfaceNormalsProtoInstance; // allowed alternative for surfaceNormals field

	/** IS/connect statements might be used if this node is within a ProtoBody and connections are defined between prototype fields and built-in node fields */
	private ISObject IS;

	// ==== String constants for enumeration values ensure correct syntax and avoid run-time errors ====

	/** SFString field named <i>phaseFunction</i> can equal this enumeration value <i>"Henyey-Greenstein"</i> (Java syntax) or <i>Henyey-Greenstein</i> (XML syntax). */
	public static final String PHASEFUNCTION_HENYEY_GREENSTEIN = "Henyey-Greenstein";

	/** SFString field named <i>phaseFunction</i> can equal this enumeration value <i>"NONE"</i> (Java syntax) or <i>NONE</i> (XML syntax). */
	public static final String PHASEFUNCTION_NONE = "NONE";

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>ShadedVolumeStyle</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "ShadedVolumeStyle";

	/** Provides name of this element: ShadedVolumeStyle.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** SFBool field named <i>enabled</i> has default value <i>true</i> (Java syntax) or <i>true</i> (XML syntax). */
	public static final boolean ENABLED_DEFAULT_VALUE = true;

	/** SFBool field named <i>lighting</i> has default value <i>false</i> (Java syntax) or <i>false</i> (XML syntax). */
	public static final boolean LIGHTING_DEFAULT_VALUE = false;

	/** SFString field named <i>phaseFunction</i> has default value <i>"Henyey-Greenstein"</i> (Java syntax) or <i>Henyey-Greenstein</i> (XML syntax). */
	public static final String PHASEFUNCTION_DEFAULT_VALUE = "Henyey-Greenstein";

	/** SFBool field named <i>shadows</i> has default value <i>false</i> (Java syntax) or <i>false</i> (XML syntax). */
	public static final boolean SHADOWS_DEFAULT_VALUE = false;

	/** Indicate type corresponding to given fieldName.
	 * @param fieldName name of field in this X3D node
	 * @see ConfigurationProperties#ERROR_UNKNOWN_FIELD_TYPE
	 * @return X3D type (SFvec3f etc.), otherwise ConfigurationProperties.ERROR_UNKNOWN_FIELD_TYPE if not recognized
	 */
	@Override		
	public String getFieldType(String fieldName)
	{
		String result;

		switch (fieldName)
		{
			// String constants for exact field type values matching X3D Schema definitions,
			// thus avoiding spelling errors and allowing type-matching checks
											
			case "containerField":
				result = "SFString";
				break;
			case "enabled":
				result = "SFBool";
				break;
			case "lighting":
				result = "SFBool";
				break;
			case "material":
				result = "SFNode";
				break;
			case "metadata":
				result = "SFNode";
				break;
			case "phaseFunction":
				result = "SFString";
				break;
			case "shadows":
				result = "SFBool";
				break;
			case "surfaceNormals":
				result = "SFNode";
				break;
			case "DEF":
				result = "SFString";
				break;
			case "USE":
				result = "SFString";
				break;
			case "class":
				result = "SFString";
				break;
			default:
			{
				// if fieldName has a prefix "set_" prepended (or a suffix "_changed" appended) then try again by stripping it and recursing once
				if      (fieldName.trim().startsWith("set_"))
						 result = getFieldType(fieldName.trim().substring(4)); // after "set_"
				else if (fieldName.trim().endsWith("_changed"))
						 result = getFieldType(fieldName.trim().substring(0, fieldName.length() - 8)); // before "_changed"
				else     result = ConfigurationProperties.ERROR_UNKNOWN_FIELD_TYPE; // unique return value avoids mistaken matches
			}
		}
		return result;
	}

	/** Indicate accessType corresponding to given fieldName.
	 * @param fieldName name of field in this X3D node
	 * @see ConfigurationProperties#ERROR_UNKNOWN_FIELD_ACCESSTYPE
	 * @return X3D accessType (inputOnly etc.), otherwise ConfigurationProperties.ERROR_UNKNOWN_FIELD_ACCESSTYPE if not recognized
	 */
	@Override
	public String getAccessType(String fieldName)
	{
		String result; // set by following checks
		switch (fieldName)
		{
			// String constants for field accessType values matching X3D Schema definitions,
			// thus avoiding spelling errors and allowing accessType-matching checks
			case "enabled":
				result = "inputOutput";
				break;
			case "lighting":
				result = "inputOutput";
				break;
			case "material":
				result = "inputOutput";
				break;
			case "metadata":
				result = "inputOutput";
				break;
			case "phaseFunction":
				result = "initializeOnly";
				break;
			case "shadows":
				result = "inputOutput";
				break;
			case "surfaceNormals":
				result = "inputOutput";
				break;
			case "DEF":
				result = "inputOutput";
				break;
			case "USE":
				result = "inputOutput";
				break;
			case "class":
				result = "inputOutput";
				break;
			default:
			{
				// if user has added a prefix "set_" or suffix "_changed" then try again by stripping it and recursing once
				if      (fieldName.trim().startsWith("set_"))
						 result = getAccessType(fieldName.trim().substring(4)); // after "set_"
				else if (fieldName.trim().endsWith("_changed"))
						 result = getAccessType(fieldName.trim().substring(0, fieldName.length() - 8)); // before "_changed"
				else     result = ConfigurationProperties.ERROR_UNKNOWN_FIELD_ACCESSTYPE; // unique return value avoids mistaken matches
			}
		}
		return result;
	}

	/** containerField describes typical field relationship of a node to its parent.
	 * Usage is not ordinarily needed when using this API, default value is provided for informational purposes. */
	String containerField_DEFAULT_VALUE = "renderStyle";

	// String constants for field names usable in ROUTE statements

	/** fromField ROUTE name for SFBool field named <i>enabled</i>. */
	public static final String fromField_ENABLED = "enabled";

	/** toField ROUTE name for SFBool field named <i>enabled</i>. */
	public static final String toField_ENABLED = "enabled";

	/** fromField ROUTE name for SFBool field named <i>lighting</i>. */
	public static final String fromField_LIGHTING = "lighting";

	/** toField ROUTE name for SFBool field named <i>lighting</i>. */
	public static final String toField_LIGHTING = "lighting";

	/** fromField ROUTE name for SFNode field named <i>material</i>. */
	public static final String fromField_MATERIAL = "material";

	/** toField ROUTE name for SFNode field named <i>material</i>. */
	public static final String toField_MATERIAL = "material";

	/** fromField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String fromField_METADATA = "metadata";

	/** toField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String toField_METADATA = "metadata";

	/** fromField ROUTE name for SFBool field named <i>shadows</i>. */
	public static final String fromField_SHADOWS = "shadows";

	/** toField ROUTE name for SFBool field named <i>shadows</i>. */
	public static final String toField_SHADOWS = "shadows";

	/** fromField ROUTE name for SFNode field named <i>surfaceNormals</i>. */
	public static final String fromField_SURFACENORMALS = "surfaceNormals";

	/** toField ROUTE name for SFNode field named <i>surfaceNormals</i>. */
	public static final String toField_SURFACENORMALS = "surfaceNormals";

	/** Constructor for ShadedVolumeStyleObject to initialize member variables with default values. */
	public ShadedVolumeStyleObject()
	{
		super(); // constructor invocation and corresponding initialize()
		initialize();
	}

	/** Initialize all member variables to default values. */
	@Override
	public final void initialize()
	{
		super.initialize();

		containerField_ALTERNATE_VALUES = new String[] { "renderStyle" };

		enabled = ENABLED_DEFAULT_VALUE;
		lighting = LIGHTING_DEFAULT_VALUE;
		material = null; // clear out any prior node
		metadata = null; // clear out any prior node
		phaseFunction = PHASEFUNCTION_DEFAULT_VALUE;
		shadows = SHADOWS_DEFAULT_VALUE;
		surfaceNormals = null; // clear out any prior node

		commentsList = new ArrayList<>(); // instantiate
	}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide boolean value from inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @return value of enabled field
	 */
	@Override
	public boolean getEnabled()
	{
		return enabled;
	}

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>enabled</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables node operation.
	 * @param newValue is new value for the enabled field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setEnabled(boolean newValue)
	{
		enabled = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool enabled field, similar to {@link #setEnabled(boolean)}.
	 * @param newValue is new value for the enabled field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setEnabled(SFBoolObject newValue)
	{
		setEnabled(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide boolean value from inputOutput SFBool field named <i>lighting</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether rendering calculates and applies shading effects to visual output.
	 * @return value of lighting field
	 */
	@Override
	public boolean getLighting()
	{
		return lighting;
	}

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>lighting</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether rendering calculates and applies shading effects to visual output.
	 * @param newValue is new value for the lighting field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setLighting(boolean newValue)
	{
		lighting = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool lighting field, similar to {@link #setLighting(boolean)}.
	 * @param newValue is new value for the lighting field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setLighting(SFBoolObject newValue)
	{
		setLighting(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide X3DMaterialNode instance (using a properly typed node) from inputOutput SFNode field <i>material</i>.
	 * @see #getMaterialProtoInstance()
	 * @return value of material field
	 */
	@Override
	public X3DMaterialNode getMaterial()
	{
		return material;
	}

	/**
	 * Assign X3DMaterialNode instance (using a properly typed node) to inputOutput SFNode field <i>material</i>.
	 * @see #setMaterial(ProtoInstanceObject)
	 * @param newValue is new value for the material field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setMaterial(X3DMaterialNode newValue)
	{
		material = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) material).setParentObject(this); // parentTest15
		}
		if (materialProtoInstance != null)
		{
			materialProtoInstance.setParentObject(null); // housekeeping, clear prior object
			materialProtoInstance = null;
		}

		return this;
	}

	/**
	 * Utility method to clear SFNode value of material field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public ShadedVolumeStyleObject clearMaterial()
	{
		((X3DConcreteElement) material).clearParentObject(); // remove references to facilitate Java memory management
		material = null; // reset SFNode field
		return this;
	}
	/**
	 * Assign ProtoInstance to <i>material</i> field;

	 * <i>WARNING:</i> ProtoInstance must match acceptable node type X3DMaterialNode.
	 * @param newProtoInstanceNode is the new ProtoInstance node for the material field
	 * @see #setMaterial(X3DMaterialNode)
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ShadedVolumeStyleObject setMaterial(ProtoInstanceObject newProtoInstanceNode)
	{
		if (material != null)
		{
			((X3DConcreteElement) material).setParentObject(null); // housekeeping, clear prior object
			material = null;
		}
		materialProtoInstance = newProtoInstanceNode;
		if (newProtoInstanceNode != null)
		{
			newProtoInstanceNode.setParentObject(this);
		}
		return this;
	}
	/**
	 * Provide properly typed ProtoInstance for inputOutput SFNode field <i>material</i>, if available.
	 * @see #getMaterial()
	 * @return ProtoInstance value of geometry field
	 */
	public ProtoInstanceObject getMaterialProtoInstance()
	{
		return materialProtoInstance;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>material</i>.
	 * @return whether a properly typed node or ProtoInstance or CommentsBlock is available.
	 * @see #getMaterial()
	 * @see #getMaterialProtoInstance()
	 */
	public boolean hasMaterial()
	{
		return (material != null) || (materialProtoInstance != null);
	}
	/**
	 * Provide X3DMetadataObject instance (using a properly typed node) from inputOutput SFNode field <i>metadata</i>.
	 * @see #getMetadataProtoInstance()
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @return value of metadata field
	 */
	@Override
	public X3DMetadataObject getMetadata()
	{
		return metadata;
	}

	/**
	 * Assign X3DMetadataObject instance (using a properly typed node) to inputOutput SFNode field <i>metadata</i>.
	 * @see #setMetadata(ProtoInstanceObject)
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @param newValue is new value for the metadata field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setMetadata(X3DMetadataObject newValue)
	{
		metadata = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) metadata).setParentObject(this); // parentTest15
		}
		if (metadataProtoInstance != null)
		{
			metadataProtoInstance.setParentObject(null); // housekeeping, clear prior object
			metadataProtoInstance = null;
		}

		return this;
	}

	/**
	 * Utility method to clear SFNode value of metadata field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public ShadedVolumeStyleObject clearMetadata()
	{
		((X3DConcreteElement) metadata).clearParentObject(); // remove references to facilitate Java memory management
		metadata = null; // reset SFNode field
		return this;
	}
	/**
	 * Assign ProtoInstance to <i>metadata</i> field;

	 * <i>WARNING:</i> ProtoInstance must match acceptable node type X3DMetadataObject.
	 * @param newProtoInstanceNode is the new ProtoInstance node for the metadata field
	 * @see #setMetadata(X3DMetadataObject)
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ShadedVolumeStyleObject setMetadata(ProtoInstanceObject newProtoInstanceNode)
	{
		if (metadata != null)
		{
			((X3DConcreteElement) metadata).setParentObject(null); // housekeeping, clear prior object
			metadata = null;
		}
		metadataProtoInstance = newProtoInstanceNode;
		if (newProtoInstanceNode != null)
		{
			newProtoInstanceNode.setParentObject(this);
		}
		return this;
	}
	/**
	 * Provide properly typed ProtoInstance for inputOutput SFNode field <i>metadata</i>, if available.
	 * @see #getMetadata()
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @return ProtoInstance value of geometry field
	 */
	public ProtoInstanceObject getMetadataProtoInstance()
	{
		return metadataProtoInstance;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>metadata</i>.
	 * @return whether a properly typed node or ProtoInstance or CommentsBlock is available.
	 * @see #getMetadata()
	 * @see #getMetadataProtoInstance()
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 */
	public boolean hasMetadata()
	{
		return (metadata != null) || (metadataProtoInstance != null);
	}
	/**
	 * Provide String enumeration value ['Henyey-Greenstein'|'NONE'|'etc.'] from initializeOnly SFString field named <i>phaseFunction</i>.
	 * <br><br>
	 * <i>Tooltip:</i> define scattering model for implementations using global illumination (NONE or Henyey-Greenstein phase function).#10;Warning: do not wrap extra quotation marks around these SFString enumeration values, since "quotation" "marks" are only used for MFString values.
	 * <br><br>
	 * Available enumeration values for string comparison: {@link #PHASEFUNCTION_HENYEY_GREENSTEIN HENYEY_GREENSTEIN}, {@link #PHASEFUNCTION_NONE NONE}.
	 * @return value of phaseFunction field
	 */
	@Override
	public String getPhaseFunction()
	{
		return phaseFunction;
	}

	/**
	 * Assign String enumeration value ("Henyey-Greenstein"|"NONE") ['Henyey-Greenstein'|'NONE'|'etc.'] to initializeOnly SFString field named <i>phaseFunction</i>.
	 * <br><br>
	 * <i>Hint:</i> authors have option to choose from an extendible list of predefined enumeration values ({@link #PHASEFUNCTION_HENYEY_GREENSTEIN HENYEY_GREENSTEIN}, {@link #PHASEFUNCTION_NONE NONE}).
	 * <br><br>
	 * <i>Tooltip:</i> define scattering model for implementations using global illumination (NONE or Henyey-Greenstein phase function).#10;Warning: do not wrap extra quotation marks around these SFString enumeration values, since "quotation" "marks" are only used for MFString values.
	 * @param newValue is new value for the phaseFunction field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setPhaseFunction(String newValue)
	{
		if (newValue == null) 
			newValue = new String(); // Principle of Least Astonishment (POLA)
			// https://en.wikipedia.org/wiki/Principle_of_least_astonishment
		phaseFunction = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFString phaseFunction field, similar to {@link #setPhaseFunction(String)}.
	 * @param newValue is new value for the phaseFunction field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setPhaseFunction(SFStringObject newValue)
	{
		setPhaseFunction(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide boolean value from inputOutput SFBool field named <i>shadows</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether rendering calculates and applies shadows to visual output (using global illumination model).
	 * @return value of shadows field
	 */
	@Override
	public boolean getShadows()
	{
		return shadows;
	}

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>shadows</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Whether rendering calculates and applies shadows to visual output (using global illumination model).
	 * @param newValue is new value for the shadows field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setShadows(boolean newValue)
	{
		shadows = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool shadows field, similar to {@link #setShadows(boolean)}.
	 * @param newValue is new value for the shadows field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setShadows(SFBoolObject newValue)
	{
		setShadows(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide X3DTexture3DNode instance (using a properly typed node) from inputOutput SFNode field <i>surfaceNormals</i>.
	 * @see #getSurfaceNormalsProtoInstance()
	 * @return value of surfaceNormals field
	 */
	@Override
	public X3DTexture3DNode getSurfaceNormals()
	{
		return surfaceNormals;
	}

	/**
	 * Assign X3DTexture3DNode instance (using a properly typed node) to inputOutput SFNode field <i>surfaceNormals</i>.
	 * @see #setSurfaceNormals(ProtoInstanceObject)
	 * @param newValue is new value for the surfaceNormals field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setSurfaceNormals(X3DTexture3DNode newValue)
	{
		surfaceNormals = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) surfaceNormals).setParentObject(this); // parentTest15
		}
		if (surfaceNormalsProtoInstance != null)
		{
			surfaceNormalsProtoInstance.setParentObject(null); // housekeeping, clear prior object
			surfaceNormalsProtoInstance = null;
		}

		return this;
	}

	/**
	 * Utility method to clear SFNode value of surfaceNormals field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public ShadedVolumeStyleObject clearSurfaceNormals()
	{
		((X3DConcreteElement) surfaceNormals).clearParentObject(); // remove references to facilitate Java memory management
		surfaceNormals = null; // reset SFNode field
		return this;
	}
	/**
	 * Assign ProtoInstance to <i>surfaceNormals</i> field;

	 * <i>WARNING:</i> ProtoInstance must match acceptable node type X3DTexture3DNode.
	 * @param newProtoInstanceNode is the new ProtoInstance node for the surfaceNormals field
	 * @see #setSurfaceNormals(X3DTexture3DNode)
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ShadedVolumeStyleObject setSurfaceNormals(ProtoInstanceObject newProtoInstanceNode)
	{
		if (surfaceNormals != null)
		{
			((X3DConcreteElement) surfaceNormals).setParentObject(null); // housekeeping, clear prior object
			surfaceNormals = null;
		}
		surfaceNormalsProtoInstance = newProtoInstanceNode;
		if (newProtoInstanceNode != null)
		{
			newProtoInstanceNode.setParentObject(this);
		}
		return this;
	}
	/**
	 * Provide properly typed ProtoInstance for inputOutput SFNode field <i>surfaceNormals</i>, if available.
	 * @see #getSurfaceNormals()
	 * @return ProtoInstance value of geometry field
	 */
	public ProtoInstanceObject getSurfaceNormalsProtoInstance()
	{
		return surfaceNormalsProtoInstance;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>surfaceNormals</i>.
	 * @return whether a properly typed node or ProtoInstance or CommentsBlock is available.
	 * @see #getSurfaceNormals()
	 * @see #getSurfaceNormalsProtoInstance()
	 */
	public boolean hasSurfaceNormals()
	{
		return (surfaceNormals != null) || (surfaceNormalsProtoInstance != null);
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ShadedVolumeStyleObject setDEF(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to ShadedVolumeStyle
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("ShadedVolumeStyle DEF newValue='" + newValue + "'" + 
				" has illegal name value, cannot be empty and must be defined with valid NMTOKEN name string" + 
				" (with legal characters and no embedded whitespace).");
		}
		setConcreteUSE(""); // ensure that no previous USE value remains
		setConcreteDEF(newValue); // private superclass methods
		return this;
	}

	/**
	 * Assign typed object value to SFString DEF field, similar to {@link #setDEF(String)}.
	 * @param newValue is new value for the DEF field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setDEF(SFStringObject newValue)
	{
		setDEF(newValue.getPrimitiveValue());
		return this;
	}

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
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ShadedVolumeStyleObject setUSE(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to ShadedVolumeStyle
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("ShadedVolumeStyle USE newValue='" + newValue + "'" + 
				" has illegal name value, cannot be empty and must be defined with valid NMTOKEN name string" + 
				" (with legal characters and no embedded whitespace).");
		}
		initialize(); // reset all other field values to default (equivalent to empty)
		setConcreteUSE(newValue); // private superclass method
		return this;
	}

	/**
	 * Assign typed object value to SFString USE field, similar to {@link #setUSE(String)}.
	 * @param newValue is new value for the USE field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setUSE(SFStringObject newValue)
	{
		setUSE(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ShadedVolumeStyleObject setCssClass(String newValue)
	{
		if (newValue == null) 
			newValue = new String(); // Principle of Least Astonishment (POLA)
			// https://en.wikipedia.org/wiki/Principle_of_least_astonishment
		setConcreteCssClass(newValue); // private superclass method
		return this;
	}

	/**
	 * Assign typed object value to SFString cssClass field, similar to {@link #setCssClass(String)}.
	 * @param newValue is new value for the class field.
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setCssClass(SFStringObject newValue)
	{
		setCssClass(newValue.getPrimitiveValue());
		return this;
	}

	// Additional utility methods for this class ==============================

	/**
	 * Utility constructor that assigns DEF name after initializing member variables with default values
	 * @param DEFname unique DEF name for this X3D node
	 */
	public ShadedVolumeStyleObject (String DEFname)
	{
		initialize();
		setDEF(DEFname); // apply checks
	}

	/**
	 * Assign field named <i>IS</i> for establishing IS/connect field connections between ProtoInterface fields and internal ProtoBody nodes.
	 * The IS statement connects node fields defined inside a ProtoBody declaration back to corresponding ProtoInterface fields.
	 * @param newValue is new value for the description field.
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#IS">X3D Tooltips: IS</a>
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#connect">X3D Tooltips: connect</a>
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ShadedVolumeStyleObject setIS(ISObject newValue)
	{
		if (IS != null)
			IS.setParentObject(null); // housekeeping, clear prior object
		IS = newValue;
		IS.setParentObject(this);
		return this;
	}
	/**
	 * Provide field named <i>IS</i> for establishing IS/connect field connections between ProtoInterface fields and internal ProtoBody nodes.
	 * The IS statement connects node fields defined inside a ProtoBody declaration back to corresponding ProtoInterface fields.
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#IS">X3D Tooltips: IS</a>
	 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#connect">X3D Tooltips: connect</a>
	 * @return current ISObject, if any.
	 */
	@Override
	public ISObject getIS()
	{
		return IS;
	}
	/**
	 * Assign a USE reference to another DEF node of same node type, similar to {@link #setUSE(String)}.
	 * <br ><br >
	 * <i>WARNING:</i> note that the <code>setUSE()</code> method resets all other fields to their default values and also releases
all child nodes.
	 * <br><br>
	 * <i>WARNING.</i> no other operations can be performed to modify a USE node other than setting an alternate containerField value.
	 * @param DEFnode must have a DEF value defined
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ShadedVolumeStyleObject setUSE(ShadedVolumeStyleObject DEFnode)
	{
		if (DEFnode.getDEF().isEmpty())
		{
			String errorNotice = "setUSE(DEFnode) invoked on ShadedVolumeStyleObject" +
				" that has no DEF name defined, thus a copy cannot be referenced as a USE node";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
		setUSE(DEFnode.getDEF());
		return this;
	}
	/**
	 * Add comment as String to contained commentsList.
	 * @param newComment initial value
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ShadedVolumeStyleObject addComments (String newComment)
	{
		if (isUSE())
		{
			String errorNotice = "addComments(\"" + newComment + "\")" + "\n" +
					"cannot be applied to a USE node (USE='" + getUSE() + "') which only contains a reference to a DEF node";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
								
		commentsList.add(newComment);
		return this;
	}
	/**
	 * Add comments as String[] array to contained commentsList.
	 * @param newComments array of comments
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ShadedVolumeStyleObject addComments (String[] newComments)
	{
		if (isUSE())
		{
			String errorNotice = "addComments(" + newComments + ")" + "\n" +
					"cannot be applied to a USE node (USE='" + getUSE() + "') which only contains a reference to a DEF node";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
								
		commentsList.addAll(Arrays.asList(newComments));
		return this;
	}
	/**
	 * Add CommentsBlock to contained commentsList.
	 * @param newCommentsBlock block of comments to add
	 * @return {@link ShadedVolumeStyleObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ShadedVolumeStyleObject addComments (CommentsBlock newCommentsBlock)
	{
		if (isUSE())
		{
			String errorNotice = "addComments(CommentsBlock) " +
					"cannot be applied to a USE node (USE='" + getUSE() + "') which only contains a reference to a DEF node";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
								
		commentsList.addAll(newCommentsBlock.toStringList());
		return this;
	}
		
	/**
	 * Recursive method to provide X3D string serialization of this model subgraph.
	 * @param level number of levels of indentation for this element
	 * @return X3D string
	 */
	@Override
	public String toStringX3D(int level)
	{
		boolean hasAttributes = true; // TODO check for non-default attribute values
		boolean      hasChild = (IS != null) || (material != null) || (materialProtoInstance != null) || (metadata != null) || (metadataProtoInstance != null) || (surfaceNormals != null) || (surfaceNormalsProtoInstance != null) || !commentsList.isEmpty();

		if (isUSE())
			hasChild = false; // USE nodes only include attributes for USE and non-default containerField
		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(indent).append("<ShadedVolumeStyle"); // start opening tag
		if (hasAttributes)
		{
			if (!getDEF().equals(DEF_DEFAULT_VALUE) && !isUSE())
			{
				stringX3D.append(" DEF='").append(SFStringObject.toString(getDEF())).append("'");
			}
			
			if (!getUSE().equals(USE_DEFAULT_VALUE))
			{
				stringX3D.append(" USE='").append(SFStringObject.toString(getUSE())).append("'");
			}
			
			if (!getContainerFieldOverride().isEmpty() && !getContainerFieldOverride().equals(containerField_DEFAULT_VALUE))
			{
				stringX3D.append(" containerField='").append(getContainerFieldOverride()).append("'");
			}
			
			if (((getEnabled() != ENABLED_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" enabled='").append(SFBoolObject.toString(getEnabled())).append("'");
			}
			if (((getLighting() != LIGHTING_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" lighting='").append(SFBoolObject.toString(getLighting())).append("'");
			}
			if ((!getPhaseFunction().equals(PHASEFUNCTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" phaseFunction='").append(new SFStringObject(getPhaseFunction()).toStringX3D()).append("'");
			}
			if (((getShadows() != SHADOWS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" shadows='").append(SFBoolObject.toString(getShadows())).append("'");
			}
			if ((!getCssClass().equals(CLASS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" class='").append(new SFStringObject(getCssClass()).toStringX3D()).append("'");
			}
		}
		if ((hasChild) && !isUSE()) // has contained node(s), comment(s), IS/connect and/or source code
		{
			stringX3D.append(">").append("\n"); // finish opening tag

			if (getIS() != null)
				stringX3D.append(getIS().toStringX3D(level + indentIncrement));

			// recursively iterate over child elements
			if      (metadata != null)
			{
				stringX3D.append(((X3DConcreteElement)metadata).toStringX3D(level + indentIncrement));
			}
			else if (metadataProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)metadataProtoInstance).toStringX3D(level + indentIncrement));
			}
			if      (material != null)
			{
				stringX3D.append(((X3DConcreteElement)material).toStringX3D(level + indentIncrement));
			}
			else if (materialProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)materialProtoInstance).toStringX3D(level + indentIncrement));
			}
			if      (surfaceNormals != null)
			{
				stringX3D.append(((X3DConcreteElement)surfaceNormals).toStringX3D(level + indentIncrement));
			}
			else if (surfaceNormalsProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)surfaceNormalsProtoInstance).toStringX3D(level + indentIncrement));
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringX3D.append(commentsBlock.toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</ShadedVolumeStyle>").append("\n"); // finish closing tag
		}
		else
		{
			stringX3D.append("/>").append("\n"); // otherwise finish singleton tag
		}
		return stringX3D.toString();
	}

	/**
	 * Recursive method to provide ClassicVRML string serialization.
	 * @param level number of levels of indentation for this element
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html#VRML">X3D Resources: Virtual Reality Modeling Language (VRML) 97</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/19776-2/V3.3/Part02/grammar.html">Extensible 3D (X3D) encodings Part 2: Classic VRML encoding, Annex A: Grammar</a>
	 * @return ClassicVRML string
	 */
	@Override
	public String toStringClassicVRML(int level)
	{
		StringBuilder stringClassicVRML = new StringBuilder();
		boolean hasAttributes = true; // TODO further refinement
		boolean      hasChild = (IS != null) || (material != null) || (materialProtoInstance != null) || (metadata != null) || (metadataProtoInstance != null) || (surfaceNormals != null) || (surfaceNormalsProtoInstance != null) || !commentsList.isEmpty();
		if (isUSE())
		{
			hasAttributes = false;
			hasChild      = false; // USE nodes include no other fields
		}
		StringBuilder  indent = new StringBuilder();
		char  indentCharacter = ConfigurationProperties.getIndentCharacter();
		int   indentIncrement = ConfigurationProperties.getIndentIncrement();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		if (!getDEF().equals(DEF_DEFAULT_VALUE))
		{
			stringClassicVRML.append("DEF ").append(SFStringObject.toString(getDEF())).append(" ");
		}
		if (!getUSE().equals(USE_DEFAULT_VALUE))
		{
			 stringClassicVRML.append("USE ").append(SFStringObject.toString(getUSE())).append("\n");
		}
		else // only have further output if not a USE node
		{
			stringClassicVRML.append("ShadedVolumeStyle").append(" { "); // define node name, node content follows

			if (hasAttributes || hasChild)
			{
				stringClassicVRML.append("\n").append(indent).append(indentCharacter); // fields for this node follow
			}
			if (hasAttributes)
			{

				boolean hasISconnect = (getIS() != null) && !getIS().getConnectList().isEmpty();
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("enabled"))
						{
							stringClassicVRML.append(indentCharacter).append("enabled").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getEnabled() != ENABLED_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("enabled ").append(SFBoolObject.toString(getEnabled())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("lighting"))
						{
							stringClassicVRML.append(indentCharacter).append("lighting").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getLighting() != LIGHTING_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("lighting ").append(SFBoolObject.toString(getLighting())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("phaseFunction"))
						{
							stringClassicVRML.append(indentCharacter).append("phaseFunction").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!getPhaseFunction().equals(PHASEFUNCTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("phaseFunction ").append("\"").append(SFStringObject.toString(getPhaseFunction())).append("\"").append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("shadows"))
						{
							stringClassicVRML.append(indentCharacter).append("shadows").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getShadows() != SHADOWS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("shadows ").append(SFBoolObject.toString(getShadows())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("class"))
						{
							stringClassicVRML.append(indentCharacter).append("class").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!getCssClass().equals(CLASS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("# class ").append("\"").append(SFStringObject.toString(getCssClass())).append("\"").append("\n").append(indent).append(indentCharacter);
				}
			}
		}
		if (hasChild) // has contained node(s), comment(s), IS/connect and/or source code
		{
			// recursively iterate over child elements
			if (material != null)
			{
				stringClassicVRML.append(indentCharacter).append("material").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) material).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode
			}
			else if (materialProtoInstance != null)
			{
				stringClassicVRML.append(indentCharacter).append("material").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) materialProtoInstance).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode ProtoInstance
			}
			if (metadata != null)
			{
				stringClassicVRML.append(indentCharacter).append("metadata").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) metadata).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode
			}
			else if (metadataProtoInstance != null)
			{
				stringClassicVRML.append(indentCharacter).append("metadata").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) metadataProtoInstance).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode ProtoInstance
			}
			if (surfaceNormals != null)
			{
				stringClassicVRML.append(indentCharacter).append("surfaceNormals").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) surfaceNormals).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode
			}
			else if (surfaceNormalsProtoInstance != null)
			{
				stringClassicVRML.append(indentCharacter).append("surfaceNormals").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) surfaceNormalsProtoInstance).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode ProtoInstance
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringClassicVRML.append(commentsBlock.toStringClassicVRML(level));
				stringClassicVRML.append(indent); // end SFNode
			}
		}
		if (hasAttributes || hasChild)
		{
			stringClassicVRML.append("}").append("\n"); // finish node content
		}
		return stringClassicVRML.toString();
	}

	/**
	 * Recursive method to provide VRML97 string serialization.
	 * @param level number of levels of indentation for this element
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dResources.html#VRML">X3D Resources: Virtual Reality Modeling Language (VRML) 97</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/14772/V2.0/index.html">Virtual Reality Modeling Language (VRML) 97 specification</a>
	 * @see <a href="http://www.web3d.org/documents/specifications/14772-1/V2.1/index.html">VRML 97 v2.1 Amendment</a>
	 * @return VRML97 string
	 */
	@Override
	public String toStringVRML97(int level)
	{
		return toStringClassicVRML(level);
	}

	/**
	 * Recursive method to provide object reference to node by DEF name, if found as this node or in a contained node.
	 * @param DEFname DEF name of node to find
	 * @return object reference to node
	 */
	@Override
	public X3DConcreteNode getNodeByDEF(String DEFname)
	{
		X3DConcreteNode referenceNode;

		if (getDEF().equals(DEFname))
			return this;

		if (material != null)
		{
			referenceNode = ((X3DConcreteNode) material).getNodeByDEF(DEFname); // SFNode
			if (referenceNode != null)
				return referenceNode;
		}
		if (metadata != null)
		{
			referenceNode = ((X3DConcreteNode) metadata).getNodeByDEF(DEFname); // SFNode
			if (referenceNode != null)
				return referenceNode;
		}
		if (surfaceNormals != null)
		{
			referenceNode = ((X3DConcreteNode) surfaceNormals).getNodeByDEF(DEFname); // SFNode
			if (referenceNode != null)
				return referenceNode;
		}
		return null; // not found, in this node or in children nodes
	}

	/**
	 * Recursive method to provide object reference to node or statement by name attribute, if found as part of this element or in a contained element.
	 * Elements with name fields include meta, Metadata* nodes, field/fieldValue, ProtoDeclare/ExternProtoDeclare/ProtoInstance, HAnim nodes.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same name, this method does not handle that case.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @return object reference to found element, null otherwise
	 * @see #findNodeByDEF(String)
	 */
	@Override
	public X3DConcreteElement findElementByNameValue(String nameValue)
	{
		return findElementByNameValue(nameValue, ""); // empty string is wildcard, any element match is allowed
	}
								
	/**
	 * Recursive method to provide object reference to node or statement by name attribute, if found as part of this element or in a contained element.
	 * Elements with name fields include meta, Metadata* nodes, field/fieldValue, ProtoDeclare/ExternProtoDeclare/ProtoInstance, HAnim nodes.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same name, this method does not handle that case.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @param elementName identifies the element of interest (meta MetadataString ProtoDeclare CADassembly ProtoInstance HAnimHumanoid etc.)
	 * @return object reference to found element, null otherwise
	 * @see #findNodeByDEF(String)
	 */
	@Override
	public X3DConcreteElement findElementByNameValue(String nameValue, String elementName)
	{
		if ((nameValue == null) || nameValue.isEmpty())
		{
			String errorNotice = "findElementByNameValue(\"\", " + elementName + ") cannot use empty string to find a name attribute";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
		// no name field available for this element
		X3DConcreteElement referenceElement;
		if (material != null)
		{
			referenceElement = ((X3DConcreteElement) material).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (materialProtoInstance != null)
		{
			referenceElement = ((X3DConcreteElement) materialProtoInstance).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (metadata != null)
		{
			referenceElement = ((X3DConcreteElement) metadata).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (metadataProtoInstance != null)
		{
			referenceElement = ((X3DConcreteElement) metadataProtoInstance).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (surfaceNormals != null)
		{
			referenceElement = ((X3DConcreteElement) surfaceNormals).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (surfaceNormalsProtoInstance != null)
		{
			referenceElement = ((X3DConcreteElement) surfaceNormalsProtoInstance).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		return null; // not found
	}
	/**
	 * Recursive method to determine whether node or statement with given name attribute is found, meaning both objects are attached to same scene graph.
	 * @param nameValue is value of the name field being searched for in this element and child elements(if any)
	 * @param elementName identifies the element of interest (meta MetadataString ProtoDeclare CADassembly ProtoInstance HAnimHumanoid etc.)
	 * @see #findElementByNameValue(String, String)
	 * @return whether node is found
	 */
	public boolean hasElementByNameValue(String nameValue, String elementName)
	{
		return (findElementByNameValue(nameValue, elementName) != null);
	}

	/**
	 * Recursive method to provide object reference to node by DEF, if found as this node or in a contained node.
	 * <br ><br >
	 * <i>WARNING:</i> more than one element may be found that has the same DEF, this method does not handle that case.
	 * @param DEFvalue is value of the name field being searched for in this element and child elements(if any)
	 * @return object reference to found node, null otherwise
	 * @see #findElementByNameValue(String)
	 */
	@Override
	public X3DConcreteNode findNodeByDEF(String DEFvalue)
	{
		if ((DEFvalue == null) || DEFvalue.isEmpty())
		{
			String errorNotice = "findNodeByDEF(\"\") cannot use empty string to find a name";
			validationResult.append(errorNotice).append("\n");
			throw new org.web3d.x3d.sai.InvalidFieldValueException(errorNotice);
		}
		if (getDEF().equals(DEFvalue))
			return this;
		X3DConcreteNode referenceNode;
		if (material != null)
		{
			referenceNode = ((X3DConcreteElement) material).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		if (metadata != null)
		{
			referenceNode = ((X3DConcreteElement) metadata).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		if (surfaceNormals != null)
		{
			referenceNode = ((X3DConcreteElement) surfaceNormals).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		return null; // not found
	}
	/**
	 * Recursive method to determine whether node with DEFvalue is found, meaning both objects are attached to same scene graph.
	 * @param DEFvalue is value of the name field being searched for in this element and child elements(if any)
	 * @see #findNodeByDEF(String)
	 * @return whether node is found
	 */
	public boolean hasNodeByDEF(String DEFvalue)
	{
		return (findNodeByDEF(DEFvalue) != null);
	}

		
	/**
	 * Recursive method to validate this element plus all contained nodes and statements.
	 * @return validation results (if any)
	 */
	@Override
	public String validate()
	{
		validationResult = new StringBuilder(); // prepare for updated results

		setEnabled(getEnabled()); // exercise field checks, simple types

		setLighting(getLighting()); // exercise field checks, simple types

		setPhaseFunction(getPhaseFunction()); // exercise field checks, simple types

		setShadows(getShadows()); // exercise field checks, simple types

		if (!isUSE()) // be careful! setting DEF via setDEF() method will reset USE value
			setDEF(getDEF()); // exercise field checks, simple types

		if (isUSE()) // be careful! setting USE via setUSE() method resets all attributes to default values and wipes out all children
			setUSE(getUSE()); // exercise field checks, simple types

		setCssClass(getCssClass()); // exercise field checks, simple types

		if (material != null)
		{
			setMaterial(getMaterial());
			((X3DConcreteElement) material).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) material).getValidationResult());
		}
		if (materialProtoInstance != null)
		{
			setMaterial(getMaterialProtoInstance());
			((X3DConcreteElement) materialProtoInstance).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) materialProtoInstance).getValidationResult());
		}
		if ((material != null) && (materialProtoInstance != null))
		{
			String errorNotice = "Internal X3DJSAIL error: incorrect handling of contained SFNode field, both material and materialProtoInstance are set simultaneously";
			validationResult.append(errorNotice);
			throw new InvalidProtoException(errorNotice); // report error
		}
		if (isUSE() && hasMaterial()) // test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained SFNode material";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained comments";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}

		if (metadata != null)
		{
			setMetadata(getMetadata());
			((X3DConcreteElement) metadata).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) metadata).getValidationResult());
		}
		if (metadataProtoInstance != null)
		{
			setMetadata(getMetadataProtoInstance());
			((X3DConcreteElement) metadataProtoInstance).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) metadataProtoInstance).getValidationResult());
		}
		if ((metadata != null) && (metadataProtoInstance != null))
		{
			String errorNotice = "Internal X3DJSAIL error: incorrect handling of contained SFNode field, both metadata and metadataProtoInstance are set simultaneously";
			validationResult.append(errorNotice);
			throw new InvalidProtoException(errorNotice); // report error
		}
		if (isUSE() && hasMetadata()) // test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained SFNode metadata";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained comments";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}

		if (surfaceNormals != null)
		{
			setSurfaceNormals(getSurfaceNormals());
			((X3DConcreteElement) surfaceNormals).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) surfaceNormals).getValidationResult());
		}
		if (surfaceNormalsProtoInstance != null)
		{
			setSurfaceNormals(getSurfaceNormalsProtoInstance());
			((X3DConcreteElement) surfaceNormalsProtoInstance).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) surfaceNormalsProtoInstance).getValidationResult());
		}
		if ((surfaceNormals != null) && (surfaceNormalsProtoInstance != null))
		{
			String errorNotice = "Internal X3DJSAIL error: incorrect handling of contained SFNode field, both surfaceNormals and surfaceNormalsProtoInstance are set simultaneously";
			validationResult.append(errorNotice);
			throw new InvalidProtoException(errorNotice); // report error
		}
		if (isUSE() && hasSurfaceNormals()) // test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained SFNode surfaceNormals";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "ShadedVolumeStyle USE='" + getUSE() + "' is not allowed to have contained comments";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}

		if (getIS() != null)
		{
			if (getIS().getConnectList().isEmpty())
			{
				String errorNotice = "IS statement present, but contains no connect statements";
				validationResult.append(errorNotice).append("\n");
				throw new InvalidProtoException(errorNotice); // report error
			}				
			// TODO also check that this node has ancestor ProtoBody, and that a field with same name also exists, so that IS is legal
		}
		if (!getContainerFieldOverride().isEmpty() &&
			!Arrays.asList(containerField_ALTERNATE_VALUES).contains(getContainerFieldOverride()))
		{
			String errorNotice = ConfigurationProperties.ERROR_ILLEGAL_VALUE + 
				": illegal value enountered, containerField='" + getContainerFieldOverride() +
				"' but allowed values are containerField_ALTERNATE_VALUES='" + 
				new MFStringObject(containerField_ALTERNATE_VALUES).toStringX3D() + "'.";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldException(errorNotice); // report error
		}
		return validationResult.toString();
	}
}

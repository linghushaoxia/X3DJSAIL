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

package org.web3d.x3d.jsail.Lighting;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.fields.*; // making sure #4
import org.web3d.x3d.sai.Lighting.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;

/**
 * Linear attenuation may occur at level 2, full support at level 3.
 * 
 * <br><br>
 * <i>X3D node tooltip</i>:  SpotLight is a light source that illuminates geometry within a conical beam. Light illuminates all geometry and is normally scoped to illuminate peers and children nodes within the scene graph hierarchy Lights have no visible shape themselves and shine through occluding geometry. 
 * <ul>
 *  <li> <i> Hint:</i>   HeadLight enabled on/off is controlled by NavigationInfo.  </li> 
 * </ul> * Note that {@linkplain SFColorObject#ALICEBLUE SFColorObject} also provides a variety of color constants.
 * <br><br>

 * <br>
 * <i>Package hint:</i>  This org.web3d.x3d.jsail concrete class is used for implementing a standalone X3D object as a Plain Old Java Object (POJO).
 * If you are writing Java code for use inside an X3D Script node, compile using the <i>org.web3d.x3d.sai</i> package instead.
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/lighting.html#SpotLight" target="blank">X3D Abstract Specification: SpotLight</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#SpotLight" target="_blank">X3D Tooltips: SpotLight</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public class SpotLightObject extends org.web3d.x3d.jsail.X3DConcreteNode implements org.web3d.x3d.sai.Lighting.SpotLight
{
	private ArrayList<String> commentsList; // provided since no children array present

	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private float ambientIntensity;

	private float[] attenuation;

	private float beamWidth;

	private float[] color;

	private float cutOffAngle;

	private float[] direction;

	private boolean global;

	private float intensity;

	private float[] location;

	private X3DMetadataObject metadata; // acceptable node types: X3DMetadataObject
	private ProtoInstanceObject metadataProtoInstance; // allowed alternative for metadata field

	private boolean on;

	private float radius;

	/** IS/connect statements might be used if this node is within a ProtoBody and connections are defined between prototype fields and built-in node fields */
	private ISObject IS;

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>SpotLight</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "SpotLight";

	/** Provides name of this element: SpotLight.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** SFFloat field named <i>ambientIntensity</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float AMBIENTINTENSITY_DEFAULT_VALUE = 0f;

	/** SFVec3f field named <i>attenuation</i> has default value <i>{1f,0f,0f}</i> (Java syntax) or <i>1 0 0</i> (XML syntax). */
	public static final float[] ATTENUATION_DEFAULT_VALUE = {1f,0f,0f};

	/** SFFloat field named <i>beamWidth</i> has default value <i>0.7854f</i> (Java syntax) or <i>0.7854</i> (XML syntax). */
	public static final float BEAMWIDTH_DEFAULT_VALUE = 0.7854f;

	/** SFColor field named <i>color</i> has default value <i>{1f,1f,1f}</i> (Java syntax) or <i>1 1 1</i> (XML syntax). */
	public static final float[] COLOR_DEFAULT_VALUE = {1f,1f,1f};

	/** SFFloat field named <i>cutOffAngle</i> has default value <i>1.570796f</i> (Java syntax) or <i>1.570796</i> (XML syntax). */
	public static final float CUTOFFANGLE_DEFAULT_VALUE = 1.570796f;

	/** SFVec3f field named <i>direction</i> has default value <i>{0f,0f,-1f}</i> (Java syntax) or <i>0 0 -1</i> (XML syntax). */
	public static final float[] DIRECTION_DEFAULT_VALUE = {0f,0f,-1f};

	/** SFBool field named <i>global</i> has default value <i>true</i> (Java syntax) or <i>true</i> (XML syntax). */
	public static final boolean GLOBAL_DEFAULT_VALUE = true;

	/** SFFloat field named <i>intensity</i> has default value <i>1f</i> (Java syntax) or <i>1</i> (XML syntax). */
	public static final float INTENSITY_DEFAULT_VALUE = 1f;

	/** SFVec3f field named <i>location</i> has default value <i>{0f,0f,0f}</i> (Java syntax) or <i>0 0 0</i> (XML syntax). */
	public static final float[] LOCATION_DEFAULT_VALUE = {0f,0f,0f};

	/** SFBool field named <i>on</i> has default value <i>true</i> (Java syntax) or <i>true</i> (XML syntax). */
	public static final boolean ON_DEFAULT_VALUE = true;

	/** SFFloat field named <i>radius</i> has default value <i>100f</i> (Java syntax) or <i>100</i> (XML syntax). */
	public static final float RADIUS_DEFAULT_VALUE = 100f;

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
			case "ambientIntensity":
				result = "SFFloat";
				break;
			case "attenuation":
				result = "SFVec3f";
				break;
			case "beamWidth":
				result = "SFFloat";
				break;
			case "color":
				result = "SFColor";
				break;
			case "cutOffAngle":
				result = "SFFloat";
				break;
			case "direction":
				result = "SFVec3f";
				break;
			case "global":
				result = "SFBool";
				break;
			case "intensity":
				result = "SFFloat";
				break;
			case "location":
				result = "SFVec3f";
				break;
			case "metadata":
				result = "SFNode";
				break;
			case "on":
				result = "SFBool";
				break;
			case "radius":
				result = "SFFloat";
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
			case "ambientIntensity":
				result = "inputOutput";
				break;
			case "attenuation":
				result = "inputOutput";
				break;
			case "beamWidth":
				result = "inputOutput";
				break;
			case "color":
				result = "inputOutput";
				break;
			case "cutOffAngle":
				result = "inputOutput";
				break;
			case "direction":
				result = "inputOutput";
				break;
			case "global":
				result = "inputOutput";
				break;
			case "intensity":
				result = "inputOutput";
				break;
			case "location":
				result = "inputOutput";
				break;
			case "metadata":
				result = "inputOutput";
				break;
			case "on":
				result = "inputOutput";
				break;
			case "radius":
				result = "initializeOnly";
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
	String containerField_DEFAULT_VALUE = "children";

	// String constants for field names usable in ROUTE statements

	/** fromField ROUTE name for SFFloat field named <i>ambientIntensity</i>. */
	public static final String fromField_AMBIENTINTENSITY = "ambientIntensity";

	/** toField ROUTE name for SFFloat field named <i>ambientIntensity</i>. */
	public static final String toField_AMBIENTINTENSITY = "ambientIntensity";

	/** fromField ROUTE name for SFVec3f field named <i>attenuation</i>. */
	public static final String fromField_ATTENUATION = "attenuation";

	/** toField ROUTE name for SFVec3f field named <i>attenuation</i>. */
	public static final String toField_ATTENUATION = "attenuation";

	/** fromField ROUTE name for SFFloat field named <i>beamWidth</i>. */
	public static final String fromField_BEAMWIDTH = "beamWidth";

	/** toField ROUTE name for SFFloat field named <i>beamWidth</i>. */
	public static final String toField_BEAMWIDTH = "beamWidth";

	/** fromField ROUTE name for SFColor field named <i>color</i>. */
	public static final String fromField_COLOR = "color";

	/** toField ROUTE name for SFColor field named <i>color</i>. */
	public static final String toField_COLOR = "color";

	/** fromField ROUTE name for SFFloat field named <i>cutOffAngle</i>. */
	public static final String fromField_CUTOFFANGLE = "cutOffAngle";

	/** toField ROUTE name for SFFloat field named <i>cutOffAngle</i>. */
	public static final String toField_CUTOFFANGLE = "cutOffAngle";

	/** fromField ROUTE name for SFVec3f field named <i>direction</i>. */
	public static final String fromField_DIRECTION = "direction";

	/** toField ROUTE name for SFVec3f field named <i>direction</i>. */
	public static final String toField_DIRECTION = "direction";

	/** fromField ROUTE name for SFBool field named <i>global</i>. */
	public static final String fromField_GLOBAL = "global";

	/** toField ROUTE name for SFBool field named <i>global</i>. */
	public static final String toField_GLOBAL = "global";

	/** fromField ROUTE name for SFFloat field named <i>intensity</i>. */
	public static final String fromField_INTENSITY = "intensity";

	/** toField ROUTE name for SFFloat field named <i>intensity</i>. */
	public static final String toField_INTENSITY = "intensity";

	/** fromField ROUTE name for SFVec3f field named <i>location</i>. */
	public static final String fromField_LOCATION = "location";

	/** toField ROUTE name for SFVec3f field named <i>location</i>. */
	public static final String toField_LOCATION = "location";

	/** fromField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String fromField_METADATA = "metadata";

	/** toField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String toField_METADATA = "metadata";

	/** fromField ROUTE name for SFBool field named <i>on</i>. */
	public static final String fromField_ON = "on";

	/** toField ROUTE name for SFBool field named <i>on</i>. */
	public static final String toField_ON = "on";

	/** Constructor for SpotLightObject to initialize member variables with default values. */
	public SpotLightObject()
	{
		super(); // constructor invocation and corresponding initialize()
		initialize();
	}

	/** Initialize all member variables to default values. */
	@Override
	public final void initialize()
	{
		super.initialize();

		containerField_ALTERNATE_VALUES = new String[] { "children" };

		ambientIntensity = AMBIENTINTENSITY_DEFAULT_VALUE;
		attenuation = ATTENUATION_DEFAULT_VALUE;
		beamWidth = BEAMWIDTH_DEFAULT_VALUE;
		color = COLOR_DEFAULT_VALUE;
		cutOffAngle = CUTOFFANGLE_DEFAULT_VALUE;
		direction = DIRECTION_DEFAULT_VALUE;
		global = GLOBAL_DEFAULT_VALUE;
		intensity = INTENSITY_DEFAULT_VALUE;
		location = LOCATION_DEFAULT_VALUE;
		metadata = null; // clear out any prior node
		on = ON_DEFAULT_VALUE;
		radius = RADIUS_DEFAULT_VALUE;

		commentsList = new ArrayList<>(); // instantiate
	}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>ambientIntensity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] Brightness of ambient (nondirectional background) emission from the light.
	 * @return value of ambientIntensity field
	 */
	@Override
	public float getAmbientIntensity()
	{
		return ambientIntensity;
	}

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>ambientIntensity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] Brightness of ambient (nondirectional background) emission from the light.
	 * @param newValue is new value for the ambientIntensity field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setAmbientIntensity(float newValue)
	{
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if (newValue < 0f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight ambientIntensity newValue=" + newValue + " has component value less than restriction minInclusive=0");
  }
  if (newValue > 1f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight ambientIntensity newValue=" + SFFloatObject.toString(newValue) + " has component value greater than (or equal to) restriction maxInclusive=1");
  }
		ambientIntensity = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat ambientIntensity field, similar to {@link #setAmbientIntensity(float)}.
	 * @param newValue is new value for the ambientIntensity field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setAmbientIntensity(SFFloatObject newValue)
	{
		setAmbientIntensity(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of 3-tuple float results within allowed range of [0,infinity) from inputOutput SFVec3f field named <i>attenuation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Constant, linear-distance and squared-distance dropoff factors.
	 * @return value of attenuation field
	 */
	@Override
	public float[] getAttenuation()
	{
		return attenuation;
	}

	/**
	 * Assign 3-tuple float array within allowed range of [0,infinity) to inputOutput SFVec3f field named <i>attenuation</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Constant, linear-distance and squared-distance dropoff factors.
	 * @param newValue is new value for the attenuation field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setAttenuation(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight attenuation newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if ((newValue[0] < 0) || (newValue[1] < 0) || (newValue[2] < 0)) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight attenuation newValue=" + newValue + " has component value less than restriction minInclusive=0");
  }
		attenuation = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f attenuation field, similar to {@link #setAttenuation(float[])}.
	 * @param newValue is new value for the attenuation field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setAttenuation(SFVec3fObject newValue)
	{
		setAttenuation(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f attenuation field, similar to {@link #setAttenuation(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setAttenuation(float x, float y, float z)
	{
		setAttenuation(new float[] {x, y, z});
		return this;
	}
	/**
	 * Provide float value within allowed range of (0,1.570796] from inputOutput SFFloat field named <i>beamWidth</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1.570796] Inner conical solid angle (in radians) where light source has uniform full intensity. Hint: beamWidth is inner angle of full intensity, cutOffAngle is outer angle of zero intensity. Therefore set beamWidth &lt;= cutOffAngle. Warning: if beamWidth &gt; cutOffAngle, then beamWidth reset to equal cutOffAngle.
	 * @return value of beamWidth field
	 */
	@Override
	public float getBeamWidth()
	{
		return beamWidth;
	}

	/**
	 * Assign float value within allowed range of (0,1.570796] to inputOutput SFFloat field named <i>beamWidth</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1.570796] Inner conical solid angle (in radians) where light source has uniform full intensity. Hint: beamWidth is inner angle of full intensity, cutOffAngle is outer angle of zero intensity. Therefore set beamWidth &lt;= cutOffAngle. Warning: if beamWidth &gt; cutOffAngle, then beamWidth reset to equal cutOffAngle.
	 * @param newValue is new value for the beamWidth field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setBeamWidth(float newValue)
	{
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if (newValue <= 0f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight beamWidth newValue=" + newValue + " has component value less than (or equal to) restriction minExclusive=0");
  }
  if (newValue > 1.570796f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight beamWidth newValue=" + SFFloatObject.toString(newValue) + " has component value greater than (or equal to) restriction maxInclusive=1.570796");
  }
		beamWidth = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat beamWidth field, similar to {@link #setBeamWidth(float)}.
	 * @param newValue is new value for the beamWidth field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setBeamWidth(SFFloatObject newValue)
	{
		setBeamWidth(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of 3-tuple float results using RGB values [0..1] using RGB values [0..1] from inputOutput SFColor field named <i>color</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] color of light, applied to colors of objects. Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @return value of color field
	 */
	@Override
	public float[] getColor()
	{
		return color;
	}

	/**
	 * Assign 3-tuple float array using RGB values [0..1] using RGB values [0..1] to inputOutput SFColor field named <i>color</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] color of light, applied to colors of objects. Hint: X3D Scene Authoring Hints, Color http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Color.
	 * @param newValue is new value for the color field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setColor(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight color newValue=" + SFColorObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		color = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFColor color field, similar to {@link #setColor(float[])}.
	 * @param newValue is new value for the color field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setColor(SFColorObject newValue)
	{
		setColor(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFColor color field, similar to {@link #setColor(float[])}.

	 * @param red first component
	 * @param green second component
	 * @param blue third component

	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setColor(float red, float green, float blue)
	{
		setColor(new float[] {red, green, blue});
		return this;
	}
	/**
	 * Provide float value unit axis, angle (in radians) within allowed range of (0,1.570796] from inputOutput SFFloat field named <i>cutOffAngle</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1.570796] Outer conical solid angle (in radians) where light source intensity becomes zero. Hint: beamWidth is inner angle of full intensity, cutOffAngle is outer angle of zero intensity. Therefore set beamWidth &lt;= cutOffAngle. Warning: if beamWidth &gt; cutOffAngle, then beamWidth reset to equal cutOffAngle.
	 * @return value of cutOffAngle field
	 */
	@Override
	public float getCutOffAngle()
	{
		return cutOffAngle;
	}

	/**
	 * Assign float value unit axis, angle (in radians) within allowed range of (0,1.570796] to inputOutput SFFloat field named <i>cutOffAngle</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1.570796] Outer conical solid angle (in radians) where light source intensity becomes zero. Hint: beamWidth is inner angle of full intensity, cutOffAngle is outer angle of zero intensity. Therefore set beamWidth &lt;= cutOffAngle. Warning: if beamWidth &gt; cutOffAngle, then beamWidth reset to equal cutOffAngle.
	 * @param newValue is new value for the cutOffAngle field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setCutOffAngle(float newValue)
	{
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if (newValue <= 0f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight cutOffAngle newValue=" + newValue + " has component value less than (or equal to) restriction minExclusive=0");
  }
  if (newValue > 1.570796f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight cutOffAngle newValue=" + SFFloatObject.toString(newValue) + " has component value greater than (or equal to) restriction maxInclusive=1.570796");
  }
		cutOffAngle = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat cutOffAngle field, similar to {@link #setCutOffAngle(float)}.
	 * @param newValue is new value for the cutOffAngle field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setCutOffAngle(SFFloatObject newValue)
	{
		setCutOffAngle(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>direction</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation vector of light relative to local coordinate system.
	 * @return value of direction field
	 */
	@Override
	public float[] getDirection()
	{
		return direction;
	}

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>direction</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Orientation vector of light relative to local coordinate system.
	 * @param newValue is new value for the direction field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setDirection(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight direction newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		direction = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f direction field, similar to {@link #setDirection(float[])}.
	 * @param newValue is new value for the direction field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setDirection(SFVec3fObject newValue)
	{
		setDirection(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f direction field, similar to {@link #setDirection(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setDirection(float x, float y, float z)
	{
		setDirection(new float[] {x, y, z});
		return this;
	}
	/**
	 * Provide boolean value from inputOutput SFBool field named <i>global</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (X3D version 3.1 or later) Global lights illuminate all objects within their volume of lighting influence. Scoped lights only illuminate objects within the same transformation hierarchy.
	 * @return value of global field
	 */
	@Override
	public boolean getGlobal()
	{
		return global;
	}

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>global</i>.
	 * <br><br>
	 * <i>Tooltip:</i> (X3D version 3.1 or later) Global lights illuminate all objects within their volume of lighting influence. Scoped lights only illuminate objects within the same transformation hierarchy.
	 * @param newValue is new value for the global field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setGlobal(boolean newValue)
	{
		global = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool global field, similar to {@link #setGlobal(boolean)}.
	 * @param newValue is new value for the global field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setGlobal(SFBoolObject newValue)
	{
		setGlobal(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value within allowed range of [0,1] from inputOutput SFFloat field named <i>intensity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] Brightness of direct emission from the light.
	 * @return value of intensity field
	 */
	@Override
	public float getIntensity()
	{
		return intensity;
	}

	/**
	 * Assign float value within allowed range of [0,1] to inputOutput SFFloat field named <i>intensity</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] Brightness of direct emission from the light.
	 * @param newValue is new value for the intensity field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setIntensity(float newValue)
	{
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if (newValue < 0f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight intensity newValue=" + newValue + " has component value less than restriction minInclusive=0");
  }
  if (newValue > 1f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight intensity newValue=" + SFFloatObject.toString(newValue) + " has component value greater than (or equal to) restriction maxInclusive=1");
  }
		intensity = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat intensity field, similar to {@link #setIntensity(float)}.
	 * @param newValue is new value for the intensity field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setIntensity(SFFloatObject newValue)
	{
		setIntensity(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>location</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position of light relative to local coordinate system.
	 * @return value of location field
	 */
	@Override
	public float[] getLocation()
	{
		return location;
	}

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>location</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Position of light relative to local coordinate system.
	 * @param newValue is new value for the location field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setLocation(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight location newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		location = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f location field, similar to {@link #setLocation(float[])}.
	 * @param newValue is new value for the location field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setLocation(SFVec3fObject newValue)
	{
		setLocation(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f location field, similar to {@link #setLocation(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setLocation(float x, float y, float z)
	{
		setLocation(new float[] {x, y, z});
		return this;
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setMetadata(X3DMetadataObject newValue)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public SpotLightObject clearMetadata()
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public SpotLightObject setMetadata(ProtoInstanceObject newProtoInstanceNode)
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
	 * Provide boolean value from inputOutput SFBool field named <i>on</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables this light source.
	 * @return value of on field
	 */
	@Override
	public boolean getOn()
	{
		return on;
	}

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>on</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Enables/disables this light source.
	 * @param newValue is new value for the on field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setOn(boolean newValue)
	{
		on = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool on field, similar to {@link #setOn(boolean)}.
	 * @param newValue is new value for the on field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setOn(SFBoolObject newValue)
	{
		setOn(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value within allowed range of [0,infinity) from initializeOnly SFFloat field named <i>radius</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Maximum effective distance of light relative to local light position, affected by ancestor scaling.
	 * @return value of radius field
	 */
	@Override
	public float getRadius()
	{
		return radius;
	}

	/**
	 * Assign float value within allowed range of [0,infinity) to initializeOnly SFFloat field named <i>radius</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Maximum effective distance of light relative to local light position, affected by ancestor scaling.
	 * @param newValue is new value for the radius field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setRadius(float newValue)
	{
  // Check that newValue parameter has legal value(s) before assigning to scene graph
  if (newValue < 0f) {
    throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight radius newValue=" + newValue + " has component value less than restriction minInclusive=0");
  }
		radius = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat radius field, similar to {@link #setRadius(float)}.
	 * @param newValue is new value for the radius field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setRadius(SFFloatObject newValue)
	{
		setRadius(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final SpotLightObject setDEF(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to SpotLight
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight DEF newValue='" + newValue + "'" + 
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setDEF(SFStringObject newValue)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final SpotLightObject setUSE(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to SpotLight
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("SpotLight USE newValue='" + newValue + "'" + 
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setUSE(SFStringObject newValue)
	{
		setUSE(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final SpotLightObject setCssClass(String newValue)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setCssClass(SFStringObject newValue)
	{
		setCssClass(newValue.getPrimitiveValue());
		return this;
	}

	// Additional utility methods for this class ==============================

	/**
	 * Utility constructor that assigns DEF name after initializing member variables with default values
	 * @param DEFname unique DEF name for this X3D node
	 */
	public SpotLightObject (String DEFname)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public SpotLightObject setIS(ISObject newValue)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SpotLightObject setUSE(SpotLightObject DEFnode)
	{
		if (DEFnode.getDEF().isEmpty())
		{
			String errorNotice = "setUSE(DEFnode) invoked on SpotLightObject" +
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SpotLightObject addComments (String newComment)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SpotLightObject addComments (String[] newComments)
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
	 * @return {@link SpotLightObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SpotLightObject addComments (CommentsBlock newCommentsBlock)
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
		boolean      hasChild = (IS != null) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();

		if (isUSE())
			hasChild = false; // USE nodes only include attributes for USE and non-default containerField
		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(indent).append("<SpotLight"); // start opening tag
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
			
			if (((getAmbientIntensity() != AMBIENTINTENSITY_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" ambientIntensity='").append(SFFloatObject.toString(getAmbientIntensity())).append("'");
			}
			if ((!Arrays.equals(getAttenuation(), ATTENUATION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" attenuation='").append(SFVec3fObject.toString(getAttenuation())).append("'");
			}
			if (((getBeamWidth() != BEAMWIDTH_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" beamWidth='").append(SFFloatObject.toString(getBeamWidth())).append("'");
			}
			if ((!Arrays.equals(getColor(), COLOR_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" color='").append(SFColorObject.toString(getColor())).append("'");
			}
			if (((getCutOffAngle() != CUTOFFANGLE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" cutOffAngle='").append(SFFloatObject.toString(getCutOffAngle())).append("'");
			}
			if ((!Arrays.equals(getDirection(), DIRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" direction='").append(SFVec3fObject.toString(getDirection())).append("'");
			}
			if (((getGlobal() != GLOBAL_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" global='").append(SFBoolObject.toString(getGlobal())).append("'");
			}
			if (((getIntensity() != INTENSITY_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" intensity='").append(SFFloatObject.toString(getIntensity())).append("'");
			}
			if ((!Arrays.equals(getLocation(), LOCATION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" location='").append(SFVec3fObject.toString(getLocation())).append("'");
			}
			if (((getOn() != ON_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" on='").append(SFBoolObject.toString(getOn())).append("'");
			}
			if (((getRadius() != RADIUS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" radius='").append(SFFloatObject.toString(getRadius())).append("'");
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

			// recursively iterate over child element
			if      (metadata != null)
			{
				stringX3D.append(((X3DConcreteElement)metadata).toStringX3D(level + indentIncrement));
			}
			else if (metadataProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)metadataProtoInstance).toStringX3D(level + indentIncrement));
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringX3D.append(commentsBlock.toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</SpotLight>").append("\n"); // finish closing tag
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
		boolean      hasChild = (IS != null) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();
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
			stringClassicVRML.append("SpotLight").append(" { "); // define node name, node content follows

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
						if (element.getNodeField().equals("ambientIntensity"))
						{
							stringClassicVRML.append(indentCharacter).append("ambientIntensity").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getAmbientIntensity() != AMBIENTINTENSITY_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("ambientIntensity ").append(SFFloatObject.toString(getAmbientIntensity())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("attenuation"))
						{
							stringClassicVRML.append(indentCharacter).append("attenuation").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getAttenuation(), ATTENUATION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("attenuation ").append(SFVec3fObject.toString(getAttenuation())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("beamWidth"))
						{
							stringClassicVRML.append(indentCharacter).append("beamWidth").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getBeamWidth() != BEAMWIDTH_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("beamWidth ").append(SFFloatObject.toString(getBeamWidth())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("color"))
						{
							stringClassicVRML.append(indentCharacter).append("color").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getColor(), COLOR_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("color ").append(SFColorObject.toString(getColor())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("cutOffAngle"))
						{
							stringClassicVRML.append(indentCharacter).append("cutOffAngle").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getCutOffAngle() != CUTOFFANGLE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("cutOffAngle ").append(SFFloatObject.toString(getCutOffAngle())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("direction"))
						{
							stringClassicVRML.append(indentCharacter).append("direction").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getDirection(), DIRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("direction ").append(SFVec3fObject.toString(getDirection())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("global"))
						{
							stringClassicVRML.append(indentCharacter).append("global").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getGlobal() != GLOBAL_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("global ").append(SFBoolObject.toString(getGlobal())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("intensity"))
						{
							stringClassicVRML.append(indentCharacter).append("intensity").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getIntensity() != INTENSITY_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("intensity ").append(SFFloatObject.toString(getIntensity())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("location"))
						{
							stringClassicVRML.append(indentCharacter).append("location").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getLocation(), LOCATION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("location ").append(SFVec3fObject.toString(getLocation())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("on"))
						{
							stringClassicVRML.append(indentCharacter).append("on").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getOn() != ON_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("on ").append(SFBoolObject.toString(getOn())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("radius"))
						{
							stringClassicVRML.append(indentCharacter).append("radius").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getRadius() != RADIUS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("radius ").append(SFFloatObject.toString(getRadius())).append("\n").append(indent).append(indentCharacter);
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
			// recursively iterate over child element
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

		if (metadata != null)
		{
			referenceNode = ((X3DConcreteNode) metadata).getNodeByDEF(DEFname); // SFNode
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
		if (metadata != null)
		{
			referenceNode = ((X3DConcreteElement) metadata).findNodeByDEF(DEFvalue);
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

		setAmbientIntensity(getAmbientIntensity()); // exercise field checks, simple types

		setAttenuation(getAttenuation()); // exercise field checks, simple types

		setBeamWidth(getBeamWidth()); // exercise field checks, simple types

		setColor(getColor()); // exercise field checks, simple types

		setCutOffAngle(getCutOffAngle()); // exercise field checks, simple types

		setDirection(getDirection()); // exercise field checks, simple types

		setGlobal(getGlobal()); // exercise field checks, simple types

		setIntensity(getIntensity()); // exercise field checks, simple types

		setLocation(getLocation()); // exercise field checks, simple types

		setOn(getOn()); // exercise field checks, simple types

		setRadius(getRadius()); // exercise field checks, simple types

		if (!isUSE()) // be careful! setting DEF via setDEF() method will reset USE value
			setDEF(getDEF()); // exercise field checks, simple types

		if (isUSE()) // be careful! setting USE via setUSE() method resets all attributes to default values and wipes out all children
			setUSE(getUSE()); // exercise field checks, simple types

		setCssClass(getCssClass()); // exercise field checks, simple types

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
			String errorNotice = "SpotLight USE='" + getUSE() + "' is not allowed to have contained SFNode metadata";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "SpotLight USE='" + getUSE() + "' is not allowed to have contained comments";
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

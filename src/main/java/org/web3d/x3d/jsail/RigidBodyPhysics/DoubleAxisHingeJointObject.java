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

package org.web3d.x3d.jsail.RigidBodyPhysics;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.fields.*; // making sure #4
import org.web3d.x3d.sai.RigidBodyPhysics.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.RigidBodyPhysics.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.RigidBodyPhysics.*;
import org.web3d.x3d.sai.RigidBodyPhysics.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;

/**
 * <i>X3D node tooltip</i>:  (X3D version 3.2 or later) DoubleAxisHingeJoint has two independent axes located around a common anchor point. axis1 has limits and a motor, axis 2 only has a motor Contains two RigidBody nodes (containerField values body1, body2). 
 * <ul>
 *  <li> <i> Hint:</i>   RigidBodyPhysics component, level 2.  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This org.web3d.x3d.jsail concrete class is used for implementing a standalone X3D object as a Plain Old Java Object (POJO).
 * If you are writing Java code for use inside an X3D Script node, compile using the <i>org.web3d.x3d.sai</i> package instead.
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/rigid_physics.html#DoubleAxisHingeJoint" target="blank">X3D Abstract Specification: DoubleAxisHingeJoint</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#DoubleAxisHingeJoint" target="_blank">X3D Tooltips: DoubleAxisHingeJoint</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public class DoubleAxisHingeJointObject extends org.web3d.x3d.jsail.X3DConcreteNode implements org.web3d.x3d.sai.RigidBodyPhysics.DoubleAxisHingeJoint
{
	private ArrayList<String> commentsList; // provided since no children array present

	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private float[] anchorPoint;

	private float[] axis1;

	private float[] axis2;

	private RigidBody body1; // acceptable node types: RigidBody
	private ProtoInstanceObject body1ProtoInstance; // allowed alternative for body1 field

	private float[] body1AnchorPoint;

	private float[] body1Axis;

	private RigidBody body2; // acceptable node types: RigidBody
	private ProtoInstanceObject body2ProtoInstance; // allowed alternative for body2 field

	private float[] body2AnchorPoint;

	private float[] body2Axis;

	private float desiredAngularVelocity1;

	private float desiredAngularVelocity2;

	private ArrayList<String> forceOutput = new ArrayList<>();

	private float hinge1Angle;

	private float hinge1AngleRate;

	private float hinge2Angle;

	private float hinge2AngleRate;

	private float maxAngle1;

	private float maxTorque1;

	private float maxTorque2;

	private X3DMetadataObject metadata; // acceptable node types: X3DMetadataObject
	private ProtoInstanceObject metadataProtoInstance; // allowed alternative for metadata field

	private float minAngle1;

	private float stop1Bounce;

	private float stop1ConstantForceMix;

	private float stop1ErrorCorrection;

	private float suspensionErrorCorrection;

	private float suspensionForce;

	/** IS/connect statements might be used if this node is within a ProtoBody and connections are defined between prototype fields and built-in node fields */
	private ISObject IS;

	// ==== String constants for enumeration values ensure correct syntax and avoid run-time errors ====

	/** MFString field named <i>forceOutput</i> is an array that can include this quoted enumeration value <i>new String[] {"ALL"}</i> (Java syntax) or <i>'"ALL"'</i> (XML syntax). */
	public static final ArrayList<String> FORCEOUTPUT_ALL = new ArrayList<>(Arrays.asList("ALL"));

	/** MFString field named <i>forceOutput</i> is an array that can include this quoted enumeration value <i>new String[] {"NONE"}</i> (Java syntax) or <i>'"NONE"'</i> (XML syntax). */
	public static final ArrayList<String> FORCEOUTPUT_NONE = new ArrayList<>(Arrays.asList("NONE"));

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>DoubleAxisHingeJoint</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "DoubleAxisHingeJoint";

	/** Provides name of this element: DoubleAxisHingeJoint.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** SFVec3f field named <i>anchorPoint</i> has default value <i>{0f,0f,0f}</i> (Java syntax) or <i>0 0 0</i> (XML syntax). */
	public static final float[] ANCHORPOINT_DEFAULT_VALUE = {0f,0f,0f};

	/** SFVec3f field named <i>axis1</i> has default value <i>{0f,0f,0f}</i> (Java syntax) or <i>0 0 0</i> (XML syntax). */
	public static final float[] AXIS1_DEFAULT_VALUE = {0f,0f,0f};

	/** SFVec3f field named <i>axis2</i> has default value <i>{0f,0f,0f}</i> (Java syntax) or <i>0 0 0</i> (XML syntax). */
	public static final float[] AXIS2_DEFAULT_VALUE = {0f,0f,0f};

	/** SFFloat field named <i>desiredAngularVelocity1</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float DESIREDANGULARVELOCITY1_DEFAULT_VALUE = 0f;

	/** SFFloat field named <i>desiredAngularVelocity2</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float DESIREDANGULARVELOCITY2_DEFAULT_VALUE = 0f;

	/** MFString field named <i>forceOutput</i> has default quoted value <i>new String[] {"NONE"}</i> (Java syntax) or quoted value <i>"NONE"</i> (XML syntax). */
	public static final ArrayList<String> FORCEOUTPUT_DEFAULT_VALUE = new ArrayList<>(Arrays.asList("NONE"));

	/** SFFloat field named <i>maxAngle1</i> has default value <i>3.141592653f</i> (Java syntax) or <i>3.141592653</i> (XML syntax). */
	public static final float MAXANGLE1_DEFAULT_VALUE = 3.141592653f;

	/** SFFloat field named <i>maxTorque1</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float MAXTORQUE1_DEFAULT_VALUE = 0f;

	/** SFFloat field named <i>maxTorque2</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float MAXTORQUE2_DEFAULT_VALUE = 0f;

	/** SFFloat field named <i>minAngle1</i> has default value <i>-3.141592653f</i> (Java syntax) or <i>-3.141592653</i> (XML syntax). */
	public static final float MINANGLE1_DEFAULT_VALUE = -3.141592653f;

	/** SFFloat field named <i>stop1Bounce</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float STOP1BOUNCE_DEFAULT_VALUE = 0f;

	/** SFFloat field named <i>stop1ConstantForceMix</i> has default value <i>0.001f</i> (Java syntax) or <i>0.001</i> (XML syntax). */
	public static final float STOP1CONSTANTFORCEMIX_DEFAULT_VALUE = 0.001f;

	/** SFFloat field named <i>stop1ErrorCorrection</i> has default value <i>0.8f</i> (Java syntax) or <i>0.8</i> (XML syntax). */
	public static final float STOP1ERRORCORRECTION_DEFAULT_VALUE = 0.8f;

	/** SFFloat field named <i>suspensionErrorCorrection</i> has default value <i>0.8f</i> (Java syntax) or <i>0.8</i> (XML syntax). */
	public static final float SUSPENSIONERRORCORRECTION_DEFAULT_VALUE = 0.8f;

	/** SFFloat field named <i>suspensionForce</i> has default value <i>0f</i> (Java syntax) or <i>0</i> (XML syntax). */
	public static final float SUSPENSIONFORCE_DEFAULT_VALUE = 0f;

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
			case "anchorPoint":
				result = "SFVec3f";
				break;
			case "axis1":
				result = "SFVec3f";
				break;
			case "axis2":
				result = "SFVec3f";
				break;
			case "body1":
				result = "SFNode";
				break;
			case "body1AnchorPoint":
				result = "SFVec3f";
				break;
			case "body1Axis":
				result = "SFVec3f";
				break;
			case "body2":
				result = "SFNode";
				break;
			case "body2AnchorPoint":
				result = "SFVec3f";
				break;
			case "body2Axis":
				result = "SFVec3f";
				break;
			case "desiredAngularVelocity1":
				result = "SFFloat";
				break;
			case "desiredAngularVelocity2":
				result = "SFFloat";
				break;
			case "forceOutput":
				result = "MFString";
				break;
			case "hinge1Angle":
				result = "SFFloat";
				break;
			case "hinge1AngleRate":
				result = "SFFloat";
				break;
			case "hinge2Angle":
				result = "SFFloat";
				break;
			case "hinge2AngleRate":
				result = "SFFloat";
				break;
			case "maxAngle1":
				result = "SFFloat";
				break;
			case "maxTorque1":
				result = "SFFloat";
				break;
			case "maxTorque2":
				result = "SFFloat";
				break;
			case "metadata":
				result = "SFNode";
				break;
			case "minAngle1":
				result = "SFFloat";
				break;
			case "stop1Bounce":
				result = "SFFloat";
				break;
			case "stop1ConstantForceMix":
				result = "SFFloat";
				break;
			case "stop1ErrorCorrection":
				result = "SFFloat";
				break;
			case "suspensionErrorCorrection":
				result = "SFFloat";
				break;
			case "suspensionForce":
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
			case "anchorPoint":
				result = "inputOutput";
				break;
			case "axis1":
				result = "inputOutput";
				break;
			case "axis2":
				result = "inputOutput";
				break;
			case "body1":
				result = "inputOutput";
				break;
			case "body1AnchorPoint":
				result = "outputOnly";
				break;
			case "body1Axis":
				result = "outputOnly";
				break;
			case "body2":
				result = "inputOutput";
				break;
			case "body2AnchorPoint":
				result = "outputOnly";
				break;
			case "body2Axis":
				result = "outputOnly";
				break;
			case "desiredAngularVelocity1":
				result = "inputOutput";
				break;
			case "desiredAngularVelocity2":
				result = "inputOutput";
				break;
			case "forceOutput":
				result = "inputOutput";
				break;
			case "hinge1Angle":
				result = "outputOnly";
				break;
			case "hinge1AngleRate":
				result = "outputOnly";
				break;
			case "hinge2Angle":
				result = "outputOnly";
				break;
			case "hinge2AngleRate":
				result = "outputOnly";
				break;
			case "maxAngle1":
				result = "inputOutput";
				break;
			case "maxTorque1":
				result = "inputOutput";
				break;
			case "maxTorque2":
				result = "inputOutput";
				break;
			case "metadata":
				result = "inputOutput";
				break;
			case "minAngle1":
				result = "inputOutput";
				break;
			case "stop1Bounce":
				result = "inputOutput";
				break;
			case "stop1ConstantForceMix":
				result = "inputOutput";
				break;
			case "stop1ErrorCorrection":
				result = "inputOutput";
				break;
			case "suspensionErrorCorrection":
				result = "inputOutput";
				break;
			case "suspensionForce":
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
	String containerField_DEFAULT_VALUE = "joints";

	// String constants for field names usable in ROUTE statements

	/** fromField ROUTE name for SFVec3f field named <i>anchorPoint</i>. */
	public static final String fromField_ANCHORPOINT = "anchorPoint";

	/** toField ROUTE name for SFVec3f field named <i>anchorPoint</i>. */
	public static final String toField_ANCHORPOINT = "anchorPoint";

	/** fromField ROUTE name for SFVec3f field named <i>axis1</i>. */
	public static final String fromField_AXIS1 = "axis1";

	/** toField ROUTE name for SFVec3f field named <i>axis1</i>. */
	public static final String toField_AXIS1 = "axis1";

	/** fromField ROUTE name for SFVec3f field named <i>axis2</i>. */
	public static final String fromField_AXIS2 = "axis2";

	/** toField ROUTE name for SFVec3f field named <i>axis2</i>. */
	public static final String toField_AXIS2 = "axis2";

	/** fromField ROUTE name for SFNode field named <i>body1</i>. */
	public static final String fromField_BODY1 = "body1";

	/** toField ROUTE name for SFNode field named <i>body1</i>. */
	public static final String toField_BODY1 = "body1";

	/** fromField ROUTE name for SFVec3f field named <i>body1AnchorPoint</i>. */
	public static final String fromField_BODY1ANCHORPOINT = "body1AnchorPoint";

	/** fromField ROUTE name for SFVec3f field named <i>body1Axis</i>. */
	public static final String fromField_BODY1AXIS = "body1Axis";

	/** fromField ROUTE name for SFNode field named <i>body2</i>. */
	public static final String fromField_BODY2 = "body2";

	/** toField ROUTE name for SFNode field named <i>body2</i>. */
	public static final String toField_BODY2 = "body2";

	/** fromField ROUTE name for SFVec3f field named <i>body2AnchorPoint</i>. */
	public static final String fromField_BODY2ANCHORPOINT = "body2AnchorPoint";

	/** fromField ROUTE name for SFVec3f field named <i>body2Axis</i>. */
	public static final String fromField_BODY2AXIS = "body2Axis";

	/** fromField ROUTE name for SFFloat field named <i>desiredAngularVelocity1</i>. */
	public static final String fromField_DESIREDANGULARVELOCITY1 = "desiredAngularVelocity1";

	/** toField ROUTE name for SFFloat field named <i>desiredAngularVelocity1</i>. */
	public static final String toField_DESIREDANGULARVELOCITY1 = "desiredAngularVelocity1";

	/** fromField ROUTE name for SFFloat field named <i>desiredAngularVelocity2</i>. */
	public static final String fromField_DESIREDANGULARVELOCITY2 = "desiredAngularVelocity2";

	/** toField ROUTE name for SFFloat field named <i>desiredAngularVelocity2</i>. */
	public static final String toField_DESIREDANGULARVELOCITY2 = "desiredAngularVelocity2";

	/** fromField ROUTE name for MFString field named <i>forceOutput</i>. */
	public static final String fromField_FORCEOUTPUT = "forceOutput";

	/** toField ROUTE name for MFString field named <i>forceOutput</i>. */
	public static final String toField_FORCEOUTPUT = "forceOutput";

	/** fromField ROUTE name for SFFloat field named <i>hinge1Angle</i>. */
	public static final String fromField_HINGE1ANGLE = "hinge1Angle";

	/** fromField ROUTE name for SFFloat field named <i>hinge1AngleRate</i>. */
	public static final String fromField_HINGE1ANGLERATE = "hinge1AngleRate";

	/** fromField ROUTE name for SFFloat field named <i>hinge2Angle</i>. */
	public static final String fromField_HINGE2ANGLE = "hinge2Angle";

	/** fromField ROUTE name for SFFloat field named <i>hinge2AngleRate</i>. */
	public static final String fromField_HINGE2ANGLERATE = "hinge2AngleRate";

	/** fromField ROUTE name for SFFloat field named <i>maxAngle1</i>. */
	public static final String fromField_MAXANGLE1 = "maxAngle1";

	/** toField ROUTE name for SFFloat field named <i>maxAngle1</i>. */
	public static final String toField_MAXANGLE1 = "maxAngle1";

	/** fromField ROUTE name for SFFloat field named <i>maxTorque1</i>. */
	public static final String fromField_MAXTORQUE1 = "maxTorque1";

	/** toField ROUTE name for SFFloat field named <i>maxTorque1</i>. */
	public static final String toField_MAXTORQUE1 = "maxTorque1";

	/** fromField ROUTE name for SFFloat field named <i>maxTorque2</i>. */
	public static final String fromField_MAXTORQUE2 = "maxTorque2";

	/** toField ROUTE name for SFFloat field named <i>maxTorque2</i>. */
	public static final String toField_MAXTORQUE2 = "maxTorque2";

	/** fromField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String fromField_METADATA = "metadata";

	/** toField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String toField_METADATA = "metadata";

	/** fromField ROUTE name for SFFloat field named <i>minAngle1</i>. */
	public static final String fromField_MINANGLE1 = "minAngle1";

	/** toField ROUTE name for SFFloat field named <i>minAngle1</i>. */
	public static final String toField_MINANGLE1 = "minAngle1";

	/** fromField ROUTE name for SFFloat field named <i>stop1Bounce</i>. */
	public static final String fromField_STOP1BOUNCE = "stop1Bounce";

	/** toField ROUTE name for SFFloat field named <i>stop1Bounce</i>. */
	public static final String toField_STOP1BOUNCE = "stop1Bounce";

	/** fromField ROUTE name for SFFloat field named <i>stop1ConstantForceMix</i>. */
	public static final String fromField_STOP1CONSTANTFORCEMIX = "stop1ConstantForceMix";

	/** toField ROUTE name for SFFloat field named <i>stop1ConstantForceMix</i>. */
	public static final String toField_STOP1CONSTANTFORCEMIX = "stop1ConstantForceMix";

	/** fromField ROUTE name for SFFloat field named <i>stop1ErrorCorrection</i>. */
	public static final String fromField_STOP1ERRORCORRECTION = "stop1ErrorCorrection";

	/** toField ROUTE name for SFFloat field named <i>stop1ErrorCorrection</i>. */
	public static final String toField_STOP1ERRORCORRECTION = "stop1ErrorCorrection";

	/** fromField ROUTE name for SFFloat field named <i>suspensionErrorCorrection</i>. */
	public static final String fromField_SUSPENSIONERRORCORRECTION = "suspensionErrorCorrection";

	/** toField ROUTE name for SFFloat field named <i>suspensionErrorCorrection</i>. */
	public static final String toField_SUSPENSIONERRORCORRECTION = "suspensionErrorCorrection";

	/** fromField ROUTE name for SFFloat field named <i>suspensionForce</i>. */
	public static final String fromField_SUSPENSIONFORCE = "suspensionForce";

	/** toField ROUTE name for SFFloat field named <i>suspensionForce</i>. */
	public static final String toField_SUSPENSIONFORCE = "suspensionForce";

	/** Constructor for DoubleAxisHingeJointObject to initialize member variables with default values. */
	public DoubleAxisHingeJointObject()
	{
		super(); // constructor invocation and corresponding initialize()
		initialize();
	}

	/** Initialize all member variables to default values. */
	@Override
	public final void initialize()
	{
		super.initialize();

		containerField_ALTERNATE_VALUES = new String[] { "joints" };

		anchorPoint = ANCHORPOINT_DEFAULT_VALUE;
		axis1 = AXIS1_DEFAULT_VALUE;
		axis2 = AXIS2_DEFAULT_VALUE;
		body1 = null; // clear out any prior node
		body2 = null; // clear out any prior node
		desiredAngularVelocity1 = DESIREDANGULARVELOCITY1_DEFAULT_VALUE;
		desiredAngularVelocity2 = DESIREDANGULARVELOCITY2_DEFAULT_VALUE;
		forceOutput = FORCEOUTPUT_DEFAULT_VALUE;
		maxAngle1 = MAXANGLE1_DEFAULT_VALUE;
		maxTorque1 = MAXTORQUE1_DEFAULT_VALUE;
		maxTorque2 = MAXTORQUE2_DEFAULT_VALUE;
		metadata = null; // clear out any prior node
		minAngle1 = MINANGLE1_DEFAULT_VALUE;
		stop1Bounce = STOP1BOUNCE_DEFAULT_VALUE;
		stop1ConstantForceMix = STOP1CONSTANTFORCEMIX_DEFAULT_VALUE;
		stop1ErrorCorrection = STOP1ERRORCORRECTION_DEFAULT_VALUE;
		suspensionErrorCorrection = SUSPENSIONERRORCORRECTION_DEFAULT_VALUE;
		suspensionForce = SUSPENSIONFORCE_DEFAULT_VALUE;

		commentsList = new ArrayList<>(); // instantiate
	}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>anchorPoint</i>.
	 * <br><br>
	 * <i>Tooltip:</i> anchorPoint is joint center, specified in world coordinates.
	 * @return value of anchorPoint field
	 */
	@Override
	public float[] getAnchorPoint()
	{
		return anchorPoint;
	}

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>anchorPoint</i>.
	 * <br><br>
	 * <i>Tooltip:</i> anchorPoint is joint center, specified in world coordinates.
	 * @param newValue is new value for the anchorPoint field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setAnchorPoint(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("DoubleAxisHingeJoint anchorPoint newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		anchorPoint = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f anchorPoint field, similar to {@link #setAnchorPoint(float[])}.
	 * @param newValue is new value for the anchorPoint field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAnchorPoint(SFVec3fObject newValue)
	{
		setAnchorPoint(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f anchorPoint field, similar to {@link #setAnchorPoint(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAnchorPoint(float x, float y, float z)
	{
		setAnchorPoint(new float[] {x, y, z});
		return this;
	}
	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>axis1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> axis1 defines axis vector of joint connection to body1. Hint: 0 0 0 means motor disabled.
	 * @return value of axis1 field
	 */
	@Override
	public float[] getAxis1()
	{
		return axis1;
	}

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>axis1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> axis1 defines axis vector of joint connection to body1. Hint: 0 0 0 means motor disabled.
	 * @param newValue is new value for the axis1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setAxis1(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("DoubleAxisHingeJoint axis1 newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		axis1 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f axis1 field, similar to {@link #setAxis1(float[])}.
	 * @param newValue is new value for the axis1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAxis1(SFVec3fObject newValue)
	{
		setAxis1(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f axis1 field, similar to {@link #setAxis1(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAxis1(float x, float y, float z)
	{
		setAxis1(new float[] {x, y, z});
		return this;
	}
	/**
	 * Provide array of 3-tuple float results from inputOutput SFVec3f field named <i>axis2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> axis2 defines axis vector of joint connection to body2. Hint: 0 0 0 means motor disabled.
	 * @return value of axis2 field
	 */
	@Override
	public float[] getAxis2()
	{
		return axis2;
	}

	/**
	 * Assign 3-tuple float array to inputOutput SFVec3f field named <i>axis2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> axis2 defines axis vector of joint connection to body2. Hint: 0 0 0 means motor disabled.
	 * @param newValue is new value for the axis2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setAxis2(float[] newValue)
	{
		if (newValue == null)
			newValue = new float[0];
		// Check that newValue parameter has legal size before assigning to scene graph
		if (newValue.length != 3) // 3-tuple check
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("DoubleAxisHingeJoint axis2 newValue=" + SFVec3fObject.toString(newValue) + " has length=" + newValue.length + " instead of required length 3");
		}
		axis2 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFVec3f axis2 field, similar to {@link #setAxis2(float[])}.
	 * @param newValue is new value for the axis2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAxis2(SFVec3fObject newValue)
	{
		setAxis2(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign values to SFVec3f axis2 field, similar to {@link #setAxis2(float[])}.

	 * @param x first component
	 * @param y second component
	 * @param z third component

	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setAxis2(float x, float y, float z)
	{
		setAxis2(new float[] {x, y, z});
		return this;
	}
	/**
	 * Provide RigidBody instance (using a properly typed node) from inputOutput SFNode field <i>body1</i>.
	 * @see #getBody1ProtoInstance()
	 * @return value of body1 field
	 */
	@Override
	public RigidBody getBody1()
	{
		return body1;
	}

	/**
	 * Assign RigidBody instance (using a properly typed node) to inputOutput SFNode field <i>body1</i>.
	 * @see #setBody1(ProtoInstanceObject)
	 * @param newValue is new value for the body1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setBody1(RigidBody newValue)
	{
		body1 = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) body1).setParentObject(this); // parentTest15
		}
		if (body1ProtoInstance != null)
		{
			body1ProtoInstance.setParentObject(null); // housekeeping, clear prior object
			body1ProtoInstance = null;
		}

		return this;
	}

	/**
	 * Utility method to clear SFNode value of body1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public DoubleAxisHingeJointObject clearBody1()
	{
		((X3DConcreteElement) body1).clearParentObject(); // remove references to facilitate Java memory management
		body1 = null; // reset SFNode field
		return this;
	}
	/**
	 * Assign ProtoInstance to <i>body1</i> field;

	 * <i>WARNING:</i> ProtoInstance must match acceptable node type RigidBody.
	 * @param newProtoInstanceNode is the new ProtoInstance node for the body1 field
	 * @see #setBody1(RigidBody)
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public DoubleAxisHingeJointObject setBody1(ProtoInstanceObject newProtoInstanceNode)
	{
		if (body1 != null)
		{
			((X3DConcreteElement) body1).setParentObject(null); // housekeeping, clear prior object
			body1 = null;
		}
		body1ProtoInstance = newProtoInstanceNode;
		if (newProtoInstanceNode != null)
		{
			newProtoInstanceNode.setParentObject(this);
		}
		return this;
	}
	/**
	 * Provide properly typed ProtoInstance for inputOutput SFNode field <i>body1</i>, if available.
	 * @see #getBody1()
	 * @return ProtoInstance value of geometry field
	 */
	public ProtoInstanceObject getBody1ProtoInstance()
	{
		return body1ProtoInstance;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>body1</i>.
	 * @return whether a properly typed node or ProtoInstance or CommentsBlock is available.
	 * @see #getBody1()
	 * @see #getBody1ProtoInstance()
	 */
	public boolean hasBody1()
	{
		return (body1 != null) || (body1ProtoInstance != null);
	}
	/**
	 * Provide array of 3-tuple float results from outputOnly SFVec3f field named <i>body1AnchorPoint</i>.
	 * @return value of body1AnchorPoint field
	 */
	@Override
	public float[] getBody1AnchorPoint()
	{
		return body1AnchorPoint;
	}
	/**
	 * Provide array of 3-tuple float results from outputOnly SFVec3f field named <i>body1Axis</i>.
	 * @return value of body1Axis field
	 */
	@Override
	public float[] getBody1Axis()
	{
		return body1Axis;
	}
	/**
	 * Provide RigidBody instance (using a properly typed node) from inputOutput SFNode field <i>body2</i>.
	 * @see #getBody2ProtoInstance()
	 * @return value of body2 field
	 */
	@Override
	public RigidBody getBody2()
	{
		return body2;
	}

	/**
	 * Assign RigidBody instance (using a properly typed node) to inputOutput SFNode field <i>body2</i>.
	 * @see #setBody2(ProtoInstanceObject)
	 * @param newValue is new value for the body2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setBody2(RigidBody newValue)
	{
		body2 = newValue;
		if (newValue != null)
		{
			((X3DConcreteElement) body2).setParentObject(this); // parentTest15
		}
		if (body2ProtoInstance != null)
		{
			body2ProtoInstance.setParentObject(null); // housekeeping, clear prior object
			body2ProtoInstance = null;
		}

		return this;
	}

	/**
	 * Utility method to clear SFNode value of body2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public DoubleAxisHingeJointObject clearBody2()
	{
		((X3DConcreteElement) body2).clearParentObject(); // remove references to facilitate Java memory management
		body2 = null; // reset SFNode field
		return this;
	}
	/**
	 * Assign ProtoInstance to <i>body2</i> field;

	 * <i>WARNING:</i> ProtoInstance must match acceptable node type RigidBody.
	 * @param newProtoInstanceNode is the new ProtoInstance node for the body2 field
	 * @see #setBody2(RigidBody)
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public DoubleAxisHingeJointObject setBody2(ProtoInstanceObject newProtoInstanceNode)
	{
		if (body2 != null)
		{
			((X3DConcreteElement) body2).setParentObject(null); // housekeeping, clear prior object
			body2 = null;
		}
		body2ProtoInstance = newProtoInstanceNode;
		if (newProtoInstanceNode != null)
		{
			newProtoInstanceNode.setParentObject(this);
		}
		return this;
	}
	/**
	 * Provide properly typed ProtoInstance for inputOutput SFNode field <i>body2</i>, if available.
	 * @see #getBody2()
	 * @return ProtoInstance value of geometry field
	 */
	public ProtoInstanceObject getBody2ProtoInstance()
	{
		return body2ProtoInstance;
	}

	/**
	 * Indicate whether an object is available for inputOutput SFNode field <i>body2</i>.
	 * @return whether a properly typed node or ProtoInstance or CommentsBlock is available.
	 * @see #getBody2()
	 * @see #getBody2ProtoInstance()
	 */
	public boolean hasBody2()
	{
		return (body2 != null) || (body2ProtoInstance != null);
	}
	/**
	 * Provide array of 3-tuple float results from outputOnly SFVec3f field named <i>body2AnchorPoint</i>.
	 * @return value of body2AnchorPoint field
	 */
	@Override
	public float[] getBody2AnchorPoint()
	{
		return body2AnchorPoint;
	}
	/**
	 * Provide array of 3-tuple float results from outputOnly SFVec3f field named <i>body2Axis</i>.
	 * @return value of body2Axis field
	 */
	@Override
	public float[] getBody2Axis()
	{
		return body2Axis;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>desiredAngularVelocity1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> desiredAngularVelocity1 is goal rotation rate for hinge connection to body1.
	 * @return value of desiredAngularVelocity1 field
	 */
	@Override
	public float getDesiredAngularVelocity1()
	{
		return desiredAngularVelocity1;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>desiredAngularVelocity1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> desiredAngularVelocity1 is goal rotation rate for hinge connection to body1.
	 * @param newValue is new value for the desiredAngularVelocity1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setDesiredAngularVelocity1(float newValue)
	{
		desiredAngularVelocity1 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat desiredAngularVelocity1 field, similar to {@link #setDesiredAngularVelocity1(float)}.
	 * @param newValue is new value for the desiredAngularVelocity1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setDesiredAngularVelocity1(SFFloatObject newValue)
	{
		setDesiredAngularVelocity1(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>desiredAngularVelocity2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> desiredAngularVelocity2 is goal rotation rate for hinge connection to body2.
	 * @return value of desiredAngularVelocity2 field
	 */
	@Override
	public float getDesiredAngularVelocity2()
	{
		return desiredAngularVelocity2;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>desiredAngularVelocity2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> desiredAngularVelocity2 is goal rotation rate for hinge connection to body2.
	 * @param newValue is new value for the desiredAngularVelocity2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setDesiredAngularVelocity2(float newValue)
	{
		desiredAngularVelocity2 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat desiredAngularVelocity2 field, similar to {@link #setDesiredAngularVelocity2(float)}.
	 * @param newValue is new value for the desiredAngularVelocity2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setDesiredAngularVelocity2(SFFloatObject newValue)
	{
		setDesiredAngularVelocity2(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of String enumeration results ['"ALL"'|'"NONE"'|'"etc."'] from inputOutput MFString field named <i>forceOutput</i>.
	 * <br><br>
	 * <i>Tooltip:</i> forceOutput controls which output fields are generated for the next frame. Values are ALL, NONE, or exact names of output fields updated at start of next frame.
	 * <br><br>
	 * Available enumeration values for string comparison: {@link #FORCEOUTPUT_ALL ALL}, {@link #FORCEOUTPUT_NONE NONE}.
	 * @return value of forceOutput field
	 */
	@Override
	public String[] getForceOutput()
	{
		final String[] valuesArray = new String[forceOutput.size()];
		int i = 0;
		for (String arrayElement : forceOutput) {
			valuesArray[i++] = arrayElement;
		}
		return valuesArray;
	}
	/**
	 * Utility method to get ArrayList value of MFString forceOutput field, similar to {@link #getForceOutput()}.

	 * @return value of forceOutput field
	 */
	public ArrayList<String> getForceOutputList()
	{
		return forceOutput;
	}

	/**
	 * Assign String enumeration array (""ALL""|""NONE"") ['"ALL"'|'"NONE"'|'"etc."'] to inputOutput MFString field named <i>forceOutput</i>.
	 * <br><br>
	 * <i>Hint:</i> authors have option to choose from an extendible list of predefined enumeration values ({@link #FORCEOUTPUT_ALL ALL}, {@link #FORCEOUTPUT_NONE NONE}).
	 * <br><br>
	 * <i>Tooltip:</i> forceOutput controls which output fields are generated for the next frame. Values are ALL, NONE, or exact names of output fields updated at start of next frame.
	 * @param newValue is new value for the forceOutput field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setForceOutput(String[] newValue)
	{
		if (newValue == null)
		{
			clearForceOutput(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		forceOutput.clear(); // reset
		for (int i = 0; i < newValue.length; i++)
		{
			forceOutput.add(newValue[i]);
		}

		return this;
	}

	/**
	 * Assign typed object value to MFString forceOutput field, similar to {@link #setForceOutput(String[])}.
	 * @param newValue is new value for the forceOutput field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setForceOutput(MFStringObject newValue)
	{
		if (newValue == null)
		{
			clearForceOutput(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		setForceOutput(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Assign single SFString object value to MFString forceOutput field, similar to {@link #setForceOutput(String[])}.
	 * @param newValue is new value for the forceOutput field.
	 * @see MFStringObject#cleanupEnumerationValues(String)
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setForceOutput(SFStringObject newValue)
	{
		if (newValue == null)
		{
			clearForceOutput(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		setForceOutput(MFStringObject.cleanupEnumerationValues(newValue.toString())); // enumeration values
		return this;
	}
	/**
	 * Assign singleton String value to MFString forceOutput field, similar to {@link #setForceOutput(String[])}.
	 * @param newValue is new value for the forceOutput field.
	 * @see MFStringObject#cleanupEnumerationValues(String)
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setForceOutput(String newValue)
	{
		if (newValue == null)
		{
			clearForceOutput(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		setForceOutput(MFStringObject.cleanupEnumerationValues(newValue)); // enumeration values
		return this;
	}
	/**
	 * Assign ArrayList value of MFString forceOutput field, similar to {@link #setForceOutput(String[])}.
	 * @param newValue is new value for the forceOutput field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setForceOutput(ArrayList<String> newValue)
	{
		if (newValue == null)
		{
			clearForceOutput(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		forceOutput = newValue;
		return this;
	}
	/**
	 * Utility method to clear MFString value of forceOutput field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public DoubleAxisHingeJointObject clearForceOutput()
	{
		forceOutput.clear(); // reset
		return this;
	}
	/**
	 * Provide float value unit axis, angle (in radians) from outputOnly SFFloat field named <i>hinge1Angle</i>.
	 * @return value of hinge1Angle field
	 */
	@Override
	public float getHinge1Angle()
	{
		return hinge1Angle;
	}
	/**
	 * Provide float value unit axis, angle (in radians) from outputOnly SFFloat field named <i>hinge1AngleRate</i>.
	 * @return value of hinge1AngleRate field
	 */
	@Override
	public float getHinge1AngleRate()
	{
		return hinge1AngleRate;
	}
	/**
	 * Provide float value unit axis, angle (in radians) from outputOnly SFFloat field named <i>hinge2Angle</i>.
	 * @return value of hinge2Angle field
	 */
	@Override
	public float getHinge2Angle()
	{
		return hinge2Angle;
	}
	/**
	 * Provide float value unit axis, angle (in radians) from outputOnly SFFloat field named <i>hinge2AngleRate</i>.
	 * @return value of hinge2AngleRate field
	 */
	@Override
	public float getHinge2AngleRate()
	{
		return hinge2AngleRate;
	}
	/**
	 * Provide float value unit axis, angle (in radians) from inputOutput SFFloat field named <i>maxAngle1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [-π,π] maxAngle1 is maximum rotation angle for hinge.
	 * @return value of maxAngle1 field
	 */
	@Override
	public float getMaxAngle1()
	{
		return maxAngle1;
	}

	/**
	 * Assign float value unit axis, angle (in radians) to inputOutput SFFloat field named <i>maxAngle1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [-π,π] maxAngle1 is maximum rotation angle for hinge.
	 * @param newValue is new value for the maxAngle1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setMaxAngle1(float newValue)
	{
		maxAngle1 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat maxAngle1 field, similar to {@link #setMaxAngle1(float)}.
	 * @param newValue is new value for the maxAngle1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setMaxAngle1(SFFloatObject newValue)
	{
		setMaxAngle1(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>maxTorque1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> maxTorque1 is maximum rotational torque applied by corresponding motor axis to achieve desiredAngularVelocity1.
	 * @return value of maxTorque1 field
	 */
	@Override
	public float getMaxTorque1()
	{
		return maxTorque1;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>maxTorque1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> maxTorque1 is maximum rotational torque applied by corresponding motor axis to achieve desiredAngularVelocity1.
	 * @param newValue is new value for the maxTorque1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setMaxTorque1(float newValue)
	{
		maxTorque1 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat maxTorque1 field, similar to {@link #setMaxTorque1(float)}.
	 * @param newValue is new value for the maxTorque1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setMaxTorque1(SFFloatObject newValue)
	{
		setMaxTorque1(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>maxTorque2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> maxTorque2 is maximum rotational torque applied by corresponding motor axis to achieve desiredAngularVelocity2.
	 * @return value of maxTorque2 field
	 */
	@Override
	public float getMaxTorque2()
	{
		return maxTorque2;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>maxTorque2</i>.
	 * <br><br>
	 * <i>Tooltip:</i> maxTorque2 is maximum rotational torque applied by corresponding motor axis to achieve desiredAngularVelocity2.
	 * @param newValue is new value for the maxTorque2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setMaxTorque2(float newValue)
	{
		maxTorque2 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat maxTorque2 field, similar to {@link #setMaxTorque2(float)}.
	 * @param newValue is new value for the maxTorque2 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setMaxTorque2(SFFloatObject newValue)
	{
		setMaxTorque2(newValue.getPrimitiveValue());
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setMetadata(X3DMetadataObject newValue)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public DoubleAxisHingeJointObject clearMetadata()
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public DoubleAxisHingeJointObject setMetadata(ProtoInstanceObject newProtoInstanceNode)
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
	 * Provide float value unit axis, angle (in radians) from inputOutput SFFloat field named <i>minAngle1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [-π,π] minAngle1 is minimum rotation angle for hinge.
	 * @return value of minAngle1 field
	 */
	@Override
	public float getMinAngle1()
	{
		return minAngle1;
	}

	/**
	 * Assign float value unit axis, angle (in radians) to inputOutput SFFloat field named <i>minAngle1</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [-π,π] minAngle1 is minimum rotation angle for hinge.
	 * @param newValue is new value for the minAngle1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setMinAngle1(float newValue)
	{
		minAngle1 = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat minAngle1 field, similar to {@link #setMinAngle1(float)}.
	 * @param newValue is new value for the minAngle1 field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setMinAngle1(SFFloatObject newValue)
	{
		setMinAngle1(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>stop1Bounce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1Bounce is velocity factor for bounce back once stop point is reached. Hint: 0 means no bounce, 1 means return velocity matches.
	 * @return value of stop1Bounce field
	 */
	@Override
	public float getStop1Bounce()
	{
		return stop1Bounce;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>stop1Bounce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1Bounce is velocity factor for bounce back once stop point is reached. Hint: 0 means no bounce, 1 means return velocity matches.
	 * @param newValue is new value for the stop1Bounce field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setStop1Bounce(float newValue)
	{
		stop1Bounce = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat stop1Bounce field, similar to {@link #setStop1Bounce(float)}.
	 * @param newValue is new value for the stop1Bounce field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setStop1Bounce(SFFloatObject newValue)
	{
		setStop1Bounce(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>stop1ConstantForceMix</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1ConstantForceMix value applies a constant force value to make colliding surfaces appear to be somewhat soft. Hint: use with suspensionForce to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @return value of stop1ConstantForceMix field
	 */
	@Override
	public float getStop1ConstantForceMix()
	{
		return stop1ConstantForceMix;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>stop1ConstantForceMix</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1ConstantForceMix value applies a constant force value to make colliding surfaces appear to be somewhat soft. Hint: use with suspensionForce to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @param newValue is new value for the stop1ConstantForceMix field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setStop1ConstantForceMix(float newValue)
	{
		stop1ConstantForceMix = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat stop1ConstantForceMix field, similar to {@link #setStop1ConstantForceMix(float)}.
	 * @param newValue is new value for the stop1ConstantForceMix field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setStop1ConstantForceMix(SFFloatObject newValue)
	{
		setStop1ConstantForceMix(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>stop1ErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1ErrorCorrection is fraction of error correction performed during time step once stop point is reached. Hint: 0 means no error correction, 1 means all error corrected in single step.
	 * @return value of stop1ErrorCorrection field
	 */
	@Override
	public float getStop1ErrorCorrection()
	{
		return stop1ErrorCorrection;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>stop1ErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] stop1ErrorCorrection is fraction of error correction performed during time step once stop point is reached. Hint: 0 means no error correction, 1 means all error corrected in single step.
	 * @param newValue is new value for the stop1ErrorCorrection field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setStop1ErrorCorrection(float newValue)
	{
		stop1ErrorCorrection = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat stop1ErrorCorrection field, similar to {@link #setStop1ErrorCorrection(float)}.
	 * @param newValue is new value for the stop1ErrorCorrection field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setStop1ErrorCorrection(SFFloatObject newValue)
	{
		setStop1ErrorCorrection(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>suspensionErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] suspensionErrorCorrection describes how quickly the system resolves intersection errors due to floating-point inaccuracies. Hint: use with stop1ConstantForceMix to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @return value of suspensionErrorCorrection field
	 */
	@Override
	public float getSuspensionErrorCorrection()
	{
		return suspensionErrorCorrection;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>suspensionErrorCorrection</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] suspensionErrorCorrection describes how quickly the system resolves intersection errors due to floating-point inaccuracies. Hint: use with stop1ConstantForceMix to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @param newValue is new value for the suspensionErrorCorrection field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setSuspensionErrorCorrection(float newValue)
	{
		suspensionErrorCorrection = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat suspensionErrorCorrection field, similar to {@link #setSuspensionErrorCorrection(float)}.
	 * @param newValue is new value for the suspensionErrorCorrection field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setSuspensionErrorCorrection(SFFloatObject newValue)
	{
		setSuspensionErrorCorrection(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide float value from inputOutput SFFloat field named <i>suspensionForce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] suspensionForce describes how quickly the system resolves intersection errors due to floating-point inaccuracies. Hint: use with stop1ConstantForceMix to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @return value of suspensionForce field
	 */
	@Override
	public float getSuspensionForce()
	{
		return suspensionForce;
	}

	/**
	 * Assign float value to inputOutput SFFloat field named <i>suspensionForce</i>.
	 * <br><br>
	 * <i>Tooltip:</i> [0,1] suspensionForce describes how quickly the system resolves intersection errors due to floating-point inaccuracies. Hint: use with stop1ConstantForceMix to improve softness and numerical stability. Hint: 0 means no stop adjustment, 1 means springier stop response.
	 * @param newValue is new value for the suspensionForce field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setSuspensionForce(float newValue)
	{
		suspensionForce = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFFloat suspensionForce field, similar to {@link #setSuspensionForce(float)}.
	 * @param newValue is new value for the suspensionForce field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setSuspensionForce(SFFloatObject newValue)
	{
		setSuspensionForce(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final DoubleAxisHingeJointObject setDEF(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to DoubleAxisHingeJoint
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("DoubleAxisHingeJoint DEF newValue='" + newValue + "'" + 
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setDEF(SFStringObject newValue)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final DoubleAxisHingeJointObject setUSE(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to DoubleAxisHingeJoint
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("DoubleAxisHingeJoint USE newValue='" + newValue + "'" + 
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setUSE(SFStringObject newValue)
	{
		setUSE(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final DoubleAxisHingeJointObject setCssClass(String newValue)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setCssClass(SFStringObject newValue)
	{
		setCssClass(newValue.getPrimitiveValue());
		return this;
	}

	// Additional utility methods for this class ==============================

	/**
	 * Utility constructor that assigns DEF name after initializing member variables with default values
	 * @param DEFname unique DEF name for this X3D node
	 */
	public DoubleAxisHingeJointObject (String DEFname)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public DoubleAxisHingeJointObject setIS(ISObject newValue)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public DoubleAxisHingeJointObject setUSE(DoubleAxisHingeJointObject DEFnode)
	{
		if (DEFnode.getDEF().isEmpty())
		{
			String errorNotice = "setUSE(DEFnode) invoked on DoubleAxisHingeJointObject" +
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public DoubleAxisHingeJointObject addComments (String newComment)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public DoubleAxisHingeJointObject addComments (String[] newComments)
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
	 * @return {@link DoubleAxisHingeJointObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public DoubleAxisHingeJointObject addComments (CommentsBlock newCommentsBlock)
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
		boolean      hasChild = (IS != null) || (body1 != null) || (body1ProtoInstance != null) || (body2 != null) || (body2ProtoInstance != null) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();

		if (isUSE())
			hasChild = false; // USE nodes only include attributes for USE and non-default containerField
		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(indent).append("<DoubleAxisHingeJoint"); // start opening tag
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
			
			if ((!Arrays.equals(getAnchorPoint(), ANCHORPOINT_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" anchorPoint='").append(SFVec3fObject.toString(getAnchorPoint())).append("'");
			}
			if ((!Arrays.equals(getAxis1(), AXIS1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" axis1='").append(SFVec3fObject.toString(getAxis1())).append("'");
			}
			if ((!Arrays.equals(getAxis2(), AXIS2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" axis2='").append(SFVec3fObject.toString(getAxis2())).append("'");
			}
			if (((getDesiredAngularVelocity1() != DESIREDANGULARVELOCITY1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" desiredAngularVelocity1='").append(SFFloatObject.toString(getDesiredAngularVelocity1())).append("'");
			}
			if (((getDesiredAngularVelocity2() != DESIREDANGULARVELOCITY2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" desiredAngularVelocity2='").append(SFFloatObject.toString(getDesiredAngularVelocity2())).append("'");
			}
			if (((getForceOutput().length > 0) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" forceOutput='").append(new MFStringObject(getForceOutput()).toStringX3D()).append("'");
			}
			if (((getMaxAngle1() != MAXANGLE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" maxAngle1='").append(SFFloatObject.toString(getMaxAngle1())).append("'");
			}
			if (((getMaxTorque1() != MAXTORQUE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" maxTorque1='").append(SFFloatObject.toString(getMaxTorque1())).append("'");
			}
			if (((getMaxTorque2() != MAXTORQUE2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" maxTorque2='").append(SFFloatObject.toString(getMaxTorque2())).append("'");
			}
			if (((getMinAngle1() != MINANGLE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" minAngle1='").append(SFFloatObject.toString(getMinAngle1())).append("'");
			}
			if (((getStop1Bounce() != STOP1BOUNCE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" stop1Bounce='").append(SFFloatObject.toString(getStop1Bounce())).append("'");
			}
			if (((getStop1ConstantForceMix() != STOP1CONSTANTFORCEMIX_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" stop1ConstantForceMix='").append(SFFloatObject.toString(getStop1ConstantForceMix())).append("'");
			}
			if (((getStop1ErrorCorrection() != STOP1ERRORCORRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" stop1ErrorCorrection='").append(SFFloatObject.toString(getStop1ErrorCorrection())).append("'");
			}
			if (((getSuspensionErrorCorrection() != SUSPENSIONERRORCORRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" suspensionErrorCorrection='").append(SFFloatObject.toString(getSuspensionErrorCorrection())).append("'");
			}
			if (((getSuspensionForce() != SUSPENSIONFORCE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" suspensionForce='").append(SFFloatObject.toString(getSuspensionForce())).append("'");
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
			if      (body1 != null)
			{
				stringX3D.append(((X3DConcreteElement)body1).toStringX3D(level + indentIncrement));
			}
			else if (body1ProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)body1ProtoInstance).toStringX3D(level + indentIncrement));
			}
			if      (body2 != null)
			{
				stringX3D.append(((X3DConcreteElement)body2).toStringX3D(level + indentIncrement));
			}
			else if (body2ProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)body2ProtoInstance).toStringX3D(level + indentIncrement));
			}
			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringX3D.append(commentsBlock.toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</DoubleAxisHingeJoint>").append("\n"); // finish closing tag
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
		boolean      hasChild = (IS != null) || (body1 != null) || (body1ProtoInstance != null) || (body2 != null) || (body2ProtoInstance != null) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();
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
			stringClassicVRML.append("DoubleAxisHingeJoint").append(" { "); // define node name, node content follows

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
						if (element.getNodeField().equals("anchorPoint"))
						{
							stringClassicVRML.append(indentCharacter).append("anchorPoint").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getAnchorPoint(), ANCHORPOINT_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("anchorPoint ").append(SFVec3fObject.toString(getAnchorPoint())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("axis1"))
						{
							stringClassicVRML.append(indentCharacter).append("axis1").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getAxis1(), AXIS1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("axis1 ").append(SFVec3fObject.toString(getAxis1())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("axis2"))
						{
							stringClassicVRML.append(indentCharacter).append("axis2").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (!Arrays.equals(getAxis2(), AXIS2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("axis2 ").append(SFVec3fObject.toString(getAxis2())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("desiredAngularVelocity1"))
						{
							stringClassicVRML.append(indentCharacter).append("desiredAngularVelocity1").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getDesiredAngularVelocity1() != DESIREDANGULARVELOCITY1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("desiredAngularVelocity1 ").append(SFFloatObject.toString(getDesiredAngularVelocity1())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("desiredAngularVelocity2"))
						{
							stringClassicVRML.append(indentCharacter).append("desiredAngularVelocity2").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getDesiredAngularVelocity2() != DESIREDANGULARVELOCITY2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("desiredAngularVelocity2 ").append(SFFloatObject.toString(getDesiredAngularVelocity2())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("forceOutput"))
						{
							stringClassicVRML.append(indentCharacter).append("forceOutput").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (getForceOutput().length > 0)
				{
					stringClassicVRML.append("forceOutput ").append("[ ").append(MFStringObject.toString(getForceOutput())).append(" ]").append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("maxAngle1"))
						{
							stringClassicVRML.append(indentCharacter).append("maxAngle1").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getMaxAngle1() != MAXANGLE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("maxAngle1 ").append(SFFloatObject.toString(getMaxAngle1())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("maxTorque1"))
						{
							stringClassicVRML.append(indentCharacter).append("maxTorque1").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getMaxTorque1() != MAXTORQUE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("maxTorque1 ").append(SFFloatObject.toString(getMaxTorque1())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("maxTorque2"))
						{
							stringClassicVRML.append(indentCharacter).append("maxTorque2").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getMaxTorque2() != MAXTORQUE2_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("maxTorque2 ").append(SFFloatObject.toString(getMaxTorque2())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("minAngle1"))
						{
							stringClassicVRML.append(indentCharacter).append("minAngle1").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getMinAngle1() != MINANGLE1_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("minAngle1 ").append(SFFloatObject.toString(getMinAngle1())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("stop1Bounce"))
						{
							stringClassicVRML.append(indentCharacter).append("stop1Bounce").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getStop1Bounce() != STOP1BOUNCE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("stop1Bounce ").append(SFFloatObject.toString(getStop1Bounce())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("stop1ConstantForceMix"))
						{
							stringClassicVRML.append(indentCharacter).append("stop1ConstantForceMix").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getStop1ConstantForceMix() != STOP1CONSTANTFORCEMIX_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("stop1ConstantForceMix ").append(SFFloatObject.toString(getStop1ConstantForceMix())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("stop1ErrorCorrection"))
						{
							stringClassicVRML.append(indentCharacter).append("stop1ErrorCorrection").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getStop1ErrorCorrection() != STOP1ERRORCORRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("stop1ErrorCorrection ").append(SFFloatObject.toString(getStop1ErrorCorrection())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("suspensionErrorCorrection"))
						{
							stringClassicVRML.append(indentCharacter).append("suspensionErrorCorrection").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getSuspensionErrorCorrection() != SUSPENSIONERRORCORRECTION_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("suspensionErrorCorrection ").append(SFFloatObject.toString(getSuspensionErrorCorrection())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("suspensionForce"))
						{
							stringClassicVRML.append(indentCharacter).append("suspensionForce").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getSuspensionForce() != SUSPENSIONFORCE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("suspensionForce ").append(SFFloatObject.toString(getSuspensionForce())).append("\n").append(indent).append(indentCharacter);
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
			if (body1 != null)
			{
				stringClassicVRML.append(indentCharacter).append("body1").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) body1).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode
			}
			else if (body1ProtoInstance != null)
			{
				stringClassicVRML.append(indentCharacter).append("body1").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) body1ProtoInstance).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode ProtoInstance
			}
			if (body2 != null)
			{
				stringClassicVRML.append(indentCharacter).append("body2").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) body2).toStringClassicVRML(level + indentIncrement));
				stringClassicVRML.append(indent); // end SFNode
			}
			else if (body2ProtoInstance != null)
			{
				stringClassicVRML.append(indentCharacter).append("body2").append(" "); // containerField for SFNode
				stringClassicVRML.append(((X3DConcreteElement) body2ProtoInstance).toStringClassicVRML(level + indentIncrement));
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

		if (body1 != null)
		{
			referenceNode = ((X3DConcreteNode) body1).getNodeByDEF(DEFname); // SFNode
			if (referenceNode != null)
				return referenceNode;
		}
		if (body2 != null)
		{
			referenceNode = ((X3DConcreteNode) body2).getNodeByDEF(DEFname); // SFNode
			if (referenceNode != null)
				return referenceNode;
		}
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
		if (body1 != null)
		{
			referenceElement = ((X3DConcreteElement) body1).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (body1ProtoInstance != null)
		{
			referenceElement = ((X3DConcreteElement) body1ProtoInstance).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (body2 != null)
		{
			referenceElement = ((X3DConcreteElement) body2).findElementByNameValue(nameValue, elementName);
			if (referenceElement != null)
				return referenceElement;
		}
		if (body2ProtoInstance != null)
		{
			referenceElement = ((X3DConcreteElement) body2ProtoInstance).findElementByNameValue(nameValue, elementName);
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
		if (body1 != null)
		{
			referenceNode = ((X3DConcreteElement) body1).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
		if (body2 != null)
		{
			referenceNode = ((X3DConcreteElement) body2).findNodeByDEF(DEFvalue);
			if (referenceNode != null)
				return referenceNode;
		}
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

		setAnchorPoint(getAnchorPoint()); // exercise field checks, simple types

		setAxis1(getAxis1()); // exercise field checks, simple types

		setAxis2(getAxis2()); // exercise field checks, simple types

		setDesiredAngularVelocity1(getDesiredAngularVelocity1()); // exercise field checks, simple types

		setDesiredAngularVelocity2(getDesiredAngularVelocity2()); // exercise field checks, simple types

		setForceOutput(getForceOutput()); // exercise field checks, simple types

		setMaxAngle1(getMaxAngle1()); // exercise field checks, simple types

		setMaxTorque1(getMaxTorque1()); // exercise field checks, simple types

		setMaxTorque2(getMaxTorque2()); // exercise field checks, simple types

		setMinAngle1(getMinAngle1()); // exercise field checks, simple types

		setStop1Bounce(getStop1Bounce()); // exercise field checks, simple types

		setStop1ConstantForceMix(getStop1ConstantForceMix()); // exercise field checks, simple types

		setStop1ErrorCorrection(getStop1ErrorCorrection()); // exercise field checks, simple types

		setSuspensionErrorCorrection(getSuspensionErrorCorrection()); // exercise field checks, simple types

		setSuspensionForce(getSuspensionForce()); // exercise field checks, simple types

		if (!isUSE()) // be careful! setting DEF via setDEF() method will reset USE value
			setDEF(getDEF()); // exercise field checks, simple types

		if (isUSE()) // be careful! setting USE via setUSE() method resets all attributes to default values and wipes out all children
			setUSE(getUSE()); // exercise field checks, simple types

		setCssClass(getCssClass()); // exercise field checks, simple types

		if (body1 != null)
		{
			setBody1(getBody1());
			((X3DConcreteElement) body1).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) body1).getValidationResult());
		}
		if (body1ProtoInstance != null)
		{
			setBody1(getBody1ProtoInstance());
			((X3DConcreteElement) body1ProtoInstance).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) body1ProtoInstance).getValidationResult());
		}
		if ((body1 != null) && (body1ProtoInstance != null))
		{
			String errorNotice = "Internal X3DJSAIL error: incorrect handling of contained SFNode field, both body1 and body1ProtoInstance are set simultaneously";
			validationResult.append(errorNotice);
			throw new InvalidProtoException(errorNotice); // report error
		}
		if (isUSE() && hasBody1()) // test USE restrictions
		{
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained SFNode body1";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained comments";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}

		if (body2 != null)
		{
			setBody2(getBody2());
			((X3DConcreteElement) body2).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) body2).getValidationResult());
		}
		if (body2ProtoInstance != null)
		{
			setBody2(getBody2ProtoInstance());
			((X3DConcreteElement) body2ProtoInstance).validate(); // exercise field checks, SFNode
			validationResult.append(((X3DConcreteElement) body2ProtoInstance).getValidationResult());
		}
		if ((body2 != null) && (body2ProtoInstance != null))
		{
			String errorNotice = "Internal X3DJSAIL error: incorrect handling of contained SFNode field, both body2 and body2ProtoInstance are set simultaneously";
			validationResult.append(errorNotice);
			throw new InvalidProtoException(errorNotice); // report error
		}
		if (isUSE() && hasBody2()) // test USE restrictions
		{
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained SFNode body2";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained comments";
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
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained SFNode metadata";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "DoubleAxisHingeJoint USE='" + getUSE() + "' is not allowed to have contained comments";
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

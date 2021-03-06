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

package org.web3d.x3d.jsail.Scripting;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.fields.*; // making sure #4
import org.web3d.x3d.jsail.Core.fieldObject;
import org.web3d.x3d.sai.Scripting.*; // interfaces for this component
import org.web3d.x3d.sai.Grouping.*;
import org.web3d.x3d.sai.Shape.*;
import org.web3d.x3d.sai.Networking.*;
import org.web3d.x3d.sai.Core.*;
import org.web3d.x3d.jsail.*; // again making sure #4

import org.web3d.x3d.jsail.Core.*;

/**
 * <i>X3D node tooltip</i>:  Script provides programmed behavior for a scene. Define the script interface with &lt;field&gt; elements. Scripting code is embedded in a child CDATA node or (deprecated) in the url field. Optionally supported programming languages: ECMAScript (JavaScript) and (via url to a myNode.class file) Java. 
 * <ul>
 *  <li> <i>Hint:</i>  insert a CDATA node to contain source code embedded within an X3D scene.  </li> 
 *  <li> <i>Hint:</i>  CDATA blocks can protect literal characters (such as &amp; &lt; and &gt;) in source code from unintended escape-character modifications by XML parsers.  </li> 
 *  <li> <i>Hint:</i>   X3D Scene Authoring Hints, Scripts http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Scripts  </li> 
 * </ul>
 * <br>
 * <i>Package hint:</i>  This org.web3d.x3d.jsail concrete class is used for implementing a standalone X3D object as a Plain Old Java Object (POJO).
 * If you are writing Java code for use inside an X3D Script node, compile using the <i>org.web3d.x3d.sai</i> package instead.
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/scripting.html#Script" target="blank">X3D Abstract Specification: Script</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Script" target="_blank">X3D Tooltips: Script</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Scripts" target="_blank">X3D Scene Authoring Hints: Scripts</a>
 */
public class ScriptObject extends org.web3d.x3d.jsail.X3DConcreteNode implements org.web3d.x3d.sai.Scripting.Script
{
	private ArrayList<String> commentsList; // provided since no children array present

	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private boolean directOutput;

	private X3DMetadataObject metadata; // acceptable node types: X3DMetadataObject
	private ProtoInstanceObject metadataProtoInstance; // allowed alternative for metadata field

	private boolean mustEvaluate;

	private ArrayList<String> url = new ArrayList<>();

	private ArrayList<fieldObject> fieldList = new ArrayList<>(); // instantiation

	private String sourceCode;

	/** IS/connect statements might be used if this node is within a ProtoBody and connections are defined between prototype fields and built-in node fields */
	private ISObject IS;

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>Script</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "Script";

	/** Provides name of this element: Script.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** SFBool field named <i>directOutput</i> has default value <i>false</i> (Java syntax) or <i>false</i> (XML syntax). */
	public static final boolean DIRECTOUTPUT_DEFAULT_VALUE = false;

	/** SFBool field named <i>mustEvaluate</i> has default value <i>false</i> (Java syntax) or <i>false</i> (XML syntax). */
	public static final boolean MUSTEVALUATE_DEFAULT_VALUE = false;

	/** MFString field named <i>url</i> has default value equal to an empty list. */
	public static final ArrayList<String> URL_DEFAULT_VALUE = new ArrayList<>();

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
			case "directOutput":
				result = "SFBool";
				break;
			case "metadata":
				result = "SFNode";
				break;
			case "mustEvaluate":
				result = "SFBool";
				break;
			case "url":
				result = "MFString";
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
		// now check author-defined fields
		fieldObject fieldDeclaration = this.findFieldByName(fieldName);
		if (fieldDeclaration != null)
			result = fieldDeclaration.getType(); // found it!
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
			case "directOutput":
				result = "initializeOnly";
				break;
			case "metadata":
				result = "inputOutput";
				break;
			case "mustEvaluate":
				result = "initializeOnly";
				break;
			case "url":
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
		// now check author-defined fields
		fieldObject fieldDeclaration = this.findFieldByName(fieldName);
		if (fieldDeclaration != null)
			result = fieldDeclaration.getAccessType(); // found it!
		return result;
	}

	/** Contained plain-text source code */
	private String SOURCECODE_DEFAULT_VALUE = "";
								
	/** containerField describes typical field relationship of a node to its parent.
	 * Usage is not ordinarily needed when using this API, default value is provided for informational purposes. */
	String containerField_DEFAULT_VALUE = "children";

	// String constants for field names usable in ROUTE statements

	/** fromField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String fromField_METADATA = "metadata";

	/** toField ROUTE name for SFNode field named <i>metadata</i>. */
	public static final String toField_METADATA = "metadata";

	/** fromField ROUTE name for MFString field named <i>url</i>. */
	public static final String fromField_URL = "url";

	/** toField ROUTE name for MFString field named <i>url</i>. */
	public static final String toField_URL = "url";

	/** Constructor for ScriptObject to initialize member variables with default values. */
	public ScriptObject()
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

		directOutput = DIRECTOUTPUT_DEFAULT_VALUE;
		metadata = null; // clear out any prior node
		mustEvaluate = MUSTEVALUATE_DEFAULT_VALUE;
		url = new ArrayList<>(URL_DEFAULT_VALUE);

		commentsList = new ArrayList<>(); // instantiate

			fieldList = new ArrayList<>(); // instantiate

			sourceCode = SOURCECODE_DEFAULT_VALUE; // reset
		}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide boolean value from initializeOnly SFBool field named <i>directOutput</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Set directOutput true if Script has field reference(s) of type SFNode/MFNode, and also uses direct access to modify attributes of a referenced node in the Scene. Hint: set directOutput true if Script dynamically establishes or breaks ROUTEs. Hint: directOutput is a browser hint to avoid overoptimizing referenced nodes, since the Script may change their attribute values without ROUTEd events. Hint: directOutput false means Script cannot modify referenced nodes or change ROUTEs.
	 * @return value of directOutput field
	 */
	@Override
	public boolean getDirectOutput()
	{
		return directOutput;
	}

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>directOutput</i>.
	 * <br><br>
	 * <i>Tooltip:</i> Set directOutput true if Script has field reference(s) of type SFNode/MFNode, and also uses direct access to modify attributes of a referenced node in the Scene. Hint: set directOutput true if Script dynamically establishes or breaks ROUTEs. Hint: directOutput is a browser hint to avoid overoptimizing referenced nodes, since the Script may change their attribute values without ROUTEd events. Hint: directOutput false means Script cannot modify referenced nodes or change ROUTEs.
	 * @param newValue is new value for the directOutput field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ScriptObject setDirectOutput(boolean newValue)
	{
		directOutput = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool directOutput field, similar to {@link #setDirectOutput(boolean)}.
	 * @param newValue is new value for the directOutput field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setDirectOutput(SFBoolObject newValue)
	{
		setDirectOutput(newValue.getPrimitiveValue());
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ScriptObject setMetadata(X3DMetadataObject newValue)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).	 */
	public ScriptObject clearMetadata()
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject setMetadata(ProtoInstanceObject newProtoInstanceNode)
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
	 * Provide boolean value from initializeOnly SFBool field named <i>mustEvaluate</i>.
	 * <br><br>
	 * <i>Tooltip:</i> If mustEvaluate false, then browser may delay sending input events to Script until outputs are needed. If mustEvaluate true, then Script must receive input events immediately without browser delays. Hint: set mustEvaluate true when sending/receiving values via the network.
	 * @return value of mustEvaluate field
	 */
	@Override
	public boolean getMustEvaluate()
	{
		return mustEvaluate;
	}

	/**
	 * Assign boolean value to initializeOnly SFBool field named <i>mustEvaluate</i>.
	 * <br><br>
	 * <i>Tooltip:</i> If mustEvaluate false, then browser may delay sending input events to Script until outputs are needed. If mustEvaluate true, then Script must receive input events immediately without browser delays. Hint: set mustEvaluate true when sending/receiving values via the network.
	 * @param newValue is new value for the mustEvaluate field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ScriptObject setMustEvaluate(boolean newValue)
	{
		mustEvaluate = newValue;
		return this;
	}

	/**
	 * Assign typed object value to SFBool mustEvaluate field, similar to {@link #setMustEvaluate(boolean)}.
	 * @param newValue is new value for the mustEvaluate field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setMustEvaluate(SFBoolObject newValue)
	{
		setMustEvaluate(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Provide array of String results from inputOutput MFString field named <i>url</i>.
	 * <br><br>
	 * <i>Tooltip:</i> points to a script file url. Also (as deprecated alternative to CDATA block) can contain ecmascript: source as a quoted SFString within the url array.Warning: do not use the ecmascript: protocol prefix within external script files. Warning: replace javascript: or vrmlscript: protocol prefix with ecmascript: for source code embedded within an X3D scene. Hint: ECMAScript is the ISO standard version of JavaScript. http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#JavaScript Hint: VrmlScript was a subset of JavaScript originally proposed for use with VRML 97. http://www.bitmanagement.com/developer/spec/vrmlscript/vrmlscript.html Hint: if Script contains both external url reference and internal CDATA source then external url takes precedence, but will fall back to contained CDATA source if no external script is found. Hint: X3D Scene Authoring Hints, urls http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#urls.
	 * @return value of url field
	 */
	@Override
	public String[] getUrl()
	{
		final String[] valuesArray = new String[url.size()];
		int i = 0;
		for (String arrayElement : url) {
			valuesArray[i++] = arrayElement;
		}
		return valuesArray;
	}
	/**
	 * Utility method to get ArrayList value of MFString url field, similar to {@link #getUrl()}.

	 * @return value of url field
	 */
	public ArrayList<String> getUrlList()
	{
		return url;
	}

	/**
	 * Assign String array to inputOutput MFString field named <i>url</i>.
	 * <br><br>
	 * <i>Tooltip:</i> points to a script file url. Also (as deprecated alternative to CDATA block) can contain ecmascript: source as a quoted SFString within the url array.Warning: do not use the ecmascript: protocol prefix within external script files. Warning: replace javascript: or vrmlscript: protocol prefix with ecmascript: for source code embedded within an X3D scene. Hint: ECMAScript is the ISO standard version of JavaScript. http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#JavaScript Hint: VrmlScript was a subset of JavaScript originally proposed for use with VRML 97. http://www.bitmanagement.com/developer/spec/vrmlscript/vrmlscript.html Hint: if Script contains both external url reference and internal CDATA source then external url takes precedence, but will fall back to contained CDATA source if no external script is found. Hint: X3D Scene Authoring Hints, urls http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#urls.
	 * @param newValue is new value for the url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ScriptObject setUrl(String[] newValue)
	{
		if (newValue == null)
		{
			clearUrl(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		url.clear(); // reset
		for (int i = 0; i < newValue.length; i++)
		{
			url.add(newValue[i]);
		}

		return this;
	}

	/**
	 * Assign typed object value to MFString url field, similar to {@link #setUrl(String[])}.
	 * @param newValue is new value for the url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUrl(MFStringObject newValue)
	{
		if (newValue == null)
		{
			clearUrl(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		setUrl(newValue.getPrimitiveValue());
		return this;
	}
	/**
	 * Assign single SFString object value to MFString url field, similar to {@link #setUrl(String[])}.
	 * @param newValue is new value for the url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUrl(SFStringObject newValue)
	{
		if (newValue == null)
		{
			clearUrl(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		setUrl(newValue.getValue());
		return this;
	}
	/**
	 * Assign singleton String value to MFString url field, similar to {@link #setUrl(String[])}.
	 * @param newValue is new value for the url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUrl(String newValue)
	{
		if (newValue == null)
		{
			clearUrl(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		url.clear();
		url.add(newValue);
		return this;
	}
	/**
	 * Assign ArrayList value of MFString url field, similar to {@link #setUrl(String[])}.
	 * @param newValue is new value for the url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUrl(ArrayList<String> newValue)
	{
		if (newValue == null)
		{
			clearUrl(); // newValueNullSetDEFAULT_VALUE
			return this;
		}
		url = newValue;
		return this;
	}
	/**
	 * Utility method to clear MFString value of url field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject clearUrl()
	{
		url.clear(); // reset
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 * <i>Tooltip:</i> DEF defines a unique ID name for this node, referenceable by other nodes. Hint: DEF name is needed or else ROUTEs cannot connect Script node interfaces. Hint: descriptive DEF names improve clarity and help document a model. Hint: well-defined names can simplify design and debugging through improved author understanding. Hint: X3D Scene Authoring Hints, Naming Conventions http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#NamingConventions.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ScriptObject setDEF(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to Script
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("Script DEF newValue='" + newValue + "'" + 
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setDEF(SFStringObject newValue)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ScriptObject setUSE(String newValue)
	{

		if (newValue == null) 
			newValue = new String();
		// Check that newValue parameter meets naming requirements before assigning to Script
		if (!newValue.isEmpty() && !org.web3d.x3d.jsail.fields.SFStringObject.isNMTOKEN(newValue))
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("Script USE newValue='" + newValue + "'" + 
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUSE(SFStringObject newValue)
	{
		setUSE(newValue.getPrimitiveValue());
		return this;
	}

	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * <br><br>
	 * <i>Tooltip:</i> The class attribute is a space-separated list of classes, reserved for use by CSS cascading stylesheets. Warning: currently the class attribute is only supported in XML encoding of X3D scenes. Hint: W3C Cascading Style Sheets https://www.w3.org/Style/CSS.
	 * @param newValue is new value for the class field.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public final ScriptObject setCssClass(String newValue)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setCssClass(SFStringObject newValue)
	{
		setCssClass(newValue.getPrimitiveValue());
		return this;
	}

	// Additional utility methods for this class ==============================

	/**
	 * Utility constructor that assigns DEF name after initializing member variables with default values
	 * @param DEFname unique DEF name for this X3D node
	 */
	public ScriptObject (String DEFname)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	@Override
	public ScriptObject setIS(ISObject newValue)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public ScriptObject setUSE(ScriptObject DEFnode)
	{
		if (DEFnode.getDEF().isEmpty())
		{
			String errorNotice = "setUSE(DEFnode) invoked on ScriptObject" +
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ScriptObject addComments (String newComment)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ScriptObject addComments (String[] newComments)
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
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public ScriptObject addComments (CommentsBlock newCommentsBlock)
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
		boolean      hasChild = (IS != null) || (!fieldList.isEmpty()) || (!sourceCode.isEmpty()) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();

		if (isUSE())
			hasChild = false; // USE nodes only include attributes for USE and non-default containerField
		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(indent).append("<Script"); // start opening tag
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
			
			if (((getDirectOutput() != DIRECTOUTPUT_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" directOutput='").append(SFBoolObject.toString(getDirectOutput())).append("'");
			}
			if (((getMustEvaluate() != MUSTEVALUATE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" mustEvaluate='").append(SFBoolObject.toString(getMustEvaluate())).append("'");
			}
			if (((getUrl().length > 0) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" url='").append(new MFStringObject(getUrl()).toStringX3D()).append("'");
			}
			if ((!getCssClass().equals(CLASS_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes()) && !isUSE())
			{
				stringX3D.append(" class='").append(new SFStringObject(getCssClass()).toStringX3D()).append("'");
			}
		}
		if ((hasChild) && !isUSE()) // has contained node(s), comment(s), IS/connect and/or source code
		{
			stringX3D.append(">").append("\n"); // finish opening tag


			// recursively iterate over child element
			if      (metadata != null)
			{
				stringX3D.append(((X3DConcreteElement)metadata).toStringX3D(level + indentIncrement));
			}
			else if (metadataProtoInstance != null)
			{
					 stringX3D.append(((X3DConcreteElement)metadataProtoInstance).toStringX3D(level + indentIncrement));
			}

			for (fieldObject element : fieldList)
				 stringX3D.append(element.toStringX3D(level + indentIncrement));

			if (getIS() != null)
				stringX3D.append(getIS().toStringX3D(level + indentIncrement)); // IS follows field definitions

			if (sourceCode.trim().length() > 0)
				stringX3D.append("<![CDATA[\n").append(sourceCode)
				         .append("\n]]>\n");

			if (!commentsList.isEmpty())
			{
				CommentsBlock commentsBlock = new CommentsBlock(commentsList);
				stringX3D.append(commentsBlock.toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</Script>").append("\n"); // finish closing tag
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
		boolean      hasChild = (IS != null) || (!fieldList.isEmpty()) || (!sourceCode.isEmpty()) || (metadata != null) || (metadataProtoInstance != null) || !commentsList.isEmpty();
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
			stringClassicVRML.append("Script").append(" { "); // define node name, node content follows

			if (hasAttributes)
			{

				boolean hasISconnect = (getIS() != null) && !getIS().getConnectList().isEmpty();
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("directOutput"))
						{
							stringClassicVRML.append(indentCharacter).append("directOutput").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getDirectOutput() != DIRECTOUTPUT_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("directOutput ").append(SFBoolObject.toString(getDirectOutput())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("mustEvaluate"))
						{
							stringClassicVRML.append(indentCharacter).append("mustEvaluate").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if ((getMustEvaluate() != MUSTEVALUATE_DEFAULT_VALUE) || ConfigurationProperties.isShowDefaultAttributes())
				{
					stringClassicVRML.append("mustEvaluate ").append(SFBoolObject.toString(getMustEvaluate())).append("\n").append(indent).append(indentCharacter);
				}
				if (hasISconnect)
				{
					for (connectObject element : getIS().getConnectList())
					{
						if (element.getNodeField().equals("url"))
						{
							stringClassicVRML.append(indentCharacter).append("url").append(" IS ").append(element.getProtoField()).append("\n").append(indent).append(indentCharacter); // found matching connect
						}
					}
				}
				else 
				if (getUrl().length > 0)
				{
					stringClassicVRML.append("url ").append("[ ").append(MFStringObject.toString(getUrl())).append(" ]").append("\n").append(indent).append(indentCharacter);
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

			for (fieldObject element : fieldList)
			{
				 stringClassicVRML.append(element.toStringClassicVRML(level + indentIncrement));
			}
			if (sourceCode.trim().length() > 0)
			{
				String trimmedSource = sourceCode; // workaround, TODO fix BS Contact bug with leading whitespace
				stringClassicVRML.append(indent).append(indentCharacter).append(indentCharacter)
					.append("url [ \"").append(sourceCode).append("\n").append("\" ]").append("\n");
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

		setDirectOutput(getDirectOutput()); // exercise field checks, simple types

		setMustEvaluate(getMustEvaluate()); // exercise field checks, simple types

		setUrl(getUrl()); // exercise field checks, simple types

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
			String errorNotice = "Script USE='" + getUSE() + "' is not allowed to have contained SFNode metadata";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}
		
		if (isUSE() && !commentsList.isEmpty())// test USE restrictions
		{
			String errorNotice = "Script USE='" + getUSE() + "' is not allowed to have contained comments";
			validationResult.append(errorNotice);
			throw new InvalidFieldValueException(errorNotice); // report error		
		}

		for (fieldObject field : fieldList) // check each field
		{
			field.validate(); // exercise field checks to ensure connected and valid
			validationResult.append(field.getValidationResult());
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

	/**
	 * Add field to fieldList for this ScriptObject
	 * @param newField is field to add
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject addField (fieldObject newField)
	{
		String errorNotice = new String();
		for (fieldObject priorField : fieldList) // check for field with duplicate name
		{
			if (priorField.getName().equals(newField.getName()))
			{
				errorNotice = "Illegal addField() invocation for ScriptObject DEF='" + getDEF() + "', provided duplicate newField name='" + newField.getName() + "'";
				validationResult.append(errorNotice).append("\n");
				throw new InvalidFieldException(errorNotice);
			}
		}
		String fieldValidationResult = newField.validate();
		if (!fieldValidationResult.trim().isEmpty())
		{
			errorNotice = "Illegal addField() invocation for ScriptObject DEF='" + getDEF() + "', newField.validation() failure: " + fieldValidationResult;
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldException(errorNotice);
		}
		fieldList.add(newField);
		newField.setParentObject(this);
		return this;
	}
	/**
	 * Remove a field from contained fieldList
	 * @param fieldToRemove matching field of interest
	 * @see #removeField(String)
	 * @return whether field was removed
	 */
	public boolean removeField (fieldObject fieldToRemove)
	{
		int  fieldIndex = fieldList.indexOf(fieldToRemove);
		if  (fieldIndex >= 0)
		{
			 fieldObject removedField = fieldList.remove(fieldIndex);
			 return (removedField != null);
		}
		else return false;
	}
	/**
	 * Remove a field by name from contained fieldList
	 * @param fieldName matching field of interest
	 * @see #removeField(fieldObject)
	 * @return whether field was removed
	 */
	public boolean removeField (String fieldName)
	{
		fieldObject fieldToRemove = findFieldByName (fieldName);
		if (fieldToRemove != null)
			return removeField (fieldToRemove);
		else return false;
	}

	/**
	 * Clear all fields
	 */
	public void clearFields ()
	{
		fieldList.clear();
	}

	/**
	 * Determine whether field(s) are available
	 * @return whether field(s) are found
	 */
	public boolean hasField ()
	{
		return !fieldList.isEmpty();
	}

	/**
	 * Provide list of fields.
	 * @return value of field list
	 */
	public ArrayList<fieldObject> getFieldList()
	{
		return fieldList;
	}
		
	/**
	 * Find contained field statement by name, if present.
	 * @param fieldName is name attribute for field of interest
	 * @return fieldObject reference of interest, null otherwise
	 */
	public fieldObject findFieldByName (String fieldName)
	{
		for (fieldObject element : fieldList)
		{
			 if (element.getName().equalsIgnoreCase(fieldName))
				 return element;
		}
		return null;
	}
	/**
	 * Determine if field statement is present.
	 * @param fieldName is name attribute for field of interest
	 * @return whether field is found
	 */
	public boolean hasField (String fieldName)
	{
		return (findFieldByName(fieldName) != null);
	}


	/**
	 * Set new source code (for example, JavaScript)
	 * @param newSourceText is source code to set
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject setSourceCode (String[] newSourceText)
	{
		return setSourceCode (Arrays.toString(newSourceText));
	}

	/**
	 * Set new source code (for example, JavaScript)
	 * @param newSourceText is source code to set
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject setSourceCode (String newSourceText)
	{
		String errorNotice = new String();
		if (newSourceText == null)
		{
			errorNotice = "Illegal setSourceCode() invocation, String newSourceText is null. ";
			validationResult.append(errorNotice).append("\n");
		}
		else if (newSourceText.trim().isEmpty())
		{
			errorNotice = "Illegal setSourceCode() invocation, String newSourceText is empty. ";
			validationResult.append(errorNotice).append("\n");
		}
		else if (newSourceText.trim().startsWith("<![CDATA[") && !newSourceText.substring(newSourceText.indexOf("![CDATA[") + 8).trim().startsWith("ecmascript:"))
		{
			errorNotice = "Illegal setSourceCode() invocation, String newSourceText is wrapped in <![CDATA[ block but does not start with \"ecmascript:\"";
			validationResult.append(errorNotice).append("\n");
		}
		else if (!newSourceText.trim().startsWith("<![CDATA[") && !newSourceText.trim().startsWith("ecmascript:"))
		{
			errorNotice = "Illegal setSourceCode() invocation, String newSourceText must start with \"ecmascript:\"";
			validationResult.append(errorNotice).append("\n");
		}
		if (newSourceText.trim().startsWith("<![CDATA[") && !newSourceText.trim().endsWith(""))
		{
		errorNotice = "Illegal setSourceCode() invocation, String newSourceText begins with  block but does not end with \"]]>\"";
			validationResult.append(errorNotice).append("\n");
		}
		if (!errorNotice.isEmpty())
			throw new InvalidFieldValueException(errorNotice);

		sourceCode = newSourceText;
		return this;
	}

	/**
	 * Set new source code (for example, JavaScript)
	 * @param newSourceText is source to set
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject setSourceCode (StringBuilder newSourceText)
	{
		if (newSourceText == null)
		{
			String errorNotice = "Illegal setSourceCode() invocation, StringBuilder newSourceText is null";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException(errorNotice);
		}
		else if (!newSourceText.toString().trim().startsWith("ecmascript:") && (newSourceText.toString().trim().length() > 0))
		{
			String errorNotice = "Illegal setSourceCode() invocation, StringBuilder newSourceText must start with \"ecmascript:\"";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException(errorNotice);
		}
		sourceCode = newSourceText.toString();
		return this;
	}

	/**
	 * Append source code (for example, JavaScript)
	 * @param newSourceText is source to append
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject appendSourceCode (String newSourceText)
	{
		sourceCode += newSourceText;
		return this;
	}

	/**
	 * Append source code (for example, JavaScript)
	 * @param newSourceText is source to append
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject appendSourceCode (StringBuilder newSourceText)
	{
		if (newSourceText == null)
		{
			String errorNotice = "Illegal appendSourceCode() invocation, StringBuilder newSourceText is null";
			validationResult.append(errorNotice).append("\n");
			throw new InvalidFieldValueException(errorNotice);
		}
		else sourceCode += newSourceText.toString();
		return this;
	}

	/**
	 * Clear all contained CDATA source code.
	 * @return {@link ScriptObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public ScriptObject clearSource ()
	{
		sourceCode = SOURCECODE_DEFAULT_VALUE;
		return this;
	}
}

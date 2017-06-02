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

package org.web3d.x3d.jsail.Core;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.jsail.*; // again making sure #2

import org.web3d.x3d.jsail.Layering.LayerSetObject; // special case, as are Metadata* nodes

import java.util.Arrays;
import org.web3d.x3d.sai.Core.*;  // making sure #3
import org.web3d.x3d.jsail.*;
import org.web3d.x3d.jsail.Core.*;

import org.web3d.x3d.jsail.fields.*; // making sure #4
import java.util.Arrays;

/**
 * Scene is the implicit root node of the X3D scene graph. This concrete class represents an X3D Scene statement.
 * 
 * <br><br>
 * <i>X3D statement tooltip</i>:  Scene is the root element that contains an X3D scene graph. Add nodes and children to build an X3D model. Only one Scene root element is allowed per X3D file. 
 * <ul>
 *  <li> <i>Hint:</i>  Scene nodes within Inlined worlds report identical values as top-most root Scene node.  </li> 
 *  <li> <i>Warning:</i>   player support for attribute fields in this node is not defined.  </li> 
 * </ul>
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/concepts.html#Header" target="blank">X3D Abstract Specification: Scene</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html#Scene" target="_blank">X3D Tooltips: Scene</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public class SceneObject extends org.web3d.x3d.jsail.X3DConcreteStatement
{
	// Member value declarations are encapsulated and private, using preferred Java types for concretes library

	private ArrayList<X3DNode> children = new ArrayList<>(); // acceptable node types: X3DChildNode|X3DMetadataObject|LayerSet

	// String constants for default field values match X3D Schema definitions

	/** String constant <i>NAME</i> provides name of this element: <i>Scene</i>. */
	@SuppressWarnings("FieldNameHidesFieldInSuperclass")
	public static final String NAME = "Scene";

	/** Provides name of this element: Scene.
	 * @return name of this element
	 */
	@Override
	public final String getElementName()
	{
		return NAME;
	}

	/** Indicate type corresponding to given fieldName.
	 * @param fieldName name of field in this X3D statement
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
			case "children":
				result = "MFNode";
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
	 * @param fieldName name of field in this X3D statement
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
			case "children":
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

	/** Constructor for SceneObject to initialize member variables with default values. */
	public SceneObject()
	{
		super(); // constructor invocation and corresponding initialize()
		initialize();
	}

	/** Initialize all member variables to default values. */
	@Override
	public final void initialize()
	{
		super.initialize();

		children = new ArrayList<>();
	}

	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide array of X3DNode results (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) with acceptable node types X3DChildNode|X3DMetadataObject|LayerSet, from inputOutput MFNode field <i>children</i>.
	 * <br><br>
	 * <i>WARNING:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode|X3DMetadataObject|LayerSet.
	 * @return value of children field
	 */
	public ArrayList<X3DNode> getChildren()
	{
		return children;
	}

	/**
	 * Assign X3DNode array (using an array consisting of properly typed nodes or X3DPrototypeInstance objects) with acceptable node types X3DChildNode|X3DMetadataObject|LayerSet, to inputOutput MFNode field <i>children</i>.
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode|X3DMetadataObject|LayerSet.
	 * @param newValue is new value for the children field.
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public SceneObject setChildren(ArrayList<X3DNode> newValue)
	{
		children = newValue;
		for (X3DNode arrayElement : children)
		{
			((X3DConcreteElement) arrayElement).setParentObject(this); // parentTest11
		}
		return this;
	}

	/**
	 * Add single children node to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode|X3DMetadataObject|LayerSet.
	 * @param newValue is new value to be appended the children field.	 */
	public void addChildren(X3DNode newValue)
	{
		if (newValue == null) return; // newValueNullReturnVoid

		// newValueInstanceAcceptableNodeTypesTest checks are needed for methods that override/subset X3DNode interfaces
		boolean isNodeTypeAllowed =
				(newValue instanceof org.web3d.x3d.jsail.Core.CommentsBlock) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ROUTEObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.IMPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.EXPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ProtoDeclareObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ExternProtoDeclareObject) ||
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DChildNode) || 
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DMetadataObject) || 
				(newValue instanceof org.web3d.x3d.jsail.Layering.LayerSetObject);
		if  (!isNodeTypeAllowed)
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode newValue is not instanceof " +
				"acceptableNodeTypes X3DChildNode|X3DMetadataObject|LayerSet; newValue=" + newValue);
		}
		children.add(newValue);
		((X3DConcreteElement) newValue).setParentObject(this); // parentTest2
	}


	/**
	 * Utility method to add single child element to contained array of existing children nodes (if any).
	 * @param newValue is new node value to be appended the children field.	 
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	*/
	public SceneObject addChild(X3DChildNode newValue)
	{
		if (newValue == null)
		{
			clearChildren(); // newValueNullSetDEFAULT_VALUE
			return this;
		}

		// newValueInstanceAcceptableNodeTypesTest checks are needed for methods that override/subset X3DNode interfaces
		boolean isNodeTypeAllowed =
				(newValue instanceof org.web3d.x3d.jsail.Core.CommentsBlock) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ROUTEObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.IMPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.EXPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ProtoDeclareObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ExternProtoDeclareObject) ||
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DChildNode) || 
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DMetadataObject) || 
				(newValue instanceof org.web3d.x3d.jsail.Layering.LayerSetObject);
		if  (!isNodeTypeAllowed)
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode newValue is not instanceof " +
				"acceptableNodeTypes X3DChildNode|X3DMetadataObject|LayerSet; newValue=" + newValue);
		}

		children.add(newValue);
		((X3DConcreteElement) newValue).setParentObject(this); // parentTest3
		return this;
	}
	/**
	 * Add array of children nodes to array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode|X3DMetadataObject|LayerSet.
	 * @param newValue is new value array to be appended the children field.
	 */
	public void addChildren(X3DNode[] newValue)
	{
		if (newValue == null) return; // newValueNullReturnVoid

		// newValueArrayAcceptableNodeTypesTest checks are needed for methods that override/subset X3DNode interfaces
		for (int i = 0; i < newValue.length; i++)
		{
			boolean isNodeTypeAllowed = 
				(newValue[i] instanceof org.web3d.x3d.jsail.Core.CommentsBlock) ||
				(newValue[i] instanceof org.web3d.x3d.jsail.Core.ROUTEObject) ||
				(newValue[i] instanceof org.web3d.x3d.jsail.Networking.IMPORTObject) ||
				(newValue[i] instanceof org.web3d.x3d.jsail.Networking.EXPORTObject) ||
				(newValue[i] instanceof org.web3d.x3d.jsail.Core.ProtoDeclareObject) ||
				(newValue[i] instanceof org.web3d.x3d.jsail.Core.ExternProtoDeclareObject) ||
				(((X3DConcreteNode)newValue[i]) instanceof X3DChildNode) || 
				(((X3DConcreteNode)newValue[i]) instanceof X3DMetadataObject) || 
				(newValue[i] instanceof org.web3d.x3d.jsail.Layering.LayerSetObject);
			if  (!isNodeTypeAllowed)
			{
				throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode[] newValue["+i+"] is not instanceof " +
					"acceptableNodeTypes X3DChildNode|X3DMetadataObject|LayerSet; newValue["+i+"]=" + newValue[i]);
			}
		}
		for (int i = 0; i < newValue.length; i++)
		{
			if  (newValue[i] instanceof X3DNode)
			{
				children.add(newValue[i]);
				((X3DConcreteElement) newValue[i]).setParentObject(this); // parentTest6
			}
			else throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode[] newValue["+i+"] is not instanceof X3DNode; newValue=" + Arrays.toString(newValue));
		}
}

	/**
	 * Set single children node, replacing prior array of existing nodes (if any).
	 * <br><br>
	 * <i>Note:</i> according to Object Model for X3D (OMX3D), acceptable node types are limited to X3DChildNode|X3DMetadataObject|LayerSet.
	 * @param newValue is new node for the children field.
	 */
	public void setChildren(X3DNode newValue)
	{
		if (newValue == null)
		{
			children.clear(); // newValueNullClearsFieldReturnVoid
			return;
		}

		// newValueInstanceAcceptableNodeTypesTest checks are needed for methods that override/subset X3DNode interfaces
		boolean isNodeTypeAllowed =
				(newValue instanceof org.web3d.x3d.jsail.Core.CommentsBlock) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ROUTEObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.IMPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Networking.EXPORTObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ProtoDeclareObject) ||
				(newValue instanceof org.web3d.x3d.jsail.Core.ExternProtoDeclareObject) ||
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DChildNode) || 
				(((X3DConcreteNode)newValue) instanceof org.web3d.x3d.sai.Core.X3DMetadataObject) || 
				(newValue instanceof org.web3d.x3d.jsail.Layering.LayerSetObject);
		if  (!isNodeTypeAllowed)
		{
			throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode newValue is not instanceof " +
				"acceptableNodeTypes X3DChildNode|X3DMetadataObject|LayerSet; newValue=" + newValue);
		}
		if  (newValue instanceof X3DNode)
		{
			for (X3DNode element : children)
				((X3DConcreteElement) element).clearParentObject(); // remove references to facilitate Java memory management
			children.clear();
			((X3DConcreteElement) newValue).setParentObject(this); // parentTest8
			children.add(newValue);
		}
		else throw new org.web3d.x3d.sai.InvalidFieldValueException("X3DNode newValue is not instanceof X3DNode; newValue=" + newValue);
}

	/**
	 * Utility method to clear MFNode value of children field.
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	public SceneObject clearChildren()
	{
		for (X3DNode element : children)
			((X3DConcreteElement) element).clearParentObject(); // remove references to facilitate Java memory management
		children.clear(); // reset
		return this;
	}

	/**
	 * Indicate whether an object is available for inputOutput MFNode field <i>children</i>.
	 * @return whether a properly typed node or ProtoInstance array or CommentsBlock is available.
	 * @see #getChildren()
	 */
	public boolean hasChildren()
	{
		return (!children.isEmpty());
	}

	/**
	 * Add comment as CommentsBlock to children field
	 * @param newComment initial value
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SceneObject addComments (String newComment)
	{
		if (newComment == null) return this;
		children.add(new CommentsBlock (newComment));
		return this;
	}
	/**
	 * Add comments as String[] array to children field
	 * @param newComments array of comments
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SceneObject addComments (String[] newComments)
	{
		if (newComments == null) return this;
		children.add(new CommentsBlock (newComments));
		return this;
	}
	/**
	 * Add CommentsBlock to children field
	 * @param newCommentsBlock block of comments to add
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive
setAttribute method invocations).
	 */
	@Override
	public SceneObject addComments (CommentsBlock newCommentsBlock)
	{
		if (newCommentsBlock == null) return this;
		children.add(newCommentsBlock);
		return this;
	}
										
	// Additional utility methods for this class ==============================

		
	/**
	 * Recursive method to provide X3D string serialization of this model subgraph.
	 * @param level number of levels of indentation for this element
	 * @return X3D string
	 */
	@Override
	public String toStringX3D(int level)
	{
		boolean hasAttributes = true; // TODO check for non-default attribute values
		boolean      hasChild = (!children.isEmpty());

		StringBuilder indent = new StringBuilder();
		int  indentIncrement = ConfigurationProperties.getIndentIncrement();
		char indentCharacter = ConfigurationProperties.getIndentCharacter();
		for (int i = 0; i < (level * indentIncrement); i++)
			indent.append(indentCharacter); // level of indentation for this level

		StringBuilder stringX3D = new StringBuilder();

		stringX3D.append(indent).append("<Scene"); // start opening tag
		if (hasAttributes)
		{
		}
		if ((hasChild)) // has contained node(s), comment(s), IS/connect and/or source code
		{
			stringX3D.append(">").append("\n"); // finish opening tag


			// recursively iterate over child elements
			for (X3DNode element : children)
			{
				stringX3D.append(((X3DConcreteElement)element).toStringX3D(level + indentIncrement));
			}
			stringX3D.append(indent).append("</Scene>").append("\n"); // finish closing tag
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
		boolean      hasChild = (!children.isEmpty());
		stringClassicVRML.append("# Scene").append("\n");
			if (hasAttributes)
			{

			}
		if (hasChild) // has contained node(s), comment(s), IS/connect and/or source code
		{
			// recursively iterate over child elements
			for (X3DNode element : children)
			{
				stringClassicVRML.append(((X3DConcreteElement)element).toStringClassicVRML(level));
			}
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
	public X3DConcreteNode getNodeByDEF(String DEFname)
	{
		X3DConcreteNode referenceNode;

		for (X3DNode element : children) // MFNode
		{
			if (element instanceof org.web3d.x3d.jsail.X3DConcreteNode)
			{
				if (((X3DConcreteNode) element).getDEF().equals(DEFname))
					return (X3DConcreteNode) element; // found, this node
			
				// not yet found, continue with depth-first search of current child element
				referenceNode = ((X3DConcreteNode) element).getNodeByDEF(DEFname);
				if (referenceNode != null)
					return referenceNode; // found in child
			}
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
		for (X3DNode element : children) // MFNode
		{
			if (element instanceof X3DConcreteElement)
			{
				referenceElement = ((X3DConcreteElement) element).findElementByNameValue(nameValue, elementName);
				if (referenceElement != null)
					return referenceElement;
			}
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
		X3DConcreteNode referenceNode;
		for (X3DNode element : children) // MFNode
		{
			if (element instanceof org.web3d.x3d.jsail.X3DConcreteNode)
			{
				referenceNode = ((X3DConcreteElement) element).findNodeByDEF(DEFvalue);
				if (referenceNode != null)
					return referenceNode;
			}
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

		for (X3DNode element : children) // MFNode
		{
			((X3DConcreteElement) element).validate(); // exercise field checks, MFNode element
			validationResult.append(((X3DConcreteElement) element).getValidationResult());
		}
		setChildren(getChildren()); // also test getter/setter validation

		return validationResult.toString();
	}

	/**
	 * Utility method to add single X3DMetadataNode to contained array of existing Scene root nodes (if any).
	 * @param newValue is new node value to be appended the children field.	 
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	*/
	public SceneObject addMetadata(X3DMetadataObject newValue)
	{
		if (newValue == null)
		{
			return this;
		}
		children.add((X3DNode)newValue);
		((X3DConcreteElement) newValue).setParentObject(this);
		return this;
	}
	/**
	 * Utility method to add single LayerSetObject to contained array of existing Scene root nodes (if any).
	 * @param newValue is new node value to be appended the children field.	 
	 * @return {@link SceneObject} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	*/
	public SceneObject addChild(LayerSetObject newValue)
	{
		if (newValue == null)
		{
			return this;
		}
		children.add((X3DNode)newValue);
		((X3DConcreteElement) newValue).setParentObject(this);
		return this;
	}
}

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

package org.web3d.x3d.sai.Time;

import org.web3d.x3d.sai.Core.X3DChildNode;

import java.util.*;
import org.web3d.x3d.sai.*;  // making sure #2
import org.web3d.x3d.sai.Core.*;

/**
 * Base type from which all time-dependent nodes are derived.
 * 
 * <br><br>

 * <br>
 * <i>Package hint:</i>  This interface is defined by the X3D Java Language Binding Specification for the Scene Authoring Interface (SAI).
 *
 * @author Don Brutzman and Roy Walmsley
 * @see <a href="http://www.web3d.org/documents/specifications/19777-2/V3.0/Part2/abstracts.html#X3DTimeDependentNode" target="_blank">SAI Java Specification: TODO</a>
 * @see <a href="http://www.web3d.org/documents/specifications/19775-1/V3.3/Part01/components/time.html#X3DTimeDependentNode" target="blank">X3D Abstract Specification: TODO</a>

 * @see <a href="http://www.web3d.org/x3d/tooltips/X3dTooltips.html" target="_blank">X3D Tooltips</a>
 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html" target="_blank">X3D Scene Authoring Hints</a>
 */
public interface X3DTimeDependentNode extends X3DChildNode
{
	// ==== Accessor methods: strongly typed get/set methods for compile-time strictness

	/**
	 * Provide double value in seconds from outputOnly SFTime field named <i>elapsedTime</i>.
	 * @return value of elapsedTime field
	 */
	public double getElapsedTime();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isActive</i>.
	 * @return value of isActive field
	 */
	public boolean getIsActive();
	/**
	 * Provide boolean value from outputOnly SFBool field named <i>isPaused</i>.
	 * @return value of isPaused field
	 */
	public boolean getIsPaused();
	/**
	 * Provide boolean value from inputOutput SFBool field named <i>loop</i>.
	 * @return value of loop field
	 */
	public boolean getLoop();

	/**
	 * Assign boolean value to inputOutput SFBool field named <i>loop</i>.
	 * @param newValue is new value for the loop field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setLoop(boolean newValue);

	/**
	 * Provide X3DMetadataObject instance (using a properly typed node) from inputOutput SFNode field <i>metadata</i>.
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @return value of metadata field
	 */
	public X3DMetadataObject getMetadata(); // acceptable node types: X3DMetadataObject

	/**
	 * Assign X3DMetadataObject instance (using a properly typed node) to inputOutput SFNode field <i>metadata</i>.
	 * @see <a href="http://www.web3d.org/x3d/content/examples/X3dSceneAuthoringHints.html#Metadata">X3D Scene Authoring Hints: Metadata Nodes</a>
	 * @param newValue is new value for the metadata field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setMetadata(X3DMetadataObject newValue); // acceptable node types: X3DMetadataObject

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>pauseTime</i>.
	 * @return value of pauseTime field
	 */
	public double getPauseTime();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>pauseTime</i>.
	 * @param newValue is new value for the pauseTime field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setPauseTime(double newValue);

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>resumeTime</i>.
	 * @return value of resumeTime field
	 */
	public double getResumeTime();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>resumeTime</i>.
	 * @param newValue is new value for the resumeTime field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setResumeTime(double newValue);

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>startTime</i>.
	 * @return value of startTime field
	 */
	public double getStartTime();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>startTime</i>.
	 * @param newValue is new value for the startTime field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setStartTime(double newValue);

	/**
	 * Provide double value in seconds from inputOutput SFTime field named <i>stopTime</i>.
	 * @return value of stopTime field
	 */
	public double getStopTime();

	/**
	 * Assign double value in seconds to inputOutput SFTime field named <i>stopTime</i>.
	 * @param newValue is new value for the stopTime field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setStopTime(double newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>DEF</i>.
	 * <br><br>
	 *  Note that setting the DEF value clears the USE value.
	 * @param newValue is new value for the DEF field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setDEF(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>USE</i>.
	 * <br><br>
	 * <i>Note:</i> each <code>USE</code> node is still an independent object, with the <code>USE</code> value matching the <code>DEF</code> value in the preceding object. 
	 * <br><br>
	 * <i>WARNING:</i> invoking the <code>setUSE()</code> method resets all other fields to their default values and also releases all child nodes.<br><br>
	 * <i>WARNING:</i> no other operations can be performed to modify a USE node other than setting an alternate containerField value.
	 * @param newValue is new value for the USE field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setUSE(String newValue);


	/**
	 * Assign String value to inputOutput SFString field named <i>class</i>.
	 * @param newValue is new value for the class field.
	 * @return {@link X3DTimeDependentNode} - namely <i>this</i> same object to allow sequential method pipelining (i.e. consecutive method invocations on the same node object).
	 */
	public X3DTimeDependentNode setCssClass(String newValue);

}

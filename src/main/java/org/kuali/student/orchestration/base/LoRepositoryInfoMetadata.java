/*
 * Copyright 2010 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may	obtain a copy of the License at
 *
 * 	http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kuali.student.orchestration.base;


import java.util.Date;
import org.kuali.student.core.assembly.data.Data;
import org.kuali.student.core.assembly.data.Metadata;
import org.kuali.student.orchestration.ConstraintMetadataBank;
import org.kuali.student.orchestration.RecursionCounter;
import org.kuali.student.orchestration.base.LoRepositoryInfoHelper.Properties;


public class LoRepositoryInfoMetadata
{
	
	public boolean matches (String inputType, String inputState, String dictType, String dictState)
	{
		// TODO: code more complex matches
		return true;
	}
	
	public Metadata getMetadata (String type, String state)
	{
		Metadata mainMeta = new Metadata ();
		mainMeta.setDataType (Data.DataType.DATA);
		mainMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		loadChildMetadata (mainMeta, type, state, new RecursionCounter ());
		return mainMeta;
	}
	
	public void loadChildMetadata (Metadata mainMeta, String type, String state,  RecursionCounter recursions)
	{
		if (recursions.decrement (this.getClass ().getName ()) < 0)
		{
			recursions.increment (this.getClass ().getName ());
			mainMeta.setWriteAccess (Metadata.WriteAccess.NEVER);
			return;
		}
		
		Metadata childMeta;
		Metadata listMeta;
		
		// metadata for name
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.NAME.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.STRING);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("required"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		
		// metadata for desc
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.DESC.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.DATA);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("optional"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		new RichTextInfoMetadata ().loadChildMetadata (childMeta, type, state, recursions);
		
		// metadata for rootLoId
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.ROOT_LO_ID.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.STRING);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("required"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		
		// metadata for effectiveDate
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.EFFECTIVE_DATE.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.DATE);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("required"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("date.time"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		
		// metadata for expirationDate
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.EXPIRATION_DATE.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.DATE);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("optional"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("date.time"));
		}
		
		// metadata for attributes
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.ATTRIBUTES.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.DATA);
		childMeta.setWriteAccess (Metadata.WriteAccess.ALWAYS);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("optional"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		
		// metadata for metaInfo
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.META_INFO.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.DATA);
		childMeta.setWriteAccess (Metadata.WriteAccess.NEVER);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("optional"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
		}
		new MetaInfoMetadata ().loadChildMetadata (childMeta, type, state, recursions);
		
		// metadata for key
		childMeta = new Metadata ();
		mainMeta.getProperties ().put (Properties.KEY.getKey (), childMeta);
		childMeta.setDataType (Data.DataType.STRING);
		childMeta.setWriteAccess (Metadata.WriteAccess.NEVER);
		if (this.matches (type, state, "(default)", "(default)"))
		{
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("required"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("single"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("read.only"));
			childMeta.getConstraints ().add (ConstraintMetadataBank.BANK.get ("kuali.key"));
		}
		
		recursions.increment (this.getClass ().getName ());
	}
}


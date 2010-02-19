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
import org.kuali.student.lum.lu.assembly.data.client.PropertyEnum;


public class AtpTypeInfoHelper
{
	private static final long serialVersionUID = 1;
	
	public enum Properties implements PropertyEnum
	{
		NAME ("name"),
		DESC ("desc"),
		DURATION_TYPE ("durationType"),
		SEASONAL_TYPE ("seasonalType"),
		EFFECTIVE_DATE ("effectiveDate"),
		EXPIRATION_DATE ("expirationDate"),
		ATTRIBUTES ("attributes"),
		KEY ("key");
		
		private final String key;
		
		private Properties (final String key)
		{
			this.key = key;
		}
		
		@Override
		public String getKey ()
		{
			return this.key;
		}
	}
	private Data data;
	
	private AtpTypeInfoHelper (Data data)
	{
		this.data = data;
	}
	
	public static AtpTypeInfoHelper wrap (Data data)
	{
		if (data == null)
		{
			 return null;
		}
		return new AtpTypeInfoHelper (data);
	}
	
	public Data getData ()
	{
		return data;
	}
	
	
	public void setName (String value)
	{
		data.set (Properties.NAME.getKey (), value);
	}
	
	
	public String getName ()
	{
		return (String) data.get (Properties.NAME.getKey ());
	}
	
	
	public void setDesc (String value)
	{
		data.set (Properties.DESC.getKey (), value);
	}
	
	
	public String getDesc ()
	{
		return (String) data.get (Properties.DESC.getKey ());
	}
	
	
	public void setDurationType (String value)
	{
		data.set (Properties.DURATION_TYPE.getKey (), value);
	}
	
	
	public String getDurationType ()
	{
		return (String) data.get (Properties.DURATION_TYPE.getKey ());
	}
	
	
	public void setSeasonalType (String value)
	{
		data.set (Properties.SEASONAL_TYPE.getKey (), value);
	}
	
	
	public String getSeasonalType ()
	{
		return (String) data.get (Properties.SEASONAL_TYPE.getKey ());
	}
	
	
	public void setEffectiveDate (Date value)
	{
		data.set (Properties.EFFECTIVE_DATE.getKey (), value);
	}
	
	
	public Date getEffectiveDate ()
	{
		return (Date) data.get (Properties.EFFECTIVE_DATE.getKey ());
	}
	
	
	public void setExpirationDate (Date value)
	{
		data.set (Properties.EXPIRATION_DATE.getKey (), value);
	}
	
	
	public Date getExpirationDate ()
	{
		return (Date) data.get (Properties.EXPIRATION_DATE.getKey ());
	}
	
	
	public void setAttributes (Data value)
	{
		data.set (Properties.ATTRIBUTES.getKey (), value);
	}
	
	
	public Data getAttributes ()
	{
		return (Data) data.get (Properties.ATTRIBUTES.getKey ());
	}
	
	
	public void setKey (String value)
	{
		data.set (Properties.KEY.getKey (), value);
	}
	
	
	public String getKey ()
	{
		return (String) data.get (Properties.KEY.getKey ());
	}
	
}


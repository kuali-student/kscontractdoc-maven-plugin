/**
 * Copyright 2010 The Kuali Foundation Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.kuali.student.lum.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kuali.student.core.assembly.data.Data;
import org.kuali.student.core.assembly.data.LookupMetadata;
import org.kuali.student.core.assembly.data.LookupParamMetadata;
import org.kuali.student.core.assembly.data.LookupResultMetadata;
import org.kuali.student.core.assembly.data.Metadata;
import org.kuali.student.core.personsearch.service.impl.QuickViewByGivenNameSearchTypeCreator;
import org.kuali.student.core.search.dto.QueryParamInfo;
import org.kuali.student.core.search.dto.ResultColumnInfo;
import org.kuali.student.core.search.dto.SearchTypeInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MetadataServiceDictionaryValidator
{

 private SearchTypeInfo getSearchTypeInfo (String searchType)
 {
  return this.getSearchInfoTypeMap ().get (searchType);
 }
 private Map<String, SearchTypeInfo> searchInfoTypeMap = null;

 private Map<String, SearchTypeInfo> getSearchInfoTypeMap ()
 {
  if (this.searchInfoTypeMap != null)
  {
   return this.searchInfoTypeMap;
  }
  String[] searchConfigFiles =
  {
   "lu", "lo", "lrc", "organization", "atp", "em"
  };
  for (int i = 0; i < searchConfigFiles.length; i ++)
  {
   System.out.println ("loading search configurations for "
                       + searchConfigFiles[i]);
   ApplicationContext ac = new ClassPathXmlApplicationContext (
     "classpath:" + searchConfigFiles[i] + "-search-config.xml");
   if (searchInfoTypeMap == null)
   {
    searchInfoTypeMap = ac.getBeansOfType (SearchTypeInfo.class);
   }
   else
   {
    searchInfoTypeMap.putAll (ac.getBeansOfType (SearchTypeInfo.class));
   }
  }
  SearchTypeInfo personSearchType = new QuickViewByGivenNameSearchTypeCreator ().get ();
  searchInfoTypeMap.put (personSearchType.getKey (), personSearchType);

  return searchInfoTypeMap;
 }

 public List<String> validateMetadata (Metadata md, String name, String type)
 {
  List<String> errors = new ArrayList ();
  if (md.getInitialLookup () != null)
  {
   errors.addAll (validateLookup (md.getInitialLookup (), name, type, "initial"));
  }
  if (md.getAdditionalLookups () != null)
  {
   for (LookupMetadata lookup : md.getAdditionalLookups ())
   {
    errors.addAll (validateLookup (lookup, name, type, "additional"));
   }
  }
  if (md.getDataType ().equals (Data.DataType.DATA))
  {
   if (md.getProperties () == null)
   {
    errors.add (buildErrorPrefix1 (name, type)
                + " is of type DATA but it has null for it's properties");
   }
   else if (md.getProperties ().size () == 0)
   {
    errors.add (buildErrorPrefix1 (name, type)
                + " is of type DATA but it has no properties");
   }
  }

  if (md.getProperties () != null && md.getProperties ().size () != 0)
  {
   if ( ! (md.getDataType ().equals (Data.DataType.DATA)
        || md.getDataType ().equals (Data.DataType.LIST)))
   {
    errors.add (buildErrorPrefix1 (name, type)
                + " is NOT of type DATA or LIST but it does have properties");
   }
   for (String key : md.getProperties ().keySet ())
   {
    Metadata childMd = md.getProperties ().get (key);
    errors.addAll (this.validateMetadata (childMd, name + "." + key, type));
   }
  }
  return errors;
 }

 private List<String> validateLookup (LookupMetadata lookup, String name,
                                      String type, String lookupType)
 {
  System.out.println ("Validating lookup " + name + "(" + type + ") "
                      + lookupType);
  List<String> errors = new ArrayList ();
  SearchTypeInfo st = getSearchTypeInfo (lookup.getSearchTypeId ());
  if (st == null)
  {
   errors.add (buildErrorPrefix3 (lookup, name, type, lookupType)
               + " that has an underlying search type "
               + lookup.getSearchTypeId ()
               + " that does not exist");
   return errors;
  }
  // check params
  for (LookupParamMetadata param : lookup.getParams ())
  {
   QueryParamInfo qp = findQueryParam (st, param.getKey ());
   if (qp == null)
   {
    errors.add (buildErrorPrefix3 (lookup, name, type, lookupType)
                + " that has a parameter " + param.getKey ()
                + " that does not exist in the underlying search "
                + lookup.getSearchTypeId ());
    continue;
   }
   if ( ! dataTypeMatches (qp.getFieldDescriptor ().getDataType (),
                           param.getDataType ()))
   {
    errors.add (buildErrorPrefix3 (lookup, name, type, lookupType)
                + " that has a parameter " + param.getKey ()
                + " that who's datatype does not match the underlying parameter "
                + qp.getFieldDescriptor ().getDataType () + " vs. "
                + param.getDataType ());
    continue;
   }
  }
  // check results
  for (LookupResultMetadata result : lookup.getResults ())
  {
   ResultColumnInfo rc = findResultColumn (st, result.getKey ());
   if (rc == null)
   {
    errors.add (buildErrorPrefix3 (lookup, name, type, lookupType)
                + " that has a result column " + result.getKey ()
                + " that does not exist in the underlying search "
                + lookup.getSearchTypeId ());
    continue;
   }
   if ( ! dataTypeMatches (rc.getDataType (),
                           result.getDataType ()))
   {
    errors.add (buildErrorPrefix3 (lookup, name, type, lookupType)
                + " that has a result column " + result.getKey ()
                + " that who's datatype does not match the underlying result column "
                + rc.getDataType () + " vs. "
                + result.getDataType ());
    continue;
   }
  }
  return errors;
 }

 private boolean dataTypeMatches (String qp, Data.DataType dt)
 {
  if (dt == null)
  {
   dt = Data.DataType.STRING;
  }
  if (qp == null)
  {
   qp = "string";
  }
  switch (dt)
  {
   case STRING:
    if (qp.equalsIgnoreCase ("string"))
    {
     return true;
    }
    if (qp == null)
    {
     return true;
    }
    return false;
   case INTEGER:
    if (qp.equalsIgnoreCase ("int"))
    {
     return true;
    }
    return false;
   case LONG:
   case FLOAT:
   case DOUBLE:
   case BOOLEAN:
    if (qp.equalsIgnoreCase ("boolean"))
    {
     return true;
    }
    return false;
   case DATE:
   case TRUNCATED_DATE:
    if (qp.equalsIgnoreCase ("date"))
    {
     return true;
    }
    return false;
   case DATA:
    if (qp.equalsIgnoreCase ("complex"))
    {
     return true;
    }
    return false;
   case LIST:
    return true;
  }
  return true;
 }

 private ResultColumnInfo findResultColumn (SearchTypeInfo st, String paramKey)
 {
  for (ResultColumnInfo rc : st.getSearchResultTypeInfo ().getResultColumns ())
  {
   if (rc.getKey ().equals (paramKey))
   {
    return rc;
   }
  }
  return null;
 }

 private QueryParamInfo findQueryParam (SearchTypeInfo st, String paramKey)
 {
  for (QueryParamInfo qp : st.getSearchCriteriaTypeInfo ().getQueryParams ())
  {
   if (qp.getKey ().equals (paramKey))
   {
    return qp;
   }
  }
  return null;
 }

 private String buildErrorPrefix3 (LookupMetadata lookup, String name,
                                   String type, String lookupType)
 {
  return buildErrorPrefix2 (name, type, lookupType) + ": " + lookup.getId ();
 }

 private String buildErrorPrefix2 (String name, String type, String lookupType)
 {
  String msg = buildErrorPrefix1 (name, type);
  msg += " has an " + lookupType + " lookup ";
  return msg;
 }

 private String buildErrorPrefix1 (String name, String type)
 {
  String msg = name;
  if (type != null)
  {
   msg += "with type " + type;
  }
//  System.out.println ("buildErrorPrefix called for " + msg);
//  new RuntimeException ().printStackTrace ();
  return msg;
 }
}

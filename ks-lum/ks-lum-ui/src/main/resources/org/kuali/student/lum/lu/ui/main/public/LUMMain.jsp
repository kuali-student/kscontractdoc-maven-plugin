<%--

    Copyright 2010 The Kuali Foundation Licensed under the
    Educational Community License, Version 2.0 (the "License"); you may
    not use this file except in compliance with the License. You may
    obtain a copy of the License at

    http://www.osedu.org/licenses/ECL-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an "AS IS"
    BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
    or implied. See the License for the specific language governing
    permissions and limitations under the License.

--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page	import="org.kuali.student.common.ui.server.messages.MessageRPCPreloader"%>
<%@page	import="org.kuali.student.common.ui.server.dictionary.DictionaryRPCPreloader"%>
<%@page	import="org.kuali.student.common.ui.client.dictionary.DictionaryHelper"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>


<html>
<head>
<title>LUM Application</title>

</head>

<body>

<%
    try {
        MessageRPCPreloader messageRPCPreloader = new MessageRPCPreloader();
        String commonMessageData = messageRPCPreloader.getMessagesByGroupsEncodingString("en", new String[]{"common", "validation"});
        String luMessageData = messageRPCPreloader.getMessagesByGroupsEncodingString("en", new String[]{"course", "program"});
		
%>
<script type="text/javascript"> 
	    var commonMessages = '<%=commonMessageData%>';
	    var luMessages = '<%=luMessageData%>';
	 
     	</script>
<%
    } catch (Exception e) {

        e.printStackTrace();
    }
%>

	<!-- OPTIONAL: include this if you want history support -->
	<iframe src="javascript:''" id="__gwt_historyFrame"
		style="width: 0; height: 0; border: 0"> </iframe>
	
	<div id="applicationPanel" style="height: 100%; width: 100%; overflow: auto">
	</div>

	<script type="text/javascript" language="javascript"
		src="org.kuali.student.lum.lu.ui.main.LUMMain.nocache.js">
			</script>

</body>
</html>
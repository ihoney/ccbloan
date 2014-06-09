//////初始化信息
function body_load()
{
	///表示主从数据集高度的定制 格式divfd_ID
	if (parent.window.paramValue)
		m_objParam = parent.window.paramValue.value;
	else
		m_objParam = "";

	var tab = document.all("roleTable");

	 var whArr = m_objParam.split("&");
	var whereStr =  "and("+whArr[0] + "='" +whArr[2]+"')order by 1" ;

	tab.whereStr=whereStr;
     roleTable.actionname     ="sm0066";
     roleTable.delmethodname  ="delenum";
	 roleTable.posedelete =true;
	 divfd_roleTable.style.height="350px";
	 roleTable.fdwidth="100%";
	Table_Refresh("roleTable",false);

     initDBGrid("roleTable");

}

function roleTable_appendRecord_click(tab)
{

	var sfeature = "dialogwidth:350px; Dialogheight:450px;center:yes;help:no;resizable:yes;scroll:no;status:no";

     var spath = "selectRole.jsp";
	 var arg = new Object();
	 var whArr = parent.window.paramValue.value.split("&");	 
     arg.operid = whArr[2];
     var  goupstr = window.showModalDialog(spath,arg,sfeature);

     if(goupstr == undefined || goupstr=="")
          return;


     var roleArr = goupstr.split(";");
      var whArr = m_objParam.split("&");

     if (roleArr.length >0){
     	
	     	var oaroleid="";
	     	for (var i=0;i< roleArr.length;i++){
	     		switch (roleArr[i]){
					case "430":case "427":case "436":case "435":case "439":case "448":case "445":case "10427":case "10433":case "10544":
						if (oaroleid =="")
							oaroleid =roleArr[i];
						else
						    oaroleid =oaroleid+";"+roleArr[i];
						break;
						
					case "10537":case "10551":case "10529":case "10555":case "10531":case "10548":case "10599":case "10604":
						if (oaroleid =="")
							oaroleid =roleArr[i];
						else
						    oaroleid =oaroleid+";"+roleArr[i];
						break;
	     		}
	     	}
	     	
	     	if (oaroleid !=""){
	     		var auth = new ActiveXObject("Msxml2.XMLHTTP") ;
	 
		 		var Location="http://192.168.4.29";
		 
		 		auth.open("POST",Location+"/adadmin1/addpersontoroles.aspx",false) ;			
		 		auth.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
				 auth.send("<root><child>"+oaroleid+"*"+arg.operid+"</child></root>");
	    		//alert(auth.responseText);
	     		if (trimStr(auth.responseText) =="0"){
	     			
	     			alert("OA添加权限失败");
	     			return;
	     		
	     		}	

	     	}
     
     
          var xmlDoc = createDoc();
          var rootNode =createRootNode(xmlDoc);
          var insertNode = createActionNode(xmlDoc,"sm0066");


          for (var i=0;i< roleArr.length;i++){
               var RecorderNode = createRecorderNode(xmlDoc,"insert");
               var fieldNode = createFieldNode(xmlDoc,"RoleID","text",roleArr[i]);
               RecorderNode.appendChild(fieldNode);

               var fieldNode = createFieldNode(xmlDoc,"OperID","text",whArr[2]);
               RecorderNode.appendChild(fieldNode);
               insertNode.appendChild(RecorderNode);
          }

          rootNode.appendChild(insertNode);


           retStr = ExecServerPrgm("/BI/util/SqlExcuteJsp.jsp","POST","sys_request_xml="+xmlDoc.xml);



                    ////返回信息检查
          if (analyzeReturnXML(retStr)== "true")
          {
               tab.AbsolutePage= "1";
               tab.RecordCount ="0";

               Table_Refresh(tab.id);
          }
     }



}

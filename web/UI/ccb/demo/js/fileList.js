
//生成DataWindow对象
var lcdw;
var SQLStr;
var gWhereStr="";

/**
 * 初始化form函数
 *
 */
function body_resize()
{

	//itemTab.fdwidth="100%";
	//divfd_itemTab.style.height=document.body.offsetHeight-200;
	divfd_itemTab.style.height="100%";
	initDBGrid("itemTab" );
	body_init(queryForm,"cbRetrieve");
}

/*
*/

function cbRetrieve_Click( formname )
{
	 if(checkForm(queryForm)=="false")
        return ;
     //var sql="select  file_id,file_name,file_date,file_lastdate,isvisibled,file_type from aic_file_info where 1=1 ";
     var  whereStr ="";    
     if(trimStr(document.all.file_name.value)!="")
		whereStr+=" and (file_name like'%"+trimStr(document.all.file_name.value)+"%')";
	 if(trimStr(document.all.file_type.value)!="")
		whereStr+=" and (file_type ='"+trimStr(document.all.file_type.value)+"')";
			

     whereStr += " order by file_date desc ";
     
     //document.all["itemTab"].SQLStr=sql;
     document.all["itemTab"].whereStr = whereStr;
     document.all["itemTab"].RecordCount = "0";
     document.all["itemTab"].AbsolutePage = "1";
    //Table_Refresh in dbgrid.js pack
     Table_Refresh("itemTab",false,body_resize);
}

/*
* operate 操作类型是add
*/
function itemTab_appendRecod_click()
{
	
	var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:no;status:no";		 
	var arg=new Object();	
       
	arg.doType="add";
	var ret = dialog("fileEdit.jsp?doType=add",arg,sfeature);
	
    if(ret=="1"){ 
       document.getElementById("itemTab").RecordCount="0";
	   Table_Refresh("itemTab",false,body_resize);	   
    }
    
    //alert(ret);
    
    //document.getElementById("itemTab").RecordCount="0";
	//Table_Refresh("itemTab",false,body_resize);	  	
}

/*编辑函数
* 传递参数：
* nbxh :内部序号
* qymc ：企业名称
* read : 用于各个tab页面查询出数据，是否可以更改，只读read=yes 编辑的read=no，
* operate : edit
*/
function itemTab_editRecord_click(){


     var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:no;status:no";		 
     var tab = document.all["itemTab"];
     var trobj = tab.rows[tab.activeIndex];

     var fileId="";

 	
	 if(tab.rows.length<=0){
		 alert("没有可以操作的记录！");
		 return;
	 }

     if ((trobj.ValueStr !=undefined)&&(trobj.ValueStr!="")){
          var tmp = trobj.ValueStr.split(";");
          fileId=tmp[0];
             
     }

     if ((trobj.whStr !=undefined)&&(trobj.whStr!=""))
     {
          var tmp = trobj.whStr.split("&");
          var arg = new Object();
          arg.key = tmp[2];
          
         
           var arg=new Object();
	       arg.doType="edit";
	       var rtn=dialog("fileEdit.jsp?fileId="+fileId+"&doType=edit",arg,sfeature);
	       if(rtn=="1"){ 
		       document.getElementById("itemTab").RecordCount="0";
			   Table_Refresh("itemTab",false,body_resize);	   
		    }
     }
     
    // document.getElementById("itemTab").RecordCount="0";
    // Table_Refresh("itemTab",false,body_resize);
}


/*察看函数
* 传递参数：
* nbxh : 内部序号
* qymc ：企业名称
* read : 用于各个tab页面查询出数据，是否可以更改，只读read=yes 编辑的read=no，
*/
function itemTab_query_click(){

	
     var sfeature = "dialogwidth:800px; dialogheight:600px;center:yes;help:no;resizable:yes;scroll:no;status:no";		 
     var tab = document.all["itemTab"];
     var trobj = tab.rows[tab.activeIndex];
     var fileId="";

   	 if(tab.rows.length<=0){
		 alert("没有可以操作的记录！");
		 return;
	 }

     if ((trobj.ValueStr !=undefined)&&(trobj.ValueStr!="")){
          var tmp = trobj.ValueStr.split(";");
          fileId=tmp[0];
  

     }       
     var arg=new Object();
     arg.doType="select";
     dialog("fileEdit.jsp?fileId="+fileId+"&readOnly=yes&doType=select",arg,sfeature);

}

function itemTab_TRDbclick(){
	itemTab_query_click();
}


/*删除函数
* 传递参数：
* nbxh :内部序号
* qymc ：企业名称
* read : 用于各个tab页面查询出数据，是否可以更改，只读read=yes 编辑的read=no，
* operate : 
*/
function itemTab_deleteRecord_click(){
     var tab = document.all["itemTab"];
     var trobj = tab.rows[tab.activeIndex];

     var fileId="";
     var fileName="";

	 if(tab.rows.length<=0){
		 alert("没有可以操作的记录！");
		 return;
	 }
		 

     if ((trobj.ValueStr !=undefined)&&(trobj.ValueStr!="")){
          var tmp = trobj.ValueStr.split(";");
          fileId=tmp[0];
          fileName=tmp[1];

     }    
         
	if(confirm("确定删除该文件？\r\n文件名称："+fileName)){
       document.all.fileId.value=fileId;
	   var retxml=createExecuteform(queryForm,"update","pub007","delete")
	   if (analyzeReturnXML(retxml)!="false"){	
			alert("删除记录成功！");
			document.getElementById("itemTab").RecordCount="0";
			//document.getElementById("itemTab").AbsolutePage="1";
			Table_Refresh("itemTab",false,body_resize);
	   }			  
	}
     
}

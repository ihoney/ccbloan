/********************************************************************************
 *
 *      文件名：  
 *
 *      作  用：  js
 *
 *      作  者：  leonwoo
 *
 *      时  间：  yyyy-mm-dd
 *
 *      版  权：  leonwoo
 *
 ********************************************************************************/
var dw_column;
//初始化form表单内容，根据主键取出详细信息，包括查询、删除、修改
function formInit(){
		var arg = window.dialogArguments;	
		
		if (arg){
			operation = arg.doType;
			if (operation !="add"){  				             
				load_form();  
				
				//refresh_select("file_childtype","SELECT enuitemvalue as value,enuitemlabel as text FROM ptenudetail where enutype='FILECHILDTYPE' and enuitemvalue like  '"+document.getElementById("file_type").value+"__'");		
			}
			// 只读情况下，页面所有空间禁止修改
			if (operation =="select"||operation=="delete"){
				readFun(document.getElementById("editForm"));
			}
              
		}
		// 初始化数据窗口，校验的时候用
     dw_column=new DataWindow(document.getElementById("editForm"),"form");
	}


//删除
function deleteClick(){
     var arg = window.dialogArguments;
     if(arg){
      operation = arg.doType;
      if(operation=="delete"){
           var retxml= createExecuteform(editForm,"delete","sc1013","delete");
			if (analyzeReturnXML(retxml)+""=="true"){
				window.returnValue ="1";
				window.close();
			}
          }
     }
}
//保存，包括增加、修改
function saveClick(){

      /*var doType=document.all.doType.value;  

      if(dw_column.validate()!=null)
           return;
                
      if(doType=="add"){
	      document.editForm.submit();
	      window.returnValue="1";
	      window.close();
      }else if(doType=="edit"){
      	  document.editForm.submit();
	      window.returnValue="1";
	      window.close();
      }*/
     var doType=document.all.doType.value;        
     if(dw_column.validate()!=null)
     	return;
     var retxml="";     
     if(operation=="add"){
         retxml= createExecuteform(editForm,"insert","pub007","add");			
     }else if(operation="edit"){
	     retxml= createExecuteform(editForm,"update","pub007","edit");
     }
     
     if (analyzeReturnXML(retxml)+""=="true"){
			window.returnValue ="1";
			window.close();
	 }
}
		
function viewFile(fileId,titleGround)
{

	var sfeature ="";// "width=750,height=550,status=no,titlebar=no,toolbar=no,menubar=no,location=no";
	var spath = "/viewFile?fileId="+fileId+"&titleGround="+titleGround+"&viewFile=aic_file_info";
   	var para = "_blank";

   	window.open(spath,"_parent",sfeature);
}

function parentColumn(){
	var blockType=document.getElementById("block_type").value;
	if(blockType=="2"){
		document.getElementById("parentColumn").style.display="";
	}else
		document.getElementById("parentColumn").style.display="none";
}

//改变文件中类
function change_fileChildType(){
	var file_type=document.all.file_type.value;
    refresh_select("file_childtype","SELECT enuitemvalue as value,enuitemlabel as text FROM ptenudetail where enutype='FILECHILDTYPE' and enuitemvalue like '%"+file_type+"__%' ");		
    change_detailFileType();
}

//改变文件小类
 function change_detailFileType()
 {
 	var childtype=document.all.file_childtype.value;
 	var sql="";
 	if(childtype=="301"||childtype=="303"||childtype=="306"||childtype=="400"||childtype=="401"){
 		refresh_select("file_detailtype","SELECT enuitemvalue as value,enuitemlabel as text FROM ptenudetail where enutype='FILEDETAILTYPE' and enuitemvalue in('4','5','6') ");
 	}else if(childtype=="309"){
 		refresh_select("file_detailtype","SELECT enuitemvalue as value,enuitemlabel as text FROM ptenudetail where enutype='FILEDETAILTYPE' and enuitemvalue in('1','2','3') ");
 	}else{
 		 //refresh_select("file_detailtype","");
 		 //document.all.file_detailtype.value="";
 	   var des=document.getElementById("file_detailtype");	 
 	   var olength=des.length;	 	   
 	   for( var oindex = olength ; oindex >=0 ; oindex--)
       {
            //var otext=des.options[oindex].text;
            //var ovalue=des.options[oindex].value;
            //alert("otext="+otext+" ovalue="+ovalue);
            //src.options[oindex]=new Option(otext,ovalue);         
            //alert(oindex);             
            des.remove(oindex);  
            //document.getElementById("file_detailtype").value="";          
       }       
 	} 
 }
 
 
 



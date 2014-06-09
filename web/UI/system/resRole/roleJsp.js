
 function changeheigth(){
	document.all("rootUl").style.height=document.body.offsetHeight -55;
}

function onUserDocumentLoad()
{

		var domdoc = createDomDocument();

		var retStr = createselectArr("RoleID","text","0","sm0077");

		if (retStr != false)
		{

			domdoc.loadXML(retStr);

			var Root = domdoc.documentElement;

			treeInit();
			Nodes_clear();


			var nRoot = vNodes.add("", "", "0", "角色授权", "/images/frame/domain.gif");

			nRoot.xData.xNode = new Object();
			nRoot.xData.xNode.appID = "0";

			nRoot.xData.xNode.childCount = 0;
			nRoot.xData.waitforLoad = false;

			if (Root.childNodes.length >0){
				showApplications(Root.firstChild, nRoot);
			}
			nRoot.setExpanded(true);
		}


}

function showApplications(eleRoot, nFather, bManagedApp)
{
	var node = eleRoot;
	var count = 0;

	while(node)
	{

         var nApp = nFather.add("tvwChild", decode(getAttrValue(node.childNodes[0],"value")), decode(getAttrValue(node.childNodes[1],"value")), "/images/frame/about.gif");

		nApp.xData.xNode = new Object();
		nApp.xData.xNode.appID = "1";
        nApp.xData.waitforLoad = false;

		node = node.nextSibling;
		count = count +1;


	}



}


function tvNodeRightClick(node)
{

}

function tvNodeExpand(){

}
///装载树形子节点

function tvNodeSelected(){

	document.all("paramValue").value = "RoleID&text&"+document.node.key;

	if (document.node.xData.xNode.appID =="1")
	{

		innerDocTD.innerHTML = "<iframe id='frmContainer' src='resJsp.jsp' style='WIDTH:100%;HEIGHT:100%' frameborder='0' scrolling='auto'></iframe>";

	}else
		innerDocTD.innerHTML = "<iframe id='frmContainer' src='' style='WIDTH:100%;HEIGHT:100%' frameborder='0' scrolling='auto'></iframe>";

}

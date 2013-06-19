function Folder(folderDescription, hreference)
{
	this.desc = folderDescription;
	this.hreference = hreference;
	this.id = -1;
	this.navObj = 0;
	this.iconImg = 0;
	this.nodeImg = 0;
	this.isLastNode = 0;

	this.isOpen = true;
	this.iconSrc = "../images/tree/ftv2folderopen.gif";
	this.children = new Array;
	this.nChildren = 0;

	this.initialize = initializeFolder;
	this.setState = setStateFolder;
	this.addChild = addChild;
	this.createIndex = createEntryIndex;
	this.hide = hideFolder;
	this.display = display;
	this.renderOb = drawFolder;
	this.totalHeight = totalHeight;
	this.subEntries = folderSubEntries;
	this.outputLink = outputFolderLink;
}

function setStateFolder(isOpen)
{
	var subEntries;
	var totalHeight;
	var fIt = 0;
	var i=0;

	if (isOpen == this.isOpen){
		return;
	}

	if (browserVersion == 2)
	{
		totalHeight = 0;
		for (i=0; i < this.nChildren; i++){
			totalHeight = totalHeight + this.children[i].navObj.clip.height;
			subEntries = this.subEntries();
		}
		if (this.isOpen){
			totalHeight = 0 - totalHeight;
		}
		for (fIt = this.id + subEntries + 1; fIt < nEntries; fIt++){
			indexOfEntries[fIt].navObj.moveBy(0, totalHeight);
		}
	}
	this.isOpen = isOpen;
	propagateChangesInState(this);
}

function propagateChangesInState(folder)
{
	var i=0;

	if (folder.isOpen){
		if (folder.nodeImg){
			if (folder.isLastNode){
				folder.nodeImg.src = "../images/tree/ftv2mlastnode.gif";
			} else {
				folder.nodeImg.src = "../images/tree/ftv2mnode.gif";
			}
		}
		folder.iconImg.src = "../images/tree/ftv2folderopen.gif";
		for (i=0; i<folder.nChildren; i++){
			folder.children[i].display();
		}
	} else {
		if (folder.nodeImg){
			if (folder.isLastNode){
				folder.nodeImg.src = "../images/tree/ftv2plastnode.gif";
			} else {
				folder.nodeImg.src = "../images/tree/ftv2pnode.gif";
			}
		}
		folder.iconImg.src = "../images/tree/ftv2folderclosed.gif";
		for (i=0; i<folder.nChildren; i++){
			folder.children[i].hide();
		}
	}
}

function hideFolder()
{
	if (browserVersion == 1) {
		if (this.navObj.style.display == "none"){
			return;
		}
		this.navObj.style.display = "none";
	} else {
		if (this.navObj.visibility == "hiden"){
			return;
		}
		this.navObj.visibility = "hiden";
	}

	this.setState(0);
}

function initializeFolder(level, lastNode, leftSide)
{
	var j=0;
	var i=0;
	var numberOfFolders;
	var numberOfDocs;
	var nc;

	nc = this.nChildren;

	this.createIndex();

	var auxEv = "";

	if (browserVersion > 0){
		auxEv = "<a href='javascript:;' onMouseDown='return clickOnNode("+this.id+")' >";
	} else {
		auxEv = "<a>";
	}

	if (level>0){
		if (lastNode){
			this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='../images/tree/ftv2mlastnode.gif' width=18 height=18 border=0></a>");
			leftSide = leftSide + "<img src='../images/tree/ftv2blank.gif' width=18 height=18>";
			this.isLastNode = 1;
		} else {
			this.renderOb(leftSide + auxEv + "<img name='nodeIcon" + this.id + "' src='../images/tree/ftv2mnode.gif' width=18 height=18 border=0></a>");
			leftSide = leftSide + "<img src='../images/tree/ftv2vertline.gif' width=18 height=18>";
			this.isLastNode = 0;
		}
	} else {
		this.renderOb("");
	}

	if (nc > 0)
	{
		level = level + 1;
		for (i=0 ; i < this.nChildren; i++)
		{
			if (i == this.nChildren-1){
				this.children[i].initialize(level, 1, leftSide);
			} else {
				this.children[i].initialize(level, 0, leftSide);
			}
		}
	}
}

function drawFolder(leftSide)
{
	if (browserVersion == 2) {
		if (!doc.yPos){
			doc.yPos=8;
		}
		doc.write("<layer id='folder" + this.id + "' top=" + doc.yPos + " visibility=hiden>");
	}

	doc.write("<TABLE ");
	if (browserVersion == 1){
		doc.write(" id='folder" + this.id + "' style='position:block;' ");
	}

	doc.write(" BORDER=0 CELLSPACING=0 CELLPADDING=0>");
	doc.write("<TR><TD>");
	doc.write(leftSide);
	this.outputLink();
	doc.write("<img name='folderIcon" + this.id + "' ");
	doc.write("src='" + this.iconSrc+"' border=0></a>");
	doc.write("</TD><TD VALIGN=middle nowrap>");

	if (USETEXTLINKS){
		this.outputLink();
		doc.write("<NOBR>" + this.desc + "</NOBR></a>");
	} else {
		doc.write("<NOBR>" + this.desc + "</NOBR>");
	}

	doc.write("</TD>");
	doc.write("</TR></TABLE>");
	
	if (browserVersion == 2) {
		doc.write("</layer>");
	}

	if (browserVersion == 1) {
		this.navObj = doc.all["folder"+this.id];
		this.iconImg = doc.all["folderIcon"+this.id];
		this.nodeImg = doc.all["nodeIcon"+this.id];
	} else if (browserVersion == 2) {
		this.navObj = doc.layers["folder"+this.id];
		this.iconImg = this.navObj.document.images["folderIcon"+this.id];
		this.nodeImg = this.navObj.document.images["nodeIcon"+this.id];
		doc.yPos=doc.yPos+this.navObj.clip.height;
	}
}

function outputFolderLink()
{
	if (this.hreference){
		doc.write("<a href='" + this.hreference + "' TARGET=\"" + TFRAME + "\" ");
		if (browserVersion > 0){
			doc.write("onMouseDown='clickOnFolder("+this.id+")'>");
		}
	} else {
		if (this.id!=0){
			doc.write("<a href='javascript:;' onMouseDown='clickOnFolder("+this.id+"); return false'>"); // 100600
		}
	}
}

function addChild(childNode)
{
	this.children[this.nChildren] = childNode;
	this.nChildren++;
	return childNode;
}

function folderSubEntries()
{
	var i = 0;
	var se = this.nChildren;

	for (i=0; i < this.nChildren; i++){
		if (this.children[i].children){ //is a folder
			se = se + this.children[i].subEntries();
		}
	}

	return se;
}

function Item(itemDescription, itemLink, icontype)
{
	this.desc = itemDescription;
	this.link = itemLink;
	this.id = -1;
	this.navObj = 0;
	this.iconImg = 0;
	
	if(icontype == "folder"){	
		this.iconSrc = "../images/tree/ftv2folderclosed.gif";
	} else {
		this.iconSrc = "../images/tree/ftv2doc.gif";
	}

	this.initialize = initializeItem;
	this.createIndex = createEntryIndex;
	this.hide = hideItem;
	this.display = display;
	this.renderOb = drawItem;
	this.totalHeight = totalHeight;
}

function hideItem()
{
	if (browserVersion == 1){
		if (this.navObj.style.display == "none"){
			return;
		}
		this.navObj.style.display = "none";
	} else {
		if (this.navObj.visibility == "hiden"){
			return;
		}
		this.navObj.visibility = "hiden";
	}
}

function initializeItem(level, lastNode, leftSide)
{
	this.createIndex();

	if (level>0){
		if (lastNode)
		{
			this.renderOb(leftSide + "<img src='../images/tree/ftv2lastnode.gif' width=18 height=18>");
			leftSide = leftSide + "<img src='../images/tree/ftv2blank.gif' width=18 height=22>";
		}
		else
		{
			this.renderOb(leftSide + "<img src='../images/tree/ftv2node.gif' width=18 height=18>");
			leftSide = leftSide + "<img src='../images/tree/ftv2vertline.gif' width=18 height=18>";
		}
	} else {
		this.renderOb("");
	}
}

function drawItem(leftSide)
{
	if (browserVersion == 2){
		doc.write("<layer id='item" + this.id + "' top=" + doc.yPos + " visibility=hiden>");
	}

	doc.write("<TABLE ");

	if (browserVersion == 1){
		doc.write(" id='item" + this.id + "' style='position:block;' ");
	}

	doc.write(" BORDER=0 CELLSPACING=0 CELLPADDING=0>");
	doc.write("<TR><TD>");
	doc.write(leftSide);

	if (this.link){
		doc.write("<a href=" + this.link + ">");
		doc.write("<img id='itemIcon"+this.id+"' ");
		doc.write("src='"+this.iconSrc+"' border=0>");
		doc.write("</a>");
	}

	doc.write("</TD><TD VALIGN=middle nowrap>");

	if (USETEXTLINKS && this.link){
		doc.write("<NOBR><a href=" + this.link + " >" + this.desc + "</NOBR></a>");
	} else {
		doc.write("<NOBR>" + this.desc + "</NOBR>");
	}

	doc.write("</TD></TR></TABLE>");

	if (browserVersion == 2){
		doc.write("</layer>");
	}

	if (browserVersion == 1) {
		this.navObj = doc.all["item"+this.id];
		this.iconImg = doc.all["itemIcon"+this.id];
	} else if (browserVersion == 2) {
		this.navObj = doc.layers["item"+this.id];
		this.iconImg = this.navObj.document.images["itemIcon"+this.id];
		doc.yPos=doc.yPos+this.navObj.clip.height;
	}
}

////////
function display()
{
	if (browserVersion == 1){
		this.navObj.style.display = "block";
	} else {
		this.navObj.visibility = "show";
	}
}

function createEntryIndex()
{
	this.id = nEntries;
	indexOfEntries[nEntries] = this;
	nEntries++;
}

function totalHeight()
{
	var h = this.navObj.clip.height;
	var i = 0;

	if (this.isOpen){
		for (i=0 ; i < this.nChildren; i++){
			h = h + this.children[i].totalHeight();
		}
	}

	return h;
}

function clickOnFolder(folderId)
{
	var clicked = indexOfEntries[folderId];

	if (!clicked.isOpen){
		clickOnNode(folderId);
		return;
	}
	if (clicked.isSelected){
		return;
	}
}

function clickOnNode(folderId)
{
	var clickedFolder = 0;
	var state = 0;

	clickedFolder = indexOfEntries[folderId];
	state = clickedFolder.isOpen;

	clickedFolder.setState(!state);

	return false;
}


function gFld(description, ref)
{
	if (DWIN && ref){
		ref = "javascript:go(\""+ref+"\")";
	}

	folder = new Folder(description, ref);
	return folder;
}

function gLnk(target, description, ref)
{
	fullLink = "";

	if (DWIN && ref){
		ref = "javascript:go(\""+ref+"\")";
	}

	if (ref){
		if (target==0){
			fullLink = "'"+ref+"' target=\"" + TFRAME + "\"";
		} else {
			fullLink = "'"+ref+"' target=SubMain";
		}

		linkItem = new Item(description, fullLink, "icon");
	}
	return linkItem;
}


function gScript(target, description, ref, icontype)
{
	ref = "javascript:"+ref+";";

	linkItem = new Item(description, ref, icontype);
	return linkItem;
}


function insFld(parentFolder, childFolder)
{
	return parentFolder.addChild(childFolder);
}

function insDoc(parentFolder, document)
{
	parentFolder.addChild(document);
}


function initializeDocument(tree)
{
	if (doc.all){
		browserVersion = 1; // IE
	} else {
		if (doc.layers){
			browserVersion = 2; // NS
			self.onresize = self.doResize
    	} else {
			browserVersion = 0; // other
		}
	}
	tree.initialize(0, 1, "");
	tree.display();

	if (browserVersion > 0){
		doc.write("<layer top="+indexOfEntries[nEntries-1].navObj.top+">&nbsp;</layer>");
	
		clickOnNode(0);
		clickOnNode(0);
	}
}

function go(s)
{
	onerror=goNewW;	// IE
	sErrREF = s;	// IE

	if (!opener.closed){
		parent.SubMain.document.location=s;
	} else {
		window.open(s,"newW"); // NS
	}
}

function goNewW() // IE
{
	window.open(sErrREF,"newW");
}

function doResize() // NS
{
	document.location.reload();
}

function hideLayer(layerName){
	eval(layerRef+'["'+layerName+'"]'+styleSwitch+'.visibility="hidden"');
}


indexOfEntries = new Array;
nEntries = 0;
doc = document;
browserVersion = 0;
selectedFolder=0;
sErrREF     = ""; // IE
layerRef    ="document.all";
styleSwitch =".style";

if (navigator.appName == "Netscape") {
	layerRef="document.layers";
	styleSwitch="";
}

USETEXTLINKS = 1;
TFRAME="SubMain";
DWIN=0;


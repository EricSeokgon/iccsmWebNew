////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// dhtml functions: require IE4 or later
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

var POPUP_COLOR = "LightYellow";
var POPUP_REPEAT = "no-repeat";
var POPUP_IMAGE = "url()";
var IMAGE_OPEN = "Images/Theme/Buttons%20and%20Icons/open.gif";
var IMAGE_CLOSE = "Images/Theme/Buttons%20and%20Icons/closed.gif";
var INDEX_SELECTED = "";
var INDEX_UNSELECTED = "";
var CONTENTS_SELECTED = "";
var CONTENTS_UNSELECTED = "";

function dhtml_popup(url)
{
	var pop, main, body, x, y;

	// no url? then hide the popup
	if (url == null || url.length == 0)
	{
		pop = document.all["popupFrame"];
		if (pop != null)
			pop.style.display = "none";
		return;
	}

	// if the popup frame is already open, close it first
	if (dhtml_popup_is_open())
	{
		// the main window is the parent of the popup frame
		main = window.parent;
		body = main.document.body;
		pop = main.document.all["popupFrame"];

		// add the popup origin to the event coordinates
		x = pop.offsetLeft + window.event.offsetX;
		y = pop.offsetTop + window.event.offsetY;

		// hide the popup frame
		pop.style.display = "none";
	}
	else
	{
		// the main window is the current window
		main = window;
		body = document.body;
		pop = document.all["popupFrame"];

		// use the event coordinates for positioning the popup
		x = window.event.x;
		y = window.event.y;

		// account for the scrolling text region, if present
		var nstx = document.all["nstext"];
		if (nstx != null)
		{
			if (document.body.scroll == "no")
				y += nstx.scrollTop - nstx.offsetTop;
		}
		// get the popup frame, creating it if needed
		if (pop == null)
		{
			var div = document.all["popupDiv"];
			if (div == null)
				return;

			div.innerHTML = "<iframe id=\"popupFrame\" frameborder=\"none\" scrolling=\"none\" style=\"display:none\"></iframe>";
			pop = document.all["popupFrame"];
		}
	}

	// get frame style
	var sty = pop.style;

	// load url into frame
	pop.src = url;

	// initialize frame size/position
	sty.position  = "absolute";
	sty.border    = "1px solid #cccccc";
	sty.posLeft   = x + body.scrollLeft     - 30000;
	sty.posTop    = y + body.scrollTop + 15 - 30000;
	var wid       = body.clientWidth;
	sty.posWidth  = (wid > 500)? wid * 0.6: wid - 20;
	sty.posHeight = 0;

	// wait until the document is loaded to finish positioning
	main.setTimeout("dhtml_popup_position()", 100);
}
	
function dhtml_popup_is_open()
{
	if (window.name != "")
		return window.name != "right";
	else
		return window.location.href != window.parent.location.href;
}

function dhtml_popup_position()
{
	// get frame
	var pop = document.all["popupFrame"];
	var frm = document.frames["popupFrame"];
	var sty = pop.style;

	if (frm.document.readyState != "complete")
	{
		window.setTimeout("dhtml_popup_position()", 100);
		return;
	}

	// get containing element (scrolling text region or document body)
	var body = document.all["nstext"];
	if (body == null)
		body = document.body;

	// hide navigation/nonscrolling elements, if present
	dhtml_popup_elements(frm.self.document);

	// get content size
	sty.display = "block";
	frm.scrollTo(0,1000);
	sty.posHeight = frm.self.document.body.scrollHeight + 20;

	// make content visible
	sty.posLeft  += 30000;
	sty.posTop   += 30000;

	// adjust x position
	if (sty.posLeft + sty.posWidth + 10 - body.scrollLeft > body.clientWidth)
		sty.posLeft = body.clientWidth  - sty.posWidth - 10 + body.scrollLeft;

	// if the frame fits below the link, we're done
	if (sty.posTop + sty.posHeight - body.scrollTop < body.clientHeight)
		return;

	// calculate how much room we have above and below the link
	var space_above = sty.posTop - body.scrollTop;
	var space_below = body.clientHeight - space_above;
	space_above -= 35;
	space_below -= 20;
	if (space_above < 50) space_above = 50;
	if (space_below < 50) space_below = 50;

	// if the frame fits above or we have a lot more room there, move it up and be done
	if (sty.posHeight < space_above || space_above > 2 * space_below)
	{
		if (sty.posHeight > space_above)
			sty.posHeight = space_above;
		sty.posTop = sty.posTop - sty.posHeight - 30;
		return;
	}

	// adjust frame height to fit below the link
	sty.posHeight = space_below;
}

function dhtml_popup_elements(doc)
{
	// hide navigation bar, if present
	var nav = doc.all["ienav"];
	if (nav != null)
		nav.style.display = "none";

	// set popup background style
	doc.body.style.backgroundColor = POPUP_COLOR;
	doc.body.style.backgroundImage = POPUP_IMAGE;
	doc.body.style.backgroundRepeat = POPUP_REPEAT;

	// reset background image/color of title row, if present
	var trow = doc.all["TitleRow"];
	if (trow != null)
	{
		trow.style.backgroundImage = "none";
		trow.style.backgroundColor = "transparent";
	}

	// reset border and background image/color of nonscrolling banner, if present
	var nsb = doc.all["nsbanner"];
	if (nsb != null)
	{
		nsb.style.borderBottom = "0px";
		nsb.style.backgroundImage = "none";
		nsb.style.backgroundColor = "transparent";
	}

	// reset background image/color of scrolling text region, if present
	var nstx = doc.all["nstext"];
	if (nstx != null)
	{
		nstx.style.backgroundImage = "none";
		nstx.style.backgroundColor = "transparent";
	}
}

function dhtml_nonscrolling_resize()
{
	if (document.body.clientWidth == 0)
		return;

	var oBanner= document.all.item("nsbanner");
	var oText= document.all.item("nstext");

	if (oText == null)
		return;

	var oTitleRow = document.all.item("TitleRow");

	if (oTitleRow != null)
		oTitleRow.style.padding = "0px 10px 0px 22px;";

	if (oBanner != null)
	{
		document.body.scroll = "no"
		oText.style.overflow = "auto";
 		oBanner.style.width = document.body.clientWidth;
		oText.style.paddingRight = "20px"; // Width issue code
		oText.style.width = document.body.clientWidth;
		oText.style.top = 0;  

		if (document.body.offsetHeight > oBanner.offsetHeight + 4)
			oText.style.height = document.body.offsetHeight - oBanner.offsetHeight - 4;
		else
			oText.style.height = 0;
	}	

//	try{nstext.setActive();} //allows scrolling from keyboard as soon as page is loaded. Only works in IE 5.5 and above.
//	catch(e){}

	window.onresize = d2hnsresize;
	window.onbeforeprint = d2h_before_print;
	window.onafterprint = d2h_after_print;
} 

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// d2h functions: browser-independent
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

function d2hie()
{
	var ie = navigator.userAgent.toLowerCase().indexOf("msie");
	return ie != -1 && parseInt(navigator.appVersion) >= 4;
}

function d2hpopup(url)
{
	// use dhtml if we can
	if (d2hie())
	{
		dhtml_popup(url);
		return false;
	}

	// use regular popups
	if (url != null && url.length > 0)
	{
		var pop = window.open(url, '_d2hpopup', 'resizable=1,toolbar=0,directories=0,status=0,location=0,menubar=0,height=300,width=400');
		pop.focus();                 // if the popup was already open
		pop.onblur = "self.close()"; // doesn't work, not sure why...
	}

	// and ignore the click
	return false;
}

function d2hwindow(url, name)
{
	if (name != 'main')
	{
		window.open(url, name, 'scrollbars=1,resizable=1,toolbar=0,directories=0,status=0,location=0,menubar=0,height=300,width=400');
		return false;
	}
	return true;
}

function d2hcancel(msg, url, line)
{
	return true;
}

function d2hload()
{
	window.focus();
	window.onerror = d2hcancel;
	if (window.name == '_d2hpopup')
	{
		var major = parseInt(navigator.appVersion);
		if (major >= 4)
		{
			var agent = navigator.userAgent.toLowerCase();
			if (agent.indexOf("msie") != -1)
				document.all.item("ienav").style.display = "none";
			else
				document.layers['nsnav'].visibility = 'hide';
		}
	}
}

function d2hframeload()
{
	// for compatibility with HTML generated by earlier versions
}

function d2htocload()
{
	if (d2hie())
	{
		var id, elt;
		var count = document.all.length;

		for (i = 0; i < count; i++)
		{
			elt = document.all.item(i);

			if (elt.id.substring(0, 1) == "c")
				elt.style.display = "none";

			else if (elt.id.substring(0, 2) == "mi")
				d2himage(elt, IMAGE_CLOSE, "closed.gif");
		}
	}
}

function d2hclick()
{
	if (d2hie())
	{
		var id = window.event.srcElement.id;

		var n = id.substring(0, 1);
		if (id.substring(0, 1) != "m")
			return;

		var sub = id.substring(2);
		var elt = document.all.item("c" + sub);
		var img = document.all.item("mi" + sub);

		if (elt != null)
		{
			if (elt.style.display == "none")
			{
				elt.style.display = "";
				d2himage(img, IMAGE_OPEN, "open.gif");
			}
			else
			{
				elt.style.display = "none";
				d2himage(img, IMAGE_CLOSE, "closed.gif");
			}
		}
	}
}

// Sets a specified relative URL of image to specified HTML element
function d2himage(element, image, def)
{
	if (element != null)
	{
		// Sets the default image if open image is not initialized
		if (image.substring(0, 2) == "%O")
			image = def;

		// Sets the default image if close image is not initialized
		else if (image.substring(0, 2) == "%C")
			image = def;

		// Hide element if image is missing
		if (image == "")
			element.style.visibility = "hidden";

		// Sets the specified image to element and displays it
		else
		{
			element.src = image;
			element.style.visibility = "visible";
		}	
	}
}

function d2hswitchpane(id)
{
	var sel, unsel, selimg, unselimg;
	var prefix = id.substring(0, 8);
	if (prefix == "D2HIndex")
	{
		sel = document.all("D2HIndex");
		unsel = document.all("D2HContents");
		selimg = INDEX_SELECTED;
		unselimg = CONTENTS_UNSELECTED;
	}
	else if (prefix == "D2HConte")
	{
		sel = document.all("D2HContents");
		unsel = document.all("D2HIndex");
		selimg = CONTENTS_SELECTED;
		unselimg = INDEX_UNSELECTED;
	}

	if (sel != null)
	{
		sel.className = sel.id + "Selected";
		var selimgelm = document.all(sel.id + "Image");
		d2himage(selimgelm, selimg, "");
	}

	if (unsel != null)
	{
		unsel.className = unsel.id + "Unselected";
		var unselimgelm = document.all(unsel.id + "Image");
		d2himage(unselimgelm, unselimg, "");
	}
}

function d2hactivepane()
{
	var id = "D2HContents";
	var frms = window.parent.frames;
	if (frms.length < 2)
		return id;

	var frm = frms("left");
	if (frm == null)
		return id;

	var body = frm.document.body;
	if (body != null)		
		id = body.id;

	return id;				
}

function d2hnsresize()
{
	if (d2hie())
	{
		dhtml_nonscrolling_resize();
		var id = d2hactivepane();
		d2hswitchpane(id);
	}
}

function d2h_before_print()
{
	document.body.scroll = "yes";
	var oText = document.all.item("nstext");
	if (oText != null)
	{
		oText.style.overflow = "visible";
		oText.style.width = "100%";
	}
	var nav = document.all["ienav"];
	if (nav != null)
		nav.style.display = "none";
	var oBanner = document.all.item("nsbanner");
	if (oBanner != null)
	{
		oBanner.style.borderBottom = "0px";
		oBanner.style.margin = "0px 0px 0px 0px";
		oBanner.style.width = "100%";
	}
}

function d2h_after_print()
{
	document.location.reload();
}
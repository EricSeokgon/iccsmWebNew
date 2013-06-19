/**
 *  GUI object Script for cross browser
 *
 *  author : Kim, Min Jong (pistos@qnsolv.com)
 *
 *  start date : 2003/06/04
 *
 *  version 0.1
 */
/**
 * Preference
 */
var client = navigator.appName == 'Microsoft Internet Explorer' ? "IE" : "NE";
/**
 * Nodes
 */
var nodes = new Array();
/**
 * Index of lastest node
 */
var lastestIdx = 0;
/*
 *  Tree class
 */

function Tree(tid, rootName)
{
   this.iconNames = new Array('blank', //0
   'vertical_line', //1                     
   'closed_lastnode', //2  
   'closed_node', //3 
   'opened_lastnode', //4 
   'opened_node', //5 
   'lastnode', //6 
   'node', //7 
   'closed_default_folder', //8     
   'opened_default_folder');
   //9 
   /**
    * Icon Cache
    */
   this.icons = new Array();
   /**
    * Selection Model
    */
   this.SINGLE_TREE_SELECTION = 0;
   this.CONTIGUOUS_TREE_SELECTION = 1;
   this.DISCONTIGUOUS_TREE_SELECTION = 2;
   /**
    * Selection Mode
    */
   this.selectionMode = this.SINGLE_TREE_SELECTION;
   /**
    * Selected Node instance
    */
   this.selectedNode = new Array();
   /**
    * Opened Node
    */
   this.openedNode = null;
   /**
    * Background for unselected node
    */
   this.background = "#ffffff";
   /**
    * Foreground for unselected node
    */
   this.foreground = "#000000";
   /**
    * Background for selected node
    */
   this.selectedBackground = "navy";
   /**
    * Foreground for selected node
    */
   this.selectedForeground = "#ffffff";
   /**
    * Font size
    */
   this.fontSize = "12";
   /**
    * Font name
    */
   this.fontName = "Arial";
   /**
    * Directory for tree icon, must absolute path from webroot
    */
   this.iconDir = "../images/treeicon/win2000";
   /**
    * Extension of icon file
    */
   this.iconExt = "png";
   /**
    * Icon width
    */
   this.iconWidth = "19";
   /**
    * Icon height
    */
   this.iconHeight = "16";
   /**
    * Table for this tree;
    */
   this.table = document.getElementById(tid);
   /**
    * Changed node list for repaint
    */
   this.changedNodes = new Array();
   /**
    * Root Node of tree
    */
   this.root = new TreeNode(rootName);
   /**
    * Preload icons
    */
   this.loadIcons = function()
   {
      for(var i = 0; i < this.iconNames.length; i++)
      {
         this.icons[i] = new Image();
         this.icons[i].src = this.iconDir + "/" + this.iconNames[i] + "." + this.iconExt;
      }
      this.BLANK_ICON = this.icons[0];
      this.VERTICAL_LINE_ICON = this.icons[1];
      this.CLOSED_LASTNODE_ICON = this.icons[2];
      this.CLOSED_NODE_ICON = this.icons[3];
      this.OPENED_LASTNODE_ICON = this.icons[4];
      this.OPENED_NODE_ICON = this.icons[5];
      this.LASTNODE_ICON = this.icons[6];
      this.NODE_ICON = this.icons[7];
      this.CLOSED_DEFAULT_FOLDER_ICON = this.icons[8];
      this.OPENED_DEFAULT_FOLDER_ICON = this.icons[9];
   }
   this.loadIcons();
   /**
    * paint tree
    */
   this.paint = function()
   {
      if(client == "IE") this.paintForIE();
      else if(client == "NE") this.paintForNE();
   }
   this.paintForIE = function()
   {
      this.paintNodeForIE(this.root);
   }
   this.paintForNE = function()
   {
      this.paintNodeForNE(this.root);
   }
   this.getRowIndexById = function(rowId)
   {
      var rows = this.table.childNodes;
      for(var i = 0; i < rows.length; i++)
      {
         if(rows[i].id == rowId)
         return i;
      }
      return - 1;
   }
   /**
    * repaint tree
    */
   this.repaint = function()
   {
      if(client == "IE")
      {
         this.repaintForIE();
      }
      else if(client == "NE")
      {
         //this.repaintForNE();
      }
      this.changedNodes = new Array();
   }
   /**
    * repaint all
    */
   this.repaintAll = function()
   {
      if(client == "IE")
      {
         try
         {
            var size = this.table.rows.length;
            for(var j = 0; j < size; j++)
            {
               this.table.deleteRow(0);
            }
         }
         catch(exception)
         {
         }
         this.repaintNodeForIE(this.root, 0);
      }
      else if(client == "NE")
      {
         //this.repaintForNE();
      }
      this.changedNodes = new Array();
   }
   
   this.repaintForIE = function()
   {
      for(var i = 0; i < this.changedNodes.length; i++)
      {
         var currentNode = this.changedNodes[i];
         //alert(currentNode.name);
         var rowId = "node" + currentNode.index;
         var nextRowId = - 1;
         var rowIndex1 = - 1;
         var rowIndex2 = - 1;
         if(currentNode != this.root)
         {
            rowIndex1 = this.table.rows[rowId].rowIndex;
            try
            {
               nextRowId = "node" + currentNode.parent.getChildAfter(currentNode).index;
               rowIndex2 = this.table.rows[nextRowId].rowIndex - 1;
               //alert("1 : "+rowIndex2);               
            }
            catch(exception)
            {
               try
               {
                  nextRowId = "node" + this.getNextOpenedAncestor(currentNode).index;
                  rowIndex2 = this.table.rows[nextRowId].rowIndex - 1;
               //alert("2 : "+rowIndex2);
               }
               catch(exception)
               {
                  //alert(exception.message+","+exception.line);
                  nextRowId = this.table.rows[this.table.rows.length - 1].id;
                  rowIndex2 = this.table.rows[nextRowId].rowIndex;
               //alert("3 : "+rowIndex2);
               }
            }
         }
         else 
         {
            rowIndex1 = 0;
            rowIndex2 = this.table.rows.length - 1;
         }
         try
         {
            for(var j = 0; j <(rowIndex2 - rowIndex1) + 1; j++)
            {
               this.table.deleteRow(rowIndex1);
            }
         }
         catch(exception)
         {
         }
         //alert(this.changedNodes[i].name);
         this.repaintNodeForIE(this.changedNodes[i], rowIndex1);
      }
   }
   this.repaintForNE = function()
   {
      for(var i = 0; i < this.changedNodes.length; i++)
      {
         var currentNode = this.changedNodes[i];
         var rowId = "node" + currentNode.index;
         var nextRowId = - 1;
         var rowIndex1 = - 1;
         var rowIndex2 = - 1;
         if(currentNode != this.root)
         {
            rowIndex1 = this.getRowIndexById(rowId);
            try
            {
               nextRowId = "node" + currentNode.parent.getChildAfter(currentNode).index;
               rowIndex2 = this.getRowIndexById(nextRowId) - 1;
            }
            catch(exception)
            {
               alert(exception);
               try
               {
                  nextRowId = "node" + this.getNextOpenedAncestor(currentNode).index;
                  rowIndex2 = this.getRowIndexById(nextRowId) - 1;
               }
               catch(exception)
               {
                  nextRowId = this.table.getElementsByTagName("TR").item(this.table.getElementsByTagName("TR").length - 1).id;
                  rowIndex2 = this.getRowIndexById(nextRowId);
               }
            }
         }
         else 
         {
            rowIndex1 = 0;
            rowIndex2 = this.table.getElementsByTagName("TR").length - 1;
         }
         try
         {
            for(var j = 0; j <(rowIndex2 - rowIndex1) + 1; j++)
            {
               this.table.removeChild(this.table.getElementsByTagName("TR").item(rowIndex1));
            }
         }
         catch(exception)
         {
            alert(exception);
         }
         this.repaintNodeForNE(this.changedNodes[i], rowIndex1);
      }
   }
   /**
    * paint node
    */
   this.paintNodeForIE = function(node)
   {
      var newRow = this.table.insertRow(this.table.rows.length - 1);
      newRow.id = "node" + node.index;
      var newCell = newRow.insertCell();
      var renderString = this.leftSideForIE(node);
      newCell.innerHTML = renderString;
      for(var i = 0; i < node.children.length && node.isCollapsed == 0; i++)
      {
         this.paintNodeForIE(node.children[i]);
      }
   }
   /**
    * paint node
    */
   this.paintNodeForNE = function(node)
   {
      var newRow = document.createElement("TR");
      this.table.appendChild(newRow);
      newRow.id = "node" + node.index;
      var newCell = document.createElement("TD");
      newRow.appendChild(newCell);
      newCell.innerHTML = "<font size='2' color='red'>Mozilla is not Supported. Use IE 5.5+</font>";
      /*
	        var renderString = this.leftSideForNE(node);
	        newCell.innerHTML = renderString;
	        
	        for(var i=0; i< node.children.length && node.isCollapsed==0; i++){
	        	this.paintNodeForNE( node.children[i] );
	        }*/
   }
   /**
    * repaint node
    */
   this.repaintNodeForIE = function(node, index)
   {
      var newRow = this.table.insertRow(index);
      newRow.id = "node" + node.index;
      var newCell = newRow.insertCell();
      var renderString = this.leftSideForIE(node);
      newCell.innerHTML = renderString;
      for(var i = 0; i < node.children.length && node.isCollapsed == 0; i++)
      {
         //alert(node.children[i].name);
         if(i == 0)
         {
            this.repaintNodeForIE(node.children[i], index + 1);
         }
         else 
         {
            var rowId = null;
            try
            {
               rowId = "node" + this.getNextOpenedAncestor(node.children[i - 1]).index;
               this.repaintNodeForIE(node.children[i], this.table.rows[rowId].rowIndex);
            }
            catch(exception)
            {
               rowId = this.table.rows[this.table.rows.length - 1].id;
               this.repaintNodeForIE(node.children[i], this.table.rows[rowId].rowIndex + 1);
            }
         }
      }
   }
   /**
    * repaint node
    */
   this.repaintNodeForNE = function(node, index)
   {
      var newRow = document.createElement("TR");
      var indexRow = this.table.getElementsByTagName("TR").item(index);
      //this.appendChild(newRow, index);
      this.table.insertBefore(newRow, indexRow);
      newRow.id = "node" + node.index;
      var newCell = document.createElement("TD");
      newRow.appendChild(newCell);
      var renderString = this.leftSideForNE(node);
      newCell.innerHTML = renderString;
      for(var i = 0; i < node.children.length && node.isCollapsed == 0; i++)
      {
         if(i == 0)
         {
            this.repaintNodeForNE(node.children[i], index + 1);
         }
         else 
         {
            var rowId = null;
            try
            {
               rowId = "node" + this.getNextOpenedAncestor(node.children[i - 1]).index;
               this.repaintNodeForNE(node.children[i], this.getRowIndexById(rowId));
            }
            catch(exception)
            {
               //alert(exception);
               rowId = this.table.getElementsByTagName("TR").item(this.table.getElementsByTagName("TR").length - 1).id;
               this.repaintNodeForNE(node.children[i], this.getRowIndexById(rowId) + 1);
            }
         }
      }
   }
   /**
    * generate leftside
    */
   this.leftSideForIE = function(node)
   {
      var renderString = "";
      for(var i = 0; i < node.leftside.length; i++)
      {
         var iconSrc = this.BLANK_ICON.src;
         if(node.leftside[i] == 1)
         {
            iconSrc = this.VERTICAL_LINE_ICON.src;
         }
         renderString = renderString + "<IMG border='0' src='" + iconSrc + "' align='absmiddle'>";
      }
      if(node != this.root)
      {
         if(node.isLeaf())
         {
            var nodeIcon = this.LASTNODE_ICON;
            if(node.parent.getLastChild() != node)
            {
               nodeIcon = this.NODE_ICON;
            }
            renderString = renderString + "<IMG border='0' src='" + nodeIcon.src + "' align='absmiddle'>";
         }
         else 
         {
            var nodeIcon = null;
            if(node.isCollapsed == 0)
            {
               nodeIcon = this.OPENED_LASTNODE_ICON;
               if(node.parent.getLastChild() != node)
               {
                  nodeIcon = this.OPENED_NODE_ICON;
               }
            }
            else 
            {
               nodeIcon = this.CLOSED_LASTNODE_ICON;
               if(node.parent.getLastChild() != node)
               {
                  nodeIcon = this.CLOSED_NODE_ICON;
               }
            }
            renderString = renderString + "<IMG border='0' src='" + nodeIcon.src + "' onClick='nodes[" + node.index + "].tree.toggleNode(nodes[" + node.index + "])' align='absmiddle'>";
         }
      }
      var isSelectedNode = false;
      for(var i = 0; i < this.selectedNode.length; i++)
      {
         if(this.selectedNode[i] == node)
         {
            isSelectedNode = true;
         }
      }
      if(this.openedNode == node)
      {
         var folderIcon = this.OPENED_DEFAULT_FOLDER_ICON;
         if(node.icon != "")
         {
            folderIcon = new Image();
            folderIcon.src = this.iconDir + "/opened_" + node.icon + "_folder." + this.iconExt;
         }
         renderString = renderString + "<IMG border='0' src='" + folderIcon.src + "' align='absmiddle'>";
      }
      else 
      {
         var folderIcon = this.CLOSED_DEFAULT_FOLDER_ICON;
         if(node.icon != "")
         {
            folderIcon = new Image();
            folderIcon.src = this.iconDir + "/closed_" + node.icon + "_folder." + this.iconExt;
         }
         renderString = renderString + "<IMG border='0' src='" + folderIcon.src + "' align='absmiddle'>";
      }
      var fg = this.foreground;
      var bg = this.background;
      if(isSelectedNode)
      {
         fg = this.selectedForeground;
         bg = this.selectedBackground;
      }
      renderString = renderString + "<SPAN style='color:" + fg + ";background-color:" + bg + ";font-size:" + this.fontSize + ";font-family:" + this.fontName + ";cursor:hand'" + " onClick='nodes[" + node.index + "].tree.treeSelectionListener(nodes[" + node.index + "])'>" + node.name + "</SPAN>";
      return renderString;
   }
   /**
    * generate leftside
    */
   this.leftSideForNE = function(node)
   {
      var renderString = "";
      for(var i = 0; i < node.leftside.length; i++)
      {
         var iconSrc = this.BLANK_ICON.src;
         if(node.leftside[i] == 1)
         {
            iconSrc = this.VERTICAL_LINE_ICON.src;
         }
         renderString = renderString + "<IMG border='0' src='" + iconSrc + "' align='absmiddle'>";
      }
      if(node != this.root)
      {
         if(node.isLeaf())
         {
            var nodeIcon = this.LASTNODE_ICON;
            if(node.parent.getLastChild() != node)
            {
               nodeIcon = this.NODE_ICON;
            }
            renderString = renderString + "<IMG border='0' src='" + nodeIcon.src + "' align='absmiddle'>";
         }
         else 
         {
            var nodeIcon = null;
            if(node.isCollapsed == 0)
            {
               nodeIcon = this.OPENED_LASTNODE_ICON;
               if(node.parent.getLastChild() != node)
               {
                  nodeIcon = this.OPENED_NODE_ICON;
               }
            }
            else 
            {
               nodeIcon = this.CLOSED_LASTNODE_ICON;
               if(node.parent.getLastChild() != node)
               {
                  nodeIcon = this.CLOSED_NODE_ICON;
               }
            }
            renderString = renderString + "<IMG border='0' src='" + nodeIcon.src + "' onClick='nodes[" + node.index + "].tree.toggleNode(nodes[" + node.index + "])' align='absmiddle'>";
         }
      }
      var isSelectedNode = false;
      for(var i = 0; i < this.selectedNode.length; i++)
      {
         if(this.selectedNode[i] == node)
         {
            isSelectedNode = true;
         }
      }
      if(this.openedNode == node)
      {
         var folderIcon = this.OPENED_DEFAULT_FOLDER_ICON;
         if(node.icon != "")
         {
            folderIcon = new Image();
            folderIcon.src = this.iconDir + "/opened_" + node.icon + "_folder." + this.iconExt;
         }
         renderString = renderString + "<IMG border='0' src='" + folderIcon.src + "' align='absmiddle'>";
      }
      else 
      {
         var folderIcon = this.CLOSED_DEFAULT_FOLDER_ICON;
         if(node.icon != "")
         {
            folderIcon = new Image();
            folderIcon.src = this.iconDir + "/closed_" + node.icon + "_folder." + this.iconExt;
         }
         renderString = renderString + "<IMG border='0' src='" + folderIcon.src + "' align='absmiddle'>";
      }
      var fg = this.foreground;
      var bg = this.background;
      if(isSelectedNode)
      {
         fg = this.selectedForeground;
         bg = this.selectedBackground;
      }
      renderString = renderString + "<SPAN style='color:" + fg + ";background-color:" + bg + ";font-size:" + this.fontSize + ";font-family:" + this.fontName + ";cursor:default'" + " onClick='nodes[" + node.index + "].tree.treeSelectionListener(nodes[" + node.index + "])'>" + node.name + "</SPAN>";
      return renderString;
   }
   /**
    * Returns next opened ancestor
    */
   this.getNextOpenedAncestor = function(node)
   {
      if(client == "IE")
      return this.getNextOpenedAncestorForIE(node);
      else if(client == "NE")
      return this.getNextOpenedAncestorForNE(node);
      else 
      return null;
   }
   this.getNextOpenedAncestorForIE = function(node)
   {
      var rowId = this.table.rows["node" + node.index].rowIndex;
      var nextNode = null;
      for(var i = rowId + 1; i < this.table.rows.length; i++)
      {
         var temp = nodes[this.table.rows[i].id.substring(4, this.table.rows[i].id.length)];
         //alert(node.name+","+temp.name);
         //alert(temp.parent);
         if(temp.parent==null)continue;
         if(!node.isAncestor(temp)&&!temp.isAncestor(node))
         {
            nextNode = temp;
            break;
         }
      }
      return nextNode;
   }
   
   this.getNextOpenedAncestorForNE = function(node)
   {
      var rowId1 = "node" + node.index;
      var rowId = document.getElementById(rowId1).getAttribute("rowIndex");
      var nextNode = null;
      for(var i = rowId + 1; i < this.table.getElementsByTagName("TR").length; i++)
      {
         var temp = nodes[this.table.getElementsByTagName("TR").item(i).id.substring(4, this.table.getElementsByTagName("TR").item(i).id.length)];
         if(!node.isAncestor(temp))
         {
            nextNode = temp;
            break;
         }
      }
      return nextNode;
   }
   /**
    * Returns the number of rows that are currently being displayed.
    */
   this.getRowCount = function()
   {
      if(client == "IE")
      return this.getRowCountForIE();
      else if(client == "NE")
      return this.getRowCountForNE();
      else 
      return null;
   }
   this.getRowCountForIE = function()
   {
      return this.table.rows.length;
   }
   this.getRowCountForNE = function()
   {
      return this.table.getElementsByTagName("TR").length;
      //return null;
   }
   /**
    * Returns the path to the first selected node.
    */
   this.getSelectionPath = function()
   {
   }
   /**
    * Move node
    */
   this.moveNode = function(src, target)
   {
      src.parent.remove(src);
      target.add(src);
   }
   /**
    * Copy node
    */
   this.copyNode = function(src, target)
   {
      var newNode = src.clone();
      target.add(newNode);
   }
   /**
    * Returns true if the node at the specified display row is collapsed.
    */
   this.isCollapsed = function(index)
   {
      if(client == "IE")
      return this.isCollapsedForIE(index);
      else if(client == "NE")
      return this.isCollapsedForNE(index);
      else 
      return null;
   }
   this.isCollapsedForIE = function(index)
   {
      var id = this.table.rows[index].id;
      id = id.substring(4, id.length);
      return nodes[id].isCollapsed ? true : false;
   }
   this.isCollapsedForNE = function(index)
   {
      var id = this.table.getElementsByTagName("TR").item(index).id;
      id = id.substring(4, id.length);
      return nodes[id].isCollapsed ? true : false;
   }
   /**
    * Returns true if the node at the specified display row is currently expanded.
    */
   this.isExpanded = function(index)
   {
      if(client == "IE")
      return this.isExpandedForIE(index);
      else if(client == "NE")
      return this.isExpandedForNE(index);
      else 
      return null;
   }
   this.isExpandedForIE = function(index)
   {
      var id = this.table.rows[index].id;
      id = id.substring(4, id.length);
      return nodes[id].isCollapsed ? false : true;
   }
   this.isExpandedForNE = function(index)
   {
      var id = this.table.getElementsByTagName("TR").item(index).id;
      id = id.substring(4, id.length);
      return nodes[id].isCollapsed ? false : true;
   }
   /**
    * Returns true if the node at the specified display row is currently selected
    */
   this.isSelected = function(index)
   {
      if(client == "IE")
         return this.isSelectedForIE(index);
      else if(client == "NE")
         return this.isSelectedForNE(index);
      else 
         return null;
   }
   this.isSelectedForIE = function(index)
   {
      var id = this.table.rows[index].id;
      id = id.substring(4, id.length);
      return nodes[id].isSelected() ? false : true;
   }
   this.isSelectedForNE = function(index)
   {
      var id = this.table.getElementsByTagName("TR").item(index).id;
      id = id.substring(4, id.length);
      return nodes[id].isSelected() ? false : true;
   }
   /**
    * Ensures that the node in the specified row is expanded and viewable.
    */
   this.expandRow = function(index)
   {
   }
   /**
    * Ensures that the node identified by the specified path is expanded and viewable.
    */
   this.expandPath = function(path)
   {
   }
   /**
    * 
    */
   this.expandAll = function(){   	  
      this.root.expandDecendants();
   }
   
   /**
    * Returns true if the node identified by row is selected.
    */
   this.isRowSelected = function(index)
   {
      if(client == "IE")
      return this.isRowSelectedForIE(index);
      else if(client == "NE")
      return this.isRowSelectedForNE(index);
      else 
      return null;
   }
   this.isRowSelectedForIE = function(index)
   {
      var id = this.table.rows[index].id;
      id = id.substring(4, id.length);
      return this.selectedNode == nodes[id] ? true : false;
   }
   this.isRowSelectedForNE = function(index)
   {
      var id = this.table.getElementsByTagName("TR").item(index).id;
      id = id.substring(4, id.length);
      return this.selectedNode == nodes[id] ? true : false;
   }
   /**
    * Removes the row at the index row from the current selection.
    */
   this.removeSelectionRow = function()
   {
   }
   /**
    * Selects the node at the specified row in the display.\
    */
   this.setSelectionRow = function(index)
   {
      if(client == "IE") this.setSelectionRowForIE(index);
      else if(client == "NE") this.setSelectionRowForNE(index);
   }
   this.setSelectionRowForIE = function(index)
   {
      var id = this.table.rows[index].id;
      id = id.substring(4, id.length);
      this.selectNode(nodes[id]);
   }
   this.setSelectionRowForNE = function(index)
   {
      var id = this.table.getElementsByTagName("TR").item(index).id;
      id = id.substring(4, id.length);
      this.selectNode(nodes[id]);
   }
   /**
    *
    */
   this.unselectNode = function(node)
   {
      var newArray = new Array();
      for(var i = 0; i < this.selectedNode.length; i++)
      {
         if(this.selectedNode[i] != node) newArray[newArray.length] = this.selectedNode[i];
         else this.addChangedNode(node);
      }
      this.selectedNode = newArray;
   }
   /**
    * Selects the specified node
    */
   this.selectNode = function(node, event)
   {
      if(this.selectionMode == this.SINGLE_TREE_SELECTION)
      {
         if(this.selectedNode[0] != null)
         {
            this.addChangedNode(this.selectedNode[0]);
         }
         this.selectedNode[0] = node;
         this.openedNode = node;
      }
      else 
      {
         var withCtrl = false;
         if(client == "IE")
         {
            try
            {
               if(event.ctrlKey) withCtrl = true;
            }
            catch(exceptoin)
            {
            }
         }
         else if(client == "NE")
         {
            try
            {
               if(event.modifiers == event.CONTROL_MASK) withCtrl = true;
            }
            catch(exception)
            {
            }
         }
         if(withCtrl)
         {
            if(node.isSelected())
            {
               this.unselectNode(node);
            }
            else 
            {
               this.selectedNode[this.selectedNode.length] = node;
            }
         }
         else 
         {
            for(var i = 0; i < this.selectedNode.length; i++)
            {
               this.addChangedNode(this.selectedNode[i]);
            }
            if(this.openedNode != null) this.addChangedNode(this.openedNode);
            this.selectedNode = new Array();
            this.selectedNode[0] = node;
            this.openedNode = node;
         }
      }
      this.addChangedNode(node);
      this.repaint();
   }
   /**
    * remove node from selected node
    */
   this.removeFromSelectedNode = function(node)
   {
      var newSelectedNodes = new Array();
      for(var i = 0; i < this.selectedNode.length; i++)
      {
         if(!node == this.selectedNode[i])
         {
            newSelectedNodes[newSelectedNodes.length] = this.selectedNode[i];
         }
      }
      this.selectedNode = newSelectedNodes;
   }
   /**
    *  open node
    */
   this.openNode = function(node)
   {
      if(this.openedNode != null) 
      	this.addChangedNode(this.openedNode);
      this.openedNode = node;
      this.addChangedNode(node);
   }
   /**
    *
    */
   this.toggleNode = function(node)
   {
      var newValue = node.isCollapsed == 0 ? 1 : 0;
      node.isCollapsed = newValue;
      if(newValue == 1)
      {
         var setSelected = false;
         for(var i = 0; i < this.selectedNode.length; i++)
         {
            if(node.isAncestor(this.selectedNode[i]))
            {
               this.unselectNode(this.selectedNode[i]);
               setSelected = true;
            }
         }
         if(setSelected) this.selectedNode[this.selectedNode.length] = node;
         if(this.openedNode != null && node.isAncestor(this.openedNode)) this.openNode(node);
      }
      this.addChangedNode(node);
      this.repaint();
   }
   /**
    * add node to changed node
    */
   this.addChangedNode = function(node)
   {
      /*var newChangedNodes = new Array();
	    	for( var i=0; i<this.changedNodes.length; i++){
	    		if(!node.isAncestor(this.changedNodes[i])){
	    		    newChangedNodes[newChangedNodes.length] = this.changedNodes[i];
	    		}
	    	}
	    	this.changedNodes = newChangedNodes;*/
      if(!this.hasChangedAncestor(node)) this.changedNodes[this.changedNodes.length] = node;
   }
   /**
    * remove node from changed node
    */
   this.removeFromChangedNode = function(node)
   {
      var newChangedNodes = new Array();
      for(var i = 0; i < this.changedNodes.length; i++)
      {
         if(!node == this.changedNodes[i])
         {
            newChangedNodes[newChangedNodes.length] = this.changedNodes[i];
         }
      }
      this.changedNodes = newChangedNodes;
   }
   /**
    * Returns true if node has changed ancestor
    */
   this.hasChangedAncestor = function(node)
   {
      var tempNode = node;
      var hasChangedAncestor = false;
      while(tempNode != this.root)
      {
         tempNode = tempNode.parent;
         if(this.isChangedNode(tempNode))
         {
            hasChangedAncestor = true;
            break;
         }
      }
      return hasChangedAncestor;
   }
   /**
    * Returns true is node is changed
    */
   this.isChangedNode = function(node)
   {
      var isChanged = false;
      for(var i = 0; i < this.changedNodes.length; i++)
      {
         if(this.changedNodes[i] == node) isChanged = true;
      }
      return isChanged;
   }
   this.treeSelectionListener = function(node)
   {
      this.selectNode(node);
   }
   this.root.tree = this;
   this.root.depth = 0;
   this.root.isCollapsed = 0;
   //this.selectedNode[0] = this.root;
   this.paint();
}
/**
 *  TreeNode class
 */

function TreeNode(name)
{
   /**
    * node index
    */
   this.index = lastestIdx++;
   nodes[this.index] = this;
   /**
    * Tree
    */
   this.tree = null;
   /**
    * Node name
    */
   this.name = name;
   /**
    * Depth of node
    */
   this.depth = - 1;
   /**
    * leftside icons ( 0 : blank, 1: vertical line )
    */
   this.leftside = new Array();
   /**
    * is Collapsed
    */
   this.isCollapsed = 1;
   /**
    * is child allow
    */
   this.isAllowsChildren = 0;
   /**
    * icon name
    */
   this.icon = "";
   /**
    * parent node
    */
   this.parent = null;
   /**
    * children
    */
   this.children = new Array();
   /**
    * hashmap
    */
   this.extData = new HashMap();
   /**
    * Returns true if this node has no children.
    */
   this.isLeaf = function()
   {
      return this.children.length == 0 ? true : false;
   }
   /**
    * Returns true if this node is Ancestor of specified node
    */
   this.isAncestor = function(node)
   {
      //alert(this.name+","+node.name);
      if(node == this.tree.root)
      return false;
      var parent = node.parent;
      //alert(parent.name);
      var isAncestor = false;
      while(parent != this.tree.root)
      {
         if(parent == this)
         {
            isAncestor = true;
            break;
         }
         parent = parent.parent;
      }
      return isAncestor;
   }
   /**
    * Removes newChild from its parent and makes it a child of this node by adding it to the end of this node's child array.
    */
   this.add = function(child)
   {
      this.children[this.children.length] = child;
      child.tree = this.tree;
      child.parent = this;
      child.depth = this.depth + 1;
      if(this.depth > 0)
      {
         child.leftside = new Array();
         for(var i = 0; i < this.leftside.length; i++)
         {
            child.leftside[child.leftside.length] = this.leftside[i];
         }
         child.leftside[child.leftside.length] = this.parent.getLastChild() == this ? 0 : 1;
      }
      child.fixDecendantsInfo();
      if(this.getChildCount() > 1) this.children[this.children.length - 2].fixLeftsideOfChildren();
      if(this.tree != null) this.tree.addChangedNode(this);
   }
   
   /**
    * Expand all children
    */
   this.expandChildren = function()
   {
   	  this.isCollapsed = 0;
      for(var i=0; i<this.children.length; i++){
         this.children[i].isCollapsed = 0;
      }
   }

   /**
    * Expand all Decendants
    */
   this.expandDecendants = function()
   {
   	  this.isCollapsed = 0;
      for(var i=0; i<this.children.length; i++){
         this.children[i].isCollapsed = 0;
         this.children[i].expandDecendants();
      }
   }
      
   /**
    * Fix depth of decendants
    */
   this.fixDecendantsInfo = function()
   {
      for(var i = 0; i < this.children.length; i++)
      {
         this.children[i].tree = this.tree;
         this.children[i].depth = this.depth + 1;
         this.children[i].leftside = new Array();
         for(var j = 0; j < this.leftside.length; j++)
         {
            this.children[i].leftside[this.children[i].leftside.length] = this.leftside[j];
         }
         this.children[i].leftside[this.children[i].leftside.length] = this.parent.getLastChild() == this ? 0 : 1;
         this.children[i].fixDecendantsInfo();
      }
   }
   /**
    * Fix Leftside of Children
    */
   this.fixLeftsideOfChildren = function()
   {
      this.fixLeftsideOfDescendants(this.depth, this.parent.getLastChild() == this ? 0 : 1);
   }
   this.fixLeftsideOfDescendants = function(depth, value)
   {
      for(var i = 0; i < this.children.length; i++)
      {
         this.children[i].leftside[depth - 1] = value;
         this.children[i].fixLeftsideOfDescendants(depth, value);
      }
   }
   /**
    * Removes aChild from this node's child array, giving it a null parent.
    */
   this.remove = function(node)
   {
      var newChildren = new Array();
      for(var i = 0; i < this.children.length; i++)
      {
         if(this.children[i] == node)
         {
            node.parent = null;
            node.depth = - 1;
            node.tree = null;
            this.tree.removeFromChangedNode(node);
            this.tree.removeFromSelectedNode(node);
            if(this.tree.openedNode == node)
            {
               this.tree.openedNode = null;
            }
         }
         else 
         {
            newChildren[newChildren.length] = this.children[i];
         }
      }
      this.children = newChildren;
      if(this.getChildCount() > 0) this.children[this.children.length - 1].fixLeftsideOfChildren();
      if(this.tree != null) this.tree.addChangedNode(this);
   }
   /**
    * Removes all of this node's children, setting their parents to null.
    */
   this.removeAllChildren = function()
   {
      for(var i = 0; i < this.children.length; i++)
      {
         this.children[i].parent = null;
         this.children[i].depth = - 1;
         this.children[i].tree = null;
         this.tree.removeFromChangedNode(this.children[i]);
      }
      this.children = new Array();
      this.tree.addChangedNode(this);
   }
   /**
    * Removes the subtree rooted at this node from the tree, giving this node a null parent
    */
   this.removeFromParent = function()
   {
      this.parent.remove(this);
   }
   /**
    * Sort children
    */
   this.sortChild = function()
   {
   }
   /**
    * Returns true if node is selected
    */
   this.isSelected = function()
   {
      var isSelected = false;
      if(this.tree != null)
      {
         for(var i = 0; i < this.tree.selectedNode.length; i++)
         {
            if(this.tree.selectedNode[i] == this) isSelected = true;
         }
      }
      return isSelected;
   }
   /**
    * Returns true is node is opened
    */
   this.isOpened = function()
   {
      var isOpened = false;
      if(this.tree != null)
      {
         if(this.tree.openedNode == this) isOpened = true;
      }
      return isOpened;
   }
   /**
    * Returns the number of children of this node.
    */
   this.getChildCount = function()
   {
      return this.children.length;
   }
   /**
    * Returns the child in this node's child array that immediately follows aChild, which must be a child of this node.
    * if the specified child is the lastest node or is not child of this, returns null;
    */
   this.getChildAfter = function(node)
   {
      var cAfter = null;
      for(var i = 0; i < this.children.length - 1; i++)
      {
         if(this.children[i] == node) cAfter = this.children[i + 1];
      }
      return cAfter;
   }
   /** 
    * Returns the child in this node's child array that immediately precedes aChild, which must be a child of this node.
    * if the specified child is the first node or is not child of this, returns null;
    */
   this.getChildBefore = function(node)
   {
      var cBefore = null;
      for(var i = 1; i < this.children.length; i++)
      {
         if(this.children[i] == node) cBefore = this.children[i - 1];
      }
      return cBefore;
   }
   /**
    * Returns this node's first child.
    */
   this.getFirstChild = function()
   {
      return this.children[0];
   }
   /**
    * Returns this node's last child.
    */
   this.getLastChild = function()
   {
      return this.children[this.children.length - 1];
   }
   /**
    * Returns the child at the specified index in this node's child array.
    */
   this.getChildAt = function(index)
   {
      return this.children[index];
   }
   /**
    * Returns the index of the specified child in this node's child array.
    * if this node does not have the specified child, return -1
    */
   this.getIndex = function(node)
   {
      var index = - 1;
      for(var i = 0; i < this.children.length; i++)
      {
         if(this.children[i] == node) index = i;
      }
      return index;
   }
   /**
    * Returns the path from the root, to get to this node.
    */
   this.getPath = function()
   {
   }
   /**
    * Returns the root of the tree that contains this node.
    */
   this.getRoot = function()
   {
      return this.tree.root;
   }
   /**
    * Associates the specified value with the specified key in this map.
    */
   this.put = function(key, value)
   {
      this.extData.put(key, value);
   }
   /**
    * Returns the value to which the specified key is mapped in this identity hash map, or null if the map contains no mapping for this key
    */
   this.get = function(key)
   {
      var value = null;
      value = this.extData.get(key);
      return value;
   }
   /**
    * Clone of this
    */
   this.clone = function()
   {
      var newNode = new TreeNode(this.name);
      newNode.icon = this.icon;
      newNode.isAllowChildren = this.isAllowChildren;
      newNode.extData = this.extData;
      for(var i = 0; i < this.getChildCount(); i++)
      {
         newNode.add(this.children[i].clone());
      }
      return newNode;
   }
}

function HashMap()
{
   this.keys = new Array();
   this.values = new Array();
   /**
    * Removes all mappings from this map.
    */
   this.clear = function()
   {
   }
   /**
    * Returns true if this map contains a mapping for the specified key.
    */
   this.containsKey = function(key)
   {
   }
   /**
    * Returns true if this map maps one or more keys to the specified value.
    */
   this.containsValue = function(value)
   {
   }
   /**
    * Returns true if this map contains no key-value mappings.
    */
   this.isEmpty = function()
   {
   }
   /**
    * Associates the specified value with the specified key in this map.
    */
   this.put = function(key, value)
   {
      this.keys[this.keys.length] = key;
      this.values[this.values.length] = value;
   }
   /**
    * Returns the value to which the specified key is mapped in this identity hash map, or null if the map contains no mapping for this key
    */
   this.get = function(key)
   {
      var value = null;
      for(var i = 0; i < this.keys.length; i++)
      {
         if(this.keys[i] == key) value = this.values[i];
      }
      return value;
   }
   /**
    * Returns the number of key-value mappings in this map.
    */
   this.size = function()
   {
   }
}

function ListItem()
{
}

function List(lid)
{
   var items = new Array();
   this.add = function(item)
   {
      this.items[this.items.length] = item;
   }
}

function TableRow()
{
   var columnNames = new Array();
   var columnValues = new Array();
}

function Table(tid)
{
   var columnNames = new Array();
   var rows = new Array();
}

function FormUtil()
{
   this.validate = function(form)
   {
   }
}

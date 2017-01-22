// Add row to the HTML table
function addRow() { 

 var table = document.getElementById('my_table'); //html table
 var rowCount = table.rows.length; //no. of rows in table
 var columnCount =  table.rows[0].cells.length; //no. of columns in table          
 var row = table.insertRow(rowCount); //insert a row
 
 var cell1 = row.insertCell(0); //create a new cell           
 var element1 = document.createElement("input"); //create a new element           
 element1.type = "checkbox"; //set the element type 
 element1.setAttribute('id', 'newCheckbox'); //set the id attribute         
 cell1.appendChild(element1); //append element to cell
             
 var cell2 = row.insertCell(1);            
 var element2 = document.createElement("select");
 element2.setAttribute('class', 'form-control');
 element2.setAttribute('id', 'floor'+rowCount);
 element2.setAttribute('name', 'Floor');
 element2.setAttribute('onChange', "Javacsript:floorEventChange('"+rowCount+"')");

 //set the id attribute      
 //Create options dynamically. This will not work in mozilla.
  //create a option element

 var branch_code = document.getElementById('branch').value;
 //alert(" new create  option element "+branch_code);
 
 // ---------- this code will create select floor Option
 $.get('branch_facility_res.jsp',{type:'Floor_Name',branch_id:branch_code},function(responseJson) {
   // alert(" Called Ajax request to jsp options called responseJson "+responseJson+" "); 
   		var option0 = document.createElement("option");
		option0.text = "Select Floor "; //set the text for option
		option0.value = "NONE"; //set the value for option
		element2.add(option0);
		
	$.each(responseJson, function(key, value) { 
		var option1 = document.createElement("option");
		option1.text = value; //set the text for option
		option1.value = key; //set the value for option
		element2.add(option1); //add option to select box 
	});
 });

 cell2.appendChild(element2);             
 
 // ---------- this code will create select Facility Option
 var cell3 = row.insertCell(2);            
 var element3 = document.createElement("select");
 element3.setAttribute('class', 'form-control');
 element3.setAttribute('id', 'fac_type');
 element3.setAttribute('name', 'fac_type'); //set the id attribute      
 //Create options dynamically. This will not work in mozilla.
 var option4 = document.createElement("option"); //create a option element
 option4.text = "Open Seats"; //set the text for option
 option4.value = "Open Seats"; //set the value for option
 element3.add(option4); //add option to select box  
 
 var option5 = document.createElement("option");
 option5.text = "Cubical";
 option5.value = "Cubical"; 
 element3.add(option5);
 
 var option6 = document.createElement("option");
 option6.text = "Cabin";
 option6.value = "Cabin";
 element3.add(option6);
 
  var option7 = document.createElement("option");
 option7.text = "Meeting Room";
 option7.value = "Meeting Room";
 element3.add(option7);

 var option8 = document.createElement("option");
 option8.text = "Training Room";
 option8.value = "Training Room";
 element3.add(option8); 

  var option9 = document.createElement("option");
 option9.text = "Private Room";
 option9.value = "Private Room";
 element3.add(option9); 


 cell3.appendChild(element3);
 //Add the cells for more than 3 columns

// ---------- this code will create input text box 1
  var newCel4 = row.insertCell(3); //create a new cell           
   var element4 = document.createElement("input"); //create a div element
   element4.setAttribute('class', 'form-control');
	element4.setAttribute('id', 'fac_name');
	element4.setAttribute('name', 'fac_name');
	element4.type = "text";
   var txt = document.createTextNode("cell "); //create a text element
   element4.appendChild(txt); //append text to div      
   newCel4.appendChild(element4); //appent div to cell

   // ---------- this code will create input text box 2
     var newCel5 = row.insertCell(4); //create a new cell           
     var element5 = document.createElement("select"); //create a div element
     element5.setAttribute('class', 'form-control');
	 element5.setAttribute('id', 'fac_size');
	 element5.setAttribute('name', 'fac_size');
	
	var option10 = document.createElement("option"); //create a option element
    option10.text = 1; //set the text for option
    option10.value = 1; //set the value for option
    element5.add(option10); //add option to select box  
	
	var option11 = document.createElement("option"); //create a option element
    option11.text = 2; //set the text for option
    option11.value = 2; //set the value for option
    element5.add(option11); //add option to select box  
	
	var option12 = document.createElement("option"); //create a option element
    option12.text = 3; //set the text for option
    option12.value = 3; //set the value for option
    element5.add(option12); //add option to select box  
	
	var option13 = document.createElement("option"); //create a option element
    option13.text = 4; //set the text for option
    option13.value = 4; //set the value for option
    element5.add(option13); //add option to select box  
	
	var option14 = document.createElement("option"); //create a option element
    option14.text = 5; //set the text for option
    option14.value = 5; //set the value for option
    element5.add(option14); //add option to select box  
	
	var option15 = document.createElement("option"); //create a option element
    option15.text = 6; //set the text for option
    option15.value = 6; //set the value for option
    element5.add(option15); //add option to select box  
	
	var option16 = document.createElement("option"); //create a option element
    option16.text = 7; //set the text for option
    option16.value = 7; //set the value for option
    element5.add(option16); //add option to select box  
	
	var option17 = document.createElement("option"); //create a option element
    option17.text = 8; //set the text for option
    option17.value = 8; //set the value for option
    element5.add(option17); //add option to select box  
	
	var option18 = document.createElement("option"); //create a option element
    option18.text = 9; //set the text for option
    option18.value = 9; //set the value for option
    element5.add(option18); //add option to select box  
	
	var option19 = document.createElement("option"); //create a option element
    option19.text = 10; //set the text for option
    option19.value = 10; //set the value for option
    element5.add(option19); //add option to select box  
	
	//element5.type = "integer";
	//element5.value= 1;
   var txt = document.createTextNode("cell "); //create a text element
   element5.appendChild(txt); //append text to div      
   newCel5.appendChild(element5); //appent div to cell

	// ---------- this code will create input text box 3
   var newCel6 = row.insertCell(5); //create a new cell           
   var element6 = document.createElement("input"); //create a div element
   element6.setAttribute('class', 'form-control');
	element6.setAttribute('id', 'fac_cap');
	element6.setAttribute('name', 'fac_cap');
	element6.type = "text";
   var txt = document.createTextNode("cell "); //create a text element
   element6.appendChild(txt); //append text to div      
   newCel6.appendChild(element6); //appent div to cell


// ---------- this code will create select layout option
   //var newCel9 = row.insertCell(6); //create a new cell           
   //var element9 = document.createElement("select"); //create a div element
   //element9.setAttribute('class', 'form-control');
	//element9.setAttribute('id', 'layout_name'+rowCount);
	//element9.setAttribute('name', 'layout_name');
	//element9.type = "text";
   //var txt = document.createTextNode("cell "); //create a text element
   //element9.appendChild(txt); //append text to div      
   //newCel9.appendChild(element9); //appent div to cell


// ---------- this code will create select for shared non shared 
  var newCel10 = row.insertCell(6);            
 var element10 = document.createElement("select");
 element10.setAttribute('class', 'form-control');
 element10.setAttribute('id', 'fac_share');
 element10.setAttribute('name', 'fac_share'); //set the id attribute   
 
  var option_4 = document.createElement("option"); //create a option element
 option_4.text = "Shared"; //set the text for option
 option_4.value = "Shared"; //set the value for option
 element10.add(option_4); //add option to select box  
 
 var option_5 = document.createElement("option");
 option_5.text = "Not Shared";
 option_5.value = "Not Shared"; 
 element10.add(option_5);
 
 //var option_6 = document.createElement("option");
 //option_6.text = "NA";
 //option_6.value = "NA";
// element10.add(option_6);
 
 newCel10.appendChild(element10);

  if(columnCount >= 8){
  for (var i=11; i<=columnCount-1; i++) {

   var newCel = row.insertCell(i-1); //create a new cell           
   var element = document.createElement("input"); //create a div element
   element.setAttribute('class', 'form-control');
	element.setAttribute('id', 'newSelect');
	element.type = "text";
   var txt = document.createTextNode("cell "+i); //create a text element
   element.appendChild(txt); //append text to div      
   newCel.appendChild(element); //appent div to cell
  }


 


 //Add the cells for more than 3 columns



 var newCel = row.insertCell(columnCount-1); //create a new cell           
 var element1 = document.createElement("input"); //create a new element 

// newCel.innerHTML= '<input type="checkbox" id=chk_'+rowCount+' name=chk_'+rowCount+' onClick="Javacsript:toggleDiv(this)"> Details ';


 element1.type = "checkbox"; //set the element type 
 element1.setAttribute('id', 'chk_'+rowCount); 
 element1.setAttribute('name', 'chk_'+rowCount); 

 element1.setAttribute('value', 'check_'+rowCount);//set the id attribute
  element1.setAttribute('onClick', "Javacsript:toggleDiv('chk_"+rowCount+"')");
 
 newCel.appendChild(element1); //append element to cell
  var text = document.createTextNode( "Details" );


  newCel.appendChild(text); 

 

 }

 addTable('chk_'+rowCount);
floorEventChange(rowCount);




}


// Create function to add row to layout_master

function addLayoutRow() {    
 var table = document.getElementById('my_table'); //html table
 var rowCount = table.rows.length; //no. of rows in table
 var columnCount =  table.rows[0].cells.length; //no. of columns in table          
 var row = table.insertRow(rowCount); //insert a row  

 
 var cell1 = row.insertCell(0); //create a new cell           
 var element1 = document.createElement("input"); //create a new element           
 element1.type = "checkbox"; //set the element type 
 element1.setAttribute('id', 'newCheckbox'); //set the id attribute         
 cell1.appendChild(element1); //append element to cell
             
 
 //Add the cells for more than 3 columns


  var newCel2 = row.insertCell(1); //create a new cell           
   var element2 = document.createElement("input"); //create a div element
   element2.setAttribute('class', 'form-control');
	element2.setAttribute('id', 'layout_name');
	element2.setAttribute('name', 'layout_name');
	element2.type = "text";
   var txt = document.createTextNode("cell "); //create a text element
   element2.appendChild(txt); //append text to div      
   newCel2.appendChild(element2); //appent div to cell

    var newCel3 = row.insertCell(2); //create a new cell           
   var element3 = document.createElement("input"); //create a div element
   element3.setAttribute('class', 'form-control');
	element3.setAttribute('id', 'layout_description');
	element3.setAttribute('name', 'layout_description');
	element3.type = "text";
   var txt = document.createTextNode("cell "); //create a text element
   element3.appendChild(txt); //append text to div      
   newCel3.appendChild(element3); //appent div to cell


   var newCel4 = row.insertCell(3); //create a new cell           
   var element4 = document.createElement("input"); //create a div element
   element4.setAttribute('class', 'form-control');
	element4.setAttribute('id', 'layout_map');
	element4.setAttribute('name', 'layout_map');
	element4.type = "text";
   var txt = document.createTextNode("cell "); //create a text element
   element4.appendChild(txt); //append text to div      
   newCel4.appendChild(element4); //appent div to cell




  if(columnCount >= 3){
  for (var i=6; i<=columnCount-1; i++) {

   var newCel = row.insertCell(i-1); //create a new cell           
   var element = document.createElement("input"); //create a div element
   element.setAttribute('class', 'form-control');
	element.setAttribute('id', 'newSelect');
	element.type = "text";
   var txt = document.createTextNode("cell "+i); //create a text element
   element.appendChild(txt); //append text to div      
   newCel.appendChild(element); //appent div to cell
  }

 
 


 }

 addTable('chk_'+rowCount);

}



// Create function outside loop

function addSelect(divName,sel_name) {
	var choices = ["No", "Yes"];
    var newDiv = document.createElement('TD');
	var selectHTML = "";
    selectHTML="<select name="+sel_name+">";
	
    for(k = 0; k < choices.length; k++) {
		if (choices[k] == "Yes") {
			selectHTML += "<option selected value='" + choices[k] + "'>" + choices[k] + "</option>";
		} else {
			selectHTML += "<option value='" + choices[k] + "'>" + choices[k] + "</option>";	
		}
        
    }
	
    selectHTML += "</select>";
    newDiv.innerHTML = selectHTML;
	
    divName.appendChild(newDiv);
   
}

function addInput(divName,sel_name) {
	
    var newDiv = document.createElement('TD');
    var selectHTML = "";
    selectHTML="<input type='text' name="+sel_name+" class='form-control'/>";
    newDiv.innerHTML = selectHTML;
    divName.appendChild(newDiv);
   
}

function addInput(divName,sel_name,defat_val) {
	
    var newDiv = document.createElement('TD');
    var selectHTML = "";
    selectHTML="<input type='text' name="+sel_name+" value='"+defat_val+"' class='form-control'/>";
    newDiv.innerHTML = selectHTML;
    divName.appendChild(newDiv);
   
}


function addTable(chk) {

 var myTableDiv = document.getElementById('my_table'); //html table
	var rowCount = myTableDiv.rows.length; //no. of rows in table
	var row = myTableDiv.insertRow(rowCount); //insert a row  
	var cell12 = row.insertCell(0); 
	cell12.colSpan =9;
var newDiv = document.createElement('div');
	  newDiv.setAttribute('class', 'box');
	  newDiv.setAttribute('id', 'amenit_'+chk);
	  newDiv.setAttribute('style',"display: none");

   
  var newDiv_row = document.createElement('div');
	  newDiv_row.setAttribute('class',  'row');
	  newDiv_row.setAttribute('id', 'amenit_row'+chk);
	
	 var newDiv_price = document.createElement('div');
	  newDiv_price.setAttribute('class',  'col-sm-6');
	  newDiv_price.setAttribute('id', 'amenit_price'+chk);

	    addPriceTabe(newDiv_price);
	 
	  var newDiv_feature = document.createElement('div');
	  newDiv_feature.setAttribute('class', 'col-sm-6');
	  newDiv_feature.setAttribute('id', 'amenit_feature'+chk);
	
	  addFeatureTabe(newDiv_feature);

	   newDiv_row.appendChild(newDiv_price);
	  
	  newDiv_row.appendChild(newDiv_feature);

	  newDiv.appendChild(newDiv_row);

     cell12.appendChild(newDiv);
	 dynamicRowValues()

}

function addFeatureTabe(newDiv) {

     var features = ["proj", "board", "wifi","ac","video","water","cafe","tea","print","fax","smoke","lift"];
     var feat_names=["Projector","White Board","Wifi","AC","Video Conference","Drinking Water","Cafeteria","Tea/Coffee","Printer","Fax","Smoking Zone","Lift"];
     //alert("Calling Facility by JSP");

	 //var $branchName=$("select#branch").val();

      $.get('branch_facility_res.jsp',{type:'Features'},function(responseJson) {
		$.each(responseJson, function(key, value) { 
			 var featureCode=value.FeatureCode.myArrayList;
			 var featureName=value.FeatureName.myArrayList;
			 var featureIcon=value.FeatureIcon.myArrayList;

			  $.each(featureCode, function(codeKey, codeValue) {
			   // alert(  "Joson data Facility by "+codeKey+" "+codeValue);
				features[codeKey]=codeValue
			  });
			  
			  $.each(featureName, function(nameKey, nameValue) {
			   // alert(  "Joson data Facility by "+nameKey+" "+nameValue);
				feat_names[nameKey]=nameValue;
			  });
		});
              // alert(" features codes "+features );
		// alert(" feat_names "+feat_names );


   //alert("Starting dynamic table "+features);
	var table = document.createElement('TABLE');
    table.border='1';
	table.class="table-bordered";
	
	 var tableHead = document.createElement('THEAD');
	 var tr1 = document.createElement('TR');
	  
	 var coltd1 = document.createElement('TH');
       coltd1.width='150';
	   coltd1.appendChild(document.createTextNode("Amenities"));
	    tr1.appendChild(coltd1);
	   var coltd2 = document.createElement('TH');
       coltd2.width='75';
	   coltd2.appendChild(document.createTextNode("Available"));
	   tr1.appendChild(coltd2);
	   var coltd3 = document.createElement('TH');
       coltd3.width='75';
	   coltd3.appendChild(document.createTextNode("Complementary"));
	   tr1.appendChild(coltd3);
	   var coltd4 = document.createElement('TH');
       coltd4.width='75';
	   coltd4.appendChild(document.createTextNode("Comment"));
	   tr1.appendChild(coltd4);
	  tableHead.appendChild(tr1);
	  table.appendChild(tableHead);
   
		var tableBody = document.createElement('TBODY');
		table.appendChild(tableBody);

		for (var i=0; i<features.length; i++) {
			var tr = document.createElement('TR');
			tableBody.appendChild(tr);
			
			var td = document.createElement('TD');
			td.width='75';
			td.appendChild(document.createTextNode(feat_names[i]));
			
			tr.appendChild(td);
			addSelect(tr,features[i]);
			addSelect(tr,features[i]+"_charge");
			addInput(tr,features[i]+"_price","");
		}
		newDiv.appendChild(table);
   });
  
	var $city=$("select#city").val();
   	var $location=$("select#location").val();
	var $branchName=$("select#branch").val();

	$.get('branch_facility_res.jsp',{type:'Floor',cityname:$city,location_name:$location,branch_name:$branchName},function(responseJson) {
		$.each(responseJson, function(key, value1){
		var names=document.getElementsByName(key);
		//alert(" Array of size "+names.length);
		for(key1=0; key1 < names.length; key1++){
			//alert(names[key1].value);
			names[key1].value=value1;
		}
		});
	});
}





function addPriceTabe(newDiv) {

	//var price = ["base_price", "disc", "part_share","dispay"];
	var price = ["standard_price", "corp_price", "standard_disc","corp_disc"];
	var feat_names=["Hourly","Daily","Weekly","Monthly","Quaterly","Yearly"];

   //alert("Starting dynamic table "+features);
	var table = document.createElement('TABLE');
    table.border='1';
	table.class="table-bordered";
	
	 var tableHead = document.createElement('THEAD');
	 var tr1 = document.createElement('TR');
	  
	 var coltd1 = document.createElement('TH');
       coltd1.width='150';
	   coltd1.appendChild(document.createTextNode("Category"));
	    tr1.appendChild(coltd1);
	   var coltd2 = document.createElement('TH');
       coltd2.width='75';
	   coltd2.appendChild(document.createTextNode("Standard Price"));
	   tr1.appendChild(coltd2);
	   var coltd3 = document.createElement('TH');
       coltd3.width='75';
	   coltd3.appendChild(document.createTextNode("Corporate Price"));
	   tr1.appendChild(coltd3);
	   var coltd4 = document.createElement('TH');
       coltd4.width='75';
	   coltd4.appendChild(document.createTextNode("Standard Discount"));
	   tr1.appendChild(coltd4);
	   var coltd5 = document.createElement('TH');
       coltd5.width='75';
	   coltd5.appendChild(document.createTextNode("Corporate Discount"));
	   tr1.appendChild(coltd5);
	   var coltd6 = document.createElement('TH');
       coltd6.width='75';
	   coltd6.appendChild(document.createTextNode("Comment"));
	   tr1.appendChild(coltd6);
	  tableHead.appendChild(tr1);
	  table.appendChild(tableHead);
   
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
     
    for (var i=0; i<feat_names.length; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
        
        var td = document.createElement('TD');
        td.width='75';
	    td.appendChild(document.createTextNode(feat_names[i]));
	    tr.appendChild(td);
		//addInput(tr,feat_names[i]+"_b_price","0");
		//addInput(tr,feat_names[i]+"_disc","0");
		//addInput(tr,feat_names[i]+"_partner","0");
		//addInput(tr,feat_names[i]+"_display","No");
		//addInput(tr,feat_names[i]+"_comment","");
	  addInput(tr,feat_names[i]+"_s_price","0");
	  addInput(tr,feat_names[i]+"_c_price","0");
	  addInput(tr,feat_names[i]+"_s_disc","0");
	  addInput(tr,feat_names[i]+"_c_disc","0");
	  addInput(tr,feat_names[i]+"_comment","");
      
    }
	 newDiv.appendChild(table);
}

function deleteRow() {
	try {
		//var myTableDiv = document.getElementById('my_table');
		var table =  document.getElementById('my_table');
		var rowCount = table.rows.length;
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if(null != chkbox && true == chkbox.checked) {
					 if(rowCount <= 2) {
						alert("Cannot delete all the rows.");
						break;
					}
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
	} catch(e) {
		alert(e);
	}
}	

function add_Price_Tabe() {

	//alert('Calling the dynamic table ');
	var price = ["base_price", "disc", "part_share","dispay"];

	var feat_names=["Hourly","Daily","Weekly","Monthly","Quaterly","Yearly"];

	//alert("Starting dynamic table "+features);
	var table = document.createElement('TABLE');
	table.border='1';
	table.class="table-bordered";

	var tableHead = document.createElement('THEAD');
	var tr1 = document.createElement('TR');
	  
	var coltd1 = document.createElement('TH');
	coltd1.width='150';
	coltd1.appendChild(document.createTextNode("Category"));
	tr1.appendChild(coltd1);
	var coltd2 = document.createElement('TH');
	coltd2.width='75';
	coltd2.appendChild(document.createTextNode("Base Price"));
	tr1.appendChild(coltd2);
	var coltd3 = document.createElement('TH');
	coltd3.width='75';
	coltd3.appendChild(document.createTextNode("Margin"));
	tr1.appendChild(coltd3);
	var coltd4 = document.createElement('TH');
	coltd4.width='75';
	coltd4.appendChild(document.createTextNode("Partner Share"));
	tr1.appendChild(coltd4);
	var coltd5 = document.createElement('TH');
	coltd5.width='75';
	coltd5.appendChild(document.createTextNode("Search Display"));
	tr1.appendChild(coltd5);
	var coltd6 = document.createElement('TH');
	coltd6.width='75';
	coltd6.appendChild(document.createTextNode("Comment"));
	tr1.appendChild(coltd6);
	tableHead.appendChild(tr1);
	table.appendChild(tableHead);
   
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
     
    for (var i=0; i<feat_names.length; i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
        
        var td = document.createElement('TD');
        td.width='75';
	    td.appendChild(document.createTextNode(feat_names[i]));
	    tr.appendChild(td);
		addInput(tr,feat_names[i]+"_b_price","0");
		addInput(tr,feat_names[i]+"_disc","0");
		addInput(tr,feat_names[i]+"_partner","0");
		addInput(tr,feat_names[i]+"_display","No");
		addInput(tr,feat_names[i]+"_comment");
    }
	//newDiv.appendChild(table);  
}

function floorEventChange(indx) {

	//alert("....");
	var $branchName=$("select#branch").val();
	var Floor = document.getElementById('floor'+indx).value;
	//alert(" array element "+Floor +" "+$branchName);

	$.get('branch_facility_res.jsp',{type:'floor_layout',floor_id:Floor,branch_id:$branchName},function(responseJson) {
	var $select = $('#layout_name'+indx); 
	$select.find('option').remove();
	$('<option>').val("ALL").text("Select Layout").appendTo($select);
		$.each(responseJson, function(key, value) { 
		$('<option>').val(key).text(value).appendTo($select);  
		});
	});			    
}



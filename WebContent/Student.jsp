<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/jquery-ui-1.12.1/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="assets/jquery.jqGrid-4.4.3/css/ui.jqgrid.css" />

<script type="text/javascript" src="assets/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
<script type="text/javascript" src="assets/jquery/jquery-migrate-1.2.1.js"></script>
<script type="text/javascript" src="assets/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="assets/jquery.jqGrid-4.4.3/js/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="assets/jquery.jqGrid-4.4.3/js/i18n/grid.locale-en.js"></script>
<script type="text/javascript" src="assets/jquery.jqGrid-4.4.3/js/jquery.jqGrid.src.js"></script>

<script src="//cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script src="//cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
<script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js"></script>



<title>Student</title>

</head>
<body>
	<table id="student"></table>
	<div id="StudentPager"></div>
<!-- 	<button id="export">Export to Excel</button> -->
	<script type="text/javascript">
		jQuery(document)
				.ready(
						function() {
							jQuery("#student")
									.jqGrid(
											{
												mtype : "GET", //GET
												datatype : "JSON",
												height : "auto",
												url : "JqgridStudent",
												// 								editurl : 'JqgridStudent',
												colNames : [ 'ID', 'FirstName',
														'LastName', 'Email',
														'Mobile', 'State' ],
												colModel : [ {

													label : "id",
													name : 'id',
													index : 'id',
													align : "center",
													width : 150,
													editable : false,
													width : 50,
													editoptions : {
														size : 10
													}
												}, {
													label : "firstname",
													name : 'firstname',
													index : 'firstname',
													align : "center",
													width : 150,
													editable : true,
													edittype : 'text'
												}, {
													label : "lastname",
													name : 'lastname',
													index : 'lastname',
													align : "center",
													width : 150,
													editable : true,
													edittype : 'text'

												}, {
													label : "email",
													name : 'email',
													index : 'email',
													align : "center",
													width : 150,
													editable : true,
													edittype : 'text'

												}, {
													label : "mobile",
													name : 'mobile',
													index : 'mobile',
													align : "center",
													width : 150,
													editable : true,
													edittype : 'text',
												}, {
													label : "state",
													name : 'state',
													index : 'state',
													align : "center",
													width : 150,
													editable : true,
													edittype : 'text',
												} ],

												height : '100%',
												viewrecords : true,
												caption : 'Students Report',
												emptyrecords : 'No records',
												rowNum : 50,
												iconSet : "fontAwesome",
												gridview : true,
												subGrid : true,
												pager : '#StudentPager',
												rowList : [ 10, 20, 30 ],
												jsonReader : {
													root : "rows",
													page : "page",
													total : "total",
													records : "records",
													repeatitems : false,
													
													

												},
												
												
												onSelectRow: function() {
											        var sheet = document.createElement('style');
											        sheet.innerHTML = ".ui-jqgrid .ui-state-highlight { background-color: rgba(0, 255, 0, 0.3); }";
											        document.body.appendChild(sheet);
											    },


												 subGridRowExpanded: function(subgrid_id, row_id) {
										        	  var subgrid_table_id, pager_id;
										      		subgrid_table_id = subgrid_id+"_t";
										      		pager_id = "p_"+subgrid_table_id;
										      		$("#"+subgrid_id).html("<table id='"+subgrid_table_id+"'></table><div id='"+pager_id+"'></div>");
										      		jQuery("#"+subgrid_table_id).jqGrid({
										      			url:'JqgridStudent?id='+row_id,
										      			datatype: "JSON",
// 										      			colNames: ['id' || 'state'],
										      			colModel: [{name:"id",index:"id",width:80,key:true},
										      				{name:"firstname",index:"firstname",width:80,key:true},
										      				{name:"lastname",index:"lastname",width:80,key:true},
										      				{name:"email",index:"email",width:80,key:true},
										      				{name:"mobile",index:"mobile",width:80,key:true},
										      			{name:"state",index:"state",width:80,key:true}
										      				
										      				],

															
										      		   	rowNum:10,
										      		   	pager: pager_id,
										      		   	sortname: 'num',
										      		    sortorder: "asc",
										      		   height: '100%',
										      		   
										      		
										              jsonReader: {
															root: 'rows',
															repeatitems: false
												},
												onSelectRow: function() {
											        var sheet = document.createElement('style');
											        sheet.innerHTML = ".ui-jqgrid .ui-state-highlight { background-color: rgba(0, 255, 0, 0.3); }";
											        document.body.appendChild(sheet);
											    },
										            
										            
										      });
										      		
										      		jQuery("#student"+subgrid_table_id).jqGrid('navGrid',"#student"+pager_id,{edit:true,add:true,del:true,view:true,search:true,refresh:true,paging:true})
										      	},

														 jsonReader : {
														root : "rows",
														page : "page",
														total : "total",
														records : "records",
														repeatitems : false,
														
													}, 
												      	autowidth:true
												
										});
							
							$(document).ready(function() {
							    $('#student').DataTable( {
							        dom: 'Bfrtip',
							        buttons: [
							            'copy', 'csv', 'excel', 'pdf', 'print'
							        ]
							    } );
							} );

							

							$('#student')
									.navGrid(
											'#StudentPager',
											{
												edit : true,
												add : true,
												del : true,
												view : true,
												search : true,
												refresh : true,
												position : "left",
												cloneToTop : true
											},

											// *****************Edit****************************				
											{
												editCaption : "The Edit Dialog",
												recreateForm : true,
												closeAfterEdit : true,
												onclickSubmit : function(
														response, postdata) {

													edit();
												}
											},

											// *****************Add******************************		

											{
												closeAfterAdd : false,
												recreateForm : true,
												onclickSubmit : function(
														response, postdata) {

													add();

												},
												errorTextFormat : function(data) {
													return 'Error: '
															+ data.responseText
												}
											},
											// *****************Delete****************************				
											{
												onclickSubmit : function(
														response, postdata) {

													del();
												},

												errorTextFormat : function(data) {

													return 'Error: '
															+ data.responseText
												},

												onSelectRow : function() {
													var sheet = document
															.createElement('style');
													sheet.innerHTML = ".ui-jqgrid .ui-state-highlight { background:blue;border-color: rgb(000, 0, 153); }";
													document.body
															.appendChild(sheet);
												}
											})

							// ************************ Export to excel *****************************
							

// 							jQuery("#student")
// 									.jqGrid(
// 											'navButtonAdd',
// 											'#StudentPager',
// 											{
// 												caption : "", 					// Export to excel

// 												onClickButton : function() {
// 													var filename = "StudentDetails.xlsx", data = $(
// 															this).jqGrid(
// 															'getGridParam',
// 															'lastSelectedData'), i, item, dataAsArray = [ [
// 															"id", "firstname",
// 															"lastname",
// 															"email", "mobile",
// 															"state" ] ];

// 													for (i = 0; i < data.length; i++) {
// 														item = data[i];

// 														dataAsArray.push([
// 																item.id,
// 																item.firstname,
// 																item.lastname,
// 																item.email,
// 																item.mobile,
// 																item.state ]);
// 													}

// 													var ws_name = "SheetJS";
// 													var wb = XLSX.utils
// 															.book_new(), ws = XLSX.utils
// 															.aoa_to_sheet(dataAsArray);
// 													XLSX.utils
// 															.book_append_sheet(
// 																	wb, ws,
// 																	ws_name);
// 													XLSX
// 															.writeFile(wb,
// 																	filename);
// 												}

// 											});
							
											
							
				// *************************Export to Excel *************************
							
									jQuery("#student")
									.jqGrid('navGrid', "#StudentPager")
									.jqGrid(
											'navButtonAdd',
											"#StudentPager",
											{
												caption : "",
												onClickButton : function update() {
													exportGridToExcellForSearchOrder("student");
												},
												position : "last",
												title : "Quotation",
												cursor : "pointer"
											});

							jQuery("#student").jqGrid('navGrid',
									'#StudentPager', {
										edit : false,
										add : false,
										del : false,
										search : true
									}, {}, {}, {}, {
										sopt : [ 'cn', 'eq' ],
										closeOnEscape : true,
										searchOnEnter : true
									}, {});

							function exportGridToExcellForSearchOrder(tableName) {
								alert("Error");

								var colNames = jQuery("#" + tableName).jqGrid(
										"getGridParam", "colNames");

								var table = $("<table id='testTable'>").attr(
										"border", "1");
								$('#placeholder').append(table);
								var cols = colNames.length;
								table.append(row = $("<tr>"));
								for (var c = 1; c < cols; c++) {
									if (	colNames[c] == "firstname"
											|| colNames[c] == "lastname"
											|| colNames[c] == "email"
											|| colNames[c] == "mobile"
											|| colNames[c] == "state") {
									} else {
										row.append($("<th>").text(colNames[c]));
									}
								}
								var mya = new Array();
								mya = jQuery("#" + tableName).jqGrid(
										'getDataIDs'); 
								var data = jQuery("#" + tableName).jqGrid(
										'getRowData', mya[0]); 
								var colNames = new Array();
								var ii = 0;
								for ( var i in data) {
									if (i == "firstname" || i == "lastname"
											|| i == "email" || i == "mobile"
											|| i == "state") {
									} else {
										colNames[ii++] = i;
									}
								} 

								for (var i = 0; i < mya.length; i++) {
									table.append(row = $("<tr>"));
									data = jQuery("#" + tableName).jqGrid(
											'getRowData', mya[i]); 
									for (var j = 0; j < colNames.length; j++) {

										row
												.append($(
														"<td style='text-align:left;'>")
														.text(data[colNames[j]])); 

									}

								}
								tableToExcelHistory('testTable', 'Sheet',
										'test.xls');
							}

							var tableToExcelHistory = (function() {
								var uri = 'data:application/vnd.ms-excel;base64,', template = '<html xmlns:o="urn:schemas-microsoft-com:office:office"xmlns:x="urn:schemas-microsoft-com:office:excel"xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>', base64 = function(
										s) {
									return window
											.btoa(unescape(encodeURIComponent(s)))
								}, format = function(s, c) {
									return s.replace(/{(\w+)}/g,
											function(m, p) {
												return c[p];
											})
								}
								return function(table, name, filename) {
									if (!table.nodeType)
										table = document.getElementById(table)
									var ctx = {
										worksheet : name || 'Worksheet',
										table : table.innerHTML
									}
									window.location.href = uri
											+ base64(format(template, ctx))
								}
							})();

						})

		function add() {
			var id = $("#id").val();
			var firstname = $("#firstname").val();
			var lastname = $("#lastname").val();
			var email = $("#email").val();
			var mobile = $("#mobile").val();
			var state = $("#state").val();

			$.ajax({
				type : "POST",
				data : {
					id : id,
					firstname : firstname,
					lastname : lastname,
					email : email,
					mobile : mobile,
					state : state,
				},
				url : "AddStudent",
				success : function(gridmodel) {
					alert("Added");
				},
				error : function(gridmodel) {
					alert("FAIL");
				}

			});

		}

		function edit() {
			var rowId = $("#student").jqGrid('getGridParam', 'selrow');
			var rowData = jQuery("#student").getRowData(rowId);
			if (rowData != null) {
				var id = $("#id").val();
				var firstname = $("#firstname").val();
				var lastname = $("#lastname").val();
				var email = $("#email").val();
				var mobile = $("#mobile").val();
				var state = $("#state").val();
			}
			$.ajax({
				type : "POST",
				data : {
					'id' : rowId,
					firstname : firstname,
					lastname : lastname,
					email : email,
					mobile : mobile,
					state : state,
				},
				url : "EditServ",
				success : function(gridmodel) {
					alert("Updated");
					$("#student").trigger("reloadGrid");
				},
		
			});
		}

		function del() {
			var rowId = $("#student").jqGrid('getGridParam', 'selrow');
			var rowData = jQuery("#student").getRowData(rowId);
			if (rowData != null)
				var id = $("#id").val();
			$.ajax({
				type : "POST",
				data : {
					'id' : rowId,
				},
				url : "DeleteStudent",

				success : function(data) {

					alert("Deleted");
					$("#student").trigger("reloadGrid");
				},
				error : function(gridmodel) {
					alert("FAIL");
				}
			});

		}

		function searchmyque() {

			$("#searchbtn").dialog(
					{
						autoOpen : false,
						height : 200,
						width : 250,
						modal : true,
						title : "searchRecord",
						buttons : {
							"Cancel" : function() {
								$(this).dialog('close');
							},
							"search" : function() {
								var rowId = $("#student").jqGrid(
										'getGridParam', 'selrow');
								var rowData = jQuery("#student").getRowData(
										rowId);
								var firstname = rowData.firstname;
								$.ajax({
									type : "GET",
									url : "SearchServ",
									data : {
										firstname : firstname,
									},
									success : function() {
										alert("done");
									},
									error : function() {
										alert("FAIL");
									}
								});
							}
						}
					});

		}
	</script>
	<script type="text/javascript"> 
    
        $(document).ready(function () {
            $("#student").jqGrid({
                url: '',
                datatype: "json",
                colModel: [
					{ label: 'firstname', name: 'firstname', width: 75 },
					{ label: 'lastname', name: 'lastname', width: 90 },
					{ label: 'email', name: 'email', width: 100 },
					{ label: 'mobile', name: 'mobile', width: 100 },
					{ label: 'state', name: 'state', width: 100 },
                ],
				loadonce: true,
				viewrecords: true,
                footerrow: true,
                userDataOnFooter: true, 
                width: 780,
                height: 200,
                rowNum: 150
            });
			
			$("#export").on("click", function(){
				$("#student").jqGrid("exportToExcel",{
					includeLabels : true,
					includeGroupHeader : true,
					includeFooter: true,
					fileName : "jqGridExport.xlsx",
					maxlength : 40
				})
			})
        });
        
        
        

    </script>
	

</body>
</html>
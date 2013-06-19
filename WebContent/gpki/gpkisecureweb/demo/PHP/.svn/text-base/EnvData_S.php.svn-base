<?php
	// 응용어플단 로직   
	include 'gpkisecureweb.php';
	  
	$gpkiobj = &new GPKISecureWEB('D:/Java/Apache2/htdocs/conf');
	$ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
?>

<html>
<head>
<script language='javascript' src='.\gpkisecureweb\var.js'></script>
<script language='javascript' src='.\gpkisecureweb\GPKIFunc.js'></script>
<script language='javascript' src='.\gpkisecureweb\object.js'></script>
</head>
<body> 

<?
	
    $signType = "";
    $queryString = "";
            
    $message_type =  $gpkiobj->get_message_type();
    
	//Logger.debug.println(this, "message_type : "+message_type);

    if( $message_type == 1 || $message_type == 23 ||
        $message_type == 22 || $message_type == 20){
        $signType            = $gpkiobj->get_sign_type();
    } else {
        $signType = "없음";
    }
            
    $queryString = $gpkiobj->get_query_string();
            
    $id = "";
    $pass = "";
            
    $id = $gpkiobj->get_parameter("id");
    $pass = $gpkiobj->get_parameter("pass");
?>

<?
    $e = $gpkiobj->get_parameter_names();

    //while(e.hasMoreElements()){
    //    $paramKey = (String)e.nextElement();
    
    for($i=0; $i<count($e); $i++){
		$param_key=$e[$i];
?>
        <tr>
            <td>Key 값은 :<?= $gpkiobj->encrypt($param_key) ?> </td>
            <br>
			<td>Value 값은 :<?= $gpkiobj->encrypt($gpkiobj->get_parameter($param_key)) ?> </td>
			<p>
        </tr>        
<?        
    }
?>

QueryString : <?= $gpkiobj->encrypt($gpkiobj->get_query_string()) ?> 
<br>

    
</body>
</html>

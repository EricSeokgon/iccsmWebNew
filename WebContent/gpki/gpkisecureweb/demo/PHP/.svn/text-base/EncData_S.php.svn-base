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
    $queryString = "";
            
    $message_type =  $gpkiobj->get_message_type();

    $queryString = $gpkiobj->get_query_string();
?>
message_type : <?= $gpkiobj->encrypt($message_type) ?>
<br>
QueryString : <?= $gpkiobj->encrypt($queryString) ?> 
<br>

</body>
</html>

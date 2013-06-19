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
    $cert = null;
    $signType = "";
    $queryString = "";
    
    $cert = $gpkiobj->get_signer_cert();

    $subDN = $cert->getSubjectDN();
    $ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
    
    $message_type =  $gpkiobj->get_message_type();

    if( $message_type == 1 || $message_type == 23 ||
        $message_type == 22 || $message_type == 20){
        $signType =  $gpkiobj->get_sign_type();
    }           
    $queryString = $gpkiobj->get_query_string();
?>

사용자 인증서 정보 : <?= $gpkiobj->encrypt($subDN) ?>
<br>
message_type : <?= $gpkiobj->encrypt($message_type) ?>
<br>
signType : <?= $gpkiobj->encrypt($signType) ?>
<br>
QueryString : <?= $gpkiobj->encrypt($queryString) ?> 
<br>
    
</body>
</html>

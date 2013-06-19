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
     
    $signData = null;
    $parvatekey_random = null;
    $signType = "";
 
	$cert = $gpkiobj->get_signer_cert();
	
	$message_type =  $gpkiobj->get_message_type();

	if( $message_type == 1 || $message_type == 23 ||
        $message_type == 22 || $message_type == 20){	        
		$signData =           $gpkiobj->get_signed_data();            // signData
		$privatekey_random =  $gpkiobj->get_private_random();          // privatekey_random
		$signType =  $gpkiobj->get_sign_type();
	}
?>

<e>message_type 정보</e>
message_type은 : <?= $gpkiobj->encrypt($message_type) ?> 입니다.<p>


<e>인증서 정보</e><p>

<?
if( $cert != null) {
	// cert 객체내 함수 사용에 대한 Exception 처리
	$subjectDN=$cert->getSubjectDN();
	$ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
?>
	로그인한 인증서는 : <?= $gpkiobj->encrypt($subjectDN) ?> 입니다.<p>
<?	
}								
    $signContent=null;    // 원본메시지
    
    $signedData=new Java("com.gpki.gpkiapi.cms.SignedData");
	//$signedData->verify($signData);    // signedData를 가지고 sign 검증 실행
	$signedData->verify($gpkiobj->get_signed_data());    // signedData를 가지고 sign 검증 실행 (객체 변수에 다이렉트로 붙어야 함)
    
    $ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
	
    $signContent  = $signedData->getMessage();  // signedData에서 원본 메시지를 꺼낸다. 
	$signContentString=new Java("java.lang.String",$signContent);    
    
    $base64 = new Java("com.gpki.gpkiapi.util.Base64");    
    //$base64_encode=$base64->encode($signData);
//    $base64_encode=$base64->encode($signContent);
//    $ex = java_last_exception_get();
//	if ($ex) {
//	  echo '[GPKISecureWeb Error]'.$ex->toString();
//	  java_last_exception_clear();
//	  return;
//	}

    $ex = java_last_exception_get();
	if ($ex) {
	  echo '[GPKISecureWeb Error]'.$ex->toString();
	  java_last_exception_clear();
	  return;
	}
?>

서명값 :  <?= $gpkiobj->encrypt($signContentString->toString()) ?>  입니다.<p>


<?
	if(!is_null($privatekey_random)){

		echo 'privatekey_random 값의 길이는 :  '.$gpkiobj->encrypt(count($privatekey_random)).' 입니다.<p>';
	}
?>

<?
    $e = $gpkiobj->get_parameter_names();

    for($i=0; $i<count($e); $i++){
		$param_key=$e[$i];
?>
        <tr>
            <td>Key 값은 :<?= $gpkiobj->encrypt($param_key) ?> </td>
            <br>
			<td>Value 값은 :<?= $gpkiobj->encrypt($gpkiobj->get_parameter($param_key)) ?> </td>
			<br>
        </tr>        
<?        
    }
?>

QueryString <?= $gpkiobj->encrypt($gpkiobj->get_query_string()) ?> 입니다.<p>
<br>

    
</body>
</html>
</ENCRYPT_DATA>
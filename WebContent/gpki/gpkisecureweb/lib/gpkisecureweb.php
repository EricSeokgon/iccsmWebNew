<?
	session_cache_limiter('private'); 
	session_start();		// 응용어플단에는 반드시 session_start() 를 넣지 않는다.
	class GPKIKeyInfo {
		var $client_write_key;
		var $client_write_iv;
		var $server_write_key;
		var $server_write_iv;	
		
		var $algo;
		var $challenge;
		
		function set_client_write_key($key){
			$this->client_write_key=$key;
		}
		
		function set_client_write_iv($iv){
			$this->client_write_iv=$iv;
		}
		
		function set_server_write_key($key){
			$this->server_write_key=$key;
		}
		
		function set_server_write_iv($iv){
			$this->server_write_iv=$iv;
		}
		
		function set_algorithm($al){
			$this->algo=$al;
		}
		
		function set_challenge($chg){
			$this->challenge=$chg;
		}
		
		function get_client_write_key(){
			return $this->client_write_key;
		}
		
		function get_client_write_iv(){
			return $this->client_write_iv;
		}
		
		function get_server_write_key(){
			return $this->server_write_key;
		}
		
		function get_server_write_iv(){
			return $this->server_write_iv;
		}
		
		function get_algorithm(){
			return $this->algo;
		}
		
		function get_challenge(){
			
			$challenge=$this->challenge;			
			return $challenge;
		}			
	}
	
	
?>

<?php

  $CLASSNAME_OBJECT_LIST = array();

  function gpkisecureweb_destructor() {
	global $CLASSNAME_OBJECT_LIST;

	if(count($CLASSNAME_OBJECT_LIST)) {
	
		reset($CLASSNAME_OBJECT_LIST);
		while(list(,$obj) = each($CLASSNAME_OBJECT_LIST)) {
			$obj->destory();
		}
		$CLASSNAME_OBJECT_LIST = null;
	}
  }
?>

<?php
  class GPKISecureWEB {
	 
	 var $gpkisw;

	 function GPKISecureWEB($conf_file_path){
		global  $CLASSNAME_OBJECT_LIST;
		
		$system = new Java('java.lang.System');
		$system->setProperty('config.file', $conf_file_path.'\dsjdf.properties');
		
		// session 가져오기
		$gpki_session=$_SESSION['GPKISession'];
  
		// 객체가 엘리먼트인 세션 테스트 용 소스
		//if($gpki_session==''){
		//  $gpki_session_data=new GPKIKeyInfo;
		//  $gpki_session_data->set_client_write_key('client_write_key_session');
		//  $gpki_session_data->set_client_write_iv('set_client_write_iv_session');
		//  $gpki_session_data->set_server_write_key('set_server_write_key_session');
		//  $gpki_session_data->set_server_write_iv('set_server_write_iv_session');
		//  $gpki_session_data->set_algorithm('set_algorithm_session');
		//  $gpki_session_data->set_challenge('set_challenge_session');
		//	  
		//  $_SESSION["GPKISession"]=$gpki_session_data;
		//}
		
		// Session 이 없는 경우
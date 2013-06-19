//------------------------------------------- [Init 에 필요한 정보] --------------------------------------------------------------------//
// 서버인증서(Base64Encode)
var ServerCert   		= "MIID5zCCAs+gAwIBAgIQQ+xPwANj1dY/+QCI3zecqDANBgkqhkiG9w0BAQUFADBQMQswCQYDVQQGEwJLUjEcMBoGA1UEChMTR292ZXJubWVudCBvZiBLb3JlYTENMAsGA1UECxMER1BLSTEUMBIGA1UEAxMLQ0ExMzEwMDAwMDEwHhcNMDYwMjEwMDgzMzA0WhcNMDgwNTEwMDgzMzA0WjBdMQswCQYDVQQGEwJLUjEcMBoGA1UECgwTR292ZXJubWVudCBvZiBLb3JlYTEYMBYGA1UECwwPR3JvdXAgb2YgU2VydmVyMRYwFAYDVQQDDA1TVlIxMzEwNDQ2MDAxMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDBaoJX2A9FsK0tw3zEDQQrIQxYisHWAPgKpOYxsK7fU0h1NuG5CCi5dZ2skFK61foO2mLlUjz08/GkfjC48MAFduZrIozZyzXODr+QlUjLAzquest111PgvM0mgMzy5XDPLxbzqIdJaBP368uWTD2t/wieQ/SzuxUb8Cud91n5sQIDAQABo4IBMjCCAS4wHwYDVR0jBBgwFoAUAc8XrgSNh8y3VQtxbGtInOaxspUwHQYDVR0OBBYEFCW61E8yEKYWR/yEpWlBhzfQgNi/MA4GA1UdDwEB/wQEAwIFIDAYBgNVHSAEETAPMA0GCSqDGoaNIQIBAjAAMIGJBgNVHR8EgYEwfzB9oHugeYZ3bGRhcDovL2xkYXAuZ2NjLmdvLmtyOjM4OS9jbj1jcmwwMDA1LGNuPUNBMTMxMDAwMDAxLG91PUdQS0ksbz1Hb3Zlcm5tZW50IG9mIEtvcmVhLGM9S1I/Y2VydGlmaWNhdGVSZXZvY2F0aW9ubGlzdDtiaW5hcnkwNgYIKwYBBQUHAQEEKjAoMCYGCCsGAQUFBzABhhpodHRwOi8vZ3ZhLmdwa2kuZ28ua3I6ODA4MDANBgkqhkiG9w0BAQUFAAOCAQEAKWs/slkLYpcUYzZHiY7Y8OLnHhyqt1Ph5WQqeJSdmCe0i1UgM8tqmrm5GFHyv4dziTtLPJx6GSgFrcqphKrh9/UicPHIiou0G/CyiL7b6cPUaRW6Fatlz23eZs2BnFKuO6umIL8EV7WxICmtO/nd7jk6byZnXTtXmA9IkZ3AHoTHX0uBg3ivZ3xK1VNABPFSferuU9L2zcOFJnYC1xv7nNPHTSwHnEWiWEu1aBvn2KdrS+diZszjc+go7RSpx/qWoiZnXVab97YqM+IG6LdjJirQPjTdc5Nf4w+IMzuDOWTwVCUs0hS5JaW81jYTRd46eE/zuYv95KvxqqjSKrxG5g==";

var AlgoMode 			= 0x30;				         			// 암복호 알고리즘 (
												// 0x20 : SYM_ALG_3DES_CBC, 
												// 0x30 : SYM_ALG_SEED_CBC, 
												// 0x40 : SYM_ALG_NEAT_CBC, 
												// 0x50 : SYM_ALG_ARIA_CBC,
			         								// 0x60 : SYM_ALG_NES_CBC)

var WorkDir		        = "C:\Program Files\GPKISecureWeb";						// 작업디렉토리(모듈 설치된 위치) 		

var GNCertType  		= 0x00;				         			// GPKI, NPKI 인증서 모두 : 0x00, GPKI 만 : 0x01, NPKI 만 :0x02	
var ValidCertInfo 		= "";

//var ValidCertInfo 		= "1 2 410 100001 2 2 1|1 2 410 100001 2 1 2|";			// 특정인증서만 로딩 할 경우에 정책코드를 나열한다.	
var ValidCertInfo 		= "";			// 특정인증서만 로딩 할 경우에 정책코드를 나열한다.	


var ReadCertType 		= 0x01; 				        		// 서명용인증서 : 0x01, 암호키분배용 인증서 : 0x02

var KeyStrokeType 		= 0x00;			 	         			// 키보드 보안 API (0x01 : softcamp, 0x00 : 적용안함)

var CertOption			= 0x01;							        // 0x00 : 로그인한 세션인증서로만 서명한다. (해당인증서만 로딩한다.) 

// SiteID
var SiteID 			= "99.1.5.83";			        		        // SiteID :세션정보를 획득하는 키값

// 서명시에 
// [setup.conf : 설치파일 위치정보]

// GPKIInstaller 사용시
		
var ServerAddr 			= "99.1.5.83:80"; 				
var ConfigFilePath 		= "/gpki/gpkisecureweb/gpkisecureweb/setup/setup.conf";

// [설치 파일 경로 변수(html내부에서 사용됨)]

var SetupOffLineFilePath        = "/gpki/gpkisecureweb/gpkisecureweb/setup/install_off_v1.0.2.8.exe";

// [설치완료후 이동할 페이지 설정]
var ServiceStartPageURL		= "/gpki/gpkisecureweb/demo/JSP/index.html";

var UbikeyVersion = "1.0.3.1";
var UbikeyPopupURL = "http://www.gpki.go.kr/wire/infovine/download.html";
var UbikeyWParam = "SITE_NAME|";
var UbikeylParam = "DREAMSECURITY|KEYBOARD_SECURITY_COMP_CODE";
//---------------------------------------------- [ActiveX 버전번호] --------------------------------------------------------------------//

// [ActiveX Object 테그 형태]																					

var CodeBase_GPKIInstaller	= " CODEBASE='http://99.1.5.83:80/gpki/gpkisecureweb/gpkisecureweb/setup/GPKIInstaller.cab#version=1,0,1,3'";

var Object_GPKIInstaller 	= "<OBJECT ID ='GPKIInstaller' CLASSID = 'CLSID:531BBB4D-B043-4D70-8A88-0A416C7F7CD0' width = 0 height =0";
Object_GPKIInstaller            += CodeBase_GPKIInstaller;
Object_GPKIInstaller            += "></OBJECT >";

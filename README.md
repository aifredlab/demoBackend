# ========== 소스 import 후 해야할 내용 ==============
1. Project>우측버튼>properties>Java Compiler>Annotation Processing 선택
  - Enable project specific settings 체크
  - Enable annotation processing 체크
  - Enable processing in editor 체크
2. Java Compiler>Annotation Processing>Factory Path 선택
3. Add External jars 버튼 클릭
4. C:\Users\remote_desktop\.gradle\caches\modules-2\files-2.1\org.mapstruct\mapstruct-processor\1.5.3.Final\xxxxxxxxxxx\mapstruct-processor-1.5.3.Final.jar 추가
5. Build Path>Order and Export 탭 선택
6. 에서 .apt_generated 2개항목을 jre system library 위로 올리기
5. rebuild

# ========== MySQL 기동 ==============
## Mac 
### brew services start mysql
### brew services restart mysql
### brew services stop mysql

## Windows
### 서비스에서 MYsql80 시작하기


# ========== build.gradle =============
프로젝트 추가나 build.gradle 파일 변경시 우측버튼 클릭하여 refresh gradle project수행 

# ========== Test Page =============
http://localhost:8080/

# ========== H2 DB관리자 페이지 접 =============
http://localhost:8080/h2


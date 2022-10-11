### 1. 멀티쓰레드 환경에서 레이스 컨디션이 발생하여 결과 값이 의도와 달라지는 코드를 작성해보기
#### 테스트파일
* test.java

#### 환경 구성
* ```static int a = 1```  static 변수 a에 두 thread가 동시에 접근하여 값을 더하는 코드
* a가 99까지 더하는 과정으로 최종적으로 99로 출력되면 정상적인 값

#### 테스트 결과
* 결과값\
![image](https://user-images.githubusercontent.com/41093183/195047873-e8e2c3ac-f8c3-4f53-a4d9-4adfaa1cd27a.png)
* a가 99를 넘어선 101의 결과를 출력
* 여러 번 실행 시 100,101 값을 출력함

### 2. 멀티쓰레드 환경에서 교착상태를 강제로 만들어 확인할 수 있는 코드 작성해보기
#### 테스트파일
* test2.java
* Calc.java
* Save.java

#### 환경 구성

* 상호배제를 위한 synchronized설정
  - ```synchronized int plus(int num)``` Calc클래스의 plus메서드 synchronized설정
  - ```synchronized void valueSave(int num)``` Save클래스의 valueSave메서드 synchronized설정


* Thread-0은 Calc.plus() 호출

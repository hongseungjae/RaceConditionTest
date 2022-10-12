### 1. 멀티쓰레드 환경에서 레이스 컨디션이 발생하여 결과 값이 의도와 달라지는 코드를 작성해보기
----
#### 테스트파일
* test.java (public class)

#### 환경 구성
* ```static int a = 1```  static 변수 a에 두 thread가 동시에 접근하여 값을 더하는 코드
* a가 99까지 더하는 과정으로 최종적으로 99로 출력되면 정상적인 값


#### 테스트 결과
* 결과값\
![image](https://user-images.githubusercontent.com/41093183/195047873-e8e2c3ac-f8c3-4f53-a4d9-4adfaa1cd27a.png)
* a가 99를 넘어선 101의 결과를 출력
* 여러 번 실행 시 100,101 값을 출력함

<br/>
<br/>

### 2. 멀티쓰레드 환경에서 교착상태를 강제로 만들어 확인할 수 있는 코드 작성해보기
----
#### 테스트파일
* test2.java (public class)
* Calc.java
* Save.java

#### 환경 구성
* 상호배제를 위한 synchronized설정
  - Calc클래스의 plus메서드 synchronized설정 ```synchronized int plus(int num)```
  - Save클래스의 valueSave메서드 synchronized설정```synchronized void valueSave(int num)``` 

* 호출 과정\
  ![image](https://user-images.githubusercontent.com/41093183/195278115-1b25617e-95f0-452a-a6cc-ccd349d2a4cf.png)


<br/>


#### 테스트 결과
  * 출력 값\
  ![image](https://user-images.githubusercontent.com/41093183/195061605-2e7880c3-4de9-4396-8629-39795e2f76a7.png)
  * 거의 동시에 Thread-0이 plus 객체 점유하고 Thread-1이 save 객체를 점유함
  * Thread-0이 save 메서드 호출, Thread-1이 plus 메서드 호출
  * **교착상태**가 발생하여 Thread-0과 Thread-1이 BLOCKED 상태가 됨

  - 해당 프로세스 안에 쓰레드 상태를 확인하기 위해 Thread Dump 파일 생성
![image](https://user-images.githubusercontent.com/41093183/195062381-faec050a-fd99-47ff-b3e4-c56bb70a1dd7.png)
  - 교착상태에서의 쓰레드 상태

![image](https://user-images.githubusercontent.com/41093183/195130850-458176d7-a3ae-4949-b213-843f4e56efa4.png)



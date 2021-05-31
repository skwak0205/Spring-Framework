# Spring Framework

### Framework이란

- 프로그램의 골격이 되는 기본 코드
- 공통적인 부분은 개발이 되어 있고, 필요한 부분은 개발자가 개발하면 됨

### Spring이란

- EJB (Enterprise JavaBean) 기반 개발에서 POJO (Plain Old Java Object) 기반 개발로 변경
- EJB와 같이 복잡한 순서를 거치지 않아도 간단하게 이용할 수 있기 때문에 **'경량 컨테이너'** 라고도 불렸음

### 중점 기술

1. DI / IoC

   - DI : Dependency Injection
     - 의존 주입
     - **객체간의 결합을 느슨하게 하는 스프링의 핵심 기술**
     - 객체 자체가 아니라 Framework에 의해 객체의 의존성이 주입되는 설계 패턴
     - 객체를 직접 생성하는 것이 아닌 외부에서 객체를 주입시켜 사용하는 방식
     - 객체 생성할 때 값을 넣어줄 수 있음
     - 의존관계를 관리하는 방법
       1. Construction Injection
          - `<constructor-arg />` 사용하여 생성자에 값을 넣어줌
       2. Setter Injection
          - `<property />` 사용하여 setter 호출하고 값을 주입함
       3. Method Injection (Field 주입)
          - Annotation을 사용하여 값을 주입
   - IoC : Inversion of Control
     - 제어 역전
     - 객체를 생성하는 곳 (Spring Container)과 사용하는 곳이 분리됨

2. OCP

   - Open Closed Principle

   - 개방 폐쇄 정책
   - 개발자가 상속 받아 확장할 수 있는 부분들은 개방하고, 건들면 안되는 부분은 폐쇄 시킴

3. AOP

   - Aspect Oriented Programming

   - 관점지향 프로그래밍

   - 횡단 관점의 분리 (Separation of Cross Cutting Concern)

   - 문제를 해결하기 위한 핵심관심사항과 전체에 적용되는 공통관심사항을 기준으로 프로그래밍함으로써 공통모듈을 여러 코드에 쉽게 적용할 수 있도록 지원하는 기술

   - 용어

     1. CC (Core Concern) : 주(핵심) 관심사항 / Target이라고도 칭함

     2. CCC (Cross Cutting Concern) : 공통 관심사항

     3. Join Point

        - 인스턴스의 생성시점 / 메소드를 호출하는 시점

        - advice/ccc가 연결될 수 있는 (target/cc가 호출되는) 모든 시점

     4. Pointcut

        - Advice가 어떤 join point에 연결되어야 하는 지 결정

        - advice/ccc가 연결되는 시점

     5. Advice
        - ccc (실제 구현 code)

     6. Advisor / Aspect
        - Advice + Pointcut

     7. Weaving
        - 일련의 과정

### Spring Annotation

- 스프링은 어노테이션을 이용하여 빈과 관련된 정보를 설정
- 설정
  1. CommonAnnotationBeanPostProcessor 클래스를 설정 파일에 bean 객체로 등록하여 annotation 적용
  2. CommonAnnotationBeanPostProcessor 클래스를 설정 파일에 bean 객체로 등록하여 annotation 적용
  3. <context:component-scan base-package="" /> 태그를 이용
  4. <mvc:annotation-driven /> 태그를 이용

### Spring MVC

- 스프링이 제공하는 트랜잭션 처리가 DI 및 AOP 적용 등을 쉽게 사용할 수 있도록 도움
- 컨트롤러, command 객체, 모델 객체, Validator 등의 각각의 역할에 대한 명확한 분리
- 주요 구성 요소
  1. DispatcherServlet
     - 클라이언트의 요청을 전달 받음
     - 컨트롤러에게 클라이언트의 요청을 전달하고 컨트롤러가 리턴한 결과값을 View에 전달하여 알맞은 응답을 생성
  2. HandlerMapping
     - 클라이언트의 요청 URL을 어떤 컨트롤러가 처리할지 결정
     - RequestURL과 Controller 클래스의 맵핑을 관리
  3. Controller
     - 클라이언트의 요청을 처리한 뒤, 그 결과를 DispatcherServlet에 알려줌
     - 비즈니스 로직을 호출하여 처리 결과 ModelAndView 인스턴스를 반환
     - annotation 사용 예제
  4. ModelAndView
     - 컨트롤러가 처리한 결과 정보 및 뷰 선택에 필요한 정보를 담음
  5. ViewResolver
     - 컨트롤러의 처리결과를 생성할 뷰를 결정

